package hrsystem.hr.main.impl;


import hrsystem.hr.main.Employee_LeaveSet;
import hrsystem.hr.main.Leave;
import hrsystem.hr.main.LeaveSet;
import hrsystem.hr.main.impl.Employee_LeaveSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class LeaveSetImpl extends InstanceSet<LeaveSet,Leave> implements LeaveSet {

    public LeaveSetImpl() {
    }

    public LeaveSetImpl(Comparator<? super Leave> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Leave leave : this ) leave.setName( m_Name );
    }
    @Override
    public void setMaximumDays( int m_MaximumDays ) throws XtumlException {
        for ( Leave leave : this ) leave.setMaximumDays( m_MaximumDays );
    }
    @Override
    public void setLeave_ID( int m_Leave_ID ) throws XtumlException {
        for ( Leave leave : this ) leave.setLeave_ID( m_Leave_ID );
    }


    // selections
    @Override
    public Employee_LeaveSet R2_Employee_Leave() throws XtumlException {
        Employee_LeaveSet employee_leaveset = new Employee_LeaveSetImpl();
        for ( Leave leave : this ) employee_leaveset.addAll( leave.R2_Employee_Leave() );
        return employee_leaveset;
    }


    @Override
    public Leave nullElement() {
        return LeaveImpl.EMPTY_LEAVE;
    }

    @Override
    public LeaveSet emptySet() {
      return new LeaveSetImpl();
    }

    @Override
    public LeaveSet emptySet(Comparator<? super Leave> comp) {
      return new LeaveSetImpl(comp);
    }

    @Override
    public List<Leave> elements() {
        return Arrays.asList(toArray(new Leave[0]));
    }

}
