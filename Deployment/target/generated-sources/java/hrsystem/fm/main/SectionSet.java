package hrsystem.fm.main;


import hrsystem.fm.main.ChapterSet;
import hrsystem.fm.main.ItemSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface SectionSet extends IInstanceSet<SectionSet,Section> {

    // attributes
    public void setComments( String m_Comments ) throws XtumlException;
    public void setSecID( String m_SecID ) throws XtumlException;
    public void setCode( String m_Code ) throws XtumlException;
    public void setFund( double m_Fund ) throws XtumlException;
    public void setEconomic_Category( String m_Economic_Category ) throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;


    // selections
    public ChapterSet R2_Chapter() throws XtumlException;
    public ItemSet R3_Item() throws XtumlException;


}
