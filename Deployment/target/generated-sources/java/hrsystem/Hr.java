package hrsystem;


import hrsystem.hr.HrAuthenticate;
import hrsystem.hr.HrUI;
import hrsystem.hr.HrUI_Ops;
import hrsystem.hr.main.Bonus;
import hrsystem.hr.main.BonusSet;
import hrsystem.hr.main.BonusSpecification;
import hrsystem.hr.main.BonusSpecificationSet;
import hrsystem.hr.main.Department;
import hrsystem.hr.main.DepartmentSet;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.Grade;
import hrsystem.hr.main.GradeSet;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.JobRecord;
import hrsystem.hr.main.JobRecordSet;
import hrsystem.hr.main.JobSet;
import hrsystem.hr.main.Leave;
import hrsystem.hr.main.LeaveSet;
import hrsystem.hr.main.LeaveSpecification;
import hrsystem.hr.main.LeaveSpecificationSet;
import hrsystem.hr.main.PayslipItem;
import hrsystem.hr.main.PayslipItemSet;
import hrsystem.hr.main.Scale;
import hrsystem.hr.main.ScaleSet;
import hrsystem.hr.main.impl.BonusImpl;
import hrsystem.hr.main.impl.BonusSetImpl;
import hrsystem.hr.main.impl.BonusSpecificationImpl;
import hrsystem.hr.main.impl.BonusSpecificationSetImpl;
import hrsystem.hr.main.impl.DepartmentImpl;
import hrsystem.hr.main.impl.DepartmentSetImpl;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.EmployeeSetImpl;
import hrsystem.hr.main.impl.GradeImpl;
import hrsystem.hr.main.impl.GradeSetImpl;
import hrsystem.hr.main.impl.JobImpl;
import hrsystem.hr.main.impl.JobRecordImpl;
import hrsystem.hr.main.impl.JobRecordSetImpl;
import hrsystem.hr.main.impl.JobSetImpl;
import hrsystem.hr.main.impl.LeaveImpl;
import hrsystem.hr.main.impl.LeaveSetImpl;
import hrsystem.hr.main.impl.LeaveSpecificationImpl;
import hrsystem.hr.main.impl.LeaveSpecificationSetImpl;
import hrsystem.hr.main.impl.PayslipItemImpl;
import hrsystem.hr.main.impl.PayslipItemSetImpl;
import hrsystem.hr.main.impl.ScaleImpl;
import hrsystem.hr.main.impl.ScaleSetImpl;
import hrsystem.hr.messagecenter.ApproveLeave;
import hrsystem.hr.messagecenter.ApproveLeaveSet;
import hrsystem.hr.messagecenter.impl.ApproveLeaveImpl;
import hrsystem.hr.messagecenter.impl.ApproveLeaveSetImpl;

import io.ciera.runtime.summit.application.IApplication;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.classes.IRelationshipSet;
import io.ciera.runtime.summit.classes.Relationship;
import io.ciera.runtime.summit.classes.RelationshipSet;
import io.ciera.runtime.summit.components.Component;
import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.EmptyInstanceException;
import io.ciera.runtime.summit.exceptions.ModelIntegrityException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.StringUtil;
import io.ciera.runtime.summit.util.LOG;
import io.ciera.runtime.summit.util.TIM;
import io.ciera.runtime.summit.util.impl.LOGImpl;
import io.ciera.runtime.summit.util.impl.TIMImpl;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;


public class Hr extends Component<Hr> {

    private Map<String, Class<?>> classDirectory;

    public Hr(IApplication app, IRunContext runContext, int populationId) {
        super(app, runContext, populationId);
        ApproveLeave_extent = new ApproveLeaveSetImpl();
        Bonus_extent = new BonusSetImpl();
        BonusSpecification_extent = new BonusSpecificationSetImpl();
        Department_extent = new DepartmentSetImpl();
        Employee_extent = new EmployeeSetImpl();
        Grade_extent = new GradeSetImpl();
        Job_extent = new JobSetImpl();
        JobRecord_extent = new JobRecordSetImpl();
        Leave_extent = new LeaveSetImpl();
        LeaveSpecification_extent = new LeaveSpecificationSetImpl();
        PayslipItem_extent = new PayslipItemSetImpl();
        Scale_extent = new ScaleSetImpl();
        R102_ApproveLeave_notifies_Employee_extent = new RelationshipSet();
        R11_Leave_consumed_by_Employee_extent = new RelationshipSet();
        R12_Grade_is_part_of_Scale_extent = new RelationshipSet();
        R14_Grade_follows_Grade_extent = new RelationshipSet();
        R15_Leave_is_specified_by_a_LeaveSpecification_extent = new RelationshipSet();
        R16_Bonus_is_specified_by_BonusSpecification_extent = new RelationshipSet();
        R17_JobRecord_proceeded_by_JobRecord_extent = new RelationshipSet();
        R18_PayslipItem_listed_after_PayslipItem_extent = new RelationshipSet();
        R19_Bonus_given_in_the_past_Employee_extent = new RelationshipSet();
        R1_JobRecord_occupied_Job_extent = new RelationshipSet();
        R1_JobRecord_was_assigned_to_Employee_extent = new RelationshipSet();
        R20_Employee_to_be_promoted_to_Job_extent = new RelationshipSet();
        R21_Employee_working_within_Department_extent = new RelationshipSet();
        R22_Department_is_part_of_Department_extent = new RelationshipSet();
        R23_Department_is_managed_by_Employee_extent = new RelationshipSet();
        R3_PayslipItem_records_an_earning_or_deduction_to_Employee_extent = new RelationshipSet();
        R4_Bonus_is_given_to_an_Employee_extent = new RelationshipSet();
        R5_Employee_is_taking_a_Leave_extent = new RelationshipSet();
        R6_Employee_currently_occupies_Job_extent = new RelationshipSet();
        R7_Leave_to_be_taken_by_Employee_extent = new RelationshipSet();
        R9_Job_assigned_Grade_extent = new RelationshipSet();
        TIM = null;
        LOG = null;
        classDirectory = new TreeMap<>();
        classDirectory.put("ApproveLeave", ApproveLeaveImpl.class);
        classDirectory.put("Bonus", BonusImpl.class);
        classDirectory.put("BonusSpecification", BonusSpecificationImpl.class);
        classDirectory.put("Department", DepartmentImpl.class);
        classDirectory.put("Employee", EmployeeImpl.class);
        classDirectory.put("Grade", GradeImpl.class);
        classDirectory.put("Job", JobImpl.class);
        classDirectory.put("EJ", JobRecordImpl.class);
        classDirectory.put("Leave", LeaveImpl.class);
        classDirectory.put("LeaveSpecification", LeaveSpecificationImpl.class);
        classDirectory.put("PayslipItem", PayslipItemImpl.class);
        classDirectory.put("Scale", ScaleImpl.class);
    }

    // domain functions
    public void CreatePEI_Bonus() throws XtumlException {
        BonusSpecification bonus = BonusSpecificationImpl.create( context() );
        bonus.setName("1.5 hour overtime");
        bonus.setPercent(0.15);
        context().LOG().LogInfo( "Bonus: Created " + bonus.getName() );
        bonus = BonusSpecificationImpl.create( context() );
        bonus.setName("Scarcity");
        bonus.setPercent(0.3);
        context().LOG().LogInfo( "Bonus: Created " + bonus.getName() );
        bonus = BonusSpecificationImpl.create( context() );
        bonus.setName("Computing");
        bonus.setPercent(0.25);
        context().LOG().LogInfo( "Bonus: Created " + bonus.getName() );
        bonus = BonusSpecificationImpl.create( context() );
        bonus.setName("Research");
        bonus.setPercent(0.4);
        context().LOG().LogInfo( "Bonus: Created " + bonus.getName() );
    }

