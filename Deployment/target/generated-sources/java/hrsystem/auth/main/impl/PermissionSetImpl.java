package hrsystem.auth.main.impl;


import hrsystem.auth.main.AccountSet;
import hrsystem.auth.main.GroupSet;
import hrsystem.auth.main.Permission;
import hrsystem.auth.main.PermissionSet;
import hrsystem.auth.main.impl.AccountSetImpl;
import hrsystem.auth.main.impl.GroupSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class PermissionSetImpl extends InstanceSet<PermissionSet,Permission> implements PermissionSet {

    public PermissionSetImpl() {
    }

    public PermissionSetImpl(Comparator<? super Permission> comp) {
        super(comp);
    }

    // attributes


    // selections
    @Override
    public AccountSet R1_Account() throws XtumlException {
        AccountSet accountset = new AccountSetImpl();
        for ( Permission permission : this ) accountset.add( permission.R1_Account() );
        return accountset;
    }
    @Override
    public GroupSet R1_Group() throws XtumlException {
        GroupSet groupset = new GroupSetImpl();
        for ( Permission permission : this ) groupset.add( permission.R1_Group() );
        return groupset;
    }


    @Override
    public Permission nullElement() {
        return PermissionImpl.EMPTY_PERMISSION;
    }

    @Override
    public PermissionSet emptySet() {
      return new PermissionSetImpl();
    }

    @Override
    public PermissionSet emptySet(Comparator<? super Permission> comp) {
      return new PermissionSetImpl(comp);
    }

    @Override
    public List<Permission> elements() {
        return Arrays.asList(toArray(new Permission[0]));
    }

}
