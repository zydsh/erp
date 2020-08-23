package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Grade;
import hrsystem.hr.main.JobRecord;
import hrsystem.hr.main.JobRecordSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Job extends IModelInstance<Job,Hr> {

    // attributes
    public void setJob_ID( int m_Job_ID ) throws XtumlException;
    public int getJob_ID() throws XtumlException;
    public String getTitle() throws XtumlException;
    public void setTitle( String m_Title ) throws XtumlException;
    public void setSalary( double m_Salary ) throws XtumlException;
    public double getSalary() throws XtumlException;
    public int getStep() throws XtumlException;
    public void setStep( int m_Step ) throws XtumlException;
    public double getPensionDeduction() throws XtumlException;
    public void setPensionDeduction( double m_PensionDeduction ) throws XtumlException;
    public int getDescription() throws XtumlException;
    public void setDescription( int m_Description ) throws XtumlException;
    public void setPromotionDate( int m_PromotionDate ) throws XtumlException;
    public int getPromotionDate() throws XtumlException;
    public void setAppointmentDate( int m_AppointmentDate ) throws XtumlException;
    public int getAppointmentDate() throws XtumlException;


    // operations


    // selections
    default public void addR1_was_assigned_to_JobRecord( JobRecord inst ) {}
    default public void removeR1_was_assigned_to_JobRecord( JobRecord inst ) {}
    public JobRecordSet R1_was_assigned_to_JobRecord() throws XtumlException;
    default public void setR20_to_be_assigned_to_an_Employee( Employee inst ) {}
    public Employee R20_to_be_assigned_to_an_Employee() throws XtumlException;
    default public void setR6_is_assigned_to_an_Employee( Employee inst ) {}
    public Employee R6_is_assigned_to_an_Employee() throws XtumlException;
    default public void setR9_assigned_Grade( Grade inst ) {}
    public Grade R9_assigned_Grade() throws XtumlException;


}
