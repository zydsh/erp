package interfaces;


import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.Message;


public interface ICRUD {

    // to provider messages
    public static final int SIGNAL_NO_BUDGET = 1;
    public static class Budget extends Message {
        public Budget( final String p_Year,  final double p_Fund,  final String p_Action ) {
            super(new Object[]{p_Year,  p_Fund,  p_Action});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_BUDGET;
        }
 
    }
    public void Budget( final String p_Year,  final double p_Fund,  final String p_Action ) throws XtumlException;
    public static final int SIGNAL_NO_CHAPTER = 2;
    public static class Chapter extends Message {
        public Chapter( final String p_Name,  final int p_Code,  final double p_Ceiling_Fund,  final double p_Request_Fund,  final double p_Fund,  final String p_Action,  final String p_Year ) {
            super(new Object[]{p_Name,  p_Code,  p_Ceiling_Fund,  p_Request_Fund,  p_Fund,  p_Action,  p_Year});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_CHAPTER;
        }
 
    }
    public void Chapter( final String p_Name,  final int p_Code,  final double p_Ceiling_Fund,  final double p_Request_Fund,  final double p_Fund,  final String p_Action,  final String p_Year ) throws XtumlException;
    public static final int SIGNAL_NO_ITEM = 3;
    public static class Item extends Message {
        public Item( final double p_Fund,  final String p_Status,  final String p_Type,  final String p_Category,  final String p_ID,  final String p_Section_ID,  final String p_Action ) {
            super(new Object[]{p_Fund,  p_Status,  p_Type,  p_Category,  p_ID,  p_Section_ID,  p_Action});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_ITEM;
        }
 
    }
    public void Item( final double p_Fund,  final String p_Status,  final String p_Type,  final String p_Category,  final String p_ID,  final String p_Section_ID,  final String p_Action ) throws XtumlException;
    public static final int SIGNAL_NO_SECTION = 5;
    public static class Section extends Message {
        public Section( final String p_Name,  final String p_ID,  final double p_Fund,  final String p_Economic_Category,  final String p_Comments,  final String p_Year,  final String p_Action,  final int p_Code ) {
            super(new Object[]{p_Name,  p_ID,  p_Fund,  p_Economic_Category,  p_Comments,  p_Year,  p_Action,  p_Code});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_SECTION;
        }
 
    }
    public void Section( final String p_Name,  final String p_ID,  final double p_Fund,  final String p_Economic_Category,  final String p_Comments,  final String p_Year,  final String p_Action,  final int p_Code ) throws XtumlException;


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


}
