package hrsystem.pm.main;


import hrsystem.Pm;
import hrsystem.pm.main.Milestone;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Supporting_Documents extends IModelInstance<Supporting_Documents,Pm> {

    // attributes
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;


    // operations


    // selections
    default public void setR3_evidance_for_Milestone( Milestone inst ) {}
    public Milestone R3_evidance_for_Milestone() throws XtumlException;


}
