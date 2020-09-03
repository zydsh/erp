package erp.ui;


import erp.UI;

import interfaces.IProjects;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.BooleanUtil;
import io.ciera.runtime.summit.types.StringUtil;


public class UIProjects extends Port<UI> implements IProjects {

    public UIProjects( UI context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
    }

    public void SendStrategies( final String p_Number,  final String p_Name,  final String p_Description ) throws XtumlException {
        context().SendStrategies( p_Number, p_Name, p_Description );
    }



    // outbound messages
    public void ReadStrategies() throws XtumlException {
        if ( satisfied() ) send(new IProjects.ReadStrategies());
        else {
        }
    }
    public void Initialize() throws XtumlException {
        if ( satisfied() ) send(new IProjects.Initialize());
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IProjects.SIGNAL_NO_REPLY:
                Reply(StringUtil.deserialize(message.get(0)), BooleanUtil.deserialize(message.get(1)));
                break;
            case IProjects.SIGNAL_NO_SENDSTRATEGIES:
                SendStrategies(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)));
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "Projects";
    }

}
