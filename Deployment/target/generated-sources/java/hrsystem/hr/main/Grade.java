package hrsystem.hr.main;


import hrsystem.Hr;
import hrsystem.hr.main.Grade;
import hrsystem.hr.main.Job;
import hrsystem.hr.main.JobSet;
import hrsystem.hr.main.Scale;

import io.ciera.runtime.summit.classes.IModelInstance;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface Grade extends IModelInstance<Grade,Hr> {

    // attributes
    public String getName() throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setAllowance( double m_Allowance ) throws XtumlException;
    public double getAllowance() throws XtumlException;
    public double getBaseSalary() throws XtumlException;
    public void setBaseSalary( double m_BaseSalary ) throws XtumlException;
    public void setNumberOfSteps( int m_NumberOfSteps ) throws XtumlException;
    public int getNumberOfSteps() throws XtumlException;


    // operations


    // selections
    default public void setR12_is_part_of_Scale( Scale inst ) {}
    public Scale R12_is_part_of_Scale() throws XtumlException;
    default public void setR14_follows_Grade( Grade inst ) {}
    public Grade R14_follows_Grade() throws XtumlException;
    default public void setR14_proceeds_Grade( Grade inst ) {}
    public Grade R14_proceeds_Grade() throws XtumlException;
    default public void addR9_assigned_Job( Job inst ) {}
    default public void removeR9_assigned_Job( Job inst ) {}
    public JobSet R9_assigned_Job() throws XtumlException;


}
