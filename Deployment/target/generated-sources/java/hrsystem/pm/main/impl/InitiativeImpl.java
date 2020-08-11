package hrsystem.pm.main.impl;


import hrsystem.Pm;
import hrsystem.pm.main.Initiative;

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


public class InitiativeImpl extends ModelInstance<Initiative,Pm> implements Initiative {

    public static final String KEY_LETTERS = "Initiative";
    public static final Initiative EMPTY_INITIATIVE = new EmptyInitiative();

    private Pm context;

    // constructors
    private InitiativeImpl( Pm context ) {
        this.context = context;
        m_Name = "";
    }

    private InitiativeImpl( Pm context, UniqueId instanceId, String m_Name ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
    }

    public static Initiative create( Pm context ) throws XtumlException {
        Initiative newInitiative = new InitiativeImpl( context );
        if ( context.addInstance( newInitiative ) ) {
            newInitiative.getRunContext().addChange(new InstanceCreatedDelta(newInitiative, KEY_LETTERS));
            return newInitiative;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Initiative create( Pm context, UniqueId instanceId, String m_Name ) throws XtumlException {
        Initiative newInitiative = new InitiativeImpl( context, instanceId, m_Name );
        if ( context.addInstance( newInitiative ) ) {
            return newInitiative;
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


    // instance identifiers

    // operations


    // static operations
    public static class CLASS extends ActionHome<Pm> {

        public CLASS( Pm context ) {
            super( context );
        }

        public void crud() throws XtumlException {
        }



    }


    // events


    // selections


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
    public Initiative self() {
        return this;
    }

    @Override
    public Initiative oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_INITIATIVE;
    }

}

class EmptyInitiative extends ModelInstance<Initiative,Pm> implements Initiative {

    // attributes
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections


    @Override
    public String getKeyLetters() {
        return InitiativeImpl.KEY_LETTERS;
    }

    @Override
    public Initiative self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Initiative oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return InitiativeImpl.EMPTY_INITIATIVE;
    }

}
