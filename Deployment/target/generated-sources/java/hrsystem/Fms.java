package hrsystem;


import hrsystem.fms.FmsUI;
import hrsystem.fms.budgeting.Budget;
import hrsystem.fms.budgeting.BudgetSet;
import hrsystem.fms.budgeting.Chapter;
import hrsystem.fms.budgeting.ChapterSet;
import hrsystem.fms.budgeting.Item;
import hrsystem.fms.budgeting.ItemSet;
import hrsystem.fms.budgeting.Section;
import hrsystem.fms.budgeting.SectionSet;
import hrsystem.fms.budgeting.impl.BudgetImpl;
import hrsystem.fms.budgeting.impl.BudgetSetImpl;
import hrsystem.fms.budgeting.impl.ChapterImpl;
import hrsystem.fms.budgeting.impl.ChapterSetImpl;
import hrsystem.fms.budgeting.impl.ItemImpl;
import hrsystem.fms.budgeting.impl.ItemSetImpl;
import hrsystem.fms.budgeting.impl.SectionImpl;
import hrsystem.fms.budgeting.impl.SectionSetImpl;

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

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;


public class Fms extends Component<Fms> {

    private Map<String, Class<?>> classDirectory;

    public Fms(IApplication app, IRunContext runContext, int populationId) {
        super(app, runContext, populationId);
        Budget_extent = new BudgetSetImpl();
        Chapter_extent = new ChapterSetImpl();
        Item_extent = new ItemSetImpl();
        Section_extent = new SectionSetImpl();
        R100_Chapter_belongs_Budget_extent = new RelationshipSet();
        R200_Section_belongs_Chapter_extent = new RelationshipSet();
        R3_Item_attributed_to_Section_extent = new RelationshipSet();

        classDirectory = new TreeMap<>();
        classDirectory.put("Budget", BudgetImpl.class);
        classDirectory.put("Chapter", ChapterImpl.class);
        classDirectory.put("Item", ItemImpl.class);
        classDirectory.put("Section", SectionImpl.class);
    }

    // domain functions
    public void CreatePEIs() throws XtumlException {
        Item item = ItemImpl.create( context() );
        item.setCategory("");
        item.setType("");
        item.setStatus("");
        item.setFund(0);
        Budget budget = BudgetImpl.create( context() );
        budget.setYear("2021");
        budget.setAmount(0);
        Chapter chapter = ChapterImpl.create( context() );
        chapter.setCode("٢١");
        chapter.setName("تعويضات العاملين");
        context().relate_R100_Chapter_belongs_Budget( chapter, budget );
        Section section = SectionImpl.create( context() );
        section.setCode("رواتب الموظفين المدنيين");
        section.setName("211111");
        context().relate_R200_Section_belongs_Chapter( section, chapter );
        chapter = ChapterImpl.create( context() );
        chapter.setCode("٢٢");
        chapter.setName("السلع والخدمات");
        context().relate_R100_Chapter_belongs_Budget( chapter, budget );
        chapter = ChapterImpl.create( context() );
        chapter.setCode("٢٣");
        chapter.setName("استهلاك الرأس المال الثابت");
        context().relate_R100_Chapter_belongs_Budget( chapter, budget );
        chapter = ChapterImpl.create( context() );
        chapter.setCode("٢٤");
        chapter.setName("نفقات تمويل");
        context().relate_R100_Chapter_belongs_Budget( chapter, budget );
        chapter = ChapterImpl.create( context() );
        chapter.setCode("٢٥");
        chapter.setName("الإعانات");
        context().relate_R100_Chapter_belongs_Budget( chapter, budget );
        chapter = ChapterImpl.create( context() );
        chapter.setCode("٢٦");
        chapter.setName("المنح");
        context().relate_R100_Chapter_belongs_Budget( chapter, budget );
        chapter = ChapterImpl.create( context() );
        chapter.setCode("٢٧");
        chapter.setName("المنافع الاجتماعية");
        context().relate_R100_Chapter_belongs_Budget( chapter, budget );
        chapter = ChapterImpl.create( context() );
        chapter.setCode("٢٨");
        chapter.setName("مصروفات أخرى");
        context().relate_R100_Chapter_belongs_Budget( chapter, budget );
        chapter = ChapterImpl.create( context() );
        chapter.setCode("٣١");
        chapter.setName("أصول غير مالية");
        context().relate_R100_Chapter_belongs_Budget( chapter, budget );
    }

