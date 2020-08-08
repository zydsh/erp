package hrsystem;


import hrsystem.hr.main.Bonus;
import hrsystem.hr.main.Bonus_Payment;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Employee_Job;
import hrsystem.hr.main.Employee_Leave;
import hrsystem.hr.main.Grade;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.Leave;
import hrsystem.hr.main.Payment;
import hrsystem.hr.main.Step;
import hrsystem.hr.main.impl.BonusImpl;
import hrsystem.hr.main.impl.Bonus_PaymentImpl;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.Employee_JobImpl;
import hrsystem.hr.main.impl.Employee_LeaveImpl;
import hrsystem.hr.main.impl.GradeImpl;
import hrsystem.hr.main.impl.JobImpl;
import hrsystem.hr.main.impl.LeaveImpl;
import hrsystem.hr.main.impl.PaymentImpl;
import hrsystem.hr.main.impl.StepImpl;

import io.ciera.runtime.instanceloading.sql.SqlLoader;
import io.ciera.runtime.summit.classes.InstanceIdentifier;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.statemachine.EventHandle;
import io.ciera.runtime.summit.statemachine.IEvent;
import io.ciera.runtime.summit.time.Timer;
import io.ciera.runtime.summit.time.TimerHandle;
import io.ciera.runtime.summit.types.UniqueId;

import java.io.PrintStream;
import java.util.List;


public class HrSqlLoader extends SqlLoader {

    private Hr population;

    public HrSqlLoader( Hr population ) {
        super(population.getRunContext());
        this.population = population;
    }

