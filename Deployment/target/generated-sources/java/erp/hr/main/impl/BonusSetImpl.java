package erp.hr.main.impl;


import erp.hr.main.Bonus;
import erp.hr.main.BonusSet;
import erp.hr.main.Bonus_PaymentSet;
import erp.hr.main.impl.Bonus_PaymentSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class BonusSetImpl extends InstanceSet<BonusSet,Bonus> implements BonusSet {

    public BonusSetImpl() {
    }

    public BonusSetImpl(Comparator<? super Bonus> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setPercent( double m_Percent ) throws XtumlException {
        for ( Bonus bonus : this ) bonus.setPercent( m_Percent );
    }
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Bonus bonus : this ) bonus.setName( m_Name );
    }


    // selections
    @Override
    public Bonus_PaymentSet R4_Bonus_Payment() throws XtumlException {
        Bonus_PaymentSet bonus_paymentset = new Bonus_PaymentSetImpl();
        for ( Bonus bonus : this ) bonus_paymentset.addAll( bonus.R4_Bonus_Payment() );
        return bonus_paymentset;
    }


    @Override
    public Bonus nullElement() {
        return BonusImpl.EMPTY_BONUS;
    }

    @Override
    public BonusSet emptySet() {
      return new BonusSetImpl();
    }

    @Override
    public BonusSet emptySet(Comparator<? super Bonus> comp) {
      return new BonusSetImpl(comp);
    }

    @Override
    public List<Bonus> elements() {
        return Arrays.asList(toArray(new Bonus[0]));
    }

}
