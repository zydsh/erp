package hrsystem.hr.main;


import hrm.hr.types.PayslipItemType;

import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.PayslipItem;
import hrsystem.hr.main.PayslipItemSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface PayslipItem extends IModelInstance<PayslipItem,Hr> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public String getName() throws XtumlException;
    public void setAmount( double m_Amount ) throws XtumlException;
    public double getAmount() throws XtumlException;
    public void setDate( int m_Date ) throws XtumlException;
    public int getDate() throws XtumlException;
    public PayslipItemType getType() throws XtumlException;
    public void setType( PayslipItemType m_Type ) throws XtumlException;


    // operations


    // selections
    default public void addR18_listed_after_PayslipItem( PayslipItem inst ) {}
    default public void removeR18_listed_after_PayslipItem( PayslipItem inst ) {}
    public PayslipItemSet R18_listed_after_PayslipItem() throws XtumlException;
    default public void addR18_listed_before_PayslipItem( PayslipItem inst ) {}
    default public void removeR18_listed_before_PayslipItem( PayslipItem inst ) {}
    public PayslipItemSet R18_listed_before_PayslipItem() throws XtumlException;
    default public void setR3_records_an_earning_or_deduction_to_Employee( Employee inst ) {}
    public Employee R3_records_an_earning_or_deduction_to_Employee() throws XtumlException;


}
