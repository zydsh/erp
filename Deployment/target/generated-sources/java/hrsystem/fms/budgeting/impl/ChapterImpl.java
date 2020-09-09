package hrsystem.fms.budgeting.impl;


import hrsystem.Fms;
import hrsystem.fms.budgeting.Budget;
import hrsystem.fms.budgeting.Chapter;
import hrsystem.fms.budgeting.Section;
import hrsystem.fms.budgeting.SectionSet;
import hrsystem.fms.budgeting.impl.BudgetImpl;
import hrsystem.fms.budgeting.impl.SectionSetImpl;

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


public class ChapterImpl extends ModelInstance<Chapter,Fms> implements Chapter {

    public static final String KEY_LETTERS = "Chapter";
    public static final Chapter EMPTY_CHAPTER = new EmptyChapter();

    private Fms context;

    // constructors
    private ChapterImpl( Fms context ) {
        this.context = context;
        m_Code = "";
        m_Name = "";
        m_CeilingFund = 0d;
        m_RequestFund = 0d;
        R100_belongs_Budget_inst = BudgetImpl.EMPTY_BUDGET;
        R200_divided_Section_set = new SectionSetImpl();
    }

    private ChapterImpl( Fms context, UniqueId instanceId, String m_Code, String m_Name, double m_CeilingFund, double m_RequestFund ) {
        super(instanceId);
        this.context = context;
        this.m_Code = m_Code;
        this.m_Name = m_Name;
        this.m_CeilingFund = m_CeilingFund;
        this.m_RequestFund = m_RequestFund;
        R100_belongs_Budget_inst = BudgetImpl.EMPTY_BUDGET;
        R200_divided_Section_set = new SectionSetImpl();
    }

    public static Chapter create( Fms context ) throws XtumlException {
        Chapter newChapter = new ChapterImpl( context );
        if ( context.addInstance( newChapter ) ) {
            newChapter.getRunContext().addChange(new InstanceCreatedDelta(newChapter, KEY_LETTERS));
            return newChapter;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Chapter create( Fms context, UniqueId instanceId, String m_Code, String m_Name, double m_CeilingFund, double m_RequestFund ) throws XtumlException {
        Chapter newChapter = new ChapterImpl( context, instanceId, m_Code, m_Name, m_CeilingFund, m_RequestFund );
        if ( context.addInstance( newChapter ) ) {
            return newChapter;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private String m_Code;
    @Override
    public void setCode(String m_Code) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Code, this.m_Code)) {
            final String oldValue = this.m_Code;
            this.m_Code = m_Code;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Code", oldValue, this.m_Code));
        }
    }
    @Override
    public String getCode() throws XtumlException {
        checkLiving();
        return m_Code;
    }
    private String m_Name;
    @Override
    public void setName(String m_Name) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Name, this.m_Name)) {
            final String oldValue = this.m_Name;
            this.m_Name = m_Name;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Name", oldValue, this.m_Name));
        }
    }
    @Override
    public String getName() throws XtumlException {
        checkLiving();
        return m_Name;
    }
    private double m_CeilingFund;
    @Override
    public void setCeilingFund(double m_CeilingFund) throws XtumlException {
        checkLiving();
        if (m_CeilingFund != this.m_CeilingFund) {
            final double oldValue = this.m_CeilingFund;
            this.m_CeilingFund = m_CeilingFund;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_CeilingFund", oldValue, this.m_CeilingFund));
        }
    }
    @Override
    public double getCeilingFund() throws XtumlException {
        checkLiving();
        return m_CeilingFund;
    }
    private double m_RequestFund;
    @Override
    public void setRequestFund(double m_RequestFund) throws XtumlException {
        checkLiving();
        if (m_RequestFund != this.m_RequestFund) {
            final double oldValue = this.m_RequestFund;
            this.m_RequestFund = m_RequestFund;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_RequestFund", oldValue, this.m_RequestFund));
        }
    }
    @Override
    public double getRequestFund() throws XtumlException {
        checkLiving();
        return m_RequestFund;
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getCode());
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


    // events


    // selections
    private Budget R100_belongs_Budget_inst;
    @Override
    public void setR100_belongs_Budget( Budget inst ) {
        R100_belongs_Budget_inst = inst;
    }
    @Override
    public Budget R100_belongs_Budget() throws XtumlException {
        return R100_belongs_Budget_inst;
    }
    private SectionSet R200_divided_Section_set;
    @Override
    public void addR200_divided_Section( Section inst ) {
        R200_divided_Section_set.add(inst);
    }
    @Override
    public void removeR200_divided_Section( Section inst ) {
        R200_divided_Section_set.remove(inst);
    }
    @Override
    public SectionSet R200_divided_Section() throws XtumlException {
        return R200_divided_Section_set;
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
    public Chapter self() {
        return this;
    }

    @Override
    public Chapter oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_CHAPTER;
    }

}

class EmptyChapter extends ModelInstance<Chapter,Fms> implements Chapter {

    // attributes
    public void setCode( String m_Code ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getCode() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setCeilingFund( double m_CeilingFund ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getCeilingFund() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setRequestFund( double m_RequestFund ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getRequestFund() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Budget R100_belongs_Budget() {
        return BudgetImpl.EMPTY_BUDGET;
    }
    @Override
    public SectionSet R200_divided_Section() {
        return (new SectionSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return ChapterImpl.KEY_LETTERS;
    }

    @Override
    public Chapter self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Chapter oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return ChapterImpl.EMPTY_CHAPTER;
    }

}
