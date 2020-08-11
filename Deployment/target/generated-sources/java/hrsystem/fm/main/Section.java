package hrsystem.fm.main;


import hrsystem.Fm;
import hrsystem.fm.main.Chapter;
import hrsystem.fm.main.Item;
import hrsystem.fm.main.ItemSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Section extends IModelInstance<Section,Fm> {

    // attributes
    public String getSecID() throws XtumlException;
    public void setSecID( String m_SecID ) throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public String getName() throws XtumlException;
    public void setCode( String m_Code ) throws XtumlException;
    public String getCode() throws XtumlException;
    public void setFund( double m_Fund ) throws XtumlException;
    public double getFund() throws XtumlException;
    public void setEconomic_Category( String m_Economic_Category ) throws XtumlException;
    public String getEconomic_Category() throws XtumlException;
    public String getComments() throws XtumlException;
    public void setComments( String m_Comments ) throws XtumlException;


    // operations


    // selections
    default public void setR2_Chapter( Chapter inst ) {}
    public Chapter R2_Chapter() throws XtumlException;
    default public void addR3_Item( Item inst ) {}
    default public void removeR3_Item( Item inst ) {}
    public ItemSet R3_Item() throws XtumlException;


}
