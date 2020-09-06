package hrsystem.pm.second;


import hrsystem.pm.second.PoloSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface MarcoSet extends IInstanceSet<MarcoSet,Marco> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;


    // selections
    public PoloSet R101_followed_by_Polo() throws XtumlException;


}
