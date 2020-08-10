package erp.budget.main.impl;


import erp.Budget;
import erp.budget.main.Budget;
import erp.budget.main.Chapter;
import erp.budget.main.Section;
import erp.budget.main.SectionSet;
import erp.budget.main.impl.BudgetImpl;
import erp.budget.main.impl.ChapterImpl;
import erp.budget.main.impl.SectionSetImpl;

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


public class ChapterImpl extends ModelInstance<Chapter,Budget> implements Chapter {

    public static final String KEY_LETTERS = "Chapter";
    public static final Chapter EMPTY_CHAPTER = new EmptyChapter();

    private Budget context;

    // constructors
    private ChapterImpl( Budget context ) {
        this.context = context;
        m_Name = "";
        m_Code = 0;
        m_Ceiling_Fund = 0d;
        m_Request_Fund = 0d;
        m_Fund = 0d;
        ref_Year = 0;
        R1_Budget_inst = BudgetImpl.EMPTY_BUDGET;
        R2_Section_set = new SectionSetImpl();
    }

    private ChapterImpl( Budget context, UniqueId instanceId, String m_Name, int m_Code, double m_Ceiling_Fund, double m_Request_Fund, double m_Fund, int ref_Year ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        this.m_Code = m_Code;
        this.m_Ceiling_Fund = m_Ceiling_Fund;
        this.m_Request_Fund = m_Request_Fund;
        this.m_Fund = m_Fund;
        this.ref_Year = ref_Year;
        R1_Budget_inst = BudgetImpl.EMPTY_BUDGET;
        R2_Section_set = new SectionSetImpl();
    }

