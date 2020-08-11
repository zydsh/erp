package hrsystem.fm.main;


import hrsystem.fm.main.SectionSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface ItemSet extends IInstanceSet<ItemSet,Item> {

    // attributes
    public void setCategory( String m_Category ) throws XtumlException;
    public void setStatus( String m_Status ) throws XtumlException;
    public void setFund( double m_Fund ) throws XtumlException;
    public void setItemID( String m_ItemID ) throws XtumlException;
    public void setType( String m_Type ) throws XtumlException;


    // selections
    public SectionSet R3_Section() throws XtumlException;


}
