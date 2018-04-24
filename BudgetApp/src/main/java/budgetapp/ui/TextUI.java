package budgetapp.ui;

import java.util.Scanner;

public class TextUI {

    private Scanner scanner;
    
    
    
    public void start() {
        System.out.println("*** BudgetApp ***");
        
        System.out.println("");
        System.out.println("Key commands:");
        System.out.println("[q] quit");
        System.out.println("[1] create a wallet");
        System.out.println("[2] show balance");
        System.out.println("[3] show all transactions");
        System.out.println("[4] create a budget");
        System.out.println("[5] show your budget");
        System.out.println("[+] income");
        System.out.println("[-] expense");
        
    }
    
}
