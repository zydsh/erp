package hrsystem.hr;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus;
import hrsystem.hr.main.BonusSet;
import hrsystem.hr.main.BonusSpecification;
import hrsystem.hr.main.BonusSpecificationSet;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.JobSet;
import hrsystem.hr.main.LeaveSpecification;
import hrsystem.hr.main.LeaveSpecificationSet;
import hrsystem.hr.main.impl.BonusImpl;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.LeaveSpecificationImpl;
import hrsystem.hr.messagecenter.ApproveLeave;
import hrsystem.hr.messagecenter.ApproveLeaveSet;

import interfaces.IData;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.IntegerUtil;
import io.ciera.runtime.summit.types.StringUtil;

import java.util.Iterator;


public class HrUI extends Port<Hr> implements IData {

    public HrUI( Hr context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void ReadEmployeeList() throws XtumlException {
        EmployeeSet employeeSet = context().Employee_instances();
        int size = 0;
        Employee emp;
        for ( Iterator<Employee> _emp_iter = employeeSet.elements().iterator(); _emp_iter.hasNext(); ) {
            emp = _emp_iter.next();
            size = size + 1;
        }
        context().LOG().LogInfo( "Sending employee set .." );
        for ( Iterator<Employee> _emp_iter = employeeSet.elements().iterator(); _emp_iter.hasNext(); ) {
            emp = _emp_iter.next();
            context().UI().SendEmployee( emp.getEmployeeID(), emp.getNationalID(), emp.getFirstName(), emp.getMiddleName(), emp.getLastName(), emp.getDateOfBirth(), emp.getDegree(), emp.getGender(), emp.getStart_Date(), emp.getLeaveBalance(), emp.getSickLeaveBalance(), size );
            size = size - 1;
            context().LOG().LogInfo( ( ( ( ( "Sent:" + emp.getFirstName() ) + " " ) + emp.getMiddleName() ) + " " ) + emp.getLastName() );
        }
        context().LOG().LogInfo( "Sending employee set is complete" );
    }

    public void Initialize() throws XtumlException {
        context().Authenticate().Initialize();
        context().Initialize();
    }

    public void CreateEmployee( final int p_EmployeeID,  final int p_NationalID,  final String p_FirstName,  final String p_MiddleName,  final String p_LastName,  final int p_DateOfBirth,  final String p_Degree,  final String p_Gender ) throws XtumlException {
        Employee employee = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getNationalID() == p_NationalID);
        if ( employee.isEmpty() ) {
            Employee emp = EmployeeImpl.create( context() );
            emp.setEmployeeID(p_EmployeeID);
            emp.setNationalID(p_NationalID);
            emp.setFirstName(p_FirstName);
            emp.setMiddleName(p_LastName);
            emp.setLastName(p_LastName);
            emp.setDateOfBirth(p_DateOfBirth);
            emp.setDegree(p_Degree);
            emp.setGender(p_Gender);
            context().Authenticate().CreateNewAccount( emp.getFirstName(), emp.getLastName(), emp.getEmployeeID() );
            context().LOG().LogInfo( "Employee added successfully." );
            context().UI().Reply( "Employee added successfully.", true );
        }
        else {
            context().LOG().LogInfo( "Adding employee is unsuccessful. National ID is registered for another employee." );
            context().UI().Reply( "Adding employee is unsuccessful. Employee already exists", false );
        }
    }

