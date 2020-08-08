package hrsystem.hr;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Payment;
import hrsystem.hr.main.PaymentSet;
import hrsystem.hr.main.impl.Bonus_PaymentImpl;
import hrsystem.hr.main.impl.EmployeeImpl;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.BooleanUtil;
import io.ciera.runtime.summit.types.IntegerUtil;
import io.ciera.runtime.summit.types.StringUtil;

import java.util.Iterator;

import shared.IOps;


public class HrUI_Ops extends Port<Hr> implements IOps {

    public HrUI_Ops( Hr context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
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

    public void Employee_Job( final int p_Job_ID,  final int p_National_ID,  final String p_Action,  final boolean p_Active ) throws XtumlException {
    }

    public void Employee_Commence( final int p_National_ID ) throws XtumlException {
        new EmployeeImpl.CLASS(context()).commenceEmployee( p_National_ID );
    }

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

    public void Request_Employee_Payment( final int p_National_ID ) throws XtumlException {
        Employee emp = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getNational_ID() == p_National_ID);
        PaymentSet payments = emp.R3_Payment();
        Payment epay;
        for ( Iterator<Payment> _epay_iter = payments.elements().iterator(); _epay_iter.hasNext(); ) {
            epay = _epay_iter.next();
            context().UI_Ops().Return_Employee_Payment( epay.getAmount(), epay.getName(), epay.getDate() );
        }
    }

    public void Employee_Bonus( final int p_National_ID,  final String p_Name,  final int p_Starting,  final int p_Ending,  final String p_Action ) throws XtumlException {
        new Bonus_PaymentImpl.CLASS(context()).crud( p_National_ID, p_Name, p_Starting, p_Ending, p_Action );
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
            case IOps.SIGNAL_NO_LEAVE_RETURN:
                Leave_Return(IntegerUtil.deserialize(message.get(0)));
                break;
            case IOps.SIGNAL_NO_EMPLOYEE_JOB:
                Employee_Job(IntegerUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)), BooleanUtil.deserialize(message.get(3)));
                break;
            case IOps.SIGNAL_NO_EMPLOYEE_COMMENCE:
                Employee_Commence(IntegerUtil.deserialize(message.get(0)));
                break;
            case IOps.SIGNAL_NO_LEAVE_REQUEST:
                Leave_Request(IntegerUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)));
                break;
            case IOps.SIGNAL_NO_REQUEST_EMPLOYEE_PAYMENT:
                Request_Employee_Payment(IntegerUtil.deserialize(message.get(0)));
                break;
            case IOps.SIGNAL_NO_EMPLOYEE_BONUS:
                Employee_Bonus(IntegerUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)), IntegerUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)));
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
