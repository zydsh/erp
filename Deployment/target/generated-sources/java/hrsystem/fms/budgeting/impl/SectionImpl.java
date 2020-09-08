package hrsystem.fms.budgeting.impl;


import hrsystem.Fms;
import hrsystem.fms.budgeting.Chapter;
import hrsystem.fms.budgeting.Item;
import hrsystem.fms.budgeting.ItemSet;
import hrsystem.fms.budgeting.Section;
import hrsystem.fms.budgeting.impl.ChapterImpl;
import hrsystem.fms.budgeting.impl.ItemSetImpl;

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


public class SectionImpl extends ModelInstance<Section,Fms> implements Section {

    public static final String KEY_LETTERS = "Section";
    public static final Section EMPTY_SECTION = new EmptySection();

    private Fms context;

    // constructors
    private SectionImpl( Fms context ) {
        this.context = context;
        m_Code = "";
        m_Name = "";
        m_Amount = 0d;
        m_ApprovedFunds = 0d;
        m_TotalSpending = 0d;
        m_RemainingExpenses = 0d;
        m_OriginalFund = 0d;
        m_FundvsIncome = 0d;
        m_PostponedFund = 0d;
        m_Balance = 0d;
        m_RequestedFund = 0d;
        m_EconomicCategory = "";
        m_Comments = "";
        R200_belongs_Chapter_inst = ChapterImpl.EMPTY_CHAPTER;
        R3_assigned_Item_set = new ItemSetImpl();
    }

    private SectionImpl( Fms context, UniqueId instanceId, String m_Code, String m_Name, double m_Amount, double m_ApprovedFunds, double m_TotalSpending, double m_RemainingExpenses, double m_OriginalFund, double m_FundvsIncome, double m_PostponedFund, double m_Balance, double m_RequestedFund, String m_EconomicCategory, String m_Comments ) {
        super(instanceId);
        this.context = context;
        this.m_Code = m_Code;
        this.m_Name = m_Name;
        this.m_Amount = m_Amount;
        this.m_ApprovedFunds = m_ApprovedFunds;
        this.m_TotalSpending = m_TotalSpending;
        this.m_RemainingExpenses = m_RemainingExpenses;
        this.m_OriginalFund = m_OriginalFund;
        this.m_FundvsIncome = m_FundvsIncome;
        this.m_PostponedFund = m_PostponedFund;
        this.m_Balance = m_Balance;
        this.m_RequestedFund = m_RequestedFund;
        this.m_EconomicCategory = m_EconomicCategory;
        this.m_Comments = m_Comments;
        R200_belongs_Chapter_inst = ChapterImpl.EMPTY_CHAPTER;
        R3_assigned_Item_set = new ItemSetImpl();
    }

