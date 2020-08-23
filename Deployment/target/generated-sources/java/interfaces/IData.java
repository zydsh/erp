package interfaces;


import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.Message;


public interface IData {

    // to provider messages
    public static final int SIGNAL_NO_CREATEEMPLOYEE = 1;
    public static class CreateEmployee extends Message {
        public CreateEmployee( final int p_EmployeeID,  final int p_NationalID,  final String p_FirstName,  final String p_MiddleName,  final String p_LastName,  final int p_DateOfBirth,  final String p_Degree,  final String p_Gender ) {
            super(new Object[]{p_EmployeeID,  p_NationalID,  p_FirstName,  p_MiddleName,  p_LastName,  p_DateOfBirth,  p_Degree,  p_Gender});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_CREATEEMPLOYEE;
        }
 
    }
    public void CreateEmployee( final int p_EmployeeID,  final int p_NationalID,  final String p_FirstName,  final String p_MiddleName,  final String p_LastName,  final int p_DateOfBirth,  final String p_Degree,  final String p_Gender ) throws XtumlException;
    public static final int SIGNAL_NO_CREATELEAVESPECIFICATION = 2;
    public static class CreateLeaveSpecification extends Message {
        public CreateLeaveSpecification( final String p_Name,  final int p_MaximumDays,  final int p_MinimumDays ) {
            super(new Object[]{p_Name,  p_MaximumDays,  p_MinimumDays});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_CREATELEAVESPECIFICATION;
        }
 
    }
    public void CreateLeaveSpecification( final String p_Name,  final int p_MaximumDays,  final int p_MinimumDays ) throws XtumlException;
    public static final int SIGNAL_NO_DELETELEAVESPECIFICATION = 3;
    public static class DeleteLeaveSpecification extends Message {
        public DeleteLeaveSpecification( final String p_Name ) {
            super(new Object[]{p_Name});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_DELETELEAVESPECIFICATION;
        }
 
    }
    public void DeleteLeaveSpecification( final String p_Name ) throws XtumlException;
    public static final int SIGNAL_NO_READEMPLOYEE = 4;
    public static class ReadEmployee extends Message {
        @Override
        public int getId() {
            return SIGNAL_NO_READEMPLOYEE;
        }
 
    }
    public void ReadEmployee() throws XtumlException;
    public static final int SIGNAL_NO_READLEAVESPECIFICATION = 5;
    public static class ReadLeaveSpecification extends Message {
        @Override
        public int getId() {
            return SIGNAL_NO_READLEAVESPECIFICATION;
        }
 
    }
    public void ReadLeaveSpecification() throws XtumlException;


    // from provider messages
    public static final int SIGNAL_NO_REPLY = 6;
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
    public static final int SIGNAL_NO_SENDEMPLOYEE = 7;
    public static class SendEmployee extends Message {
        public SendEmployee( final int p_EmployeeID,  final int p_NationalID,  final String p_FirstName,  final String p_MiddleName,  final String p_LastName,  final int p_DateOfBirth,  final String p_Degree,  final String p_Gender,  final int p_StartDate,  final int p_LeaveBalance,  final int p_SickLeaveBalance,  final int p_Size ) {
            super(new Object[]{p_EmployeeID,  p_NationalID,  p_FirstName,  p_MiddleName,  p_LastName,  p_DateOfBirth,  p_Degree,  p_Gender,  p_StartDate,  p_LeaveBalance,  p_SickLeaveBalance,  p_Size});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_SENDEMPLOYEE;
        }
 
    }
    public void SendEmployee( final int p_EmployeeID,  final int p_NationalID,  final String p_FirstName,  final String p_MiddleName,  final String p_LastName,  final int p_DateOfBirth,  final String p_Degree,  final String p_Gender,  final int p_StartDate,  final int p_LeaveBalance,  final int p_SickLeaveBalance,  final int p_Size ) throws XtumlException;
    public static final int SIGNAL_NO_SENDLEAVESPECIFICATION = 8;
    public static class SendLeaveSpecification extends Message {
        public SendLeaveSpecification( final String p_Name,  final int p_MaximumDays,  final int p_MinimumDays,  final int p_Size ) {
            super(new Object[]{p_Name,  p_MaximumDays,  p_MinimumDays,  p_Size});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_SENDLEAVESPECIFICATION;
        }
 
    }
    public void SendLeaveSpecification( final String p_Name,  final int p_MaximumDays,  final int p_MinimumDays,  final int p_Size ) throws XtumlException;


}
