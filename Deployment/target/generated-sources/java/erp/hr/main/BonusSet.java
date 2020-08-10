package erp.hr.main;


import erp.hr.main.Bonus_PaymentSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface BonusSet extends IInstanceSet<BonusSet,Bonus> {

    // attributes
    public void setPercent( double m_Percent ) throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;


    // selections
    public Bonus_PaymentSet R4_Bonus_Payment() throws XtumlException;


}
