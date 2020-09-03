package erp.pm.main.impl;


import erp.Pm;
import erp.pm.main.Initiative;
import erp.pm.main.Milestone;
import erp.pm.main.Supporting_Documents;
import erp.pm.main.Supporting_DocumentsSet;
import erp.pm.main.impl.InitiativeImpl;
import erp.pm.main.impl.Supporting_DocumentsSetImpl;

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


public class MilestoneImpl extends ModelInstance<Milestone,Pm> implements Milestone {

    public static final String KEY_LETTERS = "Milestone";
    public static final Milestone EMPTY_MILESTONE = new EmptyMilestone();

    private Pm context;

    // constructors
    private MilestoneImpl( Pm context ) {
        this.context = context;
        m_Name = "";
        m_Full_Code = "";
        m_Code = "";
        m_Type = "";
        m_Success_Criteria = "";
        m_Complete_Planned = 0;
        m_Complete_Actual = 0;
        m_Complete = 0;
        m_Weight = 0;
        m_Percentage = 0;
        m_sd_State = "";
        m_sd_Description = "";
        m_Notes = "";
        m_Incomplete_Reasons = "";
        R2_achieved_by_Initiative_inst = InitiativeImpl.EMPTY_INITIATIVE;
        R3_completed_with_Supporting_Documents_set = new Supporting_DocumentsSetImpl();
    }

    private MilestoneImpl( Pm context, UniqueId instanceId, String m_Name, String m_Full_Code, String m_Code, String m_Type, String m_Success_Criteria, int m_Complete_Planned, int m_Complete_Actual, int m_Complete, int m_Weight, int m_Percentage, String m_sd_State, String m_sd_Description, String m_Notes, String m_Incomplete_Reasons ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        this.m_Full_Code = m_Full_Code;
        this.m_Code = m_Code;
        this.m_Type = m_Type;
        this.m_Success_Criteria = m_Success_Criteria;
        this.m_Complete_Planned = m_Complete_Planned;
        this.m_Complete_Actual = m_Complete_Actual;
        this.m_Complete = m_Complete;
        this.m_Weight = m_Weight;
        this.m_Percentage = m_Percentage;
        this.m_sd_State = m_sd_State;
        this.m_sd_Description = m_sd_Description;
        this.m_Notes = m_Notes;
        this.m_Incomplete_Reasons = m_Incomplete_Reasons;
        R2_achieved_by_Initiative_inst = InitiativeImpl.EMPTY_INITIATIVE;
        R3_completed_with_Supporting_Documents_set = new Supporting_DocumentsSetImpl();
    }

