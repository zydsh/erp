package shared;


import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.Message;


public interface ICRUD {

    // to provider messages
    public static final int SIGNAL_NO_BONUS = 1;
    public static class Bonus extends Message {
        public Bonus( final String p_Name,  final double p_Percent,  final String p_Action ) {
            super(new Object[]{p_Name,  p_Percent,  p_Action});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_BONUS;
        }
 
    }
    public void Bonus( final String p_Name,  final double p_Percent,  final String p_Action ) throws XtumlException;
    public static final int SIGNAL_NO_EMPLOYEE = 2;
    public static class Employee extends Message {
        public Employee( final String p_FName,  final String p_LName,  final int p_National_ID,  final String p_Action ) {
            super(new Object[]{p_FName,  p_LName,  p_National_ID,  p_Action});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_EMPLOYEE;
        }
 
    }
    public void Employee( final String p_FName,  final String p_LName,  final int p_National_ID,  final String p_Action ) throws XtumlException;
    public static final int SIGNAL_NO_GRADE = 3;
    public static class Grade extends Message {
        public Grade( final int p_Value,  final String p_Action ) {
            super(new Object[]{p_Value,  p_Action});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_GRADE;
        }
 
    }
    public void Grade( final int p_Value,  final String p_Action ) throws XtumlException;
    public static final int SIGNAL_NO_JOB = 4;
    public static class Job extends Message {
        public Job( final int p_Step,  final int p_Grade,  final double p_Amount,  final String p_Name,  final String p_Action ) {
            super(new Object[]{p_Step,  p_Grade,  p_Amount,  p_Name,  p_Action});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_JOB;
        }
 
    }
    public void Job( final int p_Step,  final int p_Grade,  final double p_Amount,  final String p_Name,  final String p_Action ) throws XtumlException;
    public static final int SIGNAL_NO_LEAVE = 5;
    public static class Leave extends Message {
        public Leave( final String p_Name,  final int p_MaximumDays,  final String p_Action ) {
            super(new Object[]{p_Name,  p_MaximumDays,  p_Action});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_LEAVE;
        }
 
    }
    public void Leave( final String p_Name,  final int p_MaximumDays,  final String p_Action ) throws XtumlException;
    public static final int SIGNAL_NO_PAYMENT = 6;
    public static class Payment extends Message {
        @Override
        public int getId() {
            return SIGNAL_NO_PAYMENT;
        }
 
    }
    public void Payment() throws XtumlException;
    public static final int SIGNAL_NO_STEP = 8;
    public static class Step extends Message {
        public Step( final int p_Value,  final String p_Action ) {
            super(new Object[]{p_Value,  p_Action});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_STEP;
        }
 
    }
    public void Step( final int p_Value,  final String p_Action ) throws XtumlException;


    // from provider messages
    public static final int SIGNAL_NO_REPLY = 7;
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
