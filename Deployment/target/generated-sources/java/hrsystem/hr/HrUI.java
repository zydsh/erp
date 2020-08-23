package hrsystem.hr;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.LeaveSpecification;
import hrsystem.hr.main.LeaveSpecificationSet;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.LeaveSpecificationImpl;

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
            context().LOG().LogInfo( "Employee added successfully." );
            context().UI().Reply( "Employee added successfully.", true );
        }
        else {
            context().LOG().LogInfo( "Adding employee is unsuccessful. National ID is registered for another employee." );
            context().UI().Reply( "Adding employee is unsuccessful. Employee already exists", false );
        }
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

    public void ReadEmployee() throws XtumlException {
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
    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
        if ( satisfied() ) send(new IData.Reply(p_msg, p_state));
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


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IData.SIGNAL_NO_DELETELEAVESPECIFICATION:
                DeleteLeaveSpecification(StringUtil.deserialize(message.get(0)));
                break;
            case IData.SIGNAL_NO_CREATEEMPLOYEE:
                CreateEmployee(IntegerUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)), IntegerUtil.deserialize(message.get(5)), StringUtil.deserialize(message.get(6)), StringUtil.deserialize(message.get(7)));
                break;
            case IData.SIGNAL_NO_READLEAVESPECIFICATION:
                ReadLeaveSpecification();
                break;
            case IData.SIGNAL_NO_READEMPLOYEE:
                ReadEmployee();
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
