package hrsystem;


import hrsystem.ui.UIApp;
import hrsystem.ui.UIAppOps;
import hrsystem.ui.UIAuthenticate;

import io.ciera.runtime.summit.application.IApplication;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.components.Component;
import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.EmptyInstanceException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.util.LOG;
import io.ciera.runtime.summit.util.impl.LOGImpl;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;


public class UI extends Component<UI> {

    private Map<String, Class<?>> classDirectory;

    public UI(IApplication app, IRunContext runContext, int populationId) {
        super(app, runContext, populationId);


        LOG = null;
        classDirectory = new TreeMap<>();

    }

    // domain functions
    public void CreateEmployee() throws XtumlException {
    }

    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
        context().LOG().LogInfo( "UI: Sending reply: " + p_msg );
    }

    public void ReplyUsernamePassword( final int p_EmployeeID,  final String p_Username,  final String p_msg,  final boolean p_state ) throws XtumlException {
        context().LOG().LogInfo( "UI: Sending reply to Username Password: " + p_msg );
    }

    public void SendEmployee( final int p_EmployeeID,  final int p_NationalID,  final String p_FirstName,  final String p_MiddleName,  final String p_LastName,  final int p_DateOfBirth,  final String p_Degree,  final String p_Gender,  final int p_StartDate,  final int p_LeaveBalance,  final int p_SickLeaveBalance,  final int p_Size ) throws XtumlException {
        context().LOG().LogInfo( ( ( "UI: Sending employee: " + p_FirstName ) + " " ) + p_LastName );
    }

    public void SendLeaveSpecification( final String p_Name,  final int p_MaximumDays,  final int p_MinimumDays,  final int p_Size ) throws XtumlException {
        context().LOG().LogInfo( "UI: Sending leave specification: " + p_Name );
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


    // utilities
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
