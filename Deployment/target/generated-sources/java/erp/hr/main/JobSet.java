package erp.hr.main;


import erp.hr.main.Employee_JobSet;
import erp.hr.main.GradeSet;
import erp.hr.main.StepSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface JobSet extends IInstanceSet<JobSet,Job> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public void setJob_ID( int m_Job_ID ) throws XtumlException;
    public void setGValue( int ref_GValue ) throws XtumlException;
    public void setSValue( int ref_SValue ) throws XtumlException;
    public void setAmount( double m_Amount ) throws XtumlException;


    // selections
    public Employee_JobSet R1_Employee_Job() throws XtumlException;
    public GradeSet R5_Grade() throws XtumlException;
    public StepSet R5_Step() throws XtumlException;


}
