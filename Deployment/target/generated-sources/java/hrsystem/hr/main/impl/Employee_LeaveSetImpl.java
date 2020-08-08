package hrsystem.hr.main.impl;


import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.Employee_Leave;
import hrsystem.hr.main.Employee_LeaveSet;
import hrsystem.hr.main.LeaveSet;
import hrsystem.hr.main.impl.EmployeeSetImpl;
import hrsystem.hr.main.impl.LeaveSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Employee_LeaveSetImpl extends InstanceSet<Employee_LeaveSet,Employee_Leave> implements Employee_LeaveSet {

    public Employee_LeaveSetImpl() {
    }

    public Employee_LeaveSetImpl(Comparator<? super Employee_Leave> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setEnding( int m_Ending ) throws XtumlException {
        for ( Employee_Leave employee_leave : this ) employee_leave.setEnding( m_Ending );
    }
    @Override
    public void setStarting( int m_Starting ) throws XtumlException {
        for ( Employee_Leave employee_leave : this ) employee_leave.setStarting( m_Starting );
    }
    @Override
    public void setApproved( boolean m_Approved ) throws XtumlException {
        for ( Employee_Leave employee_leave : this ) employee_leave.setApproved( m_Approved );
    }
    @Override
    public void setNational_ID( int ref_National_ID ) throws XtumlException {
        for ( Employee_Leave employee_leave : this ) employee_leave.setNational_ID( ref_National_ID );
    }
    @Override
    public void setLeave_ID( int ref_Leave_ID ) throws XtumlException {
        for ( Employee_Leave employee_leave : this ) employee_leave.setLeave_ID( ref_Leave_ID );
    }


    // selections
    @Override
    public EmployeeSet R2_Employee() throws XtumlException {
        EmployeeSet employeeset = new EmployeeSetImpl();
        for ( Employee_Leave employee_leave : this ) employeeset.add( employee_leave.R2_Employee() );
        return employeeset;
    }
    @Override
    public LeaveSet R2_Leave() throws XtumlException {
        LeaveSet leaveset = new LeaveSetImpl();
        for ( Employee_Leave employee_leave : this ) leaveset.add( employee_leave.R2_Leave() );
        return leaveset;
    }


    @Override
    public Employee_Leave nullElement() {
        return Employee_LeaveImpl.EMPTY_EMPLOYEE_LEAVE;
    }

    @Override
    public Employee_LeaveSet emptySet() {
      return new Employee_LeaveSetImpl();
    }

    @Override
    public Employee_LeaveSet emptySet(Comparator<? super Employee_Leave> comp) {
      return new Employee_LeaveSetImpl(comp);
    }

    @Override
    public List<Employee_Leave> elements() {
        return Arrays.asList(toArray(new Employee_Leave[0]));
    }

}
