package hrsystem.hr.main.impl;


import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.Employee_Job;
import hrsystem.hr.main.Employee_JobSet;
import hrsystem.hr.main.JobSet;
import hrsystem.hr.main.impl.EmployeeSetImpl;
import hrsystem.hr.main.impl.JobSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Employee_JobSetImpl extends InstanceSet<Employee_JobSet,Employee_Job> implements Employee_JobSet {

    public Employee_JobSetImpl() {
    }

    public Employee_JobSetImpl(Comparator<? super Employee_Job> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setAppointment_Date( int m_Appointment_Date ) throws XtumlException {
        for ( Employee_Job employee_job : this ) employee_job.setAppointment_Date( m_Appointment_Date );
    }
    @Override
    public void setJob_ID( int ref_Job_ID ) throws XtumlException {
        for ( Employee_Job employee_job : this ) employee_job.setJob_ID( ref_Job_ID );
    }
    @Override
    public void setActive( boolean m_Active ) throws XtumlException {
        for ( Employee_Job employee_job : this ) employee_job.setActive( m_Active );
    }
    @Override
    public void setNational_ID( int ref_National_ID ) throws XtumlException {
        for ( Employee_Job employee_job : this ) employee_job.setNational_ID( ref_National_ID );
    }


    // selections
    @Override
    public EmployeeSet R1_Employee() throws XtumlException {
        EmployeeSet employeeset = new EmployeeSetImpl();
        for ( Employee_Job employee_job : this ) employeeset.add( employee_job.R1_Employee() );
        return employeeset;
    }
    @Override
    public JobSet R1_Job() throws XtumlException {
        JobSet jobset = new JobSetImpl();
        for ( Employee_Job employee_job : this ) jobset.add( employee_job.R1_Job() );
        return jobset;
    }


    @Override
    public Employee_Job nullElement() {
        return Employee_JobImpl.EMPTY_EMPLOYEE_JOB;
    }

    @Override
    public Employee_JobSet emptySet() {
      return new Employee_JobSetImpl();
    }

    @Override
    public Employee_JobSet emptySet(Comparator<? super Employee_Job> comp) {
      return new Employee_JobSetImpl(comp);
    }

    @Override
    public List<Employee_Job> elements() {
        return Arrays.asList(toArray(new Employee_Job[0]));
    }

}
