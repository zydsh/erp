package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus;
import hrsystem.hr.main.BonusSet;
import hrsystem.hr.main.Department;
import hrsystem.hr.main.DepartmentSet;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.JobRecord;
import hrsystem.hr.main.JobRecordSet;
import hrsystem.hr.main.Leave;
import hrsystem.hr.main.LeaveSet;
import hrsystem.hr.main.PayslipItem;
import hrsystem.hr.main.PayslipItemSet;
import hrsystem.hr.main.impl.BonusSetImpl;
import hrsystem.hr.main.impl.DepartmentImpl;
import hrsystem.hr.main.impl.DepartmentSetImpl;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.JobImpl;
import hrsystem.hr.main.impl.JobRecordSetImpl;
import hrsystem.hr.main.impl.LeaveImpl;
import hrsystem.hr.main.impl.LeaveSetImpl;
import hrsystem.hr.main.impl.PayslipItemSetImpl;
import hrsystem.hr.messagecenter.ApproveLeave;
import hrsystem.hr.messagecenter.ApproveLeaveSet;
import hrsystem.hr.messagecenter.impl.ApproveLeaveSetImpl;

import io.ciera.runtime.instanceloading.AttributeChangedDelta;
import io.ciera.runtime.instanceloading.InstanceCreatedDelta;
import io.ciera.runtime.summit.application.ActionHome;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.classes.IInstanceIdentifier;
import io.ciera.runtime.summit.classes.InstanceIdentifier;
import io.ciera.runtime.summit.classes.ModelInstance;
import io.ciera.runtime.summit.exceptions.EmptyInstanceException;
import io.ciera.runtime.summit.exceptions.InstancePopulationException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.statemachine.Event;
import io.ciera.runtime.summit.statemachine.IEvent;
import io.ciera.runtime.summit.types.IWhere;
import io.ciera.runtime.summit.types.IXtumlType;
import io.ciera.runtime.summit.types.StringUtil;
import io.ciera.runtime.summit.types.UniqueId;


public class EmployeeImpl extends ModelInstance<Employee,Hr> implements Employee {

    public static final String KEY_LETTERS = "Employee";
    public static final Employee EMPTY_EMPLOYEE = new EmptyEmployee();

    private Hr context;

    // constructors
    private EmployeeImpl( Hr context ) {
        this.context = context;
        m_EmployeeID = 0;
        m_NationalID = 0;
        m_FirstName = "";
        m_MiddleName = "";
        m_LastName = "";
        m_DateOfBirth = 0;
        m_Degree = "";
        m_Gender = "";
        m_Start_Date = 0;
        m_LeaveBalance = 0;
        m_SickLeaveBalance = 0;
        R102_is_notified_by_ApproveLeave_set = new ApproveLeaveSetImpl();
        R19_was_given_a_Bonus_set = new BonusSetImpl();
        R1_occupied_JobRecord_set = new JobRecordSetImpl();
        R20_to_be_promoted_to_a_Job_inst = JobImpl.EMPTY_JOB;
        R21_working_within_Department_inst = DepartmentImpl.EMPTY_DEPARTMENT;
        R23_manages_Department_set = new DepartmentSetImpl();
        R2_consumed_Leave_set = new LeaveSetImpl();
        R3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem_set = new PayslipItemSetImpl();
        R4_gets_a_Bonus_set = new BonusSetImpl();
        R5_is_taking_a_Leave_inst = LeaveImpl.EMPTY_LEAVE;
        R6_currently_occupies_a_Job_inst = JobImpl.EMPTY_JOB;
        R7_is_planning_to_take__Leave_inst = LeaveImpl.EMPTY_LEAVE;
        statemachine = new EmployeeStateMachine(this, context());
    }

