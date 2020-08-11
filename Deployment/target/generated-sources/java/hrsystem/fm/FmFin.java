package hrsystem.fm;


import hrsystem.Fm;

import interfaces.IFinCRUD;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.RealUtil;
import io.ciera.runtime.summit.types.StringUtil;


public class FmFin extends Port<Fm> implements IFinCRUD {

    public FmFin( Fm context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void Item( final String p_ItemID,  final double p_Fund,  final String p_Status,  final String p_Type,  final String p_Category,  final String p_SecID,  final String p_Action ) throws XtumlException {
    }

    public void Chapter( final String p_Name,  final String p_Code,  final double p_Ceiling_Fund,  final double p_Request_Fund,  final String p_Year,  final String p_Action,  final double p_Fund ) throws XtumlException {
    }

    public void Section( final String p_SecID,  final String p_Name,  final String p_Code,  final double p_Fund,  final String p_Economic_Category,  final String p_Comments,  final String p_Action,  final String p_Year ) throws XtumlException {
    }

    public void Budget( final String p_Year,  final double p_Fund,  final String p_Action ) throws XtumlException {
    }



    // outbound messages
    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
        if ( satisfied() ) send(new IFinCRUD.Reply(p_msg, p_state));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IFinCRUD.SIGNAL_NO_ITEM:
                Item(StringUtil.deserialize(message.get(0)), RealUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)), StringUtil.deserialize(message.get(5)), StringUtil.deserialize(message.get(6)));
                break;
            case IFinCRUD.SIGNAL_NO_CHAPTER:
                Chapter(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), RealUtil.deserialize(message.get(2)), RealUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)), StringUtil.deserialize(message.get(5)), RealUtil.deserialize(message.get(6)));
                break;
            case IFinCRUD.SIGNAL_NO_SECTION:
                Section(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)), RealUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)), StringUtil.deserialize(message.get(5)), StringUtil.deserialize(message.get(6)), StringUtil.deserialize(message.get(7)));
                break;
            case IFinCRUD.SIGNAL_NO_BUDGET:
                Budget(StringUtil.deserialize(message.get(0)), RealUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)));
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "Fin";
    }

}
