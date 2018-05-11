package budgetapp.ui;

import budgetapp.domain.MoneyManager;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TextUI {

    private Scanner scanner;
    private MoneyManager service;
    private Map<String, String> commands;

    public TextUI(Scanner scanner, MoneyManager service) {
        this.scanner = scanner;
        this.service = service;

        commands = new TreeMap<>();

        commands.put("q", "q quit");
        commands.put("Q", "q quit");
        commands.put("1", "1 create a wallet");
        commands.put("2", "2 set a new balance");
        commands.put("3", "3 show balance");
        commands.put("4", "4 show all transactions");
        commands.put("5", "5 create a budget");
        commands.put("6", "6 show your budget");
        commands.put("+", "+ income");
        commands.put("-", "- expense");
        commands.put("0", "0 reset wallet");
    }

    public void printCommands() {
        System.out.println("");
        System.out.println("Key commands:");
        System.out.println("[q] quit");
        System.out.println("[1] create a wallet");
        System.out.println("[2] set a new balance");
        System.out.println("[3] show balance");
        System.out.println("[4] show all transactions");
        System.out.println("[5] create a budget");
        System.out.println("[6] show your budget");
        System.out.println("[+] income");
        System.out.println("[-] expense");
        System.out.println("[0] reset wallet");
    }

    public void start() {
        System.out.println("Welcome to BudgetApp!");
        System.out.println("---");
        if (this.service.walletExists() == true) {
            this.getBalance();
        } else {
            System.out.println("You don't have a wallet yet.\nCreate a wallet with key command [1]");
        }
        printCommands();

        while (true) {
            System.out.println("");
            System.out.print("Command: ");
            String command = scanner.nextLine();

            if (!commands.keySet().contains(command)) {
                System.out.println("Command [" + command + "] not found");
                printCommands();
            }

            if (command.matches("q|Q")) {
                break;
            } else if (command.equals("1")) {
                createWallet();
            } else if (command.equals("2")) {
                setBalance();
            } else if (command.equals("3")) {
                getBalance();
            } else if (command.equals("4")) {
                getTransactions();
            } else if (command.equals("5")) {
                createBudget();
            } else if (command.equals("6")) {
                getBudget();
            } else if (command.equals("+")) {
                addIncome();
            } else if (command.equals("-")) {
                addExpense();
            } else if (command.equals("0")) {
                reset();
            }

        }
    }

    private void createWallet() {
        if (this.service.walletExists()) {
            System.out.println("You already have a wallet.");
            return;
        }
        
        System.out.print("Opening balance (Use format 0.10 or 1000  / Otherwise, balance will be set at 0.00): ");
        double openingBalance;
        try {
            openingBalance = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Balance set at 0.00.");
            openingBalance = 0.0;
        }
        service.createWallet("MyWallet", openingBalance);
    }
    
    private void setBalance() {
        if (!this.service.walletExists()) {
            System.out.println("You need to have a wallet to set a new balance.");
            return;
        }
        System.out.println("Are you sure you want to set a new balance? (y/n)");
        boolean yes = this.yesOrNo();
        if (!yes) {
            return;
        }
        double newBalance;
        System.out.print("New balance (Use format 0.10 or 1000 / Otherwise, the balance will not be changed): ");
        try {
            newBalance = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Balance not changed.");
            return;
        }
        this.service.setBalance(newBalance);
    }
    
    private void getBalance() {
        if (!this.service.walletExists()) {
            System.out.println("You need to create a wallet first to view the balance.");
            return;
        }
        System.out.println("Your balance is: " + service.getBalance());
    }

    private void createBudget() {
        System.out.println("Do you want to create a personal budget? (y/n)");
        boolean yes = this.yesOrNo();
        if (!yes) {
            return;
        }
        double budget;
        System.out.print("What's the size of your personal budget for your chosen time perod? (Use format 0.10 or 100) ");
        try {
            budget = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Personal budget not set.");
            return;
        }
        this.service.createBudget(budget);
    }

    private void getBudget() {
        if (!this.service.budgetExists()) {
            System.out.println("You don't have a personal budget yet.");
            return;
        }
        System.out.println("Your budget: " + this.service.getBudget());
        System.out.println("Spent: " + this.service.getExpenditure());
        System.out.println("Left: " + this.service.getBudgetRemain());
    }

    private void getTransactions() {
        service.getTransactions();
    }

    private void addIncome() {
        if (!this.service.walletExists()) {
            System.out.println("You need to create a wallet first.");
            return;
        }
        System.out.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Description (e.g. date): ");
        String description = scanner.nextLine();
        service.addIncome(amount, description);
    }

    private void addExpense() {
        if (!this.service.walletExists()) {
            System.out.println("You need to create a wallet first.");
            return;
        }
        System.out.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Description (e.g. date): ");
        String desc = scanner.nextLine();
        service.addExpense(amount, desc);
    }

    private void reset() {
        try {
            service.resetWallet();
        } catch (Exception e) {
            System.out.println("Reset failed");
            return;
        }
        System.out.println("Reset succesful");
    }

    private boolean yesOrNo() {
        while (true) {
            String answer = scanner.nextLine();
            if (!answer.matches("n|N|y|Y")) {
                System.out.println("Command not found, try again.");
            } else if (answer.matches("n|N")) {
                return false;
            } else if (answer.matches("y|Y")) {
                return true;
            }
        }
    }

}
