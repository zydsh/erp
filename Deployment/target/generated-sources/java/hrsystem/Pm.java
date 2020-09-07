package hrsystem;


import hrsystem.pm.PmUI;
import hrsystem.pm.main.Initiative;
import hrsystem.pm.main.InitiativeSet;
import hrsystem.pm.main.Milestone;
import hrsystem.pm.main.MilestoneSet;
import hrsystem.pm.main.Project;
import hrsystem.pm.main.ProjectSet;
import hrsystem.pm.main.Strategy;
import hrsystem.pm.main.StrategySet;
import hrsystem.pm.main.SupportingDocuments;
import hrsystem.pm.main.SupportingDocumentsSet;
import hrsystem.pm.main.impl.InitiativeImpl;
import hrsystem.pm.main.impl.InitiativeSetImpl;
import hrsystem.pm.main.impl.MilestoneImpl;
import hrsystem.pm.main.impl.MilestoneSetImpl;
import hrsystem.pm.main.impl.ProjectImpl;
import hrsystem.pm.main.impl.ProjectSetImpl;
import hrsystem.pm.main.impl.StrategyImpl;
import hrsystem.pm.main.impl.StrategySetImpl;
import hrsystem.pm.main.impl.SupportingDocumentsImpl;
import hrsystem.pm.main.impl.SupportingDocumentsSetImpl;

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
import io.ciera.runtime.summit.util.impl.LOGImpl;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;


public class Pm extends Component<Pm> {

    private Map<String, Class<?>> classDirectory;

    public Pm(IApplication app, IRunContext runContext, int populationId) {
        super(app, runContext, populationId);
        Initiative_extent = new InitiativeSetImpl();
        Milestone_extent = new MilestoneSetImpl();
        Project_extent = new ProjectSetImpl();
        Strategy_extent = new StrategySetImpl();
        SupportingDocuments_extent = new SupportingDocumentsSetImpl();
        R10_Initiative_implements_Strategy_extent = new RelationshipSet();
        R3_SupportingDocuments_evidance_for_Milestone_extent = new RelationshipSet();
        R5_Project_implements_Initiative_extent = new RelationshipSet();
        R60_Milestone_achieved_by_Initiative_extent = new RelationshipSet();
        R8_Milestone_marks_the_development_of_Project_extent = new RelationshipSet();
        LOG = null;
        classDirectory = new TreeMap<>();
        classDirectory.put("Initiative", InitiativeImpl.class);
        classDirectory.put("Milestone", MilestoneImpl.class);
        classDirectory.put("Project", ProjectImpl.class);
        classDirectory.put("Strategy", StrategyImpl.class);
        classDirectory.put("SupportingDocuments", SupportingDocumentsImpl.class);
    }

