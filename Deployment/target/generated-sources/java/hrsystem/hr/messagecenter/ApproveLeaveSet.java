package hrsystem.hr.messagecenter;


import hrsystem.hr.main.EmployeeSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface ApproveLeaveSet extends IInstanceSet<ApproveLeaveSet,ApproveLeave> {

    // attributes
    public void setContent( String m_Content ) throws XtumlException;
    public void setStarting( int m_Starting ) throws XtumlException;
    public void setEnding( int m_Ending ) throws XtumlException;
    public void setLeaveRequesterID( int m_LeaveRequesterID ) throws XtumlException;


    // selections
    public EmployeeSet R102_notifies_Employee() throws XtumlException;


}
