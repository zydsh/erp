package hrsystem.auth.main.impl;


import hrsystem.Auth;
import hrsystem.auth.main.Account;
import hrsystem.auth.main.Group;
import hrsystem.auth.main.GroupSet;
import hrsystem.auth.main.impl.GroupSetImpl;

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


public class AccountImpl extends ModelInstance<Account,Auth> implements Account {

    public static final String KEY_LETTERS = "Account";
    public static final Account EMPTY_ACCOUNT = new EmptyAccount();

    private Auth context;

    // constructors
    private AccountImpl( Auth context ) {
        this.context = context;
        m_Username = "";
        m_Password = "";
        m_EmployeeID = 0;
        R1_a_member_of_Group_set = new GroupSetImpl();
    }

    private AccountImpl( Auth context, UniqueId instanceId, String m_Username, String m_Password, int m_EmployeeID ) {
        super(instanceId);
        this.context = context;
        this.m_Username = m_Username;
        this.m_Password = m_Password;
        this.m_EmployeeID = m_EmployeeID;
        R1_a_member_of_Group_set = new GroupSetImpl();
    }

    public static Account create( Auth context ) throws XtumlException {
        Account newAccount = new AccountImpl( context );
        if ( context.addInstance( newAccount ) ) {
            newAccount.getRunContext().addChange(new InstanceCreatedDelta(newAccount, KEY_LETTERS));
            return newAccount;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Account create( Auth context, UniqueId instanceId, String m_Username, String m_Password, int m_EmployeeID ) throws XtumlException {
        Account newAccount = new AccountImpl( context, instanceId, m_Username, m_Password, m_EmployeeID );
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
    public String getPassword() throws XtumlException {
        checkLiving();
        return m_Password;
    }
    @Override
    public void setPassword(String m_Password) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Password, this.m_Password)) {
            final String oldValue = this.m_Password;
            this.m_Password = m_Password;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Password", oldValue, this.m_Password));
        }
    }
    private int m_EmployeeID;
    @Override
    public int getEmployeeID() throws XtumlException {
        checkLiving();
        return m_EmployeeID;
    }
    @Override
    public void setEmployeeID(int m_EmployeeID) throws XtumlException {
        checkLiving();
        if (m_EmployeeID != this.m_EmployeeID) {
            final int oldValue = this.m_EmployeeID;
            this.m_EmployeeID = m_EmployeeID;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_EmployeeID", oldValue, this.m_EmployeeID));
        }
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getUsername());
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
    private GroupSet R1_a_member_of_Group_set;
    @Override
    public void addR1_a_member_of_Group( Group inst ) {
        R1_a_member_of_Group_set.add(inst);
    }
    @Override
    public void removeR1_a_member_of_Group( Group inst ) {
        R1_a_member_of_Group_set.remove(inst);
    }
    @Override
    public GroupSet R1_a_member_of_Group() throws XtumlException {
        return R1_a_member_of_Group_set;
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
    public String getPassword() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setPassword( String m_Password ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getEmployeeID() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setEmployeeID( int m_EmployeeID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public GroupSet R1_a_member_of_Group() {
        return (new GroupSetImpl());
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
