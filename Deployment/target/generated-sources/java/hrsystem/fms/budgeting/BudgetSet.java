package hrsystem.fms.budgeting;


import hrsystem.fms.budgeting.ChapterSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface BudgetSet extends IInstanceSet<BudgetSet,Budget> {

    // attributes
    public void setYear( String m_Year ) throws XtumlException;
    public void setAmount( double m_Amount ) throws XtumlException;


    // selections
    public ChapterSet R100_divided_Chapter() throws XtumlException;


}
