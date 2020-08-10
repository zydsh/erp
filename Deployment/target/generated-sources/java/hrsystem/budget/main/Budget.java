package hrsystem.budget.main;


import hrsystem.Budget;
import hrsystem.budget.main.Chapter;
import hrsystem.budget.main.ChapterSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Budget extends IModelInstance<Budget,Budget> {

    // attributes
    public String getYear() throws XtumlException;
    public void setYear( String m_Year ) throws XtumlException;
    public double getFund() throws XtumlException;
    public void setFund( double m_Fund ) throws XtumlException;


    // operations


    // selections
    default public void addR1_Chapter( Chapter inst ) {}
    default public void removeR1_Chapter( Chapter inst ) {}
    public ChapterSet R1_Chapter() throws XtumlException;


}
