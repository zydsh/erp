package hrsystem.auth.main.impl;


import hrsystem.Auth;
import hrsystem.auth.main.Group;
import hrsystem.auth.main.GroupSet;
import hrsystem.auth.main.Permissions;
import hrsystem.auth.main.impl.GroupSetImpl;

import io.ciera.runtime.instanceloading.AttributeChangedDelta;
import io.ciera.runtime.instanceloading.InstanceCreatedDelta;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.classes.IInstanceIdentifier;
import io.ciera.runtime.summit.classes.InstanceIdentifier;
import io.ciera.runtime.summit.classes.ModelInstance;
import io.ciera.runtime.summit.exceptions.EmptyInstanceException;
import io.ciera.runtime.summit.exceptions.InstancePopulationException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.IWhere;
import io.ciera.runtime.summit.types.IXtumlType;
import io.ciera.runtime.summit.types.StringUtil;
import io.ciera.runtime.summit.types.UniqueId;


public class PermissionsImpl extends ModelInstance<Permissions,Auth> implements Permissions {

    public static final String KEY_LETTERS = "Permissions";
    public static final Permissions EMPTY_PERMISSIONS = new EmptyPermissions();

    private Auth context;

    // constructors
    private PermissionsImpl( Auth context ) {
        this.context = context;
        m_Permission = "";
        R3_given_Group_set = new GroupSetImpl();
    }

    private PermissionsImpl( Auth context, UniqueId instanceId, String m_Permission ) {
        super(instanceId);
        this.context = context;
        this.m_Permission = m_Permission;
        R3_given_Group_set = new GroupSetImpl();
    }

    public static Permissions create( Auth context ) throws XtumlException {
        Permissions newPermissions = new PermissionsImpl( context );
        if ( context.addInstance( newPermissions ) ) {
            newPermissions.getRunContext().addChange(new InstanceCreatedDelta(newPermissions, KEY_LETTERS));
            return newPermissions;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Permissions create( Auth context, UniqueId instanceId, String m_Permission ) throws XtumlException {
        Permissions newPermissions = new PermissionsImpl( context, instanceId, m_Permission );
        if ( context.addInstance( newPermissions ) ) {
            return newPermissions;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private String m_Permission;
    @Override
    public void setPermission(String m_Permission) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Permission, this.m_Permission)) {
            final String oldValue = this.m_Permission;
            this.m_Permission = m_Permission;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Permission", oldValue, this.m_Permission));
        }
    }
    @Override
    public String getPermission() throws XtumlException {
        checkLiving();
        return m_Permission;
    }


    // instance identifiers

    // operations


    // static operations


    // events


    // selections
    private GroupSet R3_given_Group_set;
    @Override
    public void addR3_given_Group( Group inst ) {
        R3_given_Group_set.add(inst);
    }
    @Override
    public void removeR3_given_Group( Group inst ) {
        R3_given_Group_set.remove(inst);
    }
    @Override
    public GroupSet R3_given_Group() throws XtumlException {
        return R3_given_Group_set;
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
    public Permissions self() {
        return this;
    }

    @Override
    public Permissions oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_PERMISSIONS;
    }

}

class EmptyPermissions extends ModelInstance<Permissions,Auth> implements Permissions {

    // attributes
    public void setPermission( String m_Permission ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getPermission() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public GroupSet R3_given_Group() {
        return (new GroupSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return PermissionsImpl.KEY_LETTERS;
    }

    @Override
    public Permissions self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Permissions oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return PermissionsImpl.EMPTY_PERMISSIONS;
    }

}
