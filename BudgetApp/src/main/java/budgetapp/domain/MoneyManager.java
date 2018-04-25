package budgetapp.domain;

import java.util.ArrayList;
import java.util.List;

public class MoneyManager {

    private Wallet myWallet;
    private List<Transaction> transactions;

    public MoneyManager() {
        this.myWallet = new Wallet("My Wallet", 0.0);
        this.transactions = new ArrayList<>();
    }

    public void createWallet(String name, double startingBalance) {
        this.myWallet = new Wallet(name, startingBalance);
    }

    public void addIncome(double amount, String description) {
        if (amount >= 0) {
            myWallet.deposit(amount);
            this.transactions.add(new Income(myWallet, amount, description));
            System.out.println("Transaction succesful");
            System.out.println("Your balance is: " + myWallet.toString());
        } else {
            System.out.println("Transaction failed");
        }
    }

    public void addExpense(double amount, String description) {
        if (amount >= 0 && myWallet.getBalance() >= amount) {
            myWallet.withdraw(amount);
            this.transactions.add(new Expense(myWallet, amount, description));
            System.out.println("Transaction succesful");
            System.out.println("Your balance is: " + myWallet.toString());
        } else {
            System.out.println("Transaction failed");
        }
    }

    public void resetWallet() {
        this.myWallet = new Wallet("My Wallet", 0.0);
        this.transactions.clear();
        System.out.println("Reset succesful");
        System.out.println("---");
        System.out.println("Your balance is: " + myWallet.toString());

    }

    public void getTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t.toString());
            System.out.println("---");
        }

    }

    public void getBalance() {
        System.out.println("Your balance is: " + myWallet.toString());
    }

}
