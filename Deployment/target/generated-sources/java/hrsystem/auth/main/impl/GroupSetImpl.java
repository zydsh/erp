package hrsystem.auth.main.impl;


import hrsystem.auth.main.AccountSet;
import hrsystem.auth.main.Group;
import hrsystem.auth.main.GroupSet;
import hrsystem.auth.main.PermissionsSet;
import hrsystem.auth.main.impl.AccountSetImpl;
import hrsystem.auth.main.impl.GroupSetImpl;
import hrsystem.auth.main.impl.PermissionsSetImpl;

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
    @Override
    public void setDescription( String m_Description ) throws XtumlException {
        for ( Group group : this ) group.setDescription( m_Description );
    }


    // selections
    @Override
    public AccountSet R1_has__Account() throws XtumlException {
        AccountSet accountset = new AccountSetImpl();
        for ( Group group : this ) accountset.addAll( group.R1_has__Account() );
        return accountset;
    }
    @Override
    public GroupSet R2_has_Group() throws XtumlException {
        GroupSet groupset = new GroupSetImpl();
        for ( Group group : this ) groupset.addAll( group.R2_has_Group() );
        return groupset;
    }
    @Override
    public GroupSet R2_part_of_Group() throws XtumlException {
        GroupSet groupset = new GroupSetImpl();
        for ( Group group : this ) groupset.add( group.R2_part_of_Group() );
        return groupset;
    }
    @Override
    public PermissionsSet R3_has_Permissions() throws XtumlException {
        PermissionsSet permissionsset = new PermissionsSetImpl();
        for ( Group group : this ) permissionsset.addAll( group.R3_has_Permissions() );
        return permissionsset;
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
