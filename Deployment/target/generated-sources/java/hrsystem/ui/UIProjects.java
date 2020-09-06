package hrsystem.ui;


import hrsystem.UI;

import interfaces.IProjects;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.BooleanUtil;
import io.ciera.runtime.summit.types.IntegerUtil;
import io.ciera.runtime.summit.types.StringUtil;


public class UIProjects extends Port<UI> implements IProjects {

    public UIProjects( UI context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void SendMilestones( final String p_Name,  final String p_FullCode,  final String p_Code,  final String p_Type,  final String p_SuccessCriteria,  final int p_CompletePlanned,  final int p_CompleteActual,  final boolean p_Complete,  final int p_Weight,  final int p_Percentage,  final String p_sdState,  final String p_sdDescription,  final String p_Notes,  final String p_IncompleteReasons ) throws XtumlException {
        context().SendMilestones( p_Name, p_FullCode, p_Code, p_Type, p_SuccessCriteria, p_CompletePlanned, p_CompleteActual, p_Complete, p_Weight, p_Percentage, p_sdState, p_sdDescription, p_Notes, p_Notes );
    }

    public void SendStrategies( final String p_Number,  final String p_Name,  final String p_Description ) throws XtumlException {
        context().SendStrategies( p_Number, p_Name, p_Description );
    }

    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
    }



    // outbound messages
    public void ReadMilestones( final String p_InitiativeName,  final String p_InitiativeShortNumber,  final String p_InitiativeLongNumber ) throws XtumlException {
        if ( satisfied() ) send(new IProjects.ReadMilestones(p_InitiativeName, p_InitiativeShortNumber, p_InitiativeLongNumber));
        else {
        }
    }
    public void Initialize() throws XtumlException {
        if ( satisfied() ) send(new IProjects.Initialize());
        else {
        }
    }
    public void ReadStrategies() throws XtumlException {
        if ( satisfied() ) send(new IProjects.ReadStrategies());
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IProjects.SIGNAL_NO_SENDMILESTONES:
                SendMilestones(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)), IntegerUtil.deserialize(message.get(5)), IntegerUtil.deserialize(message.get(6)), BooleanUtil.deserialize(message.get(7)), IntegerUtil.deserialize(message.get(8)), IntegerUtil.deserialize(message.get(9)), StringUtil.deserialize(message.get(10)), StringUtil.deserialize(message.get(11)), StringUtil.deserialize(message.get(12)), StringUtil.deserialize(message.get(13)));
                break;
            case IProjects.SIGNAL_NO_SENDSTRATEGIES:
                SendStrategies(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)));
                break;
            case IProjects.SIGNAL_NO_REPLY:
                Reply(StringUtil.deserialize(message.get(0)), BooleanUtil.deserialize(message.get(1)));
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
