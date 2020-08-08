package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Employee_Leave;
import hrsystem.hr.main.Leave;
import hrsystem.hr.main.impl.Employee_LeaveImpl;

import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.statemachine.ITransition;
import io.ciera.runtime.summit.statemachine.StateMachine;
import io.ciera.runtime.summit.types.StringUtil;


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

    private void On_Leave_entry_action( final int p_Starting,  final int p_Ending,  final int p_National_ID,  final String p_Name ) throws XtumlException {
        Employee_Leave assignTo = Employee_LeaveImpl.create( context() );
        Employee employee = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getNational_ID() == p_National_ID);
        Leave leave = context().Leave_instances().anyWhere(selected -> StringUtil.equality(((Leave)selected).getName(), p_Name));
        context().relate_R2_Employee_Leave_Employee( assignTo, employee );
        context().relate_R2_Employee_Leave_Leave( assignTo, leave );
        context().LOG().LogInfo( ( employee.getFName() + " " ) + employee.getLName() );
        assignTo.setStarting(p_Starting);
        assignTo.setEnding(p_Ending);
        context().LOG().LogInfo( ( "Requested" + leave.getName() ) + "leave" );
    }

    private void Recruited_entry_action() throws XtumlException {
        context().LOG().LogInfo( "Waiting for employee to commence." );
    }

    private void Working_entry_action() throws XtumlException {
    }



    private void On_Leave_requestLeave_txn_to_On_Leave_action( final int p_Starting,  final int p_Ending,  final int p_National_ID,  final String p_Name ) throws XtumlException {
    }

    private void On_Leave_returnFromLeave_txn_to_Working_action() throws XtumlException {
    }

    private void Recruited_commenced_txn_to_Working_action() throws XtumlException {
    }

    private void Working_requestLeave_txn_to_On_Leave_action( final int p_Starting,  final int p_Ending,  final int p_National_ID,  final String p_Name ) throws XtumlException {
    }



    @Override
    public ITransition[][] getStateEventMatrix() {
        return new ITransition[][] {
            { CANT_HAPPEN,
              CANT_HAPPEN,
              (event) -> {Recruited_commenced_txn_to_Working_action();Working_entry_action();return Working;},
              CANT_HAPPEN
            },
            { (event) -> {On_Leave_returnFromLeave_txn_to_Working_action();Working_entry_action();return Working;},
              CANT_HAPPEN,
              CANT_HAPPEN,
              (event) -> {On_Leave_requestLeave_txn_to_On_Leave_action((int)event.get(0),  (int)event.get(1),  (int)event.get(2),  (String)event.get(3));On_Leave_entry_action((int)event.get(0),  (int)event.get(1),  (int)event.get(2),  (String)event.get(3));return On_Leave;}
            },
            { CANT_HAPPEN,
              CANT_HAPPEN,
              CANT_HAPPEN,
              (event) -> {Working_requestLeave_txn_to_On_Leave_action((int)event.get(0),  (int)event.get(1),  (int)event.get(2),  (String)event.get(3));On_Leave_entry_action((int)event.get(0),  (int)event.get(1),  (int)event.get(2),  (String)event.get(3));return On_Leave;}
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
