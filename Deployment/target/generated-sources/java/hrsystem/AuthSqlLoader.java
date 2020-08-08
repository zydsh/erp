package hrsystem;


import hrsystem.auth.main.Account;
import hrsystem.auth.main.Group;
import hrsystem.auth.main.Permission;
import hrsystem.auth.main.impl.AccountImpl;
import hrsystem.auth.main.impl.GroupImpl;
import hrsystem.auth.main.impl.PermissionImpl;

import io.ciera.runtime.instanceloading.sql.SqlLoader;
import io.ciera.runtime.summit.classes.InstanceIdentifier;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.UniqueId;

import java.io.PrintStream;
import java.util.List;


public class AuthSqlLoader extends SqlLoader {

    private Auth population;

    public AuthSqlLoader( Auth population ) {
        super(population.getRunContext());
        this.population = population;
    }

    @Override
    public void insert(String tableName, List<Object> values) throws XtumlException {
        switch ( tableName ) {
        case "Group":
            GroupImpl.create(population, UniqueId.deserialize(values.get(0)), (String)values.get(1));
            break;
        case "Permission":
            PermissionImpl.create(population, UniqueId.deserialize(values.get(0)));
            break;
        case "Account":
            AccountImpl.create(population, UniqueId.deserialize(values.get(0)), (String)values.get(1), (String)values.get(2), (int)values.get(3));
            break;
        default:
            //throw new XtumlException( "Class not supported by this population." );
            break;
        }
    }

    @Override
    public void batchRelate() throws XtumlException {
        batch_relate_R1_Permission_Group();
        batch_relate_R1_Permission_Account();
    }

    public void batch_relate_R1_Permission_Group() throws XtumlException {
        for ( Permission form : population.Permission_instances() ) {
            population.relate_R1_Permission_Group( form, population.Group_instances().getById1(new InstanceIdentifier()));
        }
    }
    public void batch_relate_R1_Permission_Account() throws XtumlException {
        for ( Permission form : population.Permission_instances() ) {
            population.relate_R1_Permission_Account( form, population.Account_instances().getById1(new InstanceIdentifier()));
        }
    }


    @Override
    public void serialize() throws XtumlException {
        PrintStream out = new PrintStream(getOut());
        for ( Group group_inst : population.Group_instances() ) serialize_Group( group_inst, out );
        for ( Permission permission_inst : population.Permission_instances() ) serialize_Permission( permission_inst, out );
        for ( Account account_inst : population.Account_instances() ) serialize_Account( account_inst, out );
        out.flush();
    }

    public void serialize_Group( Group group_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO Group VALUES(" );
        out.printf( "'%s'", group_inst.getInstanceId().serialize() );
        out.print(",");
        out.printf( "'%s'", group_inst.getName().replaceAll( "'", "''" ) );
        out.println( ");" );
    }
    public void serialize_Permission( Permission permission_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO Permission VALUES(" );
        out.printf( "'%s'", permission_inst.getInstanceId().serialize() );
        out.println( ");" );
    }
    public void serialize_Account( Account account_inst, PrintStream out ) throws XtumlException {
        out.print( "INSERT INTO Account VALUES(" );
        out.printf( "'%s'", account_inst.getInstanceId().serialize() );
        out.print(",");
        out.printf( "'%s'", account_inst.getUsername().replaceAll( "'", "''" ) );
        out.print(",");
        out.printf( "'%s'", account_inst.getPassword().replaceAll( "'", "''" ) );
        out.print(",");
        out.printf( "%d", account_inst.getNational_ID() );
        out.println( ");" );
    }


}
