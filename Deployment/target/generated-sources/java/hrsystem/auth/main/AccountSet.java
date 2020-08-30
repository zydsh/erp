package hrsystem.auth.main;


import hrsystem.auth.main.GroupSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface AccountSet extends IInstanceSet<AccountSet,Account> {

    // attributes
    public void setUsername( String m_Username ) throws XtumlException;
    public void setEmployeeID( int m_EmployeeID ) throws XtumlException;
    public void setPassword( String m_Password ) throws XtumlException;


    // selections
    public GroupSet R1_a_member_of_Group() throws XtumlException;


}
