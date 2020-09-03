package erp.pm.main.impl;


import erp.pm.main.InitiativeSet;
import erp.pm.main.Strategy;
import erp.pm.main.StrategySet;
import erp.pm.main.impl.InitiativeSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class StrategySetImpl extends InstanceSet<StrategySet,Strategy> implements StrategySet {

    public StrategySetImpl() {
    }

    public StrategySetImpl(Comparator<? super Strategy> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setDescription( String m_Description ) throws XtumlException {
        for ( Strategy strategy : this ) strategy.setDescription( m_Description );
    }
    @Override
    public void setNumber( String m_Number ) throws XtumlException {
        for ( Strategy strategy : this ) strategy.setNumber( m_Number );
    }
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Strategy strategy : this ) strategy.setName( m_Name );
    }


    // selections
    @Override
    public InitiativeSet R1_defines_Initiative() throws XtumlException {
        InitiativeSet initiativeset = new InitiativeSetImpl();
        for ( Strategy strategy : this ) initiativeset.addAll( strategy.R1_defines_Initiative() );
        return initiativeset;
    }


    @Override
    public Strategy nullElement() {
        return StrategyImpl.EMPTY_STRATEGY;
    }

    @Override
    public StrategySet emptySet() {
      return new StrategySetImpl();
    }

    @Override
    public StrategySet emptySet(Comparator<? super Strategy> comp) {
      return new StrategySetImpl(comp);
    }

    @Override
    public List<Strategy> elements() {
        return Arrays.asList(toArray(new Strategy[0]));
    }

}
