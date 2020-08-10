package erp.budget.main;


import erp.budget.main.BudgetSet;
import erp.budget.main.SectionSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface ChapterSet extends IInstanceSet<ChapterSet,Chapter> {

    // attributes
    public void setRequest_Fund( double m_Request_Fund ) throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setCeiling_Fund( double m_Ceiling_Fund ) throws XtumlException;
    public void setCode( int m_Code ) throws XtumlException;
    public void setFund( double m_Fund ) throws XtumlException;
    public void setYear( int ref_Year ) throws XtumlException;


    // selections
    public BudgetSet R1_Budget() throws XtumlException;
    public SectionSet R2_Section() throws XtumlException;


}
