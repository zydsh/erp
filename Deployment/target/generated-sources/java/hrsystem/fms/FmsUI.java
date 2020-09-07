package hrsystem.fms;


import hrsystem.Fms;

import interfaces.IFinance;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;


public class FmsUI extends Port<Fms> implements IFinance {

    public FmsUI( Fms context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void Initialize() throws XtumlException {
        context().Initialize();
    }



    // outbound messages


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IFinance.SIGNAL_NO_INITIALIZE:
                Initialize();
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
