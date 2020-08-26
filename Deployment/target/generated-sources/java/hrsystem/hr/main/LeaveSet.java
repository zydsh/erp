package hrsystem.hr.main;


import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.LeaveSpecificationSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface LeaveSet extends IInstanceSet<LeaveSet,Leave> {

    // attributes
    public void setEnding( int m_Ending ) throws XtumlException;
    public void setStarting( int m_Starting ) throws XtumlException;


    // selections
    public LeaveSpecificationSet R15_is_specified_by_a_LeaveSpecification() throws XtumlException;
    public EmployeeSet R2_is_consumed_by_a_Employee() throws XtumlException;
    public EmployeeSet R5_is_currently_taken_by_Employee() throws XtumlException;
    public EmployeeSet R7_to_be_taken_by_Employee() throws XtumlException;


}
