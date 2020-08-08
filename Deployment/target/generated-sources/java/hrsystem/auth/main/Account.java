package hrsystem.auth.main;


import hrsystem.Auth;
import hrsystem.auth.main.Permission;
import hrsystem.auth.main.PermissionSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Account extends IModelInstance<Account,Auth> {

    // attributes
    public void setUsername( String m_Username ) throws XtumlException;
    public String getUsername() throws XtumlException;
    public void setPassword( String m_Password ) throws XtumlException;
    public String getPassword() throws XtumlException;
    public int getNational_ID() throws XtumlException;
    public void setNational_ID( int m_National_ID ) throws XtumlException;


    // operations


    // selections
    default public void addR1_Permission( Permission inst ) {}
    default public void removeR1_Permission( Permission inst ) {}
    public PermissionSet R1_Permission() throws XtumlException;


}
