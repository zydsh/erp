package hrsystem.hr.messagecenter.impl;


import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.impl.EmployeeSetImpl;
import hrsystem.hr.messagecenter.ApproveLeave;
import hrsystem.hr.messagecenter.ApproveLeaveSet;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class ApproveLeaveSetImpl extends InstanceSet<ApproveLeaveSet,ApproveLeave> implements ApproveLeaveSet {

    public ApproveLeaveSetImpl() {
    }

    public ApproveLeaveSetImpl(Comparator<? super ApproveLeave> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setContent( String m_Content ) throws XtumlException {
        for ( ApproveLeave approveleave : this ) approveleave.setContent( m_Content );
    }
    @Override
    public void setStarting( int m_Starting ) throws XtumlException {
        for ( ApproveLeave approveleave : this ) approveleave.setStarting( m_Starting );
    }
    @Override
    public void setEnding( int m_Ending ) throws XtumlException {
        for ( ApproveLeave approveleave : this ) approveleave.setEnding( m_Ending );
    }
    @Override
    public void setLeaveRequesterID( int m_LeaveRequesterID ) throws XtumlException {
        for ( ApproveLeave approveleave : this ) approveleave.setLeaveRequesterID( m_LeaveRequesterID );
    }


    // selections
    @Override
    public EmployeeSet R102_notifies_Employee() throws XtumlException {
        EmployeeSet employeeset = new EmployeeSetImpl();
        for ( ApproveLeave approveleave : this ) employeeset.add( approveleave.R102_notifies_Employee() );
        return employeeset;
    }


    @Override
    public ApproveLeave nullElement() {
        return ApproveLeaveImpl.EMPTY_APPROVELEAVE;
    }

    @Override
    public ApproveLeaveSet emptySet() {
      return new ApproveLeaveSetImpl();
    }

    @Override
    public ApproveLeaveSet emptySet(Comparator<? super ApproveLeave> comp) {
      return new ApproveLeaveSetImpl(comp);
    }

    @Override
    public List<ApproveLeave> elements() {
        return Arrays.asList(toArray(new ApproveLeave[0]));
    }

}
