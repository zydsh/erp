package hrsystem.pm.main.impl;


import hrsystem.Pm;
import hrsystem.pm.main.Initiative;
import hrsystem.pm.main.Milestone;
import hrsystem.pm.main.Project;
import hrsystem.pm.main.SupportingDocuments;
import hrsystem.pm.main.SupportingDocumentsSet;
import hrsystem.pm.main.impl.InitiativeImpl;
import hrsystem.pm.main.impl.ProjectImpl;
import hrsystem.pm.main.impl.SupportingDocumentsSetImpl;

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
        m_FullCode = "";
        m_Code = "";
        m_Type = "";
        m_SuccessCriteria = "";
        m_CompletePlanned = 0;
        m_CompleteActual = 0;
        m_Complete = false;
        m_Weight = 0;
        m_Percentage = 0d;
        m_sdState = "";
        m_sdDescription = "";
        m_Notes = "";
        m_IncompleteReasons = "";
        R3_completed_with_SupportingDocuments_set = new SupportingDocumentsSetImpl();
        R60_achieved_by_Initiative_inst = InitiativeImpl.EMPTY_INITIATIVE;
        R8_marks_the_development_of_Project_inst = ProjectImpl.EMPTY_PROJECT;
    }

    private MilestoneImpl( Pm context, UniqueId instanceId, String m_Name, String m_FullCode, String m_Code, String m_Type, String m_SuccessCriteria, int m_CompletePlanned, int m_CompleteActual, boolean m_Complete, int m_Weight, double m_Percentage, String m_sdState, String m_sdDescription, String m_Notes, String m_IncompleteReasons ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        this.m_FullCode = m_FullCode;
        this.m_Code = m_Code;
        this.m_Type = m_Type;
        this.m_SuccessCriteria = m_SuccessCriteria;
        this.m_CompletePlanned = m_CompletePlanned;
        this.m_CompleteActual = m_CompleteActual;
        this.m_Complete = m_Complete;
        this.m_Weight = m_Weight;
        this.m_Percentage = m_Percentage;
        this.m_sdState = m_sdState;
        this.m_sdDescription = m_sdDescription;
        this.m_Notes = m_Notes;
        this.m_IncompleteReasons = m_IncompleteReasons;
        R3_completed_with_SupportingDocuments_set = new SupportingDocumentsSetImpl();
        R60_achieved_by_Initiative_inst = InitiativeImpl.EMPTY_INITIATIVE;
        R8_marks_the_development_of_Project_inst = ProjectImpl.EMPTY_PROJECT;
    }

    public static Milestone create( Pm context ) throws XtumlException {
        Milestone newMilestone = new MilestoneImpl( context );
        if ( context.addInstance( newMilestone ) ) {
            newMilestone.getRunContext().addChange(new InstanceCreatedDelta(newMilestone, KEY_LETTERS));
            return newMilestone;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Milestone create( Pm context, UniqueId instanceId, String m_Name, String m_FullCode, String m_Code, String m_Type, String m_SuccessCriteria, int m_CompletePlanned, int m_CompleteActual, boolean m_Complete, int m_Weight, double m_Percentage, String m_sdState, String m_sdDescription, String m_Notes, String m_IncompleteReasons ) throws XtumlException {
        Milestone newMilestone = new MilestoneImpl( context, instanceId, m_Name, m_FullCode, m_Code, m_Type, m_SuccessCriteria, m_CompletePlanned, m_CompleteActual, m_Complete, m_Weight, m_Percentage, m_sdState, m_sdDescription, m_Notes, m_IncompleteReasons );
        if ( context.addInstance( newMilestone ) ) {
            return newMilestone;
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
    private String m_FullCode;
    @Override
    public String getFullCode() throws XtumlException {
        checkLiving();
        return m_FullCode;
    }
    @Override
    public void setFullCode(String m_FullCode) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_FullCode, this.m_FullCode)) {
            final String oldValue = this.m_FullCode;
            this.m_FullCode = m_FullCode;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_FullCode", oldValue, this.m_FullCode));
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
    public void setType(String m_Type) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Type, this.m_Type)) {
            final String oldValue = this.m_Type;
            this.m_Type = m_Type;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Type", oldValue, this.m_Type));
        }
    }
    @Override
    public String getType() throws XtumlException {
        checkLiving();
        return m_Type;
    }
    private String m_SuccessCriteria;
    @Override
    public String getSuccessCriteria() throws XtumlException {
        checkLiving();
        return m_SuccessCriteria;
    }
    @Override
    public void setSuccessCriteria(String m_SuccessCriteria) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_SuccessCriteria, this.m_SuccessCriteria)) {
            final String oldValue = this.m_SuccessCriteria;
            this.m_SuccessCriteria = m_SuccessCriteria;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_SuccessCriteria", oldValue, this.m_SuccessCriteria));
        }
    }
    private int m_CompletePlanned;
    @Override
    public void setCompletePlanned(int m_CompletePlanned) throws XtumlException {
        checkLiving();
        if (m_CompletePlanned != this.m_CompletePlanned) {
            final int oldValue = this.m_CompletePlanned;
            this.m_CompletePlanned = m_CompletePlanned;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_CompletePlanned", oldValue, this.m_CompletePlanned));
        }
    }
    @Override
    public int getCompletePlanned() throws XtumlException {
        checkLiving();
        return m_CompletePlanned;
    }
    private int m_CompleteActual;
    @Override
    public int getCompleteActual() throws XtumlException {
        checkLiving();
        return m_CompleteActual;
    }
    @Override
    public void setCompleteActual(int m_CompleteActual) throws XtumlException {
        checkLiving();
        if (m_CompleteActual != this.m_CompleteActual) {
            final int oldValue = this.m_CompleteActual;
            this.m_CompleteActual = m_CompleteActual;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_CompleteActual", oldValue, this.m_CompleteActual));
        }
    }
    private boolean m_Complete;
    @Override
    public boolean getComplete() throws XtumlException {
        checkLiving();
        return m_Complete;
    }
    @Override
    public void setComplete(boolean m_Complete) throws XtumlException {
        checkLiving();
        if (m_Complete != this.m_Complete) {
            final boolean oldValue = this.m_Complete;
            this.m_Complete = m_Complete;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Complete", oldValue, this.m_Complete));
        }
    }
    private int m_Weight;
    @Override
    public int getWeight() throws XtumlException {
        checkLiving();
        return m_Weight;
    }
    @Override
    public void setWeight(int m_Weight) throws XtumlException {
        checkLiving();
        if (m_Weight != this.m_Weight) {
            final int oldValue = this.m_Weight;
            this.m_Weight = m_Weight;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Weight", oldValue, this.m_Weight));
        }
    }
    private double m_Percentage;
    @Override
    public void setPercentage(double m_Percentage) throws XtumlException {
        checkLiving();
        if (m_Percentage != this.m_Percentage) {
            final double oldValue = this.m_Percentage;
            this.m_Percentage = m_Percentage;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Percentage", oldValue, this.m_Percentage));
        }
    }
    @Override
    public double getPercentage() throws XtumlException {
        checkLiving();
        return m_Percentage;
    }
    private String m_sdState;
    @Override
    public void setSdState(String m_sdState) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_sdState, this.m_sdState)) {
            final String oldValue = this.m_sdState;
            this.m_sdState = m_sdState;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_sdState", oldValue, this.m_sdState));
        }
    }
    @Override
    public String getSdState() throws XtumlException {
        checkLiving();
        return m_sdState;
    }
    private String m_sdDescription;
    @Override
    public void setSdDescription(String m_sdDescription) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_sdDescription, this.m_sdDescription)) {
            final String oldValue = this.m_sdDescription;
            this.m_sdDescription = m_sdDescription;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_sdDescription", oldValue, this.m_sdDescription));
        }
    }
    @Override
    public String getSdDescription() throws XtumlException {
        checkLiving();
        return m_sdDescription;
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
    private String m_IncompleteReasons;
    @Override
    public String getIncompleteReasons() throws XtumlException {
        checkLiving();
        return m_IncompleteReasons;
    }
    @Override
    public void setIncompleteReasons(String m_IncompleteReasons) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_IncompleteReasons, this.m_IncompleteReasons)) {
            final String oldValue = this.m_IncompleteReasons;
            this.m_IncompleteReasons = m_IncompleteReasons;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_IncompleteReasons", oldValue, this.m_IncompleteReasons));
        }
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getFullCode());
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
    private SupportingDocumentsSet R3_completed_with_SupportingDocuments_set;
    @Override
    public void addR3_completed_with_SupportingDocuments( SupportingDocuments inst ) {
        R3_completed_with_SupportingDocuments_set.add(inst);
    }
    @Override
    public void removeR3_completed_with_SupportingDocuments( SupportingDocuments inst ) {
        R3_completed_with_SupportingDocuments_set.remove(inst);
    }
    @Override
    public SupportingDocumentsSet R3_completed_with_SupportingDocuments() throws XtumlException {
        return R3_completed_with_SupportingDocuments_set;
    }
    private Initiative R60_achieved_by_Initiative_inst;
    @Override
    public void setR60_achieved_by_Initiative( Initiative inst ) {
        R60_achieved_by_Initiative_inst = inst;
    }
    @Override
    public Initiative R60_achieved_by_Initiative() throws XtumlException {
        return R60_achieved_by_Initiative_inst;
    }
    private Project R8_marks_the_development_of_Project_inst;
    @Override
    public void setR8_marks_the_development_of_Project( Project inst ) {
        R8_marks_the_development_of_Project_inst = inst;
    }
    @Override
    public Project R8_marks_the_development_of_Project() throws XtumlException {
        return R8_marks_the_development_of_Project_inst;
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
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getFullCode() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setFullCode( String m_FullCode ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setCode( String m_Code ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getCode() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setType( String m_Type ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getType() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public String getSuccessCriteria() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setSuccessCriteria( String m_SuccessCriteria ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setCompletePlanned( int m_CompletePlanned ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getCompletePlanned() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getCompleteActual() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setCompleteActual( int m_CompleteActual ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public boolean getComplete() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setComplete( boolean m_Complete ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getWeight() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setWeight( int m_Weight ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setPercentage( double m_Percentage ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getPercentage() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setSdState( String m_sdState ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getSdState() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setSdDescription( String m_sdDescription ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getSdDescription() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setNotes( String m_Notes ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getNotes() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public String getIncompleteReasons() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setIncompleteReasons( String m_IncompleteReasons ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public SupportingDocumentsSet R3_completed_with_SupportingDocuments() {
        return (new SupportingDocumentsSetImpl());
    }
    @Override
    public Initiative R60_achieved_by_Initiative() {
        return InitiativeImpl.EMPTY_INITIATIVE;
    }
    @Override
    public Project R8_marks_the_development_of_Project() {
        return ProjectImpl.EMPTY_PROJECT;
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
