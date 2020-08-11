package hrsystem.pm;


import hrsystem.Pm;

import interfaces.IPmCRUD;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.IntegerUtil;
import io.ciera.runtime.summit.types.RealUtil;
import io.ciera.runtime.summit.types.StringUtil;


public class PmPM extends Port<Pm> implements IPmCRUD {

    public PmPM( Pm context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void Initiative( final String p_Name,  final String p_Short_Number,  final String p_Long_Number,  final String p_Description,  final int p_Start_Date,  final int p_Actual_Start_Date,  final int p_End_Date,  final int p_Actual_End_Date,  final double p_Budget,  final String p_Action ) throws XtumlException {
    }

    public void Strategy( final String p_Name,  final String p_Description,  final String p_Number,  final String p_Action ) throws XtumlException {
    }



    // outbound messages


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IPmCRUD.SIGNAL_NO_INITIATIVE:
                Initiative(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)), IntegerUtil.deserialize(message.get(4)), IntegerUtil.deserialize(message.get(5)), IntegerUtil.deserialize(message.get(6)), IntegerUtil.deserialize(message.get(7)), RealUtil.deserialize(message.get(8)), StringUtil.deserialize(message.get(9)));
                break;
            case IPmCRUD.SIGNAL_NO_STRATEGY:
                Strategy(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)));
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "PM";
    }

}
