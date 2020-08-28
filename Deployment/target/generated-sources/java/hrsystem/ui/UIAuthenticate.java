package hrsystem.ui;


import hrsystem.UI;

import interfaces.IAuthentication;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.BooleanUtil;
import io.ciera.runtime.summit.types.StringUtil;


public class UIAuthenticate extends Port<UI> implements IAuthentication {

    public UIAuthenticate( UI context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void Reply( final String p_Username,  final String p_Password,  final boolean p_state ) throws XtumlException {
        context().ReplyUsernamePassword( p_Username, p_Password, p_state );
    }



    // outbound messages
    public void CreateNewAccount( final String p_First_Name,  final String p_Last_Name,  final int p_EmployeeID ) throws XtumlException {
        if ( satisfied() ) send(new IAuthentication.CreateNewAccount(p_First_Name, p_Last_Name, p_EmployeeID));
        else {
        }
    }
    public void Initialize() throws XtumlException {
        if ( satisfied() ) send(new IAuthentication.Initialize());
        else {
        }
    }
    public void GetUsernamePassword( final int p_EmployeeID ) throws XtumlException {
        if ( satisfied() ) send(new IAuthentication.GetUsernamePassword(p_EmployeeID));
        else {
        }
    }
    public void ChangePassword( final String p_Username,  final String p_OldPassword,  final String p_NewPassword ) throws XtumlException {
        if ( satisfied() ) send(new IAuthentication.ChangePassword(p_Username, p_OldPassword, p_NewPassword));
        else {
        }
    }
    public void AddToGroup( final int p_EmployeeID,  final String p_Group ) throws XtumlException {
        if ( satisfied() ) send(new IAuthentication.AddToGroup(p_EmployeeID, p_Group));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IAuthentication.SIGNAL_NO_REPLY:
                Reply(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), BooleanUtil.deserialize(message.get(2)));
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "Authenticate";
    }

}
