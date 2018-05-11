package budgetapp.domain;

import java.text.DecimalFormat;

public class Wallet {

    private String name;
    private double balance;
    private Budget budget;
    private static final DecimalFormat centsFormat = new DecimalFormat("0.00");

    public Wallet(String name, double openingBalance) {
        this.name = name;
        this.balance = openingBalance;
    }

    public double getBalance() {
        return this.balance;
    }
    
    public void setBalance(double amount) {
        this.balance = amount;
    }

    public void deposit(double amount) {
        if (amount >= 0) {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        }
    }
    
    public void withdraw(double amount, Budget budget) {
        if (this.balance >= amount) {
            this.balance -= amount;
        }
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return centsFormat.format(balance);
    }

    public void reset() {
        this.balance = 0;
    }
    
   
}
