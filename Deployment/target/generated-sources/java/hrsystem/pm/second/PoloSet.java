package hrsystem.pm.second;


import hrsystem.pm.second.MarcoSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface PoloSet extends IInstanceSet<PoloSet,Polo> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;


    // selections
    public MarcoSet R101_follows_Marco() throws XtumlException;


}
