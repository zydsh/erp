package hrsystem.hr.main;


import hrsystem.hr.main.Employee_LeaveSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface LeaveSet extends IInstanceSet<LeaveSet,Leave> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public void setMaximumDays( int m_MaximumDays ) throws XtumlException;
    public void setLeave_ID( int m_Leave_ID ) throws XtumlException;


    // selections
    public Employee_LeaveSet R2_Employee_Leave() throws XtumlException;


}
