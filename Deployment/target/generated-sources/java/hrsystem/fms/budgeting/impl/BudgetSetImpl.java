package hrsystem.fms.budgeting.impl;


import hrsystem.fms.budgeting.Budget;
import hrsystem.fms.budgeting.BudgetSet;
import hrsystem.fms.budgeting.ChapterSet;
import hrsystem.fms.budgeting.impl.ChapterSetImpl;

import io.ciera.runtime.summit.classes.InstanceSet;
import io.ciera.runtime.summit.exceptions.XtumlException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class BudgetSetImpl extends InstanceSet<BudgetSet,Budget> implements BudgetSet {

    public BudgetSetImpl() {
    }

    public BudgetSetImpl(Comparator<? super Budget> comp) {
        super(comp);
    }

    // attributes
    @Override
    public void setYear( String m_Year ) throws XtumlException {
        for ( Budget budget : this ) budget.setYear( m_Year );
    }
    @Override
    public void setAmount( double m_Amount ) throws XtumlException {
        for ( Budget budget : this ) budget.setAmount( m_Amount );
    }


    // selections
    @Override
    public ChapterSet R100_divided_Chapter() throws XtumlException {
        ChapterSet chapterset = new ChapterSetImpl();
        for ( Budget budget : this ) chapterset.addAll( budget.R100_divided_Chapter() );
        return chapterset;
    }


    @Override
    public Budget nullElement() {
        return BudgetImpl.EMPTY_BUDGET;
    }

    @Override
    public BudgetSet emptySet() {
      return new BudgetSetImpl();
    }

    @Override
    public BudgetSet emptySet(Comparator<? super Budget> comp) {
      return new BudgetSetImpl(comp);
    }

    @Override
    public List<Budget> elements() {
        return Arrays.asList(toArray(new Budget[0]));
    }

}
