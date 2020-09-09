package hrsystem.fms.budgeting.impl;


import hrsystem.fms.budgeting.ChapterSet;
import hrsystem.fms.budgeting.ItemSet;
import hrsystem.fms.budgeting.Section;
import hrsystem.fms.budgeting.SectionSet;
import hrsystem.fms.budgeting.impl.ChapterSetImpl;
import hrsystem.fms.budgeting.impl.ItemSetImpl;

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
    public void setPostponedFund( double m_PostponedFund ) throws XtumlException {
        for ( Section section : this ) section.setPostponedFund( m_PostponedFund );
    }
    @Override
    public void setOriginalFund( double m_OriginalFund ) throws XtumlException {
        for ( Section section : this ) section.setOriginalFund( m_OriginalFund );
    }
    @Override
    public void setBalance( double m_Balance ) throws XtumlException {
        for ( Section section : this ) section.setBalance( m_Balance );
    }
    @Override
    public void setCode( String m_Code ) throws XtumlException {
        for ( Section section : this ) section.setCode( m_Code );
    }
    @Override
    public void setApprovedFunds( double m_ApprovedFunds ) throws XtumlException {
        for ( Section section : this ) section.setApprovedFunds( m_ApprovedFunds );
    }
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Section section : this ) section.setName( m_Name );
    }
    @Override
    public void setComments( String m_Comments ) throws XtumlException {
        for ( Section section : this ) section.setComments( m_Comments );
    }
    @Override
    public void setRequestedFund( double m_RequestedFund ) throws XtumlException {
        for ( Section section : this ) section.setRequestedFund( m_RequestedFund );
    }
    @Override
    public void setRemainingExpenses( double m_RemainingExpenses ) throws XtumlException {
        for ( Section section : this ) section.setRemainingExpenses( m_RemainingExpenses );
    }
    @Override
    public void setFundvsIncome( double m_FundvsIncome ) throws XtumlException {
        for ( Section section : this ) section.setFundvsIncome( m_FundvsIncome );
    }
    @Override
    public void setEconomicCategory( String m_EconomicCategory ) throws XtumlException {
        for ( Section section : this ) section.setEconomicCategory( m_EconomicCategory );
    }
    @Override
    public void setTotalSpending( double m_TotalSpending ) throws XtumlException {
        for ( Section section : this ) section.setTotalSpending( m_TotalSpending );
    }
    @Override
    public void setAmount( double m_Amount ) throws XtumlException {
        for ( Section section : this ) section.setAmount( m_Amount );
    }


    // selections
    @Override
    public ChapterSet R200_belongs_Chapter() throws XtumlException {
        ChapterSet chapterset = new ChapterSetImpl();
        for ( Section section : this ) chapterset.add( section.R200_belongs_Chapter() );
        return chapterset;
    }
    @Override
    public ItemSet R3_assigned_Item() throws XtumlException {
        ItemSet itemset = new ItemSetImpl();
        for ( Section section : this ) itemset.addAll( section.R3_assigned_Item() );
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
