package hrsystem.hr.main;


import hrsystem.hr.main.DepartmentSet;
import hrsystem.hr.main.EmployeeSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface DepartmentSet extends IInstanceSet<DepartmentSet,Department> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public void setManager( String m_Manager ) throws XtumlException;
    public void setDescription( String m_Description ) throws XtumlException;
    public void setMission( int m_Mission ) throws XtumlException;


    // selections
    public EmployeeSet R21_holds_Employee() throws XtumlException;
    public DepartmentSet R22_is_divided_into_Department() throws XtumlException;
    public DepartmentSet R22_is_part_of_Department() throws XtumlException;
    public EmployeeSet R23_is_managed_by_Employee() throws XtumlException;


}
