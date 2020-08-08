package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus;
import hrsystem.hr.main.Bonus_Payment;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.impl.BonusImpl;
import hrsystem.hr.main.impl.Bonus_PaymentImpl;
import hrsystem.hr.main.impl.EmployeeImpl;

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
import io.ciera.runtime.summit.statemachine.Event;
import io.ciera.runtime.summit.statemachine.IEvent;
import io.ciera.runtime.summit.types.IWhere;
import io.ciera.runtime.summit.types.IXtumlType;
import io.ciera.runtime.summit.types.StringUtil;
import io.ciera.runtime.summit.types.UniqueId;


public class Bonus_PaymentImpl extends ModelInstance<Bonus_Payment,Hr> implements Bonus_Payment {

    public static final String KEY_LETTERS = "BP";
    public static final Bonus_Payment EMPTY_BONUS_PAYMENT = new EmptyBonus_Payment();

    private Hr context;

    // constructors
    private Bonus_PaymentImpl( Hr context ) {
        this.context = context;
        m_Starting = 0;
        m_Ending = 0;
        m_Amount = 0d;
        ref_National_ID = 0;
        ref_Name = 0;
        R4_Bonus_inst = BonusImpl.EMPTY_BONUS;
        R4_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        statemachine = new Bonus_PaymentStateMachine(this, context());
    }

    private Bonus_PaymentImpl( Hr context, UniqueId instanceId, int m_Starting, int m_Ending, double m_Amount, int ref_National_ID, int ref_Name, int initialState ) {
        super(instanceId);
        this.context = context;
        this.m_Starting = m_Starting;
        this.m_Ending = m_Ending;
        this.m_Amount = m_Amount;
        this.ref_National_ID = ref_National_ID;
        this.ref_Name = ref_Name;
        R4_Bonus_inst = BonusImpl.EMPTY_BONUS;
        R4_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
        statemachine = new Bonus_PaymentStateMachine(this, context(), initialState);
    }

    public static Bonus_Payment create( Hr context ) throws XtumlException {
        Bonus_Payment newBonus_Payment = new Bonus_PaymentImpl( context );
        if ( context.addInstance( newBonus_Payment ) ) {
            newBonus_Payment.getRunContext().addChange(new InstanceCreatedDelta(newBonus_Payment, KEY_LETTERS));
            return newBonus_Payment;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Bonus_Payment create( Hr context, UniqueId instanceId, int m_Starting, int m_Ending, double m_Amount, int ref_National_ID, int ref_Name, int initialState ) throws XtumlException {
        Bonus_Payment newBonus_Payment = new Bonus_PaymentImpl( context, instanceId, m_Starting, m_Ending, m_Amount, ref_National_ID, ref_Name, initialState );
        if ( context.addInstance( newBonus_Payment ) ) {
            return newBonus_Payment;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    private final Bonus_PaymentStateMachine statemachine;
    
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
    private double m_Amount;
    @Override
    public double getAmount() throws XtumlException {
        checkLiving();
        return m_Amount;
    }
    @Override
    public void setAmount(double m_Amount) throws XtumlException {
        checkLiving();
        if (m_Amount != this.m_Amount) {
            final double oldValue = this.m_Amount;
            this.m_Amount = m_Amount;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Amount", oldValue, this.m_Amount));
        }
    }
    private int ref_National_ID;
    @Override
    public void setNational_ID(int ref_National_ID) throws XtumlException {
        checkLiving();
        if (ref_National_ID != this.ref_National_ID) {
            final int oldValue = this.ref_National_ID;
            this.ref_National_ID = ref_National_ID;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "ref_National_ID", oldValue, this.ref_National_ID));
        }
    }
    @Override
    public int getNational_ID() throws XtumlException {
        checkLiving();
        return ref_National_ID;
    }
    private int ref_Name;
    @Override
    public int getName() throws XtumlException {
        checkLiving();
        return ref_Name;
    }
    @Override
    public void setName(int ref_Name) throws XtumlException {
        checkLiving();
        if (ref_Name != this.ref_Name) {
            final int oldValue = this.ref_Name;
            this.ref_Name = ref_Name;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "ref_Name", oldValue, this.ref_Name));
        }
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getNational_ID(), getName());
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

