package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Grade;
import hrsystem.hr.main.GradeSet;
import hrsystem.hr.main.Scale;
import hrsystem.hr.main.impl.GradeSetImpl;

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


public class ScaleImpl extends ModelInstance<Scale,Hr> implements Scale {

    public static final String KEY_LETTERS = "Scale";
    public static final Scale EMPTY_SCALE = new EmptyScale();

    private Hr context;

    // constructors
    private ScaleImpl( Hr context ) {
        this.context = context;
        m_Name = "";
        m_Description = 0;
        R12_is_made_of_Grade_set = new GradeSetImpl();
    }

    private ScaleImpl( Hr context, UniqueId instanceId, String m_Name, int m_Description ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        this.m_Description = m_Description;
        R12_is_made_of_Grade_set = new GradeSetImpl();
    }

    public static Scale create( Hr context ) throws XtumlException {
        Scale newScale = new ScaleImpl( context );
        if ( context.addInstance( newScale ) ) {
            newScale.getRunContext().addChange(new InstanceCreatedDelta(newScale, KEY_LETTERS));
            return newScale;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Scale create( Hr context, UniqueId instanceId, String m_Name, int m_Description ) throws XtumlException {
        Scale newScale = new ScaleImpl( context, instanceId, m_Name, m_Description );
        if ( context.addInstance( newScale ) ) {
            return newScale;
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
    private int m_Description;
    @Override
    public void setDescription(int m_Description) throws XtumlException {
        checkLiving();
        if (m_Description != this.m_Description) {
            final int oldValue = this.m_Description;
            this.m_Description = m_Description;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Description", oldValue, this.m_Description));
        }
    }
    @Override
    public int getDescription() throws XtumlException {
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
    private GradeSet R12_is_made_of_Grade_set;
    @Override
    public void addR12_is_made_of_Grade( Grade inst ) {
        R12_is_made_of_Grade_set.add(inst);
    }
    @Override
    public void removeR12_is_made_of_Grade( Grade inst ) {
        R12_is_made_of_Grade_set.remove(inst);
    }
    @Override
    public GradeSet R12_is_made_of_Grade() throws XtumlException {
        return R12_is_made_of_Grade_set;
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
    public Scale self() {
        return this;
    }

    @Override
    public Scale oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_SCALE;
    }

}

class EmptyScale extends ModelInstance<Scale,Hr> implements Scale {

    // attributes
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setDescription( int m_Description ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getDescription() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public GradeSet R12_is_made_of_Grade() {
        return (new GradeSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return ScaleImpl.KEY_LETTERS;
    }

    @Override
    public Scale self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Scale oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return ScaleImpl.EMPTY_SCALE;
    }

}
