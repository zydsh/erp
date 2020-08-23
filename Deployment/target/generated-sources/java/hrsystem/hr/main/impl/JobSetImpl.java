package hrsystem.hr.main.impl;


import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.GradeSet;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.JobRecordSet;
import hrsystem.hr.main.JobSet;
import hrsystem.hr.main.impl.EmployeeSetImpl;
import hrsystem.hr.main.impl.GradeSetImpl;
import hrsystem.hr.main.impl.JobRecordSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class JobSetImpl extends InstanceSet<JobSet,Job> implements JobSet {

    public JobSetImpl() {
    }

    public JobSetImpl(Comparator<? super Job> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setPromotionDate( int m_PromotionDate ) throws XtumlException {
        for ( Job job : this ) job.setPromotionDate( m_PromotionDate );
    }
    @Override
    public void setSalary( double m_Salary ) throws XtumlException {
        for ( Job job : this ) job.setSalary( m_Salary );
    }
    @Override
    public void setJob_ID( int m_Job_ID ) throws XtumlException {
        for ( Job job : this ) job.setJob_ID( m_Job_ID );
    }
    @Override
    public void setTitle( String m_Title ) throws XtumlException {
        for ( Job job : this ) job.setTitle( m_Title );
    }
    @Override
    public void setAppointmentDate( int m_AppointmentDate ) throws XtumlException {
        for ( Job job : this ) job.setAppointmentDate( m_AppointmentDate );
    }
    @Override
    public void setPensionDeduction( double m_PensionDeduction ) throws XtumlException {
        for ( Job job : this ) job.setPensionDeduction( m_PensionDeduction );
    }
    @Override
    public void setDescription( int m_Description ) throws XtumlException {
        for ( Job job : this ) job.setDescription( m_Description );
    }
    @Override
    public void setStep( int m_Step ) throws XtumlException {
        for ( Job job : this ) job.setStep( m_Step );
    }


    // selections
    @Override
    public JobRecordSet R1_was_assigned_to_JobRecord() throws XtumlException {
        JobRecordSet jobrecordset = new JobRecordSetImpl();
        for ( Job job : this ) jobrecordset.addAll( job.R1_was_assigned_to_JobRecord() );
        return jobrecordset;
    }
    @Override
    public EmployeeSet R20_to_be_assigned_to_an_Employee() throws XtumlException {
        EmployeeSet employeeset = new EmployeeSetImpl();
        for ( Job job : this ) employeeset.add( job.R20_to_be_assigned_to_an_Employee() );
        return employeeset;
    }
    @Override
    public EmployeeSet R6_is_assigned_to_an_Employee() throws XtumlException {
        EmployeeSet employeeset = new EmployeeSetImpl();
        for ( Job job : this ) employeeset.add( job.R6_is_assigned_to_an_Employee() );
        return employeeset;
    }
    @Override
    public GradeSet R9_assigned_Grade() throws XtumlException {
        GradeSet gradeset = new GradeSetImpl();
        for ( Job job : this ) gradeset.add( job.R9_assigned_Grade() );
        return gradeset;
    }


    @Override
    public Job nullElement() {
        return JobImpl.EMPTY_JOB;
    }

    @Override
    public JobSet emptySet() {
      return new JobSetImpl();
    }

    @Override
    public JobSet emptySet(Comparator<? super Job> comp) {
      return new JobSetImpl(comp);
    }

    @Override
    public List<Job> elements() {
        return Arrays.asList(toArray(new Job[0]));
    }

}
