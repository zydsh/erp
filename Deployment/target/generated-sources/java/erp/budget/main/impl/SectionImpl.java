package erp.budget.main.impl;


import erp.Budget;
import erp.budget.main.Chapter;
import erp.budget.main.Item;
import erp.budget.main.ItemSet;
import erp.budget.main.Section;
import erp.budget.main.impl.ChapterImpl;
import erp.budget.main.impl.ItemSetImpl;
import erp.budget.main.impl.SectionImpl;

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


public class SectionImpl extends ModelInstance<Section,Budget> implements Section {

    public static final String KEY_LETTERS = "Section";
    public static final Section EMPTY_SECTION = new EmptySection();

    private Budget context;

    // constructors
    private SectionImpl( Budget context ) {
        this.context = context;
        m_ID = "";
        m_Code = 0;
        m_Name = "";
        m_Fund = 0d;
        m_Economic_Category = "";
        m_Comments = "";
        R2_Chapter_inst = ChapterImpl.EMPTY_CHAPTER;
        R3_Item_set = new ItemSetImpl();
    }

    private SectionImpl( Budget context, UniqueId instanceId, String m_ID, int m_Code, String m_Name, double m_Fund, String m_Economic_Category, String m_Comments ) {
        super(instanceId);
        this.context = context;
        this.m_ID = m_ID;
        this.m_Code = m_Code;
        this.m_Name = m_Name;
        this.m_Fund = m_Fund;
        this.m_Economic_Category = m_Economic_Category;
        this.m_Comments = m_Comments;
        R2_Chapter_inst = ChapterImpl.EMPTY_CHAPTER;
        R3_Item_set = new ItemSetImpl();
    }

    public static Section create( Budget context ) throws XtumlException {
        Section newSection = new SectionImpl( context );
        if ( context.addInstance( newSection ) ) {
            newSection.getRunContext().addChange(new InstanceCreatedDelta(newSection, KEY_LETTERS));
            return newSection;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Section create( Budget context, UniqueId instanceId, String m_ID, int m_Code, String m_Name, double m_Fund, String m_Economic_Category, String m_Comments ) throws XtumlException {
        Section newSection = new SectionImpl( context, instanceId, m_ID, m_Code, m_Name, m_Fund, m_Economic_Category, m_Comments );
        if ( context.addInstance( newSection ) ) {
            return newSection;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private String m_ID;
    @Override
    public String getID() throws XtumlException {
        checkLiving();
        return m_ID;
    }
    @Override
    public void setID(String m_ID) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_ID, this.m_ID)) {
            final String oldValue = this.m_ID;
            this.m_ID = m_ID;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_ID", oldValue, this.m_ID));
        }
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
    private double m_Fund;
    @Override
    public void setFund(double m_Fund) throws XtumlException {
        checkLiving();
        if (m_Fund != this.m_Fund) {
            final double oldValue = this.m_Fund;
            this.m_Fund = m_Fund;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Fund", oldValue, this.m_Fund));
        }
    }
    @Override
    public double getFund() throws XtumlException {
        checkLiving();
        return m_Fund;
    }
    private String m_Economic_Category;
    @Override
    public String getEconomic_Category() throws XtumlException {
        checkLiving();
        return m_Economic_Category;
    }
    @Override
    public void setEconomic_Category(String m_Economic_Category) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Economic_Category, this.m_Economic_Category)) {
            final String oldValue = this.m_Economic_Category;
            this.m_Economic_Category = m_Economic_Category;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Economic_Category", oldValue, this.m_Economic_Category));
        }
    }
    private String m_Comments;
    @Override
    public void setComments(String m_Comments) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Comments, this.m_Comments)) {
            final String oldValue = this.m_Comments;
            this.m_Comments = m_Comments;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Comments", oldValue, this.m_Comments));
        }
    }
    @Override
    public String getComments() throws XtumlException {
        checkLiving();
        return m_Comments;
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getCode(), getName());
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
            return new InstanceIdentifier(getID());
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

        public void crud( final int p_Code,  final String p_Name,  final double p_Fund,  final String p_Economic_Category,  final String p_Comments,  final String p_Action,  final String p_Year,  final String p_ID ) throws XtumlException {
            Section section = context().Section_instances().anyWhere(selected -> StringUtil.equality(((Section)selected).getID(), p_ID));
            if ( section.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Attempting to add a new section to employee." );
                Section s = SectionImpl.create( context() );
                s.setName(p_Name);
                s.setFund(p_Fund);
                s.setCode(p_Code);
                s.setEconomic_Category(p_Economic_Category);
                s.setComments(p_Comments);
                Chapter chapter = context().Chapter_instances().anyWhere(selected -> StringUtil.equality(((Chapter)selected).getYear(), p_Year));
                context().relate_R2_Section_Chapter( s, chapter );
                context().UI_Fin().Reply( "budget created successfully.", true );
            }
            else if ( !section.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Attempting to add a new section." );
                context().LOG().LogInfo( "Section already exists." );
                context().UI_Fin().Reply( "Section already exists", false );
            }
            else if ( !section.isEmpty() && StringUtil.equality(p_Action, "UPDATE") ) {
                context().LOG().LogInfo( "Attempting to update section." );
                section.setName(p_Name);
                section.setFund(p_Fund);
                section.setCode(p_Code);
                section.setEconomic_Category(p_Economic_Category);
                section.setComments(p_Comments);
                context().LOG().LogInfo( "Section updated successfully." );
                context().UI_Fin().Reply( "Section updated successfully", true );
            }
            else if ( !section.isEmpty() && StringUtil.equality(p_Action, "DELETE") ) {
                context().LOG().LogInfo( "Attempting to delete a section instance." );
                context().LOG().LogInfo( "Section delete in not implemented yet." );
                context().UI_Fin().Reply( "Section delete in not implemented yet", false );
            }
            else if ( section.isEmpty() ) {
                context().LOG().LogInfo( "Section does not exist." );
                context().UI_Fin().Reply( "Section does not exist.", false );
            }
        }



    }


    // events


    // selections
    private Chapter R2_Chapter_inst;
    @Override
    public void setR2_Chapter( Chapter inst ) {
        R2_Chapter_inst = inst;
    }
    @Override
    public Chapter R2_Chapter() throws XtumlException {
        return R2_Chapter_inst;
    }
    private ItemSet R3_Item_set;
    @Override
    public void addR3_Item( Item inst ) {
        R3_Item_set.add(inst);
    }
    @Override
    public void removeR3_Item( Item inst ) {
        R3_Item_set.remove(inst);
    }
    @Override
    public ItemSet R3_Item() throws XtumlException {
        return R3_Item_set;
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
    public Section self() {
        return this;
    }

    @Override
    public Section oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_SECTION;
    }

}

class EmptySection extends ModelInstance<Section,Budget> implements Section {

    // attributes
    public String getID() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setID( String m_ID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getCode() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setCode( int m_Code ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setFund( double m_Fund ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getFund() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public String getEconomic_Category() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setEconomic_Category( String m_Economic_Category ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setComments( String m_Comments ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getComments() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Chapter R2_Chapter() {
        return ChapterImpl.EMPTY_CHAPTER;
    }
    @Override
    public ItemSet R3_Item() {
        return (new ItemSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return SectionImpl.KEY_LETTERS;
    }

    @Override
    public Section self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Section oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return SectionImpl.EMPTY_SECTION;
    }

}
