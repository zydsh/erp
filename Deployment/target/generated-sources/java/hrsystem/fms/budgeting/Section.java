package hrsystem.fms.budgeting;


import hrsystem.Fms;
import hrsystem.fms.budgeting.Chapter;
import hrsystem.fms.budgeting.Item;
import hrsystem.fms.budgeting.ItemSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Section extends IModelInstance<Section,Fms> {

    // attributes
    public void setCode( String m_Code ) throws XtumlException;
    public String getCode() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public String getName() throws XtumlException;
    public double getAmount() throws XtumlException;
    public void setAmount( double m_Amount ) throws XtumlException;
    public void setApprovedFunds( double m_ApprovedFunds ) throws XtumlException;
    public double getApprovedFunds() throws XtumlException;
    public void setTotalSpending( double m_TotalSpending ) throws XtumlException;
    public double getTotalSpending() throws XtumlException;
    public double getRemainingExpenses() throws XtumlException;
    public void setRemainingExpenses( double m_RemainingExpenses ) throws XtumlException;
    public void setOriginalFund( double m_OriginalFund ) throws XtumlException;
    public double getOriginalFund() throws XtumlException;
    public void setFundvsIncome( double m_FundvsIncome ) throws XtumlException;
    public double getFundvsIncome() throws XtumlException;
    public void setPostponedFund( double m_PostponedFund ) throws XtumlException;
    public double getPostponedFund() throws XtumlException;
    public void setBalance( double m_Balance ) throws XtumlException;
    public double getBalance() throws XtumlException;
    public void setRequestedFund( double m_RequestedFund ) throws XtumlException;
    public double getRequestedFund() throws XtumlException;
    public String getEconomicCategory() throws XtumlException;
    public void setEconomicCategory( String m_EconomicCategory ) throws XtumlException;
    public String getComments() throws XtumlException;
    public void setComments( String m_Comments ) throws XtumlException;


    // operations


    // selections
    default public void setR200_belongs_Chapter( Chapter inst ) {}
    public Chapter R200_belongs_Chapter() throws XtumlException;
    default public void addR3_assigned_Item( Item inst ) {}
    default public void removeR3_assigned_Item( Item inst ) {}
    public ItemSet R3_assigned_Item() throws XtumlException;


}
