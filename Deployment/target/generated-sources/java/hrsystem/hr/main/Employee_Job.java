package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Job;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Employee_Job extends IModelInstance<Employee_Job,Hr> {

    // attributes
    public void setAppointment_Date( int m_Appointment_Date ) throws XtumlException;
    public int getAppointment_Date() throws XtumlException;
    public boolean getActive() throws XtumlException;
    public void setActive( boolean m_Active ) throws XtumlException;
    public void setJob_ID( int ref_Job_ID ) throws XtumlException;
    public int getJob_ID() throws XtumlException;
    public int getNational_ID() throws XtumlException;
    public void setNational_ID( int ref_National_ID ) throws XtumlException;


    // operations


    // selections
    default public void setR1_Employee( Employee inst ) {}
    public Employee R1_Employee() throws XtumlException;
    default public void setR1_Job( Job inst ) {}
    public Job R1_Job() throws XtumlException;


}
