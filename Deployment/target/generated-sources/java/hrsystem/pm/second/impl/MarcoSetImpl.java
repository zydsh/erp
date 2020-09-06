package hrsystem.pm.second.impl;


import hrsystem.pm.second.Marco;
import hrsystem.pm.second.MarcoSet;
import hrsystem.pm.second.PoloSet;
import hrsystem.pm.second.impl.PoloSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class MarcoSetImpl extends InstanceSet<MarcoSet,Marco> implements MarcoSet {

    public MarcoSetImpl() {
    }

    public MarcoSetImpl(Comparator<? super Marco> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Marco marco : this ) marco.setName( m_Name );
    }


    // selections
    @Override
    public PoloSet R101_followed_by_Polo() throws XtumlException {
        PoloSet poloset = new PoloSetImpl();
        for ( Marco marco : this ) poloset.addAll( marco.R101_followed_by_Polo() );
        return poloset;
    }


    @Override
    public Marco nullElement() {
        return MarcoImpl.EMPTY_MARCO;
    }

    @Override
    public MarcoSet emptySet() {
      return new MarcoSetImpl();
    }

    @Override
    public MarcoSet emptySet(Comparator<? super Marco> comp) {
      return new MarcoSetImpl(comp);
    }

    @Override
    public List<Marco> elements() {
        return Arrays.asList(toArray(new Marco[0]));
    }

}
