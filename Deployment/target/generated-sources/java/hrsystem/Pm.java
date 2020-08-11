package hrsystem;


import hrsystem.pm.PmPort1;
import hrsystem.pm.main.Initiative;
import hrsystem.pm.main.InitiativeSet;
import hrsystem.pm.main.impl.InitiativeImpl;
import hrsystem.pm.main.impl.InitiativeSetImpl;

import io.ciera.runtime.summit.application.IApplication;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.components.Component;
import io.ciera.runtime.summit.exceptions.BadArgumentException;
import io.ciera.runtime.summit.exceptions.EmptyInstanceException;
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


        classDirectory = new TreeMap<>();
        classDirectory.put("Initiative", InitiativeImpl.class);
    }

    // domain functions


    // relates and unrelates


    // instance selections
    private InitiativeSet Initiative_extent;
    public InitiativeSet Initiative_instances() {
        return Initiative_extent;
    }


    // relationship selections


    // ports
    private PmPort1 PmPort1;
    public PmPort1 Port1() {
        if ( null == PmPort1 ) PmPort1 = new PmPort1( this, null );
        return PmPort1;
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
        return false;
    }

    @Override
    public boolean removeInstance( IModelInstance<?,?> instance ) throws XtumlException {
        if ( null == instance ) throw new BadArgumentException( "Null instance passed." );
        if ( instance.isEmpty() ) throw new EmptyInstanceException( "Cannot remove empty instance from population." );
        if ( instance instanceof Initiative ) return Initiative_extent.remove( (Initiative)instance );
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
