package erp.pm.main;


import erp.pm.main.MilestoneSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Supporting_DocumentsSet extends IInstanceSet<Supporting_DocumentsSet,Supporting_Documents> {

    // attributes
    public void setNotes( String m_Notes ) throws XtumlException;
    public void setState( String m_State ) throws XtumlException;
    public void setDocument( String m_Document ) throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;


    // selections
    public MilestoneSet R3_evidance_for_Milestone() throws XtumlException;


}
