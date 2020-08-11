package hrsystem.ui;


import hrsystem.UI;

import interfaces.IPmCRUD;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.BooleanUtil;
import io.ciera.runtime.summit.types.StringUtil;


public class UIPmcrud extends Port<UI> implements IPmCRUD {

    public UIPmcrud( UI context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
        context().Reply( p_msg, p_state );
    }



    // outbound messages
    public void Milestone( final String p_Name,  final String p_Full_Code,  final String p_Code,  final String p_Type,  final String p_Success_Criteria,  final int p_Complete_Planned,  final int p_Complete_Actual,  final int p_Complete,  final int p_Weight,  final int p_Percentage,  final String p_sd_State,  final String p_sd_Description,  final String p_Notes,  final String p_Incomplete_Reasons,  final String p_Initiative_Number,  final String p_Action ) throws XtumlException {
        if ( satisfied() ) send(new IPmCRUD.Milestone(p_Name, p_Full_Code, p_Code, p_Type, p_Success_Criteria, p_Complete_Planned, p_Complete_Actual, p_Complete, p_Weight, p_Percentage, p_sd_State, p_sd_Description, p_Notes, p_Incomplete_Reasons, p_Initiative_Number, p_Action));
        else {
        }
    }
    public void Initiative( final String p_Name,  final String p_Short_Number,  final String p_Long_Number,  final String p_Description,  final int p_Start_Date,  final int p_Actual_Start_Date,  final int p_End_Date,  final int p_Actual_End_Date,  final double p_Budget,  final String p_Str_Name,  final String p_Action ) throws XtumlException {
        if ( satisfied() ) send(new IPmCRUD.Initiative(p_Name, p_Short_Number, p_Long_Number, p_Description, p_Start_Date, p_Actual_Start_Date, p_End_Date, p_Actual_End_Date, p_Budget, p_Str_Name, p_Action));
        else {
        }
    }
    public void Strategy( final String p_Name,  final String p_Description,  final String p_Number,  final String p_Action ) throws XtumlException {
        if ( satisfied() ) send(new IPmCRUD.Strategy(p_Name, p_Description, p_Number, p_Action));
        else {
        }
    }
    public void Supporting_Documents( final String p_Name,  final String p_Document,  final String p_State,  final String p_Notes,  final String p_Full_Code,  final String p_Action ) throws XtumlException {
        if ( satisfied() ) send(new IPmCRUD.Supporting_Documents(p_Name, p_Document, p_State, p_Notes, p_Full_Code, p_Action));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IPmCRUD.SIGNAL_NO_REPLY:
                Reply(StringUtil.deserialize(message.get(0)), BooleanUtil.deserialize(message.get(1)));
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "Pmcrud";
    }

}
