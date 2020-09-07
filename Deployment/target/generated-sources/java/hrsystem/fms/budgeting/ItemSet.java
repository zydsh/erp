package hrsystem.fms.budgeting;


import hrsystem.fms.budgeting.SectionSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface ItemSet extends IInstanceSet<ItemSet,Item> {

    // attributes
    public void setStatus( String m_Status ) throws XtumlException;
    public void setType( UnresolvedType0 m_Type ) throws XtumlException;
    public void setCategory( String m_Category ) throws XtumlException;
    public void setFund( int m_Fund ) throws XtumlException;


    // selections
    public SectionSet R3_attributed_to_Section() throws XtumlException;


}
