package hrsystem.fms.budgeting.impl;


import hrsystem.fms.budgeting.BudgetSet;
import hrsystem.fms.budgeting.Chapter;
import hrsystem.fms.budgeting.ChapterSet;
import hrsystem.fms.budgeting.SectionSet;
import hrsystem.fms.budgeting.impl.BudgetSetImpl;
import hrsystem.fms.budgeting.impl.SectionSetImpl;

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
    public void setCeilingFund( double m_CeilingFund ) throws XtumlException {
        for ( Chapter chapter : this ) chapter.setCeilingFund( m_CeilingFund );
    }
    @Override
    public void setCode( String m_Code ) throws XtumlException {
        for ( Chapter chapter : this ) chapter.setCode( m_Code );
    }
    @Override
    public void setRequestFund( double m_RequestFund ) throws XtumlException {
        for ( Chapter chapter : this ) chapter.setRequestFund( m_RequestFund );
    }
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Chapter chapter : this ) chapter.setName( m_Name );
    }


    // selections
    @Override
    public BudgetSet R100_belongs_Budget() throws XtumlException {
        BudgetSet budgetset = new BudgetSetImpl();
        for ( Chapter chapter : this ) budgetset.add( chapter.R100_belongs_Budget() );
        return budgetset;
    }
    @Override
    public SectionSet R200_divided_Section() throws XtumlException {
        SectionSet sectionset = new SectionSetImpl();
        for ( Chapter chapter : this ) sectionset.addAll( chapter.R200_divided_Section() );
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
