package hrsystem.hr.main;


import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.LeaveSpecificationSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface LeaveSet extends IInstanceSet<LeaveSet,Leave> {

    // attributes
    public void setStarting( int m_Starting ) throws XtumlException;
    public void setEnding( int m_Ending ) throws XtumlException;


    // selections
    public EmployeeSet R11_consumed_by_Employee() throws XtumlException;
    public LeaveSpecificationSet R15_is_specified_by_a_LeaveSpecification() throws XtumlException;
    public EmployeeSet R5_is_currently_taken_by_Employee() throws XtumlException;
    public EmployeeSet R7_to_be_taken_by_Employee() throws XtumlException;


}
