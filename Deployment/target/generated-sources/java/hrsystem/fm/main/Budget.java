package hrsystem.fm.main;


import hrsystem.Fm;
import hrsystem.fm.main.Chapter;
import hrsystem.fm.main.ChapterSet;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Budget extends IModelInstance<Budget,Fm> {

    // attributes
    public void setYear( String m_Year ) throws XtumlException;
    public String getYear() throws XtumlException;
    public double getFund() throws XtumlException;
    public void setFund( double m_Fund ) throws XtumlException;


    // operations


    // selections
    default public void addR1_Chapter( Chapter inst ) {}
    default public void removeR1_Chapter( Chapter inst ) {}
    public ChapterSet R1_Chapter() throws XtumlException;


}
