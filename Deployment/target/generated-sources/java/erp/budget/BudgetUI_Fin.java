package erp.budget;


import erp.Budget;
import erp.budget.main.impl.BudgetImpl;
import erp.budget.main.impl.ChapterImpl;
import erp.budget.main.impl.ItemImpl;
import erp.budget.main.impl.SectionImpl;

import interfaces.ICRUD;

import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.interfaces.IMessage;
import io.ciera.runtime.summit.interfaces.IPort;
import io.ciera.runtime.summit.interfaces.Port;
import io.ciera.runtime.summit.types.IntegerUtil;
import io.ciera.runtime.summit.types.RealUtil;
import io.ciera.runtime.summit.types.StringUtil;


public class BudgetUI_Fin extends Port<Budget> implements ICRUD {

    public BudgetUI_Fin( Budget context, IPort<?> peer ) {
        super( context, peer );
    }

    // inbound messages
    public void Item( final double p_Fund,  final String p_Status,  final String p_Type,  final String p_Category,  final String p_ID,  final String p_Section_ID,  final String p_Action ) throws XtumlException {
        new ItemImpl.CLASS(context()).crud( p_Fund, p_Status, p_Type, p_Category, p_Action, p_ID, p_Section_ID );
    }

    public void Budget( final String p_Year,  final double p_Fund,  final String p_Action ) throws XtumlException {
        new BudgetImpl.CLASS(context()).crud( p_Year, p_Fund, p_Action );
    }

    public void Section( final String p_Name,  final String p_ID,  final double p_Fund,  final String p_Economic_Category,  final String p_Comments,  final String p_Year,  final String p_Action,  final int p_Code ) throws XtumlException {
        new SectionImpl.CLASS(context()).crud( p_Code, p_Name, p_Fund, p_Economic_Category, p_Comments, p_Action, p_Year, p_ID );
    }

    public void Chapter( final String p_Name,  final int p_Code,  final double p_Ceiling_Fund,  final double p_Request_Fund,  final double p_Fund,  final String p_Action,  final String p_Year ) throws XtumlException {
        new ChapterImpl.CLASS(context()).crud( p_Name, p_Code, p_Ceiling_Fund, p_Request_Fund, p_Fund, p_Year, p_Action );
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
            case ICRUD.SIGNAL_NO_ITEM:
                Item(RealUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)), StringUtil.deserialize(message.get(5)), StringUtil.deserialize(message.get(6)));
                break;
            case ICRUD.SIGNAL_NO_BUDGET:
                Budget(StringUtil.deserialize(message.get(0)), RealUtil.deserialize(message.get(1)), StringUtil.deserialize(message.get(2)));
                break;
            case ICRUD.SIGNAL_NO_SECTION:
                Section(StringUtil.deserialize(message.get(0)), StringUtil.deserialize(message.get(1)), RealUtil.deserialize(message.get(2)), StringUtil.deserialize(message.get(3)), StringUtil.deserialize(message.get(4)), StringUtil.deserialize(message.get(5)), StringUtil.deserialize(message.get(6)), IntegerUtil.deserialize(message.get(7)));
                break;
            case ICRUD.SIGNAL_NO_CHAPTER:
                Chapter(StringUtil.deserialize(message.get(0)), IntegerUtil.deserialize(message.get(1)), RealUtil.deserialize(message.get(2)), RealUtil.deserialize(message.get(3)), RealUtil.deserialize(message.get(4)), StringUtil.deserialize(message.get(5)), StringUtil.deserialize(message.get(6)));
                break;
        default:
            throw new BadArgumentException( "Message not implemented by this port." );
        }
    }



    @Override
    public String getName() {
        return "UI_Fin";
    }

}
