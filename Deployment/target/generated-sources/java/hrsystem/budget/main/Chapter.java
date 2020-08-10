package hrsystem.budget.main;


import hrsystem.Budget;
import hrsystem.budget.main.Budget;
import hrsystem.budget.main.Section;
import hrsystem.budget.main.SectionSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Chapter extends IModelInstance<Chapter,Budget> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public String getName() throws XtumlException;
    public int getCode() throws XtumlException;
    public void setCode( int m_Code ) throws XtumlException;
    public double getCeiling_Fund() throws XtumlException;
    public void setCeiling_Fund( double m_Ceiling_Fund ) throws XtumlException;
    public void setRequest_Fund( double m_Request_Fund ) throws XtumlException;
    public double getRequest_Fund() throws XtumlException;
    public double getFund() throws XtumlException;
    public void setFund( double m_Fund ) throws XtumlException;
    public void setYear( int ref_Year ) throws XtumlException;
    public int getYear() throws XtumlException;


    // operations


    // selections
    default public void setR1_Budget( Budget inst ) {}
    public Budget R1_Budget() throws XtumlException;
    default public void addR2_Section( Section inst ) {}
    default public void removeR2_Section( Section inst ) {}
    public SectionSet R2_Section() throws XtumlException;


}
