package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Grade;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.JobSet;
import hrsystem.hr.main.impl.GradeImpl;
import hrsystem.hr.main.impl.JobSetImpl;

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


public class GradeImpl extends ModelInstance<Grade,Hr> implements Grade {

    public static final String KEY_LETTERS = "Grade";
    public static final Grade EMPTY_GRADE = new EmptyGrade();

    private Hr context;

    // constructors
    private GradeImpl( Hr context ) {
        this.context = context;
        m_GValue = 0;
        R5_Job_set = new JobSetImpl();
    }

    private GradeImpl( Hr context, UniqueId instanceId, int m_GValue ) {
        super(instanceId);
        this.context = context;
        this.m_GValue = m_GValue;
        R5_Job_set = new JobSetImpl();
    }

    public static Grade create( Hr context ) throws XtumlException {
        Grade newGrade = new GradeImpl( context );
        if ( context.addInstance( newGrade ) ) {
            newGrade.getRunContext().addChange(new InstanceCreatedDelta(newGrade, KEY_LETTERS));
            return newGrade;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Grade create( Hr context, UniqueId instanceId, int m_GValue ) throws XtumlException {
        Grade newGrade = new GradeImpl( context, instanceId, m_GValue );
        if ( context.addInstance( newGrade ) ) {
            return newGrade;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private int m_GValue;
    @Override
    public int getGValue() throws XtumlException {
        checkLiving();
        return m_GValue;
    }
    @Override
    public void setGValue(int m_GValue) throws XtumlException {
        checkLiving();
        if (m_GValue != this.m_GValue) {
            final int oldValue = this.m_GValue;
            this.m_GValue = m_GValue;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_GValue", oldValue, this.m_GValue));
            if ( !R5_Job().isEmpty() ) R5_Job().setGValue( m_GValue );
        }
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getGValue());
        }
        catch ( XtumlException e ) {
            getRunContext().getLog().error(e);
            System.exit(1);
            return null;
        }
    }

    // operations


    // static operations
    public static class CLASS extends ActionHome<Hr> {

        public CLASS( Hr context ) {
            super( context );
        }

        public void crud( final int p_Value,  final String p_Action ) throws XtumlException {
            context().LOG().LogInfo( "Attempting to add a new Grade." );
            Grade inst = context().Grade_instances().anyWhere(selected -> ((Grade)selected).getGValue() == p_Value);
            if ( inst.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                Grade g = GradeImpl.create( context() );
                g.setGValue(p_Value);
                context().UI().Reply( "Grade: added successfully.", true );
            }
            else if ( !inst.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Grade already exists." );
                context().UI().Reply( "Grade already exists", false );
            }
            else if ( !inst.isEmpty() && StringUtil.equality(p_Action, "UPDATE") ) {
                context().LOG().LogInfo( "Grade updated successfully." );
                context().UI().Reply( "Grade updated successfully", true );
            }
            else if ( !inst.isEmpty() && StringUtil.equality(p_Action, "DELETE") ) {
                context().LOG().LogInfo( "Grade deleted successfully." );
                context().UI().Reply( "Grade delete unsuccessful", false );
            }
            else if ( inst.isEmpty() ) {
                context().LOG().LogInfo( "Grade does not exist." );
                context().UI().Reply( "Grade does not exist.", false );
            }
        }



    }


    // events


    // selections
    private JobSet R5_Job_set;
    @Override
    public void addR5_Job( Job inst ) {
        R5_Job_set.add(inst);
    }
    @Override
    public void removeR5_Job( Job inst ) {
        R5_Job_set.remove(inst);
    }
    @Override
    public JobSet R5_Job() throws XtumlException {
        return R5_Job_set;
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
    public int getGValue() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setGValue( int m_GValue ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }


    // operations


    // selections
    @Override
    public JobSet R5_Job() {
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
