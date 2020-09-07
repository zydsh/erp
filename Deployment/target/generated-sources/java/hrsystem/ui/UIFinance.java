package hrsystem.ui;


import hrsystem.UI;

import interfaces.IFinance;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;


public class UIFinance extends Port<UI> implements IFinance {

    public UIFinance( UI context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages


    // outbound messages
    public void Initialize() throws XtumlException {
        if ( satisfied() ) send(new IFinance.Initialize());
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
        return "Finance";
    }

}
