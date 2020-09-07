package hrsystem.fms.budgeting.impl;


import hrsystem.Fms;
import hrsystem.fms.budgeting.Budget;
import hrsystem.fms.budgeting.Chapter;
import hrsystem.fms.budgeting.ChapterSet;
import hrsystem.fms.budgeting.impl.ChapterSetImpl;

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


public class BudgetImpl extends ModelInstance<Budget,Fms> implements Budget {

    public static final String KEY_LETTERS = "Budget";
    public static final Budget EMPTY_BUDGET = new EmptyBudget();

    private Fms context;

    // constructors
    private BudgetImpl( Fms context ) {
        this.context = context;
        m_Year = "";
        m_Amount = 0d;
        R100_divided_Chapter_set = new ChapterSetImpl();
    }

    private BudgetImpl( Fms context, UniqueId instanceId, String m_Year, double m_Amount ) {
        super(instanceId);
        this.context = context;
        this.m_Year = m_Year;
        this.m_Amount = m_Amount;
        R100_divided_Chapter_set = new ChapterSetImpl();
    }

    public static Budget create( Fms context ) throws XtumlException {
        Budget newBudget = new BudgetImpl( context );
        if ( context.addInstance( newBudget ) ) {
            newBudget.getRunContext().addChange(new InstanceCreatedDelta(newBudget, KEY_LETTERS));
            return newBudget;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Budget create( Fms context, UniqueId instanceId, String m_Year, double m_Amount ) throws XtumlException {
        Budget newBudget = new BudgetImpl( context, instanceId, m_Year, m_Amount );
        if ( context.addInstance( newBudget ) ) {
            return newBudget;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private String m_Year;
    @Override
    public String getYear() throws XtumlException {
        checkLiving();
        return m_Year;
    }
    @Override
    public void setYear(String m_Year) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Year, this.m_Year)) {
            final String oldValue = this.m_Year;
            this.m_Year = m_Year;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Year", oldValue, this.m_Year));
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
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getYear());
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
    private ChapterSet R100_divided_Chapter_set;
    @Override
    public void addR100_divided_Chapter( Chapter inst ) {
        R100_divided_Chapter_set.add(inst);
    }
    @Override
    public void removeR100_divided_Chapter( Chapter inst ) {
        R100_divided_Chapter_set.remove(inst);
    }
    @Override
    public ChapterSet R100_divided_Chapter() throws XtumlException {
        return R100_divided_Chapter_set;
    }


    @Override
    public IRunContext getRunContext() {
        return context().getRunContext();
    }

    @Override
    public Fms context() {
        return context;
    }

    @Override
    public String getKeyLetters() {
        return KEY_LETTERS;
    }

    @Override
    public Budget self() {
        return this;
    }

    @Override
    public Budget oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_BUDGET;
    }

}

class EmptyBudget extends ModelInstance<Budget,Fms> implements Budget {

    // attributes
    public String getYear() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setYear( String m_Year ) throws XtumlException {
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
    public ChapterSet R100_divided_Chapter() {
        return (new ChapterSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return BudgetImpl.KEY_LETTERS;
    }

    @Override
    public Budget self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Budget oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return BudgetImpl.EMPTY_BUDGET;
    }

}
