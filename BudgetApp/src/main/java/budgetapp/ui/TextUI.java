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
        this.service = new MoneyManager();
        service = new MoneyManager();

        commands = new TreeMap<>();

        commands.put("q", "q quit");
        commands.put("Q", "q quit");
        commands.put("1", "1 create a wallet");
        commands.put("2", "2 show balance");
        commands.put("3", "3 show all transactions");
        commands.put("4", "4 create a budget");
        commands.put("5", "5 show your budget");
        commands.put("+", "+ income");
        commands.put("-", "- expense");
    }

    public void printCommands() {
        System.out.println("");
        System.out.println("Key commands:");
        System.out.println("[q] quit");
        System.out.println("[1] create a wallet");
        System.out.println("[2] show balance");
        System.out.println("[3] show all transactions");
        System.out.println("[4] create a budget");
        System.out.println("[5] show your budget");
        System.out.println("[+] add income");
        System.out.println("[-] add expense");
        System.out.println("[0] reset wallet");
    }

    public void start() {
        System.out.println("Welcome to BudgetApp!");

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
                getBalance();
            } else if (command.equals("3")) {
                getTransactions();
            } else if (command.equals("4")) {
                createBudget();
            } else if (command.equals("5")) {
                getBudget();
            } else if (command.equals("+")) {
                addIncome();
            } else if (command.equals("-")) {
                addExpense();
            }

        }
    }
    
    private void createWallet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void getBalance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void createBudget() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void getBudget() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void getTransactions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void addIncome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void addExpense() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
