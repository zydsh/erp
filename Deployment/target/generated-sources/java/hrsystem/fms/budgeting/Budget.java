package hrsystem.fms.budgeting;


import hrsystem.Fms;
import hrsystem.fms.budgeting.Chapter;
import hrsystem.fms.budgeting.ChapterSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Budget extends IModelInstance<Budget,Fms> {

    // attributes
    public void setYear( String m_Year ) throws XtumlException;
    public String getYear() throws XtumlException;
    public void setAmount( double m_Amount ) throws XtumlException;
    public double getAmount() throws XtumlException;


    // operations


    // selections
    default public void addR100_divided_Chapter( Chapter inst ) {}
    default public void removeR100_divided_Chapter( Chapter inst ) {}
    public ChapterSet R100_divided_Chapter() throws XtumlException;


}
