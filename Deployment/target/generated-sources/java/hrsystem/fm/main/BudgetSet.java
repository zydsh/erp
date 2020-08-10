package hrsystem.fm.main;


import hrsystem.fm.main.ChapterSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface BudgetSet extends IInstanceSet<BudgetSet,Budget> {

    // attributes
    public void setYear( String m_Year ) throws XtumlException;
    public void setFund( double m_Fund ) throws XtumlException;


    // selections
    public ChapterSet R1_Chapter() throws XtumlException;


}
