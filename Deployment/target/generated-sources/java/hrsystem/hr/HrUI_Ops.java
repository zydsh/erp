package hrsystem.hr;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Leave;
import hrsystem.hr.main.LeaveSpecification;
import hrsystem.hr.main.impl.LeaveImpl;
import hrsystem.hr.messagecenter.ApproveLeave;
import hrsystem.hr.messagecenter.impl.ApproveLeaveImpl;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.BooleanUtil;
import io.ciera.runtime.summit.types.IntegerUtil;
import io.ciera.runtime.summit.types.StringUtil;

import shared.IOps;


public class HrUI_Ops extends Port<Hr> implements IOps {

    public HrUI_Ops( Hr context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void AssignBonusToEmployee( final int p_National_ID,  final String p_Name,  final int p_Starting,  final int p_Ending,  final String p_Action ) throws XtumlException {
    }

    public void GenerateEmployeePayslip( final int p_National_ID ) throws XtumlException {
    }

    public void AssignJobToEmployee( final int p_Job_ID,  final int p_National_ID,  final String p_Action,  final boolean p_Active ) throws XtumlException {
    }

    public void RequestEmployeeLeave( final int p_Starting,  final int p_Ending,  final int p_EmployeeID,  final String p_LeaveName ) throws XtumlException {
        Employee employee = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == p_EmployeeID);
        LeaveSpecification leaveSpec = context().LeaveSpecification_instances().anyWhere(selected -> StringUtil.equality(((LeaveSpecification)selected).getName(), p_LeaveName));
        if ( !employee.isEmpty() && !leaveSpec.isEmpty() ) {
            Leave empLeave = LeaveImpl.create( context() );
            empLeave.setStarting(p_Starting);
            empLeave.setEnding(p_Ending);
            context().relate_R7_Leave_to_be_taken_by_Employee( empLeave, employee );
            context().relate_R15_Leave_is_specified_by_a_LeaveSpecification( empLeave, leaveSpec );
            Employee employeeMngr = employee.R21_working_within_Department().R23_is_managed_by_Employee();
            ApproveLeave approveLeaveMsg = ApproveLeaveImpl.create( context() );
            approveLeaveMsg.createMessage( p_Starting, p_Ending, employee.getEmployeeID(), employeeMngr.getEmployeeID() );
        }
        else {
            context().LOG().LogInfo( "Employee is not registered!" );
            context().UI().Reply( "Employee is not found.", false );
        }
    }

    public void CommenceEmployee( final int p_National_ID ) throws XtumlException {
        Employee employee = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getNationalID() == p_National_ID);
        if ( !employee.isEmpty() ) {
            employee.commenceEmployee( p_National_ID );
        }
        else {
            context().LOG().LogInfo( "Employee is not registered!" );
            context().UI().Reply( "Employee is not found.", false );
        }
    }

    public void RejectEmployeeLeave( final int p_EmployeeID ) throws XtumlException {
        Employee employee = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == p_EmployeeID);
        if ( !employee.isEmpty() ) {
            Leave leave = employee.R7_is_planning_to_take__Leave();
            context().generate(new LeaveImpl.Reject(getRunContext(), context().getId()).to(leave));
        }
    }

    public void ApproveEmployeeLeave( final int p_EmployeeID ) throws XtumlException {
        Employee employee = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == p_EmployeeID);
        if ( !employee.isEmpty() ) {
            Leave leave = employee.R7_is_planning_to_take__Leave();
            context().generate(new LeaveImpl.Approve(getRunContext(), context().getId()).to(leave));
        }
    }

    public void ReturnFromLeave( final int p_National_ID ) throws XtumlException {
    }



    // outbound messages
    public void Return_Employee_Payment( final double p_Amount,  final String p_Name,  final int p_Date ) throws XtumlException {
        if ( satisfied() ) send(new IOps.Return_Employee_Payment(p_Amount, p_Name, p_Date));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IOps.SIGNAL_NO_ASSIGNBONUSTOEMPLOYEE:
                AssignBonusToEmployee(IntegerUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)), IntegerUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)));
                break;
            case IOps.SIGNAL_NO_GENERATEEMPLOYEEPAYSLIP:
                GenerateEmployeePayslip(IntegerUtil.deserialize(message.get(0)));
                break;
            case IOps.SIGNAL_NO_ASSIGNJOBTOEMPLOYEE:
                AssignJobToEmployee(IntegerUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)), BooleanUtil.deserialize(message.get(3)));
                break;
            case IOps.SIGNAL_NO_REQUESTEMPLOYEELEAVE:
                RequestEmployeeLeave(IntegerUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)));
                break;
            case IOps.SIGNAL_NO_COMMENCEEMPLOYEE:
                CommenceEmployee(IntegerUtil.deserialize(message.get(0)));
                break;
            case IOps.SIGNAL_NO_REJECTEMPLOYEELEAVE:
                RejectEmployeeLeave(IntegerUtil.deserialize(message.get(0)));
                break;
            case IOps.SIGNAL_NO_APPROVEEMPLOYEELEAVE:
                ApproveEmployeeLeave(IntegerUtil.deserialize(message.get(0)));
                break;
            case IOps.SIGNAL_NO_RETURNFROMLEAVE:
                ReturnFromLeave(IntegerUtil.deserialize(message.get(0)));
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "UI_Ops";
    }

}
