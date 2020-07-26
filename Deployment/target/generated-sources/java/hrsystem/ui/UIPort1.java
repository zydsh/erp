package hrsystem.ui;


import hrsystem.UI;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;

import shared.IOps;


public class UIPort1 extends Port<UI> implements IOps {

    public UIPort1( UI context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages


    // outbound messages
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
    public void Leave_Request( final int p_Starting,  final int p_Ending,  final int p_National_ID,  final String p_Name ) throws XtumlException {
        if ( satisfied() ) send(new IOps.Leave_Request(p_Starting, p_Ending, p_National_ID, p_Name));
        else {
        }
    }
    public void Employee_Commence( final int p_National_ID ) throws XtumlException {
        if ( satisfied() ) send(new IOps.Employee_Commence(p_National_ID));
        else {
        }
    }
    public void Employee_Job( final int p_Job_ID,  final int p_National_ID ) throws XtumlException {
        if ( satisfied() ) send(new IOps.Employee_Job(p_Job_ID, p_National_ID));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "Port1";
    }

}
