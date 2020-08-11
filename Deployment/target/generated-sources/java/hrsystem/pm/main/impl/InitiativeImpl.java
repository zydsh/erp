package hrsystem.pm.main.impl;


import hrsystem.Pm;
import hrsystem.pm.main.Initiative;
import hrsystem.pm.main.Milestone;
import hrsystem.pm.main.MilestoneSet;
import hrsystem.pm.main.Strategy;
import hrsystem.pm.main.impl.InitiativeImpl;
import hrsystem.pm.main.impl.MilestoneSetImpl;
import hrsystem.pm.main.impl.StrategyImpl;

import io.ciera.runtime.instanceloading.AttributeChangedDelta;
import io.ciera.runtime.instanceloading.InstanceCreatedDelta;
import io.ciera.runtime.summit.application.ActionHome;
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
        m_Short_Number = "";
        m_Long_Number = "";
        m_Description = "";
        m_Start_Date = 0;
        m_Actual_Start_Date = 0;
        m_End_Date = 0;
        m_Actual_End_Date = 0;
        m_Budget = 0d;
        R1_Strategy_inst = StrategyImpl.EMPTY_STRATEGY;
        R2_Milestone_set = new MilestoneSetImpl();
    }

    private InitiativeImpl( Pm context, UniqueId instanceId, String m_Name, String m_Short_Number, String m_Long_Number, String m_Description, int m_Start_Date, int m_Actual_Start_Date, int m_End_Date, int m_Actual_End_Date, double m_Budget ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        this.m_Short_Number = m_Short_Number;
        this.m_Long_Number = m_Long_Number;
        this.m_Description = m_Description;
        this.m_Start_Date = m_Start_Date;
        this.m_Actual_Start_Date = m_Actual_Start_Date;
        this.m_End_Date = m_End_Date;
        this.m_Actual_End_Date = m_Actual_End_Date;
        this.m_Budget = m_Budget;
        R1_Strategy_inst = StrategyImpl.EMPTY_STRATEGY;
        R2_Milestone_set = new MilestoneSetImpl();
    }

    public static Initiative create( Pm context ) throws XtumlException {
        Initiative newInitiative = new InitiativeImpl( context );
        if ( context.addInstance( newInitiative ) ) {
            newInitiative.getRunContext().addChange(new InstanceCreatedDelta(newInitiative, KEY_LETTERS));
            return newInitiative;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Initiative create( Pm context, UniqueId instanceId, String m_Name, String m_Short_Number, String m_Long_Number, String m_Description, int m_Start_Date, int m_Actual_Start_Date, int m_End_Date, int m_Actual_End_Date, double m_Budget ) throws XtumlException {
        Initiative newInitiative = new InitiativeImpl( context, instanceId, m_Name, m_Short_Number, m_Long_Number, m_Description, m_Start_Date, m_Actual_Start_Date, m_End_Date, m_Actual_End_Date, m_Budget );
        if ( context.addInstance( newInitiative ) ) {
            return newInitiative;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private String m_Name;
    @Override
    public void setName(String m_Name) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Name, this.m_Name)) {
            final String oldValue = this.m_Name;
            this.m_Name = m_Name;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Name", oldValue, this.m_Name));
        }
    }
    @Override
    public String getName() throws XtumlException {
        checkLiving();
        return m_Name;
    }
    private String m_Short_Number;
    @Override
    public String getShort_Number() throws XtumlException {
        checkLiving();
        return m_Short_Number;
    }
    @Override
    public void setShort_Number(String m_Short_Number) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Short_Number, this.m_Short_Number)) {
            final String oldValue = this.m_Short_Number;
            this.m_Short_Number = m_Short_Number;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Short_Number", oldValue, this.m_Short_Number));
        }
    }
    private String m_Long_Number;
    @Override
    public void setLong_Number(String m_Long_Number) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Long_Number, this.m_Long_Number)) {
            final String oldValue = this.m_Long_Number;
            this.m_Long_Number = m_Long_Number;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Long_Number", oldValue, this.m_Long_Number));
        }
    }
    @Override
    public String getLong_Number() throws XtumlException {
        checkLiving();
        return m_Long_Number;
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
    private int m_Start_Date;
    @Override
    public int getStart_Date() throws XtumlException {
        checkLiving();
        return m_Start_Date;
    }
    @Override
    public void setStart_Date(int m_Start_Date) throws XtumlException {
        checkLiving();
        if (m_Start_Date != this.m_Start_Date) {
            final int oldValue = this.m_Start_Date;
            this.m_Start_Date = m_Start_Date;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Start_Date", oldValue, this.m_Start_Date));
        }
    }
    private int m_Actual_Start_Date;
    @Override
    public void setActual_Start_Date(int m_Actual_Start_Date) throws XtumlException {
        checkLiving();
        if (m_Actual_Start_Date != this.m_Actual_Start_Date) {
            final int oldValue = this.m_Actual_Start_Date;
            this.m_Actual_Start_Date = m_Actual_Start_Date;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Actual_Start_Date", oldValue, this.m_Actual_Start_Date));
        }
    }
    @Override
    public int getActual_Start_Date() throws XtumlException {
        checkLiving();
        return m_Actual_Start_Date;
    }
    private int m_End_Date;
    @Override
    public int getEnd_Date() throws XtumlException {
        checkLiving();
        return m_End_Date;
    }
    @Override
    public void setEnd_Date(int m_End_Date) throws XtumlException {
        checkLiving();
        if (m_End_Date != this.m_End_Date) {
            final int oldValue = this.m_End_Date;
            this.m_End_Date = m_End_Date;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_End_Date", oldValue, this.m_End_Date));
        }
    }
    private int m_Actual_End_Date;
    @Override
    public void setActual_End_Date(int m_Actual_End_Date) throws XtumlException {
        checkLiving();
        if (m_Actual_End_Date != this.m_Actual_End_Date) {
            final int oldValue = this.m_Actual_End_Date;
            this.m_Actual_End_Date = m_Actual_End_Date;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Actual_End_Date", oldValue, this.m_Actual_End_Date));
        }
    }
    @Override
    public int getActual_End_Date() throws XtumlException {
        checkLiving();
        return m_Actual_End_Date;
    }
    private double m_Budget;
    @Override
    public void setBudget(double m_Budget) throws XtumlException {
        checkLiving();
        if (m_Budget != this.m_Budget) {
            final double oldValue = this.m_Budget;
            this.m_Budget = m_Budget;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Budget", oldValue, this.m_Budget));
        }
    }
    @Override
    public double getBudget() throws XtumlException {
        checkLiving();
        return m_Budget;
    }


    // instance identifiers

    // operations


    // static operations
    public static class CLASS extends ActionHome<Pm> {

        public CLASS( Pm context ) {
            super( context );
        }

        public void crud( final String p_Name,  final String p_Short_Number,  final String p_Long_Number,  final String p_Description,  final int p_Start_Date,  final int p_Actual_Start_Date,  final int p_End_Date,  final int p_Actual_End_Date,  final double p_Budget,  final String p_Str_Name,  final String p_Action ) throws XtumlException {
            Initiative initiative = context().Initiative_instances().anyWhere(selected -> StringUtil.equality(((Initiative)selected).getName(), p_Name));
            if ( initiative.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Attempting to add a new initiative to employee." );
                Initiative i = InitiativeImpl.create( context() );
                i.setName(p_Name);
                i.setShort_Number(p_Short_Number);
                i.setLong_Number(p_Long_Number);
                i.setStart_Date(p_Start_Date);
                i.setActual_Start_Date(p_Actual_Start_Date);
                i.setEnd_Date(p_End_Date);
                i.setActual_End_Date(p_Actual_End_Date);
                i.setBudget(p_Budget);
                i.setDescription(p_Description);
                Strategy str = context().Strategy_instances().anyWhere(selected -> StringUtil.equality(((Strategy)selected).getName(), p_Str_Name));
                context().relate_R1_Initiative_Strategy( i, str );
                context().PM().Reply( "initiative created successfully.", true );
            }
            else if ( !initiative.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Attempting to add a new initiative." );
                context().LOG().LogInfo( "Initiative already exists." );
                context().PM().Reply( "Initiative already exists", false );
            }
            else if ( !initiative.isEmpty() && StringUtil.equality(p_Action, "UPDATE") ) {
                context().LOG().LogInfo( "Attempting to update initiative." );
                initiative.setName(p_Name);
                initiative.setShort_Number(p_Short_Number);
                initiative.setLong_Number(p_Long_Number);
                initiative.setStart_Date(p_Start_Date);
                initiative.setActual_Start_Date(p_Actual_Start_Date);
                initiative.setEnd_Date(p_End_Date);
                initiative.setActual_End_Date(p_Actual_End_Date);
                initiative.setBudget(p_Budget);
                context().LOG().LogInfo( "Initiative updated successfully." );
                context().PM().Reply( "Initiative updated successfully", true );
            }
            else if ( !initiative.isEmpty() && StringUtil.equality(p_Action, "DELETE") ) {
                context().LOG().LogInfo( "Attempting to delete a initiative instance." );
                context().LOG().LogInfo( "Initiative delete in not implemented yet." );
                context().PM().Reply( "Initiative delete in not implemented yet", false );
            }
            else if ( initiative.isEmpty() ) {
                context().LOG().LogInfo( "Initiative does not exist." );
                context().PM().Reply( "Initiative does not exist.", false );
            }
        }



    }


    // events


    // selections
    private Strategy R1_Strategy_inst;
    @Override
    public void setR1_Strategy( Strategy inst ) {
        R1_Strategy_inst = inst;
    }
    @Override
    public Strategy R1_Strategy() throws XtumlException {
        return R1_Strategy_inst;
    }
    private MilestoneSet R2_Milestone_set;
    @Override
    public void addR2_Milestone( Milestone inst ) {
        R2_Milestone_set.add(inst);
    }
    @Override
    public void removeR2_Milestone( Milestone inst ) {
        R2_Milestone_set.remove(inst);
    }
    @Override
    public MilestoneSet R2_Milestone() throws XtumlException {
        return R2_Milestone_set;
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
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public String getShort_Number() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setShort_Number( String m_Short_Number ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setLong_Number( String m_Long_Number ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getLong_Number() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setDescription( String m_Description ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getDescription() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getStart_Date() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setStart_Date( int m_Start_Date ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setActual_Start_Date( int m_Actual_Start_Date ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getActual_Start_Date() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getEnd_Date() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setEnd_Date( int m_End_Date ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setActual_End_Date( int m_Actual_End_Date ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getActual_End_Date() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setBudget( double m_Budget ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getBudget() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Strategy R1_Strategy() {
        return StrategyImpl.EMPTY_STRATEGY;
    }
    @Override
    public MilestoneSet R2_Milestone() {
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
