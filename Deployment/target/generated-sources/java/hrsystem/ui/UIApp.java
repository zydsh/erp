package hrsystem.ui;


import hrsystem.UI;

import interfaces.IData;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.BooleanUtil;
import io.ciera.runtime.summit.types.IntegerUtil;
import io.ciera.runtime.summit.types.RealUtil;
import io.ciera.runtime.summit.types.StringUtil;


public class UIApp extends Port<UI> implements IData {

    public UIApp( UI context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void SendLeaveSpecification( final String p_Name,  final int p_MaximumDays,  final int p_MinimumDays,  final int p_Size ) throws XtumlException {
        context().SendLeaveSpecification( p_Name, p_MaximumDays, p_MinimumDays, p_Size );
    }

    public void SendDepartmentList( final String p_Name,  final String p_Mission,  final String p_Description,  final String p_Manager,  final String p_ManagingDepartment ) throws XtumlException {
        context().SendDepartmentList( p_Name, p_Mission, p_Description, p_Manager, p_ManagingDepartment );
    }

    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
        context().Reply( p_msg, p_state );
    }

    public void SendSalaryStructure( final double p_EmployeeSalary,  final String p_BonusName,  final double p_BonusAmount ) throws XtumlException {
        context().SendSalaryStructure( p_EmployeeSalary, p_BonusName, p_BonusAmount );
    }

    public void SendJobList( final int p_JobID,  final String p_Title,  final double p_Salary,  final String p_EmployeeName,  final int p_EmployeeID ) throws XtumlException {
        context().SendJobList( p_JobID, p_Title, p_Salary, p_EmployeeName, p_EmployeeID );
    }

    public void SendEmployeeBonuses( final String p_BonusName,  final int p_Starting,  final int p_Ending,  final double p_Percent,  final double p_Amount ) throws XtumlException {
        context().SendEmployeeBonuses( p_BonusName, p_Starting, p_Ending, p_Percent, p_Amount );
    }

    public void SendScales( final String p_Name,  final String p_Description ) throws XtumlException {
        context().SendScales( p_Name, p_Description );
    }

    public void ReplyNewEmployee( final String p_Username,  final String p_Password ) throws XtumlException {
    }

    public void SendEmployee( final int p_EmployeeID,  final int p_NationalID,  final String p_FirstName,  final String p_MiddleName,  final String p_LastName,  final String p_Email,  final String p_OfficePhone,  final int p_DateOfBirth,  final String p_Degree,  final String p_Gender,  final int p_StartDate,  final int p_LeaveBalance,  final int p_SickLeaveBalance,  final double p_Salary ) throws XtumlException {
        context().SendEmployee( p_EmployeeID, p_NationalID, p_FirstName, p_MiddleName, p_LastName, p_Email, p_OfficePhone, p_DateOfBirth, p_Degree, p_Gender, p_StartDate, p_LeaveBalance, p_SickLeaveBalance, p_Salary );
    }

    public void SendEmployeeMessages( final int p_LeaveRequesterID,  final int p_Starting,  final int p_Ending,  final String p_Content ) throws XtumlException {
        context().SendEmployeeMessages( p_LeaveRequesterID, p_Starting, p_Ending, p_Content );
    }

    public void SendBonusList( final String p_Name,  final double p_Percent ) throws XtumlException {
        context().SendBonusList( p_Name, p_Percent );
    }

    public void SendGrades( final String p_Name,  final double p_BaseSalary,  final double p_Allowance,  final int p_NumberOfSteps,  final String p_Above,  final String p_Below ) throws XtumlException {
        context().SendGrades( p_Name, p_BaseSalary, p_Allowance, p_NumberOfSteps, p_Above, p_Below );
    }



