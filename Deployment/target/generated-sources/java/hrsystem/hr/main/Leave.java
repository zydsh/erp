package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.LeaveSpecification;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Leave extends IModelInstance<Leave,Hr> {

    // attributes
    public void setStarting( int m_Starting ) throws XtumlException;
    public int getStarting() throws XtumlException;
    public int getEnding() throws XtumlException;
    public void setEnding( int m_Ending ) throws XtumlException;


    // operations


    // selections
    default public void setR15_is_specified_by_a_LeaveSpecification( LeaveSpecification inst ) {}
    public LeaveSpecification R15_is_specified_by_a_LeaveSpecification() throws XtumlException;
    default public void setR2_is_consumed_by_a_Employee( Employee inst ) {}
    public Employee R2_is_consumed_by_a_Employee() throws XtumlException;
    default public void setR5_is_currently_taken_by_Employee( Employee inst ) {}
    public Employee R5_is_currently_taken_by_Employee() throws XtumlException;
    default public void setR7_to_be_taken_by_Employee( Employee inst ) {}
    public Employee R7_to_be_taken_by_Employee() throws XtumlException;


}
