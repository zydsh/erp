package hrsystem.fm.main.impl;


import hrsystem.fm.main.ChapterSet;
import hrsystem.fm.main.ItemSet;
import hrsystem.fm.main.Section;
import hrsystem.fm.main.SectionSet;
import hrsystem.fm.main.impl.ChapterSetImpl;
import hrsystem.fm.main.impl.ItemSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class SectionSetImpl extends InstanceSet<SectionSet,Section> implements SectionSet {

    public SectionSetImpl() {
    }

    public SectionSetImpl(Comparator<? super Section> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setCode( String m_Code ) throws XtumlException {
        for ( Section section : this ) section.setCode( m_Code );
    }
    @Override
    public void setEconomic_Category( String m_Economic_Category ) throws XtumlException {
        for ( Section section : this ) section.setEconomic_Category( m_Economic_Category );
    }
    @Override
    public void setComments( String m_Comments ) throws XtumlException {
        for ( Section section : this ) section.setComments( m_Comments );
    }
    @Override
    public void setSecID( String m_SecID ) throws XtumlException {
        for ( Section section : this ) section.setSecID( m_SecID );
    }
    @Override
    public void setFund( double m_Fund ) throws XtumlException {
        for ( Section section : this ) section.setFund( m_Fund );
    }
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Section section : this ) section.setName( m_Name );
    }


    // selections
    @Override
    public ChapterSet R2_Chapter() throws XtumlException {
        ChapterSet chapterset = new ChapterSetImpl();
        for ( Section section : this ) chapterset.add( section.R2_Chapter() );
        return chapterset;
    }
    @Override
    public ItemSet R3_Item() throws XtumlException {
        ItemSet itemset = new ItemSetImpl();
        for ( Section section : this ) itemset.addAll( section.R3_Item() );
        return itemset;
    }


    @Override
    public Section nullElement() {
        return SectionImpl.EMPTY_SECTION;
    }

    @Override
    public SectionSet emptySet() {
      return new SectionSetImpl();
    }

    @Override
    public SectionSet emptySet(Comparator<? super Section> comp) {
      return new SectionSetImpl(comp);
    }

    @Override
    public List<Section> elements() {
        return Arrays.asList(toArray(new Section[0]));
    }

}
