package budget;

import budget.model.Category;
import budget.model.Expense;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Pawel on 2016-11-11.
 */
public class TestBudget {

    private Budget budget;

    @Before
    public final void before() {
        budget = new Budget();
    }

    @Test
    public void oneExpenseAfterAddingOne(){
        Expense expense = new Expense();
        budget.addExpense(expense);
        Assert.assertEquals(1, budget.getExpenses().size());
    }

    @Test
    public void twoExpensesFromDatePeriod(){
        Calendar c = Calendar.getInstance();
        c.set(2016, 11, 1);
        Expense expense = new Expense(Category.FOODS, c.getTime(), BigDecimal.valueOf(32.50));
        budget.addExpense(expense);
        expense = new Expense(Category.AUTO, c.getTime(), BigDecimal.valueOf(206.52));
        budget.addExpense(expense);
        Assert.assertEquals(2, budget.getExpenses(2016, 11).size());
    }

    @Test
    public void sumOfExpensesFromDatePeriod(){
        Calendar c = Calendar.getInstance();
        c.set(2016, 11, 1);
        Expense expense = new Expense(Category.FOODS, c.getTime(), BigDecimal.valueOf(32.50));
        budget.addExpense(expense);
        expense = new Expense(Category.AUTO, c.getTime(), BigDecimal.valueOf(206.52));
        budget.addExpense(expense);
        Assert.assertEquals(new Double(239.02), budget.getSumOfExpenses(2016, 11));
    }

    @Test
    public void expenseFromJanuary(){
        Calendar c = Calendar.getInstance();
        c.set(2017, 01, 01);
        Expense expense = new Expense(Category.FOODS, c.getTime(), BigDecimal.valueOf(18.00));
        budget.addExpense(expense);
        Assert.assertEquals(1, budget.getExpenses(2017, 1).size());
    }
}
