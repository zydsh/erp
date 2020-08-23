package hrsystem.hr.main.impl;


import hrsystem.hr.main.BonusSet;
import hrsystem.hr.main.DepartmentSet;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.JobRecordSet;
import hrsystem.hr.main.JobSet;
import hrsystem.hr.main.LeaveSet;
import hrsystem.hr.main.PayslipItemSet;
import hrsystem.hr.main.impl.BonusSetImpl;
import hrsystem.hr.main.impl.DepartmentSetImpl;
import hrsystem.hr.main.impl.JobRecordSetImpl;
import hrsystem.hr.main.impl.JobSetImpl;
import hrsystem.hr.main.impl.LeaveSetImpl;
import hrsystem.hr.main.impl.PayslipItemSetImpl;
import hrsystem.hr.messagecenter.ApproveLeaveSet;
import hrsystem.hr.messagecenter.impl.ApproveLeaveSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class EmployeeSetImpl extends InstanceSet<EmployeeSet,Employee> implements EmployeeSet {

    public EmployeeSetImpl() {
    }

    public EmployeeSetImpl(Comparator<? super Employee> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setEmployeeID( int m_EmployeeID ) throws XtumlException {
        for ( Employee employee : this ) employee.setEmployeeID( m_EmployeeID );
    }
    @Override
    public void setMiddleName( String m_MiddleName ) throws XtumlException {
        for ( Employee employee : this ) employee.setMiddleName( m_MiddleName );
    }
    @Override
    public void setLastName( String m_LastName ) throws XtumlException {
        for ( Employee employee : this ) employee.setLastName( m_LastName );
    }
    @Override
    public void setStart_Date( int m_Start_Date ) throws XtumlException {
        for ( Employee employee : this ) employee.setStart_Date( m_Start_Date );
    }
    @Override
    public void setSickLeaveBalance( int m_SickLeaveBalance ) throws XtumlException {
        for ( Employee employee : this ) employee.setSickLeaveBalance( m_SickLeaveBalance );
    }
    @Override
    public void setDateOfBirth( int m_DateOfBirth ) throws XtumlException {
        for ( Employee employee : this ) employee.setDateOfBirth( m_DateOfBirth );
    }
    @Override
    public void setFirstName( String m_FirstName ) throws XtumlException {
        for ( Employee employee : this ) employee.setFirstName( m_FirstName );
    }
    @Override
    public void setDegree( String m_Degree ) throws XtumlException {
        for ( Employee employee : this ) employee.setDegree( m_Degree );
    }
    @Override
    public void setGender( String m_Gender ) throws XtumlException {
        for ( Employee employee : this ) employee.setGender( m_Gender );
    }
    @Override
    public void setNationalID( int m_NationalID ) throws XtumlException {
        for ( Employee employee : this ) employee.setNationalID( m_NationalID );
    }
    @Override
    public void setLeaveBalance( int m_LeaveBalance ) throws XtumlException {
        for ( Employee employee : this ) employee.setLeaveBalance( m_LeaveBalance );
    }


    // selections
    @Override
    public ApproveLeaveSet R102_is_notified_by_ApproveLeave() throws XtumlException {
        ApproveLeaveSet approveleaveset = new ApproveLeaveSetImpl();
        for ( Employee employee : this ) approveleaveset.addAll( employee.R102_is_notified_by_ApproveLeave() );
        return approveleaveset;
    }
    @Override
    public BonusSet R19_was_given_a_Bonus() throws XtumlException {
        BonusSet bonusset = new BonusSetImpl();
        for ( Employee employee : this ) bonusset.addAll( employee.R19_was_given_a_Bonus() );
        return bonusset;
    }
    @Override
    public JobRecordSet R1_occupied_JobRecord() throws XtumlException {
        JobRecordSet jobrecordset = new JobRecordSetImpl();
        for ( Employee employee : this ) jobrecordset.addAll( employee.R1_occupied_JobRecord() );
        return jobrecordset;
    }
    @Override
    public JobSet R20_to_be_promoted_to_a_Job() throws XtumlException {
        JobSet jobset = new JobSetImpl();
        for ( Employee employee : this ) jobset.add( employee.R20_to_be_promoted_to_a_Job() );
        return jobset;
    }
    @Override
    public DepartmentSet R21_working_within_Department() throws XtumlException {
        DepartmentSet departmentset = new DepartmentSetImpl();
        for ( Employee employee : this ) departmentset.add( employee.R21_working_within_Department() );
        return departmentset;
    }
    @Override
    public DepartmentSet R23_manages_Department() throws XtumlException {
        DepartmentSet departmentset = new DepartmentSetImpl();
        for ( Employee employee : this ) departmentset.addAll( employee.R23_manages_Department() );
        return departmentset;
    }
    @Override
    public LeaveSet R2_consumed_Leave() throws XtumlException {
        LeaveSet leaveset = new LeaveSetImpl();
        for ( Employee employee : this ) leaveset.addAll( employee.R2_consumed_Leave() );
        return leaveset;
    }
    @Override
    public PayslipItemSet R3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem() throws XtumlException {
        PayslipItemSet payslipitemset = new PayslipItemSetImpl();
        for ( Employee employee : this ) payslipitemset.addAll( employee.R3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem() );
        return payslipitemset;
    }
    @Override
    public BonusSet R4_gets_a_Bonus() throws XtumlException {
        BonusSet bonusset = new BonusSetImpl();
        for ( Employee employee : this ) bonusset.addAll( employee.R4_gets_a_Bonus() );
        return bonusset;
    }
    @Override
    public LeaveSet R5_is_taking_a_Leave() throws XtumlException {
        LeaveSet leaveset = new LeaveSetImpl();
        for ( Employee employee : this ) leaveset.add( employee.R5_is_taking_a_Leave() );
        return leaveset;
    }
    @Override
    public JobSet R6_currently_occupies_a_Job() throws XtumlException {
        JobSet jobset = new JobSetImpl();
        for ( Employee employee : this ) jobset.add( employee.R6_currently_occupies_a_Job() );
        return jobset;
    }
    @Override
    public LeaveSet R7_is_planning_to_take__Leave() throws XtumlException {
        LeaveSet leaveset = new LeaveSetImpl();
        for ( Employee employee : this ) leaveset.add( employee.R7_is_planning_to_take__Leave() );
        return leaveset;
    }


    @Override
    public Employee nullElement() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }

    @Override
    public EmployeeSet emptySet() {
      return new EmployeeSetImpl();
    }

    @Override
    public EmployeeSet emptySet(Comparator<? super Employee> comp) {
      return new EmployeeSetImpl(comp);
    }

    @Override
    public List<Employee> elements() {
        return Arrays.asList(toArray(new Employee[0]));
    }

}
