package budget;

import java.math.BigDecimal;
import java.util.*;

import budget.model.Expense;

/**
 * Created by Pawel on 2016-11-11.
 */
public class Budget {

    private List<Expense> expenses = new ArrayList<>();

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public void addExpense(Expense expense){
        this.expenses.add(expense);
    }

    public List<Expense> getExpenses(int year, int month) {
        List<Expense> retList = new LinkedList<>();
        for(Iterator<Expense> it = this.expenses.iterator(); it.hasNext();){
            Expense expense = it.next();
            if(isFrom(expense, year, month)){
                retList.add(expense);
            }
        }
        return retList;
    }

    public Double getSumOfExpenses(int year, int month){
        BigDecimal retValue = BigDecimal.ZERO;
        for(Iterator<Expense> it = this.expenses.iterator(); it.hasNext();){
            Expense expense = it.next();
            if(isFrom(expense, year, month)){
                retValue = retValue.add(expense.getValue());
            }
        }
        return retValue.doubleValue();
    }

    private boolean isFrom(Expense expense, int year, int month){
        Calendar expenseDate = Calendar.getInstance();
        expenseDate.setTime(expense.getDate());
        if(expenseDate.get(Calendar.YEAR) == year && expenseDate.get(Calendar.MONTH) == month){
            return true;
        }
        return false;
    }
}
