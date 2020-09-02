package hrsystem.hr.messagecenter;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface ApproveLeave extends IModelInstance<ApproveLeave,Hr> {

    // attributes
    public int getLeaveRequesterID() throws XtumlException;
    public void setLeaveRequesterID( int m_LeaveRequesterID ) throws XtumlException;
    public void setStarting( int m_Starting ) throws XtumlException;
    public int getStarting() throws XtumlException;
    public void setEnding( int m_Ending ) throws XtumlException;
    public int getEnding() throws XtumlException;
    public void setContent( String m_Content ) throws XtumlException;
    public String getContent() throws XtumlException;


    // operations
    public void createMessage( final int p_Starting,  final int p_Ending,  final int p_EmployeeID,  final int p_ManagerID ) throws XtumlException;


    // selections
    default public void setR102_notifies_Employee( Employee inst ) {}
    public Employee R102_notifies_Employee() throws XtumlException;


}
