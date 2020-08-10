package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Employee_Leave;
import hrsystem.hr.main.Employee_LeaveSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Leave extends IModelInstance<Leave,Hr> {

    // attributes
    public int getLeave_ID() throws XtumlException;
    public void setLeave_ID( int m_Leave_ID ) throws XtumlException;
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public int getMaximumDays() throws XtumlException;
    public void setMaximumDays( int m_MaximumDays ) throws XtumlException;


    // operations


    // selections
    default public void addR2_Employee_Leave( Employee_Leave inst ) {}
    default public void removeR2_Employee_Leave( Employee_Leave inst ) {}
    public Employee_LeaveSet R2_Employee_Leave() throws XtumlException;


}
