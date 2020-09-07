package interfaces;


import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.Message;


public interface IData {

    // to provider messages
    public static final int SIGNAL_NO_ASSIGNEMPLOYEEBONUS = 1;
    public static class AssignEmployeeBonus extends Message {
        public AssignEmployeeBonus( final int p_EmployeeID,  final String p_BonusName,  final int p_Starting,  final int p_Ending ) {
            super(new Object[]{p_EmployeeID,  p_BonusName,  p_Starting,  p_Ending});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_ASSIGNEMPLOYEEBONUS;
        }
 
    }
    public void AssignEmployeeBonus( final int p_EmployeeID,  final String p_BonusName,  final int p_Starting,  final int p_Ending ) throws XtumlException;
    public static final int SIGNAL_NO_CREATEEMPLOYEE = 2;
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
    public static final int SIGNAL_NO_CREATELEAVESPECIFICATION = 3;
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
    public static final int SIGNAL_NO_DELETELEAVESPECIFICATION = 4;
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
    public static final int SIGNAL_NO_GETEMPLOYEE = 5;
    public static class GetEmployee extends Message {
        public GetEmployee( final int p_EmployeeID ) {
            super(new Object[]{p_EmployeeID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_GETEMPLOYEE;
        }
 
    }
    public void GetEmployee( final int p_EmployeeID ) throws XtumlException;
    public static final int SIGNAL_NO_GETSALARYSTRUCTURE = 6;
    public static class GetSalaryStructure extends Message {
        public GetSalaryStructure( final int p_EmployeeID ) {
            super(new Object[]{p_EmployeeID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_GETSALARYSTRUCTURE;
        }
 
    }
    public void GetSalaryStructure( final int p_EmployeeID ) throws XtumlException;
    public static final int SIGNAL_NO_INITIALIZE = 7;
    public static class Initialize extends Message {
        @Override
        public int getId() {
            return SIGNAL_NO_INITIALIZE;
        }
 
    }
    public void Initialize() throws XtumlException;
    public static final int SIGNAL_NO_READBONUSLIST = 8;
    public static class ReadBonusList extends Message {
        @Override
        public int getId() {
            return SIGNAL_NO_READBONUSLIST;
        }
 
    }
    public void ReadBonusList() throws XtumlException;
    public static final int SIGNAL_NO_READDEPARTMENTLIST = 9;
    public static class ReadDepartmentList extends Message {
        @Override
        public int getId() {
            return SIGNAL_NO_READDEPARTMENTLIST;
        }
 
    }
    public void ReadDepartmentList() throws XtumlException;
    public static final int SIGNAL_NO_READEMPLOYEEBONUSES = 10;
    public static class ReadEmployeeBonuses extends Message {
        public ReadEmployeeBonuses( final int p_EmployeeID ) {
            super(new Object[]{p_EmployeeID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_READEMPLOYEEBONUSES;
        }
 
    }
    public void ReadEmployeeBonuses( final int p_EmployeeID ) throws XtumlException;
    public static final int SIGNAL_NO_READEMPLOYEELIST = 11;
    public static class ReadEmployeeList extends Message {
        @Override
        public int getId() {
            return SIGNAL_NO_READEMPLOYEELIST;
        }
 
    }
    public void ReadEmployeeList() throws XtumlException;
    public static final int SIGNAL_NO_READEMPLOYEEMESSAGE = 12;
    public static class ReadEmployeeMessage extends Message {
        public ReadEmployeeMessage( final int p_EmployeeID ) {
            super(new Object[]{p_EmployeeID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_READEMPLOYEEMESSAGE;
        }
 
    }
    public void ReadEmployeeMessage( final int p_EmployeeID ) throws XtumlException;
    public static final int SIGNAL_NO_READGRADES = 13;
    public static class ReadGrades extends Message {
        public ReadGrades( final String p_Name ) {
            super(new Object[]{p_Name});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_READGRADES;
        }
 
    }
    public void ReadGrades( final String p_Name ) throws XtumlException;
    public static final int SIGNAL_NO_READJOBLIST = 14;
    public static class ReadJobList extends Message {
        @Override
        public int getId() {
            return SIGNAL_NO_READJOBLIST;
        }
 
    }
    public void ReadJobList() throws XtumlException;
    public static final int SIGNAL_NO_READLEAVESPECIFICATION = 15;
    public static class ReadLeaveSpecification extends Message {
        @Override
        public int getId() {
            return SIGNAL_NO_READLEAVESPECIFICATION;
        }
 
    }
    public void ReadLeaveSpecification() throws XtumlException;
    public static final int SIGNAL_NO_READSCALES = 16;
    public static class ReadScales extends Message {
        @Override
        public int getId() {
            return SIGNAL_NO_READSCALES;
        }
 
    }
    public void ReadScales() throws XtumlException;
    public static final int SIGNAL_NO_STOPEMPLOYEEBONUS = 29;
    public static class StopEmployeeBonus extends Message {
        public StopEmployeeBonus( final int p_EmployeeID,  final String p_BonusName ) {
            super(new Object[]{p_EmployeeID,  p_BonusName});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_STOPEMPLOYEEBONUS;
        }
 
    }
    public void StopEmployeeBonus( final int p_EmployeeID,  final String p_BonusName ) throws XtumlException;


    // from provider messages
    public static final int SIGNAL_NO_REPLY = 17;
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
    public static final int SIGNAL_NO_REPLYNEWEMPLOYEE = 18;
    public static class ReplyNewEmployee extends Message {
        public ReplyNewEmployee( final String p_Username,  final String p_Password ) {
            super(new Object[]{p_Username,  p_Password});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_REPLYNEWEMPLOYEE;
        }
 
    }
    public void ReplyNewEmployee( final String p_Username,  final String p_Password ) throws XtumlException;
    public static final int SIGNAL_NO_SENDBONUSLIST = 19;
    public static class SendBonusList extends Message {
        public SendBonusList( final String p_Name,  final double p_Percent ) {
            super(new Object[]{p_Name,  p_Percent});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_SENDBONUSLIST;
        }
 
    }
    public void SendBonusList( final String p_Name,  final double p_Percent ) throws XtumlException;
    public static final int SIGNAL_NO_SENDDEPARTMENTLIST = 20;
    public static class SendDepartmentList extends Message {
        public SendDepartmentList( final String p_Name,  final String p_Mission,  final String p_Description,  final String p_Manager,  final String p_ManagingDepartment ) {
            super(new Object[]{p_Name,  p_Mission,  p_Description,  p_Manager,  p_ManagingDepartment});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_SENDDEPARTMENTLIST;
        }
 
    }
    public void SendDepartmentList( final String p_Name,  final String p_Mission,  final String p_Description,  final String p_Manager,  final String p_ManagingDepartment ) throws XtumlException;
    public static final int SIGNAL_NO_SENDEMPLOYEE = 21;
    public static class SendEmployee extends Message {
        public SendEmployee( final int p_EmployeeID,  final int p_NationalID,  final String p_FirstName,  final String p_MiddleName,  final String p_LastName,  final String p_Email,  final String p_OfficePhone,  final int p_DateOfBirth,  final String p_Degree,  final String p_Gender,  final int p_StartDate,  final int p_LeaveBalance,  final int p_SickLeaveBalance,  final double p_Salary ) {
            super(new Object[]{p_EmployeeID,  p_NationalID,  p_FirstName,  p_MiddleName,  p_LastName,  p_Email,  p_OfficePhone,  p_DateOfBirth,  p_Degree,  p_Gender,  p_StartDate,  p_LeaveBalance,  p_SickLeaveBalance,  p_Salary});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_SENDEMPLOYEE;
        }
 
    }
    public void SendEmployee( final int p_EmployeeID,  final int p_NationalID,  final String p_FirstName,  final String p_MiddleName,  final String p_LastName,  final String p_Email,  final String p_OfficePhone,  final int p_DateOfBirth,  final String p_Degree,  final String p_Gender,  final int p_StartDate,  final int p_LeaveBalance,  final int p_SickLeaveBalance,  final double p_Salary ) throws XtumlException;
    public static final int SIGNAL_NO_SENDEMPLOYEEBONUSES = 22;
    public static class SendEmployeeBonuses extends Message {
        public SendEmployeeBonuses( final String p_BonusName,  final int p_Starting,  final int p_Ending,  final double p_Percent,  final double p_Amount ) {
            super(new Object[]{p_BonusName,  p_Starting,  p_Ending,  p_Percent,  p_Amount});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_SENDEMPLOYEEBONUSES;
        }
 
    }
    public void SendEmployeeBonuses( final String p_BonusName,  final int p_Starting,  final int p_Ending,  final double p_Percent,  final double p_Amount ) throws XtumlException;
    public static final int SIGNAL_NO_SENDEMPLOYEEMESSAGES = 23;
    public static class SendEmployeeMessages extends Message {
        public SendEmployeeMessages( final int p_LeaveRequesterID,  final int p_Starting,  final int p_Ending,  final String p_Content ) {
            super(new Object[]{p_LeaveRequesterID,  p_Starting,  p_Ending,  p_Content});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_SENDEMPLOYEEMESSAGES;
        }
 
    }
    public void SendEmployeeMessages( final int p_LeaveRequesterID,  final int p_Starting,  final int p_Ending,  final String p_Content ) throws XtumlException;
    public static final int SIGNAL_NO_SENDGRADES = 24;
    public static class SendGrades extends Message {
        public SendGrades( final String p_Name,  final double p_BaseSalary,  final double p_Allowance,  final int p_NumberOfSteps,  final String p_Above,  final String p_Below ) {
            super(new Object[]{p_Name,  p_BaseSalary,  p_Allowance,  p_NumberOfSteps,  p_Above,  p_Below});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_SENDGRADES;
        }
 
    }
    public void SendGrades( final String p_Name,  final double p_BaseSalary,  final double p_Allowance,  final int p_NumberOfSteps,  final String p_Above,  final String p_Below ) throws XtumlException;
    public static final int SIGNAL_NO_SENDJOBLIST = 25;
    public static class SendJobList extends Message {
        public SendJobList( final int p_JobID,  final String p_Title,  final double p_Salary,  final String p_EmployeeName,  final int p_EmployeeID ) {
            super(new Object[]{p_JobID,  p_Title,  p_Salary,  p_EmployeeName,  p_EmployeeID});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_SENDJOBLIST;
        }
 
    }
    public void SendJobList( final int p_JobID,  final String p_Title,  final double p_Salary,  final String p_EmployeeName,  final int p_EmployeeID ) throws XtumlException;
    public static final int SIGNAL_NO_SENDLEAVESPECIFICATION = 26;
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
    public static final int SIGNAL_NO_SENDSALARYSTRUCTURE = 27;
    public static class SendSalaryStructure extends Message {
        public SendSalaryStructure( final double p_EmployeeSalary,  final String p_BonusName,  final double p_BonusAmount ) {
            super(new Object[]{p_EmployeeSalary,  p_BonusName,  p_BonusAmount});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_SENDSALARYSTRUCTURE;
        }
 
    }
    public void SendSalaryStructure( final double p_EmployeeSalary,  final String p_BonusName,  final double p_BonusAmount ) throws XtumlException;
    public static final int SIGNAL_NO_SENDSCALES = 28;
    public static class SendScales extends Message {
        public SendScales( final String p_Name,  final String p_Description ) {
            super(new Object[]{p_Name,  p_Description});
        }
        @Override
        public int getId() {
            return SIGNAL_NO_SENDSCALES;
        }
 
    }
    public void SendScales( final String p_Name,  final String p_Description ) throws XtumlException;


}
