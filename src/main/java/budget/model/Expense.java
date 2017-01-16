package budget.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Pawel on 2016-11-11.
 */
public class Expense {

    private Date date;

    private Category category;

    private BigDecimal value;

    public Expense(){}

    public Expense(Category category, Date date, BigDecimal value){
        this.category = category;
        this.date = date;
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
