package hrsystem;


import hrsystem.hr.HrUI;
import hrsystem.hr.HrUI_Ops;
import hrsystem.hr.main.Bonus;
import hrsystem.hr.main.BonusSet;
import hrsystem.hr.main.BonusSpecification;
import hrsystem.hr.main.BonusSpecificationSet;
import hrsystem.hr.main.Department;
import hrsystem.hr.main.DepartmentSet;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.Grade;
import hrsystem.hr.main.GradeSet;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.JobRecord;
import hrsystem.hr.main.JobRecordSet;
import hrsystem.hr.main.JobSet;
import hrsystem.hr.main.Leave;
import hrsystem.hr.main.LeaveSet;
import hrsystem.hr.main.LeaveSpecification;
import hrsystem.hr.main.LeaveSpecificationSet;
import hrsystem.hr.main.PayslipItem;
import hrsystem.hr.main.PayslipItemSet;
import hrsystem.hr.main.Scale;
import hrsystem.hr.main.ScaleSet;
import hrsystem.hr.main.impl.BonusImpl;
import hrsystem.hr.main.impl.BonusSetImpl;
import hrsystem.hr.main.impl.BonusSpecificationImpl;
import hrsystem.hr.main.impl.BonusSpecificationSetImpl;
import hrsystem.hr.main.impl.DepartmentImpl;
import hrsystem.hr.main.impl.DepartmentSetImpl;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.EmployeeSetImpl;
import hrsystem.hr.main.impl.GradeImpl;
import hrsystem.hr.main.impl.GradeSetImpl;
import hrsystem.hr.main.impl.JobImpl;
import hrsystem.hr.main.impl.JobRecordImpl;
import hrsystem.hr.main.impl.JobRecordSetImpl;
import hrsystem.hr.main.impl.JobSetImpl;
import hrsystem.hr.main.impl.LeaveImpl;
import hrsystem.hr.main.impl.LeaveSetImpl;
import hrsystem.hr.main.impl.LeaveSpecificationImpl;
import hrsystem.hr.main.impl.LeaveSpecificationSetImpl;
import hrsystem.hr.main.impl.PayslipItemImpl;
import hrsystem.hr.main.impl.PayslipItemSetImpl;
import hrsystem.hr.main.impl.ScaleImpl;
import hrsystem.hr.main.impl.ScaleSetImpl;
import hrsystem.hr.messagecenter.ApproveLeave;
import hrsystem.hr.messagecenter.ApproveLeaveSet;
import hrsystem.hr.messagecenter.impl.ApproveLeaveImpl;
import hrsystem.hr.messagecenter.impl.ApproveLeaveSetImpl;

import io.ciera.runtime.summit.application.IApplication;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.classes.IRelationshipSet;
import io.ciera.runtime.summit.classes.Relationship;
import io.ciera.runtime.summit.classes.RelationshipSet;
import io.ciera.runtime.summit.components.Component;
import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.EmptyInstanceException;
import io.ciera.runtime.summit.exceptions.ModelIntegrityException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.util.LOG;
import io.ciera.runtime.summit.util.TIM;
import io.ciera.runtime.summit.util.impl.LOGImpl;
import io.ciera.runtime.summit.util.impl.TIMImpl;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;


public class Hr extends Component<Hr> {

    private Map<String, Class<?>> classDirectory;

