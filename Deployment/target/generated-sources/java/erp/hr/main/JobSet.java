package erp.hr.main;


import erp.hr.main.EmployeeSet;
import erp.hr.main.GradeSet;
import erp.hr.main.JobRecordSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface JobSet extends IInstanceSet<JobSet,Job> {

    // attributes
    public void setAppointmentDate( int m_AppointmentDate ) throws XtumlException;
    public void setPromotionDate( int m_PromotionDate ) throws XtumlException;
    public void setStep( int m_Step ) throws XtumlException;
    public void setSalary( double m_Salary ) throws XtumlException;
    public void setJob_ID( int m_Job_ID ) throws XtumlException;
    public void setTitle( String m_Title ) throws XtumlException;
    public void setDescription( String m_Description ) throws XtumlException;
    public void setPensionDeduction( double m_PensionDeduction ) throws XtumlException;


    // selections
    public JobRecordSet R1_was_assigned_to_JobRecord() throws XtumlException;
    public EmployeeSet R20_to_be_assigned_to_Employee() throws XtumlException;
    public EmployeeSet R6_is_assigned_to_Employee() throws XtumlException;
    public GradeSet R9_assigned_Grade() throws XtumlException;


}