    public static Milestone create( Pm context ) throws XtumlException {
        Milestone newMilestone = new MilestoneImpl( context );
        if ( context.addInstance( newMilestone ) ) {
            newMilestone.getRunContext().addChange(new InstanceCreatedDelta(newMilestone, KEY_LETTERS));
            return newMilestone;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Milestone create( Pm context, UniqueId instanceId, String m_Name, String m_Full_Code, String m_Code, String m_Type, String m_Success_Criteria, int m_Complete_Planned, int m_Complete_Actual, int m_Complete, int m_Weight, int m_Percentage, String m_sd_State, String m_sd_Description, String m_Notes, String m_Incomplete_Reasons ) throws XtumlException {
        Milestone newMilestone = new MilestoneImpl( context, instanceId, m_Name, m_Full_Code, m_Code, m_Type, m_Success_Criteria, m_Complete_Planned, m_Complete_Actual, m_Complete, m_Weight, m_Percentage, m_sd_State, m_sd_Description, m_Notes, m_Incomplete_Reasons );
        if ( context.addInstance( newMilestone ) ) {
            return newMilestone;
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
    private String m_Full_Code;
    @Override
    public String getFull_Code() throws XtumlException {
        checkLiving();
        return m_Full_Code;
    }
    @Override
    public void setFull_Code(String m_Full_Code) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Full_Code, this.m_Full_Code)) {
            final String oldValue = this.m_Full_Code;
            this.m_Full_Code = m_Full_Code;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Full_Code", oldValue, this.m_Full_Code));
        }
    }
    private String m_Code;
    @Override
    public void setCode(String m_Code) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Code, this.m_Code)) {
            final String oldValue = this.m_Code;
            this.m_Code = m_Code;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Code", oldValue, this.m_Code));
        }
    }
    @Override
    public String getCode() throws XtumlException {
        checkLiving();
        return m_Code;
    }
    private String m_Type;
    @Override
    public String getType() throws XtumlException {
        checkLiving();
        return m_Type;
    }
    @Override
    public void setType(String m_Type) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Type, this.m_Type)) {
            final String oldValue = this.m_Type;
            this.m_Type = m_Type;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Type", oldValue, this.m_Type));
        }
    }
    private String m_Success_Criteria;
    @Override
    public void setSuccess_Criteria(String m_Success_Criteria) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Success_Criteria, this.m_Success_Criteria)) {
            final String oldValue = this.m_Success_Criteria;
            this.m_Success_Criteria = m_Success_Criteria;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Success_Criteria", oldValue, this.m_Success_Criteria));
        }
    }
    @Override
    public String getSuccess_Criteria() throws XtumlException {
        checkLiving();
        return m_Success_Criteria;
    }
    private int m_Complete_Planned;
    @Override
    public int getComplete_Planned() throws XtumlException {
        checkLiving();
        return m_Complete_Planned;
    }
    @Override
    public void setComplete_Planned(int m_Complete_Planned) throws XtumlException {
        checkLiving();
        if (m_Complete_Planned != this.m_Complete_Planned) {
            final int oldValue = this.m_Complete_Planned;
            this.m_Complete_Planned = m_Complete_Planned;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Complete_Planned", oldValue, this.m_Complete_Planned));
        }
    }
    private int m_Complete_Actual;
    @Override
    public int getComplete_Actual() throws XtumlException {
        checkLiving();
        return m_Complete_Actual;
    }
    @Override
    public void setComplete_Actual(int m_Complete_Actual) throws XtumlException {
        checkLiving();
        if (m_Complete_Actual != this.m_Complete_Actual) {
            final int oldValue = this.m_Complete_Actual;
            this.m_Complete_Actual = m_Complete_Actual;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Complete_Actual", oldValue, this.m_Complete_Actual));
        }
    }
    private int m_Complete;
    @Override
    public int getComplete() throws XtumlException {
        checkLiving();
        return m_Complete;
    }
    @Override
    public void setComplete(int m_Complete) throws XtumlException {
        checkLiving();
        if (m_Complete != this.m_Complete) {
            final int oldValue = this.m_Complete;
            this.m_Complete = m_Complete;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Complete", oldValue, this.m_Complete));
        }
    }
    private int m_Weight;
    @Override
    public void setWeight(int m_Weight) throws XtumlException {
        checkLiving();
        if (m_Weight != this.m_Weight) {
            final int oldValue = this.m_Weight;
            this.m_Weight = m_Weight;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Weight", oldValue, this.m_Weight));
        }
    }
    @Override
    public int getWeight() throws XtumlException {
        checkLiving();
        return m_Weight;
    }
    private int m_Percentage;
    @Override
    public void setPercentage(int m_Percentage) throws XtumlException {
        checkLiving();
        if (m_Percentage != this.m_Percentage) {
            final int oldValue = this.m_Percentage;
            this.m_Percentage = m_Percentage;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Percentage", oldValue, this.m_Percentage));
        }
    }
    @Override
    public int getPercentage() throws XtumlException {
        checkLiving();
        return m_Percentage;
    }
    private String m_sd_State;
    @Override
    public String getSd_State() throws XtumlException {
        checkLiving();
        return m_sd_State;
    }
    @Override
    public void setSd_State(String m_sd_State) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_sd_State, this.m_sd_State)) {
            final String oldValue = this.m_sd_State;
            this.m_sd_State = m_sd_State;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_sd_State", oldValue, this.m_sd_State));
        }
    }
    private String m_sd_Description;
    @Override
    public String getSd_Description() throws XtumlException {
        checkLiving();
        return m_sd_Description;
    }
    @Override
    public void setSd_Description(String m_sd_Description) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_sd_Description, this.m_sd_Description)) {
            final String oldValue = this.m_sd_Description;
            this.m_sd_Description = m_sd_Description;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_sd_Description", oldValue, this.m_sd_Description));
        }
    }
    private String m_Notes;
    @Override
    public void setNotes(String m_Notes) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Notes, this.m_Notes)) {
            final String oldValue = this.m_Notes;
            this.m_Notes = m_Notes;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Notes", oldValue, this.m_Notes));
        }
    }
    @Override
    public String getNotes() throws XtumlException {
        checkLiving();
        return m_Notes;
    }
    private String m_Incomplete_Reasons;
    @Override
    public void setIncomplete_Reasons(String m_Incomplete_Reasons) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Incomplete_Reasons, this.m_Incomplete_Reasons)) {
            final String oldValue = this.m_Incomplete_Reasons;
            this.m_Incomplete_Reasons = m_Incomplete_Reasons;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Incomplete_Reasons", oldValue, this.m_Incomplete_Reasons));
        }
    }
    @Override
    public String getIncomplete_Reasons() throws XtumlException {
        checkLiving();
        return m_Incomplete_Reasons;
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getFull_Code());
        }
        catch ( XtumlException e ) {
            getRunContext().getLog().error(e);
            System.exit(1);
            return null;
        }
    }
    @Override
    public IInstanceIdentifier getId2() {
        try {
            return new InstanceIdentifier(getCode());
        }
        catch ( XtumlException e ) {
            getRunContext().getLog().error(e);
            System.exit(1);
            return null;
        }
    }

    // operations


    // static operations


    // events


    // selections
    private Initiative R2_achieved_by_Initiative_inst;
    @Override
    public void setR2_achieved_by_Initiative( Initiative inst ) {
        R2_achieved_by_Initiative_inst = inst;
    }
    @Override
    public Initiative R2_achieved_by_Initiative() throws XtumlException {
        return R2_achieved_by_Initiative_inst;
    }
    private Supporting_DocumentsSet R3_completed_with_Supporting_Documents_set;
    @Override
    public void addR3_completed_with_Supporting_Documents( Supporting_Documents inst ) {
        R3_completed_with_Supporting_Documents_set.add(inst);
    }
    @Override
    public void removeR3_completed_with_Supporting_Documents( Supporting_Documents inst ) {
        R3_completed_with_Supporting_Documents_set.remove(inst);
    }
    @Override
    public Supporting_DocumentsSet R3_completed_with_Supporting_Documents() throws XtumlException {
        return R3_completed_with_Supporting_Documents_set;
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
    public Milestone self() {
        return this;
    }

    @Override
    public Milestone oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_MILESTONE;
    }

}

