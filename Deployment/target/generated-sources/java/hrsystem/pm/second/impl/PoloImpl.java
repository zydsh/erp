package hrsystem.pm.second.impl;


import hrsystem.Pm;
import hrsystem.pm.second.Marco;
import hrsystem.pm.second.Polo;
import hrsystem.pm.second.impl.MarcoImpl;

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


public class PoloImpl extends ModelInstance<Polo,Pm> implements Polo {

    public static final String KEY_LETTERS = "Polo";
    public static final Polo EMPTY_POLO = new EmptyPolo();

    private Pm context;

    // constructors
    private PoloImpl( Pm context ) {
        this.context = context;
        m_Name = "";
        R101_follows_Marco_inst = MarcoImpl.EMPTY_MARCO;
    }

    private PoloImpl( Pm context, UniqueId instanceId, String m_Name ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        R101_follows_Marco_inst = MarcoImpl.EMPTY_MARCO;
    }

    public static Polo create( Pm context ) throws XtumlException {
        Polo newPolo = new PoloImpl( context );
        if ( context.addInstance( newPolo ) ) {
            newPolo.getRunContext().addChange(new InstanceCreatedDelta(newPolo, KEY_LETTERS));
            return newPolo;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Polo create( Pm context, UniqueId instanceId, String m_Name ) throws XtumlException {
        Polo newPolo = new PoloImpl( context, instanceId, m_Name );
        if ( context.addInstance( newPolo ) ) {
            return newPolo;
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


    // events


    // selections
    private Marco R101_follows_Marco_inst;
    @Override
    public void setR101_follows_Marco( Marco inst ) {
        R101_follows_Marco_inst = inst;
    }
    @Override
    public Marco R101_follows_Marco() throws XtumlException {
        return R101_follows_Marco_inst;
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
    public Polo self() {
        return this;
    }

    @Override
    public Polo oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_POLO;
    }

}

class EmptyPolo extends ModelInstance<Polo,Pm> implements Polo {

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
    public Marco R101_follows_Marco() {
        return MarcoImpl.EMPTY_MARCO;
    }


    @Override
    public String getKeyLetters() {
        return PoloImpl.KEY_LETTERS;
    }

    @Override
    public Polo self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Polo oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return PoloImpl.EMPTY_POLO;
    }

}
