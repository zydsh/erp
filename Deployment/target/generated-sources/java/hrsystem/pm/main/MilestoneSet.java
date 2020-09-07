package hrsystem.pm.main;


import hrsystem.pm.main.InitiativeSet;
import hrsystem.pm.main.Supporting_DocumentsSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface MilestoneSet extends IInstanceSet<MilestoneSet,Milestone> {

    // attributes
    public void setWeight( int m_Weight ) throws XtumlException;
    public void setType( String m_Type ) throws XtumlException;
    public void setIncompleteReasons( String m_IncompleteReasons ) throws XtumlException;
    public void setCode( String m_Code ) throws XtumlException;
    public void setCompleteActual( int m_CompleteActual ) throws XtumlException;
    public void setSuccessCriteria( String m_SuccessCriteria ) throws XtumlException;
    public void setFullCode( String m_FullCode ) throws XtumlException;
    public void setSdDescription( String m_sdDescription ) throws XtumlException;
    public void setCompletePlanned( int m_CompletePlanned ) throws XtumlException;
    public void setComplete( boolean m_Complete ) throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setPercentage( double m_Percentage ) throws XtumlException;
    public void setNotes( String m_Notes ) throws XtumlException;
    public void setSdState( String m_sdState ) throws XtumlException;


    // selections
    public Supporting_DocumentsSet R3_completed_with_Supporting_Documents() throws XtumlException;
    public InitiativeSet R60_achieved_by_Initiative() throws XtumlException;


}
