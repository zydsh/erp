package erp.auth.main;


import erp.Auth;
import erp.auth.main.Account;
import erp.auth.main.AccountSet;
import erp.auth.main.Group;
import erp.auth.main.GroupSet;
import erp.auth.main.Permissions;
import erp.auth.main.PermissionsSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Group extends IModelInstance<Group,Auth> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public String getName() throws XtumlException;
    public String getDescription() throws XtumlException;
    public void setDescription( String m_Description ) throws XtumlException;


    // operations


    // selections
    default public void addR1_has__Account( Account inst ) {}
    default public void removeR1_has__Account( Account inst ) {}
    public AccountSet R1_has__Account() throws XtumlException;
    default public void addR2_has_Group( Group inst ) {}
    default public void removeR2_has_Group( Group inst ) {}
    public GroupSet R2_has_Group() throws XtumlException;
    default public void setR2_part_of_Group( Group inst ) {}
    public Group R2_part_of_Group() throws XtumlException;
    default public void addR3_has_Permissions( Permissions inst ) {}
    default public void removeR3_has_Permissions( Permissions inst ) {}
    public PermissionsSet R3_has_Permissions() throws XtumlException;


}
