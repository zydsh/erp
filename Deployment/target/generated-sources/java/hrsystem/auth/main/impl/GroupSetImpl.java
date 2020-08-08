package hrsystem.auth.main.impl;


import hrsystem.auth.main.Group;
import hrsystem.auth.main.GroupSet;
import hrsystem.auth.main.PermissionSet;
import hrsystem.auth.main.impl.PermissionSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class GroupSetImpl extends InstanceSet<GroupSet,Group> implements GroupSet {

    public GroupSetImpl() {
    }

    public GroupSetImpl(Comparator<? super Group> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Group group : this ) group.setName( m_Name );
    }


    // selections
    @Override
    public PermissionSet R1_Permission() throws XtumlException {
        PermissionSet permissionset = new PermissionSetImpl();
        for ( Group group : this ) permissionset.addAll( group.R1_Permission() );
        return permissionset;
    }


    @Override
    public Group nullElement() {
        return GroupImpl.EMPTY_GROUP;
    }

    @Override
    public GroupSet emptySet() {
      return new GroupSetImpl();
    }

    @Override
    public GroupSet emptySet(Comparator<? super Group> comp) {
      return new GroupSetImpl(comp);
    }

    @Override
    public List<Group> elements() {
        return Arrays.asList(toArray(new Group[0]));
    }

}
