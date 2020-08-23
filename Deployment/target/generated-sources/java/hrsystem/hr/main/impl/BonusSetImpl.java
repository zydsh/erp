package hrsystem.hr.main.impl;


import hrsystem.hr.main.Bonus;
import hrsystem.hr.main.BonusSet;
import hrsystem.hr.main.BonusSpecificationSet;
import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.impl.BonusSpecificationSetImpl;
import hrsystem.hr.main.impl.EmployeeSetImpl;

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
    public void setAmount( double m_Amount ) throws XtumlException {
        for ( Bonus bonus : this ) bonus.setAmount( m_Amount );
    }
    @Override
    public void setStarting( int m_Starting ) throws XtumlException {
        for ( Bonus bonus : this ) bonus.setStarting( m_Starting );
    }
    @Override
    public void setEnding( int m_Ending ) throws XtumlException {
        for ( Bonus bonus : this ) bonus.setEnding( m_Ending );
    }


    // selections
    @Override
    public BonusSpecificationSet R16_is_specified_by_BonusSpecification() throws XtumlException {
        BonusSpecificationSet bonusspecificationset = new BonusSpecificationSetImpl();
        for ( Bonus bonus : this ) bonusspecificationset.add( bonus.R16_is_specified_by_BonusSpecification() );
        return bonusspecificationset;
    }
    @Override
    public EmployeeSet R19_given_in_the_past_to_an_Employee() throws XtumlException {
        EmployeeSet employeeset = new EmployeeSetImpl();
        for ( Bonus bonus : this ) employeeset.add( bonus.R19_given_in_the_past_to_an_Employee() );
        return employeeset;
    }
    @Override
    public EmployeeSet R4_is_given_to_an_Employee() throws XtumlException {
        EmployeeSet employeeset = new EmployeeSetImpl();
        for ( Bonus bonus : this ) employeeset.add( bonus.R4_is_given_to_an_Employee() );
        return employeeset;
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
