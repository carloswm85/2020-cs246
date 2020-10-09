package calculator;

import java.util.ArrayList;
import java.util.List;

class VacationCalculator {

    public static void main(String[] args) {

        VacationCalculator vc = new VacationCalculator();
        float numberNights = 5;

        // Calculate some vacation costs...
        float japanCost = vc.calculateVacationCost(Destination.Japan, numberNights);

        // Print the cost...
        System.out.format("Vacation costs is %f", japanCost);
    }

    /**
     * Calculates the total cost for vacationing at a given location for
     * a specific number of nights.
     *
     * @param  dest the destination of the vacation
     * @return      the total cost of the vacation
     */
    public float calculateVacationCost(Destination dest, float numberNights)
    {
        List<Expense> expenses = new ArrayList<>();
        Cruise cruise = new Cruise(dest);
        Dining dining = new Dining(dest, numberNights);
        Lodging lodging = new Lodging(dest, numberNights);

        expenses.add(cruise);
        expenses.add(dining);
        expenses.add(lodging);

        float totalExpenses = tallyExpenses(expenses);

        return totalExpenses;
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