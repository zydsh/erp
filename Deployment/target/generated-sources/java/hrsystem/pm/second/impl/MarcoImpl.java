package hrsystem.pm.second.impl;


import hrsystem.Pm;
import hrsystem.pm.second.Marco;
import hrsystem.pm.second.Polo;
import hrsystem.pm.second.PoloSet;
import hrsystem.pm.second.impl.PoloSetImpl;

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


public class MarcoImpl extends ModelInstance<Marco,Pm> implements Marco {

    public static final String KEY_LETTERS = "Marco";
    public static final Marco EMPTY_MARCO = new EmptyMarco();

    private Pm context;

    // constructors
    private MarcoImpl( Pm context ) {
        this.context = context;
        m_Name = "";
        R101_followed_by_Polo_set = new PoloSetImpl();
    }

    private MarcoImpl( Pm context, UniqueId instanceId, String m_Name ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        R101_followed_by_Polo_set = new PoloSetImpl();
    }

    public static Marco create( Pm context ) throws XtumlException {
        Marco newMarco = new MarcoImpl( context );
        if ( context.addInstance( newMarco ) ) {
            newMarco.getRunContext().addChange(new InstanceCreatedDelta(newMarco, KEY_LETTERS));
            return newMarco;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Marco create( Pm context, UniqueId instanceId, String m_Name ) throws XtumlException {
        Marco newMarco = new MarcoImpl( context, instanceId, m_Name );
        if ( context.addInstance( newMarco ) ) {
            return newMarco;
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
    private PoloSet R101_followed_by_Polo_set;
    @Override
    public void addR101_followed_by_Polo( Polo inst ) {
        R101_followed_by_Polo_set.add(inst);
    }
    @Override
    public void removeR101_followed_by_Polo( Polo inst ) {
        R101_followed_by_Polo_set.remove(inst);
    }
    @Override
    public PoloSet R101_followed_by_Polo() throws XtumlException {
        return R101_followed_by_Polo_set;
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
    public Marco self() {
        return this;
    }

    @Override
    public Marco oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_MARCO;
    }

}

class EmptyMarco extends ModelInstance<Marco,Pm> implements Marco {

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
    public PoloSet R101_followed_by_Polo() {
        return (new PoloSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return MarcoImpl.KEY_LETTERS;
    }

    @Override
    public Marco self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Marco oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return MarcoImpl.EMPTY_MARCO;
    }

}
