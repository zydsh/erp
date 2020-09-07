package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Leave;
import hrsystem.hr.main.LeaveSet;
import hrsystem.hr.main.LeaveSpecification;
import hrsystem.hr.main.impl.LeaveSetImpl;

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


public class LeaveSpecificationImpl extends ModelInstance<LeaveSpecification,Hr> implements LeaveSpecification {

    public static final String KEY_LETTERS = "LeaveSpecification";
    public static final LeaveSpecification EMPTY_LEAVESPECIFICATION = new EmptyLeaveSpecification();

    private Hr context;

    // constructors
    private LeaveSpecificationImpl( Hr context ) {
        this.context = context;
        m_Name = "";
        m_MaximumDays = 0;
        m_MinimumDays = 0;
        R15_specifies_Leave_set = new LeaveSetImpl();
    }

    private LeaveSpecificationImpl( Hr context, UniqueId instanceId, String m_Name, int m_MaximumDays, int m_MinimumDays ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        this.m_MaximumDays = m_MaximumDays;
        this.m_MinimumDays = m_MinimumDays;
        R15_specifies_Leave_set = new LeaveSetImpl();
    }

    public static LeaveSpecification create( Hr context ) throws XtumlException {
        LeaveSpecification newLeaveSpecification = new LeaveSpecificationImpl( context );
        if ( context.addInstance( newLeaveSpecification ) ) {
            newLeaveSpecification.getRunContext().addChange(new InstanceCreatedDelta(newLeaveSpecification, KEY_LETTERS));
            return newLeaveSpecification;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static LeaveSpecification create( Hr context, UniqueId instanceId, String m_Name, int m_MaximumDays, int m_MinimumDays ) throws XtumlException {
        LeaveSpecification newLeaveSpecification = new LeaveSpecificationImpl( context, instanceId, m_Name, m_MaximumDays, m_MinimumDays );
        if ( context.addInstance( newLeaveSpecification ) ) {
            return newLeaveSpecification;
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
    private int m_MaximumDays;
    @Override
    public int getMaximumDays() throws XtumlException {
        checkLiving();
        return m_MaximumDays;
    }
    @Override
    public void setMaximumDays(int m_MaximumDays) throws XtumlException {
        checkLiving();
        if (m_MaximumDays != this.m_MaximumDays) {
            final int oldValue = this.m_MaximumDays;
            this.m_MaximumDays = m_MaximumDays;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_MaximumDays", oldValue, this.m_MaximumDays));
        }
    }
    private int m_MinimumDays;
    @Override
    public int getMinimumDays() throws XtumlException {
        checkLiving();
        return m_MinimumDays;
    }
    @Override
    public void setMinimumDays(int m_MinimumDays) throws XtumlException {
        checkLiving();
        if (m_MinimumDays != this.m_MinimumDays) {
            final int oldValue = this.m_MinimumDays;
            this.m_MinimumDays = m_MinimumDays;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_MinimumDays", oldValue, this.m_MinimumDays));
        }
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
    private LeaveSet R15_specifies_Leave_set;
    @Override
    public void addR15_specifies_Leave( Leave inst ) {
        R15_specifies_Leave_set.add(inst);
    }
    @Override
    public void removeR15_specifies_Leave( Leave inst ) {
        R15_specifies_Leave_set.remove(inst);
    }
    @Override
    public LeaveSet R15_specifies_Leave() throws XtumlException {
        return R15_specifies_Leave_set;
    }


    @Override
    public IRunContext getRunContext() {
        return context().getRunContext();
    }

    @Override
    public Hr context() {
        return context;
    }

    @Override
    public String getKeyLetters() {
        return KEY_LETTERS;
    }

    @Override
    public LeaveSpecification self() {
        return this;
    }

    @Override
    public LeaveSpecification oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_LEAVESPECIFICATION;
    }

}

class EmptyLeaveSpecification extends ModelInstance<LeaveSpecification,Hr> implements LeaveSpecification {

    // attributes
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getMaximumDays() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setMaximumDays( int m_MaximumDays ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getMinimumDays() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setMinimumDays( int m_MinimumDays ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public LeaveSet R15_specifies_Leave() {
        return (new LeaveSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return LeaveSpecificationImpl.KEY_LETTERS;
    }

    @Override
    public LeaveSpecification self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public LeaveSpecification oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return LeaveSpecificationImpl.EMPTY_LEAVESPECIFICATION;
    }

}
