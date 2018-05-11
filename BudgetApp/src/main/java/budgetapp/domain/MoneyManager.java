package budgetapp.domain;

import java.text.DecimalFormat;


public class MoneyManager {

    private Wallet wallet;
    private Budget budget;
    private static final DecimalFormat CENTS_FORMAT = new DecimalFormat("0.00");

    public MoneyManager() {
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

    public boolean addIncome(double amount, String description) {
        if (amount < 0) {
            return false;
        }
        wallet.deposit(amount);
        return true;
    }

    public boolean addExpense(double amount, String description) {
        if (amount < 0 || wallet.getBalance() < amount) {
            return false;
        }
        wallet.withdraw(amount);        
        if (budgetExists()) {
            this.budget.updateBudgetCounter(amount);
        }
        return true;
    }

    public boolean resetWallet() {
        if (!walletExists()) {
            return false;
        }
        this.wallet.reset();
        return true;
    }

    public void getTransactions() {
        this.wallet.getTransactions();

    }

    public boolean budgetExists() {
        return this.budget != null;
    }

    public void createBudget(double amount) {
        this.budget = new Budget(amount);
    }

    public String getBudget() {
        return this.budget.toString();
    }

    public String getExpenditure() {
        return this.budget.getExpanditure();
    }

    public String getBudgetRemain() {
        return CENTS_FORMAT.format(this.budget.getBudgetCounter());
    }

}
