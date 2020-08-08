package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.Payment;
import hrsystem.hr.main.impl.EmployeeImpl;

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


public class PaymentImpl extends ModelInstance<Payment,Hr> implements Payment {

    public static final String KEY_LETTERS = "Payment";
    public static final Payment EMPTY_PAYMENT = new EmptyPayment();

    private Hr context;

    // constructors
    private PaymentImpl( Hr context ) {
        this.context = context;
        m_Name = "";
        m_Amount = 0d;
        m_Date = 0;
        ref_National_ID = 0;
        R3_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
    }

    private PaymentImpl( Hr context, UniqueId instanceId, String m_Name, double m_Amount, int m_Date, int ref_National_ID ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        this.m_Amount = m_Amount;
        this.m_Date = m_Date;
        this.ref_National_ID = ref_National_ID;
        R3_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
    }

    public static Payment create( Hr context ) throws XtumlException {
        Payment newPayment = new PaymentImpl( context );
        if ( context.addInstance( newPayment ) ) {
            newPayment.getRunContext().addChange(new InstanceCreatedDelta(newPayment, KEY_LETTERS));
            return newPayment;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Payment create( Hr context, UniqueId instanceId, String m_Name, double m_Amount, int m_Date, int ref_National_ID ) throws XtumlException {
        Payment newPayment = new PaymentImpl( context, instanceId, m_Name, m_Amount, m_Date, ref_National_ID );
        if ( context.addInstance( newPayment ) ) {
            return newPayment;
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
    public int getDate() throws XtumlException {
        checkLiving();
        return m_Date;
    }
    @Override
    public void setDate(int m_Date) throws XtumlException {
        checkLiving();
        if (m_Date != this.m_Date) {
            final int oldValue = this.m_Date;
            this.m_Date = m_Date;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Date", oldValue, this.m_Date));
        }
    }
    private int ref_National_ID;
    @Override
    public void setNational_ID(int ref_National_ID) throws XtumlException {
        checkLiving();
        if (ref_National_ID != this.ref_National_ID) {
            final int oldValue = this.ref_National_ID;
            this.ref_National_ID = ref_National_ID;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "ref_National_ID", oldValue, this.ref_National_ID));
        }
    }
    @Override
    public int getNational_ID() throws XtumlException {
        checkLiving();
        return ref_National_ID;
    }


    // instance identifiers

    // operations


    // static operations


    // events


    // selections
    private Employee R3_Employee_inst;
    @Override
    public void setR3_Employee( Employee inst ) {
        R3_Employee_inst = inst;
    }
    @Override
    public Employee R3_Employee() throws XtumlException {
        return R3_Employee_inst;
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
    public Payment self() {
        return this;
    }

    @Override
    public Payment oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_PAYMENT;
    }

}

class EmptyPayment extends ModelInstance<Payment,Hr> implements Payment {

    // attributes
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setAmount( double m_Amount ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getAmount() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public int getDate() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setDate( int m_Date ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setNational_ID( int ref_National_ID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getNational_ID() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Employee R3_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }


    @Override
    public String getKeyLetters() {
        return PaymentImpl.KEY_LETTERS;
    }

    @Override
    public Payment self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Payment oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return PaymentImpl.EMPTY_PAYMENT;
    }

}
