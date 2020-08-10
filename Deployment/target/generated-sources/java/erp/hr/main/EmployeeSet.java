package erp.hr.main;


import erp.hr.main.Bonus_PaymentSet;
import erp.hr.main.Employee_JobSet;
import erp.hr.main.Employee_LeaveSet;
import erp.hr.main.PaymentSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface EmployeeSet extends IInstanceSet<EmployeeSet,Employee> {

    // attributes
    public void setFName( String m_FName ) throws XtumlException;
    public void setNational_ID( int m_National_ID ) throws XtumlException;
    public void setLName( String m_LName ) throws XtumlException;
    public void setStart_Date( int m_Start_Date ) throws XtumlException;


    // selections
    public Employee_JobSet R1_Employee_Job() throws XtumlException;
    public Employee_LeaveSet R2_Employee_Leave() throws XtumlException;
    public PaymentSet R3_Payment() throws XtumlException;
    public Bonus_PaymentSet R4_Bonus_Payment() throws XtumlException;


}
