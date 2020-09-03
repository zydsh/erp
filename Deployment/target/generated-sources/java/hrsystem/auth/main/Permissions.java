package hrsystem.auth.main;


import hrsystem.Auth;
import hrsystem.auth.main.Group;
import hrsystem.auth.main.GroupSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Permissions extends IModelInstance<Permissions,Auth> {

    // attributes
    public void setPermission( String m_Permission ) throws XtumlException;
    public String getPermission() throws XtumlException;


    // operations


    // selections
    default public void addR3_given_Group( Group inst ) {}
    default public void removeR3_given_Group( Group inst ) {}
    public GroupSet R3_given_Group() throws XtumlException;


}
