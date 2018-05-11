package budgetapp.domain;

import java.text.DecimalFormat;

public class Budget {

    private int id;
    private Wallet wallet;
    private double budget;
    private String info;
    private static final DecimalFormat centsFormat = new DecimalFormat("0.00");
    
    public Budget(int id, double budget, Wallet myWallet) {
        this.id = id;
        this.budget = budget;
        this.wallet = myWallet;

    }
    
    public Budget(double budget, String info, Wallet myWallet) {
        this.budget = budget;
        this.info = info;
        this.wallet = myWallet;

    }

    public int getId() {
        return id;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public double getBudget() {
        return budget;
    }

    public String getInfo() {
        return info;
    }
    
    @Override
    public String toString() {
        return centsFormat.format(budget);
    }

}
