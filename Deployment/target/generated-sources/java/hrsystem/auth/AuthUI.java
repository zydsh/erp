package hrsystem.auth;


import hrsystem.Auth;
import hrsystem.auth.main.Account;

import interfaces.IAuthentication;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.IntegerUtil;
import io.ciera.runtime.summit.types.StringUtil;


public class AuthUI extends Port<Auth> implements IAuthentication {

    public AuthUI( Auth context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void AddToGroup( final int p_EmployeeID,  final String p_Group ) throws XtumlException {
    }

    public void GetUsernamePassword( final int p_EmployeeID ) throws XtumlException {
        Account account = context().Account_instances().anyWhere(selected -> ((Account)selected).getEmployeeID() == p_EmployeeID);
        if ( account.isEmpty() ) {
            context().UI().Reply( "", "", false );
            context().LOG().LogInfo( "User account not found" );
        }
        else {
            context().UI().Reply( account.getUsername(), account.getPassword(), true );
            context().LOG().LogInfo( "User account successfully sent" );
        }
    }

    public void CreateNewAccount( final String p_First_Name,  final String p_Last_Name,  final int p_EmployeeID ) throws XtumlException {
    }

    public void Initialize() throws XtumlException {
    }

    public void ChangePassword( final String p_Username,  final String p_OldPassword,  final String p_NewPassword ) throws XtumlException {
    }



    // outbound messages
    public void Reply( final String p_Username,  final String p_Password,  final boolean p_state ) throws XtumlException {
        if ( satisfied() ) send(new IAuthentication.Reply(p_Username, p_Password, p_state));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IAuthentication.SIGNAL_NO_ADDTOGROUP:
                AddToGroup(IntegerUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)));
                break;
            case IAuthentication.SIGNAL_NO_GETUSERNAMEPASSWORD:
                GetUsernamePassword(IntegerUtil.deserialize(message.get(0)));
                break;
            case IAuthentication.SIGNAL_NO_CREATENEWACCOUNT:
                CreateNewAccount(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)));
                break;
            case IAuthentication.SIGNAL_NO_INITIALIZE:
                Initialize();
                break;
            case IAuthentication.SIGNAL_NO_CHANGEPASSWORD:
                ChangePassword(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)));
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "UI";
    }

}