    public static Section create( Fms context ) throws XtumlException {
        Section newSection = new SectionImpl( context );
        if ( context.addInstance( newSection ) ) {
            newSection.getRunContext().addChange(new InstanceCreatedDelta(newSection, KEY_LETTERS));
            return newSection;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Section create( Fms context, UniqueId instanceId, String m_Code, String m_Name, double m_Amount, double m_ApprovedFunds, double m_TotalSpending, double m_RemainingExpenses, double m_OriginalFund, double m_FundvsIncome, double m_PostponedFund, double m_Balance, double m_RequestedFund, String m_EconomicCategory, String m_Comments ) throws XtumlException {
        Section newSection = new SectionImpl( context, instanceId, m_Code, m_Name, m_Amount, m_ApprovedFunds, m_TotalSpending, m_RemainingExpenses, m_OriginalFund, m_FundvsIncome, m_PostponedFund, m_Balance, m_RequestedFund, m_EconomicCategory, m_Comments );
        if ( context.addInstance( newSection ) ) {
            return newSection;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
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
    private double m_Amount;
    @Override
    public void setAmount(double m_Amount) throws XtumlException {
        checkLiving();
        if (m_Amount != this.m_Amount) {
            final double oldValue = this.m_Amount;
            this.m_Amount = m_Amount;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Amount", oldValue, this.m_Amount));
        }
    }
    @Override
    public double getAmount() throws XtumlException {
        checkLiving();
        return m_Amount;
    }
    private double m_ApprovedFunds;
    @Override
    public double getApprovedFunds() throws XtumlException {
        checkLiving();
        return m_ApprovedFunds;
    }
    @Override
    public void setApprovedFunds(double m_ApprovedFunds) throws XtumlException {
        checkLiving();
        if (m_ApprovedFunds != this.m_ApprovedFunds) {
            final double oldValue = this.m_ApprovedFunds;
            this.m_ApprovedFunds = m_ApprovedFunds;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_ApprovedFunds", oldValue, this.m_ApprovedFunds));
        }
    }
    private double m_TotalSpending;
    @Override
    public double getTotalSpending() throws XtumlException {
        checkLiving();
        return m_TotalSpending;
    }
    @Override
    public void setTotalSpending(double m_TotalSpending) throws XtumlException {
        checkLiving();
        if (m_TotalSpending != this.m_TotalSpending) {
            final double oldValue = this.m_TotalSpending;
            this.m_TotalSpending = m_TotalSpending;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_TotalSpending", oldValue, this.m_TotalSpending));
        }
    }
    private double m_RemainingExpenses;
    @Override
    public double getRemainingExpenses() throws XtumlException {
        checkLiving();
        return m_RemainingExpenses;
    }
    @Override
    public void setRemainingExpenses(double m_RemainingExpenses) throws XtumlException {
        checkLiving();
        if (m_RemainingExpenses != this.m_RemainingExpenses) {
            final double oldValue = this.m_RemainingExpenses;
            this.m_RemainingExpenses = m_RemainingExpenses;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_RemainingExpenses", oldValue, this.m_RemainingExpenses));
        }
    }
    private double m_OriginalFund;
    @Override
    public void setOriginalFund(double m_OriginalFund) throws XtumlException {
        checkLiving();
        if (m_OriginalFund != this.m_OriginalFund) {
            final double oldValue = this.m_OriginalFund;
            this.m_OriginalFund = m_OriginalFund;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_OriginalFund", oldValue, this.m_OriginalFund));
        }
    }
    @Override
    public double getOriginalFund() throws XtumlException {
        checkLiving();
        return m_OriginalFund;
    }
    private double m_FundvsIncome;
    @Override
    public void setFundvsIncome(double m_FundvsIncome) throws XtumlException {
        checkLiving();
        if (m_FundvsIncome != this.m_FundvsIncome) {
            final double oldValue = this.m_FundvsIncome;
            this.m_FundvsIncome = m_FundvsIncome;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_FundvsIncome", oldValue, this.m_FundvsIncome));
        }
    }
    @Override
    public double getFundvsIncome() throws XtumlException {
        checkLiving();
        return m_FundvsIncome;
    }
    private double m_PostponedFund;
    @Override
    public void setPostponedFund(double m_PostponedFund) throws XtumlException {
        checkLiving();
        if (m_PostponedFund != this.m_PostponedFund) {
            final double oldValue = this.m_PostponedFund;
            this.m_PostponedFund = m_PostponedFund;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_PostponedFund", oldValue, this.m_PostponedFund));
        }
    }
    @Override
    public double getPostponedFund() throws XtumlException {
        checkLiving();
        return m_PostponedFund;
    }
    private double m_Balance;
    @Override
    public double getBalance() throws XtumlException {
        checkLiving();
        return m_Balance;
    }
    @Override
    public void setBalance(double m_Balance) throws XtumlException {
        checkLiving();
        if (m_Balance != this.m_Balance) {
            final double oldValue = this.m_Balance;
            this.m_Balance = m_Balance;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Balance", oldValue, this.m_Balance));
        }
    }
    private double m_RequestedFund;
    @Override
    public double getRequestedFund() throws XtumlException {
        checkLiving();
        return m_RequestedFund;
    }
    @Override
    public void setRequestedFund(double m_RequestedFund) throws XtumlException {
        checkLiving();
        if (m_RequestedFund != this.m_RequestedFund) {
            final double oldValue = this.m_RequestedFund;
            this.m_RequestedFund = m_RequestedFund;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_RequestedFund", oldValue, this.m_RequestedFund));
        }
    }
    private String m_EconomicCategory;
    @Override
    public String getEconomicCategory() throws XtumlException {
        checkLiving();
        return m_EconomicCategory;
    }
    @Override
    public void setEconomicCategory(String m_EconomicCategory) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_EconomicCategory, this.m_EconomicCategory)) {
            final String oldValue = this.m_EconomicCategory;
            this.m_EconomicCategory = m_EconomicCategory;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_EconomicCategory", oldValue, this.m_EconomicCategory));
        }
    }
    private String m_Comments;
    @Override
    public String getComments() throws XtumlException {
        checkLiving();
        return m_Comments;
    }
    @Override
    public void setComments(String m_Comments) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Comments, this.m_Comments)) {
            final String oldValue = this.m_Comments;
            this.m_Comments = m_Comments;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Comments", oldValue, this.m_Comments));
        }
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getCode());
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
            return new InstanceIdentifier(getName());
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
    private Chapter R200_belongs_Chapter_inst;
    @Override
    public void setR200_belongs_Chapter( Chapter inst ) {
        R200_belongs_Chapter_inst = inst;
    }
    @Override
    public Chapter R200_belongs_Chapter() throws XtumlException {
        return R200_belongs_Chapter_inst;
    }
    private ItemSet R3_assigned_Item_set;
    @Override
    public void addR3_assigned_Item( Item inst ) {
        R3_assigned_Item_set.add(inst);
    }
    @Override
    public void removeR3_assigned_Item( Item inst ) {
        R3_assigned_Item_set.remove(inst);
    }
    @Override
    public ItemSet R3_assigned_Item() throws XtumlException {
        return R3_assigned_Item_set;
    }


    @Override
    public IRunContext getRunContext() {
        return context().getRunContext();
    }

    @Override
    public Fms context() {
        return context;
    }

    @Override
    public String getKeyLetters() {
        return KEY_LETTERS;
    }

    @Override
    public Section self() {
        return this;
    }

    @Override
    public Section oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_SECTION;
    }

}

class EmptySection extends ModelInstance<Section,Fms> implements Section {

    // attributes
    public void setCode( String m_Code ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getCode() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setAmount( double m_Amount ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getAmount() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public double getApprovedFunds() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setApprovedFunds( double m_ApprovedFunds ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getTotalSpending() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setTotalSpending( double m_TotalSpending ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getRemainingExpenses() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setRemainingExpenses( double m_RemainingExpenses ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setOriginalFund( double m_OriginalFund ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getOriginalFund() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setFundvsIncome( double m_FundvsIncome ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getFundvsIncome() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setPostponedFund( double m_PostponedFund ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getPostponedFund() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public double getBalance() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setBalance( double m_Balance ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getRequestedFund() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setRequestedFund( double m_RequestedFund ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getEconomicCategory() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setEconomicCategory( String m_EconomicCategory ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getComments() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setComments( String m_Comments ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Chapter R200_belongs_Chapter() {
        return ChapterImpl.EMPTY_CHAPTER;
    }
    @Override
    public ItemSet R3_assigned_Item() {
        return (new ItemSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return SectionImpl.KEY_LETTERS;
    }

    @Override
    public Section self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Section oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return SectionImpl.EMPTY_SECTION;
    }

}
