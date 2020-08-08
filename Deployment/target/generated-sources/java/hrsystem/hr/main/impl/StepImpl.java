package hrsystem.hr.main.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.JobSet;
import hrsystem.hr.main.Step;
import hrsystem.hr.main.impl.JobSetImpl;
import hrsystem.hr.main.impl.StepImpl;

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


public class StepImpl extends ModelInstance<Step,Hr> implements Step {

    public static final String KEY_LETTERS = "Step";
    public static final Step EMPTY_STEP = new EmptyStep();

    private Hr context;

    // constructors
    private StepImpl( Hr context ) {
        this.context = context;
        m_SValue = 0;
        R5_Job_set = new JobSetImpl();
    }

    private StepImpl( Hr context, UniqueId instanceId, int m_SValue ) {
        super(instanceId);
        this.context = context;
        this.m_SValue = m_SValue;
        R5_Job_set = new JobSetImpl();
    }

    public static Step create( Hr context ) throws XtumlException {
        Step newStep = new StepImpl( context );
        if ( context.addInstance( newStep ) ) {
            newStep.getRunContext().addChange(new InstanceCreatedDelta(newStep, KEY_LETTERS));
            return newStep;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static Step create( Hr context, UniqueId instanceId, int m_SValue ) throws XtumlException {
        Step newStep = new StepImpl( context, instanceId, m_SValue );
        if ( context.addInstance( newStep ) ) {
            return newStep;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private int m_SValue;
    @Override
    public int getSValue() throws XtumlException {
        checkLiving();
        return m_SValue;
    }
    @Override
    public void setSValue(int m_SValue) throws XtumlException {
        checkLiving();
        if (m_SValue != this.m_SValue) {
            final int oldValue = this.m_SValue;
            this.m_SValue = m_SValue;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_SValue", oldValue, this.m_SValue));
            if ( !R5_Job().isEmpty() ) R5_Job().setSValue( m_SValue );
        }
    }


    // instance identifiers
    @Override
    public IInstanceIdentifier getId1() {
        try {
            return new InstanceIdentifier(getSValue());
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
            context().LOG().LogInfo( "Attempting to add a new Step." );
            Step inst = context().Step_instances().anyWhere(selected -> ((Step)selected).getSValue() == p_Value);
            if ( inst.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                Step s = StepImpl.create( context() );
                s.setSValue(p_Value);
                context().UI().Reply( "Step: added successfully.", true );
            }
            else if ( !inst.isEmpty() && StringUtil.equality(p_Action, "NEW") ) {
                context().LOG().LogInfo( "Step already exists." );
                context().UI().Reply( "Step already exists", false );
            }
            else if ( !inst.isEmpty() && StringUtil.equality(p_Action, "UPDATE") ) {
                context().LOG().LogInfo( "Step updated successfully." );
                context().UI().Reply( "Step updated successfully", true );
            }
            else if ( !inst.isEmpty() && StringUtil.equality(p_Action, "DELETE") ) {
                context().LOG().LogInfo( "Step deleted successfully." );
                context().UI().Reply( "Step delete unsuccessful", false );
            }
            else if ( inst.isEmpty() ) {
                context().LOG().LogInfo( "Step does not exist." );
                context().UI().Reply( "Step does not exist.", false );
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
    public Step self() {
        return this;
    }

    @Override
    public Step oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_STEP;
    }

}

class EmptyStep extends ModelInstance<Step,Hr> implements Step {

    // attributes
    public int getSValue() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setSValue( int m_SValue ) throws XtumlException {
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
        return StepImpl.KEY_LETTERS;
    }

    @Override
    public Step self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Step oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return StepImpl.EMPTY_STEP;
    }

}
