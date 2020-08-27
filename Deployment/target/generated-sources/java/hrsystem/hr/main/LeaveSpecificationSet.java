package hrsystem.hr.main;


import hrsystem.hr.main.LeaveSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface LeaveSpecificationSet extends IInstanceSet<LeaveSpecificationSet,LeaveSpecification> {

    // attributes
    public void setMinimumDays( int m_MinimumDays ) throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setMaximumDays( int m_MaximumDays ) throws XtumlException;


    // selections
    public LeaveSet R15_specifies_Leave() throws XtumlException;


}
