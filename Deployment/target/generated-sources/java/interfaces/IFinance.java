package interfaces;


import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.Message;


public interface IFinance {

    // to provider messages
    public static final int SIGNAL_NO_INITIALIZE = 1;
    public static class Initialize extends Message {
        @Override
        public int getId() {
            return SIGNAL_NO_INITIALIZE;
        }
 
    }
    public void Initialize() throws XtumlException;


    // from provider messages


}