    public void Initialize() throws XtumlException {
        context().CreatePEIs();
    }



    // relates and unrelates
    public void relate_R100_Chapter_belongs_Budget( Chapter form, Budget part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R100_Chapter_belongs_Budget_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR100_divided_Chapter(form);
            form.setR100_belongs_Budget(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R100_Chapter_belongs_Budget( Chapter form, Budget part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R100_Chapter_belongs_Budget_extent.remove( R100_Chapter_belongs_Budget_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR100_divided_Chapter(form);
            form.setR100_belongs_Budget(BudgetImpl.EMPTY_BUDGET);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R200_Section_belongs_Chapter( Section form, Chapter part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R200_Section_belongs_Chapter_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR200_divided_Section(form);
            form.setR200_belongs_Chapter(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R200_Section_belongs_Chapter( Section form, Chapter part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R200_Section_belongs_Chapter_extent.remove( R200_Section_belongs_Chapter_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR200_divided_Section(form);
            form.setR200_belongs_Chapter(ChapterImpl.EMPTY_CHAPTER);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R3_Item_attributed_to_Section( Item form, Section part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R3_Item_attributed_to_Section_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR3_assigned_Item(form);
            form.setR3_attributed_to_Section(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R3_Item_attributed_to_Section( Item form, Section part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R3_Item_attributed_to_Section_extent.remove( R3_Item_attributed_to_Section_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR3_assigned_Item(form);
            form.setR3_attributed_to_Section(SectionImpl.EMPTY_SECTION);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }


    // instance selections
    private BudgetSet Budget_extent;
    public BudgetSet Budget_instances() {
        return Budget_extent;
    }
    private ChapterSet Chapter_extent;
    public ChapterSet Chapter_instances() {
        return Chapter_extent;
    }
    private ItemSet Item_extent;
    public ItemSet Item_instances() {
        return Item_extent;
    }
    private SectionSet Section_extent;
    public SectionSet Section_instances() {
        return Section_extent;
    }


    // relationship selections
    private IRelationshipSet R100_Chapter_belongs_Budget_extent;
    public IRelationshipSet R100_Chapter_belongs_Budgets() throws XtumlException {
        return R100_Chapter_belongs_Budget_extent;
    }
    private IRelationshipSet R200_Section_belongs_Chapter_extent;
    public IRelationshipSet R200_Section_belongs_Chapters() throws XtumlException {
        return R200_Section_belongs_Chapter_extent;
    }
    private IRelationshipSet R3_Item_attributed_to_Section_extent;
    public IRelationshipSet R3_Item_attributed_to_Sections() throws XtumlException {
        return R3_Item_attributed_to_Section_extent;
    }


    // ports
    private FmsUI FmsUI;
    public FmsUI UI() {
        if ( null == FmsUI ) FmsUI = new FmsUI( this, null );
        return FmsUI;
    }


    // utilities


    // component initialization function
    @Override
    public void initialize() throws XtumlException {

    }

    @Override
    public String getVersion() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("FmsProperties.properties"));
        } catch (IOException e) { /* do nothing */ }
        return prop.getProperty("version", "Unknown");
    }
    @Override
    public String getVersionDate() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("FmsProperties.properties"));
        } catch (IOException e) { /* do nothing */ }
        return prop.getProperty("version_date", "Unknown");
    }

    @Override
    public boolean addInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot add empty instance to population." );
        if ( instance instanceof Budget ) return Budget_extent.add( (Budget)instance );
        else if ( instance instanceof Chapter ) return Chapter_extent.add( (Chapter)instance );
        else if ( instance instanceof Item ) return Item_extent.add( (Item)instance );
        else if ( instance instanceof Section ) return Section_extent.add( (Section)instance );
        return false;
    }

    @Override
    public boolean removeInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot remove empty instance from population." );
        if ( instance instanceof Budget ) return Budget_extent.remove( (Budget)instance );
        else if ( instance instanceof Chapter ) return Chapter_extent.remove( (Chapter)instance );
        else if ( instance instanceof Item ) return Item_extent.remove( (Item)instance );
        else if ( instance instanceof Section ) return Section_extent.remove( (Section)instance );
        return false;
    }

    @Override
    public Fms context() {
        return this;
    }

    @Override
    public Class<?> getClassByKeyLetters(String keyLetters) {
        return classDirectory.get(keyLetters);
    }

}
