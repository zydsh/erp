package erp.hr.main;


import erp.Hr;
import erp.hr.main.Job;
import erp.hr.main.JobSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Grade extends IModelInstance<Grade,Hr> {

    // attributes
    public int getGValue() throws XtumlException;
    public void setGValue( int m_GValue ) throws XtumlException;


    // operations


    // selections
    default public void addR5_Job( Job inst ) {}
    default public void removeR5_Job( Job inst ) {}
    public JobSet R5_Job() throws XtumlException;


}
