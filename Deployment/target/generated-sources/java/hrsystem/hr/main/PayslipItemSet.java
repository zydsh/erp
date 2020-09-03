package hrsystem.hr.main;


import hrm.hr.types.PayslipItemType;

import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.PayslipItemSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface PayslipItemSet extends IInstanceSet<PayslipItemSet,PayslipItem> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public void setDate( int m_Date ) throws XtumlException;
    public void setAmount( double m_Amount ) throws XtumlException;
    public void setType( PayslipItemType m_Type ) throws XtumlException;


    // selections
    public PayslipItemSet R18_listed_after_PayslipItem() throws XtumlException;
    public PayslipItemSet R18_listed_before_PayslipItem() throws XtumlException;
    public EmployeeSet R3_records_an_earning_or_deduction_to_Employee() throws XtumlException;


}
