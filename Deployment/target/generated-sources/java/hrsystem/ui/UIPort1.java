package hrsystem.ui;


import hrsystem.UI;

import interfaces.IPmCRUD;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;


public class UIPort1 extends Port<UI> implements IPmCRUD {

    public UIPort1( UI context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages


    // outbound messages
    public void Initiative( final String p_Name,  final String p_Short_Number,  final String p_Long_Number,  final String p_Description,  final int p_Start_Date,  final int p_Actual_Start_Date,  final int p_End_Date,  final int p_Actual_End_Date,  final double p_Budget,  final String p_Action ) throws XtumlException {
        if ( satisfied() ) send(new IPmCRUD.Initiative(p_Name, p_Short_Number, p_Long_Number, p_Description, p_Start_Date, p_Actual_Start_Date, p_End_Date, p_Actual_End_Date, p_Budget, p_Action));
        else {
        }
    }
    public void Strategy( final String p_Name,  final String p_Description,  final String p_Number,  final String p_Action ) throws XtumlException {
        if ( satisfied() ) send(new IPmCRUD.Strategy(p_Name, p_Description, p_Number, p_Action));
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
