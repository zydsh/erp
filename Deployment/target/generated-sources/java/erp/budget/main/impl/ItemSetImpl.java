package erp.budget.main.impl;


import erp.budget.main.Item;
import erp.budget.main.ItemSet;
import erp.budget.main.SectionSet;
import erp.budget.main.impl.SectionSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class ItemSetImpl extends InstanceSet<ItemSet,Item> implements ItemSet {

    public ItemSetImpl() {
    }

    public ItemSetImpl(Comparator<? super Item> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setStatus( String m_Status ) throws XtumlException {
        for ( Item item : this ) item.setStatus( m_Status );
    }
    @Override
    public void setID( String m_ID ) throws XtumlException {
        for ( Item item : this ) item.setID( m_ID );
    }
    @Override
    public void setFund( double m_Fund ) throws XtumlException {
        for ( Item item : this ) item.setFund( m_Fund );
    }
    @Override
    public void setType( String m_Type ) throws XtumlException {
        for ( Item item : this ) item.setType( m_Type );
    }
    @Override
    public void setCategory( String m_Category ) throws XtumlException {
        for ( Item item : this ) item.setCategory( m_Category );
    }


    // selections
    @Override
    public SectionSet R3_Section() throws XtumlException {
        SectionSet sectionset = new SectionSetImpl();
        for ( Item item : this ) sectionset.add( item.R3_Section() );
        return sectionset;
    }


    @Override
    public Item nullElement() {
        return ItemImpl.EMPTY_ITEM;
    }

    @Override
    public ItemSet emptySet() {
      return new ItemSetImpl();
    }

    @Override
    public ItemSet emptySet(Comparator<? super Item> comp) {
      return new ItemSetImpl(comp);
    }

    @Override
    public List<Item> elements() {
        return Arrays.asList(toArray(new Item[0]));
    }

}