        public void crud( final int p_National_ID,  final String p_Name,  final int p_Starting,  final int p_Ending,  final String p_Action ) throws XtumlException {
            Employee employee = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getNational_ID() == p_National_ID);
            Bonus bonus = context().Bonus_instances().anyWhere(selected -> StringUtil.equality(((Bonus)selected).getName(), p_Name));
            Bonus_Payment bp = context().Bonus_Payment_instances().anyWhere(selected -> StringUtil.equality(((Bonus_Payment)selected).getName(), p_Name) && ((Bonus_Payment)selected).getNational_ID() == p_National_ID);
            if ( bp.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Attempting to add a new bonus to employee." );
                Bonus_Payment b = Bonus_PaymentImpl.create( context() );
                context().relate_R4_Bonus_Payment_Employee( b, employee );
                context().relate_R4_Bonus_Payment_Bonus( b, bonus );
                b.setStarting(p_Starting);
                b.setEnding(p_Ending);
                context().UI().Reply( "bonus created successfully.", true );
            }
            else if ( !bp.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Attempting to add a new bonus." );
                context().LOG().LogInfo( "bonus already exists." );
                context().UI().Reply( "bonus already exists", false );
            }
            else if ( !bp.isEmpty() && StringUtil.equality(p_Action, "UPDATE") ) {
                context().LOG().LogInfo( "Attempting to update bonus." );
                bp.setStarting(p_Starting);
                bp.setEnding(p_Ending);
                context().LOG().LogInfo( "bonus updated successfully." );
                context().UI().Reply( "bonus updated successfully", true );
            }
            else if ( !bp.isEmpty() && StringUtil.equality(p_Action, "DELETE") ) {
                context().LOG().LogInfo( "Attempting to delete a bonus instance." );
                context().LOG().LogInfo( "bonus delete in not implemented yet." );
                context().UI().Reply( "bonus delete in not implemented yet", false );
            }
            else if ( bp.isEmpty() ) {
                context().LOG().LogInfo( "bonus does not exist." );
                context().UI().Reply( "bonus does not exist.", false );
            }
        }



    }


    // events
    public static class deactivateBonus extends Event {
        public deactivateBonus(IRunContext runContext, int populationId) {
            super(runContext, populationId);
        }
        @Override
        public int getId() {
            return 1;
        }
        @Override
        public String getClassName() {
            return "Bonus_Payment";
        }
    }
    public static class payBonus extends Event {
        public payBonus(IRunContext runContext, int populationId) {
            super(runContext, populationId);
        }
        @Override
        public int getId() {
            return 2;
        }
        @Override
        public String getClassName() {
            return "Bonus_Payment";
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
            return "Bonus_Payment";
        }
    }


    // selections
    private Bonus R4_Bonus_inst;
    @Override
    public void setR4_Bonus( Bonus inst ) {
        R4_Bonus_inst = inst;
    }
    @Override
    public Bonus R4_Bonus() throws XtumlException {
        return R4_Bonus_inst;
    }
    private Employee R4_Employee_inst;
    @Override
    public void setR4_Employee( Employee inst ) {
        R4_Employee_inst = inst;
    }
    @Override
    public Employee R4_Employee() throws XtumlException {
        return R4_Employee_inst;
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
    public Bonus_Payment self() {
        return this;
    }

    @Override
    public Bonus_Payment oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_BONUS_PAYMENT;
    }

}

class EmptyBonus_Payment extends ModelInstance<Bonus_Payment,Hr> implements Bonus_Payment {

    // attributes
    public int getStarting() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setStarting( int m_Starting ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setEnding( int m_Ending ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getEnding() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public double getAmount() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setAmount( double m_Amount ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setNational_ID( int ref_National_ID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getNational_ID() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setName( int ref_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Bonus R4_Bonus() {
        return BonusImpl.EMPTY_BONUS;
    }
    @Override
    public Employee R4_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }


    @Override
    public String getKeyLetters() {
        return Bonus_PaymentImpl.KEY_LETTERS;
    }

    @Override
    public Bonus_Payment self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Bonus_Payment oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return Bonus_PaymentImpl.EMPTY_BONUS_PAYMENT;
    }

}
