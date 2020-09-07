package hrsystem.pm.main.impl;


import hrsystem.Pm;
import hrsystem.pm.main.Initiative;
import hrsystem.pm.main.Milestone;
import hrsystem.pm.main.MilestoneSet;
import hrsystem.pm.main.Project;
import hrsystem.pm.main.ProjectSet;
import hrsystem.pm.main.Strategy;
import hrsystem.pm.main.impl.MilestoneSetImpl;
import hrsystem.pm.main.impl.ProjectSetImpl;
import hrsystem.pm.main.impl.StrategyImpl;

import io.ciera.runtime.instanceloading.AttributeChangedDelta;
import io.ciera.runtime.instanceloading.InstanceCreatedDelta;
import io.ciera.runtime.summit.application.IRunContext;
import io.ciera.runtime.summit.classes.IInstanceIdentifier;
import io.ciera.runtime.summit.classes.InstanceIdentifier;
import io.ciera.runtime.summit.classes.ModelInstance;
import io.ciera.runtime.summit.exceptions.EmptyInstanceException;
import io.ciera.runtime.summit.exceptions.InstancePopulationException;
import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.IWhere;
import io.ciera.runtime.summit.types.IXtumlType;
import io.ciera.runtime.summit.types.StringUtil;
import io.ciera.runtime.summit.types.UniqueId;


public class InitiativeImpl extends ModelInstance<Initiative,Pm> implements Initiative {

    public static final String KEY_LETTERS = "Initiative";
    public static final Initiative EMPTY_INITIATIVE = new EmptyInitiative();

    private Pm context;

    // constructors
    private InitiativeImpl( Pm context ) {
        this.context = context;
        m_Name = "";
        m_ShortNumber = "";
        m_LongNumber = "";
        m_Description = "";
        m_StartDate = 0;
        m_ActualStartDate = 0;
        m_EndDate = 0;
        m_ActualEndDate = 0;
        m_Budget = 0d;
        R10_implements_Strategy_inst = StrategyImpl.EMPTY_STRATEGY;
        R5_implemented_Project_set = new ProjectSetImpl();
        R60_achieves_Milestone_set = new MilestoneSetImpl();
    }

    private InitiativeImpl( Pm context, UniqueId instanceId, String m_Name, String m_ShortNumber, String m_LongNumber, String m_Description, int m_StartDate, int m_ActualStartDate, int m_EndDate, int m_ActualEndDate, double m_Budget ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        this.m_ShortNumber = m_ShortNumber;
        this.m_LongNumber = m_LongNumber;
        this.m_Description = m_Description;
        this.m_StartDate = m_StartDate;
        this.m_ActualStartDate = m_ActualStartDate;
        this.m_EndDate = m_EndDate;
        this.m_ActualEndDate = m_ActualEndDate;
        this.m_Budget = m_Budget;
        R10_implements_Strategy_inst = StrategyImpl.EMPTY_STRATEGY;
        R5_implemented_Project_set = new ProjectSetImpl();
        R60_achieves_Milestone_set = new MilestoneSetImpl();
    }

