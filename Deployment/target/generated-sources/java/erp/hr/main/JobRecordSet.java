package erp.hr.main;


import erp.hr.main.EmployeeSet;
import erp.hr.main.JobRecordSet;
import erp.hr.main.JobSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface JobRecordSet extends IInstanceSet<JobRecordSet,JobRecord> {

    // attributes
    public void setEndDate( int m_EndDate ) throws XtumlException;
    public void setStartingDate( int m_StartingDate ) throws XtumlException;


    // selections
    public JobRecordSet R17_preceded_by_JobRecord() throws XtumlException;
    public JobRecordSet R17_proceeded_by_JobRecord() throws XtumlException;
    public JobSet R1_occupied_Job() throws XtumlException;
    public EmployeeSet R1_was_assigned_to_Employee() throws XtumlException;


}
