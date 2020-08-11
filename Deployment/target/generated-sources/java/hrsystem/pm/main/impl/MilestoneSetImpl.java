package hrsystem.pm.main.impl;


import hrsystem.pm.main.InitiativeSet;
import hrsystem.pm.main.Milestone;
import hrsystem.pm.main.MilestoneSet;
import hrsystem.pm.main.Supporting_DocumentsSet;
import hrsystem.pm.main.impl.InitiativeSetImpl;
import hrsystem.pm.main.impl.Supporting_DocumentsSetImpl;

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
    public void setWeight( int m_Weight ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setWeight( m_Weight );
    }
    @Override
    public void setSd_Description( String m_sd_Description ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setSd_Description( m_sd_Description );
    }
    @Override
    public void setCode( String m_Code ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setCode( m_Code );
    }
    @Override
    public void setFull_Code( String m_Full_Code ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setFull_Code( m_Full_Code );
    }
    @Override
    public void setComplete_Planned( int m_Complete_Planned ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setComplete_Planned( m_Complete_Planned );
    }
    @Override
    public void setSd_State( String m_sd_State ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setSd_State( m_sd_State );
    }
    @Override
    public void setComplete_Actual( int m_Complete_Actual ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setComplete_Actual( m_Complete_Actual );
    }
    @Override
    public void setComplete( int m_Complete ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setComplete( m_Complete );
    }
    @Override
    public void setIncomplete_Reasons( String m_Incomplete_Reasons ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setIncomplete_Reasons( m_Incomplete_Reasons );
    }
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setName( m_Name );
    }
    @Override
    public void setNotes( String m_Notes ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setNotes( m_Notes );
    }
    @Override
    public void setType( String m_Type ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setType( m_Type );
    }
    @Override
    public void setPercentage( int m_Percentage ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setPercentage( m_Percentage );
    }
    @Override
    public void setSuccess_Criteria( String m_Success_Criteria ) throws XtumlException {
        for ( Milestone milestone : this ) milestone.setSuccess_Criteria( m_Success_Criteria );
    }


    // selections
    @Override
    public InitiativeSet R2_Initiative() throws XtumlException {
        InitiativeSet initiativeset = new InitiativeSetImpl();
        for ( Milestone milestone : this ) initiativeset.add( milestone.R2_Initiative() );
        return initiativeset;
    }
    @Override
    public Supporting_DocumentsSet R3_Supporting_Documents() throws XtumlException {
        Supporting_DocumentsSet supporting_documentsset = new Supporting_DocumentsSetImpl();
        for ( Milestone milestone : this ) supporting_documentsset.addAll( milestone.R3_Supporting_Documents() );
        return supporting_documentsset;
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
