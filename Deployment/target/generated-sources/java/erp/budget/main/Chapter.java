package erp.budget.main;


import erp.Budget;
import erp.budget.main.Budget;
import erp.budget.main.Section;
import erp.budget.main.SectionSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Chapter extends IModelInstance<Chapter,Budget> {

    // attributes
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setCode( int m_Code ) throws XtumlException;
    public int getCode() throws XtumlException;
    public void setCeiling_Fund( double m_Ceiling_Fund ) throws XtumlException;
    public double getCeiling_Fund() throws XtumlException;
    public void setRequest_Fund( double m_Request_Fund ) throws XtumlException;
    public double getRequest_Fund() throws XtumlException;
    public double getFund() throws XtumlException;
    public void setFund( double m_Fund ) throws XtumlException;
    public int getYear() throws XtumlException;
    public void setYear( int ref_Year ) throws XtumlException;


    // operations


    // selections
    default public void setR1_Budget( Budget inst ) {}
    public Budget R1_Budget() throws XtumlException;
    default public void addR2_Section( Section inst ) {}
    default public void removeR2_Section( Section inst ) {}
    public SectionSet R2_Section() throws XtumlException;


}
