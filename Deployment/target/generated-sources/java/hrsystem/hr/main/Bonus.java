package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus_Payment;
import hrsystem.hr.main.Bonus_PaymentSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Bonus extends IModelInstance<Bonus,Hr> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public String getName() throws XtumlException;
    public void setPercent( double m_Percent ) throws XtumlException;
    public double getPercent() throws XtumlException;


    // operations


    // selections
    default public void addR4_Bonus_Payment( Bonus_Payment inst ) {}
    default public void removeR4_Bonus_Payment( Bonus_Payment inst ) {}
    public Bonus_PaymentSet R4_Bonus_Payment() throws XtumlException;


}
