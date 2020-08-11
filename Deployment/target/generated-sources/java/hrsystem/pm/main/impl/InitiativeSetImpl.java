package hrsystem.pm.main.impl;


import hrsystem.pm.main.Initiative;
import hrsystem.pm.main.InitiativeSet;
import hrsystem.pm.main.MilestoneSet;
import hrsystem.pm.main.StrategySet;
import hrsystem.pm.main.impl.MilestoneSetImpl;
import hrsystem.pm.main.impl.StrategySetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class InitiativeSetImpl extends InstanceSet<InitiativeSet,Initiative> implements InitiativeSet {

    public InitiativeSetImpl() {
    }

    public InitiativeSetImpl(Comparator<? super Initiative> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setActual_Start_Date( int m_Actual_Start_Date ) throws XtumlException {
        for ( Initiative initiative : this ) initiative.setActual_Start_Date( m_Actual_Start_Date );
    }
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Initiative initiative : this ) initiative.setName( m_Name );
    }
    @Override
    public void setBudget( double m_Budget ) throws XtumlException {
        for ( Initiative initiative : this ) initiative.setBudget( m_Budget );
    }
    @Override
    public void setLong_Number( String m_Long_Number ) throws XtumlException {
        for ( Initiative initiative : this ) initiative.setLong_Number( m_Long_Number );
    }
    @Override
    public void setDescription( String m_Description ) throws XtumlException {
        for ( Initiative initiative : this ) initiative.setDescription( m_Description );
    }
    @Override
    public void setEnd_Date( int m_End_Date ) throws XtumlException {
        for ( Initiative initiative : this ) initiative.setEnd_Date( m_End_Date );
    }
    @Override
    public void setShort_Number( String m_Short_Number ) throws XtumlException {
        for ( Initiative initiative : this ) initiative.setShort_Number( m_Short_Number );
    }
    @Override
    public void setStart_Date( int m_Start_Date ) throws XtumlException {
        for ( Initiative initiative : this ) initiative.setStart_Date( m_Start_Date );
    }


    // selections
    @Override
    public StrategySet R1_Strategy() throws XtumlException {
        StrategySet strategyset = new StrategySetImpl();
        for ( Initiative initiative : this ) strategyset.add( initiative.R1_Strategy() );
        return strategyset;
    }
    @Override
    public MilestoneSet R2_Milestone() throws XtumlException {
        MilestoneSet milestoneset = new MilestoneSetImpl();
        for ( Initiative initiative : this ) milestoneset.addAll( initiative.R2_Milestone() );
        return milestoneset;
    }


    @Override
    public Initiative nullElement() {
        return InitiativeImpl.EMPTY_INITIATIVE;
    }

    @Override
    public InitiativeSet emptySet() {
      return new InitiativeSetImpl();
    }

    @Override
    public InitiativeSet emptySet(Comparator<? super Initiative> comp) {
      return new InitiativeSetImpl(comp);
    }

    @Override
    public List<Initiative> elements() {
        return Arrays.asList(toArray(new Initiative[0]));
    }

}
