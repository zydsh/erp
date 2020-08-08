package hrsystem.hr;


import hrsystem.Hr;
import hrsystem.hr.main.impl.BonusImpl;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.GradeImpl;
import hrsystem.hr.main.impl.JobImpl;
import hrsystem.hr.main.impl.LeaveImpl;
import hrsystem.hr.main.impl.StepImpl;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.IntegerUtil;
import io.ciera.runtime.summit.types.RealUtil;
import io.ciera.runtime.summit.types.StringUtil;

import shared.ICRUD;


public class HrUI extends Port<Hr> implements ICRUD {

    public HrUI( Hr context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void Employee( final String p_FName,  final String p_LName,  final int p_National_ID,  final String p_Action ) throws XtumlException {
        new EmployeeImpl.CLASS(context()).crud( p_FName, p_LName, p_National_ID, p_Action );
    }

    public void Job( final int p_Step,  final int p_Grade,  final double p_Amount,  final String p_Name,  final String p_Action ) throws XtumlException {
        new JobImpl.CLASS(context()).crud( p_Step, p_Grade, p_Amount, p_Name, p_Action );
    }

    public void Leave( final String p_Name,  final int p_MaximumDays,  final String p_Action ) throws XtumlException {
        new LeaveImpl.CLASS(context()).crud( p_Name, p_MaximumDays, p_Action );
    }

    public void Payment() throws XtumlException {
    }

    public void Grade( final int p_Value,  final String p_Action ) throws XtumlException {
        new GradeImpl.CLASS(context()).crud( p_Value, p_Action );
    }

    public void Step( final int p_Value,  final String p_Action ) throws XtumlException {
        new StepImpl.CLASS(context()).crud( p_Value, p_Action );
    }

    public void Bonus( final String p_Name,  final double p_Percent,  final String p_Action ) throws XtumlException {
        new BonusImpl.CLASS(context()).crud( p_Name, p_Percent, p_Action );
    }



    // outbound messages
    public void Reply( final String p_msg,  final boolean p_state ) throws XtumlException {
        if ( satisfied() ) send(new ICRUD.Reply(p_msg, p_state));
        else {
        }
    }


    @Override
    public void deliver( IMessage message ) throws XtumlException {
        if ( null == message ) throw new BadArgumentException( "Cannot deliver null message." );
        switch ( message.getId() ) {
            case ICRUD.SIGNAL_NO_EMPLOYEE:
                Employee(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), IntegerUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)));
                break;
            case ICRUD.SIGNAL_NO_JOB:
                Job(IntegerUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), RealUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)));
                break;
            case ICRUD.SIGNAL_NO_LEAVE:
                Leave(StringUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)));
                break;
            case ICRUD.SIGNAL_NO_PAYMENT:
                Payment();
                break;
            case ICRUD.SIGNAL_NO_GRADE:
                Grade(IntegerUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)));
                break;
            case ICRUD.SIGNAL_NO_STEP:
                Step(IntegerUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)));
                break;
            case ICRUD.SIGNAL_NO_BONUS:
                Bonus(StringUtil.deserialize(message.get(0)), RealUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)));
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "UI";
    }

}
