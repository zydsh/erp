package hrsystem.fms.budgeting;


import hrsystem.fms.budgeting.ChapterSet;
import hrsystem.fms.budgeting.ItemSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface SectionSet extends IInstanceSet<SectionSet,Section> {

    // attributes
    public void setComments( String m_Comments ) throws XtumlException;
    public void setApprovedFunds( double m_ApprovedFunds ) throws XtumlException;
    public void setTotalSpending( double m_TotalSpending ) throws XtumlException;
    public void setRequestedFund( double m_RequestedFund ) throws XtumlException;
    public void setPostponedFund( double m_PostponedFund ) throws XtumlException;
    public void setCode( String m_Code ) throws XtumlException;
    public void setEconomicCategory( String m_EconomicCategory ) throws XtumlException;
    public void setFundvsIncome( double m_FundvsIncome ) throws XtumlException;
    public void setOriginalFund( double m_OriginalFund ) throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setRemainingExpenses( double m_RemainingExpenses ) throws XtumlException;
    public void setBalance( double m_Balance ) throws XtumlException;
    public void setAmount( double m_Amount ) throws XtumlException;


    // selections
    public ChapterSet R200_belongs_Chapter() throws XtumlException;
    public ItemSet R3_assigned_Item() throws XtumlException;


}
