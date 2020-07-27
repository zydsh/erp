package shared;


import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.Message;


public interface IOps {

    // to provider messages
    public static final int SIGNAL_NO_EMPLOYEE_BONUS = 1;
    public static class Employee_Bonus extends Message {
        public Employee_Bonus( final int p_National_ID,  final String p_Name,  final int p_Starting,  final int p_Ending,  final String p_Action ) {
            super(new Object[]{p_National_ID,  p_Name,  p_Starting,  p_Ending,  p_Action});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_EMPLOYEE_BONUS;
        }
 
    }
    public void Employee_Bonus( final int p_National_ID,  final String p_Name,  final int p_Starting,  final int p_Ending,  final String p_Action ) throws XtumlException;
    public static final int SIGNAL_NO_EMPLOYEE_COMMENCE = 2;
    public static class Employee_Commence extends Message {
        public Employee_Commence( final int p_National_ID ) {
            super(new Object[]{p_National_ID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_EMPLOYEE_COMMENCE;
        }
 
    }
    public void Employee_Commence( final int p_National_ID ) throws XtumlException;
    public static final int SIGNAL_NO_EMPLOYEE_JOB = 3;
    public static class Employee_Job extends Message {
        public Employee_Job( final int p_Job_ID,  final int p_National_ID,  final String p_Action,  final boolean p_Active ) {
            super(new Object[]{p_Job_ID,  p_National_ID,  p_Action,  p_Active});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_EMPLOYEE_JOB;
        }
 
    }
    public void Employee_Job( final int p_Job_ID,  final int p_National_ID,  final String p_Action,  final boolean p_Active ) throws XtumlException;
    public static final int SIGNAL_NO_LEAVE_REQUEST = 4;
    public static class Leave_Request extends Message {
        public Leave_Request( final int p_Starting,  final int p_Ending,  final int p_National_ID,  final String p_Name ) {
            super(new Object[]{p_Starting,  p_Ending,  p_National_ID,  p_Name});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_LEAVE_REQUEST;
        }
 
    }
    public void Leave_Request( final int p_Starting,  final int p_Ending,  final int p_National_ID,  final String p_Name ) throws XtumlException;
    public static final int SIGNAL_NO_LEAVE_RETURN = 5;
    public static class Leave_Return extends Message {
        public Leave_Return( final int p_National_ID ) {
            super(new Object[]{p_National_ID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_LEAVE_RETURN;
        }
 
    }
    public void Leave_Return( final int p_National_ID ) throws XtumlException;
    public static final int SIGNAL_NO_REQUEST_EMPLOYEE_PAYMENT = 6;
    public static class Request_Employee_Payment extends Message {
        public Request_Employee_Payment( final int p_National_ID ) {
            super(new Object[]{p_National_ID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_REQUEST_EMPLOYEE_PAYMENT;
        }
 
    }
    public void Request_Employee_Payment( final int p_National_ID ) throws XtumlException;


    // from provider messages
    public static final int SIGNAL_NO_RETURN_EMPLOYEE_PAYMENT = 7;
    public static class Return_Employee_Payment extends Message {
        public Return_Employee_Payment( final double p_Amount,  final String p_Name,  final int p_Date ) {
            super(new Object[]{p_Amount,  p_Name,  p_Date});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_RETURN_EMPLOYEE_PAYMENT;
        }
 
    }
    public void Return_Employee_Payment( final double p_Amount,  final String p_Name,  final int p_Date ) throws XtumlException;


}
