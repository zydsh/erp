package erp.pm.main;


import erp.Pm;
import erp.pm.main.Initiative;
import erp.pm.main.Supporting_Documents;
import erp.pm.main.Supporting_DocumentsSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Milestone extends IModelInstance<Milestone,Pm> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public String getName() throws XtumlException;
    public String getFull_Code() throws XtumlException;
    public void setFull_Code( String m_Full_Code ) throws XtumlException;
    public void setCode( String m_Code ) throws XtumlException;
    public String getCode() throws XtumlException;
    public String getType() throws XtumlException;
    public void setType( String m_Type ) throws XtumlException;
    public void setSuccess_Criteria( String m_Success_Criteria ) throws XtumlException;
    public String getSuccess_Criteria() throws XtumlException;
    public int getComplete_Planned() throws XtumlException;
    public void setComplete_Planned( int m_Complete_Planned ) throws XtumlException;
    public int getComplete_Actual() throws XtumlException;
    public void setComplete_Actual( int m_Complete_Actual ) throws XtumlException;
    public int getComplete() throws XtumlException;
    public void setComplete( int m_Complete ) throws XtumlException;
    public void setWeight( int m_Weight ) throws XtumlException;
    public int getWeight() throws XtumlException;
    public void setPercentage( int m_Percentage ) throws XtumlException;
    public int getPercentage() throws XtumlException;
    public String getSd_State() throws XtumlException;
    public void setSd_State( String m_sd_State ) throws XtumlException;
    public String getSd_Description() throws XtumlException;
    public void setSd_Description( String m_sd_Description ) throws XtumlException;
    public void setNotes( String m_Notes ) throws XtumlException;
    public String getNotes() throws XtumlException;
    public void setIncomplete_Reasons( String m_Incomplete_Reasons ) throws XtumlException;
    public String getIncomplete_Reasons() throws XtumlException;


    // operations


    // selections
    default public void setR2_achieved_by_Initiative( Initiative inst ) {}
    public Initiative R2_achieved_by_Initiative() throws XtumlException;
    default public void addR3_completed_with_Supporting_Documents( Supporting_Documents inst ) {}
    default public void removeR3_completed_with_Supporting_Documents( Supporting_Documents inst ) {}
    public Supporting_DocumentsSet R3_completed_with_Supporting_Documents() throws XtumlException;


}
