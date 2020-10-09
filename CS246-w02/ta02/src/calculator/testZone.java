package calculator;

import java.util.ArrayList;
import java.util.List;

class testZone {

    public static void main(String[] args) {


    }

    /**
     * An internal method used by VacationCalculator to loop through
     * a List of items that implement the Expense interface and
     * determine their cost
     *
     * @param  expenses A list of items that implement the Expense interface
     * @return          the total cost calculated by the items
     */
    float tallyExpenses(List<Expense> expenses)
    {
        float totalCost = 0;
        for (Expense expense : expenses) {
            totalCost += expense.getCost();
        }
        return totalCost;
    }
}