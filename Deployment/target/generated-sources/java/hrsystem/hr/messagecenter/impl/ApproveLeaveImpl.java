package hrsystem.hr.messagecenter.impl;


import hrsystem.Hr;
import hrsystem.hr.main.Employee;
import hrsystem.hr.main.impl.EmployeeImpl;
import hrsystem.hr.messagecenter.ApproveLeave;

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


public class ApproveLeaveImpl extends ModelInstance<ApproveLeave,Hr> implements ApproveLeave {

    public static final String KEY_LETTERS = "ApproveLeave";
    public static final ApproveLeave EMPTY_APPROVELEAVE = new EmptyApproveLeave();

    private Hr context;

    // constructors
    private ApproveLeaveImpl( Hr context ) {
        this.context = context;
        m_LeaveRequesterID = 0;
        m_Starting = 0;
        m_Ending = 0;
        m_Content = "";
        R102_notifies_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
    }

    private ApproveLeaveImpl( Hr context, UniqueId instanceId, int m_LeaveRequesterID, int m_Starting, int m_Ending, String m_Content ) {
        super(instanceId);
        this.context = context;
        this.m_LeaveRequesterID = m_LeaveRequesterID;
        this.m_Starting = m_Starting;
        this.m_Ending = m_Ending;
        this.m_Content = m_Content;
        R102_notifies_Employee_inst = EmployeeImpl.EMPTY_EMPLOYEE;
    }

    public static ApproveLeave create( Hr context ) throws XtumlException {
        ApproveLeave newApproveLeave = new ApproveLeaveImpl( context );
        if ( context.addInstance( newApproveLeave ) ) {
            newApproveLeave.getRunContext().addChange(new InstanceCreatedDelta(newApproveLeave, KEY_LETTERS));
            return newApproveLeave;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }

    public static ApproveLeave create( Hr context, UniqueId instanceId, int m_LeaveRequesterID, int m_Starting, int m_Ending, String m_Content ) throws XtumlException {
        ApproveLeave newApproveLeave = new ApproveLeaveImpl( context, instanceId, m_LeaveRequesterID, m_Starting, m_Ending, m_Content );
        if ( context.addInstance( newApproveLeave ) ) {
            return newApproveLeave;
        }
        else throw new InstancePopulationException( "Instance already exists within this population." );
    }



    // attributes
    private int m_LeaveRequesterID;
    @Override
    public int getLeaveRequesterID() throws XtumlException {
        checkLiving();
        return m_LeaveRequesterID;
    }
    @Override
    public void setLeaveRequesterID(int m_LeaveRequesterID) throws XtumlException {
        checkLiving();
        if (m_LeaveRequesterID != this.m_LeaveRequesterID) {
            final int oldValue = this.m_LeaveRequesterID;
            this.m_LeaveRequesterID = m_LeaveRequesterID;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_LeaveRequesterID", oldValue, this.m_LeaveRequesterID));
        }
    }
    private int m_Starting;
    @Override
    public void setStarting(int m_Starting) throws XtumlException {
        checkLiving();
        if (m_Starting != this.m_Starting) {
            final int oldValue = this.m_Starting;
            this.m_Starting = m_Starting;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Starting", oldValue, this.m_Starting));
        }
    }
    @Override
    public int getStarting() throws XtumlException {
        checkLiving();
        return m_Starting;
    }
    private int m_Ending;
    @Override
    public void setEnding(int m_Ending) throws XtumlException {
        checkLiving();
        if (m_Ending != this.m_Ending) {
            final int oldValue = this.m_Ending;
            this.m_Ending = m_Ending;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Ending", oldValue, this.m_Ending));
        }
    }
    @Override
    public int getEnding() throws XtumlException {
        checkLiving();
        return m_Ending;
    }
    private String m_Content;
    @Override
    public void setContent(String m_Content) throws XtumlException {
        checkLiving();
        if (StringUtil.inequality(m_Content, this.m_Content)) {
            final String oldValue = this.m_Content;
            this.m_Content = m_Content;
            getRunContext().addChange(new AttributeChangedDelta(this, KEY_LETTERS, "m_Content", oldValue, this.m_Content));
        }
    }
    @Override
    public String getContent() throws XtumlException {
        checkLiving();
        return m_Content;
    }


    // instance identifiers

    // operations
    @Override
    public void createMessage( final int p_Starting,  final int p_Ending,  final int p_EmployeeID,  final int p_ManagerID ) throws XtumlException {
        Employee employee = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == p_ManagerID);
        context().relate_R102_ApproveLeave_notifies_Employee( self(), employee );
        Employee emp = context().Employee_instances().anyWhere(selected -> ((Employee)selected).getEmployeeID() == p_EmployeeID);
        String Content = ( ( emp.getFirstName() + " " ) + emp.getLastName() ) + " is requesting to take leave.";
    }



    // static operations


    // events


    // selections
    private Employee R102_notifies_Employee_inst;
    @Override
    public void setR102_notifies_Employee( Employee inst ) {
        R102_notifies_Employee_inst = inst;
    }
    @Override
    public Employee R102_notifies_Employee() throws XtumlException {
        return R102_notifies_Employee_inst;
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
    public ApproveLeave self() {
        return this;
    }

    @Override
    public ApproveLeave oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        if (condition.evaluate(this)) return this;
        else return EMPTY_APPROVELEAVE;
    }

}

class EmptyApproveLeave extends ModelInstance<ApproveLeave,Hr> implements ApproveLeave {

    // attributes
    public int getLeaveRequesterID() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setLeaveRequesterID( int m_LeaveRequesterID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public void setStarting( int m_Starting ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getStarting() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setEnding( int m_Ending ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public int getEnding() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }
    public void setContent( String m_Content ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot set attribute of empty instance." );
    }
    public String getContent() throws XtumlException {
        throw new EmptyInstanceException( "Cannot get attribute of empty instance." );
    }


    // operations
    public void createMessage( final int p_Starting,  final int p_Ending,  final int p_EmployeeID,  final int p_ManagerID ) throws XtumlException {
        throw new EmptyInstanceException( "Cannot invoke operation on empty instance." );
    }


    // selections
    @Override
    public Employee R102_notifies_Employee() {
        return EmployeeImpl.EMPTY_EMPLOYEE;
    }


    @Override
    public String getKeyLetters() {
        return ApproveLeaveImpl.KEY_LETTERS;
    }

    @Override
    public ApproveLeave self() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public ApproveLeave oneWhere(IWhere<IXtumlType> condition) throws XtumlException {
        if (null == condition) throw new XtumlException("Null condition passed to selection.");
        return ApproveLeaveImpl.EMPTY_APPROVELEAVE;
    }

}
