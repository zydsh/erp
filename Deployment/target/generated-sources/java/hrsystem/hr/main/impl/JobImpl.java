package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Grade;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.JobRecord;
import hrsystem.hr.main.JobRecordSet;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.GradeImpl;
import hrsystem.hr.main.impl.JobRecordSetImpl;

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
import io.ciera.runtime.summit.types.StringUtil;
import io.ciera.runtime.summit.types.UniqueId;


public class JobImpl extends ModelInstance<Job,Hr> implements Job {

    public static final String KEY_LETTERS = "Job";
    public static final Job EMPTY_JOB = new EmptyJob();

    private Hr context;

    // constructors
    private JobImpl( Hr context ) {
        this.context = context;
        m_Job_ID = 0;
        m_Title = "";
        m_Salary = 0d;
        m_Step = 0;
        m_PensionDeduction = 0d;
        m_Description = 0;
        m_PromotionDate = 0;
        m_AppointmentDate = 0;
        R1_was_assigned_to_JobRecord_set = new JobRecordSetImpl();
        R20_to_be_assigned_to_an_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        R6_is_assigned_to_an_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        R9_assigned_Grade_inst = GradeImpl.EMPTY_GRADE;
    }

    private JobImpl( Hr context, UniqueId instanceId, int m_Job_ID, String m_Title, double m_Salary, int m_Step, double m_PensionDeduction, int m_Description, int m_PromotionDate, int m_AppointmentDate ) {
        super(instanceId);
        this.context = context;
        this.m_Job_ID = m_Job_ID;
        this.m_Title = m_Title;
        this.m_Salary = m_Salary;
        this.m_Step = m_Step;
        this.m_PensionDeduction = m_PensionDeduction;
        this.m_Description = m_Description;
        this.m_PromotionDate = m_PromotionDate;
        this.m_AppointmentDate = m_AppointmentDate;
        R1_was_assigned_to_JobRecord_set = new JobRecordSetImpl();
        R20_to_be_assigned_to_an_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        R6_is_assigned_to_an_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        R9_assigned_Grade_inst = GradeImpl.EMPTY_GRADE;
    }

