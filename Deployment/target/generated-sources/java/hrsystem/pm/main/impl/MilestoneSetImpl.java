package hrsystem.pm.main.impl;


import hrsystem.pm.main.InitiativeSet;
import hrsystem.pm.main.Milestone;
import hrsystem.pm.main.MilestoneSet;
import hrsystem.pm.main.ProjectSet;
import hrsystem.pm.main.SupportingDocumentsSet;
import hrsystem.pm.main.impl.InitiativeSetImpl;
import hrsystem.pm.main.impl.ProjectSetImpl;
import hrsystem.pm.main.impl.SupportingDocumentsSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class MilestoneSetImpl extends InstanceSet<MilestoneSet,Milestone> implements MilestoneSet {

    public MilestoneSetImpl() {
    }

    public MilestoneSetImpl(Comparator<? super Milestone> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setNotes( String m_Notes ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setNotes( m_Notes );
    }
    @Override
    public void setCode( String m_Code ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setCode( m_Code );
    }
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setName( m_Name );
    }
    @Override
    public void setComplete( boolean m_Complete ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setComplete( m_Complete );
    }
    @Override
    public void setIncompleteReasons( String m_IncompleteReasons ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setIncompleteReasons( m_IncompleteReasons );
    }
    @Override
    public void setCompletePlanned( int m_CompletePlanned ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setCompletePlanned( m_CompletePlanned );
    }
    @Override
    public void setSdState( String m_sdState ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setSdState( m_sdState );
    }
    @Override
    public void setPercentage( double m_Percentage ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setPercentage( m_Percentage );
    }
    @Override
    public void setSdDescription( String m_sdDescription ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setSdDescription( m_sdDescription );
    }
    @Override
    public void setFullCode( String m_FullCode ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setFullCode( m_FullCode );
    }
    @Override
    public void setWeight( int m_Weight ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setWeight( m_Weight );
    }
    @Override
    public void setCompleteActual( int m_CompleteActual ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setCompleteActual( m_CompleteActual );
    }
    @Override
    public void setSuccessCriteria( String m_SuccessCriteria ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setSuccessCriteria( m_SuccessCriteria );
    }
    @Override
    public void setType( String m_Type ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setType( m_Type );
    }


    // selections
    @Override
    public SupportingDocumentsSet R3_completed_with_SupportingDocuments() throws XtumlException {
        SupportingDocumentsSet supportingdocumentsset = new SupportingDocumentsSetImpl();
        for ( Milestone milestone : this ) supportingdocumentsset.addAll( milestone.R3_completed_with_SupportingDocuments() );
        return supportingdocumentsset;
    }
    @Override
    public InitiativeSet R60_achieved_by_Initiative() throws XtumlException {
        InitiativeSet initiativeset = new InitiativeSetImpl();
        for ( Milestone milestone : this ) initiativeset.add( milestone.R60_achieved_by_Initiative() );
        return initiativeset;
    }
    @Override
    public ProjectSet R8_marks_the_development_of_Project() throws XtumlException {
        ProjectSet projectset = new ProjectSetImpl();
        for ( Milestone milestone : this ) projectset.add( milestone.R8_marks_the_development_of_Project() );
        return projectset;
    }


    @Override
    public Milestone nullElement() {
        return MilestoneImpl.EMPTY_MILESTONE;
    }

    @Override
    public MilestoneSet emptySet() {
      return new MilestoneSetImpl();
    }

    @Override
    public MilestoneSet emptySet(Comparator<? super Milestone> comp) {
      return new MilestoneSetImpl(comp);
    }

    @Override
    public List<Milestone> elements() {
        return Arrays.asList(toArray(new Milestone[0]));
    }

}
