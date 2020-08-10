package erp.hr.main;


import erp.Hr;
import erp.hr.main.Employee;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Payment extends IModelInstance<Payment,Hr> {

    // attributes
    public void setName( String m_Name ) throws XtumlException;
    public String getName() throws XtumlException;
    public void setAmount( double m_Amount ) throws XtumlException;
    public double getAmount() throws XtumlException;
    public int getDate() throws XtumlException;
    public void setDate( int m_Date ) throws XtumlException;
    public int getNational_ID() throws XtumlException;
    public void setNational_ID( int ref_National_ID ) throws XtumlException;


    // operations


    // selections
    default public void setR3_Employee( Employee inst ) {}
    public Employee R3_Employee() throws XtumlException;


}