    // domain functions
    public void CreatePEIs() throws XtumlException {
        Strategy str1 = StrategyImpl.create( context() );
        str1.setNumber("Str 1");
        str1.setName("دعم البحث والتطوير لضمان استدامة منظومة تطوير المحتوى المحلي");
        str1.setDescription(( "يسعى هدف دعم البحث والتطوير لضمان استدامة منظومة تطوير المحتوى" + "المحلي وضمان استدامة دعم البحوث عالية الجودة وتمويلها على المدى الطويل" ) + "وذلك لتحقيق هدف المملكة لتصبح في مقدمة دول منطقة الشرق الوسط في مجال العلوم والتقنية والابتكار بنهاية ٢٠٢٠");
        context().LOG().LogInfo( ( ( ( ( "Strategy: Number " + str1.getName() ) + ", Name " ) + str1.getName() ) + ", Description" ) + str1.getDescription() );
        Strategy str2 = StrategyImpl.create( context() );
        str2.setNumber("Str 2");
        str2.setName("توطين وتطوير التقنية في القطاعات ذات الإنفاق المحلي الكبير");
        str2.setDescription("يسعى الهدف لتعزيز المحتوى المحلي من خلال نقل وتوطين التقنية ");
        context().LOG().LogInfo( ( ( ( ( "Strategy: Number " + str2.getName() ) + ", Name " ) + str2.getName() ) + ", Description" ) + str2.getDescription() );
        Initiative init = InitiativeImpl.create( context() );
        init.setName("مبادرة إطار تنظيمي لتعزيز البرمجيات الحرة ومفتوحة المصدر");
        init.setShortNumber("687");
        init.setLongNumber("");
        init.setDescription("صياغة أنظمة تدعم جودة صناعة البرمجيات الكبرى والمتوسطة وتساهم في خفض التكلفة وتوطين التقنية، ومن ذلك توسيع استخدام البرمجيات الحرة ومفتوحة المصدر ورفع كفاءة القطاع الخاص في تنفيذ برمجيات عالية الجودة حسب المقاييس العالمية ويتطلب هذا العمل تنسيق الجهود لصياغة أنظمة وقوانين لتحقيق ما سبق");
        init.setStartDate(0);
        init.setActualStartDate(0);
        init.setActualEndDate(0);
        init.setEndDate(0);
        init.setBudget(800000);
        context().relate_R10_Initiative_implements_Strategy( init, str1 );
        Milestone mile = MilestoneImpl.create( context() );
        mile.setName("اكتمال الدراسات المساندة");
        mile.setFullCode("M-01-687");
        mile.setCode("1");
        mile.setType("");
        mile.setSuccessCriteria("تسليم التقرير");
        mile.setCompleteActual(0);
        mile.setCompletePlanned(0);
        mile.setComplete(false);
        mile.setWeight(5);
        mile.setPercentage(5);
        mile.setSdState("");
        mile.setSdDescription("");
        mile.setNotes("");
        mile.setIncompleteReasons("");
        context().relate_R60_Milestone_achieved_by_Initiative( mile, init );
        mile = MilestoneImpl.create( context() );
        mile.setName("الانتهاء من رفع خطابات للجهات المشاركة في ورش العمل");
        mile.setFullCode("M-02-687");
        mile.setCode("2");
        mile.setType("معلم");
        mile.setSuccessCriteria("تسليم التقرير");
        mile.setCompleteActual(0);
        mile.setCompletePlanned(0);
        mile.setComplete(true);
        mile.setWeight(5);
        mile.setPercentage(10);
        mile.setSdState("");
        mile.setSdDescription("خطابات ردود المشاركين");
        mile.setNotes("");
        mile.setIncompleteReasons("");
        context().relate_R60_Milestone_achieved_by_Initiative( mile, init );
        mile = MilestoneImpl.create( context() );
        mile.setName("اكتمال مسودة التنظيم");
        mile.setFullCode("M-03-687");
        mile.setCode("3");
        mile.setType("معلم");
        mile.setSuccessCriteria("تسليم التقرير");
        mile.setCompleteActual(0);
        mile.setCompletePlanned(0);
        mile.setComplete(true);
        mile.setWeight(15);
        mile.setPercentage(25);
        mile.setSdState("");
        mile.setSdDescription("مسودة التنظيم");
        mile.setNotes("");
        mile.setIncompleteReasons("");
        context().relate_R60_Milestone_achieved_by_Initiative( mile, init );
    }

    public void Initialize() throws XtumlException {
        context().CreatePEIs();
    }



