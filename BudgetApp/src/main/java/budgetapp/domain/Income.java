package budgetapp.domain;

import java.text.DecimalFormat;

public class Income extends Transaction {

    private int id;
    private Wallet wallet;
    private double amount;
    private String info;
    private static final DecimalFormat centsFormat = new DecimalFormat("0.00");

    public Income(int id, Wallet wallet, double amount, String info) {
        super(id, wallet, amount, info);
    }
    
    public Income(Wallet wallet, double amount, String info) {
        super(wallet, amount, info);
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
        return "+ " + super.toString();
    }

}
