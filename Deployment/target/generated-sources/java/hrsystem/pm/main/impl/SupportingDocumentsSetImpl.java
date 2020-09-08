package hrsystem.pm.main.impl;


import hrsystem.pm.main.MilestoneSet;
import hrsystem.pm.main.SupportingDocuments;
import hrsystem.pm.main.SupportingDocumentsSet;
import hrsystem.pm.main.impl.MilestoneSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class SupportingDocumentsSetImpl extends InstanceSet<SupportingDocumentsSet,SupportingDocuments> implements SupportingDocumentsSet {

    public SupportingDocumentsSetImpl() {
    }

    public SupportingDocumentsSetImpl(Comparator<? super SupportingDocuments> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setNotes( String m_Notes ) throws XtumlException {
        for ( SupportingDocuments supportingdocuments : this ) supportingdocuments.setNotes( m_Notes );
    }
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( SupportingDocuments supportingdocuments : this ) supportingdocuments.setName( m_Name );
    }
    @Override
    public void setDocument( String m_Document ) throws XtumlException {
        for ( SupportingDocuments supportingdocuments : this ) supportingdocuments.setDocument( m_Document );
    }
    @Override
    public void setState( String m_State ) throws XtumlException {
        for ( SupportingDocuments supportingdocuments : this ) supportingdocuments.setState( m_State );
    }


    // selections
    @Override
    public MilestoneSet R3_evidance_for_Milestone() throws XtumlException {
        MilestoneSet milestoneset = new MilestoneSetImpl();
        for ( SupportingDocuments supportingdocuments : this ) milestoneset.add( supportingdocuments.R3_evidance_for_Milestone() );
        return milestoneset;
    }


    @Override
    public SupportingDocuments nullElement() {
        return SupportingDocumentsImpl.EMPTY_SUPPORTINGDOCUMENTS;
    }

    @Override
    public SupportingDocumentsSet emptySet() {
      return new SupportingDocumentsSetImpl();
    }

    @Override
    public SupportingDocumentsSet emptySet(Comparator<? super SupportingDocuments> comp) {
      return new SupportingDocumentsSetImpl(comp);
    }

    @Override
    public List<SupportingDocuments> elements() {
        return Arrays.asList(toArray(new SupportingDocuments[0]));
    }

}
