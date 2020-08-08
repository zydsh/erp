package hrsystem.auth.main.impl;


import hrsystem.Auth;
import hrsystem.auth.main.Account;
import hrsystem.auth.main.Permission;
import hrsystem.auth.main.PermissionSet;
import hrsystem.auth.main.impl.AccountImpl;
import hrsystem.auth.main.impl.PermissionSetImpl;

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
import io.ciera.runtime.summit.types.IWhere;
import io.ciera.runtime.summit.types.IXtumlType;
import io.ciera.runtime.summit.types.StringUtil;
import io.ciera.runtime.summit.types.UniqueId;


public class AccountImpl extends ModelInstance<Account,Auth> implements Account {

    public static final String KEY_LETTERS = "Account";
    public static final Account EMPTY_ACCOUNT = new EmptyAccount();

    private Auth context;

    // constructors
    private AccountImpl( Auth context ) {
        this.context = context;
        m_Username = "";
        m_Password = "";
        m_National_ID = 0;
        R1_Permission_set = new PermissionSetImpl();
    }

    private AccountImpl( Auth context, UniqueId instanceId, String m_Username, String m_Password, int m_National_ID ) {
        super(instanceId);
        this.context = context;
        this.m_Username = m_Username;
        this.m_Password = m_Password;
        this.m_National_ID = m_National_ID;
        R1_Permission_set = new PermissionSetImpl();
    }

    public static Account create( Auth context ) throws XtumlException {
        Account newAccount = new AccountImpl( context );
        if ( context.addInstance( newAccount ) ) {
            newAccount.getRunContext().addChange(new InstanceCreatedDelta(newAccount, KEY_LETTERS));
            return newAccount;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Account create( Auth context, UniqueId instanceId, String m_Username, String m_Password, int m_National_ID ) throws XtumlException {
        Account newAccount = new AccountImpl( context, instanceId, m_Username, m_Password, m_National_ID );
        if ( context.addInstance( newAccount ) ) {
            return newAccount;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private String m_Username;
    @Override
    public void setUsername(String m_Username) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Username, this.m_Username)) {
            final String oldValue = this.m_Username;
            this.m_Username = m_Username;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Username", oldValue, this.m_Username));
        }
    }
    @Override
    public String getUsername() throws XtumlException {
        checkLiving();
        return m_Username;
    }
    private String m_Password;
    @Override
    public void setPassword(String m_Password) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Password, this.m_Password)) {
            final String oldValue = this.m_Password;
            this.m_Password = m_Password;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Password", oldValue, this.m_Password));
        }
    }
    @Override
    public String getPassword() throws XtumlException {
        checkLiving();
        return m_Password;
    }
    private int m_National_ID;
    @Override
    public int getNational_ID() throws XtumlException {
        checkLiving();
        return m_National_ID;
    }
    @Override
    public void setNational_ID(int m_National_ID) throws XtumlException {
        checkLiving();
        if (m_National_ID != this.m_National_ID) {
            final int oldValue = this.m_National_ID;
            this.m_National_ID = m_National_ID;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_National_ID", oldValue, this.m_National_ID));
        }
    }


    // instance identifiers

    // operations


    // static operations
    public static class CLASS extends ActionHome<Auth> {

        public CLASS( Auth context ) {
            super( context );
        }

        public void crud( final String p_First_Name,  final String p_Last_Name,  final int p_National_ID ) throws XtumlException {
            Account acc = context().Account_instances().anyWhere(selected -> ((Account)selected).getNational_ID() == p_National_ID);
            if ( acc.isEmpty() ) {
                String user_name = context().getUserName( p_First_Name, p_Last_Name );
                String pwd = context().getPassword( p_First_Name, p_Last_Name, p_National_ID );
                Account account = AccountImpl.create( context() );
                account.setUsername(user_name);
                account.setPassword(pwd);
                account.setNational_ID(p_National_ID);
            }
            else {
                context().LOG().LogInfo( "Cannot create instance because teh account already exists." );
            }
        }



    }


    // events


    // selections
    private PermissionSet R1_Permission_set;
    @Override
    public void addR1_Permission( Permission inst ) {
        R1_Permission_set.add(inst);
    }
    @Override
    public void removeR1_Permission( Permission inst ) {
        R1_Permission_set.remove(inst);
    }
    @Override
    public PermissionSet R1_Permission() throws XtumlException {
        return R1_Permission_set;
    }


    @Override
    public IRunContext getRunContext() {
        return context().getRunContext();
    }

    @Override
    public Auth context() {
        return context;
    }

    @Override
    public String getKeyLetters() {
        return KEY_LETTERS;
    }

    @Override
    public Account self() {
        return this;
    }

    @Override
    public Account oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_ACCOUNT;
    }

}

class EmptyAccount extends ModelInstance<Account,Auth> implements Account {

    // attributes
    public void setUsername( String m_Username ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getUsername() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setPassword( String m_Password ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getPassword() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getNational_ID() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setNational_ID( int m_National_ID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public PermissionSet R1_Permission() {
        return (new PermissionSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return AccountImpl.KEY_LETTERS;
    }

    @Override
    public Account self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Account oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return AccountImpl.EMPTY_ACCOUNT;
    }

}
