package hrsystem.pm.main.impl;


import hrsystem.pm.main.MilestoneSet;
import hrsystem.pm.main.Supporting_Documents;
import hrsystem.pm.main.Supporting_DocumentsSet;
import hrsystem.pm.main.impl.MilestoneSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Supporting_DocumentsSetImpl extends InstanceSet<Supporting_DocumentsSet,Supporting_Documents> implements Supporting_DocumentsSet {

    public Supporting_DocumentsSetImpl() {
    }

    public Supporting_DocumentsSetImpl(Comparator<? super Supporting_Documents> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setState( String m_State ) throws XtumlException {
        for ( Supporting_Documents supporting_documents : this ) supporting_documents.setState( m_State );
    }
    @Override
    public void setNotes( String m_Notes ) throws XtumlException {
        for ( Supporting_Documents supporting_documents : this ) supporting_documents.setNotes( m_Notes );
    }
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Supporting_Documents supporting_documents : this ) supporting_documents.setName( m_Name );
    }
    @Override
    public void setDocument( String m_Document ) throws XtumlException {
        for ( Supporting_Documents supporting_documents : this ) supporting_documents.setDocument( m_Document );
    }


    // selections
    @Override
    public MilestoneSet R3_evidance_for_Milestone() throws XtumlException {
        MilestoneSet milestoneset = new MilestoneSetImpl();
        for ( Supporting_Documents supporting_documents : this ) milestoneset.add( supporting_documents.R3_evidance_for_Milestone() );
        return milestoneset;
    }


    @Override
    public Supporting_Documents nullElement() {
        return Supporting_DocumentsImpl.EMPTY_SUPPORTING_DOCUMENTS;
    }

    @Override
    public Supporting_DocumentsSet emptySet() {
      return new Supporting_DocumentsSetImpl();
    }

    @Override
    public Supporting_DocumentsSet emptySet(Comparator<? super Supporting_Documents> comp) {
      return new Supporting_DocumentsSetImpl(comp);
    }

    @Override
    public List<Supporting_Documents> elements() {
        return Arrays.asList(toArray(new Supporting_Documents[0]));
    }

}