    @Override
    public void insert(String tableName, List<Object> values) throws XtumlException {
        switch ( tableName ) {
        case "Leave":
            LeaveImpl.create(population, UniqueId.deserialize(values.get(0)), (int)values.get(1), (String)values.get(2), (int)values.get(3));
            break;
        case "Employee_Leave":
            Employee_LeaveImpl.create(population, UniqueId.deserialize(values.get(0)), (int)values.get(1), (int)values.get(2), (int)values.get(3) == 1 ? true : false, (int)values.get(4), (int)values.get(5));
            break;
        case "Grade":
            GradeImpl.create(population, UniqueId.deserialize(values.get(0)), (int)values.get(1));
            break;
        case "Step":
            StepImpl.create(population, UniqueId.deserialize(values.get(0)), (int)values.get(1));
            break;
        case "Job":
            JobImpl.create(population, UniqueId.deserialize(values.get(0)), (int)values.get(1), (double)values.get(2), (String)values.get(3), (int)values.get(4), (int)values.get(5));
            break;
        case "Payment":
            PaymentImpl.create(population, UniqueId.deserialize(values.get(0)), (String)values.get(1), (double)values.get(2), (int)values.get(3), (int)values.get(4));
            break;
        case "BP":
            Bonus_PaymentImpl.create(population, UniqueId.deserialize(values.get(0)), (int)values.get(1), (int)values.get(2), (double)values.get(3), (int)values.get(4), (int)values.get(5), (int)values.get(6));
            break;
        case "Bonus":
            BonusImpl.create(population, UniqueId.deserialize(values.get(0)), (String)values.get(1), (double)values.get(2));
            break;
        case "EJ":
            Employee_JobImpl.create(population, UniqueId.deserialize(values.get(0)), (int)values.get(1), (int)values.get(2) == 1 ? true : false, (int)values.get(3), (int)values.get(4));
            break;
        case "EM":
            EmployeeImpl.create(population, UniqueId.deserialize(values.get(0)), (int)values.get(1), (String)values.get(2), (String)values.get(3), (int)values.get(4), (int)values.get(5));
            break;
        case "CIERA_TIMER":
            population.getRunContext().addTimer(new Timer(TimerHandle.deserialize(values.get(0)), (int)values.get(1), EventHandle.deserialize(values.get(2)), (long)values.get(3), (int)values.get(4), (int)values.get(5) == 1 ? true : false));
            break;
        case "Bonus_Payment_resumeBonus":
            new BonusImpl.Payment_resumeBonus(population.getRunContext(), (int)values.get(1), (int)values.get(3), (int)values.get(4)).to(EventHandle.deserialize(values.get(0)), population.Bonus_Payment_instances().anyWhere(selected -> selected.getInstanceId().equality(UniqueId.deserialize(values.get(2)))));
            break;
        case "Employee_returnFromLeave":
            new EmployeeImpl.returnFromLeave(population.getRunContext(), (int)values.get(1)).to(EventHandle.deserialize(values.get(0)), population.Employee_instances().anyWhere(selected -> selected.getInstanceId().equality(UniqueId.deserialize(values.get(2)))));
            break;
        case "Employee_employeeUpdateRcvd":
            new EmployeeImpl.employeeUpdateRcvd(population.getRunContext(), (int)values.get(1)).to(EventHandle.deserialize(values.get(0)), population.Employee_instances().anyWhere(selected -> selected.getInstanceId().equality(UniqueId.deserialize(values.get(2)))));
            break;
        case "Employee_requestLeave":
            new EmployeeImpl.requestLeave(population.getRunContext(), (int)values.get(1), (int)values.get(3), (int)values.get(4), (int)values.get(5), (String)values.get(6)).to(EventHandle.deserialize(values.get(0)), population.Employee_instances().anyWhere(selected -> selected.getInstanceId().equality(UniqueId.deserialize(values.get(2)))));
            break;
        case "Employee_commenced":
            new EmployeeImpl.commenced(population.getRunContext(), (int)values.get(1)).to(EventHandle.deserialize(values.get(0)), population.Employee_instances().anyWhere(selected -> selected.getInstanceId().equality(UniqueId.deserialize(values.get(2)))));
            break;
        case "Bonus_Payment_payBonus":
            new BonusImpl.Payment_payBonus(population.getRunContext(), (int)values.get(1)).to(EventHandle.deserialize(values.get(0)), population.Bonus_Payment_instances().anyWhere(selected -> selected.getInstanceId().equality(UniqueId.deserialize(values.get(2)))));
            break;
        case "Bonus_Payment_deactivateBonus":
            new BonusImpl.Payment_deactivateBonus(population.getRunContext(), (int)values.get(1)).to(EventHandle.deserialize(values.get(0)), population.Bonus_Payment_instances().anyWhere(selected -> selected.getInstanceId().equality(UniqueId.deserialize(values.get(2)))));
            break;
        default:
            //throw new XtumlException( "Class not supported by this population." );
            break;
        }
    }

    @Override
    public void batchRelate() throws XtumlException {
        batch_relate_R2_Employee_Leave_Employee();
        batch_relate_R2_Employee_Leave_Leave();
        batch_relate_R1_Employee_Job_Employee();
        batch_relate_R5_Job_Step();
        batch_relate_R1_Employee_Job_Job();
        batch_relate_R3_Payment_Employee();
        batch_relate_R4_Bonus_Payment_Employee();
        batch_relate_R4_Bonus_Payment_Bonus();
        batch_relate_R5_Job_Grade();
    }

