package hrsystem.pm.main.impl;


import hrsystem.Pm;
import hrsystem.pm.main.Initiative;
import hrsystem.pm.main.InitiativeSet;
import hrsystem.pm.main.Strategy;
import hrsystem.pm.main.impl.InitiativeSetImpl;

import io.ciera.runtime.instanceloading.AttributeChangedDelta;
import io.ciera.runtime.instanceloading.InstanceCreatedDelta;
import io.ciera.runtime.summit.application.ActionHome;
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
        m_Name = "";
        m_Description = "";
        m_Number = "";
        R1_Initiative_set = new InitiativeSetImpl();
    }

    private StrategyImpl( Pm context, UniqueId instanceId, String m_Name, String m_Description, String m_Number ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        this.m_Description = m_Description;
        this.m_Number = m_Number;
        R1_Initiative_set = new InitiativeSetImpl();
    }

    public static Strategy create( Pm context ) throws XtumlException {
        Strategy newStrategy = new StrategyImpl( context );
        if ( context.addInstance( newStrategy ) ) {
            newStrategy.getRunContext().addChange(new InstanceCreatedDelta(newStrategy, KEY_LETTERS));
            return newStrategy;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Strategy create( Pm context, UniqueId instanceId, String m_Name, String m_Description, String m_Number ) throws XtumlException {
        Strategy newStrategy = new StrategyImpl( context, instanceId, m_Name, m_Description, m_Number );
        if ( context.addInstance( newStrategy ) ) {
            return newStrategy;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private String m_Name;
    @Override
    public void setName(String m_Name) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Name, this.m_Name)) {
            final String oldValue = this.m_Name;
            this.m_Name = m_Name;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Name", oldValue, this.m_Name));
        }
    }
    @Override
    public String getName() throws XtumlException {
        checkLiving();
        return m_Name;
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
    private String m_Number;
    @Override
    public void setNumber(String m_Number) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Number, this.m_Number)) {
            final String oldValue = this.m_Number;
            this.m_Number = m_Number;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Number", oldValue, this.m_Number));
        }
    }
    @Override
    public String getNumber() throws XtumlException {
        checkLiving();
        return m_Number;
    }


    // instance identifiers

    // operations


    // static operations
    public static class CLASS extends ActionHome<Pm> {

        public CLASS( Pm context ) {
            super( context );
        }

        public void crud( final String p_Name,  final String p_Number,  final String p_Description,  final String p_Action ) throws XtumlException {
        }



    }


    // events


    // selections
    private InitiativeSet R1_Initiative_set;
    @Override
    public void addR1_Initiative( Initiative inst ) {
        R1_Initiative_set.add(inst);
    }
    @Override
    public void removeR1_Initiative( Initiative inst ) {
        R1_Initiative_set.remove(inst);
    }
    @Override
    public InitiativeSet R1_Initiative() throws XtumlException {
        return R1_Initiative_set;
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
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setDescription( String m_Description ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getDescription() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setNumber( String m_Number ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getNumber() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public InitiativeSet R1_Initiative() {
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
