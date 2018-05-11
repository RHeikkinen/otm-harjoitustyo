package budgetapp.domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MoneyManager {

    private Wallet wallet;
    private Budget budget;
    private List<Transaction> transactions;
    public double budgetCounter;
    private static final DecimalFormat centsFormat = new DecimalFormat("0.00");

    public MoneyManager() {
        this.transactions = new ArrayList<>();
    }

    public void createWallet(String name, double startingBalance) {
        this.wallet = new Wallet(name, startingBalance);
    }

    public boolean walletExists() {
        return this.wallet != null;
    }

    public void setBalance(double balance) {
        this.wallet.setBalance(balance);
    }

    public String getBalance() {
        return wallet.toString();
    }

    public void addIncome(double amount, String description) {
        if (amount >= 0) {
            wallet.deposit(amount);
            this.transactions.add(new Income(wallet, amount, description));
        }
    }

    public void addExpense(double amount, String description) {
        if (amount >= 0 && wallet.getBalance() >= amount) {
            wallet.withdraw(amount);
            if (budgetExists()) {
                this.budgetCounter -= amount;
            }
            this.transactions.add(new Expense(wallet, amount, description));
        }
    }

    public void resetWallet() {
        if (walletExists()) {
            this.wallet.reset();
            this.transactions.clear();
        }
    }

    public void getTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t.toString());
            System.out.println("---");
        }

    }

    public boolean budgetExists() {
        return this.budget != null;
    }

    public void createBudget(double amount) {
        this.budget = new Budget(1, amount, wallet);
        this.budgetCounter = amount;
    }

    public String getBudget() {
        return this.budget.toString();
    }

    public String getExpenditure() {
        return centsFormat.format(this.budget.getBudget() - this.budgetCounter);
    }

    public String getBudgetRemain() {
        return centsFormat.format(this.budgetCounter);
    }

}
