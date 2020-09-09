package hrsystem.pm.main.impl;


import hrsystem.pm.main.Initiative;
import hrsystem.pm.main.InitiativeSet;
import hrsystem.pm.main.MilestoneSet;
import hrsystem.pm.main.ProjectSet;
import hrsystem.pm.main.StrategySet;
import hrsystem.pm.main.impl.MilestoneSetImpl;
import hrsystem.pm.main.impl.ProjectSetImpl;
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
    public void setActualEndDate( int m_ActualEndDate ) throws XtumlException {
        for ( Initiative initiative : this ) initiative.setActualEndDate( m_ActualEndDate );
    }
    @Override
    public void setStartDate( int m_StartDate ) throws XtumlException {
        for ( Initiative initiative : this ) initiative.setStartDate( m_StartDate );
    }
    @Override
    public void setLongNumber( String m_LongNumber ) throws XtumlException {
        for ( Initiative initiative : this ) initiative.setLongNumber( m_LongNumber );
    }
    @Override
    public void setBudget( double m_Budget ) throws XtumlException {
        for ( Initiative initiative : this ) initiative.setBudget( m_Budget );
    }
    @Override
    public void setShortNumber( String m_ShortNumber ) throws XtumlException {
        for ( Initiative initiative : this ) initiative.setShortNumber( m_ShortNumber );
    }
    @Override
    public void setDescription( String m_Description ) throws XtumlException {
        for ( Initiative initiative : this ) initiative.setDescription( m_Description );
    }
    @Override
    public void setActualStartDate( int m_ActualStartDate ) throws XtumlException {
        for ( Initiative initiative : this ) initiative.setActualStartDate( m_ActualStartDate );
    }
    @Override
    public void setEndDate( int m_EndDate ) throws XtumlException {
        for ( Initiative initiative : this ) initiative.setEndDate( m_EndDate );
    }
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Initiative initiative : this ) initiative.setName( m_Name );
    }


    // selections
    @Override
    public StrategySet R10_implements_Strategy() throws XtumlException {
        StrategySet strategyset = new StrategySetImpl();
        for ( Initiative initiative : this ) strategyset.add( initiative.R10_implements_Strategy() );
        return strategyset;
    }
    @Override
    public ProjectSet R5_implemented_Project() throws XtumlException {
        ProjectSet projectset = new ProjectSetImpl();
        for ( Initiative initiative : this ) projectset.addAll( initiative.R5_implemented_Project() );
        return projectset;
    }
    @Override
    public MilestoneSet R60_achieves_Milestone() throws XtumlException {
        MilestoneSet milestoneset = new MilestoneSetImpl();
        for ( Initiative initiative : this ) milestoneset.addAll( initiative.R60_achieves_Milestone() );
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
