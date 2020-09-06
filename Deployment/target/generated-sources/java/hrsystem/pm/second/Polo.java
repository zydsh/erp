package hrsystem.pm.second;


import hrsystem.Pm;
import hrsystem.pm.second.Marco;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Polo extends IModelInstance<Polo,Pm> {

    // attributes
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;


    // operations


    // selections
    default public void setR101_follows_Marco( Marco inst ) {}
    public Marco R101_follows_Marco() throws XtumlException;


}
