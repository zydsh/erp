package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.JobRecord;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface JobRecord extends IModelInstance<JobRecord,Hr> {

    // attributes
    public void setEndDate( int m_EndDate ) throws XtumlException;
    public int getEndDate() throws XtumlException;
    public void setStartingDate( int m_StartingDate ) throws XtumlException;
    public int getStartingDate() throws XtumlException;


    // operations


    // selections
    default public void setR17_preceded_by_JobRecord( JobRecord inst ) {}
    public JobRecord R17_preceded_by_JobRecord() throws XtumlException;
    default public void setR17_proceeded_by_JobRecord( JobRecord inst ) {}
    public JobRecord R17_proceeded_by_JobRecord() throws XtumlException;
    default public void setR1_occupied_Job( Job inst ) {}
    public Job R1_occupied_Job() throws XtumlException;
    default public void setR1_was_assigned_to_Employee( Employee inst ) {}
    public Employee R1_was_assigned_to_Employee() throws XtumlException;


}
