package hrsystem.hr.main;


import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.JobSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Employee_JobSet extends IInstanceSet<Employee_JobSet,Employee_Job> {

    // attributes
    public void setActive( boolean m_Active ) throws XtumlException;
    public void setAppointment_Date( int m_Appointment_Date ) throws XtumlException;


    // selections
    public EmployeeSet R1_Employee() throws XtumlException;
    public JobSet R1_Job() throws XtumlException;


}