    public void CreatePEI_Departments() throws XtumlException {
        Department departmentHR = DepartmentImpl.create( context() );
        departmentHR.setName("Human Resources");
        departmentHR.setMission("Manages employees functions");
        context().LOG().LogInfo( "Department: Created " + departmentHR.getName() );
        Employee mgr = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == 1422222);
        context().relate_R23_Department_is_managed_by_Employee( departmentHR, mgr );
        context().relate_R21_Employee_working_within_Department( mgr, departmentHR );
        context().Authenticate().AddToGroup( mgr.getEmployeeID(), "Managers" );
        context().Authenticate().AddToGroup( mgr.getEmployeeID(), "HR" );
        mgr = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == 1421111);
        context().relate_R21_Employee_working_within_Department( mgr, departmentHR );
        context().Authenticate().AddToGroup( mgr.getEmployeeID(), "HR" );
        mgr = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == 1420000);
        context().relate_R21_Employee_working_within_Department( mgr, departmentHR );
        context().Authenticate().AddToGroup( mgr.getEmployeeID(), "HR" );
        Department departmentFin = DepartmentImpl.create( context() );
        departmentFin.setName("Finance Resources");
        departmentFin.setMission("Manages finance ");
        context().LOG().LogInfo( "Department: Created " + departmentFin.getName() );
        mgr = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == 1427777);
        context().relate_R23_Department_is_managed_by_Employee( departmentFin, mgr );
        context().relate_R21_Employee_working_within_Department( mgr, departmentFin );
        context().Authenticate().AddToGroup( mgr.getEmployeeID(), "Managers" );
        mgr = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == 1426666);
        context().relate_R21_Employee_working_within_Department( mgr, departmentHR );
        mgr = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == 1425555);
        context().relate_R21_Employee_working_within_Department( mgr, departmentHR );
        Department vpServices = DepartmentImpl.create( context() );
        vpServices.setName("Vice President for Services");
        vpServices.setMission("Manage organization supporting services");
        context().LOG().LogInfo( "Department: Created " + vpServices.getName() );
        mgr = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == 1424444);
        context().relate_R23_Department_is_managed_by_Employee( vpServices, mgr );
        context().relate_R21_Employee_working_within_Department( mgr, vpServices );
        context().Authenticate().AddToGroup( mgr.getEmployeeID(), "Managers" );
        Employee emp = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == 1428888);
        context().relate_R21_Employee_working_within_Department( emp, vpServices );
        emp = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == 1429999);
        context().relate_R21_Employee_working_within_Department( emp, vpServices );
        context().relate_R22_Department_is_part_of_Department( vpServices, departmentHR );
        context().LOG().LogInfo( ( ( "Departments: related: " + vpServices.getName() ) + " to " ) + departmentHR.getName() );
        Department President = DepartmentImpl.create( context() );
        President.setName("President Office");
        President.setMission("Manage all organization activities");
        context().LOG().LogInfo( "Departments: created: " + President.getName() );
        mgr = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == 1423333);
        context().relate_R23_Department_is_managed_by_Employee( President, mgr );
        context().relate_R21_Employee_working_within_Department( mgr, President );
        context().Authenticate().AddToGroup( mgr.getEmployeeID(), "Managers" );
        emp = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == 1430000);
        context().relate_R21_Employee_working_within_Department( emp, vpServices );
        context().relate_R22_Department_is_part_of_Department( President, vpServices );
        context().LOG().LogInfo( ( ( "Departments: related: " + vpServices.getName() ) + " to " ) + President.getName() );
    }

    public void CreatePEI_Employees() throws XtumlException {
        Employee emp = EmployeeImpl.create( context() );
        emp.setEmployeeID(1420000);
        emp.setNationalID(1041000000);
        emp.setFirstName("Khalid");
        emp.setMiddleName("Abdulaziz");
        emp.setLastName("Alrajeh");
        emp.setDateOfBirth(19691034);
        emp.setDegree("Mcs");
        emp.setGender("Male");
        Job job = context().Job_instances().anyWhere(selected -> ((Job)selected).getJob_ID() == 1);
        context().relate_R6_Employee_currently_occupies_Job( emp, job );
        emp.commenceEmployee( emp.getNationalID() );
        context().Authenticate().CreateNewAccount( emp.getFirstName(), emp.getLastName(), emp.getEmployeeID() );
        context().LOG().LogInfo( ( ( ( "Employee: Added " + emp.getFirstName() ) + " " ) + emp.getLastName() ) + " successfully." );
        emp = EmployeeImpl.create( context() );
        emp.setEmployeeID(1421111);
        emp.setNationalID(1041000001);
        emp.setFirstName("Saad");
        emp.setMiddleName("Abdullah");
        emp.setLastName("Alassaf");
        emp.setDateOfBirth(19691034);
        emp.setDegree("Mcs");
        emp.setGender("Male");
        job = context().Job_instances().anyWhere(selected -> ((Job)selected).getJob_ID() == 2);
        context().relate_R6_Employee_currently_occupies_Job( emp, job );
        emp.commenceEmployee( emp.getNationalID() );
        context().Authenticate().CreateNewAccount( emp.getFirstName(), emp.getLastName(), emp.getEmployeeID() );
        context().LOG().LogInfo( ( ( ( "Employee: Added " + emp.getFirstName() ) + " " ) + emp.getLastName() ) + " successfully." );
        emp = EmployeeImpl.create( context() );
        emp.setEmployeeID(1422222);
        emp.setNationalID(1041000002);
        emp.setFirstName("Saud");
        emp.setMiddleName("Abdullah");
        emp.setLastName("Almanea");
        emp.setDateOfBirth(19691034);
        emp.setDegree("Mcs");
        emp.setGender("Male");
        job = context().Job_instances().anyWhere(selected -> ((Job)selected).getJob_ID() == 3);
        context().relate_R6_Employee_currently_occupies_Job( emp, job );
        emp.commenceEmployee( emp.getNationalID() );
        context().Authenticate().CreateNewAccount( emp.getFirstName(), emp.getLastName(), emp.getEmployeeID() );
        context().LOG().LogInfo( ( ( ( "Employee: Added " + emp.getFirstName() ) + " " ) + emp.getLastName() ) + " successfully." );
        emp = EmployeeImpl.create( context() );
        emp.setEmployeeID(1423333);
        emp.setNationalID(1041000003);
        emp.setFirstName("Khalid");
        emp.setMiddleName("Abdulaziz");
        emp.setLastName("Alfaleh");
        emp.setDateOfBirth(19691034);
        emp.setDegree("Mcs");
        emp.setGender("Male");
        job = context().Job_instances().anyWhere(selected -> ((Job)selected).getJob_ID() == 4);
        context().relate_R6_Employee_currently_occupies_Job( emp, job );
        emp.commenceEmployee( emp.getNationalID() );
        context().Authenticate().CreateNewAccount( emp.getFirstName(), emp.getLastName(), emp.getEmployeeID() );
        context().LOG().LogInfo( ( ( ( "Employee: Added " + emp.getFirstName() ) + " " ) + emp.getLastName() ) + " successfully." );
        emp = EmployeeImpl.create( context() );
        emp.setEmployeeID(1424444);
        emp.setNationalID(1041000004);
        emp.setFirstName("Saud");
        emp.setMiddleName("Abdullah");
        emp.setLastName("Aba Alkhail");
        emp.setDateOfBirth(19781012);
        emp.setDegree("PhD");
        emp.setGender("Male");
        job = context().Job_instances().anyWhere(selected -> ((Job)selected).getJob_ID() == 5);
        context().relate_R6_Employee_currently_occupies_Job( emp, job );
        emp.commenceEmployee( emp.getNationalID() );
        context().Authenticate().CreateNewAccount( emp.getFirstName(), emp.getLastName(), emp.getEmployeeID() );
        context().LOG().LogInfo( ( ( ( "Employee: Added " + emp.getFirstName() ) + " " ) + emp.getLastName() ) + " successfully." );
        emp = EmployeeImpl.create( context() );
        emp.setEmployeeID(1425555);
        emp.setNationalID(1041000005);
        emp.setFirstName("Saleh");
        emp.setMiddleName("Fahad");
        emp.setLastName("Alotaibi");
        emp.setDateOfBirth(19811034);
        emp.setDegree("Bsc");
        emp.setGender("Male");
        job = context().Job_instances().anyWhere(selected -> ((Job)selected).getJob_ID() == 6);
        context().relate_R6_Employee_currently_occupies_Job( emp, job );
        emp.commenceEmployee( emp.getNationalID() );
        context().Authenticate().CreateNewAccount( emp.getFirstName(), emp.getLastName(), emp.getEmployeeID() );
        context().LOG().LogInfo( ( ( ( "Employee: Added " + emp.getFirstName() ) + " " ) + emp.getLastName() ) + " successfully." );
        emp = EmployeeImpl.create( context() );
        emp.setEmployeeID(1426666);
        emp.setNationalID(1041000006);
        emp.setFirstName("Riyadh");
        emp.setMiddleName("Fahad");
        emp.setLastName("Almutairi");
        emp.setDateOfBirth(19821034);
        emp.setDegree("Bsc");
        emp.setGender("Male");
        job = context().Job_instances().anyWhere(selected -> ((Job)selected).getJob_ID() == 7);
        context().relate_R6_Employee_currently_occupies_Job( emp, job );
        emp.commenceEmployee( emp.getNationalID() );
        context().Authenticate().CreateNewAccount( emp.getFirstName(), emp.getLastName(), emp.getEmployeeID() );
        context().LOG().LogInfo( ( ( ( "Employee: Added " + emp.getFirstName() ) + " " ) + emp.getLastName() ) + " successfully." );
        emp = EmployeeImpl.create( context() );
        emp.setEmployeeID(1427777);
        emp.setNationalID(1041000007);
        emp.setFirstName("Raed");
        emp.setMiddleName("Saad");
        emp.setLastName("Alshareef");
        emp.setDateOfBirth(19831034);
        emp.setDegree("Bsc");
        emp.setGender("Male");
        job = context().Job_instances().anyWhere(selected -> ((Job)selected).getJob_ID() == 8);
        context().relate_R6_Employee_currently_occupies_Job( emp, job );
        emp.commenceEmployee( emp.getNationalID() );
        context().Authenticate().CreateNewAccount( emp.getFirstName(), emp.getLastName(), emp.getEmployeeID() );
        context().LOG().LogInfo( ( ( ( "Employee: Added " + emp.getFirstName() ) + " " ) + emp.getLastName() ) + " successfully." );
        emp = EmployeeImpl.create( context() );
        emp.setEmployeeID(1428888);
        emp.setNationalID(1041000008);
        emp.setFirstName("Shaleh");
        emp.setMiddleName("Gaed");
        emp.setLastName("Alotaibi");
        emp.setDateOfBirth(19841034);
        emp.setDegree("Bsc");
        emp.setGender("Male");
        job = context().Job_instances().anyWhere(selected -> ((Job)selected).getJob_ID() == 9);
        context().relate_R6_Employee_currently_occupies_Job( emp, job );
        emp.commenceEmployee( emp.getNationalID() );
        context().Authenticate().CreateNewAccount( emp.getFirstName(), emp.getLastName(), emp.getEmployeeID() );
        context().LOG().LogInfo( ( ( ( "Employee: Added " + emp.getFirstName() ) + " " ) + emp.getLastName() ) + " successfully." );
        emp = EmployeeImpl.create( context() );
        emp.setEmployeeID(1429999);
        emp.setNationalID(1041000009);
        emp.setFirstName("Sarah");
        emp.setMiddleName("Abdullah");
        emp.setLastName("Alameer");
        emp.setDateOfBirth(19861034);
        emp.setDegree("Bsc");
        emp.setGender("Female");
        job = context().Job_instances().anyWhere(selected -> ((Job)selected).getJob_ID() == 10);
        context().relate_R6_Employee_currently_occupies_Job( emp, job );
        emp.commenceEmployee( emp.getNationalID() );
        context().Authenticate().CreateNewAccount( emp.getFirstName(), emp.getLastName(), emp.getEmployeeID() );
        context().LOG().LogInfo( ( ( ( "Employee: Added " + emp.getFirstName() ) + " " ) + emp.getLastName() ) + " successfully." );
        emp = EmployeeImpl.create( context() );
        emp.setEmployeeID(1430000);
        emp.setNationalID(1041000010);
        emp.setFirstName("Ahmad");
        emp.setMiddleName("Ziyad");
        emp.setLastName("Alshaikh");
        emp.setDateOfBirth(20200318);
        emp.setDegree("Bsc");
        emp.setGender("Male");
        job = context().Job_instances().anyWhere(selected -> ((Job)selected).getJob_ID() == 11);
        context().relate_R6_Employee_currently_occupies_Job( emp, job );
        emp.commenceEmployee( emp.getNationalID() );
        context().Authenticate().CreateNewAccount( emp.getFirstName(), emp.getLastName(), emp.getEmployeeID() );
        context().LOG().LogInfo( ( ( ( "Employee: Added " + emp.getFirstName() ) + " " ) + emp.getLastName() ) + " successfully." );
    }

    public void CreatePEI_Leave() throws XtumlException {
        LeaveSpecification leaveSpecification = LeaveSpecificationImpl.create( context() );
        leaveSpecification.setName("Regular Leave");
        leaveSpecification.setMaximumDays(105);
        leaveSpecification.setMinimumDays(5);
        context().LOG().LogInfo( ( "Leave: Added " + leaveSpecification.getName() ) + " successfully." );
        leaveSpecification = LeaveSpecificationImpl.create( context() );
        leaveSpecification.setName("Sick Leave");
        leaveSpecification.setMaximumDays(5);
        leaveSpecification.setMinimumDays(1);
        context().LOG().LogInfo( ( "Leave: Added " + leaveSpecification.getName() ) + " successfully." );
        leaveSpecification = LeaveSpecificationImpl.create( context() );
        leaveSpecification.setName("Exceptional Leave");
        leaveSpecification.setMaximumDays(365);
        leaveSpecification.setMinimumDays(180);
        context().LOG().LogInfo( ( "Leave: Added " + leaveSpecification.getName() ) + " successfully." );
    }

    public void CreatePEI_Scale() throws XtumlException {
        Scale scale = ScaleImpl.create( context() );
        scale.setName("General Schedule");
        scale.setDescription("The general scale of the organization");
        context().LOG().LogInfo( ( "Scale: Added " + scale.getName() ) + " successfully." );
        Grade grade = GradeImpl.create( context() );
        grade.setName("1");
        grade.setNumberOfSteps(15);
        grade.setBaseSalary(3000);
        grade.setAllowance(135);
        context().relate_R12_Grade_is_part_of_Scale( grade, scale );
        context().LOG().LogInfo( ( "Grade: Added " + grade.getName() ) + " successfully." );
        Grade grade2 = GradeImpl.create( context() );
        grade2.setName("2");
        grade2.setNumberOfSteps(15);
        grade2.setBaseSalary(3430);
        grade2.setAllowance(165);
        context().relate_R12_Grade_is_part_of_Scale( grade2, scale );
        context().relate_R14_Grade_follows_Grade( grade2, grade );
        context().LOG().LogInfo( ( "Grade: Added " + grade2.getName() ) + " successfully." );
        Grade grade3 = GradeImpl.create( context() );
        grade3.setName("3");
        grade3.setNumberOfSteps(15);
        grade3.setBaseSalary(3945);
        grade3.setAllowance(190);
        context().relate_R12_Grade_is_part_of_Scale( grade3, scale );
        context().relate_R14_Grade_follows_Grade( grade3, grade2 );
        context().LOG().LogInfo( ( "Grade: Added " + grade3.getName() ) + " successfully." );
        Grade grade4 = GradeImpl.create( context() );
        grade4.setName("4");
        grade4.setNumberOfSteps(15);
        grade4.setBaseSalary(4530);
        grade4.setAllowance(230);
        context().relate_R12_Grade_is_part_of_Scale( grade4, scale );
        context().relate_R14_Grade_follows_Grade( grade4, grade3 );
        context().LOG().LogInfo( ( "Grade: Added " + grade4.getName() ) + " successfully." );
        Grade grade5 = GradeImpl.create( context() );
        grade5.setName("5");
        grade5.setNumberOfSteps(15);
        grade5.setBaseSalary(5240);
        grade5.setAllowance(265);
        context().relate_R12_Grade_is_part_of_Scale( grade5, scale );
        context().relate_R14_Grade_follows_Grade( grade5, grade4 );
        context().LOG().LogInfo( ( "Grade: Added " + grade5.getName() ) + " successfully." );
        Grade grade6 = GradeImpl.create( context() );
        grade6.setName("6");
        grade6.setNumberOfSteps(15);
        grade6.setBaseSalary(6065);
        grade6.setAllowance(305);
        context().relate_R12_Grade_is_part_of_Scale( grade6, scale );
        context().relate_R14_Grade_follows_Grade( grade6, grade5 );
        context().LOG().LogInfo( ( "Grade: Added " + grade6.getName() ) + " successfully." );
        Grade grade7 = GradeImpl.create( context() );
        grade7.setName("7");
        grade7.setNumberOfSteps(15);
        grade7.setBaseSalary(7010);
        grade7.setAllowance(365);
        context().relate_R12_Grade_is_part_of_Scale( grade7, scale );
        context().relate_R14_Grade_follows_Grade( grade7, grade6 );
        context().LOG().LogInfo( ( "Grade: Added " + grade7.getName() ) + " successfully." );
        Grade grade8 = GradeImpl.create( context() );
        grade8.setName("8");
        grade8.setNumberOfSteps(15);
        grade8.setBaseSalary(8010);
        grade8.setAllowance(415);
        context().relate_R12_Grade_is_part_of_Scale( grade8, scale );
        context().relate_R14_Grade_follows_Grade( grade8, grade7 );
        context().LOG().LogInfo( ( "Grade: Added " + grade8.getName() ) + " successfully." );
        Grade grade9 = GradeImpl.create( context() );
        grade9.setName("9");
        grade9.setNumberOfSteps(15);
        grade9.setBaseSalary(9275);
        grade9.setAllowance(470);
        context().relate_R12_Grade_is_part_of_Scale( grade9, scale );
        context().relate_R14_Grade_follows_Grade( grade9, grade8 );
        context().LOG().LogInfo( ( "Grade: Added " + grade9.getName() ) + " successfully." );
        Grade grade10 = GradeImpl.create( context() );
        grade10.setName("10");
        grade10.setNumberOfSteps(15);
        grade10.setBaseSalary(10275);
        grade10.setAllowance(510);
        context().relate_R12_Grade_is_part_of_Scale( grade10, scale );
        context().relate_R14_Grade_follows_Grade( grade10, grade9 );
        context().LOG().LogInfo( ( "Grade: Added " + grade10.getName() ) + " successfully." );
        Grade grade11 = GradeImpl.create( context() );
        grade11.setName("11");
        grade11.setNumberOfSteps(14);
        grade11.setBaseSalary(11815);
        grade11.setAllowance(530);
        context().relate_R12_Grade_is_part_of_Scale( grade11, scale );
        context().relate_R14_Grade_follows_Grade( grade11, grade10 );
        context().LOG().LogInfo( ( "Grade: Added " + grade11.getName() ) + " successfully." );
        Grade grade12 = GradeImpl.create( context() );
        grade12.setName("12");
        grade12.setNumberOfSteps(13);
        grade12.setBaseSalary(13435);
        grade12.setAllowance(570);
        context().relate_R12_Grade_is_part_of_Scale( grade12, scale );
        context().relate_R14_Grade_follows_Grade( grade12, grade11 );
        context().LOG().LogInfo( ( "Grade: Added " + grade12.getName() ) + " successfully." );
        Grade grade13 = GradeImpl.create( context() );
        grade13.setName("13");
        grade13.setNumberOfSteps(12);
        grade13.setBaseSalary(15180);
        grade13.setAllowance(605);
        context().relate_R12_Grade_is_part_of_Scale( grade13, scale );
        context().relate_R14_Grade_follows_Grade( grade13, grade12 );
        context().LOG().LogInfo( ( "Grade: Added " + grade13.getName() ) + " successfully." );
        Grade grade14 = GradeImpl.create( context() );
        grade14.setName("14");
        grade14.setNumberOfSteps(11);
        grade14.setBaseSalary(17015);
        grade14.setAllowance(700);
        context().relate_R12_Grade_is_part_of_Scale( grade14, scale );
        context().relate_R14_Grade_follows_Grade( grade14, grade13 );
        context().LOG().LogInfo( ( "Grade: Added " + grade14.getName() ) + " successfully." );
        Grade grade15 = GradeImpl.create( context() );
        grade15.setName("15");
        grade15.setNumberOfSteps(10);
        grade15.setBaseSalary(20855);
        grade15.setAllowance(865);
        context().relate_R12_Grade_is_part_of_Scale( grade15, scale );
        context().relate_R14_Grade_follows_Grade( grade15, grade14 );
        context().LOG().LogInfo( ( "Grade: Added " + grade15.getName() ) + " successfully." );
        Job job = JobImpl.create( context() );
        job.setJob_ID(1);
        job.setTitle("Front-End Junior Software Engineer ");
        job.setDescription("Developing front end solutions");
        job.setPensionDeduction(0.09);
        grade = context().Grade_instances().anyWhere(selected -> StringUtil.equality(((Grade)selected).getName(), "8"));
        context().relate_R9_Job_assigned_Grade( job, grade );
        context().LOG().LogInfo( ( " Job: Added " + job.getTitle() ) + " successfully." );
        job = JobImpl.create( context() );
        job.setJob_ID(2);
        job.setTitle("Back-End Junior Software Engineer ");
        job.setDescription("Developing back end solutions");
        job.setPensionDeduction(0.09);
        grade = context().Grade_instances().anyWhere(selected -> StringUtil.equality(((Grade)selected).getName(), "8"));
        context().relate_R9_Job_assigned_Grade( job, grade );
        context().LOG().LogInfo( ( " Job: Added " + job.getTitle() ) + " successfully." );
        job = JobImpl.create( context() );
        job.setJob_ID(3);
        job.setTitle("Senior Software Engineer ");
        job.setDescription("Manging front/back end solutions");
        job.setPensionDeduction(0.09);
        grade = context().Grade_instances().anyWhere(selected -> StringUtil.equality(((Grade)selected).getName(), "10"));
        context().relate_R9_Job_assigned_Grade( job, grade );
        context().LOG().LogInfo( ( " Job: Added " + job.getTitle() ) + " successfully." );
        job = JobImpl.create( context() );
        job.setJob_ID(4);
        job.setTitle("HR Specialist ");
        job.setDescription("Recruting and evaluting employee profiles");
        job.setPensionDeduction(0.09);
        grade = context().Grade_instances().anyWhere(selected -> StringUtil.equality(((Grade)selected).getName(), "9"));
        context().relate_R9_Job_assigned_Grade( job, grade );
        context().LOG().LogInfo( ( " Job: Added " + job.getTitle() ) + " successfully." );
        job = JobImpl.create( context() );
        job.setJob_ID(5);
        job.setTitle("Lead Software Engineer ");
        job.setDescription("Manging software teams solutions");
        job.setPensionDeduction(0.09);
        grade = context().Grade_instances().anyWhere(selected -> StringUtil.equality(((Grade)selected).getName(), "12"));
        context().relate_R9_Job_assigned_Grade( job, grade );
        context().LOG().LogInfo( ( " Job: Added " + job.getTitle() ) + " successfully." );
        job = JobImpl.create( context() );
        job.setJob_ID(6);
        job.setTitle("Finance Manager ");
        job.setDescription("Manging finance");
        job.setPensionDeduction(0.09);
        grade = context().Grade_instances().anyWhere(selected -> StringUtil.equality(((Grade)selected).getName(), "14"));
        context().relate_R9_Job_assigned_Grade( job, grade );
        context().LOG().LogInfo( ( " Job: Added " + job.getTitle() ) + " successfully." );
        job = JobImpl.create( context() );
        job.setJob_ID(7);
        job.setTitle("Payroll Manager ");
        job.setDescription("Manging payroll");
        job.setPensionDeduction(0.09);
        grade = context().Grade_instances().anyWhere(selected -> StringUtil.equality(((Grade)selected).getName(), "10"));
        context().relate_R9_Job_assigned_Grade( job, grade );
        context().LOG().LogInfo( ( " Job: Added " + job.getTitle() ) + " successfully." );
        job = JobImpl.create( context() );
        job.setJob_ID(8);
        job.setTitle("Budget Manager ");
        job.setDescription("Manging budget");
        job.setPensionDeduction(0.09);
        grade = context().Grade_instances().anyWhere(selected -> StringUtil.equality(((Grade)selected).getName(), "10"));
        context().relate_R9_Job_assigned_Grade( job, grade );
        context().LOG().LogInfo( ( " Job: Added " + job.getTitle() ) + " successfully." );
        job = JobImpl.create( context() );
        job.setJob_ID(9);
        job.setTitle("President ");
        job.setDescription("Manges the organization");
        job.setPensionDeduction(0.09);
        grade = context().Grade_instances().anyWhere(selected -> StringUtil.equality(((Grade)selected).getName(), "15"));
        context().relate_R9_Job_assigned_Grade( job, grade );
        context().LOG().LogInfo( ( " Job: Added " + job.getTitle() ) + " successfully." );
        job = JobImpl.create( context() );
        job.setJob_ID(10);
        job.setTitle("HR Expert ");
        job.setDescription("Analyze HR Data");
        job.setPensionDeduction(0.09);
        grade = context().Grade_instances().anyWhere(selected -> StringUtil.equality(((Grade)selected).getName(), "9"));
        context().relate_R9_Job_assigned_Grade( job, grade );
        context().LOG().LogInfo( ( " Job: Added " + job.getTitle() ) + " successfully." );
        job = JobImpl.create( context() );
        job.setJob_ID(11);
        job.setTitle("HR Specilast ");
        job.setDescription("Works at HR");
        job.setPensionDeduction(0.09);
        grade = context().Grade_instances().anyWhere(selected -> StringUtil.equality(((Grade)selected).getName(), "8"));
        context().relate_R9_Job_assigned_Grade( job, grade );
        context().LOG().LogInfo( ( " Job: Added " + job.getTitle() ) + " successfully." );
        job = JobImpl.create( context() );
        job.setJob_ID(12);
        job.setTitle("HR Specilast ");
        job.setDescription("Works at HR");
        job.setPensionDeduction(0.09);
        grade = context().Grade_instances().anyWhere(selected -> StringUtil.equality(((Grade)selected).getName(), "8"));
        context().relate_R9_Job_assigned_Grade( job, grade );
        context().LOG().LogInfo( ( " Job: Added " + job.getTitle() ) + " successfully." );
        job = JobImpl.create( context() );
        job.setJob_ID(13);
        job.setTitle("HR Specilast ");
        job.setDescription("Works at HR");
        job.setPensionDeduction(0.09);
        grade = context().Grade_instances().anyWhere(selected -> StringUtil.equality(((Grade)selected).getName(), "8"));
        context().relate_R9_Job_assigned_Grade( job, grade );
        context().LOG().LogInfo( ( " Job: Added " + job.getTitle() ) + " successfully." );
        job = JobImpl.create( context() );
        job.setJob_ID(14);
        job.setTitle("HR Specilast ");
        job.setDescription("Works at HR");
        job.setPensionDeduction(0.09);
        grade = context().Grade_instances().anyWhere(selected -> StringUtil.equality(((Grade)selected).getName(), "8"));
        context().relate_R9_Job_assigned_Grade( job, grade );
        context().LOG().LogInfo( ( " Job: Added " + job.getTitle() ) + " successfully." );
        job = JobImpl.create( context() );
        job.setJob_ID(15);
        job.setTitle("Finance Specilast ");
        job.setDescription("Works at Finance");
        job.setPensionDeduction(0.09);
        grade = context().Grade_instances().anyWhere(selected -> StringUtil.equality(((Grade)selected).getName(), "8"));
        context().relate_R9_Job_assigned_Grade( job, grade );
        context().LOG().LogInfo( ( " Job: Added " + job.getTitle() ) + " successfully." );
        job = JobImpl.create( context() );
        job.setJob_ID(16);
        job.setTitle("Finance Specilast ");
        job.setDescription("Works at Finance");
        job.setPensionDeduction(0.09);
        grade = context().Grade_instances().anyWhere(selected -> StringUtil.equality(((Grade)selected).getName(), "8"));
        context().relate_R9_Job_assigned_Grade( job, grade );
        context().LOG().LogInfo( ( " Job: Added " + job.getTitle() ) + " successfully." );
    }

    public void Initialize() throws XtumlException {
        context().CreatePEI_Leave();
        context().CreatePEI_Scale();
        context().CreatePEI_Employees();
        context().CreatePEI_Departments();
        context().CreatePEI_Bonus();
    }

    public double paymentRatio( final int p_Starting,  final int p_Ending ) throws XtumlException {
        int month = ( ( 30 * 24 ) * 60 ) * 60;
        int currentDate = context().TIM().current_seconds();
        int timeToStart = p_Starting - currentDate;
        int timeToEnd = p_Ending - currentDate;
        if ( p_Starting >= currentDate ) {
            return 0;
        }
        else if ( ( ( p_Starting < currentDate && currentDate - p_Starting > month ) && p_Ending > currentDate ) && p_Ending - currentDate > month ) {
            return 1;
        }
        else if ( ( ( p_Starting < currentDate && currentDate - p_Starting < month ) && p_Ending > currentDate ) && p_Ending - currentDate > month ) {
            return ( currentDate - p_Starting ) / month;
        }
        return 0;
    }

    public void testPaymentRatio() throws XtumlException {
        int week = ( ( 7 * 24 ) * 60 ) * 60;
        int month = 4 * week;
        int time = context().TIM().current_seconds();
        context().LOG().LogInfo( "start passed more than a month ago and end is a month or more away " );
        int starting = time - week * 8;
        int ending = time + week * 52;
        context().LOG().LogInfo( "start is a month or more away " );
        starting = time + 5 * week;
        ending = time + week * 52;
        context().LOG().LogInfo( "start is less than a month away " );
        starting = time + week * 2;
        ending = time + week * 52;
        context().LOG().LogInfo( "start passed by less than a month " );
        starting = time - week * 2;
        ending = time + week * 52;
        double result = context().paymentRatio( starting, ending );
        context().LOG().LogReal( "result ", result );
        int period = 2 / 3;
        context().LOG().LogReal( "test calculation", period );
        context().LOG().LogInfo( "ending is a month or more away " );
        starting = time - week * 52;
        ending = time + week * 5;
        context().LOG().LogInfo( "ending is less than a month away " );
        starting = time - week * 52;
        ending = time + week * 2;
        context().LOG().LogInfo( "ending passed by less than a month " );
        starting = time - week * 52;
        ending = time - week * 2;
        context().LOG().LogInfo( "ending passed by more than a month " );
        starting = time - week * 52;
        ending = time - week * 5;
    }



    // relates and unrelates
    public void relate_R102_ApproveLeave_notifies_Employee( ApproveLeave form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R102_ApproveLeave_notifies_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR102_is_notified_by_ApproveLeave(form);
            form.setR102_notifies_Employee(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R102_ApproveLeave_notifies_Employee( ApproveLeave form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R102_ApproveLeave_notifies_Employee_extent.remove( R102_ApproveLeave_notifies_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR102_is_notified_by_ApproveLeave(form);
            form.setR102_notifies_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R11_Leave_consumed_by_Employee( Leave form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R11_Leave_consumed_by_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR11_consumed_Leave(form);
            form.setR11_consumed_by_Employee(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R11_Leave_consumed_by_Employee( Leave form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R11_Leave_consumed_by_Employee_extent.remove( R11_Leave_consumed_by_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR11_consumed_Leave(form);
            form.setR11_consumed_by_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R12_Grade_is_part_of_Scale( Grade form, Scale part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R12_Grade_is_part_of_Scale_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR12_is_made_of_Grade(form);
            form.setR12_is_part_of_Scale(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R12_Grade_is_part_of_Scale( Grade form, Scale part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R12_Grade_is_part_of_Scale_extent.remove( R12_Grade_is_part_of_Scale_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR12_is_made_of_Grade(form);
            form.setR12_is_part_of_Scale(ScaleImpl.EMPTY_SCALE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R14_Grade_follows_Grade( Grade form, Grade part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R14_Grade_follows_Grade_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR14_succeed_Grade(form);
            form.setR14_follows_Grade(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R14_Grade_follows_Grade( Grade form, Grade part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R14_Grade_follows_Grade_extent.remove( R14_Grade_follows_Grade_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR14_succeed_Grade(GradeImpl.EMPTY_GRADE);
            form.setR14_follows_Grade(GradeImpl.EMPTY_GRADE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R15_Leave_is_specified_by_a_LeaveSpecification( Leave form, LeaveSpecification part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R15_Leave_is_specified_by_a_LeaveSpecification_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR15_specifies_Leave(form);
            form.setR15_is_specified_by_a_LeaveSpecification(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R15_Leave_is_specified_by_a_LeaveSpecification( Leave form, LeaveSpecification part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R15_Leave_is_specified_by_a_LeaveSpecification_extent.remove( R15_Leave_is_specified_by_a_LeaveSpecification_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR15_specifies_Leave(form);
            form.setR15_is_specified_by_a_LeaveSpecification(LeaveSpecificationImpl.EMPTY_LEAVESPECIFICATION);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R16_Bonus_is_specified_by_BonusSpecification( Bonus form, BonusSpecification part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R16_Bonus_is_specified_by_BonusSpecification_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR16_specifies_Bonus(form);
            form.setR16_is_specified_by_BonusSpecification(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R16_Bonus_is_specified_by_BonusSpecification( Bonus form, BonusSpecification part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R16_Bonus_is_specified_by_BonusSpecification_extent.remove( R16_Bonus_is_specified_by_BonusSpecification_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR16_specifies_Bonus(form);
            form.setR16_is_specified_by_BonusSpecification(BonusSpecificationImpl.EMPTY_BONUSSPECIFICATION);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R17_JobRecord_proceeded_by_JobRecord( JobRecord form, JobRecord part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R17_JobRecord_proceeded_by_JobRecord_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR17_preceded_by_JobRecord(form);
            form.setR17_proceeded_by_JobRecord(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R17_JobRecord_proceeded_by_JobRecord( JobRecord form, JobRecord part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R17_JobRecord_proceeded_by_JobRecord_extent.remove( R17_JobRecord_proceeded_by_JobRecord_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR17_preceded_by_JobRecord(JobRecordImpl.EMPTY_JOBRECORD);
            form.setR17_proceeded_by_JobRecord(JobRecordImpl.EMPTY_JOBRECORD);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R18_PayslipItem_listed_after_PayslipItem( PayslipItem form, PayslipItem part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R18_PayslipItem_listed_after_PayslipItem_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR18_listed_before_PayslipItem(form);
            form.addR18_listed_after_PayslipItem(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R18_PayslipItem_listed_after_PayslipItem( PayslipItem form, PayslipItem part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R18_PayslipItem_listed_after_PayslipItem_extent.remove( R18_PayslipItem_listed_after_PayslipItem_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR18_listed_before_PayslipItem(form);
            form.removeR18_listed_after_PayslipItem(part);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R19_Bonus_given_in_the_past_Employee( Bonus form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R19_Bonus_given_in_the_past_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR19_was_given_Bonus(form);
            form.setR19_given_in_the_past_Employee(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R19_Bonus_given_in_the_past_Employee( Bonus form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R19_Bonus_given_in_the_past_Employee_extent.remove( R19_Bonus_given_in_the_past_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR19_was_given_Bonus(form);
            form.setR19_given_in_the_past_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R1_JobRecord_occupied_Job( JobRecord form, Job part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R1_JobRecord_occupied_Job_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR1_was_assigned_to_JobRecord(form);
            form.setR1_occupied_Job(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R1_JobRecord_occupied_Job( JobRecord form, Job part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R1_JobRecord_occupied_Job_extent.remove( R1_JobRecord_occupied_Job_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR1_was_assigned_to_JobRecord(form);
            form.setR1_occupied_Job(JobImpl.EMPTY_JOB);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R1_JobRecord_was_assigned_to_Employee( JobRecord form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R1_JobRecord_was_assigned_to_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR1_occupied_JobRecord(form);
            form.setR1_was_assigned_to_Employee(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R1_JobRecord_was_assigned_to_Employee( JobRecord form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R1_JobRecord_was_assigned_to_Employee_extent.remove( R1_JobRecord_was_assigned_to_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR1_occupied_JobRecord(form);
            form.setR1_was_assigned_to_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R20_Employee_to_be_promoted_to_Job( Employee form, Job part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R20_Employee_to_be_promoted_to_Job_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR20_to_be_assigned_to_Employee(form);
            form.setR20_to_be_promoted_to_Job(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R20_Employee_to_be_promoted_to_Job( Employee form, Job part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R20_Employee_to_be_promoted_to_Job_extent.remove( R20_Employee_to_be_promoted_to_Job_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR20_to_be_assigned_to_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
            form.setR20_to_be_promoted_to_Job(JobImpl.EMPTY_JOB);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R21_Employee_working_within_Department( Employee form, Department part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R21_Employee_working_within_Department_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR21_holds_Employee(form);
            form.setR21_working_within_Department(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R21_Employee_working_within_Department( Employee form, Department part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R21_Employee_working_within_Department_extent.remove( R21_Employee_working_within_Department_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR21_holds_Employee(form);
            form.setR21_working_within_Department(DepartmentImpl.EMPTY_DEPARTMENT);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R22_Department_is_part_of_Department( Department form, Department part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R22_Department_is_part_of_Department_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR22_is_divided_into_Department(form);
            form.setR22_is_part_of_Department(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R22_Department_is_part_of_Department( Department form, Department part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R22_Department_is_part_of_Department_extent.remove( R22_Department_is_part_of_Department_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR22_is_divided_into_Department(form);
            form.setR22_is_part_of_Department(DepartmentImpl.EMPTY_DEPARTMENT);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R23_Department_is_managed_by_Employee( Department form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R23_Department_is_managed_by_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR23_manages_Department(form);
            form.setR23_is_managed_by_Employee(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R23_Department_is_managed_by_Employee( Department form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R23_Department_is_managed_by_Employee_extent.remove( R23_Department_is_managed_by_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR23_manages_Department(form);
            form.setR23_is_managed_by_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R3_PayslipItem_records_an_earning_or_deduction_to_Employee( PayslipItem form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R3_PayslipItem_records_an_earning_or_deduction_to_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem(form);
            form.setR3_records_an_earning_or_deduction_to_Employee(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R3_PayslipItem_records_an_earning_or_deduction_to_Employee( PayslipItem form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R3_PayslipItem_records_an_earning_or_deduction_to_Employee_extent.remove( R3_PayslipItem_records_an_earning_or_deduction_to_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem(form);
            form.setR3_records_an_earning_or_deduction_to_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R4_Bonus_is_given_to_an_Employee( Bonus form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R4_Bonus_is_given_to_an_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR4_gets_a_Bonus(form);
            form.setR4_is_given_to_an_Employee(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R4_Bonus_is_given_to_an_Employee( Bonus form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R4_Bonus_is_given_to_an_Employee_extent.remove( R4_Bonus_is_given_to_an_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR4_gets_a_Bonus(form);
            form.setR4_is_given_to_an_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R5_Employee_is_taking_a_Leave( Employee form, Leave part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R5_Employee_is_taking_a_Leave_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR5_is_currently_taken_by_Employee(form);
            form.setR5_is_taking_a_Leave(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R5_Employee_is_taking_a_Leave( Employee form, Leave part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R5_Employee_is_taking_a_Leave_extent.remove( R5_Employee_is_taking_a_Leave_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR5_is_currently_taken_by_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
            form.setR5_is_taking_a_Leave(LeaveImpl.EMPTY_LEAVE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R6_Employee_currently_occupies_Job( Employee form, Job part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R6_Employee_currently_occupies_Job_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR6_is_assigned_to_Employee(form);
            form.setR6_currently_occupies_Job(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R6_Employee_currently_occupies_Job( Employee form, Job part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R6_Employee_currently_occupies_Job_extent.remove( R6_Employee_currently_occupies_Job_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR6_is_assigned_to_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
            form.setR6_currently_occupies_Job(JobImpl.EMPTY_JOB);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R7_Leave_to_be_taken_by_Employee( Leave form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R7_Leave_to_be_taken_by_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR7_is_planning_to_take__Leave(form);
            form.setR7_to_be_taken_by_Employee(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R7_Leave_to_be_taken_by_Employee( Leave form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R7_Leave_to_be_taken_by_Employee_extent.remove( R7_Leave_to_be_taken_by_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR7_is_planning_to_take__Leave(LeaveImpl.EMPTY_LEAVE);
            form.setR7_to_be_taken_by_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R9_Job_assigned_Grade( Job form, Grade part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R9_Job_assigned_Grade_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR9_assigned_Job(form);
            form.setR9_assigned_Grade(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R9_Job_assigned_Grade( Job form, Grade part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R9_Job_assigned_Grade_extent.remove( R9_Job_assigned_Grade_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR9_assigned_Job(form);
            form.setR9_assigned_Grade(GradeImpl.EMPTY_GRADE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }


    // instance selections
    private ApproveLeaveSet ApproveLeave_extent;
    public ApproveLeaveSet ApproveLeave_instances() {
        return ApproveLeave_extent;
    }
    private BonusSpecificationSet BonusSpecification_extent;
    public BonusSpecificationSet BonusSpecification_instances() {
        return BonusSpecification_extent;
    }
    private BonusSet Bonus_extent;
    public BonusSet Bonus_instances() {
        return Bonus_extent;
    }
    private DepartmentSet Department_extent;
    public DepartmentSet Department_instances() {
        return Department_extent;
    }
    private EmployeeSet Employee_extent;
    public EmployeeSet Employee_instances() {
        return Employee_extent;
    }
    private GradeSet Grade_extent;
    public GradeSet Grade_instances() {
        return Grade_extent;
    }
    private JobRecordSet JobRecord_extent;
    public JobRecordSet JobRecord_instances() {
        return JobRecord_extent;
    }
    private JobSet Job_extent;
    public JobSet Job_instances() {
        return Job_extent;
    }
    private LeaveSpecificationSet LeaveSpecification_extent;
    public LeaveSpecificationSet LeaveSpecification_instances() {
        return LeaveSpecification_extent;
    }
    private LeaveSet Leave_extent;
    public LeaveSet Leave_instances() {
        return Leave_extent;
    }
    private PayslipItemSet PayslipItem_extent;
    public PayslipItemSet PayslipItem_instances() {
        return PayslipItem_extent;
    }
    private ScaleSet Scale_extent;
    public ScaleSet Scale_instances() {
        return Scale_extent;
    }


    // relationship selections
    private IRelationshipSet R102_ApproveLeave_notifies_Employee_extent;
    public IRelationshipSet R102_ApproveLeave_notifies_Employees() throws XtumlException {
        return R102_ApproveLeave_notifies_Employee_extent;
    }
    private IRelationshipSet R11_Leave_consumed_by_Employee_extent;
    public IRelationshipSet R11_Leave_consumed_by_Employees() throws XtumlException {
        return R11_Leave_consumed_by_Employee_extent;
    }
    private IRelationshipSet R12_Grade_is_part_of_Scale_extent;
    public IRelationshipSet R12_Grade_is_part_of_Scales() throws XtumlException {
        return R12_Grade_is_part_of_Scale_extent;
    }
    private IRelationshipSet R14_Grade_follows_Grade_extent;
    public IRelationshipSet R14_Grade_follows_Grades() throws XtumlException {
        return R14_Grade_follows_Grade_extent;
    }
    private IRelationshipSet R15_Leave_is_specified_by_a_LeaveSpecification_extent;
    public IRelationshipSet R15_Leave_is_specified_by_a_LeaveSpecifications() throws XtumlException {
        return R15_Leave_is_specified_by_a_LeaveSpecification_extent;
    }
    private IRelationshipSet R16_Bonus_is_specified_by_BonusSpecification_extent;
    public IRelationshipSet R16_Bonus_is_specified_by_BonusSpecifications() throws XtumlException {
        return R16_Bonus_is_specified_by_BonusSpecification_extent;
    }
    private IRelationshipSet R17_JobRecord_proceeded_by_JobRecord_extent;
    public IRelationshipSet R17_JobRecord_proceeded_by_JobRecords() throws XtumlException {
        return R17_JobRecord_proceeded_by_JobRecord_extent;
    }
    private IRelationshipSet R18_PayslipItem_listed_after_PayslipItem_extent;
    public IRelationshipSet R18_PayslipItem_listed_after_PayslipItems() throws XtumlException {
        return R18_PayslipItem_listed_after_PayslipItem_extent;
    }
    private IRelationshipSet R19_Bonus_given_in_the_past_Employee_extent;
    public IRelationshipSet R19_Bonus_given_in_the_past_Employees() throws XtumlException {
        return R19_Bonus_given_in_the_past_Employee_extent;
    }
    private IRelationshipSet R1_JobRecord_occupied_Job_extent;
    public IRelationshipSet R1_JobRecord_occupied_Jobs() throws XtumlException {
        return R1_JobRecord_occupied_Job_extent;
    }
    private IRelationshipSet R1_JobRecord_was_assigned_to_Employee_extent;
    public IRelationshipSet R1_JobRecord_was_assigned_to_Employees() throws XtumlException {
        return R1_JobRecord_was_assigned_to_Employee_extent;
    }
    private IRelationshipSet R20_Employee_to_be_promoted_to_Job_extent;
    public IRelationshipSet R20_Employee_to_be_promoted_to_Jobs() throws XtumlException {
        return R20_Employee_to_be_promoted_to_Job_extent;
    }
    private IRelationshipSet R21_Employee_working_within_Department_extent;
    public IRelationshipSet R21_Employee_working_within_Departments() throws XtumlException {
        return R21_Employee_working_within_Department_extent;
    }
    private IRelationshipSet R22_Department_is_part_of_Department_extent;
    public IRelationshipSet R22_Department_is_part_of_Departments() throws XtumlException {
        return R22_Department_is_part_of_Department_extent;
    }
    private IRelationshipSet R23_Department_is_managed_by_Employee_extent;
    public IRelationshipSet R23_Department_is_managed_by_Employees() throws XtumlException {
        return R23_Department_is_managed_by_Employee_extent;
    }
    private IRelationshipSet R3_PayslipItem_records_an_earning_or_deduction_to_Employee_extent;
    public IRelationshipSet R3_PayslipItem_records_an_earning_or_deduction_to_Employees() throws XtumlException {
        return R3_PayslipItem_records_an_earning_or_deduction_to_Employee_extent;
    }
    private IRelationshipSet R4_Bonus_is_given_to_an_Employee_extent;
    public IRelationshipSet R4_Bonus_is_given_to_an_Employees() throws XtumlException {
        return R4_Bonus_is_given_to_an_Employee_extent;
    }
    private IRelationshipSet R5_Employee_is_taking_a_Leave_extent;
    public IRelationshipSet R5_Employee_is_taking_a_Leaves() throws XtumlException {
        return R5_Employee_is_taking_a_Leave_extent;
    }
    private IRelationshipSet R6_Employee_currently_occupies_Job_extent;
    public IRelationshipSet R6_Employee_currently_occupies_Jobs() throws XtumlException {
        return R6_Employee_currently_occupies_Job_extent;
    }
    private IRelationshipSet R7_Leave_to_be_taken_by_Employee_extent;
    public IRelationshipSet R7_Leave_to_be_taken_by_Employees() throws XtumlException {
        return R7_Leave_to_be_taken_by_Employee_extent;
    }
    private IRelationshipSet R9_Job_assigned_Grade_extent;
    public IRelationshipSet R9_Job_assigned_Grades() throws XtumlException {
        return R9_Job_assigned_Grade_extent;
    }


    // ports
    private HrAuthenticate HrAuthenticate;
    public HrAuthenticate Authenticate() {
        if ( null == HrAuthenticate ) HrAuthenticate = new HrAuthenticate( this, null );
        return HrAuthenticate;
    }
    private HrUI HrUI;
    public HrUI UI() {
        if ( null == HrUI ) HrUI = new HrUI( this, null );
        return HrUI;
    }
    private HrUI_Ops HrUI_Ops;
    public HrUI_Ops UI_Ops() {
        if ( null == HrUI_Ops ) HrUI_Ops = new HrUI_Ops( this, null );
        return HrUI_Ops;
    }


    // utilities
    private TIM TIM;
    public TIM TIM() {
        if ( null == TIM ) TIM = new TIMImpl<>( this );
        return TIM;
    }
    private LOG LOG;
    public LOG LOG() {
        if ( null == LOG ) LOG = new LOGImpl<>( this );
        return LOG;
    }


    // component initialization function
    @Override
    public void initialize() throws XtumlException {

    }

    @Override
    public String getVersion() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("HrProperties.properties"));
        } catch (IOException e) { /* do nothing */ }
        return prop.getProperty("version", "Unknown");
    }
    @Override
    public String getVersionDate() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("HrProperties.properties"));
        } catch (IOException e) { /* do nothing */ }
        return prop.getProperty("version_date", "Unknown");
    }

    @Override
    public boolean addInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot add empty instance to population." );
        if ( instance instanceof ApproveLeave ) return ApproveLeave_extent.add( (ApproveLeave)instance );
        else if ( instance instanceof Bonus ) return Bonus_extent.add( (Bonus)instance );
        else if ( instance instanceof BonusSpecification ) return BonusSpecification_extent.add( (BonusSpecification)instance );
        else if ( instance instanceof Department ) return Department_extent.add( (Department)instance );
        else if ( instance instanceof Employee ) return Employee_extent.add( (Employee)instance );
        else if ( instance instanceof Grade ) return Grade_extent.add( (Grade)instance );
        else if ( instance instanceof Job ) return Job_extent.add( (Job)instance );
        else if ( instance instanceof JobRecord ) return JobRecord_extent.add( (JobRecord)instance );
        else if ( instance instanceof Leave ) return Leave_extent.add( (Leave)instance );
        else if ( instance instanceof LeaveSpecification ) return LeaveSpecification_extent.add( (LeaveSpecification)instance );
        else if ( instance instanceof PayslipItem ) return PayslipItem_extent.add( (PayslipItem)instance );
        else if ( instance instanceof Scale ) return Scale_extent.add( (Scale)instance );
        return false;
    }

    @Override
    public boolean removeInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot remove empty instance from population." );
        if ( instance instanceof ApproveLeave ) return ApproveLeave_extent.remove( (ApproveLeave)instance );
        else if ( instance instanceof Bonus ) return Bonus_extent.remove( (Bonus)instance );
        else if ( instance instanceof BonusSpecification ) return BonusSpecification_extent.remove( (BonusSpecification)instance );
        else if ( instance instanceof Department ) return Department_extent.remove( (Department)instance );
        else if ( instance instanceof Employee ) return Employee_extent.remove( (Employee)instance );
        else if ( instance instanceof Grade ) return Grade_extent.remove( (Grade)instance );
        else if ( instance instanceof Job ) return Job_extent.remove( (Job)instance );
        else if ( instance instanceof JobRecord ) return JobRecord_extent.remove( (JobRecord)instance );
        else if ( instance instanceof Leave ) return Leave_extent.remove( (Leave)instance );
        else if ( instance instanceof LeaveSpecification ) return LeaveSpecification_extent.remove( (LeaveSpecification)instance );
        else if ( instance instanceof PayslipItem ) return PayslipItem_extent.remove( (PayslipItem)instance );
        else if ( instance instanceof Scale ) return Scale_extent.remove( (Scale)instance );
        return false;
    }

    @Override
    public Hr context() {
        return this;
    }

    @Override
    public Class<?> getClassByKeyLetters(String keyLetters) {
        return classDirectory.get(keyLetters);
    }

}
