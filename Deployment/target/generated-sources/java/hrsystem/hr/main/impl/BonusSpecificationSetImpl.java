package hrsystem.hr.main.impl;


import hrsystem.hr.main.BonusSet;
import hrsystem.hr.main.BonusSpecification;
import hrsystem.hr.main.BonusSpecificationSet;
import hrsystem.hr.main.impl.BonusSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class BonusSpecificationSetImpl extends InstanceSet<BonusSpecificationSet,BonusSpecification> implements BonusSpecificationSet {

    public BonusSpecificationSetImpl() {
    }

    public BonusSpecificationSetImpl(Comparator<? super BonusSpecification> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( BonusSpecification bonusspecification : this ) bonusspecification.setName( m_Name );
    }
    @Override
    public void setPercent( double m_Percent ) throws XtumlException {
        for ( BonusSpecification bonusspecification : this ) bonusspecification.setPercent( m_Percent );
    }


    // selections
    @Override
    public BonusSet R16_specifies_Bonus() throws XtumlException {
        BonusSet bonusset = new BonusSetImpl();
        for ( BonusSpecification bonusspecification : this ) bonusset.addAll( bonusspecification.R16_specifies_Bonus() );
        return bonusset;
    }


    @Override
    public BonusSpecification nullElement() {
        return BonusSpecificationImpl.EMPTY_BONUSSPECIFICATION;
    }

    @Override
    public BonusSpecificationSet emptySet() {
      return new BonusSpecificationSetImpl();
    }

    @Override
    public BonusSpecificationSet emptySet(Comparator<? super BonusSpecification> comp) {
      return new BonusSpecificationSetImpl(comp);
    }

    @Override
    public List<BonusSpecification> elements() {
        return Arrays.asList(toArray(new BonusSpecification[0]));
    }

}
