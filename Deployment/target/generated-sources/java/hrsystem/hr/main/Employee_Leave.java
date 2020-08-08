package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Leave;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Employee_Leave extends IModelInstance<Employee_Leave,Hr> {

    // attributes
    public void setStarting( int m_Starting ) throws XtumlException;
    public int getStarting() throws XtumlException;
    public void setEnding( int m_Ending ) throws XtumlException;
    public int getEnding() throws XtumlException;
    public void setApproved( boolean m_Approved ) throws XtumlException;
    public boolean getApproved() throws XtumlException;
    public int getNational_ID() throws XtumlException;
    public void setNational_ID( int ref_National_ID ) throws XtumlException;
    public int getLeave_ID() throws XtumlException;
    public void setLeave_ID( int ref_Leave_ID ) throws XtumlException;


    // operations


    // selections
    default public void setR2_Employee( Employee inst ) {}
    public Employee R2_Employee() throws XtumlException;
    default public void setR2_Leave( Leave inst ) {}
    public Leave R2_Leave() throws XtumlException;


}
