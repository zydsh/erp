package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus;
import hrsystem.hr.main.Bonus_Payment;
import hrsystem.hr.main.Bonus_PaymentSet;
import hrsystem.hr.main.impl.BonusImpl;
import hrsystem.hr.main.impl.Bonus_PaymentSetImpl;

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


public class BonusImpl extends ModelInstance<Bonus,Hr> implements Bonus {

    public static final String KEY_LETTERS = "Bonus";
    public static final Bonus EMPTY_BONUS = new EmptyBonus();

    private Hr context;

    // constructors
    private BonusImpl( Hr context ) {
        this.context = context;
        m_Name = "";
        m_Percent = 0d;
        R4_Bonus_Payment_set = new Bonus_PaymentSetImpl();
    }

    private BonusImpl( Hr context, UniqueId instanceId, String m_Name, double m_Percent ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        this.m_Percent = m_Percent;
        R4_Bonus_Payment_set = new Bonus_PaymentSetImpl();
    }

    public static Bonus create( Hr context ) throws XtumlException {
        Bonus newBonus = new BonusImpl( context );
        if ( context.addInstance( newBonus ) ) {
            newBonus.getRunContext().addChange(new InstanceCreatedDelta(newBonus, KEY_LETTERS));
            return newBonus;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Bonus create( Hr context, UniqueId instanceId, String m_Name, double m_Percent ) throws XtumlException {
        Bonus newBonus = new BonusImpl( context, instanceId, m_Name, m_Percent );
        if ( context.addInstance( newBonus ) ) {
            return newBonus;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private String m_Name;
    @Override
    public void setName(String m_Name) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Name, this.m_Name)) {
            final String oldValue = this.m_Name;
            this.m_Name = m_Name;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Name", oldValue, this.m_Name));
            if ( !R4_Bonus_Payment().isEmpty() ) R4_Bonus_Payment().setName( m_Name );
        }
    }
    @Override
    public String getName() throws XtumlException {
        checkLiving();
        return m_Name;
    }
    private double m_Percent;
    @Override
    public void setPercent(double m_Percent) throws XtumlException {
        checkLiving();
        if (m_Percent != this.m_Percent) {
            final double oldValue = this.m_Percent;
            this.m_Percent = m_Percent;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Percent", oldValue, this.m_Percent));
        }
    }
    @Override
    public double getPercent() throws XtumlException {
        checkLiving();
        return m_Percent;
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getName());
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

        public void crud( final String p_Name,  final double p_Percent,  final String p_Action ) throws XtumlException {
            Bonus bonus = context().Bonus_instances().anyWhere(selected -> StringUtil.equality(((Bonus)selected).getName(), p_Name));
            if ( bonus.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Attempting to add a new bonus to employee." );
                Bonus b = BonusImpl.create( context() );
                b.setName(p_Name);
                b.setPercent(p_Percent);
                context().UI().Reply( "bonus created successfully.", true );
            }
            else if ( !bonus.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Attempting to add a new bonus." );
                context().LOG().LogInfo( "bonus already exists." );
                context().UI().Reply( "Bonus already exists", false );
            }
            else if ( !bonus.isEmpty() && StringUtil.equality(p_Action, "UPDATE") ) {
                context().LOG().LogInfo( "Attempting to update bonus." );
                bonus.setName(p_Name);
                bonus.setPercent(p_Percent);
                context().LOG().LogInfo( "bonus updated successfully." );
                context().UI().Reply( "bonus updated successfully", true );
            }
            else if ( !bonus.isEmpty() && StringUtil.equality(p_Action, "DELETE") ) {
                context().LOG().LogInfo( "Attempting to delete a bonus instance." );
                context().LOG().LogInfo( "bonus delete in not implemented yet." );
                context().UI().Reply( "bonus delete in not implemented yet", false );
            }
            else if ( bonus.isEmpty() ) {
                context().LOG().LogInfo( "bonus does not exist." );
                context().UI().Reply( "bonus does not exist.", false );
            }
        }



    }


    // events


    // selections
    private Bonus_PaymentSet R4_Bonus_Payment_set;
    @Override
    public void addR4_Bonus_Payment( Bonus_Payment inst ) {
        R4_Bonus_Payment_set.add(inst);
    }
    @Override
    public void removeR4_Bonus_Payment( Bonus_Payment inst ) {
        R4_Bonus_Payment_set.remove(inst);
    }
    @Override
    public Bonus_PaymentSet R4_Bonus_Payment() throws XtumlException {
        return R4_Bonus_Payment_set;
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
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setPercent( double m_Percent ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getPercent() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Bonus_PaymentSet R4_Bonus_Payment() {
        return (new Bonus_PaymentSetImpl());
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
