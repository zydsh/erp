package hrsystem.fms.budgeting;


import hrsystem.Fms;
import hrsystem.fms.budgeting.Section;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;

import sharedtypes.Category;
import sharedtypes.Income;


public interface Item extends IModelInstance<Item,Fms> {

    // attributes
    public void setBasis( String m_Basis ) throws XtumlException;
    public String getBasis() throws XtumlException;
    public void setCategory( Category m_Category ) throws XtumlException;
    public Category getCategory() throws XtumlException;
    public Income getType() throws XtumlException;
    public void setType( Income m_Type ) throws XtumlException;
    public void setStatus( String m_Status ) throws XtumlException;
    public String getStatus() throws XtumlException;
    public int getFund() throws XtumlException;
    public void setFund( int m_Fund ) throws XtumlException;


    // operations


    // selections
    default public void setR3_attributed_to_Section( Section inst ) {}
    public Section R3_attributed_to_Section() throws XtumlException;


}
