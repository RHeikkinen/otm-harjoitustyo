package budgetapp.domain;

import java.text.DecimalFormat;

public abstract class Transaction {

    private int id;
    private Wallet wallet;
    private double amount;
    private String info;
    private static final DecimalFormat centsFormat = new DecimalFormat("0.00");

    public Transaction(int id, Wallet wallet, double amount, String info) {
        this.id = id;
        this.wallet = wallet;
        this.amount = amount;
        this.info = info;
    }
    
    public Transaction(Wallet wallet, double amount, String info) {
        this.wallet = wallet;
        this.amount = amount;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public double getAmount() {
        return amount;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return centsFormat.format(amount) + " (" + this.getInfo() + ")";
    }
}
