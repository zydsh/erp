package hrsystem.pm.main;


import hrsystem.pm.main.MilestoneSet;
import hrsystem.pm.main.StrategySet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface InitiativeSet extends IInstanceSet<InitiativeSet,Initiative> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public void setBudget( double m_Budget ) throws XtumlException;
    public void setActual_End_Date( int m_Actual_End_Date ) throws XtumlException;
    public void setDescription( String m_Description ) throws XtumlException;
    public void setLong_Number( String m_Long_Number ) throws XtumlException;
    public void setActual_Start_Date( int m_Actual_Start_Date ) throws XtumlException;
    public void setShort_Number( String m_Short_Number ) throws XtumlException;
    public void setEnd_Date( int m_End_Date ) throws XtumlException;
    public void setStart_Date( int m_Start_Date ) throws XtumlException;


    // selections
    public StrategySet R1_Strategy() throws XtumlException;
    public MilestoneSet R2_Milestone() throws XtumlException;


}
