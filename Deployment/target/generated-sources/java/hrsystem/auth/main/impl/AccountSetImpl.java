package hrsystem.auth.main.impl;


import hrsystem.auth.main.Account;
import hrsystem.auth.main.AccountSet;
import hrsystem.auth.main.PermissionSet;
import hrsystem.auth.main.impl.PermissionSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class AccountSetImpl extends InstanceSet<AccountSet,Account> implements AccountSet {

    public AccountSetImpl() {
    }

    public AccountSetImpl(Comparator<? super Account> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setNational_ID( int m_National_ID ) throws XtumlException {
        for ( Account account : this ) account.setNational_ID( m_National_ID );
    }
    @Override
    public void setPassword( String m_Password ) throws XtumlException {
        for ( Account account : this ) account.setPassword( m_Password );
    }
    @Override
    public void setUsername( String m_Username ) throws XtumlException {
        for ( Account account : this ) account.setUsername( m_Username );
    }


    // selections
    @Override
    public PermissionSet R1_Permission() throws XtumlException {
        PermissionSet permissionset = new PermissionSetImpl();
        for ( Account account : this ) permissionset.addAll( account.R1_Permission() );
        return permissionset;
    }


    @Override
    public Account nullElement() {
        return AccountImpl.EMPTY_ACCOUNT;
    }

    @Override
    public AccountSet emptySet() {
      return new AccountSetImpl();
    }

    @Override
    public AccountSet emptySet(Comparator<? super Account> comp) {
      return new AccountSetImpl(comp);
    }

    @Override
    public List<Account> elements() {
        return Arrays.asList(toArray(new Account[0]));
    }

}
