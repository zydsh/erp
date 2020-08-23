package hrsystem.hr.main.impl;


import hrsystem.hr.main.GradeSet;
import hrsystem.hr.main.Scale;
import hrsystem.hr.main.ScaleSet;
import hrsystem.hr.main.impl.GradeSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class ScaleSetImpl extends InstanceSet<ScaleSet,Scale> implements ScaleSet {

    public ScaleSetImpl() {
    }

    public ScaleSetImpl(Comparator<? super Scale> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Scale scale : this ) scale.setName( m_Name );
    }
    @Override
    public void setDescription( int m_Description ) throws XtumlException {
        for ( Scale scale : this ) scale.setDescription( m_Description );
    }


    // selections
    @Override
    public GradeSet R12_is_made_of_Grade() throws XtumlException {
        GradeSet gradeset = new GradeSetImpl();
        for ( Scale scale : this ) gradeset.addAll( scale.R12_is_made_of_Grade() );
        return gradeset;
    }


    @Override
    public Scale nullElement() {
        return ScaleImpl.EMPTY_SCALE;
    }

    @Override
    public ScaleSet emptySet() {
      return new ScaleSetImpl();
    }

    @Override
    public ScaleSet emptySet(Comparator<? super Scale> comp) {
      return new ScaleSetImpl(comp);
    }

    @Override
    public List<Scale> elements() {
        return Arrays.asList(toArray(new Scale[0]));
    }

}
