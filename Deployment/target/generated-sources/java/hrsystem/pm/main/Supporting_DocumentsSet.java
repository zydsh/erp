package hrsystem.pm.main;


import hrsystem.pm.main.MilestoneSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Supporting_DocumentsSet extends IInstanceSet<Supporting_DocumentsSet,Supporting_Documents> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;


    // selections
    public MilestoneSet R3_evidance_for_Milestone() throws XtumlException;


}
