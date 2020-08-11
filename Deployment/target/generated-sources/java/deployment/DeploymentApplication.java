package deployment;


import hrsystem.Fm;
import hrsystem.Hr;
import hrsystem.Pm;
import hrsystem.UI;

import io.ciera.runtime.summit.application.ApplicationExecutor;
import io.ciera.runtime.summit.application.IApplication;
import io.ciera.runtime.summit.application.ILogger;
import io.ciera.runtime.summit.application.tasks.GenericExecutionTask;
import io.ciera.runtime.summit.application.tasks.HaltExecutionTask;
import io.ciera.runtime.summit.components.IComponent;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;


public class DeploymentApplication implements IApplication {

    private IComponent<?>[] components;
    private ApplicationExecutor[] executors;

    public DeploymentApplication() {
        components = new IComponent<?>[4];
        executors = new ApplicationExecutor[1];
    }

    @Override
    public void run() {
        for (ApplicationExecutor executor : executors) {
            executor.run();
        }
    }

    @Override
    public void setup( String[] args, ILogger logger ) {
        for ( int i = 0; i < executors.length; i++ ) {
            if ( null != logger ) {
                executors[i] = new ApplicationExecutor( "DeploymentApplicationExecutor" + i, args, logger );
            }
            else {
                executors[i] = new ApplicationExecutor( "DeploymentApplicationExecutor" + i, args );
            }
        }
        components[3] = new Pm(this, executors[0], 3);
        components[0] = new UI(this, executors[0], 0);
        components[1] = new Fm(this, executors[0], 1);
        components[2] = new Hr(this, executors[0], 2);
        ((UI)components[0]).App().satisfy(((Hr)components[2]).UI());
        ((Hr)components[2]).UI().satisfy(((UI)components[0]).App());
        ((UI)components[0]).AppOps().satisfy(((Hr)components[2]).UI_Ops());
        ((Hr)components[2]).UI_Ops().satisfy(((UI)components[0]).AppOps());
        ((UI)components[0]).Fincrud().satisfy(((Fm)components[1]).Fin());
        ((Fm)components[1]).Fin().satisfy(((UI)components[0]).Fincrud());
        ((UI)components[0]).Port1().satisfy(((Pm)components[3]).PM());
        ((Pm)components[3]).PM().satisfy(((UI)components[0]).Port1());
    }

    public Pm Pm() {
        return (Pm)components[3];
    }
    public UI UI() {
        return (UI)components[0];
    }
    public Fm Fm() {
        return (Fm)components[1];
    }
    public Hr Hr() {
        return (Hr)components[2];
    }

    @Override
    public void initialize() {
        for ( IComponent<?> component : components ) {
            component.getRunContext().execute( new GenericExecutionTask() {
                @Override
                public void run() throws XtumlException {
                    component.initialize();
                }
            });
        }
    }

    @Override
    public void start() {
        if (1 == executors.length) {
            executors[0].run();
        }
        else {
            for ( ApplicationExecutor executor : executors ) {
                executor.start();
            }
        }
    }

    @Override
    public void printVersions() {
        io.ciera.runtime.Version.printVersion();
        for ( IComponent<?> c : components ) {
            System.out.printf("%s: %s (%s)", c.getClass().getName(), c.getVersion(), c.getVersionDate());
            System.out.println();
        }
    }

    @Override
    public void stop() {
        for ( ApplicationExecutor executor : executors ) {
            executor.execute(new HaltExecutionTask());
        }
    }

    public static void main( String[] args ) {
        IApplication app = new DeploymentApplication();
        app.setup( args, null );
        if ( Arrays.asList(args).contains("-v") || Arrays.asList(args).contains("--version") ) {
            app.printVersions();
        }
        else {
            app.initialize();
            app.start();
        }
    }

}
