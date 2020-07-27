package hrsystem.hr;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.impl.EmployeeImpl;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.IntegerUtil;
import io.ciera.runtime.summit.types.StringUtil;

import shared.IOps;


public class HrUI_Ops extends Port<Hr> implements IOps {

    public HrUI_Ops( Hr context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void Leave_Request( final int p_Starting,  final int p_Ending,  final int p_National_ID,  final String p_Name ) throws XtumlException {
        Employee employee = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getNational_ID() == p_National_ID);
        if ( !employee.isEmpty() ) {
            context().generate(new EmployeeImpl.requestLeave(getRunContext(), context().getId(),  p_Starting, p_Ending, p_National_ID, p_Name ).to(employee));
            context().UI().Reply( "Employee has requested leave successfully ", true );
        }
        else {
            context().LOG().LogInfo( "Employee is not registered!" );
            context().UI().Reply( "Employee is not found.", false );
        }
    }

    public void Employee_Job( final int p_Job_ID,  final int p_National_ID ) throws XtumlException {
    }

    public void Employee_Bonus( final int p_National_ID,  final String p_Name,  final int p_Starting,  final int p_Ending,  final String p_Action ) throws XtumlException {
    }

    public void Employee_Commence( final int p_National_ID ) throws XtumlException {
    }

    public void Leave_Return( final int p_National_ID ) throws XtumlException {
        Employee employee = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getNational_ID() == p_National_ID);
        if ( !employee.isEmpty() ) {
            context().generate(new EmployeeImpl.returnFromLeave(getRunContext(), context().getId()).to(employee));
            context().UI().Reply( "Employee request is successfull ", true );
        }
        else {
            context().LOG().LogInfo( "Employee is not registered!" );
            context().UI().Reply( "Employee is not found.", false );
        }
    }



    // outbound messages


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IOps.SIGNAL_NO_LEAVE_REQUEST:
                Leave_Request(IntegerUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)));
                break;
            case IOps.SIGNAL_NO_EMPLOYEE_JOB:
                Employee_Job(IntegerUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)));
                break;
            case IOps.SIGNAL_NO_EMPLOYEE_BONUS:
                Employee_Bonus(IntegerUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)), IntegerUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)));
                break;
            case IOps.SIGNAL_NO_EMPLOYEE_COMMENCE:
                Employee_Commence(IntegerUtil.deserialize(message.get(0)));
                break;
            case IOps.SIGNAL_NO_LEAVE_RETURN:
                Leave_Return(IntegerUtil.deserialize(message.get(0)));
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
