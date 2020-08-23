package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Leave;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.LeaveImpl;

import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.statemachine.EventHandle;
import io.ciera.runtime.summit.statemachine.ITransition;
import io.ciera.runtime.summit.statemachine.StateMachine;


public class LeaveStateMachine extends StateMachine<Leave,Hr> {

    public static final int Approved = 1;
    public static final int AwaitingApproval = 0;
    public static final int EndLeave = 2;
    public static final int Rejected = 3;
    public static final int StartLeave = 4;


    private Leave self;

    public LeaveStateMachine(Leave self, Hr context) {
        this(self, context, AwaitingApproval);
    }

    public LeaveStateMachine(Leave self, Hr context, int initialState) {
        super(context, initialState);
        this.self = self;
    }

    private void Approved_entry_action() throws XtumlException {
        context().LOG().LogInfo( "Employee leave approved" );
        context().LOG().LogInfo( "Leave started timer for future leave " );
        int timeUntilLeaveStarts = self().getStarting() - context().TIM().current_seconds();
        EventHandle StartLeave = new LeaveImpl.StartLeave(getRunContext(), context().getId()).toSelf(self());
        context().TIM().timer_start( StartLeave, timeUntilLeaveStarts );
    }

    private void AwaitingApproval_entry_action() throws XtumlException {
    }

    private void EndLeave_entry_action() throws XtumlException {
        Employee employee = self().R5_is_currently_taken_by_Employee();
        context().relate_R2_Leave_is_consumed_by_a_Employee( self(), employee );
        context().unrelate_R5_Employee_is_taking_a_Leave( employee, self() );
        context().generate(new EmployeeImpl.LeaveEnded(getRunContext(), context().getId()).to(employee));
        context().LOG().LogInfo( "Employee leave ended" );
    }

    private void Rejected_entry_action() throws XtumlException {
        context().LOG().LogInfo( "Employee leave rejected" );
        Employee employee = self().R7_to_be_taken_by_Employee();
        context().unrelate_R7_Leave_to_be_taken_by_Employee( self(), employee );
        self().delete();
    }

    private void StartLeave_entry_action() throws XtumlException {
        Employee employee = self().R7_to_be_taken_by_Employee();
        context().relate_R5_Employee_is_taking_a_Leave( employee, self() );
        context().unrelate_R7_Leave_to_be_taken_by_Employee( self(), employee );
        context().generate(new EmployeeImpl.LeaveStarted(getRunContext(), context().getId()).to(employee));
        context().LOG().LogInfo( "Employee leave started" );
        int timeUntilLeaveEnds = self().getEnding() - context().TIM().current_seconds();
        EventHandle EndLeave = new LeaveImpl.EndLeave(getRunContext(), context().getId()).toSelf(self());
        context().TIM().timer_start( EndLeave, timeUntilLeaveEnds );
    }



    private void Approved_StartLeave_txn_to_StartLeave_action() throws XtumlException {
    }

    private void AwaitingApproval_Approve_txn_to_Approved_action() throws XtumlException {
    }

    private void AwaitingApproval_Reject_txn_to_Rejected_action() throws XtumlException {
    }

    private void StartLeave_EndLeave_txn_to_EndLeave_action() throws XtumlException {
    }



    @Override
    public ITransition[][] getStateEventMatrix() {
        return new ITransition[][] {
            { (event) -> {AwaitingApproval_Reject_txn_to_Rejected_action();Rejected_entry_action();return Rejected;},
              (event) -> {AwaitingApproval_Approve_txn_to_Approved_action();Approved_entry_action();return Approved;},
              CANT_HAPPEN,
              CANT_HAPPEN
            },
            { CANT_HAPPEN,
              CANT_HAPPEN,
              (event) -> {Approved_StartLeave_txn_to_StartLeave_action();StartLeave_entry_action();return StartLeave;},
              CANT_HAPPEN
            },
            { CANT_HAPPEN,
              CANT_HAPPEN,
              CANT_HAPPEN,
              CANT_HAPPEN
            },
            { CANT_HAPPEN,
              CANT_HAPPEN,
              CANT_HAPPEN,
              CANT_HAPPEN
            },
            { CANT_HAPPEN,
              CANT_HAPPEN,
              CANT_HAPPEN,
              (event) -> {StartLeave_EndLeave_txn_to_EndLeave_action();EndLeave_entry_action();return EndLeave;}
            }
        };
    }

    @Override
    public Leave self() {
        return self;
    }

    @Override
    public String getClassName() {
        return "Leave";
    }

}
