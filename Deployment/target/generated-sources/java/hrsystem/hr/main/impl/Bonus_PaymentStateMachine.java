package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus;
import hrsystem.hr.main.Bonus_Payment;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.impl.Bonus_PaymentImpl;
import hrsystem.hr.main.impl.EmployeeImpl;

import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.statemachine.ITransition;
import io.ciera.runtime.summit.statemachine.StateMachine;


public class Bonus_PaymentStateMachine extends StateMachine<Bonus_Payment,Hr> {

    public static final int Active = 0;
    public static final int Inactive = 1;
    public static final int Resume = 2;


    private Bonus_Payment self;

    public Bonus_PaymentStateMachine(Bonus_Payment self, Hr context) {
        this(self, context, Active);
    }

    public Bonus_PaymentStateMachine(Bonus_Payment self, Hr context, int initialState) {
        super(context, initialState);
        this.self = self;
    }

    private void Active_entry_action() throws XtumlException {
        Employee employee = self().R4_Employee();
        Bonus bonus = self().R4_Bonus();
        int payment_time = context().TIM().current_seconds();
        double bonus_payment = employee.getSalary() * bonus.getPercent();
        self().setAmount(context().getPartialPayment( payment_time, self().getStarting(), self().getEnding(), bonus_payment ));
        if ( context().isLessThanMonth( self().getStarting(), payment_time ) ) {
            new EmployeeImpl.CLASS(context()).createPayment( employee.getNational_ID(), bonus.getName(), self().getAmount(), context().TIM().current_seconds() );
            context().LOG().LogInfo( "Bonus is paid partially because payment started less than a month" );
        }
        else if ( context().isLessThanMonth( payment_time, self().getEnding() ) ) {
            new EmployeeImpl.CLASS(context()).createPayment( employee.getNational_ID(), bonus.getName(), self().getAmount(), context().TIM().current_seconds() );
            context().generate(new Bonus_PaymentImpl.deactivateBonus(getRunContext(), context().getId()).toSelf(self()));
            context().LOG().LogInfo( "Bonus is schedualed for payment" );
            context().LOG().LogInfo( "Bonus stopped because bonus ending date has passed" );
        }
        else if ( payment_time > self().getStarting() && payment_time < self().getEnding() ) {
            new EmployeeImpl.CLASS(context()).createPayment( employee.getNational_ID(), bonus.getName(), self().getAmount(), payment_time );
            context().LOG().LogInfo( "Bonus is schedualed for payment" );
        }
    }

    private void Inactive_entry_action() throws XtumlException {
        context().LOG().LogInfo( "Bonus is now deactivated" );
    }

    private void Resume_entry_action( final int p_Starting,  final int p_Ending ) throws XtumlException {
        self().setStarting(p_Starting);
        self().setEnding(p_Ending);
        context().LOG().LogInfo( "Bonus is updated to new starting and ending times." );
    }



    private void Active_payBonus_txn_to_Active_action() throws XtumlException {
    }

    private void Active_deactivateBonus_txn_to_Inactive_action() throws XtumlException {
    }

    private void Inactive_resumeBonus_txn_to_Resume_action( final int p_Starting,  final int p_Ending ) throws XtumlException {
    }

    private void Resume_payBonus_txn_to_Active_action() throws XtumlException {
    }



    @Override
    public ITransition[][] getStateEventMatrix() {
        return new ITransition[][] {
            { CANT_HAPPEN,
              (event) -> {Active_deactivateBonus_txn_to_Inactive_action();Inactive_entry_action();return Inactive;},
              (event) -> {Active_payBonus_txn_to_Active_action();Active_entry_action();return Active;}
            },
            { (event) -> {Inactive_resumeBonus_txn_to_Resume_action((int)event.get(0),  (int)event.get(1));Resume_entry_action((int)event.get(0),  (int)event.get(1));return Resume;},
              CANT_HAPPEN,
              CANT_HAPPEN
            },
            { CANT_HAPPEN,
              CANT_HAPPEN,
              (event) -> {Resume_payBonus_txn_to_Active_action();Active_entry_action();return Active;}
            }
        };
    }

    @Override
    public Bonus_Payment self() {
        return self;
    }

    @Override
    public String getClassName() {
        return "Bonus_Payment";
    }

}
