package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Department;
import hrsystem.hr.main.DepartmentSet;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.EmployeeSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Department extends IModelInstance<Department,Hr> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public String getName() throws XtumlException;
    public int getMission() throws XtumlException;
    public void setMission( int m_Mission ) throws XtumlException;
    public String getDescription() throws XtumlException;
    public void setDescription( String m_Description ) throws XtumlException;
    public void setManager( String m_Manager ) throws XtumlException;
    public String getManager() throws XtumlException;


    // operations


    // selections
    default public void addR21_holds_Employee( Employee inst ) {}
    default public void removeR21_holds_Employee( Employee inst ) {}
    public EmployeeSet R21_holds_Employee() throws XtumlException;
    default public void addR22_is_divided_into_Department( Department inst ) {}
    default public void removeR22_is_divided_into_Department( Department inst ) {}
    public DepartmentSet R22_is_divided_into_Department() throws XtumlException;
    default public void setR22_is_part_of_Department( Department inst ) {}
    public Department R22_is_part_of_Department() throws XtumlException;
    default public void setR23_is_managed_by_Employee( Employee inst ) {}
    public Employee R23_is_managed_by_Employee() throws XtumlException;


}
