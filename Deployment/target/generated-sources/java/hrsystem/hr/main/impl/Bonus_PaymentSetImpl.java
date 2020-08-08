package hrsystem.hr.main.impl;


import hrsystem.hr.main.BonusSet;
import hrsystem.hr.main.Bonus_Payment;
import hrsystem.hr.main.Bonus_PaymentSet;
import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.impl.BonusSetImpl;
import hrsystem.hr.main.impl.EmployeeSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Bonus_PaymentSetImpl extends InstanceSet<Bonus_PaymentSet,Bonus_Payment> implements Bonus_PaymentSet {

    public Bonus_PaymentSetImpl() {
    }

    public Bonus_PaymentSetImpl(Comparator<? super Bonus_Payment> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setNational_ID( int ref_National_ID ) throws XtumlException {
        for ( Bonus_Payment bonus_payment : this ) bonus_payment.setNational_ID( ref_National_ID );
    }
    @Override
    public void setEnding( int m_Ending ) throws XtumlException {
        for ( Bonus_Payment bonus_payment : this ) bonus_payment.setEnding( m_Ending );
    }
    @Override
    public void setAmount( double m_Amount ) throws XtumlException {
        for ( Bonus_Payment bonus_payment : this ) bonus_payment.setAmount( m_Amount );
    }
    @Override
    public void setName( int ref_Name ) throws XtumlException {
        for ( Bonus_Payment bonus_payment : this ) bonus_payment.setName( ref_Name );
    }
    @Override
    public void setStarting( int m_Starting ) throws XtumlException {
        for ( Bonus_Payment bonus_payment : this ) bonus_payment.setStarting( m_Starting );
    }


    // selections
    @Override
    public BonusSet R4_Bonus() throws XtumlException {
        BonusSet bonusset = new BonusSetImpl();
        for ( Bonus_Payment bonus_payment : this ) bonusset.add( bonus_payment.R4_Bonus() );
        return bonusset;
    }
    @Override
    public EmployeeSet R4_Employee() throws XtumlException {
        EmployeeSet employeeset = new EmployeeSetImpl();
        for ( Bonus_Payment bonus_payment : this ) employeeset.add( bonus_payment.R4_Employee() );
        return employeeset;
    }


    @Override
    public Bonus_Payment nullElement() {
        return Bonus_PaymentImpl.EMPTY_BONUS_PAYMENT;
    }

    @Override
    public Bonus_PaymentSet emptySet() {
      return new Bonus_PaymentSetImpl();
    }

    @Override
    public Bonus_PaymentSet emptySet(Comparator<? super Bonus_Payment> comp) {
      return new Bonus_PaymentSetImpl(comp);
    }

    @Override
    public List<Bonus_Payment> elements() {
        return Arrays.asList(toArray(new Bonus_Payment[0]));
    }

}
