package shared;


import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.Message;


public interface IOps {

    // to provider messages
    public static final int SIGNAL_NO_APPROVEEMPLOYEELEAVE = 1;
    public static class ApproveEmployeeLeave extends Message {
        public ApproveEmployeeLeave( final int p_EmployeeID ) {
            super(new Object[]{p_EmployeeID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_APPROVEEMPLOYEELEAVE;
        }
 
    }
    public void ApproveEmployeeLeave( final int p_EmployeeID ) throws XtumlException;
    public static final int SIGNAL_NO_ASSIGNBONUSTOEMPLOYEE = 2;
    public static class AssignBonusToEmployee extends Message {
        public AssignBonusToEmployee( final int p_National_ID,  final String p_Name,  final int p_Starting,  final int p_Ending,  final String p_Action ) {
            super(new Object[]{p_National_ID,  p_Name,  p_Starting,  p_Ending,  p_Action});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_ASSIGNBONUSTOEMPLOYEE;
        }
 
    }
    public void AssignBonusToEmployee( final int p_National_ID,  final String p_Name,  final int p_Starting,  final int p_Ending,  final String p_Action ) throws XtumlException;
    public static final int SIGNAL_NO_ASSIGNJOBTOEMPLOYEE = 3;
    public static class AssignJobToEmployee extends Message {
        public AssignJobToEmployee( final int p_Job_ID,  final int p_National_ID,  final String p_Action,  final boolean p_Active ) {
            super(new Object[]{p_Job_ID,  p_National_ID,  p_Action,  p_Active});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_ASSIGNJOBTOEMPLOYEE;
        }
 
    }
    public void AssignJobToEmployee( final int p_Job_ID,  final int p_National_ID,  final String p_Action,  final boolean p_Active ) throws XtumlException;
    public static final int SIGNAL_NO_COMMENCEEMPLOYEE = 4;
    public static class CommenceEmployee extends Message {
        public CommenceEmployee( final int p_National_ID ) {
            super(new Object[]{p_National_ID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_COMMENCEEMPLOYEE;
        }
 
    }
    public void CommenceEmployee( final int p_National_ID ) throws XtumlException;
    public static final int SIGNAL_NO_GENERATEEMPLOYEEPAYSLIP = 5;
    public static class GenerateEmployeePayslip extends Message {
        public GenerateEmployeePayslip( final int p_National_ID ) {
            super(new Object[]{p_National_ID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_GENERATEEMPLOYEEPAYSLIP;
        }
 
    }
    public void GenerateEmployeePayslip( final int p_National_ID ) throws XtumlException;
    public static final int SIGNAL_NO_REJECTEMPLOYEELEAVE = 6;
    public static class RejectEmployeeLeave extends Message {
        public RejectEmployeeLeave( final int p_EmployeeID ) {
            super(new Object[]{p_EmployeeID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_REJECTEMPLOYEELEAVE;
        }
 
    }
    public void RejectEmployeeLeave( final int p_EmployeeID ) throws XtumlException;
    public static final int SIGNAL_NO_REQUESTEMPLOYEELEAVE = 7;
    public static class RequestEmployeeLeave extends Message {
        public RequestEmployeeLeave( final int p_Starting,  final int p_Ending,  final int p_EmployeeID,  final String p_LeaveName ) {
            super(new Object[]{p_Starting,  p_Ending,  p_EmployeeID,  p_LeaveName});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_REQUESTEMPLOYEELEAVE;
        }
 
    }
    public void RequestEmployeeLeave( final int p_Starting,  final int p_Ending,  final int p_EmployeeID,  final String p_LeaveName ) throws XtumlException;
    public static final int SIGNAL_NO_RETURNFROMLEAVE = 8;
    public static class ReturnFromLeave extends Message {
        public ReturnFromLeave( final int p_National_ID ) {
            super(new Object[]{p_National_ID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_RETURNFROMLEAVE;
        }
 
    }
    public void ReturnFromLeave( final int p_National_ID ) throws XtumlException;


    // from provider messages
    public static final int SIGNAL_NO_RETURN_EMPLOYEE_PAYMENT = 9;
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
