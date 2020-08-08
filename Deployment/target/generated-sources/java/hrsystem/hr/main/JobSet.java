package hrsystem.hr.main;


import hrsystem.hr.main.Employee_JobSet;
import hrsystem.hr.main.GradeSet;
import hrsystem.hr.main.StepSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface JobSet extends IInstanceSet<JobSet,Job> {

    // attributes
    public void setGValue( int ref_GValue ) throws XtumlException;
    public void setJob_ID( int m_Job_ID ) throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setSValue( int ref_SValue ) throws XtumlException;
    public void setAmount( double m_Amount ) throws XtumlException;


    // selections
    public Employee_JobSet R1_Employee_Job() throws XtumlException;
    public GradeSet R5_Grade() throws XtumlException;
    public StepSet R5_Step() throws XtumlException;


}
