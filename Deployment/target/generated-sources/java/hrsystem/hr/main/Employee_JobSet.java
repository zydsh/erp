package hrsystem.hr.main;


import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.JobSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Employee_JobSet extends IInstanceSet<Employee_JobSet,Employee_Job> {

    // attributes
    public void setAppointment_Date( int m_Appointment_Date ) throws XtumlException;
    public void setJob_ID( int ref_Job_ID ) throws XtumlException;
    public void setActive( boolean m_Active ) throws XtumlException;
    public void setNational_ID( int ref_National_ID ) throws XtumlException;


    // selections
    public EmployeeSet R1_Employee() throws XtumlException;
    public JobSet R1_Job() throws XtumlException;


}
