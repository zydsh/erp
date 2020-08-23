package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;

import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.statemachine.ITransition;
import io.ciera.runtime.summit.statemachine.StateMachine;


public class EmployeeStateMachine extends StateMachine<Employee,Hr> {

    public static final int On_Leave = 1;
    public static final int Recruited = 0;
    public static final int Working = 2;


    private Employee self;

    public EmployeeStateMachine(Employee self, Hr context) {
        this(self, context, Recruited);
    }

    public EmployeeStateMachine(Employee self, Hr context, int initialState) {
        super(context, initialState);
        this.self = self;
    }

    private void On_Leave_entry_action() throws XtumlException {
        context().LOG().LogInfo( ( ( ( "Employee:" + self().getFirstName() ) + " " ) + self().getLastName() ) + " is currently on leave" );
    }

    private void Recruited_entry_action() throws XtumlException {
        context().LOG().LogInfo( "Waiting for employee to commence." );
    }

    private void Working_entry_action() throws XtumlException {
        context().LOG().LogInfo( ( ( ( "Employee:" + self().getFirstName() ) + " " ) + self().getLastName() ) + " is currently working" );
    }



    private void On_Leave_LeaveEnded_txn_to_Working_action() throws XtumlException {
    }

    private void Recruited_commenced_txn_to_Working_action() throws XtumlException {
    }

    private void Working_LeaveStarted_txn_to_On_Leave_action() throws XtumlException {
    }



    @Override
    public ITransition[][] getStateEventMatrix() {
        return new ITransition[][] {
            { CANT_HAPPEN,
              (event) -> {Recruited_commenced_txn_to_Working_action();Working_entry_action();return Working;},
              CANT_HAPPEN,
              CANT_HAPPEN,
              CANT_HAPPEN,
              CANT_HAPPEN
            },
            { CANT_HAPPEN,
              CANT_HAPPEN,
              CANT_HAPPEN,
              (event) -> {On_Leave_LeaveEnded_txn_to_Working_action();Working_entry_action();return Working;},
              CANT_HAPPEN,
              CANT_HAPPEN
            },
            { CANT_HAPPEN,
              CANT_HAPPEN,
              (event) -> {Working_LeaveStarted_txn_to_On_Leave_action();On_Leave_entry_action();return On_Leave;},
              CANT_HAPPEN,
              CANT_HAPPEN,
              CANT_HAPPEN
            }
        };
    }

    @Override
    public Employee self() {
        return self;
    }

    @Override
    public String getClassName() {
        return "Employee";
    }

}
