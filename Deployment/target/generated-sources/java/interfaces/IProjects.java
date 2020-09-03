package interfaces;


import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.Message;


public interface IProjects {

    // to provider messages
    public static final int SIGNAL_NO_INITIALIZE = 1;
    public static class Initialize extends Message {
        @Override
        public int getId() {
            return SIGNAL_NO_INITIALIZE;
        }
 
    }
    public void Initialize() throws XtumlException;
    public static final int SIGNAL_NO_READSTRATEGIES = 2;
    public static class ReadStrategies extends Message {
        @Override
        public int getId() {
            return SIGNAL_NO_READSTRATEGIES;
        }
 
    }
    public void ReadStrategies() throws XtumlException;


    // from provider messages
    public static final int SIGNAL_NO_REPLY = 3;
    public static class Reply extends Message {
        public Reply( final String p_msg,  final boolean p_state ) {
            super(new Object[]{p_msg,  p_state});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_REPLY;
        }
 
    }
    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException;
    public static final int SIGNAL_NO_SENDSTRATEGIES = 4;
    public static class SendStrategies extends Message {
        public SendStrategies( final String p_Number,  final String p_Name,  final String p_Description ) {
            super(new Object[]{p_Number,  p_Name,  p_Description});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_SENDSTRATEGIES;
        }
 
    }
    public void SendStrategies( final String p_Number,  final String p_Name,  final String p_Description ) throws XtumlException;


}
