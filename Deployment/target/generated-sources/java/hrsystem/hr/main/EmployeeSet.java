package hrsystem.hr.main;


import hrsystem.hr.main.Bonus_PaymentSet;
import hrsystem.hr.main.Employee_JobSet;
import hrsystem.hr.main.Employee_LeaveSet;
import hrsystem.hr.main.PaymentSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface EmployeeSet extends IInstanceSet<EmployeeSet,Employee> {

    // attributes
    public void setStart_Date( int m_Start_Date ) throws XtumlException;
    public void setFName( String m_FName ) throws XtumlException;
    public void setNational_ID( int m_National_ID ) throws XtumlException;
    public void setLName( String m_LName ) throws XtumlException;


    // selections
    public Employee_JobSet R1_Employee_Job() throws XtumlException;
    public Employee_LeaveSet R2_Employee_Leave() throws XtumlException;
    public PaymentSet R3_Payment() throws XtumlException;
    public Bonus_PaymentSet R4_Bonus_Payment() throws XtumlException;


}
