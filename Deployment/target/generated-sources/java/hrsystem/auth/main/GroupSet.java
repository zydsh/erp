package hrsystem.auth.main;


import hrsystem.auth.main.PermissionSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface GroupSet extends IInstanceSet<GroupSet,Group> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;


    // selections
    public PermissionSet R1_Permission() throws XtumlException;


}
