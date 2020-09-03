package erp.pm.main;


import erp.Pm;
import erp.pm.main.Initiative;
import erp.pm.main.InitiativeSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Strategy extends IModelInstance<Strategy,Pm> {

    // attributes
    public String getNumber() throws XtumlException;
    public void setNumber( String m_Number ) throws XtumlException;
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public String getDescription() throws XtumlException;
    public void setDescription( String m_Description ) throws XtumlException;


    // operations


    // selections
    default public void addR1_defines_Initiative( Initiative inst ) {}
    default public void removeR1_defines_Initiative( Initiative inst ) {}
    public InitiativeSet R1_defines_Initiative() throws XtumlException;


}
