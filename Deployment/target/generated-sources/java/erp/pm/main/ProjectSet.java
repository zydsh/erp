package erp.pm.main;


import erp.pm.main.InitiativeSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface ProjectSet extends IInstanceSet<ProjectSet,Project> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;


    // selections
    public InitiativeSet R4_defined_by_Initiative() throws XtumlException;


}
