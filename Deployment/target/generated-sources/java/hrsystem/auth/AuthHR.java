package hrsystem.auth;


import hrsystem.Auth;
import hrsystem.auth.main.Account;
import hrsystem.auth.main.AccountSet;
import hrsystem.auth.main.Group;
import hrsystem.auth.main.impl.AccountImpl;

import interfaces.IAuthentication;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.IntegerUtil;
import io.ciera.runtime.summit.types.StringUtil;


public class AuthHR extends Port<Auth> implements IAuthentication {

    public AuthHR( Auth context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void CreateNewAccount( final String p_First_Name,  final String p_Last_Name,  final int p_EmployeeID ) throws XtumlException {
        AccountSet account = ((AccountSet)context().Account_instances().where(selected -> ((Account)selected).getEmployeeID() == p_EmployeeID));
        context().LOG().LogInfo( ( ( "Account: attempting to set username and passowrd for " + p_First_Name ) + " " ) + p_Last_Name );
        if ( account.isEmpty() ) {
            Account acc = AccountImpl.create( context() );
            acc.setEmployeeID(p_EmployeeID);
            acc.setUsername(context().getUserName( p_First_Name, p_Last_Name ));
            acc.setPassword(context().getPassword( p_EmployeeID, p_First_Name + p_Last_Name, context().TIM().current_seconds() ));
            Group group = context().Group_instances().anyWhere(selected -> StringUtil.equality(((Group)selected).getName(), "Employees"));
            context().relate_R1_Group_has__Account( group, acc );
            context().LOG().LogInfo( ( ( ( ( ( ( "Account: account created for employee " + p_First_Name ) + " " ) + p_Last_Name ) + " Username: " ) + acc.getUsername() ) + " Group " ) + group.getName() );
        }
        else {
            context().LOG().LogInfo( "Account: account set is not empty " );
        }
    }

    public void CheckUsernamePassword( final String p_Username,  final String p_Password ) throws XtumlException {
    }

    public void ChangePassword( final String p_Username,  final String p_OldPassword,  final String p_NewPassword ) throws XtumlException {
    }

    public void Initialize() throws XtumlException {
        context().Initialize();
    }

    public void AddToGroup( final int p_EmployeeID,  final String p_Group ) throws XtumlException {
        Account account = context().Account_instances().anyWhere(selected -> ((Account)selected).getEmployeeID() == p_EmployeeID);
        if ( account.isEmpty() ) {
            context().LOG().LogInfo( "Account: employee has no account " );
        }
        else {
            Group group = context().Group_instances().anyWhere(selected -> StringUtil.equality(((Group)selected).getName(), p_Group));
            context().relate_R1_Group_has__Account( group, account );
        }
    }



    // outbound messages
    public void Reply( final int p_EmployeeID,  final String p_Username,  final String p_msg,  final boolean p_state ) throws XtumlException {
        if ( satisfied() ) send(new IAuthentication.Reply(p_EmployeeID, p_Username, p_msg, p_state));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IAuthentication.SIGNAL_NO_CREATENEWACCOUNT:
                CreateNewAccount(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)));
                break;
            case IAuthentication.SIGNAL_NO_CHECKUSERNAMEPASSWORD:
                CheckUsernamePassword(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)));
                break;
            case IAuthentication.SIGNAL_NO_CHANGEPASSWORD:
                ChangePassword(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)));
                break;
            case IAuthentication.SIGNAL_NO_INITIALIZE:
                Initialize();
                break;
            case IAuthentication.SIGNAL_NO_ADDTOGROUP:
                AddToGroup(IntegerUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)));
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "HR";
    }

}
