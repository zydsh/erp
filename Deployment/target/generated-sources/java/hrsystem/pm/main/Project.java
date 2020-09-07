package hrsystem.pm.main;


import hrsystem.Pm;
import hrsystem.pm.main.Initiative;
import hrsystem.pm.main.Milestone;
import hrsystem.pm.main.MilestoneSet;

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
    default public void addR8_reaches_Milestone( Milestone inst ) {}
    default public void removeR8_reaches_Milestone( Milestone inst ) {}
    public MilestoneSet R8_reaches_Milestone() throws XtumlException;


}