    public void batch_relate_R2_Employee_Leave_Employee() throws XtumlException {
        for ( Employee_Leave form : population.Employee_Leave_instances() ) {
            population.relate_R2_Employee_Leave_Employee( form, population.Employee_instances().getById1(new InstanceIdentifier(form.getNational_ID())));
        }
    }
    public void batch_relate_R2_Employee_Leave_Leave() throws XtumlException {
        for ( Employee_Leave form : population.Employee_Leave_instances() ) {
            population.relate_R2_Employee_Leave_Leave( form, population.Leave_instances().getById1(new InstanceIdentifier(form.getLeave_ID())));
        }
    }
    public void batch_relate_R1_Employee_Job_Employee() throws XtumlException {
        for ( Employee_Job form : population.Employee_Job_instances() ) {
            population.relate_R1_Employee_Job_Employee( form, population.Employee_instances().getById1(new InstanceIdentifier(form.getNational_ID())));
        }
    }
    public void batch_relate_R5_Job_Step() throws XtumlException {
        for ( Job form : population.Job_instances() ) {
            population.relate_R5_Job_Step( form, population.Step_instances().getById1(new InstanceIdentifier(form.getSValue())));
        }
    }
    public void batch_relate_R1_Employee_Job_Job() throws XtumlException {
        for ( Employee_Job form : population.Employee_Job_instances() ) {
            population.relate_R1_Employee_Job_Job( form, population.Job_instances().getById1(new InstanceIdentifier(form.getJob_ID())));
        }
    }
    public void batch_relate_R3_Payment_Employee() throws XtumlException {
        for ( Payment form : population.Payment_instances() ) {
            population.relate_R3_Payment_Employee( form, population.Employee_instances().getById1(new InstanceIdentifier(form.getNational_ID())));
        }
    }
    public void batch_relate_R4_Bonus_Payment_Employee() throws XtumlException {
        for ( Bonus_Payment form : population.Bonus_Payment_instances() ) {
            population.relate_R4_Bonus_Payment_Employee( form, population.Employee_instances().getById1(new InstanceIdentifier(form.getNational_ID())));
        }
    }
    public void batch_relate_R4_Bonus_Payment_Bonus() throws XtumlException {
        for ( Bonus_Payment form : population.Bonus_Payment_instances() ) {
            population.relate_R4_Bonus_Payment_Bonus( form, population.Bonus_instances().getById1(new InstanceIdentifier(form.getName())));
        }
    }
    public void batch_relate_R5_Job_Grade() throws XtumlException {
        for ( Job form : population.Job_instances() ) {
            population.relate_R5_Job_Grade( form, population.Grade_instances().getById1(new InstanceIdentifier(form.getGValue())));
        }
    }


    @Override
    public void serialize() throws XtumlException {
        PrintStream out = new PrintStream(getOut());
        for ( Employee employee_inst : population.Employee_instances() ) serialize_Employee( employee_inst, out );
        for ( Employee_Job employee_job_inst : population.Employee_Job_instances() ) serialize_Employee_Job( employee_job_inst, out );
        for ( Step step_inst : population.Step_instances() ) serialize_Step( step_inst, out );
        for ( Job job_inst : population.Job_instances() ) serialize_Job( job_inst, out );
        for ( Payment payment_inst : population.Payment_instances() ) serialize_Payment( payment_inst, out );
        for ( Bonus_Payment bonus_payment_inst : population.Bonus_Payment_instances() ) serialize_Bonus_Payment( bonus_payment_inst, out );
        for ( Bonus bonus_inst : population.Bonus_instances() ) serialize_Bonus( bonus_inst, out );
        for ( Leave leave_inst : population.Leave_instances() ) serialize_Leave( leave_inst, out );
        for ( Employee_Leave employee_leave_inst : population.Employee_Leave_instances() ) serialize_Employee_Leave( employee_leave_inst, out );
        for ( Grade grade_inst : population.Grade_instances() ) serialize_Grade( grade_inst, out );
        for ( Timer ciera_timer_inst : population.getRunContext().getActiveTimers().where(selected -> selected.getPopulationId() == population.getId()) ) serialize_CIERA_TIMER( ciera_timer_inst, out );
        for ( IEvent employee_commenced_inst : population.getRunContext().getActiveEvents().where(selected -> selected instanceof EmployeeImpl.commenced) ) serialize_Employee_commenced( (EmployeeImpl.commenced)employee_commenced_inst, out );
        for ( IEvent employee_employeeupdatercvd_inst : population.getRunContext().getActiveEvents().where(selected -> selected instanceof EmployeeImpl.employeeUpdateRcvd) ) serialize_Employee_employeeUpdateRcvd( (EmployeeImpl.employeeUpdateRcvd)employee_employeeupdatercvd_inst, out );
        for ( IEvent employee_returnfromleave_inst : population.getRunContext().getActiveEvents().where(selected -> selected instanceof EmployeeImpl.returnFromLeave) ) serialize_Employee_returnFromLeave( (EmployeeImpl.returnFromLeave)employee_returnfromleave_inst, out );
        for ( IEvent bonus_payment_paybonus_inst : population.getRunContext().getActiveEvents().where(selected -> selected instanceof BonusImpl.Payment_payBonus) ) serialize_Bonus_Payment_payBonus( (BonusImpl.Payment_payBonus)bonus_payment_paybonus_inst, out );
        for ( IEvent bonus_payment_resumebonus_inst : population.getRunContext().getActiveEvents().where(selected -> selected instanceof BonusImpl.Payment_resumeBonus) ) serialize_Bonus_Payment_resumeBonus( (BonusImpl.Payment_resumeBonus)bonus_payment_resumebonus_inst, out );
        for ( IEvent bonus_payment_deactivatebonus_inst : population.getRunContext().getActiveEvents().where(selected -> selected instanceof BonusImpl.Payment_deactivateBonus) ) serialize_Bonus_Payment_deactivateBonus( (BonusImpl.Payment_deactivateBonus)bonus_payment_deactivatebonus_inst, out );
        for ( IEvent employee_requestleave_inst : population.getRunContext().getActiveEvents().where(selected -> selected instanceof EmployeeImpl.requestLeave) ) serialize_Employee_requestLeave( (EmployeeImpl.requestLeave)employee_requestleave_inst, out );
        out.flush();
    }

