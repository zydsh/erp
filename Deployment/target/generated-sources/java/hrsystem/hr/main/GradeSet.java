package hrsystem.hr.main;


import hrsystem.hr.main.GradeSet;
import hrsystem.hr.main.JobSet;
import hrsystem.hr.main.ScaleSet;

import io.ciera.runtime.summit.classes.IInstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;


public interface GradeSet extends IInstanceSet<GradeSet,Grade> {

    // attributes
    public void setAllowance( double m_Allowance ) throws XtumlException;
    public void setNumberOfSteps( int m_NumberOfSteps ) throws XtumlException;
    public void setName( String m_Name ) throws XtumlException;
    public void setBaseSalary( double m_BaseSalary ) throws XtumlException;


    // selections
    public ScaleSet R12_is_part_of_Scale() throws XtumlException;
    public GradeSet R14_follows_Grade() throws XtumlException;
    public GradeSet R14_proceeds_Grade() throws XtumlException;
    public JobSet R9_assigned_Job() throws XtumlException;


}
