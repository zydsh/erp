package hrsystem.auth.main.impl;


import hrsystem.Auth;
import hrsystem.auth.main.Account;
import hrsystem.auth.main.Group;
import hrsystem.auth.main.Permission;
import hrsystem.auth.main.impl.AccountImpl;
import hrsystem.auth.main.impl.GroupImpl;

import io.ciera.runtime.instanceloading.InstanceCreatedDelta;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.classes.IInstanceIdentifier;
import io.ciera.runtime.summit.classes.InstanceIdentifier;
import io.ciera.runtime.summit.classes.ModelInstance;
import io.ciera.runtime.summit.exceptions.InstancePopulationException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.IWhere;
import io.ciera.runtime.summit.types.IXtumlType;
import io.ciera.runtime.summit.types.UniqueId;


public class PermissionImpl extends ModelInstance<Permission,Auth> implements Permission {

    public static final String KEY_LETTERS = "Permission";
    public static final Permission EMPTY_PERMISSION = new EmptyPermission();

    private Auth context;

    // constructors
    private PermissionImpl( Auth context ) {
        this.context = context;
        R1_Account_inst = AccountImpl.EMPTY_ACCOUNT;
        R1_Group_inst = GroupImpl.EMPTY_GROUP;
    }

    private PermissionImpl( Auth context, UniqueId instanceId ) {
        super(instanceId);
        this.context = context;
        R1_Account_inst = AccountImpl.EMPTY_ACCOUNT;
        R1_Group_inst = GroupImpl.EMPTY_GROUP;
    }

    public static Permission create( Auth context ) throws XtumlException {
        Permission newPermission = new PermissionImpl( context );
        if ( context.addInstance( newPermission ) ) {
            newPermission.getRunContext().addChange(new InstanceCreatedDelta(newPermission, KEY_LETTERS));
            return newPermission;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Permission create( Auth context, UniqueId instanceId ) throws XtumlException {
        Permission newPermission = new PermissionImpl( context, instanceId );
        if ( context.addInstance( newPermission ) ) {
            return newPermission;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes


    // instance identifiers

    // operations


    // static operations


    // events


    // selections
    private Account R1_Account_inst;
    @Override
    public void setR1_Account( Account inst ) {
        R1_Account_inst = inst;
    }
    @Override
    public Account R1_Account() throws XtumlException {
        return R1_Account_inst;
    }
    private Group R1_Group_inst;
    @Override
    public void setR1_Group( Group inst ) {
        R1_Group_inst = inst;
    }
    @Override
    public Group R1_Group() throws XtumlException {
        return R1_Group_inst;
    }


    @Override
    public IRunContext getRunContext() {
        return context().getRunContext();
    }

    @Override
    public Auth context() {
        return context;
    }

    @Override
    public String getKeyLetters() {
        return KEY_LETTERS;
    }

    @Override
    public Permission self() {
        return this;
    }

    @Override
    public Permission oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_PERMISSION;
    }

}

class EmptyPermission extends ModelInstance<Permission,Auth> implements Permission {

    // attributes


    // operations


    // selections
    @Override
    public Account R1_Account() {
        return AccountImpl.EMPTY_ACCOUNT;
    }
    @Override
    public Group R1_Group() {
        return GroupImpl.EMPTY_GROUP;
    }


    @Override
    public String getKeyLetters() {
        return PermissionImpl.KEY_LETTERS;
    }

    @Override
    public Permission self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Permission oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return PermissionImpl.EMPTY_PERMISSION;
    }

}
