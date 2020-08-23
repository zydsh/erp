package hrsystem.hr.main.impl;


import hrsystem.hr.main.Grade;
import hrsystem.hr.main.GradeSet;
import hrsystem.hr.main.JobSet;
import hrsystem.hr.main.ScaleSet;
import hrsystem.hr.main.impl.GradeSetImpl;
import hrsystem.hr.main.impl.JobSetImpl;
import hrsystem.hr.main.impl.ScaleSetImpl;

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
    public void setAllowance( double m_Allowance ) throws XtumlException {
        for ( Grade grade : this ) grade.setAllowance( m_Allowance );
    }
    @Override
    public void setNumberOfSteps( int m_NumberOfSteps ) throws XtumlException {
        for ( Grade grade : this ) grade.setNumberOfSteps( m_NumberOfSteps );
    }
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Grade grade : this ) grade.setName( m_Name );
    }
    @Override
    public void setBaseSalary( double m_BaseSalary ) throws XtumlException {
        for ( Grade grade : this ) grade.setBaseSalary( m_BaseSalary );
    }


    // selections
    @Override
    public ScaleSet R12_is_part_of_Scale() throws XtumlException {
        ScaleSet scaleset = new ScaleSetImpl();
        for ( Grade grade : this ) scaleset.add( grade.R12_is_part_of_Scale() );
        return scaleset;
    }
    @Override
    public GradeSet R14_follows_Grade() throws XtumlException {
        GradeSet gradeset = new GradeSetImpl();
        for ( Grade grade : this ) gradeset.add( grade.R14_follows_Grade() );
        return gradeset;
    }
    @Override
    public GradeSet R14_proceeds_Grade() throws XtumlException {
        GradeSet gradeset = new GradeSetImpl();
        for ( Grade grade : this ) gradeset.add( grade.R14_proceeds_Grade() );
        return gradeset;
    }
    @Override
    public JobSet R9_assigned_Job() throws XtumlException {
        JobSet jobset = new JobSetImpl();
        for ( Grade grade : this ) jobset.addAll( grade.R9_assigned_Job() );
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