    private EmployeeImpl( Hr context, UniqueId instanceId, int m_EmployeeID, int m_NationalID, String m_FirstName, String m_MiddleName, String m_LastName, int m_DateOfBirth, String m_Degree, String m_Gender, int m_Start_Date, int m_LeaveBalance, int m_SickLeaveBalance, int initialState ) {
        super(instanceId);
        this.context = context;
        this.m_EmployeeID = m_EmployeeID;
        this.m_NationalID = m_NationalID;
        this.m_FirstName = m_FirstName;
        this.m_MiddleName = m_MiddleName;
        this.m_LastName = m_LastName;
        this.m_DateOfBirth = m_DateOfBirth;
        this.m_Degree = m_Degree;
        this.m_Gender = m_Gender;
        this.m_Start_Date = m_Start_Date;
        this.m_LeaveBalance = m_LeaveBalance;
        this.m_SickLeaveBalance = m_SickLeaveBalance;
        R102_is_notified_by_ApproveLeave_set = new ApproveLeaveSetImpl();
        R19_was_given_a_Bonus_set = new BonusSetImpl();
        R1_occupied_JobRecord_set = new JobRecordSetImpl();
        R20_to_be_promoted_to_a_Job_inst = JobImpl.EMPTY_JOB;
        R21_working_within_Department_inst = DepartmentImpl.EMPTY_DEPARTMENT;
        R23_manages_Department_set = new DepartmentSetImpl();
        R2_consumed_Leave_set = new LeaveSetImpl();
        R3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem_set = new PayslipItemSetImpl();
        R4_gets_a_Bonus_set = new BonusSetImpl();
        R5_is_taking_a_Leave_inst = LeaveImpl.EMPTY_LEAVE;
        R6_currently_occupies_a_Job_inst = JobImpl.EMPTY_JOB;
        R7_is_planning_to_take__Leave_inst = LeaveImpl.EMPTY_LEAVE;
        statemachine = new EmployeeStateMachine(this, context(), initialState);
    }