    public static Job create( Hr context ) throws XtumlException {
        Job newJob = new JobImpl( context );
        if ( context.addInstance( newJob ) ) {
            newJob.getRunContext().addChange(new InstanceCreatedDelta(newJob, KEY_LETTERS));
            return newJob;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Job create( Hr context, UniqueId instanceId, int m_Job_ID, String m_Title, double m_Salary, int m_Step, double m_PensionDeduction, int m_Description, int m_PromotionDate, int m_AppointmentDate ) throws XtumlException {
        Job newJob = new JobImpl( context, instanceId, m_Job_ID, m_Title, m_Salary, m_Step, m_PensionDeduction, m_Description, m_PromotionDate, m_AppointmentDate );
        if ( context.addInstance( newJob ) ) {
            return newJob;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private int m_Job_ID;
    @Override
    public void setJob_ID(int m_Job_ID) throws XtumlException {
        checkLiving();
        if (m_Job_ID != this.m_Job_ID) {
            final int oldValue = this.m_Job_ID;
            this.m_Job_ID = m_Job_ID;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Job_ID", oldValue, this.m_Job_ID));
        }
    }
    @Override
    public int getJob_ID() throws XtumlException {
        checkLiving();
        return m_Job_ID;
    }
    private String m_Title;
    @Override
    public String getTitle() throws XtumlException {
        checkLiving();
        return m_Title;
    }
    @Override
    public void setTitle(String m_Title) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Title, this.m_Title)) {
            final String oldValue = this.m_Title;
            this.m_Title = m_Title;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Title", oldValue, this.m_Title));
        }
    }
    private double m_Salary;
    @Override
    public void setSalary(double m_Salary) throws XtumlException {
        checkLiving();
        if (m_Salary != this.m_Salary) {
            final double oldValue = this.m_Salary;
            this.m_Salary = m_Salary;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Salary", oldValue, this.m_Salary));
        }
    }
    @Override
    public double getSalary() throws XtumlException {
        checkLiving();
        {
            Grade grade = self().R9_assigned_Grade();
            self().setSalary(grade.getAllowance() * self().getStep() + grade.getBaseSalary());
        }
        return m_Salary;
    }
    private int m_Step;
    @Override
    public int getStep() throws XtumlException {
        checkLiving();
        return m_Step;
    }
    @Override
    public void setStep(int m_Step) throws XtumlException {
        checkLiving();
        if (m_Step != this.m_Step) {
            final int oldValue = this.m_Step;
            this.m_Step = m_Step;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Step", oldValue, this.m_Step));
        }
    }
    private double m_PensionDeduction;
    @Override
    public double getPensionDeduction() throws XtumlException {
        checkLiving();
        return m_PensionDeduction;
    }
    @Override
    public void setPensionDeduction(double m_PensionDeduction) throws XtumlException {
        checkLiving();
        if (m_PensionDeduction != this.m_PensionDeduction) {
            final double oldValue = this.m_PensionDeduction;
            this.m_PensionDeduction = m_PensionDeduction;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_PensionDeduction", oldValue, this.m_PensionDeduction));
        }
    }
    private int m_Description;
    @Override
    public int getDescription() throws XtumlException {
        checkLiving();
        return m_Description;
    }
    @Override
    public void setDescription(int m_Description) throws XtumlException {
        checkLiving();
        if (m_Description != this.m_Description) {
            final int oldValue = this.m_Description;
            this.m_Description = m_Description;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Description", oldValue, this.m_Description));
        }
    }
    private int m_PromotionDate;
    @Override
    public void setPromotionDate(int m_PromotionDate) throws XtumlException {
        checkLiving();
        if (m_PromotionDate != this.m_PromotionDate) {
            final int oldValue = this.m_PromotionDate;
            this.m_PromotionDate = m_PromotionDate;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_PromotionDate", oldValue, this.m_PromotionDate));
        }
    }
    @Override
    public int getPromotionDate() throws XtumlException {
        checkLiving();
        return m_PromotionDate;
    }
    private int m_AppointmentDate;
    @Override
    public void setAppointmentDate(int m_AppointmentDate) throws XtumlException {
        checkLiving();
        if (m_AppointmentDate != this.m_AppointmentDate) {
            final int oldValue = this.m_AppointmentDate;
            this.m_AppointmentDate = m_AppointmentDate;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_AppointmentDate", oldValue, this.m_AppointmentDate));
        }
    }
    @Override
    public int getAppointmentDate() throws XtumlException {
        checkLiving();
        return m_AppointmentDate;
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getJob_ID());
        }
        catch ( XtumlException e ) {
            getRunContext().getLog().error(e);
            System.exit(1);
            return null;
        }
    }

    // operations


    // static operations


    // events


    // selections
    private JobRecordSet R1_was_assigned_to_JobRecord_set;
    @Override
    public void addR1_was_assigned_to_JobRecord( JobRecord inst ) {
        R1_was_assigned_to_JobRecord_set.add(inst);
    }
    @Override
    public void removeR1_was_assigned_to_JobRecord( JobRecord inst ) {
        R1_was_assigned_to_JobRecord_set.remove(inst);
    }
    @Override
    public JobRecordSet R1_was_assigned_to_JobRecord() throws XtumlException {
        return R1_was_assigned_to_JobRecord_set;
    }
    private Employee R20_to_be_assigned_to_an_Employee_inst;
    @Override
    public void setR20_to_be_assigned_to_an_Employee( Employee inst ) {
        R20_to_be_assigned_to_an_Employee_inst = inst;
    }
    @Override
    public Employee R20_to_be_assigned_to_an_Employee() throws XtumlException {
        return R20_to_be_assigned_to_an_Employee_inst;
    }
    private Employee R6_is_assigned_to_an_Employee_inst;
    @Override
    public void setR6_is_assigned_to_an_Employee( Employee inst ) {
        R6_is_assigned_to_an_Employee_inst = inst;
    }
    @Override
    public Employee R6_is_assigned_to_an_Employee() throws XtumlException {
        return R6_is_assigned_to_an_Employee_inst;
    }
    private Grade R9_assigned_Grade_inst;
    @Override
    public void setR9_assigned_Grade( Grade inst ) {
        R9_assigned_Grade_inst = inst;
    }
    @Override
    public Grade R9_assigned_Grade() throws XtumlException {
        return R9_assigned_Grade_inst;
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
    public Job self() {
        return this;
    }

    @Override
    public Job oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_JOB;
    }

}

class EmptyJob extends ModelInstance<Job,Hr> implements Job {

    // attributes
    public void setJob_ID( int m_Job_ID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getJob_ID() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public String getTitle() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setTitle( String m_Title ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setSalary( double m_Salary ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getSalary() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getStep() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setStep( int m_Step ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getPensionDeduction() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setPensionDeduction( double m_PensionDeduction ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getDescription() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setDescription( int m_Description ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setPromotionDate( int m_PromotionDate ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getPromotionDate() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setAppointmentDate( int m_AppointmentDate ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getAppointmentDate() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public JobRecordSet R1_was_assigned_to_JobRecord() {
        return (new JobRecordSetImpl());
    }
    @Override
    public Employee R20_to_be_assigned_to_an_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }
    @Override
    public Employee R6_is_assigned_to_an_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }
    @Override
    public Grade R9_assigned_Grade() {
        return GradeImpl.EMPTY_GRADE;
    }


    @Override
    public String getKeyLetters() {
        return JobImpl.KEY_LETTERS;
    }

    @Override
    public Job self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Job oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return JobImpl.EMPTY_JOB;
    }

}
