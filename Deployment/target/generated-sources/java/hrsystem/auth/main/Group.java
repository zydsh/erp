package hrsystem.auth.main;


import hrsystem.Auth;
import hrsystem.auth.main.Permission;
import hrsystem.auth.main.PermissionSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Group extends IModelInstance<Group,Auth> {

    // attributes
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;


    // operations


    // selections
    default public void addR1_Permission( Permission inst ) {}
    default public void removeR1_Permission( Permission inst ) {}
    public PermissionSet R1_Permission() throws XtumlException;


}
