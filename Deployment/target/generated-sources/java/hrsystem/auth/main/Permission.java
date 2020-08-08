package hrsystem.auth.main;


import hrsystem.Auth;
import hrsystem.auth.main.Account;
import hrsystem.auth.main.Group;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Permission extends IModelInstance<Permission,Auth> {

    // attributes


    // operations


    // selections
    default public void setR1_Account( Account inst ) {}
    public Account R1_Account() throws XtumlException;
    default public void setR1_Group( Group inst ) {}
    public Group R1_Group() throws XtumlException;


}
