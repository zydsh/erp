package hrsystem.ui;


import hrsystem.UI;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.IntegerUtil;
import io.ciera.runtime.summit.types.RealUtil;
import io.ciera.runtime.summit.types.StringUtil;

import shared.IOps;


public class UIAppOps extends Port<UI> implements IOps {

    public UIAppOps( UI context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void Return_Employee_Payment( final double p_Amount,  final String p_Name,  final int p_Date ) throws XtumlException {
    }



    // outbound messages
    public void RequestEmployeeLeave( final int p_Starting,  final int p_Ending,  final int p_EmployeeID,  final String p_LeaveName ) throws XtumlException {
        if ( satisfied() ) send(new IOps.RequestEmployeeLeave(p_Starting, p_Ending, p_EmployeeID, p_LeaveName));
        else {
        }
    }
    public void CommenceEmployee( final int p_National_ID ) throws XtumlException {
        if ( satisfied() ) send(new IOps.CommenceEmployee(p_National_ID));
        else {
        }
    }
    public void ApproveEmployeeLeave( final int p_EmployeeID ) throws XtumlException {
        if ( satisfied() ) send(new IOps.ApproveEmployeeLeave(p_EmployeeID));
        else {
        }
    }
    public void GenerateEmployeePayslip( final int p_National_ID ) throws XtumlException {
        if ( satisfied() ) send(new IOps.GenerateEmployeePayslip(p_National_ID));
        else {
        }
    }
    public void AssignJobToEmployee( final int p_Job_ID,  final int p_National_ID,  final String p_Action,  final boolean p_Active ) throws XtumlException {
        if ( satisfied() ) send(new IOps.AssignJobToEmployee(p_Job_ID, p_National_ID, p_Action, p_Active));
        else {
        }
    }
    public void ReturnFromLeave( final int p_National_ID ) throws XtumlException {
        if ( satisfied() ) send(new IOps.ReturnFromLeave(p_National_ID));
        else {
        }
    }
    public void RejectEmployeeLeave( final int p_EmployeeID ) throws XtumlException {
        if ( satisfied() ) send(new IOps.RejectEmployeeLeave(p_EmployeeID));
        else {
        }
    }
    public void AssignBonusToEmployee( final int p_National_ID,  final String p_Name,  final int p_Starting,  final int p_Ending,  final String p_Action ) throws XtumlException {
        if ( satisfied() ) send(new IOps.AssignBonusToEmployee(p_National_ID, p_Name, p_Starting, p_Ending, p_Action));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IOps.SIGNAL_NO_RETURN_EMPLOYEE_PAYMENT:
                Return_Employee_Payment(RealUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)));
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "AppOps";
    }

}
