package hrsystem.hr.main;


import hrsystem.hr.main.BonusSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface BonusSpecificationSet extends IInstanceSet<BonusSpecificationSet,BonusSpecification> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public void setPercent( double m_Percent ) throws XtumlException;


    // selections
    public BonusSet R16_specifies_Bonus() throws XtumlException;


}