    public static Chapter create( Budget context ) throws XtumlException {
        Chapter newChapter = new ChapterImpl( context );
        if ( context.addInstance( newChapter ) ) {
            newChapter.getRunContext().addChange(new InstanceCreatedDelta(newChapter, KEY_LETTERS));
            return newChapter;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Chapter create( Budget context, UniqueId instanceId, String m_Name, int m_Code, double m_Ceiling_Fund, double m_Request_Fund, double m_Fund, int ref_Year ) throws XtumlException {
        Chapter newChapter = new ChapterImpl( context, instanceId, m_Name, m_Code, m_Ceiling_Fund, m_Request_Fund, m_Fund, ref_Year );
        if ( context.addInstance( newChapter ) ) {
            return newChapter;
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
        }
    }
    @Override
    public String getName() throws XtumlException {
        checkLiving();
        return m_Name;
    }
    private int m_Code;
    @Override
    public int getCode() throws XtumlException {
        checkLiving();
        return m_Code;
    }
    @Override
    public void setCode(int m_Code) throws XtumlException {
        checkLiving();
        if (m_Code != this.m_Code) {
            final int oldValue = this.m_Code;
            this.m_Code = m_Code;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Code", oldValue, this.m_Code));
        }
    }
    private double m_Ceiling_Fund;
    @Override
    public void setCeiling_Fund(double m_Ceiling_Fund) throws XtumlException {
        checkLiving();
        if (m_Ceiling_Fund != this.m_Ceiling_Fund) {
            final double oldValue = this.m_Ceiling_Fund;
            this.m_Ceiling_Fund = m_Ceiling_Fund;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Ceiling_Fund", oldValue, this.m_Ceiling_Fund));
        }
    }
    @Override
    public double getCeiling_Fund() throws XtumlException {
        checkLiving();
        return m_Ceiling_Fund;
    }
    private double m_Request_Fund;
    @Override
    public void setRequest_Fund(double m_Request_Fund) throws XtumlException {
        checkLiving();
        if (m_Request_Fund != this.m_Request_Fund) {
            final double oldValue = this.m_Request_Fund;
            this.m_Request_Fund = m_Request_Fund;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Request_Fund", oldValue, this.m_Request_Fund));
        }
    }
    @Override
    public double getRequest_Fund() throws XtumlException {
        checkLiving();
        return m_Request_Fund;
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
    private int ref_Year;
    @Override
    public int getYear() throws XtumlException {
        checkLiving();
        return ref_Year;
    }
    @Override
    public void setYear(int ref_Year) throws XtumlException {
        checkLiving();
        if (ref_Year != this.ref_Year) {
            final int oldValue = this.ref_Year;
            this.ref_Year = ref_Year;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "ref_Year", oldValue, this.ref_Year));
        }
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
    public static class CLASS extends ActionHome<Budget> {

        public CLASS( Budget context ) {
            super( context );
        }

        public void crud( final String p_Name,  final int p_Code,  final double p_Ceiling_Fund,  final double p_Request_Fund,  final double p_Fund,  final String p_Year,  final String p_Action ) throws XtumlException {
            Chapter chapter = context().Chapter_instances().anyWhere(selected -> StringUtil.equality(((Chapter)selected).getName(), p_Name) && StringUtil.equality(((Chapter)selected).getYear(), p_Year));
            if ( chapter.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Attempting to add a new chapter to employee." );
                Chapter c = ChapterImpl.create( context() );
                c.setName(p_Name);
                c.setFund(p_Fund);
                c.setCode(p_Code);
                c.setCeiling_Fund(p_Ceiling_Fund);
                c.setRequest_Fund(p_Request_Fund);
                Budget bud = context().Budget_instances().anyWhere(selected -> StringUtil.equality(((Budget)selected).getYear(), p_Year));
                context().relate_R1_Chapter_Budget( c, bud );
                context().UI_Fin().Reply( "budget created successfully.", true );
            }
            else if ( !chapter.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Attempting to add a new chapter." );
                context().LOG().LogInfo( "Chapter already exists." );
                context().UI_Fin().Reply( "Chapter already exists", false );
            }
            else if ( !chapter.isEmpty() && StringUtil.equality(p_Action, "UPDATE") ) {
                context().LOG().LogInfo( "Attempting to update chapter." );
                chapter.setName(p_Name);
                chapter.setCode(p_Code);
                context().LOG().LogInfo( "Chapter updated successfully." );
                context().UI_Fin().Reply( "Chapter updated successfully", true );
            }
            else if ( !chapter.isEmpty() && StringUtil.equality(p_Action, "DELETE") ) {
                context().LOG().LogInfo( "Attempting to delete a chapter instance." );
                context().LOG().LogInfo( "Chapter delete in not implemented yet." );
                context().UI_Fin().Reply( "Chapter delete in not implemented yet", false );
            }
            else if ( chapter.isEmpty() ) {
                context().LOG().LogInfo( "Chapter does not exist." );
                context().UI_Fin().Reply( "Chapter does not exist.", false );
            }
        }



    }


    // events


    // selections
    private Budget R1_Budget_inst;
    @Override
    public void setR1_Budget( Budget inst ) {
        R1_Budget_inst = inst;
    }
    @Override
    public Budget R1_Budget() throws XtumlException {
        return R1_Budget_inst;
    }
    private SectionSet R2_Section_set;
    @Override
    public void addR2_Section( Section inst ) {
        R2_Section_set.add(inst);
    }
    @Override
    public void removeR2_Section( Section inst ) {
        R2_Section_set.remove(inst);
    }
    @Override
    public SectionSet R2_Section() throws XtumlException {
        return R2_Section_set;
    }


    @Override
    public IRunContext getRunContext() {
        return context().getRunContext();
    }

    @Override
    public Budget context() {
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

class EmptyChapter extends ModelInstance<Chapter,Budget> implements Chapter {

    // attributes
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getCode() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setCode( int m_Code ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setCeiling_Fund( double m_Ceiling_Fund ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getCeiling_Fund() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setRequest_Fund( double m_Request_Fund ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getRequest_Fund() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public double getFund() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setFund( double m_Fund ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getYear() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setYear( int ref_Year ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Budget R1_Budget() {
        return BudgetImpl.EMPTY_BUDGET;
    }
    @Override
    public SectionSet R2_Section() {
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
