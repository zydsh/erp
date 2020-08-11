package hrsystem.pm.main;


import hrsystem.pm.main.InitiativeSet;
import hrsystem.pm.main.Supporting_DocumentsSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface MilestoneSet extends IInstanceSet<MilestoneSet,Milestone> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public void setComplete( int m_Complete ) throws XtumlException;
    public void setCode( String m_Code ) throws XtumlException;
    public void setSd_Description( String m_sd_Description ) throws XtumlException;
    public void setNotes( String m_Notes ) throws XtumlException;
    public void setWeight( int m_Weight ) throws XtumlException;
    public void setType( String m_Type ) throws XtumlException;
    public void setSuccess_Criteria( String m_Success_Criteria ) throws XtumlException;
    public void setPercentage( int m_Percentage ) throws XtumlException;
    public void setComplete_Planned( int m_Complete_Planned ) throws XtumlException;
    public void setSd_State( String m_sd_State ) throws XtumlException;
    public void setComplete_Actual( int m_Complete_Actual ) throws XtumlException;
    public void setFull_Code( String m_Full_Code ) throws XtumlException;
    public void setIncomplete_Reasons( String m_Incomplete_Reasons ) throws XtumlException;


    // selections
    public InitiativeSet R2_Initiative() throws XtumlException;
    public Supporting_DocumentsSet R3_Supporting_Documents() throws XtumlException;


}
