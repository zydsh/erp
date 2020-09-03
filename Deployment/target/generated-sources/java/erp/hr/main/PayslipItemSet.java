package erp.hr.main;


import erp.hr.main.EmployeeSet;
import erp.hr.main.PayslipItemSet;

import hrm.hr.types.PayslipItemType;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface PayslipItemSet extends IInstanceSet<PayslipItemSet,PayslipItem> {

    // attributes
    public void setType( PayslipItemType m_Type ) throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setDate( int m_Date ) throws XtumlException;
    public void setAmount( double m_Amount ) throws XtumlException;


    // selections
    public PayslipItemSet R18_listed_after_PayslipItem() throws XtumlException;
    public PayslipItemSet R18_listed_before_PayslipItem() throws XtumlException;
    public EmployeeSet R3_records_an_earning_or_deduction_to_Employee() throws XtumlException;


}
