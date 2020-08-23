package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus;
import hrsystem.hr.main.BonusSet;
import hrsystem.hr.main.BonusSpecification;
import hrsystem.hr.main.impl.BonusSetImpl;

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


public class BonusSpecificationImpl extends ModelInstance<BonusSpecification,Hr> implements BonusSpecification {

    public static final String KEY_LETTERS = "BonusSpecification";
    public static final BonusSpecification EMPTY_BONUSSPECIFICATION = new EmptyBonusSpecification();

    private Hr context;

    // constructors
    private BonusSpecificationImpl( Hr context ) {
        this.context = context;
        m_Name = "";
        m_Percent = 0d;
        R16_specifies_Bonus_set = new BonusSetImpl();
    }

    private BonusSpecificationImpl( Hr context, UniqueId instanceId, String m_Name, double m_Percent ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        this.m_Percent = m_Percent;
        R16_specifies_Bonus_set = new BonusSetImpl();
    }

    public static BonusSpecification create( Hr context ) throws XtumlException {
        BonusSpecification newBonusSpecification = new BonusSpecificationImpl( context );
        if ( context.addInstance( newBonusSpecification ) ) {
            newBonusSpecification.getRunContext().addChange(new InstanceCreatedDelta(newBonusSpecification, KEY_LETTERS));
            return newBonusSpecification;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static BonusSpecification create( Hr context, UniqueId instanceId, String m_Name, double m_Percent ) throws XtumlException {
        BonusSpecification newBonusSpecification = new BonusSpecificationImpl( context, instanceId, m_Name, m_Percent );
        if ( context.addInstance( newBonusSpecification ) ) {
            return newBonusSpecification;
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
    private double m_Percent;
    @Override
    public void setPercent(double m_Percent) throws XtumlException {
        checkLiving();
        if (m_Percent != this.m_Percent) {
            final double oldValue = this.m_Percent;
            this.m_Percent = m_Percent;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Percent", oldValue, this.m_Percent));
        }
    }
    @Override
    public double getPercent() throws XtumlException {
        checkLiving();
        return m_Percent;
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
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
    private BonusSet R16_specifies_Bonus_set;
    @Override
    public void addR16_specifies_Bonus( Bonus inst ) {
        R16_specifies_Bonus_set.add(inst);
    }
    @Override
    public void removeR16_specifies_Bonus( Bonus inst ) {
        R16_specifies_Bonus_set.remove(inst);
    }
    @Override
    public BonusSet R16_specifies_Bonus() throws XtumlException {
        return R16_specifies_Bonus_set;
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
    public BonusSpecification self() {
        return this;
    }

    @Override
    public BonusSpecification oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_BONUSSPECIFICATION;
    }

}

class EmptyBonusSpecification extends ModelInstance<BonusSpecification,Hr> implements BonusSpecification {

    // attributes
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setPercent( double m_Percent ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getPercent() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public BonusSet R16_specifies_Bonus() {
        return (new BonusSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return BonusSpecificationImpl.KEY_LETTERS;
    }

    @Override
    public BonusSpecification self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public BonusSpecification oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return BonusSpecificationImpl.EMPTY_BONUSSPECIFICATION;
    }

}
