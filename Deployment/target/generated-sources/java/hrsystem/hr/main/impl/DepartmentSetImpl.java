package hrsystem.hr.main.impl;


import hrsystem.hr.main.Department;
import hrsystem.hr.main.DepartmentSet;
import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.impl.DepartmentSetImpl;
import hrsystem.hr.main.impl.EmployeeSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class DepartmentSetImpl extends InstanceSet<DepartmentSet,Department> implements DepartmentSet {

    public DepartmentSetImpl() {
    }

    public DepartmentSetImpl(Comparator<? super Department> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Department department : this ) department.setName( m_Name );
    }
    @Override
    public void setManager( String m_Manager ) throws XtumlException {
        for ( Department department : this ) department.setManager( m_Manager );
    }
    @Override
    public void setDescription( String m_Description ) throws XtumlException {
        for ( Department department : this ) department.setDescription( m_Description );
    }
    @Override
    public void setMission( int m_Mission ) throws XtumlException {
        for ( Department department : this ) department.setMission( m_Mission );
    }


    // selections
    @Override
    public EmployeeSet R21_holds_Employee() throws XtumlException {
        EmployeeSet employeeset = new EmployeeSetImpl();
        for ( Department department : this ) employeeset.addAll( department.R21_holds_Employee() );
        return employeeset;
    }
    @Override
    public DepartmentSet R22_is_divided_into_Department() throws XtumlException {
        DepartmentSet departmentset = new DepartmentSetImpl();
        for ( Department department : this ) departmentset.addAll( department.R22_is_divided_into_Department() );
        return departmentset;
    }
    @Override
    public DepartmentSet R22_is_part_of_Department() throws XtumlException {
        DepartmentSet departmentset = new DepartmentSetImpl();
        for ( Department department : this ) departmentset.add( department.R22_is_part_of_Department() );
        return departmentset;
    }
    @Override
    public EmployeeSet R23_is_managed_by_Employee() throws XtumlException {
        EmployeeSet employeeset = new EmployeeSetImpl();
        for ( Department department : this ) employeeset.add( department.R23_is_managed_by_Employee() );
        return employeeset;
    }


    @Override
    public Department nullElement() {
        return DepartmentImpl.EMPTY_DEPARTMENT;
    }

    @Override
    public DepartmentSet emptySet() {
      return new DepartmentSetImpl();
    }

    @Override
    public DepartmentSet emptySet(Comparator<? super Department> comp) {
      return new DepartmentSetImpl(comp);
    }

    @Override
    public List<Department> elements() {
        return Arrays.asList(toArray(new Department[0]));
    }

}
