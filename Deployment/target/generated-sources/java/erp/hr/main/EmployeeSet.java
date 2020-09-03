package erp.hr.main;


import erp.hr.main.BonusSet;
import erp.hr.main.DepartmentSet;
import erp.hr.main.JobRecordSet;
import erp.hr.main.JobSet;
import erp.hr.main.LeaveSet;
import erp.hr.main.PayslipItemSet;
import erp.hr.messagecenter.ApproveLeaveSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface EmployeeSet extends IInstanceSet<EmployeeSet,Employee> {

    // attributes
    public void setDegree( String m_Degree ) throws XtumlException;
    public void setOfficePhone( String m_OfficePhone ) throws XtumlException;
    public void setEmployeeID( int m_EmployeeID ) throws XtumlException;
    public void setEmail( String m_Email ) throws XtumlException;
    public void setNationalID( int m_NationalID ) throws XtumlException;
    public void setMiddleName( String m_MiddleName ) throws XtumlException;
    public void setSickLeaveBalance( int m_SickLeaveBalance ) throws XtumlException;
    public void setStart_Date( int m_Start_Date ) throws XtumlException;
    public void setGender( String m_Gender ) throws XtumlException;
    public void setDateOfBirth( int m_DateOfBirth ) throws XtumlException;
    public void setLastName( String m_LastName ) throws XtumlException;
    public void setLeaveBalance( int m_LeaveBalance ) throws XtumlException;
    public void setFirstName( String m_FirstName ) throws XtumlException;


    // selections
    public ApproveLeaveSet R102_is_notified_by_ApproveLeave() throws XtumlException;
    public LeaveSet R11_consumed_Leave() throws XtumlException;
    public BonusSet R19_was_given_Bonus() throws XtumlException;
    public JobRecordSet R1_occupied_JobRecord() throws XtumlException;
    public JobSet R20_to_be_promoted_to_Job() throws XtumlException;
    public DepartmentSet R21_working_within_Department() throws XtumlException;
    public DepartmentSet R23_manages_Department() throws XtumlException;
    public PayslipItemSet R3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem() throws XtumlException;
    public BonusSet R4_gets_a_Bonus() throws XtumlException;
    public LeaveSet R5_is_taking_a_Leave() throws XtumlException;
    public JobSet R6_currently_occupies_Job() throws XtumlException;
    public LeaveSet R7_is_planning_to_take__Leave() throws XtumlException;


}
