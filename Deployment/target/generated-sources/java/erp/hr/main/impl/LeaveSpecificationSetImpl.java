package erp.hr.main.impl;


import erp.hr.main.LeaveSet;
import erp.hr.main.LeaveSpecification;
import erp.hr.main.LeaveSpecificationSet;
import erp.hr.main.impl.LeaveSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class LeaveSpecificationSetImpl extends InstanceSet<LeaveSpecificationSet,LeaveSpecification> implements LeaveSpecificationSet {

    public LeaveSpecificationSetImpl() {
    }

    public LeaveSpecificationSetImpl(Comparator<? super LeaveSpecification> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setMaximumDays( int m_MaximumDays ) throws XtumlException {
        for ( LeaveSpecification leavespecification : this ) leavespecification.setMaximumDays( m_MaximumDays );
    }
    @Override
    public void setMinimumDays( int m_MinimumDays ) throws XtumlException {
        for ( LeaveSpecification leavespecification : this ) leavespecification.setMinimumDays( m_MinimumDays );
    }
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( LeaveSpecification leavespecification : this ) leavespecification.setName( m_Name );
    }


    // selections
    @Override
    public LeaveSet R15_specifies_Leave() throws XtumlException {
        LeaveSet leaveset = new LeaveSetImpl();
        for ( LeaveSpecification leavespecification : this ) leaveset.addAll( leavespecification.R15_specifies_Leave() );
        return leaveset;
    }


    @Override
    public LeaveSpecification nullElement() {
        return LeaveSpecificationImpl.EMPTY_LEAVESPECIFICATION;
    }

    @Override
    public LeaveSpecificationSet emptySet() {
      return new LeaveSpecificationSetImpl();
    }

    @Override
    public LeaveSpecificationSet emptySet(Comparator<? super LeaveSpecification> comp) {
      return new LeaveSpecificationSetImpl(comp);
    }

    @Override
    public List<LeaveSpecification> elements() {
        return Arrays.asList(toArray(new LeaveSpecification[0]));
    }

}
