package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Leave;
import hrsystem.hr.main.LeaveSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface LeaveSpecification extends IModelInstance<LeaveSpecification,Hr> {

    // attributes
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public int getMaximumDays() throws XtumlException;
    public void setMaximumDays( int m_MaximumDays ) throws XtumlException;
    public int getMinimumDays() throws XtumlException;
    public void setMinimumDays( int m_MinimumDays ) throws XtumlException;


    // operations


    // selections
    default public void addR15_specifies_Leave( Leave inst ) {}
    default public void removeR15_specifies_Leave( Leave inst ) {}
    public LeaveSet R15_specifies_Leave() throws XtumlException;


}
