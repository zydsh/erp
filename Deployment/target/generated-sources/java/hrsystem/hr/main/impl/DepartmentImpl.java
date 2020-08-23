package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Department;
import hrsystem.hr.main.DepartmentSet;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.impl.DepartmentImpl;
import hrsystem.hr.main.impl.DepartmentSetImpl;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.EmployeeSetImpl;

import io.ciera.runtime.instanceloading.AttributeChangedDelta;
import io.ciera.runtime.instanceloading.InstanceCreatedDelta;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.classes.IInstanceIdentifier;
import io.ciera.runtime.summit.classes.InstanceIdentifier;
import io.ciera.runtime.summit.classes.ModelInstance;
import io.ciera.runtime.summit.exceptions.EmptyInstanceException;
import io.ciera.runtime.summit.exceptions.InstancePopulationException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.IWhere;
import io.ciera.runtime.summit.types.IXtumlType;
import io.ciera.runtime.summit.types.StringUtil;
import io.ciera.runtime.summit.types.UniqueId;


public class DepartmentImpl extends ModelInstance<Department,Hr> implements Department {

    public static final String KEY_LETTERS = "Department";
    public static final Department EMPTY_DEPARTMENT = new EmptyDepartment();

    private Hr context;

    // constructors
    private DepartmentImpl( Hr context ) {
        this.context = context;
        m_Name = "";
        m_Mission = 0;
        m_Description = "";
        m_Manager = "";
        R21_holds_Employee_set = new EmployeeSetImpl();
        R22_is_divided_into_Department_set = new DepartmentSetImpl();
        R22_is_part_of_Department_inst = DepartmentImpl.EMPTY_DEPARTMENT;
        R23_is_managed_by_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
    }

    private DepartmentImpl( Hr context, UniqueId instanceId, String m_Name, int m_Mission, String m_Description, String m_Manager ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        this.m_Mission = m_Mission;
        this.m_Description = m_Description;
        this.m_Manager = m_Manager;
        R21_holds_Employee_set = new EmployeeSetImpl();
        R22_is_divided_into_Department_set = new DepartmentSetImpl();
        R22_is_part_of_Department_inst = DepartmentImpl.EMPTY_DEPARTMENT;
        R23_is_managed_by_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
    }

    public static Department create( Hr context ) throws XtumlException {
        Department newDepartment = new DepartmentImpl( context );
        if ( context.addInstance( newDepartment ) ) {
            newDepartment.getRunContext().addChange(new InstanceCreatedDelta(newDepartment, KEY_LETTERS));
            return newDepartment;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Department create( Hr context, UniqueId instanceId, String m_Name, int m_Mission, String m_Description, String m_Manager ) throws XtumlException {
        Department newDepartment = new DepartmentImpl( context, instanceId, m_Name, m_Mission, m_Description, m_Manager );
        if ( context.addInstance( newDepartment ) ) {
            return newDepartment;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private String m_Name;
    @Override
    public void setName(String m_Name) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Name, this.m_Name)) {
            final String oldValue = this.m_Name;
            this.m_Name = m_Name;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Name", oldValue, this.m_Name));
        }
    }
    @Override
    public String getName() throws XtumlException {
        checkLiving();
        return m_Name;
    }
    private int m_Mission;
    @Override
    public int getMission() throws XtumlException {
        checkLiving();
        return m_Mission;
    }
    @Override
    public void setMission(int m_Mission) throws XtumlException {
        checkLiving();
        if (m_Mission != this.m_Mission) {
            final int oldValue = this.m_Mission;
            this.m_Mission = m_Mission;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Mission", oldValue, this.m_Mission));
        }
    }
    private String m_Description;
    @Override
    public String getDescription() throws XtumlException {
        checkLiving();
        return m_Description;
    }
    @Override
    public void setDescription(String m_Description) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Description, this.m_Description)) {
            final String oldValue = this.m_Description;
            this.m_Description = m_Description;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Description", oldValue, this.m_Description));
        }
    }
    private String m_Manager;
    @Override
    public void setManager(String m_Manager) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Manager, this.m_Manager)) {
            final String oldValue = this.m_Manager;
            this.m_Manager = m_Manager;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Manager", oldValue, this.m_Manager));
        }
    }
    @Override
    public String getManager() throws XtumlException {
        checkLiving();
        {
            Employee employee = self().R23_is_managed_by_Employee();
            self().setManager(( employee.getFirstName() + " " ) + employee.getLastName());
        }
        return m_Manager;
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getName());
        }
        catch ( XtumlException e ) {
            getRunContext().getLog().error(e);
            System.exit(1);
            return null;
        }
    }

    // operations


    // static operations


    // events


    // selections
    private EmployeeSet R21_holds_Employee_set;
    @Override
    public void addR21_holds_Employee( Employee inst ) {
        R21_holds_Employee_set.add(inst);
    }
    @Override
    public void removeR21_holds_Employee( Employee inst ) {
        R21_holds_Employee_set.remove(inst);
    }
    @Override
    public EmployeeSet R21_holds_Employee() throws XtumlException {
        return R21_holds_Employee_set;
    }
    private DepartmentSet R22_is_divided_into_Department_set;
    @Override
    public void addR22_is_divided_into_Department( Department inst ) {
        R22_is_divided_into_Department_set.add(inst);
    }
    @Override
    public void removeR22_is_divided_into_Department( Department inst ) {
        R22_is_divided_into_Department_set.remove(inst);
    }
    @Override
    public DepartmentSet R22_is_divided_into_Department() throws XtumlException {
        return R22_is_divided_into_Department_set;
    }
    private Department R22_is_part_of_Department_inst;
    @Override
    public void setR22_is_part_of_Department( Department inst ) {
        R22_is_part_of_Department_inst = inst;
    }
    @Override
    public Department R22_is_part_of_Department() throws XtumlException {
        return R22_is_part_of_Department_inst;
    }
    private Employee R23_is_managed_by_Employee_inst;
    @Override
    public void setR23_is_managed_by_Employee( Employee inst ) {
        R23_is_managed_by_Employee_inst = inst;
    }
    @Override
    public Employee R23_is_managed_by_Employee() throws XtumlException {
        return R23_is_managed_by_Employee_inst;
    }


    @Override
    public IRunContext getRunContext() {
        return context().getRunContext();
    }

    @Override
    public Hr context() {
        return context;
    }

    @Override
    public String getKeyLetters() {
        return KEY_LETTERS;
    }

    @Override
    public Department self() {
        return this;
    }

    @Override
    public Department oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_DEPARTMENT;
    }

}

class EmptyDepartment extends ModelInstance<Department,Hr> implements Department {

    // attributes
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getMission() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setMission( int m_Mission ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getDescription() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setDescription( String m_Description ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setManager( String m_Manager ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getManager() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public EmployeeSet R21_holds_Employee() {
        return (new EmployeeSetImpl());
    }
    @Override
    public DepartmentSet R22_is_divided_into_Department() {
        return (new DepartmentSetImpl());
    }
    @Override
    public Department R22_is_part_of_Department() {
        return DepartmentImpl.EMPTY_DEPARTMENT;
    }
    @Override
    public Employee R23_is_managed_by_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }


    @Override
    public String getKeyLetters() {
        return DepartmentImpl.KEY_LETTERS;
    }

    @Override
    public Department self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Department oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return DepartmentImpl.EMPTY_DEPARTMENT;
    }

}
