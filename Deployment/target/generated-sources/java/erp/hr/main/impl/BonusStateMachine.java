package erp.hr.main.impl;


import erp.Hr;
import erp.hr.main.Bonus;
import erp.hr.main.BonusSpecification;
import erp.hr.main.Employee;
import erp.hr.main.Job;

import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.statemachine.ITransition;
import io.ciera.runtime.summit.statemachine.StateMachine;


public class BonusStateMachine extends StateMachine<Bonus,Hr> {

    public static final int Active = 0;
    public static final int Inactive = 1;


    private Bonus self;

    public BonusStateMachine(Bonus self, Hr context) {
        this(self, context, Active);
    }

    public BonusStateMachine(Bonus self, Hr context, int initialState) {
        super(context, initialState);
        this.self = self;
    }

    private void Active_entry_action() throws XtumlException {
        Job job = self().R4_is_given_to_an_Employee().R6_currently_occupies_Job();
        BonusSpecification bonus = self().R16_is_specified_by_BonusSpecification();
        self().setAmount(job.getSalary() * bonus.getPercent());
    }

    private void Inactive_entry_action() throws XtumlException {
        Employee employee = self().R4_is_given_to_an_Employee();
        context().unrelate_R4_Bonus_is_given_to_an_Employee( self(), employee );
        context().relate_R19_Bonus_given_in_the_past_Employee( self(), employee );
        context().LOG().LogInfo( "Bonus is now deactivated" );
    }



    private void Active_payBonus_txn_to_Active_action() throws XtumlException {
    }

    private void Active_deactivateBonus_txn_to_Inactive_action() throws XtumlException {
    }



    @Override
    public ITransition[][] getStateEventMatrix() {
        return new ITransition[][] {
            { (event) -> {Active_deactivateBonus_txn_to_Inactive_action();Inactive_entry_action();return Inactive;},
              (event) -> {Active_payBonus_txn_to_Active_action();Active_entry_action();return Active;},
              CANT_HAPPEN
            },
            { CANT_HAPPEN,
              CANT_HAPPEN,
              CANT_HAPPEN
            }
        };
    }

    @Override
    public Bonus self() {
        return self;
    }

    @Override
    public String getClassName() {
        return "Bonus";
    }

}
