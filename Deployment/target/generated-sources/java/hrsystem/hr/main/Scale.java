package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Grade;
import hrsystem.hr.main.GradeSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Scale extends IModelInstance<Scale,Hr> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public String getName() throws XtumlException;
    public void setDescription( int m_Description ) throws XtumlException;
    public int getDescription() throws XtumlException;


    // operations


    // selections
    default public void addR12_is_made_of_Grade( Grade inst ) {}
    default public void removeR12_is_made_of_Grade( Grade inst ) {}
    public GradeSet R12_is_made_of_Grade() throws XtumlException;


}
