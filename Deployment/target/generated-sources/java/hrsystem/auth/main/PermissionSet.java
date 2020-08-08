package hrsystem.auth.main;


import hrsystem.auth.main.AccountSet;
import hrsystem.auth.main.GroupSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface PermissionSet extends IInstanceSet<PermissionSet,Permission> {

    // attributes


    // selections
    public AccountSet R1_Account() throws XtumlException;
    public GroupSet R1_Group() throws XtumlException;


}
