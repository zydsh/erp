package hrsystem.pm.main;


import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface InitiativeSet extends IInstanceSet<InitiativeSet,Initiative> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;


    // selections


}
