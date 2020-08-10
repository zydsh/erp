package erp.budget.main.impl;


import erp.Budget;
import erp.budget.main.Item;
import erp.budget.main.Section;
import erp.budget.main.impl.ItemImpl;
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


public class ItemImpl extends ModelInstance<Item,Budget> implements Item {

    public static final String KEY_LETTERS = "Item";
    public static final Item EMPTY_ITEM = new EmptyItem();

    private Budget context;

    // constructors
    private ItemImpl( Budget context ) {
        this.context = context;
        m_ID = "";
        m_Fund = 0d;
        m_Status = "";
        m_Type = "";
        m_Category = "";
        R3_Section_inst = SectionImpl.EMPTY_SECTION;
    }

    private ItemImpl( Budget context, UniqueId instanceId, String m_ID, double m_Fund, String m_Status, String m_Type, String m_Category ) {
        super(instanceId);
        this.context = context;
        this.m_ID = m_ID;
        this.m_Fund = m_Fund;
        this.m_Status = m_Status;
        this.m_Type = m_Type;
        this.m_Category = m_Category;
        R3_Section_inst = SectionImpl.EMPTY_SECTION;
    }

    public static Item create( Budget context ) throws XtumlException {
        Item newItem = new ItemImpl( context );
        if ( context.addInstance( newItem ) ) {
            newItem.getRunContext().addChange(new InstanceCreatedDelta(newItem, KEY_LETTERS));
            return newItem;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Item create( Budget context, UniqueId instanceId, String m_ID, double m_Fund, String m_Status, String m_Type, String m_Category ) throws XtumlException {
        Item newItem = new ItemImpl( context, instanceId, m_ID, m_Fund, m_Status, m_Type, m_Category );
        if ( context.addInstance( newItem ) ) {
            return newItem;
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
    private String m_Status;
    @Override
    public void setStatus(String m_Status) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Status, this.m_Status)) {
            final String oldValue = this.m_Status;
            this.m_Status = m_Status;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Status", oldValue, this.m_Status));
        }
    }
    @Override
    public String getStatus() throws XtumlException {
        checkLiving();
        return m_Status;
    }
    private String m_Type;
    @Override
    public void setType(String m_Type) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Type, this.m_Type)) {
            final String oldValue = this.m_Type;
            this.m_Type = m_Type;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Type", oldValue, this.m_Type));
        }
    }
    @Override
    public String getType() throws XtumlException {
        checkLiving();
        return m_Type;
    }
    private String m_Category;
    @Override
    public String getCategory() throws XtumlException {
        checkLiving();
        return m_Category;
    }
    @Override
    public void setCategory(String m_Category) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Category, this.m_Category)) {
            final String oldValue = this.m_Category;
            this.m_Category = m_Category;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Category", oldValue, this.m_Category));
        }
    }


    // instance identifiers

    // operations


    // static operations
    public static class CLASS extends ActionHome<Budget> {

        public CLASS( Budget context ) {
            super( context );
        }

        public void crud( final double p_Fund,  final String p_Status,  final String p_Type,  final String p_Category,  final String p_Action,  final String p_ID,  final String p_Section_ID ) throws XtumlException {
            Item item = context().Item_instances().anyWhere(selected -> StringUtil.equality(((Item)selected).getID(), p_ID));
            if ( item.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Attempting to add a new item to employee." );
                Item i = ItemImpl.create( context() );
                i.setID(p_ID);
                i.setFund(p_Fund);
                i.setStatus(p_Status);
                i.setType(p_Type);
                i.setCategory(p_Category);
                Section section = context().Section_instances().anyWhere(selected -> StringUtil.equality(((Section)selected).getID(), p_Section_ID));
                context().relate_R3_Item_Section( i, section );
                context().UI_Fin().Reply( "budget created successfully.", true );
            }
            else if ( !item.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Attempting to add a new item." );
                context().LOG().LogInfo( "Item already exists." );
                context().UI_Fin().Reply( "Item already exists", false );
            }
            else if ( !item.isEmpty() && StringUtil.equality(p_Action, "UPDATE") ) {
                context().LOG().LogInfo( "Attempting to update item." );
                item.setStatus(p_Status);
                item.setFund(p_Fund);
                item.setType(p_Type);
                item.setCategory(p_Category);
                context().LOG().LogInfo( "Item updated successfully." );
                context().UI_Fin().Reply( "Item updated successfully", true );
            }
            else if ( !item.isEmpty() && StringUtil.equality(p_Action, "DELETE") ) {
                context().LOG().LogInfo( "Attempting to delete a item instance." );
                context().LOG().LogInfo( "Item delete in not implemented yet." );
                context().UI_Fin().Reply( "Item delete in not implemented yet", false );
            }
            else if ( item.isEmpty() ) {
                context().LOG().LogInfo( "Item does not exist." );
                context().UI_Fin().Reply( "Item does not exist.", false );
            }
        }



    }


    // events


    // selections
    private Section R3_Section_inst;
    @Override
    public void setR3_Section( Section inst ) {
        R3_Section_inst = inst;
    }
    @Override
    public Section R3_Section() throws XtumlException {
        return R3_Section_inst;
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
    public Item self() {
        return this;
    }

    @Override
    public Item oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_ITEM;
    }

}

class EmptyItem extends ModelInstance<Item,Budget> implements Item {

    // attributes
    public String getID() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setID( String m_ID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getFund() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setFund( double m_Fund ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setStatus( String m_Status ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getStatus() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setType( String m_Type ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getType() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public String getCategory() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setCategory( String m_Category ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Section R3_Section() {
        return SectionImpl.EMPTY_SECTION;
    }


    @Override
    public String getKeyLetters() {
        return ItemImpl.KEY_LETTERS;
    }

    @Override
    public Item self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Item oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return ItemImpl.EMPTY_ITEM;
    }

}
