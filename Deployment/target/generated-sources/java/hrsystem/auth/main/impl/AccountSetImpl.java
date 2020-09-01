package hrsystem.auth.main.impl;


import hrsystem.auth.main.Account;
import hrsystem.auth.main.AccountSet;
import hrsystem.auth.main.GroupSet;
import hrsystem.auth.main.impl.GroupSetImpl;

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
    public void setUsername( String m_Username ) throws XtumlException {
        for ( Account account : this ) account.setUsername( m_Username );
    }
    @Override
    public void setPassword( String m_Password ) throws XtumlException {
        for ( Account account : this ) account.setPassword( m_Password );
    }
    @Override
    public void setEmployeeID( int m_EmployeeID ) throws XtumlException {
        for ( Account account : this ) account.setEmployeeID( m_EmployeeID );
    }


    // selections
    @Override
    public GroupSet R1_a_member_of_Group() throws XtumlException {
        GroupSet groupset = new GroupSetImpl();
        for ( Account account : this ) groupset.addAll( account.R1_a_member_of_Group() );
        return groupset;
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
