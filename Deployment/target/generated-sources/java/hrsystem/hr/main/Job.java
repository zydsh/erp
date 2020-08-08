package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Employee_Job;
import hrsystem.hr.main.Employee_JobSet;
import hrsystem.hr.main.Grade;
import hrsystem.hr.main.Step;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Job extends IModelInstance<Job,Hr> {

    // attributes
    public void setJob_ID( int m_Job_ID ) throws XtumlException;
    public int getJob_ID() throws XtumlException;
    public void setAmount( double m_Amount ) throws XtumlException;
    public double getAmount() throws XtumlException;
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setGValue( int ref_GValue ) throws XtumlException;
    public int getGValue() throws XtumlException;
    public int getSValue() throws XtumlException;
    public void setSValue( int ref_SValue ) throws XtumlException;


    // operations


    // selections
    default public void addR1_Employee_Job( Employee_Job inst ) {}
    default public void removeR1_Employee_Job( Employee_Job inst ) {}
    public Employee_JobSet R1_Employee_Job() throws XtumlException;
    default public void setR5_Grade( Grade inst ) {}
    public Grade R5_Grade() throws XtumlException;
    default public void setR5_Step( Step inst ) {}
    public Step R5_Step() throws XtumlException;


}