    public Hr(IApplication app, IRunContext runContext, int populationId) {
        super(app, runContext, populationId);
        ApproveLeave_extent = new ApproveLeaveSetImpl();
        Bonus_extent = new BonusSetImpl();
        BonusSpecification_extent = new BonusSpecificationSetImpl();
        Department_extent = new DepartmentSetImpl();
        Employee_extent = new EmployeeSetImpl();
        Grade_extent = new GradeSetImpl();
        Job_extent = new JobSetImpl();
        JobRecord_extent = new JobRecordSetImpl();
        Leave_extent = new LeaveSetImpl();
        LeaveSpecification_extent = new LeaveSpecificationSetImpl();
        PayslipItem_extent = new PayslipItemSetImpl();
        Scale_extent = new ScaleSetImpl();
        R102_ApproveLeave_notifies_Employee_extent = new RelationshipSet();
        R12_Grade_is_part_of_Scale_extent = new RelationshipSet();
        R14_Grade_follows_Grade_extent = new RelationshipSet();
        R15_Leave_is_specified_by_a_LeaveSpecification_extent = new RelationshipSet();
        R16_Bonus_is_specified_by_BonusSpecification_extent = new RelationshipSet();
        R17_JobRecord_preceded_by_JobRecord_extent = new RelationshipSet();
        R18_PayslipItem_listed_before_PayslipItem_extent = new RelationshipSet();
        R19_Bonus_given_in_the_past_to_an_Employee_extent = new RelationshipSet();
        R1_JobRecord_occupied_Job_extent = new RelationshipSet();
        R1_JobRecord_was_assigned_to_Employee_extent = new RelationshipSet();
        R20_Job_to_be_assigned_to_an_Employee_extent = new RelationshipSet();
        R21_Employee_working_within_Department_extent = new RelationshipSet();
        R22_Department_is_part_of_Department_extent = new RelationshipSet();
        R23_Department_is_managed_by_Employee_extent = new RelationshipSet();
        R2_Leave_is_consumed_by_a_Employee_extent = new RelationshipSet();
        R3_PayslipItem_records_an_earning_or_deduction_to_Employee_extent = new RelationshipSet();
        R4_Bonus_is_given_to_an_Employee_extent = new RelationshipSet();
        R5_Employee_is_taking_a_Leave_extent = new RelationshipSet();
        R6_Job_is_assigned_to_an_Employee_extent = new RelationshipSet();
        R7_Leave_to_be_taken_by_Employee_extent = new RelationshipSet();
        R9_Job_assigned_Grade_extent = new RelationshipSet();
        LOG = null;
        TIM = null;
        classDirectory = new TreeMap<>();
        classDirectory.put("ApproveLeave", ApproveLeaveImpl.class);
        classDirectory.put("BP", BonusImpl.class);
        classDirectory.put("BonusSpecification", BonusSpecificationImpl.class);
        classDirectory.put("Department", DepartmentImpl.class);
        classDirectory.put("Employee", EmployeeImpl.class);
        classDirectory.put("Grade", GradeImpl.class);
        classDirectory.put("Job", JobImpl.class);
        classDirectory.put("EJ", JobRecordImpl.class);
        classDirectory.put("Leave", LeaveImpl.class);
        classDirectory.put("LeaveSpecification", LeaveSpecificationImpl.class);
        classDirectory.put("PayslipItem", PayslipItemImpl.class);
        classDirectory.put("Scale", ScaleImpl.class);
    }

    // domain functions
    public double getPartialPayment( final int p_Payment_Time,  final int p_Starting_Time,  final int p_Ending_Time,  final double p_Payment ) throws XtumlException {
        if ( p_Payment_Time >= p_Ending_Time && context().isLessThanMonth( p_Payment_Time, p_Ending_Time ) ) {
            int days = 30 - ( ( ( p_Payment_Time - p_Ending_Time ) / 24 ) * 60 ) * 60;
            return days * ( p_Payment / 30 );
        }
        else if ( p_Payment_Time >= p_Starting_Time && context().isLessThanMonth( p_Starting_Time, p_Payment_Time ) ) {
            int days = ( ( ( p_Payment_Time - p_Starting_Time ) / 24 ) * 60 ) * 60;
            return days * ( p_Payment / 30 );
        }
        else {
            return 0;
        }
    }

    public boolean isLessThanMonth( final int p_Starting_Time,  final int p_Ending_Time ) throws XtumlException {
        int time = ( ( ( p_Ending_Time - p_Starting_Time ) / 24 ) * 60 ) * 60;
        int month = 30;
        if ( time <= month ) {
            return true;
        }
        else {
            return false;
        }
    }



