package budgetapp.domain;

import java.text.DecimalFormat;

public class Transaction {

    private double amount;
    private String info;
    private static final DecimalFormat centsFormat = new DecimalFormat("0.00");

    public Transaction(double amount, String info) {
        this.amount = amount;
        this.info = info;
    }

    public double getAmount() {
        return amount;
    }

    public String getInfo() {
        return info;
    }
    
    public void setInfo(String description) {
        this.info = description;
    }

    @Override
    public String toString() {
        return this.getInfo() + " " + centsFormat.format(amount);
    }
}
