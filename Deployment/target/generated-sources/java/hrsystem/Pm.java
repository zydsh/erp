package hrsystem;


import hrsystem.pm.PmPM;
import hrsystem.pm.main.Initiative;
import hrsystem.pm.main.InitiativeSet;
import hrsystem.pm.main.Strategy;
import hrsystem.pm.main.StrategySet;
import hrsystem.pm.main.impl.InitiativeImpl;
import hrsystem.pm.main.impl.InitiativeSetImpl;
import hrsystem.pm.main.impl.StrategyImpl;
import hrsystem.pm.main.impl.StrategySetImpl;

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


public class Pm extends Component<Pm> {

    private Map<String, Class<?>> classDirectory;

    public Pm(IApplication app, IRunContext runContext, int populationId) {
        super(app, runContext, populationId);
        Initiative_extent = new InitiativeSetImpl();
        Strategy_extent = new StrategySetImpl();
        R1_Initiative_Strategy_extent = new RelationshipSet();

        classDirectory = new TreeMap<>();
        classDirectory.put("Initiative", InitiativeImpl.class);
        classDirectory.put("Strategy", StrategyImpl.class);
    }

    // domain functions


    // relates and unrelates
    public void relate_R1_Initiative_Strategy( Initiative form, Strategy part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot relate empty instances." );
        // TODO cardinality check
        if ( R1_Initiative_Strategy_extent.add( new Relationship( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.addR1_Initiative(form);
            form.setR1_Strategy(part);
        }
        else throw new ModelIntegrityException( "Instances could not be related." );
    }

    public void unrelate_R1_Initiative_Strategy( Initiative form, Strategy part ) throws XtumlException {
        if ( null == form || null == part ) throw new BadArgumentException( "Null instances passed." );
        if ( form.isEmpty() || part.isEmpty() ) throw new EmptyInstanceException( "Cannot unrelate empty instances." );
        if ( R1_Initiative_Strategy_extent.remove( R1_Initiative_Strategy_extent.get( form.getInstanceId(), part.getInstanceId() ) ) ) {
            part.removeR1_Initiative(form);
            form.setR1_Strategy(StrategyImpl.EMPTY_STRATEGY);
        }
        else throw new ModelIntegrityException( "Instances could not be unrelated." );
    }


    // instance selections
    private InitiativeSet Initiative_extent;
    public InitiativeSet Initiative_instances() {
        return Initiative_extent;
    }
    private StrategySet Strategy_extent;
    public StrategySet Strategy_instances() {
        return Strategy_extent;
    }


    // relationship selections
    private IRelationshipSet R1_Initiative_Strategy_extent;
    public IRelationshipSet R1_Initiative_Strategys() throws XtumlException {
        return R1_Initiative_Strategy_extent;
    }


    // ports
    private PmPM PmPM;
    public PmPM PM() {
        if ( null == PmPM ) PmPM = new PmPM( this, null );
        return PmPM;
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
        else if ( instance instanceof Strategy ) return Strategy_extent.add( (Strategy)instance );
        return false;
    }

    @Override
    public boolean removeInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot remove empty instance from population." );
        if ( instance instanceof Initiative ) return Initiative_extent.remove( (Initiative)instance );
        else if ( instance instanceof Strategy ) return Strategy_extent.remove( (Strategy)instance );
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