    // relates and unrelates
    public void relate_R102_ApproveLeave_notifies_Employee( ApproveLeave form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R102_ApproveLeave_notifies_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR102_is_notified_by_ApproveLeave(form);
            form.setR102_notifies_Employee(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R102_ApproveLeave_notifies_Employee( ApproveLeave form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R102_ApproveLeave_notifies_Employee_extent.remove( R102_ApproveLeave_notifies_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR102_is_notified_by_ApproveLeave(form);
            form.setR102_notifies_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R12_Grade_is_part_of_Scale( Grade form, Scale part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R12_Grade_is_part_of_Scale_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR12_is_made_of_Grade(form);
            form.setR12_is_part_of_Scale(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R12_Grade_is_part_of_Scale( Grade form, Scale part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R12_Grade_is_part_of_Scale_extent.remove( R12_Grade_is_part_of_Scale_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR12_is_made_of_Grade(form);
            form.setR12_is_part_of_Scale(ScaleImpl.EMPTY_SCALE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R14_Grade_follows_Grade( Grade form, Grade part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R14_Grade_follows_Grade_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR14_proceeds_Grade(form);
            form.setR14_follows_Grade(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R14_Grade_follows_Grade( Grade form, Grade part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R14_Grade_follows_Grade_extent.remove( R14_Grade_follows_Grade_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR14_proceeds_Grade(GradeImpl.EMPTY_GRADE);
            form.setR14_follows_Grade(GradeImpl.EMPTY_GRADE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R15_Leave_is_specified_by_a_LeaveSpecification( Leave form, LeaveSpecification part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R15_Leave_is_specified_by_a_LeaveSpecification_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR15_specifies_Leave(form);
            form.setR15_is_specified_by_a_LeaveSpecification(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R15_Leave_is_specified_by_a_LeaveSpecification( Leave form, LeaveSpecification part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R15_Leave_is_specified_by_a_LeaveSpecification_extent.remove( R15_Leave_is_specified_by_a_LeaveSpecification_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR15_specifies_Leave(form);
            form.setR15_is_specified_by_a_LeaveSpecification(LeaveSpecificationImpl.EMPTY_LEAVESPECIFICATION);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R16_Bonus_is_specified_by_BonusSpecification( Bonus form, BonusSpecification part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R16_Bonus_is_specified_by_BonusSpecification_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR16_specifies_Bonus(form);
            form.setR16_is_specified_by_BonusSpecification(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R16_Bonus_is_specified_by_BonusSpecification( Bonus form, BonusSpecification part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R16_Bonus_is_specified_by_BonusSpecification_extent.remove( R16_Bonus_is_specified_by_BonusSpecification_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR16_specifies_Bonus(form);
            form.setR16_is_specified_by_BonusSpecification(BonusSpecificationImpl.EMPTY_BONUSSPECIFICATION);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R17_JobRecord_preceded_by_JobRecord( JobRecord form, JobRecord part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R17_JobRecord_preceded_by_JobRecord_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR17_proceeded_by_JobRecord(form);
            form.setR17_preceded_by_JobRecord(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R17_JobRecord_preceded_by_JobRecord( JobRecord form, JobRecord part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R17_JobRecord_preceded_by_JobRecord_extent.remove( R17_JobRecord_preceded_by_JobRecord_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR17_proceeded_by_JobRecord(JobRecordImpl.EMPTY_JOBRECORD);
            form.setR17_preceded_by_JobRecord(JobRecordImpl.EMPTY_JOBRECORD);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R18_PayslipItem_listed_before_PayslipItem( PayslipItem form, PayslipItem part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R18_PayslipItem_listed_before_PayslipItem_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR18_listed_after_PayslipItem(form);
            form.addR18_listed_before_PayslipItem(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R18_PayslipItem_listed_before_PayslipItem( PayslipItem form, PayslipItem part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R18_PayslipItem_listed_before_PayslipItem_extent.remove( R18_PayslipItem_listed_before_PayslipItem_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR18_listed_after_PayslipItem(form);
            form.removeR18_listed_before_PayslipItem(part);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R19_Bonus_given_in_the_past_to_an_Employee( Bonus form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R19_Bonus_given_in_the_past_to_an_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR19_was_given_a_Bonus(form);
            form.setR19_given_in_the_past_to_an_Employee(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R19_Bonus_given_in_the_past_to_an_Employee( Bonus form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R19_Bonus_given_in_the_past_to_an_Employee_extent.remove( R19_Bonus_given_in_the_past_to_an_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR19_was_given_a_Bonus(form);
            form.setR19_given_in_the_past_to_an_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R1_JobRecord_occupied_Job( JobRecord form, Job part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R1_JobRecord_occupied_Job_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR1_was_assigned_to_JobRecord(form);
            form.setR1_occupied_Job(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R1_JobRecord_occupied_Job( JobRecord form, Job part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R1_JobRecord_occupied_Job_extent.remove( R1_JobRecord_occupied_Job_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR1_was_assigned_to_JobRecord(form);
            form.setR1_occupied_Job(JobImpl.EMPTY_JOB);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R1_JobRecord_was_assigned_to_Employee( JobRecord form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R1_JobRecord_was_assigned_to_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR1_occupied_JobRecord(form);
            form.setR1_was_assigned_to_Employee(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R1_JobRecord_was_assigned_to_Employee( JobRecord form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R1_JobRecord_was_assigned_to_Employee_extent.remove( R1_JobRecord_was_assigned_to_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR1_occupied_JobRecord(form);
            form.setR1_was_assigned_to_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R20_Job_to_be_assigned_to_an_Employee( Job form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R20_Job_to_be_assigned_to_an_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR20_to_be_promoted_to_a_Job(form);
            form.setR20_to_be_assigned_to_an_Employee(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R20_Job_to_be_assigned_to_an_Employee( Job form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R20_Job_to_be_assigned_to_an_Employee_extent.remove( R20_Job_to_be_assigned_to_an_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR20_to_be_promoted_to_a_Job(JobImpl.EMPTY_JOB);
            form.setR20_to_be_assigned_to_an_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R21_Employee_working_within_Department( Employee form, Department part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R21_Employee_working_within_Department_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR21_holds_Employee(form);
            form.setR21_working_within_Department(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R21_Employee_working_within_Department( Employee form, Department part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R21_Employee_working_within_Department_extent.remove( R21_Employee_working_within_Department_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR21_holds_Employee(form);
            form.setR21_working_within_Department(DepartmentImpl.EMPTY_DEPARTMENT);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R22_Department_is_part_of_Department( Department form, Department part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R22_Department_is_part_of_Department_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR22_is_divided_into_Department(form);
            form.setR22_is_part_of_Department(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R22_Department_is_part_of_Department( Department form, Department part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R22_Department_is_part_of_Department_extent.remove( R22_Department_is_part_of_Department_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR22_is_divided_into_Department(form);
            form.setR22_is_part_of_Department(DepartmentImpl.EMPTY_DEPARTMENT);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R23_Department_is_managed_by_Employee( Department form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R23_Department_is_managed_by_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR23_manages_Department(form);
            form.setR23_is_managed_by_Employee(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R23_Department_is_managed_by_Employee( Department form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R23_Department_is_managed_by_Employee_extent.remove( R23_Department_is_managed_by_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR23_manages_Department(form);
            form.setR23_is_managed_by_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R2_Leave_is_consumed_by_a_Employee( Leave form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R2_Leave_is_consumed_by_a_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR2_consumed_Leave(form);
            form.setR2_is_consumed_by_a_Employee(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R2_Leave_is_consumed_by_a_Employee( Leave form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R2_Leave_is_consumed_by_a_Employee_extent.remove( R2_Leave_is_consumed_by_a_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR2_consumed_Leave(form);
            form.setR2_is_consumed_by_a_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R3_PayslipItem_records_an_earning_or_deduction_to_Employee( PayslipItem form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R3_PayslipItem_records_an_earning_or_deduction_to_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem(form);
            form.setR3_records_an_earning_or_deduction_to_Employee(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R3_PayslipItem_records_an_earning_or_deduction_to_Employee( PayslipItem form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R3_PayslipItem_records_an_earning_or_deduction_to_Employee_extent.remove( R3_PayslipItem_records_an_earning_or_deduction_to_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR3_an_earning_or_a_deduction_is_recorded_in_a_PayslipItem(form);
            form.setR3_records_an_earning_or_deduction_to_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R4_Bonus_is_given_to_an_Employee( Bonus form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R4_Bonus_is_given_to_an_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR4_gets_a_Bonus(form);
            form.setR4_is_given_to_an_Employee(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R4_Bonus_is_given_to_an_Employee( Bonus form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R4_Bonus_is_given_to_an_Employee_extent.remove( R4_Bonus_is_given_to_an_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR4_gets_a_Bonus(form);
            form.setR4_is_given_to_an_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R5_Employee_is_taking_a_Leave( Employee form, Leave part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R5_Employee_is_taking_a_Leave_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR5_is_currently_taken_by_Employee(form);
            form.setR5_is_taking_a_Leave(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R5_Employee_is_taking_a_Leave( Employee form, Leave part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R5_Employee_is_taking_a_Leave_extent.remove( R5_Employee_is_taking_a_Leave_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR5_is_currently_taken_by_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
            form.setR5_is_taking_a_Leave(LeaveImpl.EMPTY_LEAVE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R6_Job_is_assigned_to_an_Employee( Job form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R6_Job_is_assigned_to_an_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR6_currently_occupies_a_Job(form);
            form.setR6_is_assigned_to_an_Employee(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R6_Job_is_assigned_to_an_Employee( Job form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R6_Job_is_assigned_to_an_Employee_extent.remove( R6_Job_is_assigned_to_an_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR6_currently_occupies_a_Job(JobImpl.EMPTY_JOB);
            form.setR6_is_assigned_to_an_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R7_Leave_to_be_taken_by_Employee( Leave form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R7_Leave_to_be_taken_by_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR7_is_planning_to_take__Leave(form);
            form.setR7_to_be_taken_by_Employee(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R7_Leave_to_be_taken_by_Employee( Leave form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R7_Leave_to_be_taken_by_Employee_extent.remove( R7_Leave_to_be_taken_by_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.setR7_is_planning_to_take__Leave(LeaveImpl.EMPTY_LEAVE);
            form.setR7_to_be_taken_by_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R9_Job_assigned_Grade( Job form, Grade part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R9_Job_assigned_Grade_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR9_assigned_Job(form);
            form.setR9_assigned_Grade(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R9_Job_assigned_Grade( Job form, Grade part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R9_Job_assigned_Grade_extent.remove( R9_Job_assigned_Grade_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR9_assigned_Job(form);
            form.setR9_assigned_Grade(GradeImpl.EMPTY_GRADE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }


    // instance selections
    private ApproveLeaveSet ApproveLeave_extent;
    public ApproveLeaveSet ApproveLeave_instances() {
        return ApproveLeave_extent;
    }
    private BonusSpecificationSet BonusSpecification_extent;
    public BonusSpecificationSet BonusSpecification_instances() {
        return BonusSpecification_extent;
    }
    private BonusSet Bonus_extent;
    public BonusSet Bonus_instances() {
        return Bonus_extent;
    }
    private DepartmentSet Department_extent;
    public DepartmentSet Department_instances() {
        return Department_extent;
    }
    private EmployeeSet Employee_extent;
    public EmployeeSet Employee_instances() {
        return Employee_extent;
    }
    private GradeSet Grade_extent;
    public GradeSet Grade_instances() {
        return Grade_extent;
    }
    private JobRecordSet JobRecord_extent;
    public JobRecordSet JobRecord_instances() {
        return JobRecord_extent;
    }
    private JobSet Job_extent;
    public JobSet Job_instances() {
        return Job_extent;
    }
    private LeaveSpecificationSet LeaveSpecification_extent;
    public LeaveSpecificationSet LeaveSpecification_instances() {
        return LeaveSpecification_extent;
    }
    private LeaveSet Leave_extent;
    public LeaveSet Leave_instances() {
        return Leave_extent;
    }
    private PayslipItemSet PayslipItem_extent;
    public PayslipItemSet PayslipItem_instances() {
        return PayslipItem_extent;
    }
    private ScaleSet Scale_extent;
    public ScaleSet Scale_instances() {
        return Scale_extent;
    }


    // relationship selections
    private IRelationshipSet R102_ApproveLeave_notifies_Employee_extent;
    public IRelationshipSet R102_ApproveLeave_notifies_Employees() throws XtumlException {
        return R102_ApproveLeave_notifies_Employee_extent;
    }
    private IRelationshipSet R12_Grade_is_part_of_Scale_extent;
    public IRelationshipSet R12_Grade_is_part_of_Scales() throws XtumlException {
        return R12_Grade_is_part_of_Scale_extent;
    }
    private IRelationshipSet R14_Grade_follows_Grade_extent;
    public IRelationshipSet R14_Grade_follows_Grades() throws XtumlException {
        return R14_Grade_follows_Grade_extent;
    }
    private IRelationshipSet R15_Leave_is_specified_by_a_LeaveSpecification_extent;
    public IRelationshipSet R15_Leave_is_specified_by_a_LeaveSpecifications() throws XtumlException {
        return R15_Leave_is_specified_by_a_LeaveSpecification_extent;
    }
    private IRelationshipSet R16_Bonus_is_specified_by_BonusSpecification_extent;
    public IRelationshipSet R16_Bonus_is_specified_by_BonusSpecifications() throws XtumlException {
        return R16_Bonus_is_specified_by_BonusSpecification_extent;
    }
    private IRelationshipSet R17_JobRecord_preceded_by_JobRecord_extent;
    public IRelationshipSet R17_JobRecord_preceded_by_JobRecords() throws XtumlException {
        return R17_JobRecord_preceded_by_JobRecord_extent;
    }
    private IRelationshipSet R18_PayslipItem_listed_before_PayslipItem_extent;
    public IRelationshipSet R18_PayslipItem_listed_before_PayslipItems() throws XtumlException {
        return R18_PayslipItem_listed_before_PayslipItem_extent;
    }
    private IRelationshipSet R19_Bonus_given_in_the_past_to_an_Employee_extent;
    public IRelationshipSet R19_Bonus_given_in_the_past_to_an_Employees() throws XtumlException {
        return R19_Bonus_given_in_the_past_to_an_Employee_extent;
    }
    private IRelationshipSet R1_JobRecord_occupied_Job_extent;
    public IRelationshipSet R1_JobRecord_occupied_Jobs() throws XtumlException {
        return R1_JobRecord_occupied_Job_extent;
    }
    private IRelationshipSet R1_JobRecord_was_assigned_to_Employee_extent;
    public IRelationshipSet R1_JobRecord_was_assigned_to_Employees() throws XtumlException {
        return R1_JobRecord_was_assigned_to_Employee_extent;
    }
    private IRelationshipSet R20_Job_to_be_assigned_to_an_Employee_extent;
    public IRelationshipSet R20_Job_to_be_assigned_to_an_Employees() throws XtumlException {
        return R20_Job_to_be_assigned_to_an_Employee_extent;
    }
    private IRelationshipSet R21_Employee_working_within_Department_extent;
    public IRelationshipSet R21_Employee_working_within_Departments() throws XtumlException {
        return R21_Employee_working_within_Department_extent;
    }
    private IRelationshipSet R22_Department_is_part_of_Department_extent;
    public IRelationshipSet R22_Department_is_part_of_Departments() throws XtumlException {
        return R22_Department_is_part_of_Department_extent;
    }
    private IRelationshipSet R23_Department_is_managed_by_Employee_extent;
    public IRelationshipSet R23_Department_is_managed_by_Employees() throws XtumlException {
        return R23_Department_is_managed_by_Employee_extent;
    }
    private IRelationshipSet R2_Leave_is_consumed_by_a_Employee_extent;
    public IRelationshipSet R2_Leave_is_consumed_by_a_Employees() throws XtumlException {
        return R2_Leave_is_consumed_by_a_Employee_extent;
    }
    private IRelationshipSet R3_PayslipItem_records_an_earning_or_deduction_to_Employee_extent;
    public IRelationshipSet R3_PayslipItem_records_an_earning_or_deduction_to_Employees() throws XtumlException {
        return R3_PayslipItem_records_an_earning_or_deduction_to_Employee_extent;
    }
    private IRelationshipSet R4_Bonus_is_given_to_an_Employee_extent;
    public IRelationshipSet R4_Bonus_is_given_to_an_Employees() throws XtumlException {
        return R4_Bonus_is_given_to_an_Employee_extent;
    }
    private IRelationshipSet R5_Employee_is_taking_a_Leave_extent;
    public IRelationshipSet R5_Employee_is_taking_a_Leaves() throws XtumlException {
        return R5_Employee_is_taking_a_Leave_extent;
    }
    private IRelationshipSet R6_Job_is_assigned_to_an_Employee_extent;
    public IRelationshipSet R6_Job_is_assigned_to_an_Employees() throws XtumlException {
        return R6_Job_is_assigned_to_an_Employee_extent;
    }
    private IRelationshipSet R7_Leave_to_be_taken_by_Employee_extent;
    public IRelationshipSet R7_Leave_to_be_taken_by_Employees() throws XtumlException {
        return R7_Leave_to_be_taken_by_Employee_extent;
    }
    private IRelationshipSet R9_Job_assigned_Grade_extent;
    public IRelationshipSet R9_Job_assigned_Grades() throws XtumlException {
        return R9_Job_assigned_Grade_extent;
    }


    // ports
    private HrUI HrUI;
    public HrUI UI() {
        if ( null == HrUI ) HrUI = new HrUI( this, null );
        return HrUI;
    }
    private HrUI_Ops HrUI_Ops;
    public HrUI_Ops UI_Ops() {
        if ( null == HrUI_Ops ) HrUI_Ops = new HrUI_Ops( this, null );
        return HrUI_Ops;
    }


    // utilities
    private LOG LOG;
    public LOG LOG() {
        if ( null == LOG ) LOG = new LOGImpl<>( this );
        return LOG;
    }
    private TIM TIM;
    public TIM TIM() {
        if ( null == TIM ) TIM = new TIMImpl<>( this );
        return TIM;
    }


    // component initialization function
    @Override
    public void initialize() throws XtumlException {

    }

    @Override
    public String getVersion() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("HrProperties.properties"));
        } catch (IOException e) { /* do nothing */ }
        return prop.getProperty("version", "Unknown");
    }
    @Override
    public String getVersionDate() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("HrProperties.properties"));
        } catch (IOException e) { /* do nothing */ }
        return prop.getProperty("version_date", "Unknown");
    }

    @Override
    public boolean addInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot add empty instance to population." );
        if ( instance instanceof ApproveLeave ) return ApproveLeave_extent.add( (ApproveLeave)instance );
        else if ( instance instanceof Bonus ) return Bonus_extent.add( (Bonus)instance );
        else if ( instance instanceof BonusSpecification ) return BonusSpecification_extent.add( (BonusSpecification)instance );
        else if ( instance instanceof Department ) return Department_extent.add( (Department)instance );
        else if ( instance instanceof Employee ) return Employee_extent.add( (Employee)instance );
        else if ( instance instanceof Grade ) return Grade_extent.add( (Grade)instance );
        else if ( instance instanceof Job ) return Job_extent.add( (Job)instance );
        else if ( instance instanceof JobRecord ) return JobRecord_extent.add( (JobRecord)instance );
        else if ( instance instanceof Leave ) return Leave_extent.add( (Leave)instance );
        else if ( instance instanceof LeaveSpecification ) return LeaveSpecification_extent.add( (LeaveSpecification)instance );
        else if ( instance instanceof PayslipItem ) return PayslipItem_extent.add( (PayslipItem)instance );
        else if ( instance instanceof Scale ) return Scale_extent.add( (Scale)instance );
        return false;
    }

    @Override
    public boolean removeInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot remove empty instance from population." );
        if ( instance instanceof ApproveLeave ) return ApproveLeave_extent.remove( (ApproveLeave)instance );
        else if ( instance instanceof Bonus ) return Bonus_extent.remove( (Bonus)instance );
        else if ( instance instanceof BonusSpecification ) return BonusSpecification_extent.remove( (BonusSpecification)instance );
        else if ( instance instanceof Department ) return Department_extent.remove( (Department)instance );
        else if ( instance instanceof Employee ) return Employee_extent.remove( (Employee)instance );
        else if ( instance instanceof Grade ) return Grade_extent.remove( (Grade)instance );
        else if ( instance instanceof Job ) return Job_extent.remove( (Job)instance );
        else if ( instance instanceof JobRecord ) return JobRecord_extent.remove( (JobRecord)instance );
        else if ( instance instanceof Leave ) return Leave_extent.remove( (Leave)instance );
        else if ( instance instanceof LeaveSpecification ) return LeaveSpecification_extent.remove( (LeaveSpecification)instance );
        else if ( instance instanceof PayslipItem ) return PayslipItem_extent.remove( (PayslipItem)instance );
        else if ( instance instanceof Scale ) return Scale_extent.remove( (Scale)instance );
        return false;
    }

    @Override
    public Hr context() {
        return this;
    }

    @Override
    public Class<?> getClassByKeyLetters(String keyLetters) {
        return classDirectory.get(keyLetters);
    }

}
