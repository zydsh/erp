package hrsystem.hr;


import hrsystem.Hr;

import interfaces.IAuthentication;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.BooleanUtil;
import io.ciera.runtime.summit.types.IntegerUtil;
import io.ciera.runtime.summit.types.StringUtil;


public class HrAuthenticate extends Port<Hr> implements IAuthentication {

    public HrAuthenticate( Hr context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void Reply( final int p_EmployeeID,  final String p_Username,  final String p_msg,  final boolean p_state ) throws XtumlException {
    }

    public void SendEmployeePermissions( final String p_GroupName,  final String p_Description ) throws XtumlException {
    }



    // outbound messages
    public void ReadEmployeePermissions( final int p_EmployeeID ) throws XtumlException {
        if ( satisfied() ) send(new IAuthentication.ReadEmployeePermissions(p_EmployeeID));
        else {
        }
    }
    public void CheckUsernamePassword( final String p_Username,  final String p_Password ) throws XtumlException {
        if ( satisfied() ) send(new IAuthentication.CheckUsernamePassword(p_Username, p_Password));
        else {
        }
    }
    public void CreateNewAccount( final String p_First_Name,  final String p_Last_Name,  final int p_EmployeeID ) throws XtumlException {
        if ( satisfied() ) send(new IAuthentication.CreateNewAccount(p_First_Name, p_Last_Name, p_EmployeeID));
        else {
        }
    }
    public void AddToGroup( final int p_EmployeeID,  final String p_Group ) throws XtumlException {
        if ( satisfied() ) send(new IAuthentication.AddToGroup(p_EmployeeID, p_Group));
        else {
        }
    }
    public void Initialize() throws XtumlException {
        if ( satisfied() ) send(new IAuthentication.Initialize());
        else {
        }
    }
    public void ChangePassword( final String p_Username,  final String p_OldPassword,  final String p_NewPassword ) throws XtumlException {
        if ( satisfied() ) send(new IAuthentication.ChangePassword(p_Username, p_OldPassword, p_NewPassword));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IAuthentication.SIGNAL_NO_REPLY:
                Reply(IntegerUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)), BooleanUtil.deserialize(message.get(3)));
                break;
            case IAuthentication.SIGNAL_NO_SENDEMPLOYEEPERMISSIONS:
                SendEmployeePermissions(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)));
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
