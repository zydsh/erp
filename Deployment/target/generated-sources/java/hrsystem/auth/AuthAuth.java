package hrsystem.auth;


import hrsystem.Auth;
import hrsystem.auth.main.impl.AccountImpl;

import interfaces.ICRUD;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.IntegerUtil;
import io.ciera.runtime.summit.types.StringUtil;


public class AuthAuth extends Port<Auth> implements ICRUD {

    public AuthAuth( Auth context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void Account( final String p_First_Name,  final String p_Last_Name,  final int p_National_ID ) throws XtumlException {
        new AccountImpl.CLASS(context()).crud( p_First_Name, p_Last_Name, p_National_ID );
    }



    // outbound messages
    public void Reply( final String p_Username,  final String p_Password,  final boolean p_state ) throws XtumlException {
        if ( satisfied() ) send(new ICRUD.Reply(p_Username, p_Password, p_state));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case ICRUD.SIGNAL_NO_ACCOUNT:
                Account(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)));
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "Auth";
    }

}
