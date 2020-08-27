package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.JobRecord;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.JobImpl;
import hrsystem.hr.main.impl.JobRecordImpl;

import io.ciera.runtime.instanceloading.AttributeChangedDelta;
import io.ciera.runtime.instanceloading.InstanceCreatedDelta;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.classes.IInstanceIdentifier;
import io.ciera.runtime.summit.classes.InstanceIdentifier;
import io.ciera.runtime.summit.classes.ModelInstance;
import io.ciera.runtime.summit.exceptions.EmptyInstanceException;
import io.ciera.runtime.summit.exceptions.InstancePopulationException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.IWhere;
import io.ciera.runtime.summit.types.IXtumlType;
import io.ciera.runtime.summit.types.UniqueId;


public class JobRecordImpl extends ModelInstance<JobRecord,Hr> implements JobRecord {

    public static final String KEY_LETTERS = "EJ";
    public static final JobRecord EMPTY_JOBRECORD = new EmptyJobRecord();

    private Hr context;

    // constructors
    private JobRecordImpl( Hr context ) {
        this.context = context;
        m_EndDate = 0;
        m_StartingDate = 0;
        R17_preceded_by_JobRecord_inst = JobRecordImpl.EMPTY_JOBRECORD;
        R17_proceeded_by_JobRecord_inst = JobRecordImpl.EMPTY_JOBRECORD;
        R1_occupied_Job_inst = JobImpl.EMPTY_JOB;
        R1_was_assigned_to_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
    }

    private JobRecordImpl( Hr context, UniqueId instanceId, int m_EndDate, int m_StartingDate ) {
        super(instanceId);
        this.context = context;
        this.m_EndDate = m_EndDate;
        this.m_StartingDate = m_StartingDate;
        R17_preceded_by_JobRecord_inst = JobRecordImpl.EMPTY_JOBRECORD;
        R17_proceeded_by_JobRecord_inst = JobRecordImpl.EMPTY_JOBRECORD;
        R1_occupied_Job_inst = JobImpl.EMPTY_JOB;
        R1_was_assigned_to_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
    }

    public static JobRecord create( Hr context ) throws XtumlException {
        JobRecord newJobRecord = new JobRecordImpl( context );
        if ( context.addInstance( newJobRecord ) ) {
            newJobRecord.getRunContext().addChange(new InstanceCreatedDelta(newJobRecord, KEY_LETTERS));
            return newJobRecord;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static JobRecord create( Hr context, UniqueId instanceId, int m_EndDate, int m_StartingDate ) throws XtumlException {
        JobRecord newJobRecord = new JobRecordImpl( context, instanceId, m_EndDate, m_StartingDate );
        if ( context.addInstance( newJobRecord ) ) {
            return newJobRecord;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private int m_EndDate;
    @Override
    public void setEndDate(int m_EndDate) throws XtumlException {
        checkLiving();
        if (m_EndDate != this.m_EndDate) {
            final int oldValue = this.m_EndDate;
            this.m_EndDate = m_EndDate;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_EndDate", oldValue, this.m_EndDate));
        }
    }
    @Override
    public int getEndDate() throws XtumlException {
        checkLiving();
        return m_EndDate;
    }
    private int m_StartingDate;
    @Override
    public void setStartingDate(int m_StartingDate) throws XtumlException {
        checkLiving();
        if (m_StartingDate != this.m_StartingDate) {
            final int oldValue = this.m_StartingDate;
            this.m_StartingDate = m_StartingDate;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_StartingDate", oldValue, this.m_StartingDate));
        }
    }
    @Override
    public int getStartingDate() throws XtumlException {
        checkLiving();
        return m_StartingDate;
    }


    // instance identifiers

    // operations


    // static operations


    // events


    // selections
    private JobRecord R17_preceded_by_JobRecord_inst;
    @Override
    public void setR17_preceded_by_JobRecord( JobRecord inst ) {
        R17_preceded_by_JobRecord_inst = inst;
    }
    @Override
    public JobRecord R17_preceded_by_JobRecord() throws XtumlException {
        return R17_preceded_by_JobRecord_inst;
    }
    private JobRecord R17_proceeded_by_JobRecord_inst;
    @Override
    public void setR17_proceeded_by_JobRecord( JobRecord inst ) {
        R17_proceeded_by_JobRecord_inst = inst;
    }
    @Override
    public JobRecord R17_proceeded_by_JobRecord() throws XtumlException {
        return R17_proceeded_by_JobRecord_inst;
    }
    private Job R1_occupied_Job_inst;
    @Override
    public void setR1_occupied_Job( Job inst ) {
        R1_occupied_Job_inst = inst;
    }
    @Override
    public Job R1_occupied_Job() throws XtumlException {
        return R1_occupied_Job_inst;
    }
    private Employee R1_was_assigned_to_Employee_inst;
    @Override
    public void setR1_was_assigned_to_Employee( Employee inst ) {
        R1_was_assigned_to_Employee_inst = inst;
    }
    @Override
    public Employee R1_was_assigned_to_Employee() throws XtumlException {
        return R1_was_assigned_to_Employee_inst;
    }


    @Override
    public IRunContext getRunContext() {
        return context().getRunContext();
    }

    @Override
    public Hr context() {
        return context;
    }

    @Override
    public String getKeyLetters() {
        return KEY_LETTERS;
    }

    @Override
    public JobRecord self() {
        return this;
    }

    @Override
    public JobRecord oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_JOBRECORD;
    }

}

class EmptyJobRecord extends ModelInstance<JobRecord,Hr> implements JobRecord {

    // attributes
    public void setEndDate( int m_EndDate ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getEndDate() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setStartingDate( int m_StartingDate ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getStartingDate() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public JobRecord R17_preceded_by_JobRecord() {
        return JobRecordImpl.EMPTY_JOBRECORD;
    }
    @Override
    public JobRecord R17_proceeded_by_JobRecord() {
        return JobRecordImpl.EMPTY_JOBRECORD;
    }
    @Override
    public Job R1_occupied_Job() {
        return JobImpl.EMPTY_JOB;
    }
    @Override
    public Employee R1_was_assigned_to_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }


    @Override
    public String getKeyLetters() {
        return JobRecordImpl.KEY_LETTERS;
    }

    @Override
    public JobRecord self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public JobRecord oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return JobRecordImpl.EMPTY_JOBRECORD;
    }

}
