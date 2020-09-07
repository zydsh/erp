package hrsystem.pm.main;


import hrsystem.pm.main.InitiativeSet;
import hrsystem.pm.main.MilestoneSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface ProjectSet extends IInstanceSet<ProjectSet,Project> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;


    // selections
    public InitiativeSet R5_implements_Initiative() throws XtumlException;
    public MilestoneSet R8_reaches_Milestone() throws XtumlException;


}