class EmptyMilestone extends ModelInstance<Milestone,Pm> implements Milestone {

    // attributes
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public String getFull_Code() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setFull_Code( String m_Full_Code ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setCode( String m_Code ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getCode() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public String getType() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setType( String m_Type ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setSuccess_Criteria( String m_Success_Criteria ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getSuccess_Criteria() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getComplete_Planned() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setComplete_Planned( int m_Complete_Planned ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getComplete_Actual() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setComplete_Actual( int m_Complete_Actual ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getComplete() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setComplete( int m_Complete ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setWeight( int m_Weight ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getWeight() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setPercentage( int m_Percentage ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getPercentage() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public String getSd_State() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setSd_State( String m_sd_State ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getSd_Description() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setSd_Description( String m_sd_Description ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setNotes( String m_Notes ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getNotes() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setIncomplete_Reasons( String m_Incomplete_Reasons ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getIncomplete_Reasons() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Initiative R2_achieved_by_Initiative() {
        return InitiativeImpl.EMPTY_INITIATIVE;
    }
    @Override
    public Supporting_DocumentsSet R3_completed_with_Supporting_Documents() {
        return (new Supporting_DocumentsSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return MilestoneImpl.KEY_LETTERS;
    }

    @Override
    public Milestone self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Milestone oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return MilestoneImpl.EMPTY_MILESTONE;
    }

}
