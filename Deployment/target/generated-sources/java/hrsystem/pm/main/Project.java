package hrsystem.pm.main;


import hrsystem.Pm;
import hrsystem.pm.main.Initiative;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Project extends IModelInstance<Project,Pm> {

    // attributes
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;


    // operations


    // selections
    default public void setR5_implements_Initiative( Initiative inst ) {}
    public Initiative R5_implements_Initiative() throws XtumlException;


}
