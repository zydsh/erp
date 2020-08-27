package hrsystem.hr.main;


import hrsystem.hr.main.BonusSpecificationSet;
import hrsystem.hr.main.EmployeeSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface BonusSet extends IInstanceSet<BonusSet,Bonus> {

    // attributes
    public void setAmount( double m_Amount ) throws XtumlException;
    public void setStarting( int m_Starting ) throws XtumlException;
    public void setEnding( int m_Ending ) throws XtumlException;


    // selections
    public BonusSpecificationSet R16_is_specified_by_BonusSpecification() throws XtumlException;
    public EmployeeSet R19_given_in_the_past_to_an_Employee() throws XtumlException;
    public EmployeeSet R4_is_given_to_an_Employee() throws XtumlException;


}
