package hrsystem.auth.main;


import hrsystem.auth.main.GroupSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface PermissionsSet extends IInstanceSet<PermissionsSet,Permissions> {

    // attributes
    public void setPermission( String m_Permission ) throws XtumlException;


    // selections
    public GroupSet R3_given_Group() throws XtumlException;


}
