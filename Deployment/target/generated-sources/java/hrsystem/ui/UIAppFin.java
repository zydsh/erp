package hrsystem.ui;


import hrsystem.UI;

import interfaces.ICRUD;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.BooleanUtil;
import io.ciera.runtime.summit.types.StringUtil;


public class UIAppFin extends Port<UI> implements ICRUD {

    public UIAppFin( UI context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
    }



    // outbound messages
    public void Section( final String p_Name,  final String p_ID,  final double p_Fund,  final String p_Economic_Category,  final String p_Comments,  final String p_Year,  final String p_Action,  final int p_Code ) throws XtumlException {
        if ( satisfied() ) send(new ICRUD.Section(p_Name, p_ID, p_Fund, p_Economic_Category, p_Comments, p_Year, p_Action, p_Code));
        else {
        }
    }
    public void Item( final double p_Fund,  final String p_Status,  final String p_Type,  final String p_Category,  final String p_ID,  final String p_Section_ID,  final String p_Action ) throws XtumlException {
        if ( satisfied() ) send(new ICRUD.Item(p_Fund, p_Status, p_Type, p_Category, p_ID, p_Section_ID, p_Action));
        else {
        }
    }
    public void Chapter( final String p_Name,  final int p_Code,  final double p_Ceiling_Fund,  final double p_Request_Fund,  final double p_Fund,  final String p_Action,  final String p_Year ) throws XtumlException {
        if ( satisfied() ) send(new ICRUD.Chapter(p_Name, p_Code, p_Ceiling_Fund, p_Request_Fund, p_Fund, p_Action, p_Year));
        else {
        }
    }
    public void Budget( final String p_Year,  final double p_Fund,  final String p_Action ) throws XtumlException {
        if ( satisfied() ) send(new ICRUD.Budget(p_Year, p_Fund, p_Action));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case ICRUD.SIGNAL_NO_REPLY:
                Reply(StringUtil.deserialize(message.get(0)), BooleanUtil.deserialize(message.get(1)));
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "AppFin";
    }

}
