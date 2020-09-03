package erp.hr.main;


import erp.Hr;
import erp.hr.main.Grade;
import erp.hr.main.GradeSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Scale extends IModelInstance<Scale,Hr> {

    // attributes
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setDescription( String m_Description ) throws XtumlException;
    public String getDescription() throws XtumlException;


    // operations


    // selections
    default public void addR12_is_made_of_Grade( Grade inst ) {}
    default public void removeR12_is_made_of_Grade( Grade inst ) {}
    public GradeSet R12_is_made_of_Grade() throws XtumlException;


}
