package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus;
import hrsystem.hr.main.BonusSet;
import hrsystem.hr.main.Department;
import hrsystem.hr.main.DepartmentSet;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.JobRecord;
import hrsystem.hr.main.JobRecordSet;
import hrsystem.hr.main.Leave;
import hrsystem.hr.main.LeaveSet;
import hrsystem.hr.main.PayslipItem;
import hrsystem.hr.main.PayslipItemSet;
import hrsystem.hr.messagecenter.ApproveLeave;
import hrsystem.hr.messagecenter.ApproveLeaveSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Employee extends IModelInstance<Employee,Hr> {

    // attributes
    public void setEmployeeID( int m_EmployeeID ) throws XtumlException;
    public int getEmployeeID() throws XtumlException;
    public int getNationalID() throws XtumlException;
    public void setNationalID( int m_NationalID ) throws XtumlException;
    public void setFirstName( String m_FirstName ) throws XtumlException;
    public String getFirstName() throws XtumlException;
    public void setMiddleName( String m_MiddleName ) throws XtumlException;
    public String getMiddleName() throws XtumlException;
    public void setLastName( String m_LastName ) throws XtumlException;
    public String getLastName() throws XtumlException;
    public int getDateOfBirth() throws XtumlException;
    public void setDateOfBirth( int m_DateOfBirth ) throws XtumlException;
    public String getDegree() throws XtumlException;
    public void setDegree( String m_Degree ) throws XtumlException;
    public String getGender() throws XtumlException;
    public void setGender( String m_Gender ) throws XtumlException;
    public void setStart_Date( int m_Start_Date ) throws XtumlException;
    public int getStart_Date() throws XtumlException;
    public int getLeaveBalance() throws XtumlException;
    public void setLeaveBalance( int m_LeaveBalance ) throws XtumlException;
    public void setSickLeaveBalance( int m_SickLeaveBalance ) throws XtumlException;
    public int getSickLeaveBalance() throws XtumlException;


    // operations
    public void commenceEmployee( final int p_National_ID ) throws XtumlException;
    public double getSalary() throws XtumlException;


    // selections
    default public void addR102_is_notified_by_ApproveLeave( ApproveLeave inst ) {}
    default public void removeR102_is_notified_by_ApproveLeave( ApproveLeave inst ) {}
    public ApproveLeaveSet R102_is_notified_by_ApproveLeave() throws XtumlException;
    default public void addR19_was_given_a_Bonus( Bonus inst ) {}
    default public void removeR19_was_given_a_Bonus( Bonus inst ) {}
    public BonusSet R19_was_given_a_Bonus() throws XtumlException;
    default public void addR1_occupied_JobRecord( JobRecord inst ) {}
    default public void removeR1_occupied_JobRecord( JobRecord inst ) {}
    public JobRecordSet R1_occupied_JobRecord() throws XtumlException;
    default public void setR20_to_be_promoted_to_a_Job( Job inst ) {}
    public Job R20_to_be_promoted_to_a_Job() throws XtumlException;
    default public void setR21_working_within_Department( Department inst ) {}
    public Department R21_working_within_Department() throws XtumlException;
    default public void addR23_manages_Department( Department inst ) {}
    default public void removeR23_manages_Department( Department inst ) {}
    public DepartmentSet R23_manages_Department() throws XtumlException;
    default public void addR2_consumed_Leave( Leave inst ) {}
    default public void removeR2_consumed_Leave( Leave inst ) {}
    public LeaveSet R2_consumed_Leave() throws XtumlException;
    default public void addR3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem( PayslipItem inst ) {}
    default public void removeR3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem( PayslipItem inst ) {}
    public PayslipItemSet R3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem() throws XtumlException;
    default public void addR4_gets_a_Bonus( Bonus inst ) {}
    default public void removeR4_gets_a_Bonus( Bonus inst ) {}
    public BonusSet R4_gets_a_Bonus() throws XtumlException;
    default public void setR5_is_taking_a_Leave( Leave inst ) {}
    public Leave R5_is_taking_a_Leave() throws XtumlException;
    default public void setR6_currently_occupies_a_Job( Job inst ) {}
    public Job R6_currently_occupies_a_Job() throws XtumlException;
    default public void setR7_is_planning_to_take__Leave( Leave inst ) {}
    public Leave R7_is_planning_to_take__Leave() throws XtumlException;


}
