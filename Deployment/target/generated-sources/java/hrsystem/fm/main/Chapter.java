package hrsystem.fm.main;


import hrsystem.Fm;
import hrsystem.fm.main.Budget;
import hrsystem.fm.main.Section;
import hrsystem.fm.main.SectionSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Chapter extends IModelInstance<Chapter,Fm> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public String getName() throws XtumlException;
    public void setCode( String m_Code ) throws XtumlException;
    public String getCode() throws XtumlException;
    public double getCeiling_Fund() throws XtumlException;
    public void setCeiling_Fund( double m_Ceiling_Fund ) throws XtumlException;
    public double getRequest_Fund() throws XtumlException;
    public void setRequest_Fund( double m_Request_Fund ) throws XtumlException;
    public void setYear( String m_Year ) throws XtumlException;
    public String getYear() throws XtumlException;
    public void setFund( double m_Fund ) throws XtumlException;
    public double getFund() throws XtumlException;


    // operations


    // selections
    default public void setR1_Budget( Budget inst ) {}
    public Budget R1_Budget() throws XtumlException;
    default public void addR2_Section( Section inst ) {}
    default public void removeR2_Section( Section inst ) {}
    public SectionSet R2_Section() throws XtumlException;


}
