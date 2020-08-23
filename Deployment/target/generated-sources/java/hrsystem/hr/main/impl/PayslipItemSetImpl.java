package hrsystem.hr.main.impl;


import hrm.hr.types.PayslipItemType;

import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.PayslipItem;
import hrsystem.hr.main.PayslipItemSet;
import hrsystem.hr.main.impl.EmployeeSetImpl;
import hrsystem.hr.main.impl.PayslipItemSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class PayslipItemSetImpl extends InstanceSet<PayslipItemSet,PayslipItem> implements PayslipItemSet {

    public PayslipItemSetImpl() {
    }

    public PayslipItemSetImpl(Comparator<? super PayslipItem> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( PayslipItem payslipitem : this ) payslipitem.setName( m_Name );
    }
    @Override
    public void setDate( int m_Date ) throws XtumlException {
        for ( PayslipItem payslipitem : this ) payslipitem.setDate( m_Date );
    }
    @Override
    public void setAmount( double m_Amount ) throws XtumlException {
        for ( PayslipItem payslipitem : this ) payslipitem.setAmount( m_Amount );
    }
    @Override
    public void setType( PayslipItemType m_Type ) throws XtumlException {
        for ( PayslipItem payslipitem : this ) payslipitem.setType( m_Type );
    }


    // selections
    @Override
    public PayslipItemSet R18_listed_after_PayslipItem() throws XtumlException {
        PayslipItemSet payslipitemset = new PayslipItemSetImpl();
        for ( PayslipItem payslipitem : this ) payslipitemset.addAll( payslipitem.R18_listed_after_PayslipItem() );
        return payslipitemset;
    }
    @Override
    public PayslipItemSet R18_listed_before_PayslipItem() throws XtumlException {
        PayslipItemSet payslipitemset = new PayslipItemSetImpl();
        for ( PayslipItem payslipitem : this ) payslipitemset.addAll( payslipitem.R18_listed_before_PayslipItem() );
        return payslipitemset;
    }
    @Override
    public EmployeeSet R3_records_an_earning_or_deduction_to_Employee() throws XtumlException {
        EmployeeSet employeeset = new EmployeeSetImpl();
        for ( PayslipItem payslipitem : this ) employeeset.add( payslipitem.R3_records_an_earning_or_deduction_to_Employee() );
        return employeeset;
    }


    @Override
    public PayslipItem nullElement() {
        return PayslipItemImpl.EMPTY_PAYSLIPITEM;
    }

    @Override
    public PayslipItemSet emptySet() {
      return new PayslipItemSetImpl();
    }

    @Override
    public PayslipItemSet emptySet(Comparator<? super PayslipItem> comp) {
      return new PayslipItemSetImpl(comp);
    }

    @Override
    public List<PayslipItem> elements() {
        return Arrays.asList(toArray(new PayslipItem[0]));
    }

}
