package erp.budget.main;


import erp.budget.main.ChapterSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface BudgetSet extends IInstanceSet<BudgetSet,Budget> {

    // attributes
    public void setFund( double m_Fund ) throws XtumlException;
    public void setYear( String m_Year ) throws XtumlException;


    // selections
    public ChapterSet R1_Chapter() throws XtumlException;


}
