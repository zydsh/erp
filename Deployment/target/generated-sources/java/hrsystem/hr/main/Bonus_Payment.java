package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Bonus;
import hrsystem.hr.main.Employee;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Bonus_Payment extends IModelInstance<Bonus_Payment,Hr> {

    // attributes
    public void setStarting( int m_Starting ) throws XtumlException;
    public int getStarting() throws XtumlException;
    public void setEnding( int m_Ending ) throws XtumlException;
    public int getEnding() throws XtumlException;
    public double getAmount() throws XtumlException;
    public void setAmount( double m_Amount ) throws XtumlException;
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public int getID() throws XtumlException;
    public void setID( int m_ID ) throws XtumlException;


    // operations


    // selections
    default public void setR4_Bonus( Bonus inst ) {}
    public Bonus R4_Bonus() throws XtumlException;
    default public void setR4_Employee( Employee inst ) {}
    public Employee R4_Employee() throws XtumlException;


}
