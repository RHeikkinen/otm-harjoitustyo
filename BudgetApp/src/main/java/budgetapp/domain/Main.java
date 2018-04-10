
package budgetapp.domain;

public class Main {
    
    public static void main(String [ ] args) {
        Wallet myWallet = new Wallet("My Wallet", 400);
        
        System.out.println("Balance: " + myWallet);
    }
    
}
