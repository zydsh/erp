package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Grade;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.JobSet;
import hrsystem.hr.main.Scale;
import hrsystem.hr.main.impl.GradeImpl;
import hrsystem.hr.main.impl.JobSetImpl;
import hrsystem.hr.main.impl.ScaleImpl;

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


public class GradeImpl extends ModelInstance<Grade,Hr> implements Grade {

    public static final String KEY_LETTERS = "Grade";
    public static final Grade EMPTY_GRADE = new EmptyGrade();

    private Hr context;

    // constructors
    private GradeImpl( Hr context ) {
        this.context = context;
        m_Name = "";
        m_Allowance = 0d;
        m_BaseSalary = 0d;
        m_NumberOfSteps = 0;
        R12_is_part_of_Scale_inst = ScaleImpl.EMPTY_SCALE;
        R14_follows_Grade_inst = GradeImpl.EMPTY_GRADE;
        R14_proceeds_Grade_inst = GradeImpl.EMPTY_GRADE;
        R9_assigned_Job_set = new JobSetImpl();
    }

    private GradeImpl( Hr context, UniqueId instanceId, String m_Name, double m_Allowance, double m_BaseSalary, int m_NumberOfSteps ) {
        super(instanceId);
        this.context = context;
        this.m_Name = m_Name;
        this.m_Allowance = m_Allowance;
        this.m_BaseSalary = m_BaseSalary;
        this.m_NumberOfSteps = m_NumberOfSteps;
        R12_is_part_of_Scale_inst = ScaleImpl.EMPTY_SCALE;
        R14_follows_Grade_inst = GradeImpl.EMPTY_GRADE;
        R14_proceeds_Grade_inst = GradeImpl.EMPTY_GRADE;
        R9_assigned_Job_set = new JobSetImpl();
    }

    public static Grade create( Hr context ) throws XtumlException {
        Grade newGrade = new GradeImpl( context );
        if ( context.addInstance( newGrade ) ) {
            newGrade.getRunContext().addChange(new InstanceCreatedDelta(newGrade, KEY_LETTERS));
            return newGrade;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Grade create( Hr context, UniqueId instanceId, String m_Name, double m_Allowance, double m_BaseSalary, int m_NumberOfSteps ) throws XtumlException {
        Grade newGrade = new GradeImpl( context, instanceId, m_Name, m_Allowance, m_BaseSalary, m_NumberOfSteps );
        if ( context.addInstance( newGrade ) ) {
            return newGrade;
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
    private double m_Allowance;
    @Override
    public void setAllowance(double m_Allowance) throws XtumlException {
        checkLiving();
        if (m_Allowance != this.m_Allowance) {
            final double oldValue = this.m_Allowance;
            this.m_Allowance = m_Allowance;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Allowance", oldValue, this.m_Allowance));
        }
    }
    @Override
    public double getAllowance() throws XtumlException {
        checkLiving();
        return m_Allowance;
    }
    private double m_BaseSalary;
    @Override
    public double getBaseSalary() throws XtumlException {
        checkLiving();
        return m_BaseSalary;
    }
    @Override
    public void setBaseSalary(double m_BaseSalary) throws XtumlException {
        checkLiving();
        if (m_BaseSalary != this.m_BaseSalary) {
            final double oldValue = this.m_BaseSalary;
            this.m_BaseSalary = m_BaseSalary;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_BaseSalary", oldValue, this.m_BaseSalary));
        }
    }
    private int m_NumberOfSteps;
    @Override
    public void setNumberOfSteps(int m_NumberOfSteps) throws XtumlException {
        checkLiving();
        if (m_NumberOfSteps != this.m_NumberOfSteps) {
            final int oldValue = this.m_NumberOfSteps;
            this.m_NumberOfSteps = m_NumberOfSteps;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_NumberOfSteps", oldValue, this.m_NumberOfSteps));
        }
    }
    @Override
    public int getNumberOfSteps() throws XtumlException {
        checkLiving();
        return m_NumberOfSteps;
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
    private Scale R12_is_part_of_Scale_inst;
    @Override
    public void setR12_is_part_of_Scale( Scale inst ) {
        R12_is_part_of_Scale_inst = inst;
    }
    @Override
    public Scale R12_is_part_of_Scale() throws XtumlException {
        return R12_is_part_of_Scale_inst;
    }
    private Grade R14_follows_Grade_inst;
    @Override
    public void setR14_follows_Grade( Grade inst ) {
        R14_follows_Grade_inst = inst;
    }
    @Override
    public Grade R14_follows_Grade() throws XtumlException {
        return R14_follows_Grade_inst;
    }
    private Grade R14_proceeds_Grade_inst;
    @Override
    public void setR14_proceeds_Grade( Grade inst ) {
        R14_proceeds_Grade_inst = inst;
    }
    @Override
    public Grade R14_proceeds_Grade() throws XtumlException {
        return R14_proceeds_Grade_inst;
    }
    private JobSet R9_assigned_Job_set;
    @Override
    public void addR9_assigned_Job( Job inst ) {
        R9_assigned_Job_set.add(inst);
    }
    @Override
    public void removeR9_assigned_Job( Job inst ) {
        R9_assigned_Job_set.remove(inst);
    }
    @Override
    public JobSet R9_assigned_Job() throws XtumlException {
        return R9_assigned_Job_set;
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
    public Grade self() {
        return this;
    }

    @Override
    public Grade oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_GRADE;
    }

}

class EmptyGrade extends ModelInstance<Grade,Hr> implements Grade {

    // attributes
    public String getName() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setName( String m_Name ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setAllowance( double m_Allowance ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public double getAllowance() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public double getBaseSalary() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setBaseSalary( double m_BaseSalary ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setNumberOfSteps( int m_NumberOfSteps ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getNumberOfSteps() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public Scale R12_is_part_of_Scale() {
        return ScaleImpl.EMPTY_SCALE;
    }
    @Override
    public Grade R14_follows_Grade() {
        return GradeImpl.EMPTY_GRADE;
    }
    @Override
    public Grade R14_proceeds_Grade() {
        return GradeImpl.EMPTY_GRADE;
    }
    @Override
    public JobSet R9_assigned_Job() {
        return (new JobSetImpl());
    }


    @Override
    public String getKeyLetters() {
        return GradeImpl.KEY_LETTERS;
    }

    @Override
    public Grade self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Grade oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return GradeImpl.EMPTY_GRADE;
    }

}
