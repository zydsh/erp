package hrsystem.pm.main;


import hrsystem.Pm;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Initiative extends IModelInstance<Initiative,Pm> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public String getName() throws XtumlException;


    // operations


    // selections


}
