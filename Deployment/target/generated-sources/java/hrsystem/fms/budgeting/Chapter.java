package hrsystem.fms.budgeting;


import hrsystem.Fms;
import hrsystem.fms.budgeting.Budget;
import hrsystem.fms.budgeting.Section;
import hrsystem.fms.budgeting.SectionSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Chapter extends IModelInstance<Chapter,Fms> {

    // attributes
    public void setCode( String m_Code ) throws XtumlException;
    public String getCode() throws XtumlException;
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public double getCeilingFund() throws XtumlException;
    public void setCeilingFund( double m_CeilingFund ) throws XtumlException;
    public double getRequestFund() throws XtumlException;
    public void setRequestFund( double m_RequestFund ) throws XtumlException;


    // operations


    // selections
    default public void setR100_belongs_Budget( Budget inst ) {}
    public Budget R100_belongs_Budget() throws XtumlException;
    default public void addR200_divided_Section( Section inst ) {}
    default public void removeR200_divided_Section( Section inst ) {}
    public SectionSet R200_divided_Section() throws XtumlException;


}
