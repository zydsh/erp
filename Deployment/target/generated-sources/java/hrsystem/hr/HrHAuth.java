package hrsystem.hr;


import hrsystem.Hr;

import interfaces.ICRUD;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.BooleanUtil;
import io.ciera.runtime.summit.types.StringUtil;


public class HrHAuth extends Port<Hr> implements ICRUD {

    public HrHAuth( Hr context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void Reply( final String p_Username,  final String p_Password,  final boolean p_state ) throws XtumlException {
    }



    // outbound messages
    public void Account( final String p_First_Name,  final String p_Last_Name,  final int p_National_ID ) throws XtumlException {
        if ( satisfied() ) send(new ICRUD.Account(p_First_Name, p_Last_Name, p_National_ID));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case ICRUD.SIGNAL_NO_REPLY:
                Reply(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), BooleanUtil.deserialize(message.get(2)));
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "HAuth";
    }

}
