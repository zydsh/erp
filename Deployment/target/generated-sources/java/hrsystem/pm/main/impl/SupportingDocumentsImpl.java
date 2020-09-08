package hrsystem.pm.main.impl;


import hrsystem.Pm;
import hrsystem.pm.main.Milestone;
import hrsystem.pm.main.SupportingDocuments;
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


public class SupportingDocumentsImpl extends ModelInstance<SupportingDocuments,Pm> implements SupportingDocuments {

    public static final String KEY_LETTERS = "SupportingDocuments";
    public static final SupportingDocuments EMPTY_SUPPORTINGDOCUMENTS = new EmptySupportingDocuments();

    private Pm context;

    // constructors
    private SupportingDocumentsImpl( Pm context ) {
        this.context = context;
        m_Name = "";
        m_Document = "";
        m_State = "";
        m_Notes = "";
        R3_evidance_for_Milestone_inst = MilestoneImpl.EMPTY_MILESTONE;
    }

    private SupportingDocumentsImpl( Pm context, UniqueId instanceId, String m_Name, String m_Document, String m_State, String m_Notes ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        this.m_Document = m_Document;
        this.m_State = m_State;
        this.m_Notes = m_Notes;
        R3_evidance_for_Milestone_inst = MilestoneImpl.EMPTY_MILESTONE;
    }

    public static SupportingDocuments create( Pm context ) throws XtumlException {
        SupportingDocuments newSupportingDocuments = new SupportingDocumentsImpl( context );
        if ( context.addInstance( newSupportingDocuments ) ) {
            newSupportingDocuments.getRunContext().addChange(new InstanceCreatedDelta(newSupportingDocuments, KEY_LETTERS));
            return newSupportingDocuments;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static SupportingDocuments create( Pm context, UniqueId instanceId, String m_Name, String m_Document, String m_State, String m_Notes ) throws XtumlException {
        SupportingDocuments newSupportingDocuments = new SupportingDocumentsImpl( context, instanceId, m_Name, m_Document, m_State, m_Notes );
        if ( context.addInstance( newSupportingDocuments ) ) {
            return newSupportingDocuments;
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
    private String m_Document;
    @Override
    public void setDocument(String m_Document) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Document, this.m_Document)) {
            final String oldValue = this.m_Document;
            this.m_Document = m_Document;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Document", oldValue, this.m_Document));
        }
    }
    @Override
    public String getDocument() throws XtumlException {
        checkLiving();
        return m_Document;
    }
    private String m_State;
    @Override
    public String getState() throws XtumlException {
        checkLiving();
        return m_State;
    }
    @Override
    public void setState(String m_State) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_State, this.m_State)) {
            final String oldValue = this.m_State;
            this.m_State = m_State;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_State", oldValue, this.m_State));
        }
    }
    private String m_Notes;
    @Override
    public void setNotes(String m_Notes) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Notes, this.m_Notes)) {
            final String oldValue = this.m_Notes;
            this.m_Notes = m_Notes;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Notes", oldValue, this.m_Notes));
        }
    }
    @Override
    public String getNotes() throws XtumlException {
        checkLiving();
        return m_Notes;
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
    public SupportingDocuments self() {
        return this;
    }

    @Override
    public SupportingDocuments oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_SUPPORTINGDOCUMENTS;
    }

}

class EmptySupportingDocuments extends ModelInstance<SupportingDocuments,Pm> implements SupportingDocuments {

    // attributes
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setDocument( String m_Document ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getDocument() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public String getState() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setState( String m_State ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setNotes( String m_Notes ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getNotes() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Milestone R3_evidance_for_Milestone() {
        return MilestoneImpl.EMPTY_MILESTONE;
    }


    @Override
    public String getKeyLetters() {
        return SupportingDocumentsImpl.KEY_LETTERS;
    }

    @Override
    public SupportingDocuments self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public SupportingDocuments oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return SupportingDocumentsImpl.EMPTY_SUPPORTINGDOCUMENTS;
    }

}