    public static Employee create( Hr context ) throws XtumlException {
        Employee newEmployee = new EmployeeImpl( context );
        if ( context.addInstance( newEmployee ) ) {
            newEmployee.getRunContext().addChange(new InstanceCreatedDelta(newEmployee, KEY_LETTERS));
            return newEmployee;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Employee create( Hr context, UniqueId instanceId, int m_EmployeeID, int m_NationalID, String m_FirstName, String m_MiddleName, String m_LastName, int m_DateOfBirth, String m_Degree, String m_Gender, int m_Start_Date, int m_LeaveBalance, int m_SickLeaveBalance, int initialState ) throws XtumlException {
        Employee newEmployee = new EmployeeImpl( context, instanceId, m_EmployeeID, m_NationalID, m_FirstName, m_MiddleName, m_LastName, m_DateOfBirth, m_Degree, m_Gender, m_Start_Date, m_LeaveBalance, m_SickLeaveBalance, initialState );
        if ( context.addInstance( newEmployee ) ) {
            return newEmployee;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    private final EmployeeStateMachine statemachine;
    
    @Override
    public void accept(IEvent event) throws XtumlException {
        statemachine.transition(event);
    }

    @Override
    public int getCurrentState() {
        return statemachine.getCurrentState();
    }


    // attributes
    private int m_EmployeeID;
    @Override
    public void setEmployeeID(int m_EmployeeID) throws XtumlException {
        checkLiving();
        if (m_EmployeeID != this.m_EmployeeID) {
            final int oldValue = this.m_EmployeeID;
            this.m_EmployeeID = m_EmployeeID;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_EmployeeID", oldValue, this.m_EmployeeID));
        }
    }
    @Override
    public int getEmployeeID() throws XtumlException {
        checkLiving();
        return m_EmployeeID;
    }
    private int m_NationalID;
    @Override
    public int getNationalID() throws XtumlException {
        checkLiving();
        return m_NationalID;
    }
    @Override
    public void setNationalID(int m_NationalID) throws XtumlException {
        checkLiving();
        if (m_NationalID != this.m_NationalID) {
            final int oldValue = this.m_NationalID;
            this.m_NationalID = m_NationalID;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_NationalID", oldValue, this.m_NationalID));
        }
    }
    private String m_FirstName;
    @Override
    public void setFirstName(String m_FirstName) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_FirstName, this.m_FirstName)) {
            final String oldValue = this.m_FirstName;
            this.m_FirstName = m_FirstName;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_FirstName", oldValue, this.m_FirstName));
        }
    }
    @Override
    public String getFirstName() throws XtumlException {
        checkLiving();
        return m_FirstName;
    }
    private String m_MiddleName;
    @Override
    public void setMiddleName(String m_MiddleName) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_MiddleName, this.m_MiddleName)) {
            final String oldValue = this.m_MiddleName;
            this.m_MiddleName = m_MiddleName;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_MiddleName", oldValue, this.m_MiddleName));
        }
    }
    @Override
    public String getMiddleName() throws XtumlException {
        checkLiving();
        return m_MiddleName;
    }
    private String m_LastName;
    @Override
    public void setLastName(String m_LastName) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_LastName, this.m_LastName)) {
            final String oldValue = this.m_LastName;
            this.m_LastName = m_LastName;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_LastName", oldValue, this.m_LastName));
        }
    }
    @Override
    public String getLastName() throws XtumlException {
        checkLiving();
        return m_LastName;
    }
    private int m_DateOfBirth;
    @Override
    public int getDateOfBirth() throws XtumlException {
        checkLiving();
        return m_DateOfBirth;
    }
    @Override
    public void setDateOfBirth(int m_DateOfBirth) throws XtumlException {
        checkLiving();
        if (m_DateOfBirth != this.m_DateOfBirth) {
            final int oldValue = this.m_DateOfBirth;
            this.m_DateOfBirth = m_DateOfBirth;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_DateOfBirth", oldValue, this.m_DateOfBirth));
        }
    }
    private String m_Degree;
    @Override
    public String getDegree() throws XtumlException {
        checkLiving();
        return m_Degree;
    }
    @Override
    public void setDegree(String m_Degree) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Degree, this.m_Degree)) {
            final String oldValue = this.m_Degree;
            this.m_Degree = m_Degree;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Degree", oldValue, this.m_Degree));
        }
    }
    private String m_Gender;
    @Override
    public String getGender() throws XtumlException {
        checkLiving();
        return m_Gender;
    }
    @Override
    public void setGender(String m_Gender) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Gender, this.m_Gender)) {
            final String oldValue = this.m_Gender;
            this.m_Gender = m_Gender;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Gender", oldValue, this.m_Gender));
        }
    }
    private int m_Start_Date;
    @Override
    public void setStart_Date(int m_Start_Date) throws XtumlException {
        checkLiving();
        if (m_Start_Date != this.m_Start_Date) {
            final int oldValue = this.m_Start_Date;
            this.m_Start_Date = m_Start_Date;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Start_Date", oldValue, this.m_Start_Date));
        }
    }
    @Override
    public int getStart_Date() throws XtumlException {
        checkLiving();
        return m_Start_Date;
    }
    private int m_LeaveBalance;
    @Override
    public int getLeaveBalance() throws XtumlException {
        checkLiving();
        return m_LeaveBalance;
    }
    @Override
    public void setLeaveBalance(int m_LeaveBalance) throws XtumlException {
        checkLiving();
        if (m_LeaveBalance != this.m_LeaveBalance) {
            final int oldValue = this.m_LeaveBalance;
            this.m_LeaveBalance = m_LeaveBalance;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_LeaveBalance", oldValue, this.m_LeaveBalance));
        }
    }
    private int m_SickLeaveBalance;
    @Override
    public void setSickLeaveBalance(int m_SickLeaveBalance) throws XtumlException {
        checkLiving();
        if (m_SickLeaveBalance != this.m_SickLeaveBalance) {
            final int oldValue = this.m_SickLeaveBalance;
            this.m_SickLeaveBalance = m_SickLeaveBalance;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_SickLeaveBalance", oldValue, this.m_SickLeaveBalance));
        }
    }
    @Override
    public int getSickLeaveBalance() throws XtumlException {
        checkLiving();
        return m_SickLeaveBalance;
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getNationalID());
        }
        catch ( XtumlException e ) {
            getRunContext().getLog().error(e);
            System.exit(1);
            return null;
        }
    }
    @Override
    public IInstanceIdentifier getId2() {
        try {
            return new InstanceIdentifier(getEmployeeID());
        }
        catch ( XtumlException e ) {
            getRunContext().getLog().error(e);
            System.exit(1);
            return null;
        }
    }

    // operations
    @Override
    public void commenceEmployee( final int p_National_ID ) throws XtumlException {
        context().LOG().LogInfo( "An employee attempts to commence." );
        context().generate(new EmployeeImpl.commenced(getRunContext(), context().getId()).toSelf(self()));
        self().setStart_Date(context().TIM().current_seconds());
        context().UI().Reply( "Employee has commenced ", true );
    }

    @Override
    public double getSalary() throws XtumlException {
        Job job = self().R6_currently_occupies_a_Job();
        return job.getSalary();
    }



    // static operations
    public static class CLASS extends ActionHome<Hr> {

        public CLASS( Hr context ) {
            super( context );
        }

        public void createPayment( final int p_National_ID,  final String p_Name,  final double p_Amount,  final int p_Date ) throws XtumlException {
        }



    }


    // events
    public static class LeaveEnded extends Event {
        public LeaveEnded(IRunContext runContext, int populationId) {
            super(runContext, populationId);
        }
        @Override
        public int getId() {
            return 3;
        }
        @Override
        public String getClassName() {
            return "Employee";
        }
    }
    public static class LeaveStarted extends Event {
        public LeaveStarted(IRunContext runContext, int populationId) {
            super(runContext, populationId);
        }
        @Override
        public int getId() {
            return 2;
        }
        @Override
        public String getClassName() {
            return "Employee";
        }
    }
    public static class commenced extends Event {
        public commenced(IRunContext runContext, int populationId) {
            super(runContext, populationId);
        }
        @Override
        public int getId() {
            return 1;
        }
        @Override
        public String getClassName() {
            return "Employee";
        }
    }
    public static class employeeUpdateRcvd extends Event {
        public employeeUpdateRcvd(IRunContext runContext, int populationId) {
            super(runContext, populationId);
        }
        @Override
        public int getId() {
            return 4;
        }
        @Override
        public String getClassName() {
            return "Employee";
        }
    }
    public static class requestLeave extends Event {
        public requestLeave(IRunContext runContext, int populationId,  final int p_Starting,  final int p_Ending,  final int p_National_ID,  final String p_Name ) {
            super(runContext, populationId, new Object[]{p_Starting,  p_Ending,  p_National_ID,  p_Name});
        }
        @Override
        public int getId() {
            return 0;
        }
        @Override
        public String getClassName() {
            return "Employee";
        }
    }
    public static class returnFromLeave extends Event {
        public returnFromLeave(IRunContext runContext, int populationId) {
            super(runContext, populationId);
        }
        @Override
        public int getId() {
            return 5;
        }
        @Override
        public String getClassName() {
            return "Employee";
        }
    }


    // selections
    private ApproveLeaveSet R102_is_notified_by_ApproveLeave_set;
    @Override
    public void addR102_is_notified_by_ApproveLeave( ApproveLeave inst ) {
        R102_is_notified_by_ApproveLeave_set.add(inst);
    }
    @Override
    public void removeR102_is_notified_by_ApproveLeave( ApproveLeave inst ) {
        R102_is_notified_by_ApproveLeave_set.remove(inst);
    }
    @Override
    public ApproveLeaveSet R102_is_notified_by_ApproveLeave() throws XtumlException {
        return R102_is_notified_by_ApproveLeave_set;
    }
    private BonusSet R19_was_given_a_Bonus_set;
    @Override
    public void addR19_was_given_a_Bonus( Bonus inst ) {
        R19_was_given_a_Bonus_set.add(inst);
    }
    @Override
    public void removeR19_was_given_a_Bonus( Bonus inst ) {
        R19_was_given_a_Bonus_set.remove(inst);
    }
    @Override
    public BonusSet R19_was_given_a_Bonus() throws XtumlException {
        return R19_was_given_a_Bonus_set;
    }
    private JobRecordSet R1_occupied_JobRecord_set;
    @Override
    public void addR1_occupied_JobRecord( JobRecord inst ) {
        R1_occupied_JobRecord_set.add(inst);
    }
    @Override
    public void removeR1_occupied_JobRecord( JobRecord inst ) {
        R1_occupied_JobRecord_set.remove(inst);
    }
    @Override
    public JobRecordSet R1_occupied_JobRecord() throws XtumlException {
        return R1_occupied_JobRecord_set;
    }
    private Job R20_to_be_promoted_to_a_Job_inst;
    @Override
    public void setR20_to_be_promoted_to_a_Job( Job inst ) {
        R20_to_be_promoted_to_a_Job_inst = inst;
    }
    @Override
    public Job R20_to_be_promoted_to_a_Job() throws XtumlException {
        return R20_to_be_promoted_to_a_Job_inst;
    }
    private Department R21_working_within_Department_inst;
    @Override
    public void setR21_working_within_Department( Department inst ) {
        R21_working_within_Department_inst = inst;
    }
    @Override
    public Department R21_working_within_Department() throws XtumlException {
        return R21_working_within_Department_inst;
    }
    private DepartmentSet R23_manages_Department_set;
    @Override
    public void addR23_manages_Department( Department inst ) {
        R23_manages_Department_set.add(inst);
    }
    @Override
    public void removeR23_manages_Department( Department inst ) {
        R23_manages_Department_set.remove(inst);
    }
    @Override
    public DepartmentSet R23_manages_Department() throws XtumlException {
        return R23_manages_Department_set;
    }
    private LeaveSet R2_consumed_Leave_set;
    @Override
    public void addR2_consumed_Leave( Leave inst ) {
        R2_consumed_Leave_set.add(inst);
    }
    @Override
    public void removeR2_consumed_Leave( Leave inst ) {
        R2_consumed_Leave_set.remove(inst);
    }
    @Override
    public LeaveSet R2_consumed_Leave() throws XtumlException {
        return R2_consumed_Leave_set;
    }
    private PayslipItemSet R3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem_set;
    @Override
    public void addR3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem( PayslipItem inst ) {
        R3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem_set.add(inst);
    }
    @Override
    public void removeR3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem( PayslipItem inst ) {
        R3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem_set.remove(inst);
    }
    @Override
    public PayslipItemSet R3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem() throws XtumlException {
        return R3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem_set;
    }
    private BonusSet R4_gets_a_Bonus_set;
    @Override
    public void addR4_gets_a_Bonus( Bonus inst ) {
        R4_gets_a_Bonus_set.add(inst);
    }
    @Override
    public void removeR4_gets_a_Bonus( Bonus inst ) {
        R4_gets_a_Bonus_set.remove(inst);
    }
    @Override
    public BonusSet R4_gets_a_Bonus() throws XtumlException {
        return R4_gets_a_Bonus_set;
    }
    private Leave R5_is_taking_a_Leave_inst;
    @Override
    public void setR5_is_taking_a_Leave( Leave inst ) {
        R5_is_taking_a_Leave_inst = inst;
    }
    @Override
    public Leave R5_is_taking_a_Leave() throws XtumlException {
        return R5_is_taking_a_Leave_inst;
    }
    private Job R6_currently_occupies_a_Job_inst;
    @Override
    public void setR6_currently_occupies_a_Job( Job inst ) {
        R6_currently_occupies_a_Job_inst = inst;
    }
    @Override
    public Job R6_currently_occupies_a_Job() throws XtumlException {
        return R6_currently_occupies_a_Job_inst;
    }
    private Leave R7_is_planning_to_take__Leave_inst;
    @Override
    public void setR7_is_planning_to_take__Leave( Leave inst ) {
        R7_is_planning_to_take__Leave_inst = inst;
    }
    @Override
    public Leave R7_is_planning_to_take__Leave() throws XtumlException {
        return R7_is_planning_to_take__Leave_inst;
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
    public Employee self() {
        return this;
    }

    @Override
    public Employee oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_EMPLOYEE;
    }

}