    // relates and unrelates
    public void relate_R10_Initiative_implements_Strategy( Initiative form, Strategy part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R10_Initiative_implements_Strategy_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR10_implemented_by_Initiative(form);
            form.setR10_implements_Strategy(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R10_Initiative_implements_Strategy( Initiative form, Strategy part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R10_Initiative_implements_Strategy_extent.remove( R10_Initiative_implements_Strategy_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR10_implemented_by_Initiative(form);
            form.setR10_implements_Strategy(StrategyImpl.EMPTY_STRATEGY);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R3_SupportingDocuments_evidance_for_Milestone( SupportingDocuments form, Milestone part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R3_SupportingDocuments_evidance_for_Milestone_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR3_completed_with_SupportingDocuments(form);
            form.setR3_evidance_for_Milestone(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R3_SupportingDocuments_evidance_for_Milestone( SupportingDocuments form, Milestone part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R3_SupportingDocuments_evidance_for_Milestone_extent.remove( R3_SupportingDocuments_evidance_for_Milestone_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR3_completed_with_SupportingDocuments(form);
            form.setR3_evidance_for_Milestone(MilestoneImpl.EMPTY_MILESTONE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R5_Project_implements_Initiative( Project form, Initiative part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R5_Project_implements_Initiative_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR5_implemented_Project(form);
            form.setR5_implements_Initiative(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R5_Project_implements_Initiative( Project form, Initiative part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R5_Project_implements_Initiative_extent.remove( R5_Project_implements_Initiative_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR5_implemented_Project(form);
            form.setR5_implements_Initiative(InitiativeImpl.EMPTY_INITIATIVE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R60_Milestone_achieved_by_Initiative( Milestone form, Initiative part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R60_Milestone_achieved_by_Initiative_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR60_achieves_Milestone(form);
            form.setR60_achieved_by_Initiative(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R60_Milestone_achieved_by_Initiative( Milestone form, Initiative part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R60_Milestone_achieved_by_Initiative_extent.remove( R60_Milestone_achieved_by_Initiative_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR60_achieves_Milestone(form);
            form.setR60_achieved_by_Initiative(InitiativeImpl.EMPTY_INITIATIVE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R8_Milestone_marks_the_development_of_Project( Milestone form, Project part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R8_Milestone_marks_the_development_of_Project_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR8_reaches_Milestone(form);
            form.setR8_marks_the_development_of_Project(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R8_Milestone_marks_the_development_of_Project( Milestone form, Project part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R8_Milestone_marks_the_development_of_Project_extent.remove( R8_Milestone_marks_the_development_of_Project_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR8_reaches_Milestone(form);
            form.setR8_marks_the_development_of_Project(ProjectImpl.EMPTY_PROJECT);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }


    // instance selections
    private InitiativeSet Initiative_extent;
    public InitiativeSet Initiative_instances() {
        return Initiative_extent;
    }
    private MilestoneSet Milestone_extent;
    public MilestoneSet Milestone_instances() {
        return Milestone_extent;
    }
    private ProjectSet Project_extent;
    public ProjectSet Project_instances() {
        return Project_extent;
    }
    private StrategySet Strategy_extent;
    public StrategySet Strategy_instances() {
        return Strategy_extent;
    }
    private SupportingDocumentsSet SupportingDocuments_extent;
    public SupportingDocumentsSet SupportingDocuments_instances() {
        return SupportingDocuments_extent;
    }


    // relationship selections
    private IRelationshipSet R10_Initiative_implements_Strategy_extent;
    public IRelationshipSet R10_Initiative_implements_Strategys() throws XtumlException {
        return R10_Initiative_implements_Strategy_extent;
    }
    private IRelationshipSet R3_SupportingDocuments_evidance_for_Milestone_extent;
    public IRelationshipSet R3_SupportingDocuments_evidance_for_Milestones() throws XtumlException {
        return R3_SupportingDocuments_evidance_for_Milestone_extent;
    }
    private IRelationshipSet R5_Project_implements_Initiative_extent;
    public IRelationshipSet R5_Project_implements_Initiatives() throws XtumlException {
        return R5_Project_implements_Initiative_extent;
    }
    private IRelationshipSet R60_Milestone_achieved_by_Initiative_extent;
    public IRelationshipSet R60_Milestone_achieved_by_Initiatives() throws XtumlException {
        return R60_Milestone_achieved_by_Initiative_extent;
    }
    private IRelationshipSet R8_Milestone_marks_the_development_of_Project_extent;
    public IRelationshipSet R8_Milestone_marks_the_development_of_Projects() throws XtumlException {
        return R8_Milestone_marks_the_development_of_Project_extent;
    }


    // ports
    private PmUI PmUI;
    public PmUI UI() {
        if ( null == PmUI ) PmUI = new PmUI( this, null );
        return PmUI;
    }


    // utilities
    private LOG LOG;
    public LOG LOG() {
        if ( null == LOG ) LOG = new LOGImpl<>( this );
        return LOG;
    }


    // component initialization function
    @Override
    public void initialize() throws XtumlException {

    }

    @Override
    public String getVersion() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("PmProperties.properties"));
        } catch (IOException e) { /* do nothing */ }
        return prop.getProperty("version", "Unknown");
    }
    @Override
    public String getVersionDate() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("PmProperties.properties"));
        } catch (IOException e) { /* do nothing */ }
        return prop.getProperty("version_date", "Unknown");
    }

    @Override
    public boolean addInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot add empty instance to population." );
        if ( instance instanceof Initiative ) return Initiative_extent.add( (Initiative)instance );
        else if ( instance instanceof Milestone ) return Milestone_extent.add( (Milestone)instance );
        else if ( instance instanceof Project ) return Project_extent.add( (Project)instance );
        else if ( instance instanceof Strategy ) return Strategy_extent.add( (Strategy)instance );
        else if ( instance instanceof SupportingDocuments ) return SupportingDocuments_extent.add( (SupportingDocuments)instance );
        return false;
    }

    @Override
    public boolean removeInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot remove empty instance from population." );
        if ( instance instanceof Initiative ) return Initiative_extent.remove( (Initiative)instance );
        else if ( instance instanceof Milestone ) return Milestone_extent.remove( (Milestone)instance );
        else if ( instance instanceof Project ) return Project_extent.remove( (Project)instance );
        else if ( instance instanceof Strategy ) return Strategy_extent.remove( (Strategy)instance );
        else if ( instance instanceof SupportingDocuments ) return SupportingDocuments_extent.remove( (SupportingDocuments)instance );
        return false;
    }

    @Override
    public Pm context() {
        return this;
    }

    @Override
    public Class<?> getClassByKeyLetters(String keyLetters) {
        return classDirectory.get(keyLetters);
    }

}
