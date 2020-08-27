package hrsystem.auth.main;


import hrsystem.Auth;
import hrsystem.auth.main.Group;
import hrsystem.auth.main.GroupSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Account extends IModelInstance<Account,Auth> {

    // attributes
    public void setUsername( String m_Username ) throws XtumlException;
    public String getUsername() throws XtumlException;
    public String getPassword() throws XtumlException;
    public void setPassword( String m_Password ) throws XtumlException;
    public int getEmployeeID() throws XtumlException;
    public void setEmployeeID( int m_EmployeeID ) throws XtumlException;


    // operations


    // selections
    default public void addR1_a_member_of_Group( Group inst ) {}
    default public void removeR1_a_member_of_Group( Group inst ) {}
    public GroupSet R1_a_member_of_Group() throws XtumlException;


}
