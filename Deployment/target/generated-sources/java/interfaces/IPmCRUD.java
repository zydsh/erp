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
    public static final int SIGNAL_NO_STRATEGY = 2;
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


    // from provider messages


}
