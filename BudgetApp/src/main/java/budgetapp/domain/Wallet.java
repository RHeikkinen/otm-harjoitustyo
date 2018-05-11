package budgetapp.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private String name;
    private double balance;
    private Budget budget;
    private List<Transaction> transactions;
    private static final DecimalFormat CENTS_FORMAT = new DecimalFormat("0.00");

    public Wallet(String name, double openingBalance) {
        this.name = name;
        this.balance = openingBalance;
        this.transactions = new ArrayList<>();
    }

    public double getBalance() {
        return this.balance;
    }
    
    public void setBalance(double amount) {
        this.balance = amount;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            return;
        }
        this.balance += amount;
        this.transactions.add(new Transaction(amount, "+"));
    }
    
    public void withdraw(double amount) {
        if (amount < 0) {
            return;
        }
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return CENTS_FORMAT.format(balance);
    }
    
    public void getTransactions() {
        transactions.forEach((t) -> {
            System.out.println(t.toString());
        });
    }

    public void reset() {
        this.balance = 0;
        this.transactions.clear();
    }
 
}
