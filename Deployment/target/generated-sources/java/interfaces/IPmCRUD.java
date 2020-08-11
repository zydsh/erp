package interfaces;


import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.Message;


public interface IPmCRUD {

    // to provider messages
    public static final int SIGNAL_NO_INITIATIVE = 1;
    public static class Initiative extends Message {
        public Initiative( final String p_Name,  final String p_Short_Number,  final String p_Long_Number,  final String p_Description,  final int p_Start_Date,  final int p_Actual_Start_Date,  final int p_End_Date,  final int p_Actual_End_Date,  final double p_Budget,  final String p_Action ) {
            super(new Object[]{p_Name,  p_Short_Number,  p_Long_Number,  p_Description,  p_Start_Date,  p_Actual_Start_Date,  p_End_Date,  p_Actual_End_Date,  p_Budget,  p_Action});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_INITIATIVE;
        }
 
    }
    public void Initiative( final String p_Name,  final String p_Short_Number,  final String p_Long_Number,  final String p_Description,  final int p_Start_Date,  final int p_Actual_Start_Date,  final int p_End_Date,  final int p_Actual_End_Date,  final double p_Budget,  final String p_Action ) throws XtumlException;
    public static final int SIGNAL_NO_MILESTONE = 2;
    public static class Milestone extends Message {
        public Milestone( final String p_Name,  final String p_Full_Code,  final String p_Code,  final String p_Type,  final String p_Success_Criteria,  final int p_Complete_Planned,  final int p_Complete_Actual,  final int p_Complete,  final int p_Weight,  final int p_Percentage,  final String p_sd_State,  final String p_sd_Description,  final String p_Notes,  final String p_Incomplete_Reasons,  final String p_Action ) {
            super(new Object[]{p_Name,  p_Full_Code,  p_Code,  p_Type,  p_Success_Criteria,  p_Complete_Planned,  p_Complete_Actual,  p_Complete,  p_Weight,  p_Percentage,  p_sd_State,  p_sd_Description,  p_Notes,  p_Incomplete_Reasons,  p_Action});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_MILESTONE;
        }
 
    }
    public void Milestone( final String p_Name,  final String p_Full_Code,  final String p_Code,  final String p_Type,  final String p_Success_Criteria,  final int p_Complete_Planned,  final int p_Complete_Actual,  final int p_Complete,  final int p_Weight,  final int p_Percentage,  final String p_sd_State,  final String p_sd_Description,  final String p_Notes,  final String p_Incomplete_Reasons,  final String p_Action ) throws XtumlException;
    public static final int SIGNAL_NO_STRATEGY = 4;
    public static class Strategy extends Message {
        public Strategy( final String p_Name,  final String p_Description,  final String p_Number,  final String p_Action ) {
            super(new Object[]{p_Name,  p_Description,  p_Number,  p_Action});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_STRATEGY;
        }
 
    }
    public void Strategy( final String p_Name,  final String p_Description,  final String p_Number,  final String p_Action ) throws XtumlException;
    public static final int SIGNAL_NO_SUPPORTING_DOCUMENTS = 5;
    public static class Supporting_Documents extends Message {
        public Supporting_Documents( final String p_Name,  final String p_Document,  final String p_State,  final String p_Notes,  final String p_Action ) {
            super(new Object[]{p_Name,  p_Document,  p_State,  p_Notes,  p_Action});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_SUPPORTING_DOCUMENTS;
        }
 
    }
    public void Supporting_Documents( final String p_Name,  final String p_Document,  final String p_State,  final String p_Notes,  final String p_Action ) throws XtumlException;


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


}
