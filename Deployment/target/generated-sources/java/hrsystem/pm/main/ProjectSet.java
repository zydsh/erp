package hrsystem.pm.main;


import hrsystem.pm.main.InitiativeSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface ProjectSet extends IInstanceSet<ProjectSet,Project> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;


    // selections
    public InitiativeSet R5_implements_Initiative() throws XtumlException;


}
