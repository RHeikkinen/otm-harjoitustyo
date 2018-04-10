package budgetapp.domain;

public class Wallet {
    
    private String name;
    private double balance;
    
    public Wallet(String name, double openingBalance) {
        this.name = name;
        this.balance = openingBalance;
    }
    
    public double getBalance() {
        return this.balance;
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
    
    public void reset() {
        this.balance = 0;
    }
}
