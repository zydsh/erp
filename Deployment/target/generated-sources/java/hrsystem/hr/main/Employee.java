package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus_Payment;
import hrsystem.hr.main.Bonus_PaymentSet;
import hrsystem.hr.main.Employee_Job;
import hrsystem.hr.main.Employee_JobSet;
import hrsystem.hr.main.Employee_Leave;
import hrsystem.hr.main.Employee_LeaveSet;
import hrsystem.hr.main.Payment;
import hrsystem.hr.main.PaymentSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Employee extends IModelInstance<Employee,Hr> {

    // attributes
    public int getNational_ID() throws XtumlException;
    public void setNational_ID( int m_National_ID ) throws XtumlException;
    public String getFName() throws XtumlException;
    public void setFName( String m_FName ) throws XtumlException;
    public String getLName() throws XtumlException;
    public void setLName( String m_LName ) throws XtumlException;
    public int getStart_Date() throws XtumlException;
    public void setStart_Date( int m_Start_Date ) throws XtumlException;


    // operations
    public double getSalary() throws XtumlException;


    // selections
    default public void addR1_Employee_Job( Employee_Job inst ) {}
    default public void removeR1_Employee_Job( Employee_Job inst ) {}
    public Employee_JobSet R1_Employee_Job() throws XtumlException;
    default public void addR2_Employee_Leave( Employee_Leave inst ) {}
    default public void removeR2_Employee_Leave( Employee_Leave inst ) {}
    public Employee_LeaveSet R2_Employee_Leave() throws XtumlException;
    default public void addR3_Payment( Payment inst ) {}
    default public void removeR3_Payment( Payment inst ) {}
    public PaymentSet R3_Payment() throws XtumlException;
    default public void addR4_Bonus_Payment( Bonus_Payment inst ) {}
    default public void removeR4_Bonus_Payment( Bonus_Payment inst ) {}
    public Bonus_PaymentSet R4_Bonus_Payment() throws XtumlException;


}
