package hrsystem.fm.main.impl;


import hrsystem.Fm;
import hrsystem.fm.main.Budget;
import hrsystem.fm.main.Chapter;
import hrsystem.fm.main.ChapterSet;
import hrsystem.fm.main.impl.BudgetImpl;
import hrsystem.fm.main.impl.ChapterSetImpl;

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


public class BudgetImpl extends ModelInstance<Budget,Fm> implements Budget {

    public static final String KEY_LETTERS = "Budget";
    public static final Budget EMPTY_BUDGET = new EmptyBudget();

    private Fm context;

    // constructors
    private BudgetImpl( Fm context ) {
        this.context = context;
        m_Year = "";
        m_Fund = 0d;
        R1_Chapter_set = new ChapterSetImpl();
    }

    private BudgetImpl( Fm context, UniqueId instanceId, String m_Year, double m_Fund ) {
        super(instanceId);
        this.context = context;
        this.m_Year = m_Year;
        this.m_Fund = m_Fund;
        R1_Chapter_set = new ChapterSetImpl();
    }

    public static Budget create( Fm context ) throws XtumlException {
        Budget newBudget = new BudgetImpl( context );
        if ( context.addInstance( newBudget ) ) {
            newBudget.getRunContext().addChange(new InstanceCreatedDelta(newBudget, KEY_LETTERS));
            return newBudget;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Budget create( Fm context, UniqueId instanceId, String m_Year, double m_Fund ) throws XtumlException {
        Budget newBudget = new BudgetImpl( context, instanceId, m_Year, m_Fund );
        if ( context.addInstance( newBudget ) ) {
            return newBudget;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private String m_Year;
    @Override
    public void setYear(String m_Year) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Year, this.m_Year)) {
            final String oldValue = this.m_Year;
            this.m_Year = m_Year;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Year", oldValue, this.m_Year));
        }
    }
    @Override
    public String getYear() throws XtumlException {
        checkLiving();
        return m_Year;
    }
    private double m_Fund;
    @Override
    public double getFund() throws XtumlException {
        checkLiving();
        return m_Fund;
    }
    @Override
    public void setFund(double m_Fund) throws XtumlException {
        checkLiving();
        if (m_Fund != this.m_Fund) {
            final double oldValue = this.m_Fund;
            this.m_Fund = m_Fund;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Fund", oldValue, this.m_Fund));
        }
    }


    // instance identifiers

    // operations


    // static operations
    public static class CLASS extends ActionHome<Fm> {

        public CLASS( Fm context ) {
            super( context );
        }

        public void crud( final String p_Year,  final double p_Fund,  final String p_Action ) throws XtumlException {
            Budget budget = context().Budget_instances().anyWhere(selected -> StringUtil.equality(((Budget)selected).getYear(), p_Year));
            if ( budget.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Attempting to add a new budget to employee." );
                Budget b = BudgetImpl.create( context() );
                b.setYear(p_Year);
                b.setFund(p_Fund);
                context().Fin().Reply( "budget created successfully.", true );
            }
            else if ( !budget.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Attempting to add a new budget." );
                context().LOG().LogInfo( "Budget already exists." );
                context().Fin().Reply( "Budget already exists", false );
            }
            else if ( !budget.isEmpty() && StringUtil.equality(p_Action, "UPDATE") ) {
                context().LOG().LogInfo( "Attempting to update budget." );
                budget.setFund(p_Fund);
                budget.setYear(p_Year);
                context().LOG().LogInfo( "Budget updated successfully." );
                context().Fin().Reply( "Budget updated successfully", true );
            }
            else if ( !budget.isEmpty() && StringUtil.equality(p_Action, "DELETE") ) {
                context().LOG().LogInfo( "Attempting to delete a budget instance." );
                context().LOG().LogInfo( "Budget delete in not implemented yet." );
                context().Fin().Reply( "Budget delete in not implemented yet", false );
            }
            else if ( budget.isEmpty() ) {
                context().LOG().LogInfo( "Budget does not exist." );
                context().Fin().Reply( "Budget does not exist.", false );
            }
        }



    }


    // events


    // selections
    private ChapterSet R1_Chapter_set;
    @Override
    public void addR1_Chapter( Chapter inst ) {
        R1_Chapter_set.add(inst);
    }
    @Override
    public void removeR1_Chapter( Chapter inst ) {
        R1_Chapter_set.remove(inst);
    }
    @Override
    public ChapterSet R1_Chapter() throws XtumlException {
        return R1_Chapter_set;
    }


    @Override
    public IRunContext getRunContext() {
        return context().getRunContext();
    }

    @Override
    public Fm context() {
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

class EmptyBudget extends ModelInstance<Budget,Fm> implements Budget {

    // attributes
    public void setYear( String m_Year ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getYear() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public double getFund() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setFund( double m_Fund ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public ChapterSet R1_Chapter() {
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
