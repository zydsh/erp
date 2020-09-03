package erp;


import erp.pm.PmUI;
import erp.pm.main.Initiative;
import erp.pm.main.InitiativeSet;
import erp.pm.main.Milestone;
import erp.pm.main.MilestoneSet;
import erp.pm.main.Project;
import erp.pm.main.ProjectSet;
import erp.pm.main.Strategy;
import erp.pm.main.StrategySet;
import erp.pm.main.Supporting_Documents;
import erp.pm.main.Supporting_DocumentsSet;
import erp.pm.main.impl.InitiativeImpl;
import erp.pm.main.impl.InitiativeSetImpl;
import erp.pm.main.impl.MilestoneImpl;
import erp.pm.main.impl.MilestoneSetImpl;
import erp.pm.main.impl.ProjectImpl;
import erp.pm.main.impl.ProjectSetImpl;
import erp.pm.main.impl.StrategyImpl;
import erp.pm.main.impl.StrategySetImpl;
import erp.pm.main.impl.Supporting_DocumentsImpl;
import erp.pm.main.impl.Supporting_DocumentsSetImpl;

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
        Supporting_Documents_extent = new Supporting_DocumentsSetImpl();
        R1_Initiative_defined_by_Strategy_extent = new RelationshipSet();
        R2_Milestone_achieved_by_Initiative_extent = new RelationshipSet();
        R3_Supporting_Documents_evidance_for_Milestone_extent = new RelationshipSet();
        R4_Project_defined_by_Initiative_extent = new RelationshipSet();
        LOG = null;
        classDirectory = new TreeMap<>();
        classDirectory.put("Initiative", InitiativeImpl.class);
        classDirectory.put("Milestone", MilestoneImpl.class);
        classDirectory.put("Project", ProjectImpl.class);
        classDirectory.put("Strategy", StrategyImpl.class);
        classDirectory.put("Supporting_Documents", Supporting_DocumentsImpl.class);
    }

    // domain functions
    public void CreatePEI_Strategies() throws XtumlException {
        Strategy str = StrategyImpl.create( context() );
        str.setNumber("Str 1");
        str.setName("دعم البحث والتطوير لضمان استدامة منظومة تطوير المحتوى المحلي");
        str.setDescription(( "يسعى هدف دعم البحث والتطوير لضمان استدامة منظومة تطوير المحتوى" + "المحلي وضمان استدامة دعم البحوث عالية الجودة وتمويلها على المدى الطويل" ) + "وذلك لتحقيق هدف المملكة لتصبح في مقدمة دول منطقة الشرق الوسط في مجال العلوم والتقنية والابتكار بنهاية ٢٠٢٠");
        context().LOG().LogInfo( ( ( ( ( "Strategy: Number " + str.getName() ) + ", Name " ) + str.getName() ) + ", Description" ) + str.getDescription() );
        str = StrategyImpl.create( context() );
        str.setNumber("Str 2");
        str.setName("توطين وتطوير التقنية في القطاعات ذات الإنفاق المحلي الكبير");
        str.setDescription("يسعى الهدف لتعزيز المحتوى المحلي من خلال نقل وتوطين التقنية ");
        context().LOG().LogInfo( ( ( ( ( "Strategy: Number " + str.getName() ) + ", Name " ) + str.getName() ) + ", Description" ) + str.getDescription() );
    }

    public void Initialize() throws XtumlException {
        context().CreatePEI_Strategies();
    }



    // relates and unrelates
    public void relate_R1_Initiative_defined_by_Strategy( Initiative form, Strategy part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R1_Initiative_defined_by_Strategy_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR1_defines_Initiative(form);
            form.setR1_defined_by_Strategy(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R1_Initiative_defined_by_Strategy( Initiative form, Strategy part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R1_Initiative_defined_by_Strategy_extent.remove( R1_Initiative_defined_by_Strategy_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR1_defines_Initiative(form);
            form.setR1_defined_by_Strategy(StrategyImpl.EMPTY_STRATEGY);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R2_Milestone_achieved_by_Initiative( Milestone form, Initiative part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R2_Milestone_achieved_by_Initiative_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR2_achieves_Milestone(form);
            form.setR2_achieved_by_Initiative(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R2_Milestone_achieved_by_Initiative( Milestone form, Initiative part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R2_Milestone_achieved_by_Initiative_extent.remove( R2_Milestone_achieved_by_Initiative_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR2_achieves_Milestone(form);
            form.setR2_achieved_by_Initiative(InitiativeImpl.EMPTY_INITIATIVE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R3_Supporting_Documents_evidance_for_Milestone( Supporting_Documents form, Milestone part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R3_Supporting_Documents_evidance_for_Milestone_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR3_completed_with_Supporting_Documents(form);
            form.setR3_evidance_for_Milestone(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R3_Supporting_Documents_evidance_for_Milestone( Supporting_Documents form, Milestone part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R3_Supporting_Documents_evidance_for_Milestone_extent.remove( R3_Supporting_Documents_evidance_for_Milestone_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR3_completed_with_Supporting_Documents(form);
            form.setR3_evidance_for_Milestone(MilestoneImpl.EMPTY_MILESTONE);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R4_Project_defined_by_Initiative( Project form, Initiative part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R4_Project_defined_by_Initiative_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR4_defines_Project(form);
            form.setR4_defined_by_Initiative(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R4_Project_defined_by_Initiative( Project form, Initiative part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R4_Project_defined_by_Initiative_extent.remove( R4_Project_defined_by_Initiative_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR4_defines_Project(form);
            form.setR4_defined_by_Initiative(InitiativeImpl.EMPTY_INITIATIVE);
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
    private Supporting_DocumentsSet Supporting_Documents_extent;
    public Supporting_DocumentsSet Supporting_Documents_instances() {
        return Supporting_Documents_extent;
    }


    // relationship selections
    private IRelationshipSet R1_Initiative_defined_by_Strategy_extent;
    public IRelationshipSet R1_Initiative_defined_by_Strategys() throws XtumlException {
        return R1_Initiative_defined_by_Strategy_extent;
    }
    private IRelationshipSet R2_Milestone_achieved_by_Initiative_extent;
    public IRelationshipSet R2_Milestone_achieved_by_Initiatives() throws XtumlException {
        return R2_Milestone_achieved_by_Initiative_extent;
    }
    private IRelationshipSet R3_Supporting_Documents_evidance_for_Milestone_extent;
    public IRelationshipSet R3_Supporting_Documents_evidance_for_Milestones() throws XtumlException {
        return R3_Supporting_Documents_evidance_for_Milestone_extent;
    }
    private IRelationshipSet R4_Project_defined_by_Initiative_extent;
    public IRelationshipSet R4_Project_defined_by_Initiatives() throws XtumlException {
        return R4_Project_defined_by_Initiative_extent;
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
        else if ( instance instanceof Supporting_Documents ) return Supporting_Documents_extent.add( (Supporting_Documents)instance );
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
        else if ( instance instanceof Supporting_Documents ) return Supporting_Documents_extent.remove( (Supporting_Documents)instance );
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
