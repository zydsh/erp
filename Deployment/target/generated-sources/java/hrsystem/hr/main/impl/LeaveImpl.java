package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Leave;
import hrsystem.hr.main.LeaveSpecification;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.LeaveSpecificationImpl;

import io.ciera.runtime.instanceloading.AttributeChangedDelta;
import io.ciera.runtime.instanceloading.InstanceCreatedDelta;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.classes.IInstanceIdentifier;
import io.ciera.runtime.summit.classes.InstanceIdentifier;
import io.ciera.runtime.summit.classes.ModelInstance;
import io.ciera.runtime.summit.exceptions.EmptyInstanceException;
import io.ciera.runtime.summit.exceptions.InstancePopulationException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.statemachine.Event;
import io.ciera.runtime.summit.statemachine.IEvent;
import io.ciera.runtime.summit.types.IWhere;
import io.ciera.runtime.summit.types.IXtumlType;
import io.ciera.runtime.summit.types.UniqueId;


public class LeaveImpl extends ModelInstance<Leave,Hr> implements Leave {

    public static final String KEY_LETTERS = "Leave";
    public static final Leave EMPTY_LEAVE = new EmptyLeave();

    private Hr context;

    // constructors
    private LeaveImpl( Hr context ) {
        this.context = context;
        m_Starting = 0;
        m_Ending = 0;
        R15_is_specified_by_a_LeaveSpecification_inst = LeaveSpecificationImpl.EMPTY_LEAVESPECIFICATION;
        R2_is_consumed_by_a_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        R5_is_currently_taken_by_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        R7_to_be_taken_by_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        statemachine = new LeaveStateMachine(this, context());
    }

    private LeaveImpl( Hr context, UniqueId instanceId, int m_Starting, int m_Ending, int initialState ) {
        super(instanceId);
        this.context = context;
        this.m_Starting = m_Starting;
        this.m_Ending = m_Ending;
        R15_is_specified_by_a_LeaveSpecification_inst = LeaveSpecificationImpl.EMPTY_LEAVESPECIFICATION;
        R2_is_consumed_by_a_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        R5_is_currently_taken_by_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        R7_to_be_taken_by_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        statemachine = new LeaveStateMachine(this, context(), initialState);
    }

    public static Leave create( Hr context ) throws XtumlException {
        Leave newLeave = new LeaveImpl( context );
        if ( context.addInstance( newLeave ) ) {
            newLeave.getRunContext().addChange(new InstanceCreatedDelta(newLeave, KEY_LETTERS));
            return newLeave;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Leave create( Hr context, UniqueId instanceId, int m_Starting, int m_Ending, int initialState ) throws XtumlException {
        Leave newLeave = new LeaveImpl( context, instanceId, m_Starting, m_Ending, initialState );
        if ( context.addInstance( newLeave ) ) {
            return newLeave;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    private final LeaveStateMachine statemachine;
    
    @Override
    public void accept(IEvent event) throws XtumlException {
        statemachine.transition(event);
    }

    @Override
    public int getCurrentState() {
        return statemachine.getCurrentState();
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
    public int getEnding() throws XtumlException {
        checkLiving();
        return m_Ending;
    }
    @Override
    public void setEnding(int m_Ending) throws XtumlException {
        checkLiving();
        if (m_Ending != this.m_Ending) {
            final int oldValue = this.m_Ending;
            this.m_Ending = m_Ending;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Ending", oldValue, this.m_Ending));
        }
    }


    // instance identifiers

    // operations


    // static operations


    // events
    public static class Approve extends Event {
        public Approve(IRunContext runContext, int populationId) {
            super(runContext, populationId);
        }
        @Override
        public int getId() {
            return 1;
        }
        @Override
        public String getClassName() {
            return "Leave";
        }
    }
    public static class EndLeave extends Event {
        public EndLeave(IRunContext runContext, int populationId) {
            super(runContext, populationId);
        }
        @Override
        public int getId() {
            return 3;
        }
        @Override
        public String getClassName() {
            return "Leave";
        }
    }
    public static class Reject extends Event {
        public Reject(IRunContext runContext, int populationId) {
            super(runContext, populationId);
        }
        @Override
        public int getId() {
            return 0;
        }
        @Override
        public String getClassName() {
            return "Leave";
        }
    }
    public static class StartLeave extends Event {
        public StartLeave(IRunContext runContext, int populationId) {
            super(runContext, populationId);
        }
        @Override
        public int getId() {
            return 2;
        }
        @Override
        public String getClassName() {
            return "Leave";
        }
    }


    // selections
    private LeaveSpecification R15_is_specified_by_a_LeaveSpecification_inst;
    @Override
    public void setR15_is_specified_by_a_LeaveSpecification( LeaveSpecification inst ) {
        R15_is_specified_by_a_LeaveSpecification_inst = inst;
    }
    @Override
    public LeaveSpecification R15_is_specified_by_a_LeaveSpecification() throws XtumlException {
        return R15_is_specified_by_a_LeaveSpecification_inst;
    }
    private Employee R2_is_consumed_by_a_Employee_inst;
    @Override
    public void setR2_is_consumed_by_a_Employee( Employee inst ) {
        R2_is_consumed_by_a_Employee_inst = inst;
    }
    @Override
    public Employee R2_is_consumed_by_a_Employee() throws XtumlException {
        return R2_is_consumed_by_a_Employee_inst;
    }
    private Employee R5_is_currently_taken_by_Employee_inst;
    @Override
    public void setR5_is_currently_taken_by_Employee( Employee inst ) {
        R5_is_currently_taken_by_Employee_inst = inst;
    }
    @Override
    public Employee R5_is_currently_taken_by_Employee() throws XtumlException {
        return R5_is_currently_taken_by_Employee_inst;
    }
    private Employee R7_to_be_taken_by_Employee_inst;
    @Override
    public void setR7_to_be_taken_by_Employee( Employee inst ) {
        R7_to_be_taken_by_Employee_inst = inst;
    }
    @Override
    public Employee R7_to_be_taken_by_Employee() throws XtumlException {
        return R7_to_be_taken_by_Employee_inst;
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
    public Leave self() {
        return this;
    }

    @Override
    public Leave oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_LEAVE;
    }

}

class EmptyLeave extends ModelInstance<Leave,Hr> implements Leave {

    // attributes
    public void setStarting( int m_Starting ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getStarting() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getEnding() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setEnding( int m_Ending ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public LeaveSpecification R15_is_specified_by_a_LeaveSpecification() {
        return LeaveSpecificationImpl.EMPTY_LEAVESPECIFICATION;
    }
    @Override
    public Employee R2_is_consumed_by_a_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }
    @Override
    public Employee R5_is_currently_taken_by_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }
    @Override
    public Employee R7_to_be_taken_by_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }


    @Override
    public String getKeyLetters() {
        return LeaveImpl.KEY_LETTERS;
    }

    @Override
    public Leave self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Leave oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return LeaveImpl.EMPTY_LEAVE;
    }

}
