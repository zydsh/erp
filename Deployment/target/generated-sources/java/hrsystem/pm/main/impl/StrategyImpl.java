package hrsystem.pm.main.impl;


import hrsystem.Pm;
import hrsystem.pm.main.Initiative;
import hrsystem.pm.main.InitiativeSet;
import hrsystem.pm.main.Strategy;
import hrsystem.pm.main.impl.InitiativeSetImpl;

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


public class StrategyImpl extends ModelInstance<Strategy,Pm> implements Strategy {

    public static final String KEY_LETTERS = "Strategy";
    public static final Strategy EMPTY_STRATEGY = new EmptyStrategy();

    private Pm context;

    // constructors
    private StrategyImpl( Pm context ) {
        this.context = context;
        m_Number = "";
        m_Name = "";
        m_Description = "";
        R10_implemented_by_Initiative_set = new InitiativeSetImpl();
    }

    private StrategyImpl( Pm context, UniqueId instanceId, String m_Number, String m_Name, String m_Description ) {
        super(instanceId);
        this.context = context;
        this.m_Number = m_Number;
        this.m_Name = m_Name;
        this.m_Description = m_Description;
        R10_implemented_by_Initiative_set = new InitiativeSetImpl();
    }

    public static Strategy create( Pm context ) throws XtumlException {
        Strategy newStrategy = new StrategyImpl( context );
        if ( context.addInstance( newStrategy ) ) {
            newStrategy.getRunContext().addChange(new InstanceCreatedDelta(newStrategy, KEY_LETTERS));
            return newStrategy;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Strategy create( Pm context, UniqueId instanceId, String m_Number, String m_Name, String m_Description ) throws XtumlException {
        Strategy newStrategy = new StrategyImpl( context, instanceId, m_Number, m_Name, m_Description );
        if ( context.addInstance( newStrategy ) ) {
            return newStrategy;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private String m_Number;
    @Override
    public String getNumber() throws XtumlException {
        checkLiving();
        return m_Number;
    }
    @Override
    public void setNumber(String m_Number) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Number, this.m_Number)) {
            final String oldValue = this.m_Number;
            this.m_Number = m_Number;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Number", oldValue, this.m_Number));
        }
    }
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
    @Override
    public IInstanceIdentifier getId2() {
        try {
            return new InstanceIdentifier(getNumber());
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
    private InitiativeSet R10_implemented_by_Initiative_set;
    @Override
    public void addR10_implemented_by_Initiative( Initiative inst ) {
        R10_implemented_by_Initiative_set.add(inst);
    }
    @Override
    public void removeR10_implemented_by_Initiative( Initiative inst ) {
        R10_implemented_by_Initiative_set.remove(inst);
    }
    @Override
    public InitiativeSet R10_implemented_by_Initiative() throws XtumlException {
        return R10_implemented_by_Initiative_set;
    }


    @Override
    public IRunContext getRunContext() {
        return context().getRunContext();
    }

    @Override
    public Pm context() {
        return context;
    }

    @Override
    public String getKeyLetters() {
        return KEY_LETTERS;
    }

    @Override
    public Strategy self() {
        return this;
    }

    @Override
    public Strategy oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_STRATEGY;
    }

}

class EmptyStrategy extends ModelInstance<Strategy,Pm> implements Strategy {

    // attributes
    public String getNumber() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setNumber( String m_Number ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
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
    public InitiativeSet R10_implemented_by_Initiative() {
        return (new InitiativeSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return StrategyImpl.KEY_LETTERS;
    }

    @Override
    public Strategy self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Strategy oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return StrategyImpl.EMPTY_STRATEGY;
    }

}
