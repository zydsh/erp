package erp.hr.main;


import erp.Hr;
import erp.hr.main.Bonus;
import erp.hr.main.BonusSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface BonusSpecification extends IModelInstance<BonusSpecification,Hr> {

    // attributes
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setPercent( double m_Percent ) throws XtumlException;
    public double getPercent() throws XtumlException;


    // operations


    // selections
    default public void addR16_specifies_Bonus( Bonus inst ) {}
    default public void removeR16_specifies_Bonus( Bonus inst ) {}
    public BonusSet R16_specifies_Bonus() throws XtumlException;


}
