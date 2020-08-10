package hrsystem.hr.main;


import hrsystem.hr.main.JobSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface StepSet extends IInstanceSet<StepSet,Step> {

    // attributes
    public void setSValue( int m_SValue ) throws XtumlException;


    // selections
    public JobSet R5_Job() throws XtumlException;


}
