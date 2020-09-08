package hrsystem.fms.budgeting.impl;


import hrsystem.Fms;
import hrsystem.fms.budgeting.Item;
import hrsystem.fms.budgeting.Section;
import hrsystem.fms.budgeting.impl.SectionImpl;

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


public class ItemImpl extends ModelInstance<Item,Fms> implements Item {

    public static final String KEY_LETTERS = "Item";
    public static final Item EMPTY_ITEM = new EmptyItem();

    private Fms context;

    // constructors
    private ItemImpl( Fms context ) {
        this.context = context;
        m_Category = "";
        m_Type = "";
        m_Status = "";
        m_Fund = 0;
        R3_attributed_to_Section_inst = SectionImpl.EMPTY_SECTION;
    }

    private ItemImpl( Fms context, UniqueId instanceId, String m_Category, String m_Type, String m_Status, int m_Fund ) {
        super(instanceId);
        this.context = context;
        this.m_Category = m_Category;
        this.m_Type = m_Type;
        this.m_Status = m_Status;
        this.m_Fund = m_Fund;
        R3_attributed_to_Section_inst = SectionImpl.EMPTY_SECTION;
    }

    public static Item create( Fms context ) throws XtumlException {
        Item newItem = new ItemImpl( context );
        if ( context.addInstance( newItem ) ) {
            newItem.getRunContext().addChange(new InstanceCreatedDelta(newItem, KEY_LETTERS));
            return newItem;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Item create( Fms context, UniqueId instanceId, String m_Category, String m_Type, String m_Status, int m_Fund ) throws XtumlException {
        Item newItem = new ItemImpl( context, instanceId, m_Category, m_Type, m_Status, m_Fund );
        if ( context.addInstance( newItem ) ) {
            return newItem;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private String m_Category;
    @Override
    public void setCategory(String m_Category) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Category, this.m_Category)) {
            final String oldValue = this.m_Category;
            this.m_Category = m_Category;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Category", oldValue, this.m_Category));
        }
    }
    @Override
    public String getCategory() throws XtumlException {
        checkLiving();
        return m_Category;
    }
    private String m_Type;
    @Override
    public String getType() throws XtumlException {
        checkLiving();
        return m_Type;
    }
    @Override
    public void setType(String m_Type) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Type, this.m_Type)) {
            final String oldValue = this.m_Type;
            this.m_Type = m_Type;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Type", oldValue, this.m_Type));
        }
    }
    private String m_Status;
    @Override
    public String getStatus() throws XtumlException {
        checkLiving();
        return m_Status;
    }
    @Override
    public void setStatus(String m_Status) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Status, this.m_Status)) {
            final String oldValue = this.m_Status;
            this.m_Status = m_Status;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Status", oldValue, this.m_Status));
        }
    }
    private int m_Fund;
    @Override
    public int getFund() throws XtumlException {
        checkLiving();
        return m_Fund;
    }
    @Override
    public void setFund(int m_Fund) throws XtumlException {
        checkLiving();
        if (m_Fund != this.m_Fund) {
            final int oldValue = this.m_Fund;
            this.m_Fund = m_Fund;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Fund", oldValue, this.m_Fund));
        }
    }


    // instance identifiers

    // operations


    // static operations


    // events


    // selections
    private Section R3_attributed_to_Section_inst;
    @Override
    public void setR3_attributed_to_Section( Section inst ) {
        R3_attributed_to_Section_inst = inst;
    }
    @Override
    public Section R3_attributed_to_Section() throws XtumlException {
        return R3_attributed_to_Section_inst;
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

class EmptyItem extends ModelInstance<Item,Fms> implements Item {

    // attributes
    public void setCategory( String m_Category ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getCategory() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public String getType() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setType( String m_Type ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getStatus() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setStatus( String m_Status ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getFund() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setFund( int m_Fund ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Section R3_attributed_to_Section() {
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
