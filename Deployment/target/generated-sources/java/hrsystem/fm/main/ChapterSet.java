package hrsystem.fm.main;


import hrsystem.fm.main.BudgetSet;
import hrsystem.fm.main.SectionSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface ChapterSet extends IInstanceSet<ChapterSet,Chapter> {

    // attributes
    public void setCode( String m_Code ) throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setFund( double m_Fund ) throws XtumlException;
    public void setRequest_Fund( double m_Request_Fund ) throws XtumlException;
    public void setYear( String m_Year ) throws XtumlException;
    public void setCeiling_Fund( double m_Ceiling_Fund ) throws XtumlException;


    // selections
    public BudgetSet R1_Budget() throws XtumlException;
    public SectionSet R2_Section() throws XtumlException;


}
