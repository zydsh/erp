package hrsystem.auth.main.impl;


import hrsystem.auth.main.GroupSet;
import hrsystem.auth.main.Permissions;
import hrsystem.auth.main.PermissionsSet;
import hrsystem.auth.main.impl.GroupSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class PermissionsSetImpl extends InstanceSet<PermissionsSet,Permissions> implements PermissionsSet {

    public PermissionsSetImpl() {
    }

    public PermissionsSetImpl(Comparator<? super Permissions> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setPermission( String m_Permission ) throws XtumlException {
        for ( Permissions permissions : this ) permissions.setPermission( m_Permission );
    }


    // selections
    @Override
    public GroupSet R3_given_Group() throws XtumlException {
        GroupSet groupset = new GroupSetImpl();
        for ( Permissions permissions : this ) groupset.addAll( permissions.R3_given_Group() );
        return groupset;
    }


    @Override
    public Permissions nullElement() {
        return PermissionsImpl.EMPTY_PERMISSIONS;
    }

    @Override
    public PermissionsSet emptySet() {
      return new PermissionsSetImpl();
    }

    @Override
    public PermissionsSet emptySet(Comparator<? super Permissions> comp) {
      return new PermissionsSetImpl(comp);
    }

    @Override
    public List<Permissions> elements() {
        return Arrays.asList(toArray(new Permissions[0]));
    }

}
