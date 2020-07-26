package hrsystem.hr.main;


import hrsystem.hr.main.Bonus_PaymentSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface BonusSet extends IInstanceSet<BonusSet,Bonus> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public void setPercent( double m_Percent ) throws XtumlException;


    // selections
    public Bonus_PaymentSet R4_Bonus_Payment() throws XtumlException;


}
