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
    public void Request_Employee_Payment( final int p_National_ID ) throws XtumlException {
        if ( satisfied() ) send(new IOps.Request_Employee_Payment(p_National_ID));
        else {
        }
    }
    public void Leave_Request( final int p_Starting,  final int p_Ending,  final int p_National_ID,  final String p_Name ) throws XtumlException {
        if ( satisfied() ) send(new IOps.Leave_Request(p_Starting, p_Ending, p_National_ID, p_Name));
        else {
        }
    }
    public void Employee_Job( final int p_Job_ID,  final int p_National_ID,  final String p_Action,  final boolean p_Active ) throws XtumlException {
        if ( satisfied() ) send(new IOps.Employee_Job(p_Job_ID, p_National_ID, p_Action, p_Active));
        else {
        }
    }
    public void Employee_Commence( final int p_National_ID ) throws XtumlException {
        if ( satisfied() ) send(new IOps.Employee_Commence(p_National_ID));
        else {
        }
    }
    public void Leave_Return( final int p_National_ID ) throws XtumlException {
        if ( satisfied() ) send(new IOps.Leave_Return(p_National_ID));
        else {
        }
    }
    public void Employee_Bonus( final int p_National_ID,  final String p_Name,  final int p_Starting,  final int p_Ending,  final String p_Action ) throws XtumlException {
        if ( satisfied() ) send(new IOps.Employee_Bonus(p_National_ID, p_Name, p_Starting, p_Ending, p_Action));
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
