package interfaces;


import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.Message;


public interface IAuthentication {

    // to provider messages
    public static final int SIGNAL_NO_ADDTOGROUP = 1;
    public static class AddToGroup extends Message {
        public AddToGroup( final int p_EmployeeID,  final String p_Group ) {
            super(new Object[]{p_EmployeeID,  p_Group});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_ADDTOGROUP;
        }
 
    }
    public void AddToGroup( final int p_EmployeeID,  final String p_Group ) throws XtumlException;
    public static final int SIGNAL_NO_CHANGEPASSWORD = 2;
    public static class ChangePassword extends Message {
        public ChangePassword( final String p_Username,  final String p_OldPassword,  final String p_NewPassword ) {
            super(new Object[]{p_Username,  p_OldPassword,  p_NewPassword});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_CHANGEPASSWORD;
        }
 
    }
    public void ChangePassword( final String p_Username,  final String p_OldPassword,  final String p_NewPassword ) throws XtumlException;
    public static final int SIGNAL_NO_CHECKUSERNAMEPASSWORD = 3;
    public static class CheckUsernamePassword extends Message {
        public CheckUsernamePassword( final String p_Username,  final String p_Password ) {
            super(new Object[]{p_Username,  p_Password});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_CHECKUSERNAMEPASSWORD;
        }
 
    }
    public void CheckUsernamePassword( final String p_Username,  final String p_Password ) throws XtumlException;
    public static final int SIGNAL_NO_CREATENEWACCOUNT = 4;
    public static class CreateNewAccount extends Message {
        public CreateNewAccount( final String p_First_Name,  final String p_Last_Name,  final int p_EmployeeID ) {
            super(new Object[]{p_First_Name,  p_Last_Name,  p_EmployeeID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_CREATENEWACCOUNT;
        }
 
    }
    public void CreateNewAccount( final String p_First_Name,  final String p_Last_Name,  final int p_EmployeeID ) throws XtumlException;
    public static final int SIGNAL_NO_INITIALIZE = 5;
    public static class Initialize extends Message {
        @Override
        public int getId() {
            return SIGNAL_NO_INITIALIZE;
        }
 
    }
    public void Initialize() throws XtumlException;


    // from provider messages
    public static final int SIGNAL_NO_REPLY = 6;
    public static class Reply extends Message {
        public Reply( final int p_EmployeeID,  final String p_Username,  final String p_msg,  final boolean p_state ) {
            super(new Object[]{p_EmployeeID,  p_Username,  p_msg,  p_state});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_REPLY;
        }
 
    }
    public void Reply( final int p_EmployeeID,  final String p_Username,  final String p_msg,  final boolean p_state ) throws XtumlException;


}
