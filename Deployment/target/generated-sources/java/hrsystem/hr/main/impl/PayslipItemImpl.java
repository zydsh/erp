package hrsystem.hr.main.impl;


import hrm.hr.types.PayslipItemType;

import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.PayslipItem;
import hrsystem.hr.main.PayslipItemSet;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.main.impl.PayslipItemSetImpl;

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


public class PayslipItemImpl extends ModelInstance<PayslipItem,Hr> implements PayslipItem {

    public static final String KEY_LETTERS = "PayslipItem";
    public static final PayslipItem EMPTY_PAYSLIPITEM = new EmptyPayslipItem();

    private Hr context;

    // constructors
    private PayslipItemImpl( Hr context ) {
        this.context = context;
        m_Name = "";
        m_Amount = 0d;
        m_Date = 0;
        m_Type = PayslipItemType.UNINITIALIZED_ENUM;
        R18_listed_after_PayslipItem_set = new PayslipItemSetImpl();
        R18_listed_before_PayslipItem_set = new PayslipItemSetImpl();
        R3_records_an_earning_or_deduction_to_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
    }

    private PayslipItemImpl( Hr context, UniqueId instanceId, String m_Name, double m_Amount, int m_Date, PayslipItemType m_Type ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        this.m_Amount = m_Amount;
        this.m_Date = m_Date;
        this.m_Type = m_Type;
        R18_listed_after_PayslipItem_set = new PayslipItemSetImpl();
        R18_listed_before_PayslipItem_set = new PayslipItemSetImpl();
        R3_records_an_earning_or_deduction_to_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
    }

    public static PayslipItem create( Hr context ) throws XtumlException {
        PayslipItem newPayslipItem = new PayslipItemImpl( context );
        if ( context.addInstance( newPayslipItem ) ) {
            newPayslipItem.getRunContext().addChange(new InstanceCreatedDelta(newPayslipItem, KEY_LETTERS));
            return newPayslipItem;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static PayslipItem create( Hr context, UniqueId instanceId, String m_Name, double m_Amount, int m_Date, PayslipItemType m_Type ) throws XtumlException {
        PayslipItem newPayslipItem = new PayslipItemImpl( context, instanceId, m_Name, m_Amount, m_Date, m_Type );
        if ( context.addInstance( newPayslipItem ) ) {
            return newPayslipItem;
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
    private int m_Date;
    @Override
    public void setDate(int m_Date) throws XtumlException {
        checkLiving();
        if (m_Date != this.m_Date) {
            final int oldValue = this.m_Date;
            this.m_Date = m_Date;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Date", oldValue, this.m_Date));
        }
    }
    @Override
    public int getDate() throws XtumlException {
        checkLiving();
        return m_Date;
    }
    private PayslipItemType m_Type;
    @Override
    public PayslipItemType getType() throws XtumlException {
        checkLiving();
        return m_Type;
    }
    @Override
    public void setType(PayslipItemType m_Type) throws XtumlException {
        checkLiving();
        if (m_Type.inequality( this.m_Type)) {
            final PayslipItemType oldValue = this.m_Type;
            this.m_Type = m_Type;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Type", oldValue, this.m_Type));
        }
    }


    // instance identifiers

    // operations


    // static operations


    // events


    // selections
    private PayslipItemSet R18_listed_after_PayslipItem_set;
    @Override
    public void addR18_listed_after_PayslipItem( PayslipItem inst ) {
        R18_listed_after_PayslipItem_set.add(inst);
    }
    @Override
    public void removeR18_listed_after_PayslipItem( PayslipItem inst ) {
        R18_listed_after_PayslipItem_set.remove(inst);
    }
    @Override
    public PayslipItemSet R18_listed_after_PayslipItem() throws XtumlException {
        return R18_listed_after_PayslipItem_set;
    }
    private PayslipItemSet R18_listed_before_PayslipItem_set;
    @Override
    public void addR18_listed_before_PayslipItem( PayslipItem inst ) {
        R18_listed_before_PayslipItem_set.add(inst);
    }
    @Override
    public void removeR18_listed_before_PayslipItem( PayslipItem inst ) {
        R18_listed_before_PayslipItem_set.remove(inst);
    }
    @Override
    public PayslipItemSet R18_listed_before_PayslipItem() throws XtumlException {
        return R18_listed_before_PayslipItem_set;
    }
    private Employee R3_records_an_earning_or_deduction_to_Employee_inst;
    @Override
    public void setR3_records_an_earning_or_deduction_to_Employee( Employee inst ) {
        R3_records_an_earning_or_deduction_to_Employee_inst = inst;
    }
    @Override
    public Employee R3_records_an_earning_or_deduction_to_Employee() throws XtumlException {
        return R3_records_an_earning_or_deduction_to_Employee_inst;
    }


    @Override
    public IRunContext getRunContext() {
        return context().getRunContext();
    }

    @Override
    public Hr context() {
        return context;
    }

    @Override
    public String getKeyLetters() {
        return KEY_LETTERS;
    }

    @Override
    public PayslipItem self() {
        return this;
    }

    @Override
    public PayslipItem oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_PAYSLIPITEM;
    }

}

class EmptyPayslipItem extends ModelInstance<PayslipItem,Hr> implements PayslipItem {

    // attributes
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
    public void setDate( int m_Date ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getDate() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public PayslipItemType getType() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setType( PayslipItemType m_Type ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public PayslipItemSet R18_listed_after_PayslipItem() {
        return (new PayslipItemSetImpl());
    }
    @Override
    public PayslipItemSet R18_listed_before_PayslipItem() {
        return (new PayslipItemSetImpl());
    }
    @Override
    public Employee R3_records_an_earning_or_deduction_to_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }


    @Override
    public String getKeyLetters() {
        return PayslipItemImpl.KEY_LETTERS;
    }

    @Override
    public PayslipItem self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public PayslipItem oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return PayslipItemImpl.EMPTY_PAYSLIPITEM;
    }

}
