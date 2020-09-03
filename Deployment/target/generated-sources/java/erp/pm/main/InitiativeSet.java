package erp.pm.main;


import erp.pm.main.MilestoneSet;
import erp.pm.main.ProjectSet;
import erp.pm.main.StrategySet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface InitiativeSet extends IInstanceSet<InitiativeSet,Initiative> {

    // attributes
    public void setEndDate( int m_EndDate ) throws XtumlException;
    public void setLongNumber( String m_LongNumber ) throws XtumlException;
    public void setActualStartDate( int m_ActualStartDate ) throws XtumlException;
    public void setBudget( double m_Budget ) throws XtumlException;
    public void setStartDate( int m_StartDate ) throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setDescription( String m_Description ) throws XtumlException;
    public void setActualEndDate( int m_ActualEndDate ) throws XtumlException;
    public void setShortNumber( String m_ShortNumber ) throws XtumlException;


    // selections
    public StrategySet R1_defined_by_Strategy() throws XtumlException;
    public MilestoneSet R2_achieves_Milestone() throws XtumlException;
    public ProjectSet R4_defines_Project() throws XtumlException;


}
