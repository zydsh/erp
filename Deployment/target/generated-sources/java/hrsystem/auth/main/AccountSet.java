package hrsystem.auth.main;


import hrsystem.auth.main.PermissionSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface AccountSet extends IInstanceSet<AccountSet,Account> {

    // attributes
    public void setNational_ID( int m_National_ID ) throws XtumlException;
    public void setPassword( String m_Password ) throws XtumlException;
    public void setUsername( String m_Username ) throws XtumlException;


    // selections
    public PermissionSet R1_Permission() throws XtumlException;


}
