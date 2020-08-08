package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee_Job;
import hrsystem.hr.main.Employee_JobSet;
import hrsystem.hr.main.Grade;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.Step;
import hrsystem.hr.main.impl.Employee_JobSetImpl;
import hrsystem.hr.main.impl.GradeImpl;
import hrsystem.hr.main.impl.JobImpl;
import hrsystem.hr.main.impl.StepImpl;

import io.ciera.runtime.instanceloading.AttributeChangedDelta;
import io.ciera.runtime.instanceloading.InstanceCreatedDelta;
import io.ciera.runtime.summit.application.ActionHome;
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
        m_Amount = 0d;
        m_Name = "";
        ref_GValue = 0;
        ref_SValue = 0;
        R1_Employee_Job_set = new Employee_JobSetImpl();
        R5_Grade_inst = GradeImpl.EMPTY_GRADE;
        R5_Step_inst = StepImpl.EMPTY_STEP;
    }

    private JobImpl( Hr context, UniqueId instanceId, int m_Job_ID, double m_Amount, String m_Name, int ref_GValue, int ref_SValue ) {
        super(instanceId);
        this.context = context;
        this.m_Job_ID = m_Job_ID;
        this.m_Amount = m_Amount;
        this.m_Name = m_Name;
        this.ref_GValue = ref_GValue;
        this.ref_SValue = ref_SValue;
        R1_Employee_Job_set = new Employee_JobSetImpl();
        R5_Grade_inst = GradeImpl.EMPTY_GRADE;
        R5_Step_inst = StepImpl.EMPTY_STEP;
    }

    public static Job create( Hr context ) throws XtumlException {
        Job newJob = new JobImpl( context );
        if ( context.addInstance( newJob ) ) {
            newJob.getRunContext().addChange(new InstanceCreatedDelta(newJob, KEY_LETTERS));
            return newJob;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Job create( Hr context, UniqueId instanceId, int m_Job_ID, double m_Amount, String m_Name, int ref_GValue, int ref_SValue ) throws XtumlException {
        Job newJob = new JobImpl( context, instanceId, m_Job_ID, m_Amount, m_Name, ref_GValue, ref_SValue );
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
            if ( !R1_Employee_Job().isEmpty() ) R1_Employee_Job().setJob_ID( m_Job_ID );
        }
    }
    @Override
    public int getJob_ID() throws XtumlException {
        checkLiving();
        return m_Job_ID;
    }
    private double m_Amount;
    @Override
    public void setAmount(double m_Amount) throws XtumlException {
        checkLiving();
        if (m_Amount != this.m_Amount) {
            final double oldValue = this.m_Amount;
            this.m_Amount = m_Amount;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Amount", oldValue, this.m_Amount));
        }
    }
    @Override
    public double getAmount() throws XtumlException {
        checkLiving();
        return m_Amount;
    }
    private String m_Name;
    @Override
    public String getName() throws XtumlException {
        checkLiving();
        return m_Name;
    }
    @Override
    public void setName(String m_Name) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Name, this.m_Name)) {
            final String oldValue = this.m_Name;
            this.m_Name = m_Name;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Name", oldValue, this.m_Name));
        }
    }
    private int ref_GValue;
    @Override
    public void setGValue(int ref_GValue) throws XtumlException {
        checkLiving();
        if (ref_GValue != this.ref_GValue) {
            final int oldValue = this.ref_GValue;
            this.ref_GValue = ref_GValue;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "ref_GValue", oldValue, this.ref_GValue));
        }
    }
    @Override
    public int getGValue() throws XtumlException {
        checkLiving();
        return ref_GValue;
    }
    private int ref_SValue;
    @Override
    public int getSValue() throws XtumlException {
        checkLiving();
        return ref_SValue;
    }
    @Override
    public void setSValue(int ref_SValue) throws XtumlException {
        checkLiving();
        if (ref_SValue != this.ref_SValue) {
            final int oldValue = this.ref_SValue;
            this.ref_SValue = ref_SValue;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "ref_SValue", oldValue, this.ref_SValue));
        }
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
    @Override
    public IInstanceIdentifier getId2() {
        try {
            return new InstanceIdentifier(getGValue(), getSValue());
        }
        catch ( XtumlException e ) {
            getRunContext().getLog().error(e);
            System.exit(1);
            return null;
        }
    }

    // operations


    // static operations
    public static class CLASS extends ActionHome<Hr> {

        public CLASS( Hr context ) {
            super( context );
        }

        public void crud( final int p_Step,  final int p_Grade,  final double p_Amount,  final String p_Name,  final String p_Action ) throws XtumlException {
            Grade grade = context().Grade_instances().anyWhere(selected -> ((Grade)selected).getGValue() == p_Grade);
            Step step = context().Step_instances().anyWhere(selected -> ((Step)selected).getSValue() == p_Step);
            Job job = context().Job_instances().anyWhere(selected -> StringUtil.equality(((Job)selected).getName(), p_Name));
            if ( job.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Attempting to add a new Job." );
                Job j = JobImpl.create( context() );
                j.setName(p_Name);
                j.setAmount(p_Amount);
                context().relate_R5_Job_Step( j, step );
                context().relate_R5_Job_Grade( j, grade );
                context().UI().Reply( "Job created successfully.", true );
            }
            else if ( !job.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Attempting to add a new Job." );
                context().LOG().LogInfo( "Job already exists." );
                context().UI().Reply( "Job already exists", false );
            }
            else if ( !job.isEmpty() && StringUtil.equality(p_Action, "UPDATE") ) {
                context().LOG().LogInfo( "Attempting to update Job." );
                job.setName(p_Name);
                job.setAmount(p_Amount);
                context().LOG().LogInfo( "Job updated successfully." );
                context().UI().Reply( "Job updated successfully", true );
            }
            else if ( !job.isEmpty() && StringUtil.equality(p_Action, "DELETE") ) {
                context().LOG().LogInfo( "Attempting to delete a Job instance." );
                context().LOG().LogInfo( "Job delete in not implemented yet." );
                context().UI().Reply( "Job delete in not implemented yet", false );
            }
            else if ( job.isEmpty() ) {
                context().LOG().LogInfo( "Job does not exist." );
                context().UI().Reply( "Job does not exist.", false );
            }
        }



    }


    // events


    // selections
    private Employee_JobSet R1_Employee_Job_set;
    @Override
    public void addR1_Employee_Job( Employee_Job inst ) {
        R1_Employee_Job_set.add(inst);
    }
    @Override
    public void removeR1_Employee_Job( Employee_Job inst ) {
        R1_Employee_Job_set.remove(inst);
    }
    @Override
    public Employee_JobSet R1_Employee_Job() throws XtumlException {
        return R1_Employee_Job_set;
    }
    private Grade R5_Grade_inst;
    @Override
    public void setR5_Grade( Grade inst ) {
        R5_Grade_inst = inst;
    }
    @Override
    public Grade R5_Grade() throws XtumlException {
        return R5_Grade_inst;
    }
    private Step R5_Step_inst;
    @Override
    public void setR5_Step( Step inst ) {
        R5_Step_inst = inst;
    }
    @Override
    public Step R5_Step() throws XtumlException {
        return R5_Step_inst;
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
    public void setAmount( double m_Amount ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getAmount() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setGValue( int ref_GValue ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getGValue() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getSValue() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setSValue( int ref_SValue ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Employee_JobSet R1_Employee_Job() {
        return (new Employee_JobSetImpl());
    }
    @Override
    public Grade R5_Grade() {
        return GradeImpl.EMPTY_GRADE;
    }
    @Override
    public Step R5_Step() {
        return StepImpl.EMPTY_STEP;
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
