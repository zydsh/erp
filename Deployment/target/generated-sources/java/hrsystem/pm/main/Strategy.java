package hrsystem.pm.main;


import hrsystem.Pm;
import hrsystem.pm.main.Initiative;
import hrsystem.pm.main.InitiativeSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Strategy extends IModelInstance<Strategy,Pm> {

    // attributes
    public void setNumber( String m_Number ) throws XtumlException;
    public String getNumber() throws XtumlException;
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public String getDescription() throws XtumlException;
    public void setDescription( String m_Description ) throws XtumlException;


    // operations


    // selections
    default public void addR10_implemented_by_Initiative( Initiative inst ) {}
    default public void removeR10_implemented_by_Initiative( Initiative inst ) {}
    public InitiativeSet R10_implemented_by_Initiative() throws XtumlException;


}
