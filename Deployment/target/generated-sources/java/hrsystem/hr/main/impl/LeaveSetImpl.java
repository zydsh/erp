package hrsystem.hr.main.impl;


import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.Leave;
import hrsystem.hr.main.LeaveSet;
import hrsystem.hr.main.LeaveSpecificationSet;
import hrsystem.hr.main.impl.EmployeeSetImpl;
import hrsystem.hr.main.impl.LeaveSpecificationSetImpl;

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
    public void setEnding( int m_Ending ) throws XtumlException {
        for ( Leave leave : this ) leave.setEnding( m_Ending );
    }
    @Override
    public void setStarting( int m_Starting ) throws XtumlException {
        for ( Leave leave : this ) leave.setStarting( m_Starting );
    }


    // selections
    @Override
    public LeaveSpecificationSet R15_is_specified_by_a_LeaveSpecification() throws XtumlException {
        LeaveSpecificationSet leavespecificationset = new LeaveSpecificationSetImpl();
        for ( Leave leave : this ) leavespecificationset.add( leave.R15_is_specified_by_a_LeaveSpecification() );
        return leavespecificationset;
    }
    @Override
    public EmployeeSet R2_is_consumed_by_a_Employee() throws XtumlException {
        EmployeeSet employeeset = new EmployeeSetImpl();
        for ( Leave leave : this ) employeeset.add( leave.R2_is_consumed_by_a_Employee() );
        return employeeset;
    }
    @Override
    public EmployeeSet R5_is_currently_taken_by_Employee() throws XtumlException {
        EmployeeSet employeeset = new EmployeeSetImpl();
        for ( Leave leave : this ) employeeset.add( leave.R5_is_currently_taken_by_Employee() );
        return employeeset;
    }
    @Override
    public EmployeeSet R7_to_be_taken_by_Employee() throws XtumlException {
        EmployeeSet employeeset = new EmployeeSetImpl();
        for ( Leave leave : this ) employeeset.add( leave.R7_to_be_taken_by_Employee() );
        return employeeset;
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