    public void AssignEmployeeBonus( final int p_EmployeeID,  final String p_BonusName,  final int p_Starting,  final int p_Ending ) throws XtumlException {
        Employee employee = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == p_EmployeeID);
        BonusSpecification bonusSpec = context().BonusSpecification_instances().anyWhere(selected -> StringUtil.equality(((BonusSpecification)selected).getName(), p_BonusName));
        if ( !employee.isEmpty() && !bonusSpec.isEmpty() ) {
            Bonus empBonus = BonusImpl.create( context() );
            context().relate_R16_Bonus_is_specified_by_BonusSpecification( empBonus, bonusSpec );
            context().relate_R4_Bonus_is_given_to_an_Employee( empBonus, employee );
            empBonus.setStarting(p_Starting);
            empBonus.setEnding(p_Ending);
            context().LOG().LogInfo( "Assign Employee Bonus: Assigning bonus to employee " );
            context().UI().Reply( ( "Employee is assigned a bonus" + bonusSpec.getName() ) + " successfully ", true );
        }
        else {
            context().LOG().LogInfo( "Assign Employee Bonus: Failed to find bonus or employee " );
            context().UI().Reply( "Failed to find bonus or employee ", false );
        }
    }

    public void ReadEmployeeBonuses( final int p_EmployeeID ) throws XtumlException {
        Employee employee = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == p_EmployeeID);
        BonusSet bonuses = employee.R4_gets_a_Bonus();
        if ( !employee.isEmpty() && !bonuses.isEmpty() ) {
            context().UI().Reply( "Sending bonus set .. ", true );
            Bonus bonus;
            for ( Iterator<Bonus> _bonus_iter = bonuses.elements().iterator(); _bonus_iter.hasNext(); ) {
                bonus = _bonus_iter.next();
                BonusSpecification bonusSpec = bonus.R16_is_specified_by_BonusSpecification();
                context().UI().SendEmployeeBonuses( bonusSpec.getName(), bonus.getStarting(), bonus.getEnding(), bonusSpec.getPercent(), bonus.getAmount() );
                context().UI().Reply( "Sent: " + bonusSpec.getName(), true );
            }
        }
        else if ( bonuses.isEmpty() ) {
            context().UI().Reply( "Employee has no bonuses ", false );
        }
        else {
            context().UI().Reply( "Could not find Employee ", false );
        }
    }

    public void ReadJobList() throws XtumlException {
        JobSet jobs = context().Job_instances();
        if ( !jobs.isEmpty() ) {
            context().LOG().LogInfo( "Sending jobs list .." );
            Job job;
            for ( Iterator<Job> _job_iter = jobs.elements().iterator(); _job_iter.hasNext(); ) {
                job = _job_iter.next();
                Employee employee = job.R6_is_assigned_to_Employee();
                if ( !employee.isEmpty() ) {
                    context().UI().SendJobList( job.getJob_ID(), job.getTitle(), job.getSalary(), ( employee.getFirstName() + " " ) + employee.getLastName(), employee.getEmployeeID() );
                    context().LOG().LogInfo( ( ( ( ( "Sent: Job " + job.getTitle() ) + ", Assign to:  " ) + employee.getFirstName() ) + " " ) + employee.getLastName() );
                    context().LOG().LogReal( " Salary ", job.getSalary() );
                }
                else {
                    context().UI().SendJobList( job.getJob_ID(), job.getTitle(), job.getSalary(), "", 0 );
                    context().LOG().LogInfo( "Sent: Job " + job.getTitle() );
                    context().LOG().LogReal( " Salary ", job.getSalary() );
                }
            }
            context().LOG().LogInfo( "Sending jobs list is complete" );
        }
        else {
            context().LOG().LogInfo( "There are not jobs registered in the system" );
            context().UI().Reply( "There are no jobs registered in the system", false );
        }
    }

    public void StopEmployeeBonus( final int p_EmployeeID,  final String p_BonusName ) throws XtumlException {
        Employee employee = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == p_EmployeeID);
        BonusSet bonuses = employee.R4_gets_a_Bonus();
        Bonus bonus;
        for ( Iterator<Bonus> _bonus_iter = bonuses.elements().iterator(); _bonus_iter.hasNext(); ) {
            bonus = _bonus_iter.next();
            BonusSpecification b = ((BonusSpecification)bonus.R16_is_specified_by_BonusSpecification().oneWhere(selected -> StringUtil.equality(((BonusSpecification)selected).getName(), p_BonusName)));
            if ( !b.isEmpty() ) {
                context().generate(new BonusImpl.deactivateBonus(getRunContext(), context().getId()).to(bonus));
                context().LOG().LogInfo( "UI:StopEmployeeBonus: bonus is now stopped" );
            }
        }
    }

    public void DeleteLeaveSpecification( final String p_Name ) throws XtumlException {
        LeaveSpecification leaveSpec = context().LeaveSpecification_instances().anyWhere(selected -> StringUtil.equality(((LeaveSpecification)selected).getName(), p_Name));
        if ( !leaveSpec.isEmpty() ) {
            leaveSpec.delete();
            context().UI().Reply( "Leave deleted successfully.", true );
        }
        else {
            context().UI().Reply( "Leave does not exist.", false );
        }
    }

    public void ReadBonusList() throws XtumlException {
        BonusSpecificationSet bonuses = context().BonusSpecification_instances();
        if ( !bonuses.isEmpty() ) {
            context().LOG().LogInfo( "Sending bonus list .." );
            BonusSpecification bonus;
            for ( Iterator<BonusSpecification> _bonus_iter = bonuses.elements().iterator(); _bonus_iter.hasNext(); ) {
                bonus = _bonus_iter.next();
                context().UI().SendBonusList( bonus.getName(), bonus.getPercent() );
                context().LOG().LogReal( ( "Sent: Bonus " + bonus.getName() ) + ", percent amount:", bonus.getPercent() );
            }
            context().LOG().LogInfo( "Sending bonus list is complete" );
        }
        else {
            context().LOG().LogInfo( "There are not bonuses registered in the system" );
            context().UI().Reply( "There are no bonuses registered in the system", false );
        }
    }

    public void ReadEmployeeMessage( final int p_EmployeeID ) throws XtumlException {
        Employee employee = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == p_EmployeeID);
        ApproveLeaveSet msgSet = employee.R102_is_notified_by_ApproveLeave();
        context().LOG().LogInfo( "Sending employee message set .." );
        ApproveLeave msg;
        for ( Iterator<ApproveLeave> _msg_iter = msgSet.elements().iterator(); _msg_iter.hasNext(); ) {
            msg = _msg_iter.next();
            context().UI().SendEmployeeMessages( msg.getLeaveRequesterID(), msg.getStarting(), msg.getEnding(), msg.getContent() );
            context().LOG().LogInfo( "Send Employee Messages Sent: " + msg.getContent() );
        }
        context().LOG().LogInfo( "Sending employee messages is complete" );
    }

    public void ReadLeaveSpecification() throws XtumlException {
        LeaveSpecificationSet leaveSet = context().LeaveSpecification_instances();
        int size = 0;
        LeaveSpecification leave;
        for ( Iterator<LeaveSpecification> _leave_iter = leaveSet.elements().iterator(); _leave_iter.hasNext(); ) {
            leave = _leave_iter.next();
            size = size + 1;
        }
        context().UI().Reply( "Sending leave set .. ", true );
        for ( Iterator<LeaveSpecification> _leave_iter = leaveSet.elements().iterator(); _leave_iter.hasNext(); ) {
            leave = _leave_iter.next();
            context().UI().SendLeaveSpecification( leave.getName(), leave.getMaximumDays(), leave.getMinimumDays(), size );
            size = size - 1;
            context().UI().Reply( "Sent: " + leave.getName(), true );
        }
    }

    public void CreateLeaveSpecification( final String p_Name,  final int p_MaximumDays,  final int p_MinimumDays ) throws XtumlException {
        LeaveSpecification leaveSpec = context().LeaveSpecification_instances().anyWhere(selected -> StringUtil.equality(((LeaveSpecification)selected).getName(), p_Name));
        if ( leaveSpec.isEmpty() ) {
            LeaveSpecification leaveSpecification = LeaveSpecificationImpl.create( context() );
            leaveSpecification.setName(p_Name);
            leaveSpecification.setMaximumDays(p_MaximumDays);
            leaveSpecification.setMinimumDays(p_MinimumDays);
            context().UI().Reply( "Leave added successfully.", true );
        }
        else {
            leaveSpec.setName(p_Name);
            leaveSpec.setMaximumDays(p_MaximumDays);
            leaveSpec.setMinimumDays(p_MinimumDays);
            context().UI().Reply( "Leave updated successfully.", true );
        }
    }



    // outbound messages
    public void SendEmployeeBonuses( final String p_BonusName,  final int p_Starting,  final int p_Ending,  final double p_Percent,  final double p_Amount ) throws XtumlException {
        if ( satisfied() ) send(new IData.SendEmployeeBonuses(p_BonusName, p_Starting, p_Ending, p_Percent, p_Amount));
        else {
        }
    }
    public void SendJobList( final int p_JobID,  final String p_Title,  final double p_Salary,  final String p_EmployeeName,  final int p_EmployeeID ) throws XtumlException {
        if ( satisfied() ) send(new IData.SendJobList(p_JobID, p_Title, p_Salary, p_EmployeeName, p_EmployeeID));
        else {
        }
    }
    public void ReplyNewEmployee( final String p_Username,  final String p_Password ) throws XtumlException {
        if ( satisfied() ) send(new IData.ReplyNewEmployee(p_Username, p_Password));
        else {
        }
    }
    public void SendBonusList( final String p_Name,  final double p_Percent ) throws XtumlException {
        if ( satisfied() ) send(new IData.SendBonusList(p_Name, p_Percent));
        else {
        }
    }
    public void SendEmployeeMessages( final int p_LeaveRequesterID,  final int p_Starting,  final int p_Ending,  final String p_Content ) throws XtumlException {
        if ( satisfied() ) send(new IData.SendEmployeeMessages(p_LeaveRequesterID, p_Starting, p_Ending, p_Content));
        else {
        }
    }
    public void SendLeaveSpecification( final String p_Name,  final int p_MaximumDays,  final int p_MinimumDays,  final int p_Size ) throws XtumlException {
        if ( satisfied() ) send(new IData.SendLeaveSpecification(p_Name, p_MaximumDays, p_MinimumDays, p_Size));
        else {
        }
    }
    public void SendEmployee( final int p_EmployeeID,  final int p_NationalID,  final String p_FirstName,  final String p_MiddleName,  final String p_LastName,  final int p_DateOfBirth,  final String p_Degree,  final String p_Gender,  final int p_StartDate,  final int p_LeaveBalance,  final int p_SickLeaveBalance,  final int p_Size ) throws XtumlException {
        if ( satisfied() ) send(new IData.SendEmployee(p_EmployeeID, p_NationalID, p_FirstName, p_MiddleName, p_LastName, p_DateOfBirth, p_Degree, p_Gender, p_StartDate, p_LeaveBalance, p_SickLeaveBalance, p_Size));
        else {
        }
    }
    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
        if ( satisfied() ) send(new IData.Reply(p_msg, p_state));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IData.SIGNAL_NO_READEMPLOYEELIST:
                ReadEmployeeList();
                break;
            case IData.SIGNAL_NO_INITIALIZE:
                Initialize();
                break;
            case IData.SIGNAL_NO_CREATEEMPLOYEE:
                CreateEmployee(IntegerUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)), IntegerUtil.deserialize(message.get(5)), StringUtil.deserialize(message.get(6)), StringUtil.deserialize(message.get(7)));
                break;
            case IData.SIGNAL_NO_ASSIGNEMPLOYEEBONUS:
                AssignEmployeeBonus(IntegerUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)), IntegerUtil.deserialize(message.get(3)));
                break;
            case IData.SIGNAL_NO_READEMPLOYEEBONUSES:
                ReadEmployeeBonuses(IntegerUtil.deserialize(message.get(0)));
                break;
            case IData.SIGNAL_NO_READJOBLIST:
                ReadJobList();
                break;
            case IData.SIGNAL_NO_STOPEMPLOYEEBONUS:
                StopEmployeeBonus(IntegerUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)));
                break;
            case IData.SIGNAL_NO_DELETELEAVESPECIFICATION:
                DeleteLeaveSpecification(StringUtil.deserialize(message.get(0)));
                break;
            case IData.SIGNAL_NO_READBONUSLIST:
                ReadBonusList();
                break;
            case IData.SIGNAL_NO_READEMPLOYEEMESSAGE:
                ReadEmployeeMessage(IntegerUtil.deserialize(message.get(0)));
                break;
            case IData.SIGNAL_NO_READLEAVESPECIFICATION:
                ReadLeaveSpecification();
                break;
            case IData.SIGNAL_NO_CREATELEAVESPECIFICATION:
                CreateLeaveSpecification(StringUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)));
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "UI";
    }

}