    public void serialize_Employee( Employee employee_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO EM VALUES(" );
        out.printf( "'%s'", employee_inst.getInstanceId().serialize() );
        out.print(",");
        out.printf( "%d", employee_inst.getNational_ID() );
        out.print(",");
        out.printf( "'%s'", employee_inst.getFName().replaceAll( "'", "''" ) );
        out.print(",");
        out.printf( "'%s'", employee_inst.getLName().replaceAll( "'", "''" ) );
        out.print(",");
        out.printf( "%d", employee_inst.getStart_Date() );
        out.print(",");
        out.printf( "%d", employee_inst.getCurrentState() );
        out.println( ");" );
    }
    public void serialize_Employee_commenced( EmployeeImpl.commenced employee_commenced_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO Employee_commenced VALUES(" );
        out.printf( "'%s'", employee_commenced_inst.getEventHandle().serialize() );
        out.print(",");
        out.printf( "%d", employee_commenced_inst.getPopulationId() );
        out.print(",");
        out.printf( "'%s'", employee_commenced_inst.getTarget().getInstanceId().serialize() );
        out.println( ");" );
    }
    public void serialize_Employee_employeeUpdateRcvd( EmployeeImpl.employeeUpdateRcvd employee_employeeupdatercvd_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO Employee_employeeUpdateRcvd VALUES(" );
        out.printf( "'%s'", employee_employeeupdatercvd_inst.getEventHandle().serialize() );
        out.print(",");
        out.printf( "%d", employee_employeeupdatercvd_inst.getPopulationId() );
        out.print(",");
        out.printf( "'%s'", employee_employeeupdatercvd_inst.getTarget().getInstanceId().serialize() );
        out.println( ");" );
    }
    public void serialize_CIERA_TIMER( Timer ciera_timer_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO CIERA_TIMER VALUES(" );
        out.printf( "'%s'", ciera_timer_inst.getId().serialize() );
        out.print(",");
        out.printf( "%d", ciera_timer_inst.getPopulationId() );
        out.print(",");
        out.printf( "'%s'", ciera_timer_inst.getEventToGenerate().serialize() );
        out.print(",");
        out.printf( "%d", ciera_timer_inst.getWakeUpTime() );
        out.print(",");
        out.printf( "%d", ciera_timer_inst.getPeriod() );
        out.print(",");
        out.printf( "%d", ciera_timer_inst.isRecurring() ? 1 : 0 );
        out.println( ");" );
    }
    public void serialize_Employee_returnFromLeave( EmployeeImpl.returnFromLeave employee_returnfromleave_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO Employee_returnFromLeave VALUES(" );
        out.printf( "'%s'", employee_returnfromleave_inst.getEventHandle().serialize() );
        out.print(",");
        out.printf( "%d", employee_returnfromleave_inst.getPopulationId() );
        out.print(",");
        out.printf( "'%s'", employee_returnfromleave_inst.getTarget().getInstanceId().serialize() );
        out.println( ");" );
    }
    public void serialize_Bonus_Payment_payBonus( BonusImpl.Payment_payBonus bonus_payment_paybonus_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO Bonus_Payment_payBonus VALUES(" );
        out.printf( "'%s'", bonus_payment_paybonus_inst.getEventHandle().serialize() );
        out.print(",");
        out.printf( "%d", bonus_payment_paybonus_inst.getPopulationId() );
        out.print(",");
        out.printf( "'%s'", bonus_payment_paybonus_inst.getTarget().getInstanceId().serialize() );
        out.println( ");" );
    }
    public void serialize_Employee_Job( Employee_Job employee_job_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO EJ VALUES(" );
        out.printf( "'%s'", employee_job_inst.getInstanceId().serialize() );
        out.print(",");
        out.printf( "%d", employee_job_inst.getAppointment_Date() );
        out.print(",");
        out.printf( "%d", employee_job_inst.getActive() ? 1 : 0 );
        out.print(",");
        out.printf( "%d", employee_job_inst.getJob_ID() );
        out.print(",");
        out.printf( "%d", employee_job_inst.getNational_ID() );
        out.println( ");" );
    }
    public void serialize_Step( Step step_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO Step VALUES(" );
        out.printf( "'%s'", step_inst.getInstanceId().serialize() );
        out.print(",");
        out.printf( "%d", step_inst.getSValue() );
        out.println( ");" );
    }
    public void serialize_Job( Job job_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO Job VALUES(" );
        out.printf( "'%s'", job_inst.getInstanceId().serialize() );
        out.print(",");
        out.printf( "%d", job_inst.getJob_ID() );
        out.print(",");
        out.printf( "%f", job_inst.getAmount() );
        out.print(",");
        out.printf( "'%s'", job_inst.getName().replaceAll( "'", "''" ) );
        out.print(",");
        out.printf( "%d", job_inst.getGValue() );
        out.print(",");
        out.printf( "%d", job_inst.getSValue() );
        out.println( ");" );
    }
    public void serialize_Payment( Payment payment_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO Payment VALUES(" );
        out.printf( "'%s'", payment_inst.getInstanceId().serialize() );
        out.print(",");
        out.printf( "'%s'", payment_inst.getName().replaceAll( "'", "''" ) );
        out.print(",");
        out.printf( "%f", payment_inst.getAmount() );
        out.print(",");
        out.printf( "%d", payment_inst.getDate() );
        out.print(",");
        out.printf( "%d", payment_inst.getNational_ID() );
        out.println( ");" );
    }
    public void serialize_Bonus_Payment( Bonus_Payment bonus_payment_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO BP VALUES(" );
        out.printf( "'%s'", bonus_payment_inst.getInstanceId().serialize() );
        out.print(",");
        out.printf( "%d", bonus_payment_inst.getStarting() );
        out.print(",");
        out.printf( "%d", bonus_payment_inst.getEnding() );
        out.print(",");
        out.printf( "%f", bonus_payment_inst.getAmount() );
        out.print(",");
        out.printf( "%d", bonus_payment_inst.getNational_ID() );
        out.print(",");
        out.printf( "%d", bonus_payment_inst.getName() );
        out.print(",");
        out.printf( "%d", bonus_payment_inst.getCurrentState() );
        out.println( ");" );
    }
    public void serialize_Bonus( Bonus bonus_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO Bonus VALUES(" );
        out.printf( "'%s'", bonus_inst.getInstanceId().serialize() );
        out.print(",");
        out.printf( "'%s'", bonus_inst.getName().replaceAll( "'", "''" ) );
        out.print(",");
        out.printf( "%f", bonus_inst.getPercent() );
        out.println( ");" );
    }
    public void serialize_Leave( Leave leave_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO Leave VALUES(" );
        out.printf( "'%s'", leave_inst.getInstanceId().serialize() );
        out.print(",");
        out.printf( "%d", leave_inst.getLeave_ID() );
        out.print(",");
        out.printf( "'%s'", leave_inst.getName().replaceAll( "'", "''" ) );
        out.print(",");
        out.printf( "%d", leave_inst.getMaximumDays() );
        out.println( ");" );
    }
    public void serialize_Employee_Leave( Employee_Leave employee_leave_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO Employee_Leave VALUES(" );
        out.printf( "'%s'", employee_leave_inst.getInstanceId().serialize() );
        out.print(",");
        out.printf( "%d", employee_leave_inst.getStarting() );
        out.print(",");
        out.printf( "%d", employee_leave_inst.getEnding() );
        out.print(",");
        out.printf( "%d", employee_leave_inst.getApproved() ? 1 : 0 );
        out.print(",");
        out.printf( "%d", employee_leave_inst.getNational_ID() );
        out.print(",");
        out.printf( "%d", employee_leave_inst.getLeave_ID() );
        out.println( ");" );
    }
    public void serialize_Bonus_Payment_resumeBonus( BonusImpl.Payment_resumeBonus bonus_payment_resumebonus_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO Bonus_Payment_resumeBonus VALUES(" );
        out.printf( "'%s'", bonus_payment_resumebonus_inst.getEventHandle().serialize() );
        out.print(",");
        out.printf( "%d", bonus_payment_resumebonus_inst.getPopulationId() );
        out.print(",");
        out.printf( "'%s'", bonus_payment_resumebonus_inst.getTarget().getInstanceId().serialize() );
        out.print(",");
        out.printf( "%d", bonus_payment_resumebonus_inst.get(0) );
        out.print(",");
        out.printf( "%d", bonus_payment_resumebonus_inst.get(1) );
        out.println( ");" );
    }
    public void serialize_Grade( Grade grade_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO Grade VALUES(" );
        out.printf( "'%s'", grade_inst.getInstanceId().serialize() );
        out.print(",");
        out.printf( "%d", grade_inst.getGValue() );
        out.println( ");" );
    }
    public void serialize_Bonus_Payment_deactivateBonus( BonusImpl.Payment_deactivateBonus bonus_payment_deactivatebonus_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO Bonus_Payment_deactivateBonus VALUES(" );
        out.printf( "'%s'", bonus_payment_deactivatebonus_inst.getEventHandle().serialize() );
        out.print(",");
        out.printf( "%d", bonus_payment_deactivatebonus_inst.getPopulationId() );
        out.print(",");
        out.printf( "'%s'", bonus_payment_deactivatebonus_inst.getTarget().getInstanceId().serialize() );
        out.println( ");" );
    }
    public void serialize_Employee_requestLeave( EmployeeImpl.requestLeave employee_requestleave_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO Employee_requestLeave VALUES(" );
        out.printf( "'%s'", employee_requestleave_inst.getEventHandle().serialize() );
        out.print(",");
        out.printf( "%d", employee_requestleave_inst.getPopulationId() );
        out.print(",");
        out.printf( "'%s'", employee_requestleave_inst.getTarget().getInstanceId().serialize() );
        out.print(",");
        out.printf( "%d", employee_requestleave_inst.get(0) );
        out.print(",");
        out.printf( "%d", employee_requestleave_inst.get(1) );
        out.print(",");
        out.printf( "%d", employee_requestleave_inst.get(2) );
        out.print(",");
        out.printf( "'%s'", employee_requestleave_inst.get(3).replaceAll( "'", "''" ) );
        out.println( ");" );
    }


}
