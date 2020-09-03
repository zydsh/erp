package hrsystem.pm.main;


import hrsystem.Pm;
import hrsystem.pm.main.Initiative;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Project extends IModelInstance<Project,Pm> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public String getName() throws XtumlException;


    // operations


    // selections
    default public void setR4_defined_by_Initiative( Initiative inst ) {}
    public Initiative R4_defined_by_Initiative() throws XtumlException;


}
