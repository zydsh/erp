package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus;
import hrsystem.hr.main.BonusSpecification;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.impl.BonusSpecificationImpl;
import hrsystem.hr.main.impl.EmployeeImpl;

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


public class BonusImpl extends ModelInstance<Bonus,Hr> implements Bonus {

    public static final String KEY_LETTERS = "BP";
    public static final Bonus EMPTY_BONUS = new EmptyBonus();

    private Hr context;

    // constructors
    private BonusImpl( Hr context ) {
        this.context = context;
        m_Starting = 0;
        m_Ending = 0;
        m_Amount = 0d;
        R16_is_specified_by_BonusSpecification_inst = BonusSpecificationImpl.EMPTY_BONUSSPECIFICATION;
        R19_given_in_the_past_to_an_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        R4_is_given_to_an_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        statemachine = new BonusStateMachine(this, context());
    }

    private BonusImpl( Hr context, UniqueId instanceId, int m_Starting, int m_Ending, double m_Amount, int initialState ) {
        super(instanceId);
        this.context = context;
        this.m_Starting = m_Starting;
        this.m_Ending = m_Ending;
        this.m_Amount = m_Amount;
        R16_is_specified_by_BonusSpecification_inst = BonusSpecificationImpl.EMPTY_BONUSSPECIFICATION;
        R19_given_in_the_past_to_an_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        R4_is_given_to_an_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        statemachine = new BonusStateMachine(this, context(), initialState);
    }

    public static Bonus create( Hr context ) throws XtumlException {
        Bonus newBonus = new BonusImpl( context );
        if ( context.addInstance( newBonus ) ) {
            newBonus.getRunContext().addChange(new InstanceCreatedDelta(newBonus, KEY_LETTERS));
            return newBonus;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Bonus create( Hr context, UniqueId instanceId, int m_Starting, int m_Ending, double m_Amount, int initialState ) throws XtumlException {
        Bonus newBonus = new BonusImpl( context, instanceId, m_Starting, m_Ending, m_Amount, initialState );
        if ( context.addInstance( newBonus ) ) {
            return newBonus;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    private final BonusStateMachine statemachine;
    
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
    public int getStarting() throws XtumlException {
        checkLiving();
        return m_Starting;
    }
    @Override
    public void setStarting(int m_Starting) throws XtumlException {
        checkLiving();
        if (m_Starting != this.m_Starting) {
            final int oldValue = this.m_Starting;
            this.m_Starting = m_Starting;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Starting", oldValue, this.m_Starting));
        }
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


    // instance identifiers

    // operations


    // static operations


    // events
    public static class deactivateBonus extends Event {
        public deactivateBonus(IRunContext runContext, int populationId) {
            super(runContext, populationId);
        }
        @Override
        public int getId() {
            return 2;
        }
        @Override
        public String getClassName() {
            return "Bonus";
        }
    }
    public static class payBonus extends Event {
        public payBonus(IRunContext runContext, int populationId) {
            super(runContext, populationId);
        }
        @Override
        public int getId() {
            return 1;
        }
        @Override
        public String getClassName() {
            return "Bonus";
        }
    }
    public static class resumeBonus extends Event {
        public resumeBonus(IRunContext runContext, int populationId,  final int p_Starting,  final int p_Ending ) {
            super(runContext, populationId, new Object[]{p_Starting,  p_Ending});
        }
        @Override
        public int getId() {
            return 0;
        }
        @Override
        public String getClassName() {
            return "Bonus";
        }
    }


    // selections
    private BonusSpecification R16_is_specified_by_BonusSpecification_inst;
    @Override
    public void setR16_is_specified_by_BonusSpecification( BonusSpecification inst ) {
        R16_is_specified_by_BonusSpecification_inst = inst;
    }
    @Override
    public BonusSpecification R16_is_specified_by_BonusSpecification() throws XtumlException {
        return R16_is_specified_by_BonusSpecification_inst;
    }
    private Employee R19_given_in_the_past_to_an_Employee_inst;
    @Override
    public void setR19_given_in_the_past_to_an_Employee( Employee inst ) {
        R19_given_in_the_past_to_an_Employee_inst = inst;
    }
    @Override
    public Employee R19_given_in_the_past_to_an_Employee() throws XtumlException {
        return R19_given_in_the_past_to_an_Employee_inst;
    }
    private Employee R4_is_given_to_an_Employee_inst;
    @Override
    public void setR4_is_given_to_an_Employee( Employee inst ) {
        R4_is_given_to_an_Employee_inst = inst;
    }
    @Override
    public Employee R4_is_given_to_an_Employee() throws XtumlException {
        return R4_is_given_to_an_Employee_inst;
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
    public Bonus self() {
        return this;
    }

    @Override
    public Bonus oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_BONUS;
    }

}

class EmptyBonus extends ModelInstance<Bonus,Hr> implements Bonus {

    // attributes
    public int getStarting() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setStarting( int m_Starting ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getEnding() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setEnding( int m_Ending ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setAmount( double m_Amount ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getAmount() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public BonusSpecification R16_is_specified_by_BonusSpecification() {
        return BonusSpecificationImpl.EMPTY_BONUSSPECIFICATION;
    }
    @Override
    public Employee R19_given_in_the_past_to_an_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }
    @Override
    public Employee R4_is_given_to_an_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }


    @Override
    public String getKeyLetters() {
        return BonusImpl.KEY_LETTERS;
    }

    @Override
    public Bonus self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Bonus oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return BonusImpl.EMPTY_BONUS;
    }

}
