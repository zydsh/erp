package hrsystem;


import hrsystem.hr.HrHAuth;
import hrsystem.hr.HrUI;
import hrsystem.hr.HrUI_Ops;
import hrsystem.hr.main.Bonus;
import hrsystem.hr.main.BonusSet;
import hrsystem.hr.main.Bonus_Payment;
import hrsystem.hr.main.Bonus_PaymentSet;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.EmployeeSet;
import hrsystem.hr.main.Employee_Job;
import hrsystem.hr.main.Employee_JobSet;
import hrsystem.hr.main.Employee_Leave;
import hrsystem.hr.main.Employee_LeaveSet;
import hrsystem.hr.main.Grade;
import hrsystem.hr.main.GradeSet;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.JobSet;
import hrsystem.hr.main.Leave;
import hrsystem.hr.main.LeaveSet;
import hrsystem.hr.main.Payment;
import hrsystem.hr.main.PaymentSet;
import hrsystem.hr.main.Step;
import hrsystem.hr.main.StepSet;
import hrsystem.hr.main.impl.BonusImpl;
import hrsystem.hr.main.impl.BonusSetImpl;
import hrsystem.hr.main.impl.Bonus_PaymentImpl;
import hrsystem.hr.main.impl.Bonus_PaymentSetImpl;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.EmployeeSetImpl;
import hrsystem.hr.main.impl.Employee_JobImpl;
import hrsystem.hr.main.impl.Employee_JobSetImpl;
import hrsystem.hr.main.impl.Employee_LeaveImpl;
import hrsystem.hr.main.impl.Employee_LeaveSetImpl;
import hrsystem.hr.main.impl.GradeImpl;
import hrsystem.hr.main.impl.GradeSetImpl;
import hrsystem.hr.main.impl.JobImpl;
import hrsystem.hr.main.impl.JobSetImpl;
import hrsystem.hr.main.impl.LeaveImpl;
import hrsystem.hr.main.impl.LeaveSetImpl;
import hrsystem.hr.main.impl.PaymentImpl;
import hrsystem.hr.main.impl.PaymentSetImpl;
import hrsystem.hr.main.impl.StepImpl;
import hrsystem.hr.main.impl.StepSetImpl;

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
        Bonus_extent = new BonusSetImpl();
        Bonus_Payment_extent = new Bonus_PaymentSetImpl();
        Employee_extent = new EmployeeSetImpl();
        Employee_Job_extent = new Employee_JobSetImpl();
        Employee_Leave_extent = new Employee_LeaveSetImpl();
        Grade_extent = new GradeSetImpl();
        Job_extent = new JobSetImpl();
        Leave_extent = new LeaveSetImpl();
        Payment_extent = new PaymentSetImpl();
        Step_extent = new StepSetImpl();
        R1_Employee_Job_Employee_extent = new RelationshipSet();
        R1_Employee_Job_Job_extent = new RelationshipSet();
        R2_Employee_Leave_Employee_extent = new RelationshipSet();
        R2_Employee_Leave_Leave_extent = new RelationshipSet();
        R3_Payment_Employee_extent = new RelationshipSet();
        R4_Bonus_Payment_Bonus_extent = new RelationshipSet();
        R4_Bonus_Payment_Employee_extent = new RelationshipSet();
        R5_Job_Grade_extent = new RelationshipSet();
        R5_Job_Step_extent = new RelationshipSet();
        LOG = null;
        TIM = null;
        classDirectory = new TreeMap<>();
        classDirectory.put("Bonus", BonusImpl.class);
        classDirectory.put("BP", Bonus_PaymentImpl.class);
        classDirectory.put("EM", EmployeeImpl.class);
        classDirectory.put("EJ", Employee_JobImpl.class);
        classDirectory.put("Employee_Leave", Employee_LeaveImpl.class);
        classDirectory.put("Grade", GradeImpl.class);
        classDirectory.put("Job", JobImpl.class);
        classDirectory.put("Leave", LeaveImpl.class);
        classDirectory.put("Payment", PaymentImpl.class);
        classDirectory.put("Step", StepImpl.class);
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
    public void relate_R1_Employee_Job_Employee( Employee_Job form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R1_Employee_Job_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR1_Employee_Job(form);
            form.setR1_Employee(part);
            form.setNational_ID( part.getNational_ID() );
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R1_Employee_Job_Employee( Employee_Job form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R1_Employee_Job_Employee_extent.remove( R1_Employee_Job_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR1_Employee_Job(form);
            form.setR1_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R1_Employee_Job_Job( Employee_Job form, Job part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R1_Employee_Job_Job_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR1_Employee_Job(form);
            form.setR1_Job(part);
            form.setJob_ID( part.getJob_ID() );
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R1_Employee_Job_Job( Employee_Job form, Job part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R1_Employee_Job_Job_extent.remove( R1_Employee_Job_Job_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR1_Employee_Job(form);
            form.setR1_Job(JobImpl.EMPTY_JOB);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R2_Employee_Leave_Employee( Employee_Leave form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R2_Employee_Leave_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR2_Employee_Leave(form);
            form.setR2_Employee(part);
            form.setNational_ID( part.getNational_ID() );
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R2_Employee_Leave_Employee( Employee_Leave form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R2_Employee_Leave_Employee_extent.remove( R2_Employee_Leave_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR2_Employee_Leave(form);
            form.setR2_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R2_Employee_Leave_Leave( Employee_Leave form, Leave part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R2_Employee_Leave_Leave_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR2_Employee_Leave(form);
            form.setR2_Leave(part);
            form.setLeave_ID( part.getLeave_ID() );
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R2_Employee_Leave_Leave( Employee_Leave form, Leave part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R2_Employee_Leave_Leave_extent.remove( R2_Employee_Leave_Leave_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR2_Employee_Leave(form);
            form.setR2_Leave(LeaveImpl.EMPTY_LEAVE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R3_Payment_Employee( Payment form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R3_Payment_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR3_Payment(form);
            form.setR3_Employee(part);
            form.setNational_ID( part.getNational_ID() );
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R3_Payment_Employee( Payment form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R3_Payment_Employee_extent.remove( R3_Payment_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR3_Payment(form);
            form.setR3_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R4_Bonus_Payment_Bonus( Bonus_Payment form, Bonus part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R4_Bonus_Payment_Bonus_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR4_Bonus_Payment(form);
            form.setR4_Bonus(part);
            form.setName( part.getName() );
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R4_Bonus_Payment_Bonus( Bonus_Payment form, Bonus part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R4_Bonus_Payment_Bonus_extent.remove( R4_Bonus_Payment_Bonus_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR4_Bonus_Payment(form);
            form.setR4_Bonus(BonusImpl.EMPTY_BONUS);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R4_Bonus_Payment_Employee( Bonus_Payment form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R4_Bonus_Payment_Employee_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR4_Bonus_Payment(form);
            form.setR4_Employee(part);
            form.setNational_ID( part.getNational_ID() );
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R4_Bonus_Payment_Employee( Bonus_Payment form, Employee part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R4_Bonus_Payment_Employee_extent.remove( R4_Bonus_Payment_Employee_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR4_Bonus_Payment(form);
            form.setR4_Employee(EmployeeImpl.EMPTY_EMPLOYEE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R5_Job_Grade( Job form, Grade part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R5_Job_Grade_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR5_Job(form);
            form.setR5_Grade(part);
            form.setGValue( part.getGValue() );
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R5_Job_Grade( Job form, Grade part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R5_Job_Grade_extent.remove( R5_Job_Grade_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR5_Job(form);
            form.setR5_Grade(GradeImpl.EMPTY_GRADE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R5_Job_Step( Job form, Step part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R5_Job_Step_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR5_Job(form);
            form.setR5_Step(part);
            form.setSValue( part.getSValue() );
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R5_Job_Step( Job form, Step part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R5_Job_Step_extent.remove( R5_Job_Step_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR5_Job(form);
            form.setR5_Step(StepImpl.EMPTY_STEP);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }


    // instance selections
    private Bonus_PaymentSet Bonus_Payment_extent;
    public Bonus_PaymentSet Bonus_Payment_instances() {
        return Bonus_Payment_extent;
    }
    private BonusSet Bonus_extent;
    public BonusSet Bonus_instances() {
        return Bonus_extent;
    }
    private Employee_JobSet Employee_Job_extent;
    public Employee_JobSet Employee_Job_instances() {
        return Employee_Job_extent;
    }
    private Employee_LeaveSet Employee_Leave_extent;
    public Employee_LeaveSet Employee_Leave_instances() {
        return Employee_Leave_extent;
    }
    private EmployeeSet Employee_extent;
    public EmployeeSet Employee_instances() {
        return Employee_extent;
    }
    private GradeSet Grade_extent;
    public GradeSet Grade_instances() {
        return Grade_extent;
    }
    private JobSet Job_extent;
    public JobSet Job_instances() {
        return Job_extent;
    }
    private LeaveSet Leave_extent;
    public LeaveSet Leave_instances() {
        return Leave_extent;
    }
    private PaymentSet Payment_extent;
    public PaymentSet Payment_instances() {
        return Payment_extent;
    }
    private StepSet Step_extent;
    public StepSet Step_instances() {
        return Step_extent;
    }


    // relationship selections
    private IRelationshipSet R1_Employee_Job_Employee_extent;
    public IRelationshipSet R1_Employee_Job_Employees() throws XtumlException {
        return R1_Employee_Job_Employee_extent;
    }
    private IRelationshipSet R1_Employee_Job_Job_extent;
    public IRelationshipSet R1_Employee_Job_Jobs() throws XtumlException {
        return R1_Employee_Job_Job_extent;
    }
    private IRelationshipSet R2_Employee_Leave_Employee_extent;
    public IRelationshipSet R2_Employee_Leave_Employees() throws XtumlException {
        return R2_Employee_Leave_Employee_extent;
    }
    private IRelationshipSet R2_Employee_Leave_Leave_extent;
    public IRelationshipSet R2_Employee_Leave_Leaves() throws XtumlException {
        return R2_Employee_Leave_Leave_extent;
    }
    private IRelationshipSet R3_Payment_Employee_extent;
    public IRelationshipSet R3_Payment_Employees() throws XtumlException {
        return R3_Payment_Employee_extent;
    }
    private IRelationshipSet R4_Bonus_Payment_Bonus_extent;
    public IRelationshipSet R4_Bonus_Payment_Bonuss() throws XtumlException {
        return R4_Bonus_Payment_Bonus_extent;
    }
    private IRelationshipSet R4_Bonus_Payment_Employee_extent;
    public IRelationshipSet R4_Bonus_Payment_Employees() throws XtumlException {
        return R4_Bonus_Payment_Employee_extent;
    }
    private IRelationshipSet R5_Job_Grade_extent;
    public IRelationshipSet R5_Job_Grades() throws XtumlException {
        return R5_Job_Grade_extent;
    }
    private IRelationshipSet R5_Job_Step_extent;
    public IRelationshipSet R5_Job_Steps() throws XtumlException {
        return R5_Job_Step_extent;
    }


    // ports
    private HrHAuth HrHAuth;
    public HrHAuth HAuth() {
        if ( null == HrHAuth ) HrHAuth = new HrHAuth( this, null );
        return HrHAuth;
    }
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
        if ( instance instanceof Bonus ) return Bonus_extent.add( (Bonus)instance );
        else if ( instance instanceof Bonus_Payment ) return Bonus_Payment_extent.add( (Bonus_Payment)instance );
        else if ( instance instanceof Employee ) return Employee_extent.add( (Employee)instance );
        else if ( instance instanceof Employee_Job ) return Employee_Job_extent.add( (Employee_Job)instance );
        else if ( instance instanceof Employee_Leave ) return Employee_Leave_extent.add( (Employee_Leave)instance );
        else if ( instance instanceof Grade ) return Grade_extent.add( (Grade)instance );
        else if ( instance instanceof Job ) return Job_extent.add( (Job)instance );
        else if ( instance instanceof Leave ) return Leave_extent.add( (Leave)instance );
        else if ( instance instanceof Payment ) return Payment_extent.add( (Payment)instance );
        else if ( instance instanceof Step ) return Step_extent.add( (Step)instance );
        return false;
    }

    @Override
    public boolean removeInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot remove empty instance from population." );
        if ( instance instanceof Bonus ) return Bonus_extent.remove( (Bonus)instance );
        else if ( instance instanceof Bonus_Payment ) return Bonus_Payment_extent.remove( (Bonus_Payment)instance );
        else if ( instance instanceof Employee ) return Employee_extent.remove( (Employee)instance );
        else if ( instance instanceof Employee_Job ) return Employee_Job_extent.remove( (Employee_Job)instance );
        else if ( instance instanceof Employee_Leave ) return Employee_Leave_extent.remove( (Employee_Leave)instance );
        else if ( instance instanceof Grade ) return Grade_extent.remove( (Grade)instance );
        else if ( instance instanceof Job ) return Job_extent.remove( (Job)instance );
        else if ( instance instanceof Leave ) return Leave_extent.remove( (Leave)instance );
        else if ( instance instanceof Payment ) return Payment_extent.remove( (Payment)instance );
        else if ( instance instanceof Step ) return Step_extent.remove( (Step)instance );
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
