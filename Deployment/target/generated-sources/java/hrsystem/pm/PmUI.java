package hrsystem.pm;


import hrsystem.Pm;
import hrsystem.pm.main.Initiative;
import hrsystem.pm.main.Milestone;
import hrsystem.pm.main.MilestoneSet;
import hrsystem.pm.main.Strategy;
import hrsystem.pm.main.StrategySet;

import interfaces.IProjects;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.StringUtil;

import java.util.Iterator;


public class PmUI extends Port<Pm> implements IProjects {

    public PmUI( Pm context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void ReadStrategies() throws XtumlException {
        StrategySet strategies = context().Strategy_instances();
        if ( !strategies.isEmpty() ) {
            context().LOG().LogInfo( "Sending strategy set .. " );
            Strategy strategy;
            for ( Iterator<Strategy> _strategy_iter = strategies.elements().iterator(); _strategy_iter.hasNext(); ) {
                strategy = _strategy_iter.next();
                context().UI().SendStrategies( strategy.getNumber(), strategy.getName(), strategy.getDescription() );
                context().LOG().LogInfo( ( ( ( ( "Strategy: Number " + strategy.getNumber() ) + ", Name:" ) + strategy.getName() ) + ", Description: " ) + strategy.getDescription() );
            }
            context().LOG().LogInfo( "Sending strategy set is complete. " );
        }
        else {
            context().LOG().LogInfo( "Strategy: No strategyies found in the system " );
        }
    }

    public void ReadMilestones( final String p_InitiativeName,  final String p_InitiativeShortNumber,  final String p_InitiativeLongNumber ) throws XtumlException {
        Initiative initiative = context().Initiative_instances().anyWhere(selected -> ( StringUtil.equality(((Initiative)selected).getName(), p_InitiativeName) || StringUtil.equality(((Initiative)selected).getLongNumber(), p_InitiativeLongNumber) ) || StringUtil.equality(((Initiative)selected).getShortNumber(), p_InitiativeShortNumber));
        MilestoneSet milestones = initiative.R60_achieves_Milestone();
        if ( !milestones.isEmpty() ) {
            context().LOG().LogInfo( "Sending milestone set .. " );
            Milestone milestone;
            for ( Iterator<Milestone> _milestone_iter = milestones.elements().iterator(); _milestone_iter.hasNext(); ) {
                milestone = _milestone_iter.next();
                context().UI().SendMilestones( milestone.getName(), milestone.getFullCode(), milestone.getCode(), milestone.getType(), milestone.getSuccessCriteria(), milestone.getCompletePlanned(), milestone.getCompleteActual(), milestone.getComplete(), milestone.getWeight(), ((int)(milestone.getPercentage())), milestone.getSdState(), milestone.getSdDescription(), milestone.getNotes(), milestone.getIncompleteReasons() );
                context().LOG().LogInfo( ( ( "Milestone: Name " + milestone.getName() ) + ", Code: " ) + milestone.getCode() );
            }
            context().LOG().LogInfo( "Sending milestone set is complete. " );
        }
        else {
            context().LOG().LogInfo( "Milestone: No milestones found in the system " );
        }
    }

    public void Initialize() throws XtumlException {
        context().Initialize();
    }



    // outbound messages
    public void SendMilestones( final String p_Name,  final String p_FullCode,  final String p_Code,  final String p_Type,  final String p_SuccessCriteria,  final int p_CompletePlanned,  final int p_CompleteActual,  final boolean p_Complete,  final int p_Weight,  final int p_Percentage,  final String p_sdState,  final String p_sdDescription,  final String p_Notes,  final String p_IncompleteReasons ) throws XtumlException {
        if ( satisfied() ) send(new IProjects.SendMilestones(p_Name, p_FullCode, p_Code, p_Type, p_SuccessCriteria, p_CompletePlanned, p_CompleteActual, p_Complete, p_Weight, p_Percentage, p_sdState, p_sdDescription, p_Notes, p_IncompleteReasons));
        else {
        }
    }
    public void SendStrategies( final String p_Number,  final String p_Name,  final String p_Description ) throws XtumlException {
        if ( satisfied() ) send(new IProjects.SendStrategies(p_Number, p_Name, p_Description));
        else {
        }
    }
    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
        if ( satisfied() ) send(new IProjects.Reply(p_msg, p_state));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IProjects.SIGNAL_NO_READSTRATEGIES:
                ReadStrategies();
                break;
            case IProjects.SIGNAL_NO_READMILESTONES:
                ReadMilestones(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)));
                break;
            case IProjects.SIGNAL_NO_INITIALIZE:
                Initialize();
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "UI";
    }

}
