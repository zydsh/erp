package hrsystem.fm.main;


import hrsystem.Fm;
import hrsystem.fm.main.Section;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Item extends IModelInstance<Item,Fm> {

    // attributes
    public void setItemID( String m_ItemID ) throws XtumlException;
    public String getItemID() throws XtumlException;
    public double getFund() throws XtumlException;
    public void setFund( double m_Fund ) throws XtumlException;
    public void setStatus( String m_Status ) throws XtumlException;
    public String getStatus() throws XtumlException;
    public String getType() throws XtumlException;
    public void setType( String m_Type ) throws XtumlException;
    public void setCategory( String m_Category ) throws XtumlException;
    public String getCategory() throws XtumlException;


    // operations


    // selections
    default public void setR3_Section( Section inst ) {}
    public Section R3_Section() throws XtumlException;


}
