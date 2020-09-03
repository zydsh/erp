package erp.pm;


import erp.Pm;
import erp.pm.main.Strategy;
import erp.pm.main.StrategySet;

import interfaces.IProjects;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;

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

    public void Initialize() throws XtumlException {
        context().Initialize();
    }



    // outbound messages
    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
        if ( satisfied() ) send(new IProjects.Reply(p_msg, p_state));
        else {
        }
    }
    public void SendStrategies( final String p_Number,  final String p_Name,  final String p_Description ) throws XtumlException {
        if ( satisfied() ) send(new IProjects.SendStrategies(p_Number, p_Name, p_Description));
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
