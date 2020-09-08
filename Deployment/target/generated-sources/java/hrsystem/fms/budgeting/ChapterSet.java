package hrsystem.fms.budgeting;


import hrsystem.fms.budgeting.BudgetSet;
import hrsystem.fms.budgeting.SectionSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface ChapterSet extends IInstanceSet<ChapterSet,Chapter> {

    // attributes
    public void setRequestFund( double m_RequestFund ) throws XtumlException;
    public void setCode( String m_Code ) throws XtumlException;
    public void setCeilingFund( double m_CeilingFund ) throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;


    // selections
    public BudgetSet R100_belongs_Budget() throws XtumlException;
    public SectionSet R200_divided_Section() throws XtumlException;


}
