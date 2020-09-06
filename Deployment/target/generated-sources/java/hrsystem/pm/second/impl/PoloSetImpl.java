package hrsystem.pm.second.impl;


import hrsystem.pm.second.MarcoSet;
import hrsystem.pm.second.Polo;
import hrsystem.pm.second.PoloSet;
import hrsystem.pm.second.impl.MarcoSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class PoloSetImpl extends InstanceSet<PoloSet,Polo> implements PoloSet {

    public PoloSetImpl() {
    }

    public PoloSetImpl(Comparator<? super Polo> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Polo polo : this ) polo.setName( m_Name );
    }


    // selections
    @Override
    public MarcoSet R101_follows_Marco() throws XtumlException {
        MarcoSet marcoset = new MarcoSetImpl();
        for ( Polo polo : this ) marcoset.add( polo.R101_follows_Marco() );
        return marcoset;
    }


    @Override
    public Polo nullElement() {
        return PoloImpl.EMPTY_POLO;
    }

    @Override
    public PoloSet emptySet() {
      return new PoloSetImpl();
    }

    @Override
    public PoloSet emptySet(Comparator<? super Polo> comp) {
      return new PoloSetImpl(comp);
    }

    @Override
    public List<Polo> elements() {
        return Arrays.asList(toArray(new Polo[0]));
    }

}
