package hrsystem.budget.main;


import hrsystem.Budget;
import hrsystem.budget.main.Chapter;
import hrsystem.budget.main.Item;
import hrsystem.budget.main.ItemSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Section extends IModelInstance<Section,Budget> {

    // attributes
    public void setID( String m_ID ) throws XtumlException;
    public String getID() throws XtumlException;
    public int getCode() throws XtumlException;
    public void setCode( int m_Code ) throws XtumlException;
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setFund( double m_Fund ) throws XtumlException;
    public double getFund() throws XtumlException;
    public void setEconomic_Category( String m_Economic_Category ) throws XtumlException;
    public String getEconomic_Category() throws XtumlException;
    public void setComments( String m_Comments ) throws XtumlException;
    public String getComments() throws XtumlException;


    // operations


    // selections
    default public void setR2_Chapter( Chapter inst ) {}
    public Chapter R2_Chapter() throws XtumlException;
    default public void addR3_Item( Item inst ) {}
    default public void removeR3_Item( Item inst ) {}
    public ItemSet R3_Item() throws XtumlException;


}
