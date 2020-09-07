package hrsystem.pm.second;


import hrsystem.Pm;
import hrsystem.pm.second.Polo;
import hrsystem.pm.second.PoloSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Marco extends IModelInstance<Marco,Pm> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public String getName() throws XtumlException;


    // operations


    // selections
    default public void addR101_followed_by_Polo( Polo inst ) {}
    default public void removeR101_followed_by_Polo( Polo inst ) {}
    public PoloSet R101_followed_by_Polo() throws XtumlException;


}
