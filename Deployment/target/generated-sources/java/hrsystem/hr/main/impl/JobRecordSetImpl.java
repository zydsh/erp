package hrsystem.hr.main.impl;


import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.JobRecord;
import hrsystem.hr.main.JobRecordSet;
import hrsystem.hr.main.JobSet;
import hrsystem.hr.main.impl.EmployeeSetImpl;
import hrsystem.hr.main.impl.JobRecordSetImpl;
import hrsystem.hr.main.impl.JobSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class JobRecordSetImpl extends InstanceSet<JobRecordSet,JobRecord> implements JobRecordSet {

    public JobRecordSetImpl() {
    }

    public JobRecordSetImpl(Comparator<? super JobRecord> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setStartingDate( int m_StartingDate ) throws XtumlException {
        for ( JobRecord jobrecord : this ) jobrecord.setStartingDate( m_StartingDate );
    }
    @Override
    public void setEndDate( int m_EndDate ) throws XtumlException {
        for ( JobRecord jobrecord : this ) jobrecord.setEndDate( m_EndDate );
    }


    // selections
    @Override
    public JobRecordSet R17_preceded_by_JobRecord() throws XtumlException {
        JobRecordSet jobrecordset = new JobRecordSetImpl();
        for ( JobRecord jobrecord : this ) jobrecordset.add( jobrecord.R17_preceded_by_JobRecord() );
        return jobrecordset;
    }
    @Override
    public JobRecordSet R17_proceeded_by_JobRecord() throws XtumlException {
        JobRecordSet jobrecordset = new JobRecordSetImpl();
        for ( JobRecord jobrecord : this ) jobrecordset.add( jobrecord.R17_proceeded_by_JobRecord() );
        return jobrecordset;
    }
    @Override
    public JobSet R1_occupied_Job() throws XtumlException {
        JobSet jobset = new JobSetImpl();
        for ( JobRecord jobrecord : this ) jobset.add( jobrecord.R1_occupied_Job() );
        return jobset;
    }
    @Override
    public EmployeeSet R1_was_assigned_to_Employee() throws XtumlException {
        EmployeeSet employeeset = new EmployeeSetImpl();
        for ( JobRecord jobrecord : this ) employeeset.add( jobrecord.R1_was_assigned_to_Employee() );
        return employeeset;
    }


    @Override
    public JobRecord nullElement() {
        return JobRecordImpl.EMPTY_JOBRECORD;
    }

    @Override
    public JobRecordSet emptySet() {
      return new JobRecordSetImpl();
    }

    @Override
    public JobRecordSet emptySet(Comparator<? super JobRecord> comp) {
      return new JobRecordSetImpl(comp);
    }

    @Override
    public List<JobRecord> elements() {
        return Arrays.asList(toArray(new JobRecord[0]));
    }

}
