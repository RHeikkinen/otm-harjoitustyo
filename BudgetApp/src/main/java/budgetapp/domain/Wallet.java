package budgetapp.domain;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Wallet {

    private String name;
    private double balance;
    private static final DecimalFormat centsFormat = new DecimalFormat("0.00");
//  private static final NumberFormat EURO_FORMAT_FRANCE = NumberFormat.getCurrencyInstance(Locale.FRANCE);

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
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }

    public String toString() {
//      return EURO_FORMAT_FRANCE.format(balance);
        return centsFormat.format(balance);
    }

    public void reset() {
        this.balance = 0;
    }
}