    // outbound messages
    public void CreateEmployee( final int p_EmployeeID,  final int p_NationalID,  final String p_FirstName,  final String p_MiddleName,  final String p_LastName,  final int p_DateOfBirth,  final String p_Degree,  final String p_Gender ) throws XtumlException {
        if ( satisfied() ) send(new IData.CreateEmployee(p_EmployeeID, p_NationalID, p_FirstName, p_MiddleName, p_LastName, p_DateOfBirth, p_Degree, p_Gender));
        else {
        }
    }
    public void ReadBonusList() throws XtumlException {
        if ( satisfied() ) send(new IData.ReadBonusList());
        else {
        }
    }
    public void ReadScales() throws XtumlException {
        if ( satisfied() ) send(new IData.ReadScales());
        else {
        }
    }
    public void ReadGrades( final String p_Name ) throws XtumlException {
        if ( satisfied() ) send(new IData.ReadGrades(p_Name));
        else {
        }
    }
    public void ReadEmployeeMessage( final int p_EmployeeID ) throws XtumlException {
        if ( satisfied() ) send(new IData.ReadEmployeeMessage(p_EmployeeID));
        else {
        }
    }
    public void ReadEmployeeBonuses( final int p_EmployeeID ) throws XtumlException {
        if ( satisfied() ) send(new IData.ReadEmployeeBonuses(p_EmployeeID));
        else {
        }
    }
    public void GetSalaryStructure( final int p_EmployeeID ) throws XtumlException {
        if ( satisfied() ) send(new IData.GetSalaryStructure(p_EmployeeID));
        else {
        }
    }
    public void ReadEmployeeList() throws XtumlException {
        if ( satisfied() ) send(new IData.ReadEmployeeList());
        else {
        }
    }
    public void AssignEmployeeBonus( final int p_EmployeeID,  final String p_BonusName,  final int p_Starting,  final int p_Ending ) throws XtumlException {
        if ( satisfied() ) send(new IData.AssignEmployeeBonus(p_EmployeeID, p_BonusName, p_Starting, p_Ending));
        else {
        }
    }
    public void ReadJobList() throws XtumlException {
        if ( satisfied() ) send(new IData.ReadJobList());
        else {
        }
    }
    public void StopEmployeeBonus( final int p_EmployeeID,  final String p_BonusName ) throws XtumlException {
        if ( satisfied() ) send(new IData.StopEmployeeBonus(p_EmployeeID, p_BonusName));
        else {
        }
    }
    public void ReadDepartmentList() throws XtumlException {
        if ( satisfied() ) send(new IData.ReadDepartmentList());
        else {
        }
    }
    public void GetEmployee( final int p_EmployeeID ) throws XtumlException {
        if ( satisfied() ) send(new IData.GetEmployee(p_EmployeeID));
        else {
        }
    }
    public void Initialize() throws XtumlException {
        if ( satisfied() ) send(new IData.Initialize());
        else {
        }
    }
    public void ReadLeaveSpecification() throws XtumlException {
        if ( satisfied() ) send(new IData.ReadLeaveSpecification());
        else {
        }
    }
    public void DeleteLeaveSpecification( final String p_Name ) throws XtumlException {
        if ( satisfied() ) send(new IData.DeleteLeaveSpecification(p_Name));
        else {
        }
    }
    public void CreateLeaveSpecification( final String p_Name,  final int p_MaximumDays,  final int p_MinimumDays ) throws XtumlException {
        if ( satisfied() ) send(new IData.CreateLeaveSpecification(p_Name, p_MaximumDays, p_MinimumDays));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IData.SIGNAL_NO_SENDLEAVESPECIFICATION:
                SendLeaveSpecification(StringUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)), IntegerUtil.deserialize(message.get(3)));
                break;
            case IData.SIGNAL_NO_SENDDEPARTMENTLIST:
                SendDepartmentList(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)));
                break;
            case IData.SIGNAL_NO_REPLY:
                Reply(StringUtil.deserialize(message.get(0)), BooleanUtil.deserialize(message.get(1)));
                break;
            case IData.SIGNAL_NO_SENDSALARYSTRUCTURE:
                SendSalaryStructure(RealUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), RealUtil.deserialize(message.get(2)));
                break;
            case IData.SIGNAL_NO_SENDJOBLIST:
                SendJobList(IntegerUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), RealUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)), IntegerUtil.deserialize(message.get(4)));
                break;
            case IData.SIGNAL_NO_SENDEMPLOYEEBONUSES:
                SendEmployeeBonuses(StringUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)), RealUtil.deserialize(message.get(3)), RealUtil.deserialize(message.get(4)));
                break;
            case IData.SIGNAL_NO_SENDSCALES:
                SendScales(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)));
                break;
            case IData.SIGNAL_NO_REPLYNEWEMPLOYEE:
                ReplyNewEmployee(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)));
                break;
            case IData.SIGNAL_NO_SENDEMPLOYEE:
                SendEmployee(IntegerUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)), StringUtil.deserialize(message.get(5)), StringUtil.deserialize(message.get(6)), IntegerUtil.deserialize(message.get(7)), StringUtil.deserialize(message.get(8)), StringUtil.deserialize(message.get(9)), IntegerUtil.deserialize(message.get(10)), IntegerUtil.deserialize(message.get(11)), IntegerUtil.deserialize(message.get(12)), RealUtil.deserialize(message.get(13)));
                break;
            case IData.SIGNAL_NO_SENDEMPLOYEEMESSAGES:
                SendEmployeeMessages(IntegerUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)));
                break;
            case IData.SIGNAL_NO_SENDBONUSLIST:
                SendBonusList(StringUtil.deserialize(message.get(0)), RealUtil.deserialize(message.get(1)));
                break;
            case IData.SIGNAL_NO_SENDGRADES:
                SendGrades(StringUtil.deserialize(message.get(0)), RealUtil.deserialize(message.get(1)), RealUtil.deserialize(message.get(2)), IntegerUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)), StringUtil.deserialize(message.get(5)));
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "App";
    }

}
