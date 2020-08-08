package hrsystem.hr.main.impl;


import hrsystem.hr.main.Bonus_PaymentSet;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.Employee_JobSet;
import hrsystem.hr.main.Employee_LeaveSet;
import hrsystem.hr.main.PaymentSet;
import hrsystem.hr.main.impl.Bonus_PaymentSetImpl;
import hrsystem.hr.main.impl.Employee_JobSetImpl;
import hrsystem.hr.main.impl.Employee_LeaveSetImpl;
import hrsystem.hr.main.impl.PaymentSetImpl;

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
    public void setStart_Date( int m_Start_Date ) throws XtumlException {
        for ( Employee employee : this ) employee.setStart_Date( m_Start_Date );
    }
    @Override
    public void setFName( String m_FName ) throws XtumlException {
        for ( Employee employee : this ) employee.setFName( m_FName );
    }
    @Override
    public void setNational_ID( int m_National_ID ) throws XtumlException {
        for ( Employee employee : this ) employee.setNational_ID( m_National_ID );
    }
    @Override
    public void setLName( String m_LName ) throws XtumlException {
        for ( Employee employee : this ) employee.setLName( m_LName );
    }


    // selections
    @Override
    public Employee_JobSet R1_Employee_Job() throws XtumlException {
        Employee_JobSet employee_jobset = new Employee_JobSetImpl();
        for ( Employee employee : this ) employee_jobset.addAll( employee.R1_Employee_Job() );
        return employee_jobset;
    }
    @Override
    public Employee_LeaveSet R2_Employee_Leave() throws XtumlException {
        Employee_LeaveSet employee_leaveset = new Employee_LeaveSetImpl();
        for ( Employee employee : this ) employee_leaveset.addAll( employee.R2_Employee_Leave() );
        return employee_leaveset;
    }
    @Override
    public PaymentSet R3_Payment() throws XtumlException {
        PaymentSet paymentset = new PaymentSetImpl();
        for ( Employee employee : this ) paymentset.addAll( employee.R3_Payment() );
        return paymentset;
    }
    @Override
    public Bonus_PaymentSet R4_Bonus_Payment() throws XtumlException {
        Bonus_PaymentSet bonus_paymentset = new Bonus_PaymentSetImpl();
        for ( Employee employee : this ) bonus_paymentset.addAll( employee.R4_Bonus_Payment() );
        return bonus_paymentset;
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
