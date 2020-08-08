package hrsystem.hr.main.impl;


import hrsystem.hr.main.Grade;
import hrsystem.hr.main.GradeSet;
import hrsystem.hr.main.JobSet;
import hrsystem.hr.main.impl.JobSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class GradeSetImpl extends InstanceSet<GradeSet,Grade> implements GradeSet {

    public GradeSetImpl() {
    }

    public GradeSetImpl(Comparator<? super Grade> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setGValue( int m_GValue ) throws XtumlException {
        for ( Grade grade : this ) grade.setGValue( m_GValue );
    }


    // selections
    @Override
    public JobSet R5_Job() throws XtumlException {
        JobSet jobset = new JobSetImpl();
        for ( Grade grade : this ) jobset.addAll( grade.R5_Job() );
        return jobset;
    }


    @Override
    public Grade nullElement() {
        return GradeImpl.EMPTY_GRADE;
    }

    @Override
    public GradeSet emptySet() {
      return new GradeSetImpl();
    }

    @Override
    public GradeSet emptySet(Comparator<? super Grade> comp) {
      return new GradeSetImpl(comp);
    }

    @Override
    public List<Grade> elements() {
        return Arrays.asList(toArray(new Grade[0]));
    }

}
