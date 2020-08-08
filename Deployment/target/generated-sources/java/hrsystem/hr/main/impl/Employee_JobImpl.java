package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Employee_Job;
import hrsystem.hr.main.Employee_JobSet;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.Employee_JobImpl;
import hrsystem.hr.main.impl.JobImpl;

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

import java.util.Iterator;


public class Employee_JobImpl extends ModelInstance<Employee_Job,Hr> implements Employee_Job {

    public static final String KEY_LETTERS = "EJ";
    public static final Employee_Job EMPTY_EMPLOYEE_JOB = new EmptyEmployee_Job();

    private Hr context;

    // constructors
    private Employee_JobImpl( Hr context ) {
        this.context = context;
        m_Appointment_Date = 0;
        m_Active = false;
        ref_Job_ID = 0;
        ref_National_ID = 0;
        R1_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        R1_Job_inst = JobImpl.EMPTY_JOB;
    }

    private Employee_JobImpl( Hr context, UniqueId instanceId, int m_Appointment_Date, boolean m_Active, int ref_Job_ID, int ref_National_ID ) {
        super(instanceId);
        this.context = context;
        this.m_Appointment_Date = m_Appointment_Date;
        this.m_Active = m_Active;
        this.ref_Job_ID = ref_Job_ID;
        this.ref_National_ID = ref_National_ID;
        R1_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        R1_Job_inst = JobImpl.EMPTY_JOB;
    }

    public static Employee_Job create( Hr context ) throws XtumlException {
        Employee_Job newEmployee_Job = new Employee_JobImpl( context );
        if ( context.addInstance( newEmployee_Job ) ) {
            newEmployee_Job.getRunContext().addChange(new InstanceCreatedDelta(newEmployee_Job, KEY_LETTERS));
            return newEmployee_Job;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Employee_Job create( Hr context, UniqueId instanceId, int m_Appointment_Date, boolean m_Active, int ref_Job_ID, int ref_National_ID ) throws XtumlException {
        Employee_Job newEmployee_Job = new Employee_JobImpl( context, instanceId, m_Appointment_Date, m_Active, ref_Job_ID, ref_National_ID );
        if ( context.addInstance( newEmployee_Job ) ) {
            return newEmployee_Job;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private int m_Appointment_Date;
    @Override
    public void setAppointment_Date(int m_Appointment_Date) throws XtumlException {
        checkLiving();
        if (m_Appointment_Date != this.m_Appointment_Date) {
            final int oldValue = this.m_Appointment_Date;
            this.m_Appointment_Date = m_Appointment_Date;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Appointment_Date", oldValue, this.m_Appointment_Date));
        }
    }
    @Override
    public int getAppointment_Date() throws XtumlException {
        checkLiving();
        return m_Appointment_Date;
    }
    private boolean m_Active;
    @Override
    public boolean getActive() throws XtumlException {
        checkLiving();
        return m_Active;
    }
    @Override
    public void setActive(boolean m_Active) throws XtumlException {
        checkLiving();
        if (m_Active != this.m_Active) {
            final boolean oldValue = this.m_Active;
            this.m_Active = m_Active;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Active", oldValue, this.m_Active));
        }
    }
    private int ref_Job_ID;
    @Override
    public void setJob_ID(int ref_Job_ID) throws XtumlException {
        checkLiving();
        if (ref_Job_ID != this.ref_Job_ID) {
            final int oldValue = this.ref_Job_ID;
            this.ref_Job_ID = ref_Job_ID;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "ref_Job_ID", oldValue, this.ref_Job_ID));
        }
    }
    @Override
    public int getJob_ID() throws XtumlException {
        checkLiving();
        return ref_Job_ID;
    }
    private int ref_National_ID;
    @Override
    public int getNational_ID() throws XtumlException {
        checkLiving();
        return ref_National_ID;
    }
    @Override
    public void setNational_ID(int ref_National_ID) throws XtumlException {
        checkLiving();
        if (ref_National_ID != this.ref_National_ID) {
            final int oldValue = this.ref_National_ID;
            this.ref_National_ID = ref_National_ID;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "ref_National_ID", oldValue, this.ref_National_ID));
        }
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getJob_ID(), getNational_ID());
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

