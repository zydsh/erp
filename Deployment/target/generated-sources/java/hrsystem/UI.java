package hrsystem;


import hrsystem.ui.UIApp;
import hrsystem.ui.UIAppOps;
import hrsystem.ui.UIAuthenticate;
import hrsystem.ui.UIProjects;

import io.ciera.runtime.summit.application.IApplication;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.components.Component;
import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.EmptyInstanceException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.util.LOG;
import io.ciera.runtime.summit.util.TIM;
import io.ciera.runtime.summit.util.impl.LOGImpl;
import io.ciera.runtime.summit.util.impl.TIMImpl;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;


public class UI extends Component<UI> {

    private Map<String, Class<?>> classDirectory;

    public UI(IApplication app, IRunContext runContext, int populationId) {
        super(app, runContext, populationId);


        LOG = null;
        TIM = null;
        classDirectory = new TreeMap<>();

    }

    // domain functions
    public void CreateEmployee() throws XtumlException {
    }

    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
        context().LOG().LogInfo( "UI: Sending reply: " + p_msg );
    }

    public void ReplyProject( final String p_msg,  final boolean p_state ) throws XtumlException {
        context().ReplyProject( p_msg, p_state );
    }

    public void ReplyUsernamePassword( final int p_EmployeeID,  final String p_Username,  final String p_msg,  final boolean p_state ) throws XtumlException {
        context().LOG().LogInfo( "UI: Sending reply to Username Password: " + p_msg );
    }

    public void SendBonusList( final String p_Name,  final double p_Percent ) throws XtumlException {
    }

    public void SendDepartmentList( final String p_Name,  final String p_Mission,  final String p_Description,  final String p_Manager,  final String p_ManagingDepartment ) throws XtumlException {
    }

    public void SendEmployee( final int p_EmployeeID,  final int p_NationalID,  final String p_FirstName,  final String p_MiddleName,  final String p_LastName,  final String p_Email,  final String p_OfficePhone,  final int p_DateOfBirth,  final String p_Degree,  final String p_Gender,  final int p_StartDate,  final int p_LeaveBalance,  final int p_SickLeaveBalance,  final double p_Salary ) throws XtumlException {
        context().LOG().LogInfo( ( ( "UI: Sending employee: " + p_FirstName ) + " " ) + p_LastName );
    }

    public void SendEmployeeBonuses( final String p_BonusName,  final int p_Starting,  final int p_Ending,  final double p_Percent,  final double p_Amount ) throws XtumlException {
    }

    public void SendEmployeeMessages( final int p_LeaveRequesterID,  final int p_Starting,  final int p_Ending,  final String p_Content ) throws XtumlException {
        context().LOG().LogInfo( "Sending employee messages: message content:" + p_Content );
    }

    public void SendEmployeePermissions( final String p_GroupName,  final String p_Description ) throws XtumlException {
    }

    public void SendGrades( final String p_Name,  final double p_BaseSalary,  final double p_Allowance,  final int p_NumberOfSteps,  final String p_Above,  final String p_Below ) throws XtumlException {
    }

    public void SendJobList( final int p_JobID,  final String p_Title,  final double p_Salary,  final String p_EmployeeName,  final int p_EmployeeID ) throws XtumlException {
    }

    public void SendLeaveSpecification( final String p_Name,  final int p_MaximumDays,  final int p_MinimumDays,  final int p_Size ) throws XtumlException {
        context().LOG().LogInfo( "UI: Sending leave specification: " + p_Name );
    }

    public void SendMilestones( final String p_Name,  final String p_FullCode,  final String p_Code,  final String p_Type,  final String p_SuccessCriteria,  final int p_CompletePlanned,  final int p_CompleteActual,  final boolean p_Complete,  final int p_Weight,  final int p_Percentage,  final String p_sdState,  final String p_sdDescription,  final String p_Notes,  final String p_IncompleteReasons ) throws XtumlException {
    }

    public void SendSalaryStructure( final double p_EmployeeSalary,  final String p_BonusName,  final double p_BonusAmount ) throws XtumlException {
    }

    public void SendScales( final String p_Name,  final String p_Description ) throws XtumlException {
    }

    public void SendStrategies( final String p_Number,  final String p_Name,  final String p_Description ) throws XtumlException {
    }

    public void approveLeaveRequest() throws XtumlException {
        context().LOG().LogInfo( "Test: Approving leave request ... " );
        context().AppOps().ApproveEmployeeLeave( 1428888 );
    }

    public void changePassword() throws XtumlException {
        context().Authenticate().ChangePassword( "Khalid.Alrajeh", "7(!d&KhalidAlrajeh", "7(!d&" );
        context().LOG().LogInfo( "Test: Change Password second test" );
        context().Authenticate().ChangePassword( "Khalid.Alrajeh", "7(!d&KhalidAlrajeh", "7(!d&" );
    }

    public void checkUsernamePassword() throws XtumlException {
        context().LOG().LogInfo( "Test: Check Username and Password first test: correct username and password" );
        context().Authenticate().CheckUsernamePassword( "Khalid.Alrajeh", "7(!d&KhalidAlrajeh" );
        context().LOG().LogInfo( "Test: Check Username and Password second test: wrong username and password" );
        context().Authenticate().CheckUsernamePassword( "Khalid", "7(" );
        context().LOG().LogInfo( "Test: Check Username and Password third test: wrong username and correct password" );
        context().Authenticate().CheckUsernamePassword( "Khalid", "7(!d&KhalidAlrajeh" );
        context().LOG().LogInfo( "Test: Check Username and Password forth test: correct username and wrong password" );
        context().Authenticate().CheckUsernamePassword( "Khalid.Alrajeh", "7(!d" );
    }

    public void leaveRequest() throws XtumlException {
        context().LOG().LogInfo( "Test: leave request with starting couple of days before ending" );
        int monthInSeconds = 2592000 * 1000000;
        int startingTime = context().TIM().current_seconds() + monthInSeconds;
        context().LOG().LogInfo( "Test: Starting leave at: " );
        context().LOG().LogInteger( startingTime );
        int endingTime = startingTime + monthInSeconds;
        context().LOG().LogInfo( "Test: Ending leave at: " );
        context().LOG().LogInteger( endingTime );
        context().AppOps().RequestEmployeeLeave( startingTime, endingTime, 1428888, "Regular Leave" );
    }

    public void sendEmployeeMessages() throws XtumlException {
        context().LOG().LogInfo( "Test: Employee messages .." );
        context().App().ReadEmployeeMessage( 1424444 );
    }

    public void testBonus() throws XtumlException {
        int ending = context().TIM().current_seconds() + ( ( ( 52 * 7 ) * 24 ) * 60 ) * 60;
        int employeeID = 1428888;
        context().LOG().LogInfo( "Test: Assignning bonuses..." );
        context().App().AssignEmployeeBonus( employeeID, "Scarcity", context().TIM().current_seconds(), ending );
        context().App().AssignEmployeeBonus( employeeID, "Computing", context().TIM().current_seconds(), ending );
        context().App().AssignEmployeeBonus( employeeID, "Research", context().TIM().current_seconds(), ending );
        context().LOG().LogInfo( "Test: Stopping one bonus..." );
        context().App().StopEmployeeBonus( employeeID, "Computing" );
        context().LOG().LogInfo( "Test: Get employee bonus list..." );
        context().App().ReadEmployeeBonuses( employeeID );
        context().LOG().LogInfo( "Test: Get bonus list registered..." );
        context().App().ReadBonusList();
    }

    public void testDepartmentList() throws XtumlException {
        context().App().ReadDepartmentList();
    }

    public void testEmployeePermissions() throws XtumlException {
        int Emp1 = 1420000;
        int Emp2 = 1421111;
        int Emp3 = 1424444;
        int Emp4 = 1428888;
        context().LOG().LogInfo( "Test: Reading Employee permissions... " );
        context().LOG().LogInfo( "Test: EmployeeID: " );
        context().LOG().LogInteger( Emp1 );
        context().Authenticate().ReadEmployeePermissions( Emp1 );
        context().LOG().LogInfo( "Test: EmployeeID: " );
        context().LOG().LogInteger( Emp2 );
        context().Authenticate().ReadEmployeePermissions( Emp2 );
        context().LOG().LogInfo( "Test: EmployeeID: " );
        context().LOG().LogInteger( Emp3 );
        context().Authenticate().ReadEmployeePermissions( Emp3 );
        context().LOG().LogInfo( "Test: EmployeeID: " );
        context().LOG().LogInteger( Emp4 );
        context().Authenticate().ReadEmployeePermissions( Emp4 );
    }

    public void testGetEmployee() throws XtumlException {
        context().App().GetEmployee( 1424444 );
    }

    public void testGradeList() throws XtumlException {
        context().App().ReadGrades( "General Schedule" );
    }

    public void testJobList() throws XtumlException {
        context().App().ReadJobList();
    }

    public void testReadEmployeeList() throws XtumlException {
        context().App().ReadEmployeeList();
    }

    public void testSalaryStructure() throws XtumlException {
        context().App().GetSalaryStructure( 1428888 );
    }

    public void testScaleList() throws XtumlException {
        context().App().ReadScales();
    }

    public void testSendStrategies() throws XtumlException {
        context().Projects().ReadStrategies();
    }



    // relates and unrelates


    // instance selections


    // relationship selections


    // ports
    private UIApp UIApp;
    public UIApp App() {
        if ( null == UIApp ) UIApp = new UIApp( this, null );
        return UIApp;
    }
    private UIAppOps UIAppOps;
    public UIAppOps AppOps() {
        if ( null == UIAppOps ) UIAppOps = new UIAppOps( this, null );
        return UIAppOps;
    }
    private UIAuthenticate UIAuthenticate;
    public UIAuthenticate Authenticate() {
        if ( null == UIAuthenticate ) UIAuthenticate = new UIAuthenticate( this, null );
        return UIAuthenticate;
    }
    private UIProjects UIProjects;
    public UIProjects Projects() {
        if ( null == UIProjects ) UIProjects = new UIProjects( this, null );
        return UIProjects;
    }


    // utilities
    private LOG LOG;
    public LOG LOG() {
        if ( null == LOG ) LOG = new LOGImpl<>( this );
        return LOG;
    }
    private TIM TIM;
    public TIM TIM() {
        if ( null == TIM ) TIM = new TIMImpl<>( this );
        return TIM;
    }


    // component initialization function
    @Override
    public void initialize() throws XtumlException {

    }

    @Override
    public String getVersion() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("UIProperties.properties"));
        } catch (IOException e) { /* do nothing */ }
        return prop.getProperty("version", "Unknown");
    }
    @Override
    public String getVersionDate() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("UIProperties.properties"));
        } catch (IOException e) { /* do nothing */ }
        return prop.getProperty("version_date", "Unknown");
    }

    @Override
    public boolean addInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot add empty instance to population." );

        return false;
    }

    @Override
    public boolean removeInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot remove empty instance from population." );

        return false;
    }

    @Override
    public UI context() {
        return this;
    }

    @Override
    public Class<?> getClassByKeyLetters(String keyLetters) {
        return classDirectory.get(keyLetters);
    }

}
