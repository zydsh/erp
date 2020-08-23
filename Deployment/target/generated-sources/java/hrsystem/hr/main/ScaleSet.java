package hrsystem.hr.main;


import hrsystem.hr.main.GradeSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface ScaleSet extends IInstanceSet<ScaleSet,Scale> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public void setDescription( int m_Description ) throws XtumlException;


    // selections
    public GradeSet R12_is_made_of_Grade() throws XtumlException;


}
