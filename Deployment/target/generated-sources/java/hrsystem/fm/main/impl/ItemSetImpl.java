package hrsystem.fm.main.impl;


import hrsystem.fm.main.Item;
import hrsystem.fm.main.ItemSet;
import hrsystem.fm.main.SectionSet;
import hrsystem.fm.main.impl.SectionSetImpl;

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
    public void setItemID( String m_ItemID ) throws XtumlException {
        for ( Item item : this ) item.setItemID( m_ItemID );
    }
    @Override
    public void setCategory( String m_Category ) throws XtumlException {
        for ( Item item : this ) item.setCategory( m_Category );
    }
    @Override
    public void setStatus( String m_Status ) throws XtumlException {
        for ( Item item : this ) item.setStatus( m_Status );
    }
    @Override
    public void setFund( double m_Fund ) throws XtumlException {
        for ( Item item : this ) item.setFund( m_Fund );
    }
    @Override
    public void setType( String m_Type ) throws XtumlException {
        for ( Item item : this ) item.setType( m_Type );
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