    public static Initiative create( Pm context ) throws XtumlException {
        Initiative newInitiative = new InitiativeImpl( context );
        if ( context.addInstance( newInitiative ) ) {
            newInitiative.getRunContext().addChange(new InstanceCreatedDelta(newInitiative, KEY_LETTERS));
            return newInitiative;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Initiative create( Pm context, UniqueId instanceId, String m_Name, String m_ShortNumber, String m_LongNumber, String m_Description, int m_StartDate, int m_ActualStartDate, int m_EndDate, int m_ActualEndDate, double m_Budget ) throws XtumlException {
        Initiative newInitiative = new InitiativeImpl( context, instanceId, m_Name, m_ShortNumber, m_LongNumber, m_Description, m_StartDate, m_ActualStartDate, m_EndDate, m_ActualEndDate, m_Budget );
        if ( context.addInstance( newInitiative ) ) {
            return newInitiative;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
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
    private String m_ShortNumber;
    @Override
    public String getShortNumber() throws XtumlException {
        checkLiving();
        return m_ShortNumber;
    }
    @Override
    public void setShortNumber(String m_ShortNumber) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_ShortNumber, this.m_ShortNumber)) {
            final String oldValue = this.m_ShortNumber;
            this.m_ShortNumber = m_ShortNumber;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_ShortNumber", oldValue, this.m_ShortNumber));
        }
    }
    private String m_LongNumber;
    @Override
    public void setLongNumber(String m_LongNumber) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_LongNumber, this.m_LongNumber)) {
            final String oldValue = this.m_LongNumber;
            this.m_LongNumber = m_LongNumber;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_LongNumber", oldValue, this.m_LongNumber));
        }
    }
    @Override
    public String getLongNumber() throws XtumlException {
        checkLiving();
        return m_LongNumber;
    }
    private String m_Description;
    @Override
    public void setDescription(String m_Description) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Description, this.m_Description)) {
            final String oldValue = this.m_Description;
            this.m_Description = m_Description;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Description", oldValue, this.m_Description));
        }
    }
    @Override
    public String getDescription() throws XtumlException {
        checkLiving();
        return m_Description;
    }
    private int m_StartDate;
    @Override
    public void setStartDate(int m_StartDate) throws XtumlException {
        checkLiving();
        if (m_StartDate != this.m_StartDate) {
            final int oldValue = this.m_StartDate;
            this.m_StartDate = m_StartDate;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_StartDate", oldValue, this.m_StartDate));
        }
    }
    @Override
    public int getStartDate() throws XtumlException {
        checkLiving();
        return m_StartDate;
    }
    private int m_ActualStartDate;
    @Override
    public int getActualStartDate() throws XtumlException {
        checkLiving();
        return m_ActualStartDate;
    }
    @Override
    public void setActualStartDate(int m_ActualStartDate) throws XtumlException {
        checkLiving();
        if (m_ActualStartDate != this.m_ActualStartDate) {
            final int oldValue = this.m_ActualStartDate;
            this.m_ActualStartDate = m_ActualStartDate;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_ActualStartDate", oldValue, this.m_ActualStartDate));
        }
    }
    private int m_EndDate;
    @Override
    public void setEndDate(int m_EndDate) throws XtumlException {
        checkLiving();
        if (m_EndDate != this.m_EndDate) {
            final int oldValue = this.m_EndDate;
            this.m_EndDate = m_EndDate;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_EndDate", oldValue, this.m_EndDate));
        }
    }
    @Override
    public int getEndDate() throws XtumlException {
        checkLiving();
        return m_EndDate;
    }
    private int m_ActualEndDate;
    @Override
    public void setActualEndDate(int m_ActualEndDate) throws XtumlException {
        checkLiving();
        if (m_ActualEndDate != this.m_ActualEndDate) {
            final int oldValue = this.m_ActualEndDate;
            this.m_ActualEndDate = m_ActualEndDate;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_ActualEndDate", oldValue, this.m_ActualEndDate));
        }
    }
    @Override
    public int getActualEndDate() throws XtumlException {
        checkLiving();
        return m_ActualEndDate;
    }
    private double m_Budget;
    @Override
    public double getBudget() throws XtumlException {
        checkLiving();
        return m_Budget;
    }
    @Override
    public void setBudget(double m_Budget) throws XtumlException {
        checkLiving();
        if (m_Budget != this.m_Budget) {
            final double oldValue = this.m_Budget;
            this.m_Budget = m_Budget;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Budget", oldValue, this.m_Budget));
        }
    }


    // instance identifiers

    // operations


    // static operations


    // events


    // selections
    private Strategy R10_implements_Strategy_inst;
    @Override
    public void setR10_implements_Strategy( Strategy inst ) {
        R10_implements_Strategy_inst = inst;
    }
    @Override
    public Strategy R10_implements_Strategy() throws XtumlException {
        return R10_implements_Strategy_inst;
    }
    private ProjectSet R5_implemented_Project_set;
    @Override
    public void addR5_implemented_Project( Project inst ) {
        R5_implemented_Project_set.add(inst);
    }
    @Override
    public void removeR5_implemented_Project( Project inst ) {
        R5_implemented_Project_set.remove(inst);
    }
    @Override
    public ProjectSet R5_implemented_Project() throws XtumlException {
        return R5_implemented_Project_set;
    }
    private MilestoneSet R60_achieves_Milestone_set;
    @Override
    public void addR60_achieves_Milestone( Milestone inst ) {
        R60_achieves_Milestone_set.add(inst);
    }
    @Override
    public void removeR60_achieves_Milestone( Milestone inst ) {
        R60_achieves_Milestone_set.remove(inst);
    }
    @Override
    public MilestoneSet R60_achieves_Milestone() throws XtumlException {
        return R60_achieves_Milestone_set;
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
    public Initiative self() {
        return this;
    }

    @Override
    public Initiative oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_INITIATIVE;
    }

}

class EmptyInitiative extends ModelInstance<Initiative,Pm> implements Initiative {

    // attributes
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getShortNumber() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setShortNumber( String m_ShortNumber ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setLongNumber( String m_LongNumber ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getLongNumber() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setDescription( String m_Description ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getDescription() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setStartDate( int m_StartDate ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getStartDate() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getActualStartDate() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setActualStartDate( int m_ActualStartDate ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setEndDate( int m_EndDate ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getEndDate() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setActualEndDate( int m_ActualEndDate ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getActualEndDate() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public double getBudget() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setBudget( double m_Budget ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Strategy R10_implements_Strategy() {
        return StrategyImpl.EMPTY_STRATEGY;
    }
    @Override
    public ProjectSet R5_implemented_Project() {
        return (new ProjectSetImpl());
    }
    @Override
    public MilestoneSet R60_achieves_Milestone() {
        return (new MilestoneSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return InitiativeImpl.KEY_LETTERS;
    }

    @Override
    public Initiative self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Initiative oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return InitiativeImpl.EMPTY_INITIATIVE;
    }

}