        public void crud( final int p_National_ID,  final int p_Job_ID,  final String p_Action,  final boolean p_Active ) throws XtumlException {
            Employee employee = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getNational_ID() == p_National_ID);
            Job job = context().Job_instances().anyWhere(selected -> ((Job)selected).getJob_ID() == p_Job_ID);
            Employee_JobSet ej = ((Employee_JobSet)context().Employee_Job_instances().where(selected -> ((Employee_Job)selected).getJob_ID() == p_Job_ID && ((Employee_Job)selected).getNational_ID() == p_National_ID));
            if ( ej.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Attempting to add a job/position to employee." );
                Employee_Job employeePosition = Employee_JobImpl.create( context() );
                context().relate_R1_Employee_Job_Employee( employeePosition, employee );
                context().relate_R1_Employee_Job_Job( employeePosition, job );
                employeePosition.setActive(true);
                employeePosition.setAppointment_Date(context().TIM().current_seconds());
                context().UI().Reply( "job/position created successfully.", true );
            }
            else if ( !ej.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Attempting to add a job/position to employee." );
                Employee_Job employeePosition = Employee_JobImpl.create( context() );
                context().relate_R1_Employee_Job_Employee( employeePosition, employee );
                context().relate_R1_Employee_Job_Job( employeePosition, job );
                employeePosition.setActive(false);
                employeePosition.setAppointment_Date(context().TIM().current_seconds());
                context().LOG().LogInfo( "Job/position assigned but inactive." );
                context().UI().Reply( "Job/position assigned but inactive", true );
            }
            else if ( !ej.isEmpty() && StringUtil.equality(p_Action, "UPDATE") ) {
                context().LOG().LogInfo( "Attempting to update job/position." );
                Employee_Job position;
                for ( Iterator<Employee_Job> _position_iter = ej.elements().iterator(); _position_iter.hasNext(); ) {
                    position = _position_iter.next();
                    if ( position.getActive() == true ) {
                        Employee_Job current_position = position;
                        current_position.setActive(p_Active);
                    }
                }
                context().LOG().LogInfo( "Updated job/position successfully." );
                context().UI().Reply( "Updated job/position successfully.", true );
            }
            else if ( !ej.isEmpty() && StringUtil.equality(p_Action, "DELETE") ) {
                context().LOG().LogInfo( "Attempting to delete a job/position instance." );
                context().LOG().LogInfo( "job/position delete in not implemented yet." );
                context().UI().Reply( "job/position delete in not implemented yet", false );
            }
            else if ( ej.isEmpty() ) {
                context().LOG().LogInfo( "Action is not recognized, please check required action." );
                context().UI().Reply( "Action is not recognized, please check required action.", false );
            }
        }



    }


    // events


    // selections
    private Employee R1_Employee_inst;
    @Override
    public void setR1_Employee( Employee inst ) {
        R1_Employee_inst = inst;
    }
    @Override
    public Employee R1_Employee() throws XtumlException {
        return R1_Employee_inst;
    }
    private Job R1_Job_inst;
    @Override
    public void setR1_Job( Job inst ) {
        R1_Job_inst = inst;
    }
    @Override
    public Job R1_Job() throws XtumlException {
        return R1_Job_inst;
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
    public Employee_Job self() {
        return this;
    }

    @Override
    public Employee_Job oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_EMPLOYEE_JOB;
    }

}

class EmptyEmployee_Job extends ModelInstance<Employee_Job,Hr> implements Employee_Job {

    // attributes
    public void setAppointment_Date( int m_Appointment_Date ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getAppointment_Date() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public boolean getActive() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setActive( boolean m_Active ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setJob_ID( int ref_Job_ID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getJob_ID() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getNational_ID() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setNational_ID( int ref_National_ID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Employee R1_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }
    @Override
    public Job R1_Job() {
        return JobImpl.EMPTY_JOB;
    }


    @Override
    public String getKeyLetters() {
        return Employee_JobImpl.KEY_LETTERS;
    }

    @Override
    public Employee_Job self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Employee_Job oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return Employee_JobImpl.EMPTY_EMPLOYEE_JOB;
    }

}
