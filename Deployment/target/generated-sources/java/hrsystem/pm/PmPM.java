package hrsystem.pm;


import hrsystem.Pm;
import hrsystem.pm.main.impl.InitiativeImpl;
import hrsystem.pm.main.impl.MilestoneImpl;
import hrsystem.pm.main.impl.StrategyImpl;
import hrsystem.pm.main.impl.Supporting_DocumentsImpl;

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
    public void Strategy( final String p_Name,  final String p_Description,  final String p_Number,  final String p_Action ) throws XtumlException {
        new StrategyImpl.CLASS(context()).crud( p_Name, p_Number, p_Description, p_Action );
    }

    public void Supporting_Documents( final String p_Name,  final String p_Document,  final String p_State,  final String p_Notes,  final String p_Full_Code,  final String p_Action ) throws XtumlException {
        new Supporting_DocumentsImpl.CLASS(context()).crud( p_Name, p_Document, p_State, p_Notes, p_Full_Code, p_Action );
    }

    public void Initiative( final String p_Name,  final String p_Short_Number,  final String p_Long_Number,  final String p_Description,  final int p_Start_Date,  final int p_Actual_Start_Date,  final int p_End_Date,  final int p_Actual_End_Date,  final double p_Budget,  final String p_Str_Name,  final String p_Action ) throws XtumlException {
        new InitiativeImpl.CLASS(context()).crud( p_Name, p_Short_Number, p_Long_Number, p_Description, p_Start_Date, p_Actual_Start_Date, p_End_Date, p_Actual_End_Date, p_Budget, p_Str_Name, p_Action );
    }

    public void Milestone( final String p_Name,  final String p_Full_Code,  final String p_Code,  final String p_Type,  final String p_Success_Criteria,  final int p_Complete_Planned,  final int p_Complete_Actual,  final int p_Complete,  final int p_Weight,  final int p_Percentage,  final String p_sd_State,  final String p_sd_Description,  final String p_Notes,  final String p_Incomplete_Reasons,  final String p_Initiative_Number,  final String p_Action ) throws XtumlException {
        new MilestoneImpl.CLASS(context()).crud( p_Name, p_Full_Code, p_Code, p_Type, p_Success_Criteria, p_Complete_Planned, p_Complete_Actual, p_Complete, p_Weight, p_Percentage, p_sd_State, p_sd_Description, p_Notes, p_Incomplete_Reasons, p_Initiative_Number, p_Action );
    }



    // outbound messages
    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
        if ( satisfied() ) send(new IPmCRUD.Reply(p_msg, p_state));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IPmCRUD.SIGNAL_NO_STRATEGY:
                Strategy(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)));
                break;
            case IPmCRUD.SIGNAL_NO_SUPPORTING_DOCUMENTS:
                Supporting_Documents(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)), StringUtil.deserialize(message.get(5)));
                break;
            case IPmCRUD.SIGNAL_NO_INITIATIVE:
                Initiative(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)), IntegerUtil.deserialize(message.get(4)), IntegerUtil.deserialize(message.get(5)), IntegerUtil.deserialize(message.get(6)), IntegerUtil.deserialize(message.get(7)), RealUtil.deserialize(message.get(8)), StringUtil.deserialize(message.get(9)), StringUtil.deserialize(message.get(10)));
                break;
            case IPmCRUD.SIGNAL_NO_MILESTONE:
                Milestone(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)), IntegerUtil.deserialize(message.get(5)), IntegerUtil.deserialize(message.get(6)), IntegerUtil.deserialize(message.get(7)), IntegerUtil.deserialize(message.get(8)), IntegerUtil.deserialize(message.get(9)), StringUtil.deserialize(message.get(10)), StringUtil.deserialize(message.get(11)), StringUtil.deserialize(message.get(12)), StringUtil.deserialize(message.get(13)), StringUtil.deserialize(message.get(14)), StringUtil.deserialize(message.get(15)));
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
