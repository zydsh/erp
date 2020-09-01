package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus;
import hrsystem.hr.main.BonusSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface BonusSpecification extends IModelInstance<BonusSpecification,Hr> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public String getName() throws XtumlException;
    public void setPercent( double m_Percent ) throws XtumlException;
    public double getPercent() throws XtumlException;


    // operations


    // selections
    default public void addR16_specifies_Bonus( Bonus inst ) {}
    default public void removeR16_specifies_Bonus( Bonus inst ) {}
    public BonusSet R16_specifies_Bonus() throws XtumlException;


}
