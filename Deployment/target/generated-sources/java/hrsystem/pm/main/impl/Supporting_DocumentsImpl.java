package hrsystem.pm.main.impl;


import hrsystem.Pm;
import hrsystem.pm.main.Milestone;
import hrsystem.pm.main.Supporting_Documents;
import hrsystem.pm.main.impl.MilestoneImpl;

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


public class Supporting_DocumentsImpl extends ModelInstance<Supporting_Documents,Pm> implements Supporting_Documents {

    public static final String KEY_LETTERS = "Supporting_Documents";
    public static final Supporting_Documents EMPTY_SUPPORTING_DOCUMENTS = new EmptySupporting_Documents();

    private Pm context;

    // constructors
    private Supporting_DocumentsImpl( Pm context ) {
        this.context = context;
        m_Name = "";
        R3_evidance_for_Milestone_inst = MilestoneImpl.EMPTY_MILESTONE;
    }

    private Supporting_DocumentsImpl( Pm context, UniqueId instanceId, String m_Name ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        R3_evidance_for_Milestone_inst = MilestoneImpl.EMPTY_MILESTONE;
    }

    public static Supporting_Documents create( Pm context ) throws XtumlException {
        Supporting_Documents newSupporting_Documents = new Supporting_DocumentsImpl( context );
        if ( context.addInstance( newSupporting_Documents ) ) {
            newSupporting_Documents.getRunContext().addChange(new InstanceCreatedDelta(newSupporting_Documents, KEY_LETTERS));
            return newSupporting_Documents;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Supporting_Documents create( Pm context, UniqueId instanceId, String m_Name ) throws XtumlException {
        Supporting_Documents newSupporting_Documents = new Supporting_DocumentsImpl( context, instanceId, m_Name );
        if ( context.addInstance( newSupporting_Documents ) ) {
            return newSupporting_Documents;
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
    private Milestone R3_evidance_for_Milestone_inst;
    @Override
    public void setR3_evidance_for_Milestone( Milestone inst ) {
        R3_evidance_for_Milestone_inst = inst;
    }
    @Override
    public Milestone R3_evidance_for_Milestone() throws XtumlException {
        return R3_evidance_for_Milestone_inst;
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
    public Supporting_Documents self() {
        return this;
    }

    @Override
    public Supporting_Documents oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_SUPPORTING_DOCUMENTS;
    }

}

class EmptySupporting_Documents extends ModelInstance<Supporting_Documents,Pm> implements Supporting_Documents {

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
    public Milestone R3_evidance_for_Milestone() {
        return MilestoneImpl.EMPTY_MILESTONE;
    }


    @Override
    public String getKeyLetters() {
        return Supporting_DocumentsImpl.KEY_LETTERS;
    }

    @Override
    public Supporting_Documents self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Supporting_Documents oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return Supporting_DocumentsImpl.EMPTY_SUPPORTING_DOCUMENTS;
    }

}
