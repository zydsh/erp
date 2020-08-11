package hrsystem.fm.main.impl;


import hrsystem.fm.main.BudgetSet;
import hrsystem.fm.main.Chapter;
import hrsystem.fm.main.ChapterSet;
import hrsystem.fm.main.SectionSet;
import hrsystem.fm.main.impl.BudgetSetImpl;
import hrsystem.fm.main.impl.SectionSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class ChapterSetImpl extends InstanceSet<ChapterSet,Chapter> implements ChapterSet {

    public ChapterSetImpl() {
    }

    public ChapterSetImpl(Comparator<? super Chapter> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setCeiling_Fund( double m_Ceiling_Fund ) throws XtumlException {
        for ( Chapter chapter : this ) chapter.setCeiling_Fund( m_Ceiling_Fund );
    }
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Chapter chapter : this ) chapter.setName( m_Name );
    }
    @Override
    public void setYear( String m_Year ) throws XtumlException {
        for ( Chapter chapter : this ) chapter.setYear( m_Year );
    }
    @Override
    public void setRequest_Fund( double m_Request_Fund ) throws XtumlException {
        for ( Chapter chapter : this ) chapter.setRequest_Fund( m_Request_Fund );
    }
    @Override
    public void setCode( String m_Code ) throws XtumlException {
        for ( Chapter chapter : this ) chapter.setCode( m_Code );
    }
    @Override
    public void setFund( double m_Fund ) throws XtumlException {
        for ( Chapter chapter : this ) chapter.setFund( m_Fund );
    }


    // selections
    @Override
    public BudgetSet R1_Budget() throws XtumlException {
        BudgetSet budgetset = new BudgetSetImpl();
        for ( Chapter chapter : this ) budgetset.add( chapter.R1_Budget() );
        return budgetset;
    }
    @Override
    public SectionSet R2_Section() throws XtumlException {
        SectionSet sectionset = new SectionSetImpl();
        for ( Chapter chapter : this ) sectionset.addAll( chapter.R2_Section() );
        return sectionset;
    }


    @Override
    public Chapter nullElement() {
        return ChapterImpl.EMPTY_CHAPTER;
    }

    @Override
    public ChapterSet emptySet() {
      return new ChapterSetImpl();
    }

    @Override
    public ChapterSet emptySet(Comparator<? super Chapter> comp) {
      return new ChapterSetImpl(comp);
    }

    @Override
    public List<Chapter> elements() {
        return Arrays.asList(toArray(new Chapter[0]));
    }

}
