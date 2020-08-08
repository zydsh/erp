package hrsystem.hr.main;


import hrsystem.hr.main.BonusSet;
import hrsystem.hr.main.EmployeeSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Bonus_PaymentSet extends IInstanceSet<Bonus_PaymentSet,Bonus_Payment> {

    // attributes
    public void setNational_ID( int ref_National_ID ) throws XtumlException;
    public void setEnding( int m_Ending ) throws XtumlException;
    public void setAmount( double m_Amount ) throws XtumlException;
    public void setName( int ref_Name ) throws XtumlException;
    public void setStarting( int m_Starting ) throws XtumlException;


    // selections
    public BonusSet R4_Bonus() throws XtumlException;
    public EmployeeSet R4_Employee() throws XtumlException;


}
