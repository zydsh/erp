package hrsystem.pm.main.impl;


import hrsystem.pm.main.InitiativeSet;
import hrsystem.pm.main.Project;
import hrsystem.pm.main.ProjectSet;
import hrsystem.pm.main.impl.InitiativeSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class ProjectSetImpl extends InstanceSet<ProjectSet,Project> implements ProjectSet {

    public ProjectSetImpl() {
    }

    public ProjectSetImpl(Comparator<? super Project> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setName( String m_Name ) throws XtumlException {
        for ( Project project : this ) project.setName( m_Name );
    }


    // selections
    @Override
    public InitiativeSet R4_defined_by_Initiative() throws XtumlException {
        InitiativeSet initiativeset = new InitiativeSetImpl();
        for ( Project project : this ) initiativeset.add( project.R4_defined_by_Initiative() );
        return initiativeset;
    }


    @Override
    public Project nullElement() {
        return ProjectImpl.EMPTY_PROJECT;
    }

    @Override
    public ProjectSet emptySet() {
      return new ProjectSetImpl();
    }

    @Override
    public ProjectSet emptySet(Comparator<? super Project> comp) {
      return new ProjectSetImpl(comp);
    }

    @Override
    public List<Project> elements() {
        return Arrays.asList(toArray(new Project[0]));
    }

}