class EmptyEmployee extends ModelInstance<Employee,Hr> implements Employee {

    // attributes
    public void setEmployeeID( int m_EmployeeID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getEmployeeID() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getNationalID() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setNationalID( int m_NationalID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setFirstName( String m_FirstName ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getFirstName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setMiddleName( String m_MiddleName ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getMiddleName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setLastName( String m_LastName ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getLastName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getDateOfBirth() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setDateOfBirth( int m_DateOfBirth ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getDegree() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setDegree( String m_Degree ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getGender() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setGender( String m_Gender ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setStart_Date( int m_Start_Date ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getStart_Date() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getLeaveBalance() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setLeaveBalance( int m_LeaveBalance ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setSickLeaveBalance( int m_SickLeaveBalance ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getSickLeaveBalance() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations
    public void commenceEmployee( final int p_National_ID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot invoke operation on empty instance." );
    }
    public double getSalary() throws XtumlException {
        throw new EmptyInstanceException( "Cannot invoke operation on empty instance." );
    }


    // selections
    @Override
    public ApproveLeaveSet R102_is_notified_by_ApproveLeave() {
        return (new ApproveLeaveSetImpl());
    }
    @Override
    public BonusSet R19_was_given_a_Bonus() {
        return (new BonusSetImpl());
    }
    @Override
    public JobRecordSet R1_occupied_JobRecord() {
        return (new JobRecordSetImpl());
    }
    @Override
    public Job R20_to_be_promoted_to_a_Job() {
        return JobImpl.EMPTY_JOB;
    }
    @Override
    public Department R21_working_within_Department() {
        return DepartmentImpl.EMPTY_DEPARTMENT;
    }
    @Override
    public DepartmentSet R23_manages_Department() {
        return (new DepartmentSetImpl());
    }
    @Override
    public LeaveSet R2_consumed_Leave() {
        return (new LeaveSetImpl());
    }
    @Override
    public PayslipItemSet R3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem() {
        return (new PayslipItemSetImpl());
    }
    @Override
    public BonusSet R4_gets_a_Bonus() {
        return (new BonusSetImpl());
    }
    @Override
    public Leave R5_is_taking_a_Leave() {
        return LeaveImpl.EMPTY_LEAVE;
    }
    @Override
    public Job R6_currently_occupies_a_Job() {
        return JobImpl.EMPTY_JOB;
    }
    @Override
    public Leave R7_is_planning_to_take__Leave() {
        return LeaveImpl.EMPTY_LEAVE;
    }


    @Override
    public String getKeyLetters() {
        return EmployeeImpl.KEY_LETTERS;
    }

    @Override
    public Employee self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Employee oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }

}
