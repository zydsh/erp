package hrsystem.auth.main.impl;


import hrsystem.Auth;
import hrsystem.auth.main.Group;
import hrsystem.auth.main.Permission;
import hrsystem.auth.main.PermissionSet;
import hrsystem.auth.main.impl.PermissionSetImpl;

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


public class GroupImpl extends ModelInstance<Group,Auth> implements Group {

    public static final String KEY_LETTERS = "Group";
    public static final Group EMPTY_GROUP = new EmptyGroup();

    private Auth context;

    // constructors
    private GroupImpl( Auth context ) {
        this.context = context;
        m_Name = "";
        R1_Permission_set = new PermissionSetImpl();
    }

    private GroupImpl( Auth context, UniqueId instanceId, String m_Name ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        R1_Permission_set = new PermissionSetImpl();
    }

    public static Group create( Auth context ) throws XtumlException {
        Group newGroup = new GroupImpl( context );
        if ( context.addInstance( newGroup ) ) {
            newGroup.getRunContext().addChange(new InstanceCreatedDelta(newGroup, KEY_LETTERS));
            return newGroup;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Group create( Auth context, UniqueId instanceId, String m_Name ) throws XtumlException {
        Group newGroup = new GroupImpl( context, instanceId, m_Name );
        if ( context.addInstance( newGroup ) ) {
            return newGroup;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private String m_Name;
    @Override
    public String getName() throws XtumlException {
        checkLiving();
        return m_Name;
    }
    @Override
    public void setName(String m_Name) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Name, this.m_Name)) {
            final String oldValue = this.m_Name;
            this.m_Name = m_Name;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Name", oldValue, this.m_Name));
        }
    }


    // instance identifiers

    // operations


    // static operations


    // events


    // selections
    private PermissionSet R1_Permission_set;
    @Override
    public void addR1_Permission( Permission inst ) {
        R1_Permission_set.add(inst);
    }
    @Override
    public void removeR1_Permission( Permission inst ) {
        R1_Permission_set.remove(inst);
    }
    @Override
    public PermissionSet R1_Permission() throws XtumlException {
        return R1_Permission_set;
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
    public Group self() {
        return this;
    }

    @Override
    public Group oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_GROUP;
    }

}

class EmptyGroup extends ModelInstance<Group,Auth> implements Group {

    // attributes
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public PermissionSet R1_Permission() {
        return (new PermissionSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return GroupImpl.KEY_LETTERS;
    }

    @Override
    public Group self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Group oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return GroupImpl.EMPTY_GROUP;
    }

}
