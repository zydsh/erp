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
    public static final int SIGNAL_NO_READMILESTONES = 2;
    public static class ReadMilestones extends Message {
        public ReadMilestones( final String p_InitiativeName,  final String p_InitiativeShortNumber,  final String p_InitiativeLongNumber ) {
            super(new Object[]{p_InitiativeName,  p_InitiativeShortNumber,  p_InitiativeLongNumber});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_READMILESTONES;
        }
 
    }
    public void ReadMilestones( final String p_InitiativeName,  final String p_InitiativeShortNumber,  final String p_InitiativeLongNumber ) throws XtumlException;
    public static final int SIGNAL_NO_READSTRATEGIES = 3;
    public static class ReadStrategies extends Message {
        @Override
        public int getId() {
            return SIGNAL_NO_READSTRATEGIES;
        }
 
    }
    public void ReadStrategies() throws XtumlException;


    // from provider messages
    public static final int SIGNAL_NO_REPLY = 4;
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
    public static final int SIGNAL_NO_SENDMILESTONES = 5;
    public static class SendMilestones extends Message {
        public SendMilestones( final String p_Name,  final String p_FullCode,  final String p_Code,  final String p_Type,  final String p_SuccessCriteria,  final int p_CompletePlanned,  final int p_CompleteActual,  final boolean p_Complete,  final int p_Weight,  final int p_Percentage,  final String p_sdState,  final String p_sdDescription,  final String p_Notes,  final String p_IncompleteReasons ) {
            super(new Object[]{p_Name,  p_FullCode,  p_Code,  p_Type,  p_SuccessCriteria,  p_CompletePlanned,  p_CompleteActual,  p_Complete,  p_Weight,  p_Percentage,  p_sdState,  p_sdDescription,  p_Notes,  p_IncompleteReasons});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_SENDMILESTONES;
        }
 
    }
    public void SendMilestones( final String p_Name,  final String p_FullCode,  final String p_Code,  final String p_Type,  final String p_SuccessCriteria,  final int p_CompletePlanned,  final int p_CompleteActual,  final boolean p_Complete,  final int p_Weight,  final int p_Percentage,  final String p_sdState,  final String p_sdDescription,  final String p_Notes,  final String p_IncompleteReasons ) throws XtumlException;
    public static final int SIGNAL_NO_SENDSTRATEGIES = 6;
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
