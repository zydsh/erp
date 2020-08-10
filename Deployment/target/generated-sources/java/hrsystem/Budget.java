package hrsystem;


import hrsystem.budget.BudgetUI_Fin;
import hrsystem.budget.main.Budget;
import hrsystem.budget.main.BudgetSet;
import hrsystem.budget.main.Chapter;
import hrsystem.budget.main.ChapterSet;
import hrsystem.budget.main.Item;
import hrsystem.budget.main.ItemSet;
import hrsystem.budget.main.Section;
import hrsystem.budget.main.SectionSet;
import hrsystem.budget.main.impl.BudgetImpl;
import hrsystem.budget.main.impl.BudgetSetImpl;
import hrsystem.budget.main.impl.ChapterImpl;
import hrsystem.budget.main.impl.ChapterSetImpl;
import hrsystem.budget.main.impl.ItemImpl;
import hrsystem.budget.main.impl.ItemSetImpl;
import hrsystem.budget.main.impl.SectionImpl;
import hrsystem.budget.main.impl.SectionSetImpl;

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


public class Budget extends Component<Budget> {

    private Map<String, Class<?>> classDirectory;

    public Budget(IApplication app, IRunContext runContext, int populationId) {
        super(app, runContext, populationId);
        Budget_extent = new BudgetSetImpl();
        Chapter_extent = new ChapterSetImpl();
        Item_extent = new ItemSetImpl();
        Section_extent = new SectionSetImpl();
        R1_Chapter_Budget_extent = new RelationshipSet();
        R2_Section_Chapter_extent = new RelationshipSet();
        R3_Item_Section_extent = new RelationshipSet();
        LOG = null;
        classDirectory = new TreeMap<>();
        classDirectory.put("Budget", BudgetImpl.class);
        classDirectory.put("Chapter", ChapterImpl.class);
        classDirectory.put("Item", ItemImpl.class);
        classDirectory.put("Section", SectionImpl.class);
    }

    // domain functions


    // relates and unrelates
    public void relate_R1_Chapter_Budget( Chapter form, Budget part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R1_Chapter_Budget_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR1_Chapter(form);
            form.setR1_Budget(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R1_Chapter_Budget( Chapter form, Budget part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R1_Chapter_Budget_extent.remove( R1_Chapter_Budget_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR1_Chapter(form);
            form.setR1_Budget(BudgetImpl.EMPTY_BUDGET);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R2_Section_Chapter( Section form, Chapter part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R2_Section_Chapter_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR2_Section(form);
            form.setR2_Chapter(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R2_Section_Chapter( Section form, Chapter part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R2_Section_Chapter_extent.remove( R2_Section_Chapter_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR2_Section(form);
            form.setR2_Chapter(ChapterImpl.EMPTY_CHAPTER);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }
    public void relate_R3_Item_Section( Item form, Section part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R3_Item_Section_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR3_Item(form);
            form.setR3_Section(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R3_Item_Section( Item form, Section part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R3_Item_Section_extent.remove( R3_Item_Section_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR3_Item(form);
            form.setR3_Section(SectionImpl.EMPTY_SECTION);
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
    private IRelationshipSet R1_Chapter_Budget_extent;
    public IRelationshipSet R1_Chapter_Budgets() throws XtumlException {
        return R1_Chapter_Budget_extent;
    }
    private IRelationshipSet R2_Section_Chapter_extent;
    public IRelationshipSet R2_Section_Chapters() throws XtumlException {
        return R2_Section_Chapter_extent;
    }
    private IRelationshipSet R3_Item_Section_extent;
    public IRelationshipSet R3_Item_Sections() throws XtumlException {
        return R3_Item_Section_extent;
    }


    // ports
    private BudgetUI_Fin BudgetUI_Fin;
    public BudgetUI_Fin UI_Fin() {
        if ( null == BudgetUI_Fin ) BudgetUI_Fin = new BudgetUI_Fin( this, null );
        return BudgetUI_Fin;
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
            prop.load(getClass().getResourceAsStream("BudgetProperties.properties"));
        } catch (IOException e) { /* do nothing */ }
        return prop.getProperty("version", "Unknown");
    }
    @Override
    public String getVersionDate() {
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("BudgetProperties.properties"));
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
    public Budget context() {
        return this;
    }

    @Override
    public Class<?> getClassByKeyLetters(String keyLetters) {
        return classDirectory.get(keyLetters);
    }

}
