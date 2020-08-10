package hrsystem.hr.main;


import hrsystem.hr.main.JobSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface GradeSet extends IInstanceSet<GradeSet,Grade> {

    // attributes
    public void setGValue( int m_GValue ) throws XtumlException;


    // selections
    public JobSet R5_Job() throws XtumlException;


}
