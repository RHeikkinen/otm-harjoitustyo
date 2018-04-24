
package budgetapp.domain;

import budgetapp.ui.TextUI;
import java.util.Scanner;

public class Main {
    
    public static void main(String [ ] args) {
        Scanner scanner = new Scanner(System.in);
        MoneyManager service = new MoneyManager();
        
        TextUI budgetapp = new TextUI(scanner, service);
        budgetapp.start();
                
    }
    
}
