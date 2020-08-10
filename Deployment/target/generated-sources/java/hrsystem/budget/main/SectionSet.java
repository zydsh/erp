package hrsystem.budget.main;


import hrsystem.budget.main.ChapterSet;
import hrsystem.budget.main.ItemSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface SectionSet extends IInstanceSet<SectionSet,Section> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public void setCode( int m_Code ) throws XtumlException;
    public void setEconomic_Category( String m_Economic_Category ) throws XtumlException;
    public void setID( String m_ID ) throws XtumlException;
    public void setFund( double m_Fund ) throws XtumlException;
    public void setComments( String m_Comments ) throws XtumlException;


    // selections
    public ChapterSet R2_Chapter() throws XtumlException;
    public ItemSet R3_Item() throws XtumlException;


}
