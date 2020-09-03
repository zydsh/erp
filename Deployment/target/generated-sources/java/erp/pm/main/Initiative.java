package erp.pm.main;


import erp.Pm;
import erp.pm.main.Milestone;
import erp.pm.main.MilestoneSet;
import erp.pm.main.Project;
import erp.pm.main.ProjectSet;
import erp.pm.main.Strategy;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Initiative extends IModelInstance<Initiative,Pm> {

    // attributes
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setShortNumber( String m_ShortNumber ) throws XtumlException;
    public String getShortNumber() throws XtumlException;
    public void setLongNumber( String m_LongNumber ) throws XtumlException;
    public String getLongNumber() throws XtumlException;
    public String getDescription() throws XtumlException;
    public void setDescription( String m_Description ) throws XtumlException;
    public int getStartDate() throws XtumlException;
    public void setStartDate( int m_StartDate ) throws XtumlException;
    public void setActualStartDate( int m_ActualStartDate ) throws XtumlException;
    public int getActualStartDate() throws XtumlException;
    public void setEndDate( int m_EndDate ) throws XtumlException;
    public int getEndDate() throws XtumlException;
    public int getActualEndDate() throws XtumlException;
    public void setActualEndDate( int m_ActualEndDate ) throws XtumlException;
    public double getBudget() throws XtumlException;
    public void setBudget( double m_Budget ) throws XtumlException;


    // operations


    // selections
    default public void setR1_defined_by_Strategy( Strategy inst ) {}
    public Strategy R1_defined_by_Strategy() throws XtumlException;
    default public void addR2_achieves_Milestone( Milestone inst ) {}
    default public void removeR2_achieves_Milestone( Milestone inst ) {}
    public MilestoneSet R2_achieves_Milestone() throws XtumlException;
    default public void addR4_defines_Project( Project inst ) {}
    default public void removeR4_defines_Project( Project inst ) {}
    public ProjectSet R4_defines_Project() throws XtumlException;


}
