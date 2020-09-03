package hrsystem.pm.main;


import hrsystem.Pm;
import hrsystem.pm.main.Milestone;
import hrsystem.pm.main.MilestoneSet;
import hrsystem.pm.main.Project;
import hrsystem.pm.main.ProjectSet;
import hrsystem.pm.main.Strategy;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Initiative extends IModelInstance<Initiative,Pm> {

    // attributes
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setShortNumber( String m_ShortNumber ) throws XtumlException;
    public String getShortNumber() throws XtumlException;
    public String getLongNumber() throws XtumlException;
    public void setLongNumber( String m_LongNumber ) throws XtumlException;
    public void setDescription( String m_Description ) throws XtumlException;
    public String getDescription() throws XtumlException;
    public int getStartDate() throws XtumlException;
    public void setStartDate( int m_StartDate ) throws XtumlException;
    public void setActualStartDate( int m_ActualStartDate ) throws XtumlException;
    public int getActualStartDate() throws XtumlException;
    public int getEndDate() throws XtumlException;
    public void setEndDate( int m_EndDate ) throws XtumlException;
    public void setActualEndDate( int m_ActualEndDate ) throws XtumlException;
    public int getActualEndDate() throws XtumlException;
    public void setBudget( double m_Budget ) throws XtumlException;
    public double getBudget() throws XtumlException;


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
