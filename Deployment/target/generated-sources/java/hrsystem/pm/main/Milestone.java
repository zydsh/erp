package hrsystem.pm.main;


import hrsystem.Pm;
import hrsystem.pm.main.Initiative;
import hrsystem.pm.main.Supporting_Documents;
import hrsystem.pm.main.Supporting_DocumentsSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Milestone extends IModelInstance<Milestone,Pm> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public String getName() throws XtumlException;
    public void setFullCode( String m_FullCode ) throws XtumlException;
    public String getFullCode() throws XtumlException;
    public void setCode( String m_Code ) throws XtumlException;
    public String getCode() throws XtumlException;
    public void setType( String m_Type ) throws XtumlException;
    public String getType() throws XtumlException;
    public String getSuccessCriteria() throws XtumlException;
    public void setSuccessCriteria( String m_SuccessCriteria ) throws XtumlException;
    public int getCompletePlanned() throws XtumlException;
    public void setCompletePlanned( int m_CompletePlanned ) throws XtumlException;
    public int getCompleteActual() throws XtumlException;
    public void setCompleteActual( int m_CompleteActual ) throws XtumlException;
    public boolean getComplete() throws XtumlException;
    public void setComplete( boolean m_Complete ) throws XtumlException;
    public int getWeight() throws XtumlException;
    public void setWeight( int m_Weight ) throws XtumlException;
    public void setPercentage( double m_Percentage ) throws XtumlException;
    public double getPercentage() throws XtumlException;
    public void setSdState( String m_sdState ) throws XtumlException;
    public String getSdState() throws XtumlException;
    public void setSdDescription( String m_sdDescription ) throws XtumlException;
    public String getSdDescription() throws XtumlException;
    public void setNotes( String m_Notes ) throws XtumlException;
    public String getNotes() throws XtumlException;
    public void setIncompleteReasons( String m_IncompleteReasons ) throws XtumlException;
    public String getIncompleteReasons() throws XtumlException;


    // operations


    // selections
    default public void addR3_completed_with_Supporting_Documents( Supporting_Documents inst ) {}
    default public void removeR3_completed_with_Supporting_Documents( Supporting_Documents inst ) {}
    public Supporting_DocumentsSet R3_completed_with_Supporting_Documents() throws XtumlException;
    default public void setR60_achieved_by_Initiative( Initiative inst ) {}
    public Initiative R60_achieved_by_Initiative() throws XtumlException;


}
