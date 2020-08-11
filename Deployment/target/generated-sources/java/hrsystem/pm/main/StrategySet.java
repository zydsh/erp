package hrsystem.pm.main;


import hrsystem.pm.main.InitiativeSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface StrategySet extends IInstanceSet<StrategySet,Strategy> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public void setNumber( String m_Number ) throws XtumlException;
    public void setDescription( String m_Description ) throws XtumlException;


    // selections
    public InitiativeSet R1_Initiative() throws XtumlException;


}
