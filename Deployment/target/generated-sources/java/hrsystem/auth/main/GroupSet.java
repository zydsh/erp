package hrsystem.auth.main;


import hrsystem.auth.main.AccountSet;
import hrsystem.auth.main.GroupSet;
import hrsystem.auth.main.PermissionsSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface GroupSet extends IInstanceSet<GroupSet,Group> {

    // attributes
    public void setDescription( String m_Description ) throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;


    // selections
    public AccountSet R1_has__Account() throws XtumlException;
    public GroupSet R2_has_Group() throws XtumlException;
    public GroupSet R2_part_of_Group() throws XtumlException;
    public PermissionsSet R3_has_Permissions() throws XtumlException;


}
