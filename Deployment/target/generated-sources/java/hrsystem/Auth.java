package hrsystem;


import hrsystem.auth.AuthAuth;
import hrsystem.auth.main.Account;
import hrsystem.auth.main.AccountSet;
import hrsystem.auth.main.Group;
import hrsystem.auth.main.GroupSet;
import hrsystem.auth.main.Permission;
import hrsystem.auth.main.PermissionSet;
import hrsystem.auth.main.impl.AccountImpl;
import hrsystem.auth.main.impl.AccountSetImpl;
import hrsystem.auth.main.impl.GroupImpl;
import hrsystem.auth.main.impl.GroupSetImpl;
import hrsystem.auth.main.impl.PermissionImpl;
import hrsystem.auth.main.impl.PermissionSetImpl;

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
import io.ciera.runtime.summit.util.STRING;
import io.ciera.runtime.summit.util.impl.LOGImpl;
import io.ciera.runtime.summit.util.impl.STRINGImpl;

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
        Permission_extent = new PermissionSetImpl();
        R1_Permission_Account_extent = new RelationshipSet();
        R1_Permission_Group_extent = new RelationshipSet();
        LOG = null;
        STRING = null;
        classDirectory = new TreeMap<>();
        classDirectory.put("Account", AccountImpl.class);
        classDirectory.put("Group", GroupImpl.class);
        classDirectory.put("Permission", PermissionImpl.class);
    }

    // domain functions
    public String getPassword( final String p_A,  final String p_B,  final int p_N ) throws XtumlException {
        String name = "7(!d&" + p_B;
        return name;
    }

    public String getUserName( final String p_F,  final String p_L ) throws XtumlException {
        String username = ( context().STRING().substr( p_F, 0, 1 ) + "." ) + p_L;
        return username;
    }

    public void testGetPassword() throws XtumlException {
        int id = 1041426584;
        String pwd = context().getPassword( "Ziyad", "Alshaikh", id );
        context().LOG().LogInfo( "Generated password: " + pwd );
    }



    // relates and unrelates
    public void relate_R1_Permission_Account( Permission form, Account part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R1_Permission_Account_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR1_Permission(form);
            form.setR1_Account(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R1_Permission_Account( Permission form, Account part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R1_Permission_Account_extent.remove( R1_Permission_Account_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR1_Permission(form);
            form.setR1_Account(AccountImpl.EMPTY_ACCOUNT);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R1_Permission_Group( Permission form, Group part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R1_Permission_Group_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR1_Permission(form);
            form.setR1_Group(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R1_Permission_Group( Permission form, Group part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R1_Permission_Group_extent.remove( R1_Permission_Group_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR1_Permission(form);
            form.setR1_Group(GroupImpl.EMPTY_GROUP);
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
    private PermissionSet Permission_extent;
    public PermissionSet Permission_instances() {
        return Permission_extent;
    }


    // relationship selections
    private IRelationshipSet R1_Permission_Account_extent;
    public IRelationshipSet R1_Permission_Accounts() throws XtumlException {
        return R1_Permission_Account_extent;
    }
    private IRelationshipSet R1_Permission_Group_extent;
    public IRelationshipSet R1_Permission_Groups() throws XtumlException {
        return R1_Permission_Group_extent;
    }


    // ports
    private AuthAuth AuthAuth;
    public AuthAuth Auth() {
        if ( null == AuthAuth ) AuthAuth = new AuthAuth( this, null );
        return AuthAuth;
    }


    // utilities
    private LOG LOG;
    public LOG LOG() {
        if ( null == LOG ) LOG = new LOGImpl<>( this );
        return LOG;
    }
    private STRING STRING;
    public STRING STRING() {
        if ( null == STRING ) STRING = new STRINGImpl<>( this );
        return STRING;
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
        else if ( instance instanceof Permission ) return Permission_extent.add( (Permission)instance );
        return false;
    }

    @Override
    public boolean removeInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot remove empty instance from population." );
        if ( instance instanceof Account ) return Account_extent.remove( (Account)instance );
        else if ( instance instanceof Group ) return Group_extent.remove( (Group)instance );
        else if ( instance instanceof Permission ) return Permission_extent.remove( (Permission)instance );
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
