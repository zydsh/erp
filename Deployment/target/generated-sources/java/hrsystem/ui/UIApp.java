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
    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
        context().Reply( p_msg, p_state );
    }

    public void ReplyNewEmployee( final String p_Username,  final String p_Password ) throws XtumlException {
    }

    public void SendEmployeeBonuses( final String p_BonusName,  final int p_Starting,  final int p_Ending,  final double p_Percent,  final double p_Amount ) throws XtumlException {
        context().SendEmployeeBonuses( p_BonusName, p_Starting, p_Ending, p_Percent, p_Amount );
    }

    public void SendEmployeeMessages( final int p_LeaveRequesterID,  final int p_Starting,  final int p_Ending,  final String p_Content ) throws XtumlException {
        context().SendEmployeeMessages( p_LeaveRequesterID, p_Starting, p_Ending, p_Content );
    }

    public void SendJobList( final int p_JobID,  final String p_Title,  final double p_Salary,  final String p_EmployeeName,  final int p_EmployeeID ) throws XtumlException {
    }

    public void SendLeaveSpecification( final String p_Name,  final int p_MaximumDays,  final int p_MinimumDays,  final int p_Size ) throws XtumlException {
        context().SendLeaveSpecification( p_Name, p_MaximumDays, p_MinimumDays, p_Size );
    }

    public void SendEmployee( final int p_EmployeeID,  final int p_NationalID,  final String p_FirstName,  final String p_MiddleName,  final String p_LastName,  final int p_DateOfBirth,  final String p_Degree,  final String p_Gender,  final int p_StartDate,  final int p_LeaveBalance,  final int p_SickLeaveBalance,  final int p_Size ) throws XtumlException {
        context().SendEmployee( p_EmployeeID, p_NationalID, p_FirstName, p_MiddleName, p_LastName, p_DateOfBirth, p_Degree, p_Gender, p_StartDate, p_LeaveBalance, p_SickLeaveBalance, p_Size );
    }



    // outbound messages
    public void AssignEmployeeBonus( final int p_EmployeeID,  final String p_BonusName,  final int p_Starting,  final int p_Ending ) throws XtumlException {
        if ( satisfied() ) send(new IData.AssignEmployeeBonus(p_EmployeeID, p_BonusName, p_Starting, p_Ending));
        else {
        }
    }
    public void ReadEmployeeMessage( final int p_EmployeeID ) throws XtumlException {
        if ( satisfied() ) send(new IData.ReadEmployeeMessage(p_EmployeeID));
        else {
        }
    }
    public void ReadJobList() throws XtumlException {
        if ( satisfied() ) send(new IData.ReadJobList());
        else {
        }
    }
    public void CreateEmployee( final int p_EmployeeID,  final int p_NationalID,  final String p_FirstName,  final String p_MiddleName,  final String p_LastName,  final int p_DateOfBirth,  final String p_Degree,  final String p_Gender ) throws XtumlException {
        if ( satisfied() ) send(new IData.CreateEmployee(p_EmployeeID, p_NationalID, p_FirstName, p_MiddleName, p_LastName, p_DateOfBirth, p_Degree, p_Gender));
        else {
        }
    }
    public void StopEmployeeBonus( final int p_EmployeeID,  final String p_BonusName ) throws XtumlException {
        if ( satisfied() ) send(new IData.StopEmployeeBonus(p_EmployeeID, p_BonusName));
        else {
        }
    }
    public void Initialize() throws XtumlException {
        if ( satisfied() ) send(new IData.Initialize());
        else {
        }
    }
    public void ReadEmployeeList() throws XtumlException {
        if ( satisfied() ) send(new IData.ReadEmployeeList());
        else {
        }
    }
    public void ReadEmployeeBonuses( final int p_EmployeeID ) throws XtumlException {
        if ( satisfied() ) send(new IData.ReadEmployeeBonuses(p_EmployeeID));
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
    public void ReadLeaveSpecification() throws XtumlException {
        if ( satisfied() ) send(new IData.ReadLeaveSpecification());
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case IData.SIGNAL_NO_REPLY:
                Reply(StringUtil.deserialize(message.get(0)), BooleanUtil.deserialize(message.get(1)));
                break;
            case IData.SIGNAL_NO_REPLYNEWEMPLOYEE:
                ReplyNewEmployee(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)));
                break;
            case IData.SIGNAL_NO_SENDEMPLOYEEBONUSES:
                SendEmployeeBonuses(StringUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)), RealUtil.deserialize(message.get(3)), RealUtil.deserialize(message.get(4)));
                break;
            case IData.SIGNAL_NO_SENDEMPLOYEEMESSAGES:
                SendEmployeeMessages(IntegerUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)));
                break;
            case IData.SIGNAL_NO_SENDJOBLIST:
                SendJobList(IntegerUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), RealUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)), IntegerUtil.deserialize(message.get(4)));
                break;
            case IData.SIGNAL_NO_SENDLEAVESPECIFICATION:
                SendLeaveSpecification(StringUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)), IntegerUtil.deserialize(message.get(3)));
                break;
            case IData.SIGNAL_NO_SENDEMPLOYEE:
                SendEmployee(IntegerUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)), IntegerUtil.deserialize(message.get(5)), StringUtil.deserialize(message.get(6)), StringUtil.deserialize(message.get(7)), IntegerUtil.deserialize(message.get(8)), IntegerUtil.deserialize(message.get(9)), IntegerUtil.deserialize(message.get(10)), IntegerUtil.deserialize(message.get(11)));
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
