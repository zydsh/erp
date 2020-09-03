package erp.auth.main;


import erp.Auth;
import erp.auth.main.Group;
import erp.auth.main.GroupSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Account extends IModelInstance<Account,Auth> {

    // attributes
    public void setUsername( String m_Username ) throws XtumlException;
    public String getUsername() throws XtumlException;
    public void setPassword( String m_Password ) throws XtumlException;
    public String getPassword() throws XtumlException;
    public int getEmployeeID() throws XtumlException;
    public void setEmployeeID( int m_EmployeeID ) throws XtumlException;


    // operations


    // selections
    default public void addR1_a_member_of_Group( Group inst ) {}
    default public void removeR1_a_member_of_Group( Group inst ) {}
    public GroupSet R1_a_member_of_Group() throws XtumlException;


}
