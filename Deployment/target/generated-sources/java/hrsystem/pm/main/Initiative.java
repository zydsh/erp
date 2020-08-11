package hrsystem.pm.main;


import hrsystem.Pm;
import hrsystem.pm.main.Milestone;
import hrsystem.pm.main.MilestoneSet;
import hrsystem.pm.main.Strategy;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Initiative extends IModelInstance<Initiative,Pm> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public String getName() throws XtumlException;
    public void setShort_Number( String m_Short_Number ) throws XtumlException;
    public String getShort_Number() throws XtumlException;
    public String getLong_Number() throws XtumlException;
    public void setLong_Number( String m_Long_Number ) throws XtumlException;
    public void setDescription( String m_Description ) throws XtumlException;
    public String getDescription() throws XtumlException;
    public int getStart_Date() throws XtumlException;
    public void setStart_Date( int m_Start_Date ) throws XtumlException;
    public void setActual_Start_Date( int m_Actual_Start_Date ) throws XtumlException;
    public int getActual_Start_Date() throws XtumlException;
    public int getEnd_Date() throws XtumlException;
    public void setEnd_Date( int m_End_Date ) throws XtumlException;
    public void setBudget( double m_Budget ) throws XtumlException;
    public double getBudget() throws XtumlException;


    // operations


    // selections
    default public void setR1_Strategy( Strategy inst ) {}
    public Strategy R1_Strategy() throws XtumlException;
    default public void addR2_Milestone( Milestone inst ) {}
    default public void removeR2_Milestone( Milestone inst ) {}
    public MilestoneSet R2_Milestone() throws XtumlException;


}
