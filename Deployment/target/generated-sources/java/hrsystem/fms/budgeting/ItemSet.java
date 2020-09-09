package hrsystem.fms.budgeting;


import hrsystem.fms.budgeting.SectionSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import sharedtypes.Category;
import sharedtypes.Income;


public interface ItemSet extends IInstanceSet<ItemSet,Item> {

    // attributes
    public void setCategory( Category m_Category ) throws XtumlException;
    public void setStatus( String m_Status ) throws XtumlException;
    public void setBasis( String m_Basis ) throws XtumlException;
    public void setType( Income m_Type ) throws XtumlException;
    public void setFund( int m_Fund ) throws XtumlException;


    // selections
    public SectionSet R3_attributed_to_Section() throws XtumlException;


}
