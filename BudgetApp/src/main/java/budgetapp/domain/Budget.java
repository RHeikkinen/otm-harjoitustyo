package budgetapp.domain;

import java.text.DecimalFormat;

public class Budget {

    private int id;
    private double budget;
    private double budgetCounter;
    private static final DecimalFormat CENTS_FORMAT = new DecimalFormat("0.00");
    
    public Budget(double budget) {
        this.budget = budget;
        this.budgetCounter = budget;
    }

    public double getBudget() {
        return budget;
    }
    
    public double getBudgetCounter() {
        return this.budgetCounter;
    }

    public void updateBudgetCounter(double amount) {
        budgetCounter -= amount;
    }
    
    public String getExpanditure() {
        return CENTS_FORMAT.format(getBudget() - budgetCounter);
    }
    
    @Override
    public String toString() {
        return CENTS_FORMAT.format(budget);
    }

}
