package deployment;


import hrsystem.Auth;
import hrsystem.Hr;
import hrsystem.HrSqlLoader;
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
        components = new IComponent<?>[3];
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
        components[1] = new UI(this, executors[0], 1);
        components[2] = new Hr(this, executors[0], 2);
        components[2].addLoader("Sql", new HrSqlLoader((Hr)components[2]));
        components[0] = new Auth(this, executors[0], 0);
        ((UI)components[1]).App().satisfy(((Hr)components[2]).UI());
        ((Hr)components[2]).UI().satisfy(((UI)components[1]).App());
        ((UI)components[1]).AppOps().satisfy(((Hr)components[2]).UI_Ops());
        ((Hr)components[2]).UI_Ops().satisfy(((UI)components[1]).AppOps());
        ((Hr)components[2]).HAuth().satisfy(((Auth)components[0]).Auth());
        ((Auth)components[0]).Auth().satisfy(((Hr)components[2]).HAuth());
    }

    public UI UI() {
        return (UI)components[1];
    }
    public Hr Hr() {
        return (Hr)components[2];
    }
    public Auth Auth() {
        return (Auth)components[0];
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
