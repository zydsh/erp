package erp.pm.main;


import erp.pm.main.InitiativeSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface StrategySet extends IInstanceSet<StrategySet,Strategy> {

    // attributes
    public void setDescription( String m_Description ) throws XtumlException;
    public void setNumber( String m_Number ) throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;


    // selections
    public InitiativeSet R1_defines_Initiative() throws XtumlException;


}
