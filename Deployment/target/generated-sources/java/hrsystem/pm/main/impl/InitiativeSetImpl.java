package hrsystem.pm.main.impl;


import hrsystem.pm.main.Initiative;
import hrsystem.pm.main.InitiativeSet;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class InitiativeSetImpl extends InstanceSet<InitiativeSet,Initiative> implements InitiativeSet {

    public InitiativeSetImpl() {
    }

    public InitiativeSetImpl(Comparator<? super Initiative> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Initiative initiative : this ) initiative.setName( m_Name );
    }


    // selections


    @Override
    public Initiative nullElement() {
        return InitiativeImpl.EMPTY_INITIATIVE;
    }

    @Override
    public InitiativeSet emptySet() {
      return new InitiativeSetImpl();
    }

    @Override
    public InitiativeSet emptySet(Comparator<? super Initiative> comp) {
      return new InitiativeSetImpl(comp);
    }

    @Override
    public List<Initiative> elements() {
        return Arrays.asList(toArray(new Initiative[0]));
    }

}
