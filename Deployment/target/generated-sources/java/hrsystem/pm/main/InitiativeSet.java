package hrsystem.pm.main;


import hrsystem.pm.main.MilestoneSet;
import hrsystem.pm.main.ProjectSet;
import hrsystem.pm.main.StrategySet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface InitiativeSet extends IInstanceSet<InitiativeSet,Initiative> {

    // attributes
    public void setActualEndDate( int m_ActualEndDate ) throws XtumlException;
    public void setEndDate( int m_EndDate ) throws XtumlException;
    public void setStartDate( int m_StartDate ) throws XtumlException;
    public void setLongNumber( String m_LongNumber ) throws XtumlException;
    public void setDescription( String m_Description ) throws XtumlException;
    public void setShortNumber( String m_ShortNumber ) throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setActualStartDate( int m_ActualStartDate ) throws XtumlException;
    public void setBudget( double m_Budget ) throws XtumlException;


    // selections
    public StrategySet R10_implements_Strategy() throws XtumlException;
    public ProjectSet R5_implemented_Project() throws XtumlException;
    public MilestoneSet R60_achieves_Milestone() throws XtumlException;


}
