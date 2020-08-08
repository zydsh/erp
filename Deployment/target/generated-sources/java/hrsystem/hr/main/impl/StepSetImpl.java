package hrsystem.hr.main.impl;


import hrsystem.hr.main.JobSet;
import hrsystem.hr.main.Step;
import hrsystem.hr.main.StepSet;
import hrsystem.hr.main.impl.JobSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class StepSetImpl extends InstanceSet<StepSet,Step> implements StepSet {

    public StepSetImpl() {
    }

    public StepSetImpl(Comparator<? super Step> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setSValue( int m_SValue ) throws XtumlException {
        for ( Step step : this ) step.setSValue( m_SValue );
    }


    // selections
    @Override
    public JobSet R5_Job() throws XtumlException {
        JobSet jobset = new JobSetImpl();
        for ( Step step : this ) jobset.addAll( step.R5_Job() );
        return jobset;
    }


    @Override
    public Step nullElement() {
        return StepImpl.EMPTY_STEP;
    }

    @Override
    public StepSet emptySet() {
      return new StepSetImpl();
    }

    @Override
    public StepSet emptySet(Comparator<? super Step> comp) {
      return new StepSetImpl(comp);
    }

    @Override
    public List<Step> elements() {
        return Arrays.asList(toArray(new Step[0]));
    }

}
