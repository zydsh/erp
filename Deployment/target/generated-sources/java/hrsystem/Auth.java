package hrsystem;


import hrsystem.auth.AuthHR;
import hrsystem.auth.AuthUI;
import hrsystem.auth.main.Account;
import hrsystem.auth.main.AccountSet;
import hrsystem.auth.main.Group;
import hrsystem.auth.main.GroupSet;
import hrsystem.auth.main.Permissions;
import hrsystem.auth.main.PermissionsSet;
import hrsystem.auth.main.impl.AccountImpl;
import hrsystem.auth.main.impl.AccountSetImpl;
import hrsystem.auth.main.impl.GroupImpl;
import hrsystem.auth.main.impl.GroupSetImpl;
import hrsystem.auth.main.impl.PermissionsImpl;
import hrsystem.auth.main.impl.PermissionsSetImpl;

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
import io.ciera.runtime.summit.util.LOG;
import io.ciera.runtime.summit.util.TIM;
import io.ciera.runtime.summit.util.impl.LOGImpl;
import io.ciera.runtime.summit.util.impl.TIMImpl;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;


public class Auth extends Component<Auth> {

    private Map<String, Class<?>> classDirectory;

    public Auth(IApplication app, IRunContext runContext, int populationId) {
        super(app, runContext, populationId);
        Account_extent = new AccountSetImpl();
        Group_extent = new GroupSetImpl();
        Permissions_extent = new PermissionsSetImpl();
        R1_Group_has__Account_extent = new RelationshipSet();
        R2_Group_part_of_Group_extent = new RelationshipSet();
        R3_Group_has_Permissions_extent = new RelationshipSet();
        TIM = null;
        LOG = null;
        classDirectory = new TreeMap<>();
        classDirectory.put("Account", AccountImpl.class);
        classDirectory.put("Group", GroupImpl.class);
        classDirectory.put("Permissions", PermissionsImpl.class);
    }

    // domain functions
    public void CreatePEIs() throws XtumlException {
        Group group = GroupImpl.create( context() );
        group.setName("Employees");
        group.setDescription(( "Given permission to access their account to " + "perform functions such as apply for leave " ) + "or recieve messages from their managers.");
        group = GroupImpl.create( context() );
        group.setName("HR");
        group.setDescription(( "Given permission to access human resources to " + "perform general functions such as add employee " ) + "modify leave settings.");
        group = GroupImpl.create( context() );
        group.setName("Managers");
        group.setDescription(( "Given permission to access their account " + "to perform general functions and access deparatment " ) + "funcitons such as approving leave requests.");
    }

    public void Initialize() throws XtumlException {
        context().CreatePEIs();
    }

    public String getPassword( final int p_EmployeeID,  final String p_FirstLastName,  final int p_CurrentSeconds ) throws XtumlException {
        String a = "a";
        String number1 = "1";
        String b = "b";
        String dollarSign = "$";
        String paran = ")";
        String name = "7(!d&" + p_FirstLastName;
        return name;
    }

    public String getUserName( final String p_F,  final String p_L ) throws XtumlException {
        String username = ( p_F + "." ) + p_L;
        return username;
    }

    public void testGetPassword() throws XtumlException {
        int id = 1041426584;
        String pwd = context().getPassword( id, "Alshaikh", context().TIM().current_seconds() );
        context().LOG().LogInfo( "Generated password: " + pwd );
    }

    public void testGetUsername() throws XtumlException {
        String username = context().getUserName( "Ziyad", "Alshaikh" );
        context().LOG().LogInfo( "Generated username: " + username );
    }



    // relates and unrelates
    public void relate_R1_Group_has__Account( Group form, Account part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R1_Group_has__Account_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR1_a_member_of_Group(form);
            form.addR1_has__Account(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R1_Group_has__Account( Group form, Account part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R1_Group_has__Account_extent.remove( R1_Group_has__Account_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR1_a_member_of_Group(form);
            form.removeR1_has__Account(part);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R2_Group_part_of_Group( Group form, Group part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R2_Group_part_of_Group_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR2_has_Group(form);
            form.setR2_part_of_Group(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R2_Group_part_of_Group( Group form, Group part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R2_Group_part_of_Group_extent.remove( R2_Group_part_of_Group_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR2_has_Group(form);
            form.setR2_part_of_Group(GroupImpl.EMPTY_GROUP);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R3_Group_has_Permissions( Group form, Permissions part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R3_Group_has_Permissions_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR3_given_Group(form);
            form.addR3_has_Permissions(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R3_Group_has_Permissions( Group form, Permissions part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R3_Group_has_Permissions_extent.remove( R3_Group_has_Permissions_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR3_given_Group(form);
            form.removeR3_has_Permissions(part);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }


    // instance selections
    private AccountSet Account_extent;
    public AccountSet Account_instances() {
        return Account_extent;
    }
    private GroupSet Group_extent;
    public GroupSet Group_instances() {
        return Group_extent;
    }
    private PermissionsSet Permissions_extent;
    public PermissionsSet Permissions_instances() {
        return Permissions_extent;
    }


    // relationship selections
    private IRelationshipSet R1_Group_has__Account_extent;
    public IRelationshipSet R1_Group_has__Accounts() throws XtumlException {
        return R1_Group_has__Account_extent;
    }
    private IRelationshipSet R2_Group_part_of_Group_extent;
    public IRelationshipSet R2_Group_part_of_Groups() throws XtumlException {
        return R2_Group_part_of_Group_extent;
    }
    private IRelationshipSet R3_Group_has_Permissions_extent;
    public IRelationshipSet R3_Group_has_Permissionss() throws XtumlException {
        return R3_Group_has_Permissions_extent;
    }


    // ports
    private AuthHR AuthHR;
    public AuthHR HR() {
        if ( null == AuthHR ) AuthHR = new AuthHR( this, null );
        return AuthHR;
    }
    private AuthUI AuthUI;
    public AuthUI UI() {
        if ( null == AuthUI ) AuthUI = new AuthUI( this, null );
        return AuthUI;
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
            prop.load(getClass().getResourceAsStream("AuthProperties.properties"));
        } catch (IOException e) { /* do nothing */ }
        return prop.getProperty("version", "Unknown");
    }
    @Override
    public String getVersionDate() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("AuthProperties.properties"));
        } catch (IOException e) { /* do nothing */ }
        return prop.getProperty("version_date", "Unknown");
    }

    @Override
    public boolean addInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot add empty instance to population." );
        if ( instance instanceof Account ) return Account_extent.add( (Account)instance );
        else if ( instance instanceof Group ) return Group_extent.add( (Group)instance );
        else if ( instance instanceof Permissions ) return Permissions_extent.add( (Permissions)instance );
        return false;
    }

    @Override
    public boolean removeInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot remove empty instance from population." );
        if ( instance instanceof Account ) return Account_extent.remove( (Account)instance );
        else if ( instance instanceof Group ) return Group_extent.remove( (Group)instance );
        else if ( instance instanceof Permissions ) return Permissions_extent.remove( (Permissions)instance );
        return false;
    }

    @Override
    public Auth context() {
        return this;
    }

    @Override
    public Class<?> getClassByKeyLetters(String keyLetters) {
        return classDirectory.get(keyLetters);
    }

}
