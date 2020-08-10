package interfaces;


import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.Message;


public interface ICRUD {

    // to provider messages
    public static final int SIGNAL_NO_ACCOUNT = 1;
    public static class Account extends Message {
        public Account( final String p_First_Name,  final String p_Last_Name,  final int p_National_ID ) {
            super(new Object[]{p_First_Name,  p_Last_Name,  p_National_ID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_ACCOUNT;
        }
 
    }
    public void Account( final String p_First_Name,  final String p_Last_Name,  final int p_National_ID ) throws XtumlException;


    // from provider messages
    public static final int SIGNAL_NO_REPLY = 2;
    public static class Reply extends Message {
        public Reply( final String p_Username,  final String p_Password,  final boolean p_state ) {
            super(new Object[]{p_Username,  p_Password,  p_state});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_REPLY;
        }
 
    }
    public void Reply( final String p_Username,  final String p_Password,  final boolean p_state ) throws XtumlException;


}
