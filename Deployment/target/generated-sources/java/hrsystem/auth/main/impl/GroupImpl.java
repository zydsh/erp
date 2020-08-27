package hrsystem.auth.main.impl;


import hrsystem.Auth;
import hrsystem.auth.main.Account;
import hrsystem.auth.main.AccountSet;
import hrsystem.auth.main.Group;
import hrsystem.auth.main.GroupSet;
import hrsystem.auth.main.Permissions;
import hrsystem.auth.main.PermissionsSet;
import hrsystem.auth.main.impl.AccountSetImpl;
import hrsystem.auth.main.impl.GroupImpl;
import hrsystem.auth.main.impl.GroupSetImpl;
import hrsystem.auth.main.impl.PermissionsSetImpl;

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
        m_Description = "";
        R1_has__Account_set = new AccountSetImpl();
        R2_has_Group_set = new GroupSetImpl();
        R2_part_of_Group_inst = GroupImpl.EMPTY_GROUP;
        R3_has_Permissions_set = new PermissionsSetImpl();
    }

    private GroupImpl( Auth context, UniqueId instanceId, String m_Name, String m_Description ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        this.m_Description = m_Description;
        R1_has__Account_set = new AccountSetImpl();
        R2_has_Group_set = new GroupSetImpl();
        R2_part_of_Group_inst = GroupImpl.EMPTY_GROUP;
        R3_has_Permissions_set = new PermissionsSetImpl();
    }

    public static Group create( Auth context ) throws XtumlException {
        Group newGroup = new GroupImpl( context );
        if ( context.addInstance( newGroup ) ) {
            newGroup.getRunContext().addChange(new InstanceCreatedDelta(newGroup, KEY_LETTERS));
            return newGroup;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Group create( Auth context, UniqueId instanceId, String m_Name, String m_Description ) throws XtumlException {
        Group newGroup = new GroupImpl( context, instanceId, m_Name, m_Description );
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
    private String m_Description;
    @Override
    public void setDescription(String m_Description) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Description, this.m_Description)) {
            final String oldValue = this.m_Description;
            this.m_Description = m_Description;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Description", oldValue, this.m_Description));
        }
    }
    @Override
    public String getDescription() throws XtumlException {
        checkLiving();
        return m_Description;
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getName());
        }
        catch ( XtumlException e ) {
            getRunContext().getLog().error(e);
            System.exit(1);
            return null;
        }
    }

    // operations


    // static operations


    // events


    // selections
    private AccountSet R1_has__Account_set;
    @Override
    public void addR1_has__Account( Account inst ) {
        R1_has__Account_set.add(inst);
    }
    @Override
    public void removeR1_has__Account( Account inst ) {
        R1_has__Account_set.remove(inst);
    }
    @Override
    public AccountSet R1_has__Account() throws XtumlException {
        return R1_has__Account_set;
    }
    private GroupSet R2_has_Group_set;
    @Override
    public void addR2_has_Group( Group inst ) {
        R2_has_Group_set.add(inst);
    }
    @Override
    public void removeR2_has_Group( Group inst ) {
        R2_has_Group_set.remove(inst);
    }
    @Override
    public GroupSet R2_has_Group() throws XtumlException {
        return R2_has_Group_set;
    }
    private Group R2_part_of_Group_inst;
    @Override
    public void setR2_part_of_Group( Group inst ) {
        R2_part_of_Group_inst = inst;
    }
    @Override
    public Group R2_part_of_Group() throws XtumlException {
        return R2_part_of_Group_inst;
    }
    private PermissionsSet R3_has_Permissions_set;
    @Override
    public void addR3_has_Permissions( Permissions inst ) {
        R3_has_Permissions_set.add(inst);
    }
    @Override
    public void removeR3_has_Permissions( Permissions inst ) {
        R3_has_Permissions_set.remove(inst);
    }
    @Override
    public PermissionsSet R3_has_Permissions() throws XtumlException {
        return R3_has_Permissions_set;
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
    public void setDescription( String m_Description ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getDescription() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public AccountSet R1_has__Account() {
        return (new AccountSetImpl());
    }
    @Override
    public GroupSet R2_has_Group() {
        return (new GroupSetImpl());
    }
    @Override
    public Group R2_part_of_Group() {
        return GroupImpl.EMPTY_GROUP;
    }
    @Override
    public PermissionsSet R3_has_Permissions() {
        return (new PermissionsSetImpl());
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
