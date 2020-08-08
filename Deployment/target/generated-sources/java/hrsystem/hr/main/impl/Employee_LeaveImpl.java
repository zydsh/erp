package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Employee_Leave;
import hrsystem.hr.main.Leave;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.LeaveImpl;

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


public class Employee_LeaveImpl extends ModelInstance<Employee_Leave,Hr> implements Employee_Leave {

    public static final String KEY_LETTERS = "Employee_Leave";
    public static final Employee_Leave EMPTY_EMPLOYEE_LEAVE = new EmptyEmployee_Leave();

    private Hr context;

    // constructors
    private Employee_LeaveImpl( Hr context ) {
        this.context = context;
        m_Starting = 0;
        m_Ending = 0;
        m_Approved = false;
        ref_National_ID = 0;
        ref_Leave_ID = 0;
        R2_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        R2_Leave_inst = LeaveImpl.EMPTY_LEAVE;
    }

    private Employee_LeaveImpl( Hr context, UniqueId instanceId, int m_Starting, int m_Ending, boolean m_Approved, int ref_National_ID, int ref_Leave_ID ) {
        super(instanceId);
        this.context = context;
        this.m_Starting = m_Starting;
        this.m_Ending = m_Ending;
        this.m_Approved = m_Approved;
        this.ref_National_ID = ref_National_ID;
        this.ref_Leave_ID = ref_Leave_ID;
        R2_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        R2_Leave_inst = LeaveImpl.EMPTY_LEAVE;
    }

    public static Employee_Leave create( Hr context ) throws XtumlException {
        Employee_Leave newEmployee_Leave = new Employee_LeaveImpl( context );
        if ( context.addInstance( newEmployee_Leave ) ) {
            newEmployee_Leave.getRunContext().addChange(new InstanceCreatedDelta(newEmployee_Leave, KEY_LETTERS));
            return newEmployee_Leave;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Employee_Leave create( Hr context, UniqueId instanceId, int m_Starting, int m_Ending, boolean m_Approved, int ref_National_ID, int ref_Leave_ID ) throws XtumlException {
        Employee_Leave newEmployee_Leave = new Employee_LeaveImpl( context, instanceId, m_Starting, m_Ending, m_Approved, ref_National_ID, ref_Leave_ID );
        if ( context.addInstance( newEmployee_Leave ) ) {
            return newEmployee_Leave;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private int m_Starting;
    @Override
    public void setStarting(int m_Starting) throws XtumlException {
        checkLiving();
        if (m_Starting != this.m_Starting) {
            final int oldValue = this.m_Starting;
            this.m_Starting = m_Starting;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Starting", oldValue, this.m_Starting));
        }
    }
    @Override
    public int getStarting() throws XtumlException {
        checkLiving();
        return m_Starting;
    }
    private int m_Ending;
    @Override
    public void setEnding(int m_Ending) throws XtumlException {
        checkLiving();
        if (m_Ending != this.m_Ending) {
            final int oldValue = this.m_Ending;
            this.m_Ending = m_Ending;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Ending", oldValue, this.m_Ending));
        }
    }
    @Override
    public int getEnding() throws XtumlException {
        checkLiving();
        return m_Ending;
    }
    private boolean m_Approved;
    @Override
    public void setApproved(boolean m_Approved) throws XtumlException {
        checkLiving();
        if (m_Approved != this.m_Approved) {
            final boolean oldValue = this.m_Approved;
            this.m_Approved = m_Approved;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Approved", oldValue, this.m_Approved));
        }
    }
    @Override
    public boolean getApproved() throws XtumlException {
        checkLiving();
        return m_Approved;
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
    private int ref_Leave_ID;
    @Override
    public int getLeave_ID() throws XtumlException {
        checkLiving();
        return ref_Leave_ID;
    }
    @Override
    public void setLeave_ID(int ref_Leave_ID) throws XtumlException {
        checkLiving();
        if (ref_Leave_ID != this.ref_Leave_ID) {
            final int oldValue = this.ref_Leave_ID;
            this.ref_Leave_ID = ref_Leave_ID;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "ref_Leave_ID", oldValue, this.ref_Leave_ID));
        }
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getNational_ID(), getLeave_ID());
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
    private Employee R2_Employee_inst;
    @Override
    public void setR2_Employee( Employee inst ) {
        R2_Employee_inst = inst;
    }
    @Override
    public Employee R2_Employee() throws XtumlException {
        return R2_Employee_inst;
    }
    private Leave R2_Leave_inst;
    @Override
    public void setR2_Leave( Leave inst ) {
        R2_Leave_inst = inst;
    }
    @Override
    public Leave R2_Leave() throws XtumlException {
        return R2_Leave_inst;
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
    public Employee_Leave self() {
        return this;
    }

    @Override
    public Employee_Leave oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_EMPLOYEE_LEAVE;
    }

}

class EmptyEmployee_Leave extends ModelInstance<Employee_Leave,Hr> implements Employee_Leave {

    // attributes
    public void setStarting( int m_Starting ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getStarting() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setEnding( int m_Ending ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getEnding() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setApproved( boolean m_Approved ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public boolean getApproved() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getNational_ID() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setNational_ID( int ref_National_ID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getLeave_ID() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setLeave_ID( int ref_Leave_ID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Employee R2_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }
    @Override
    public Leave R2_Leave() {
        return LeaveImpl.EMPTY_LEAVE;
    }


    @Override
    public String getKeyLetters() {
        return Employee_LeaveImpl.KEY_LETTERS;
    }

    @Override
    public Employee_Leave self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Employee_Leave oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return Employee_LeaveImpl.EMPTY_EMPLOYEE_LEAVE;
    }

}
