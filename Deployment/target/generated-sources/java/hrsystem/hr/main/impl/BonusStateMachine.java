package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus;

import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.statemachine.ITransition;
import io.ciera.runtime.summit.statemachine.StateMachine;


public class BonusStateMachine extends StateMachine<Bonus,Hr> {

    public static final int Active = 0;
    public static final int Inactive = 1;
    public static final int Resume = 2;


    private Bonus self;

    public BonusStateMachine(Bonus self, Hr context) {
        this(self, context, Active);
    }

    public BonusStateMachine(Bonus self, Hr context, int initialState) {
        super(context, initialState);
        this.self = self;
    }

    private void Active_entry_action() throws XtumlException {
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
              (event) -> {Active_payBonus_txn_to_Active_action();Active_entry_action();return Active;},
              (event) -> {Active_deactivateBonus_txn_to_Inactive_action();Inactive_entry_action();return Inactive;}
            },
            { (event) -> {Inactive_resumeBonus_txn_to_Resume_action((int)event.get(0),  (int)event.get(1));Resume_entry_action((int)event.get(0),  (int)event.get(1));return Resume;},
              CANT_HAPPEN,
              CANT_HAPPEN
            },
            { CANT_HAPPEN,
              (event) -> {Resume_payBonus_txn_to_Active_action();Active_entry_action();return Active;},
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
