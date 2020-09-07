package hrsystem.pm.main.impl;


import hrsystem.Pm;
import hrsystem.pm.main.Initiative;
import hrsystem.pm.main.Milestone;
import hrsystem.pm.main.MilestoneSet;
import hrsystem.pm.main.Project;
import hrsystem.pm.main.impl.InitiativeImpl;
import hrsystem.pm.main.impl.MilestoneSetImpl;

import io.ciera.runtime.instanceloading.AttributeChangedDelta;
import io.ciera.runtime.instanceloading.InstanceCreatedDelta;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.classes.IInstanceIdentifier;
import io.ciera.runtime.summit.classes.InstanceIdentifier;
import io.ciera.runtime.summit.classes.ModelInstance;
import io.ciera.runtime.summit.exceptions.EmptyInstanceException;
import io.ciera.runtime.summit.exceptions.InstancePopulationException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.statemachine.IEvent;
import io.ciera.runtime.summit.types.IWhere;
import io.ciera.runtime.summit.types.IXtumlType;
import io.ciera.runtime.summit.types.StringUtil;
import io.ciera.runtime.summit.types.UniqueId;


public class ProjectImpl extends ModelInstance<Project,Pm> implements Project {

    public static final String KEY_LETTERS = "Project";
    public static final Project EMPTY_PROJECT = new EmptyProject();

    private Pm context;

    // constructors
    private ProjectImpl( Pm context ) {
        this.context = context;
        m_Name = "";
        R5_implements_Initiative_inst = InitiativeImpl.EMPTY_INITIATIVE;
        R8_reaches_Milestone_set = new MilestoneSetImpl();
        statemachine = new ProjectStateMachine(this, context());
    }

    private ProjectImpl( Pm context, UniqueId instanceId, String m_Name, int initialState ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        R5_implements_Initiative_inst = InitiativeImpl.EMPTY_INITIATIVE;
        R8_reaches_Milestone_set = new MilestoneSetImpl();
        statemachine = new ProjectStateMachine(this, context(), initialState);
    }

    public static Project create( Pm context ) throws XtumlException {
        Project newProject = new ProjectImpl( context );
        if ( context.addInstance( newProject ) ) {
            newProject.getRunContext().addChange(new InstanceCreatedDelta(newProject, KEY_LETTERS));
            return newProject;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Project create( Pm context, UniqueId instanceId, String m_Name, int initialState ) throws XtumlException {
        Project newProject = new ProjectImpl( context, instanceId, m_Name, initialState );
        if ( context.addInstance( newProject ) ) {
            return newProject;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    private final ProjectStateMachine statemachine;
    
    @Override
    public void accept(IEvent event) throws XtumlException {
        statemachine.transition(event);
    }

    @Override
    public int getCurrentState() {
        return statemachine.getCurrentState();
    }


    // attributes
    private String m_Name;
    @Override
    public String getName() throws XtumlException {
        checkLiving();
        return m_Name;
    }
    @Override
    public void setName(String m_Name) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Name, this.m_Name)) {
            final String oldValue = this.m_Name;
            this.m_Name = m_Name;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Name", oldValue, this.m_Name));
        }
    }


    // instance identifiers

    // operations


    // static operations


    // events


    // selections
    private Initiative R5_implements_Initiative_inst;
    @Override
    public void setR5_implements_Initiative( Initiative inst ) {
        R5_implements_Initiative_inst = inst;
    }
    @Override
    public Initiative R5_implements_Initiative() throws XtumlException {
        return R5_implements_Initiative_inst;
    }
    private MilestoneSet R8_reaches_Milestone_set;
    @Override
    public void addR8_reaches_Milestone( Milestone inst ) {
        R8_reaches_Milestone_set.add(inst);
    }
    @Override
    public void removeR8_reaches_Milestone( Milestone inst ) {
        R8_reaches_Milestone_set.remove(inst);
    }
    @Override
    public MilestoneSet R8_reaches_Milestone() throws XtumlException {
        return R8_reaches_Milestone_set;
    }


    @Override
    public IRunContext getRunContext() {
        return context().getRunContext();
    }

    @Override
    public Pm context() {
        return context;
    }

    @Override
    public String getKeyLetters() {
        return KEY_LETTERS;
    }

    @Override
    public Project self() {
        return this;
    }

    @Override
    public Project oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_PROJECT;
    }

}

class EmptyProject extends ModelInstance<Project,Pm> implements Project {

    // attributes
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Initiative R5_implements_Initiative() {
        return InitiativeImpl.EMPTY_INITIATIVE;
    }
    @Override
    public MilestoneSet R8_reaches_Milestone() {
        return (new MilestoneSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return ProjectImpl.KEY_LETTERS;
    }

    @Override
    public Project self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Project oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return ProjectImpl.EMPTY_PROJECT;
    }

}
