
package budgetapp.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MoneyManagerTest {

    MoneyManager myService;

    @Before
    public void setUp() {
        myService = new MoneyManager();
    }
    
    @Test
    public void walletCanBeCreated() {
        myService.createWallet("MyWallet", 500.0);
        assertEquals(true, myService.walletExists());
    }
    
    @Test
    public void walletExistsBooleanTest() {
        assertEquals(false, myService.walletExists());
    }
    
    @Test
    public void newBalanceCanBeSet() {
        myService.createWallet("MyWallet", 500.0);
        myService.setBalance(28.66);
        assertEquals("28.66", myService.getBalance());
    }
    
    @Test
    public void addIncomeUpdatesBalance() {
        myService.createWallet("MyWallet", 500.0);
        myService.addIncome(50.55, "+");
        assertEquals("550.55", myService.getBalance());
    }
    
    @Test
    public void addExpenseUpdatesBalance() {
        myService.createWallet("MyWallet", 500.0);
        myService.addExpense(50.55, "-");
        assertEquals("449.45", myService.getBalance());
    }
    
    @Test
    public void budgetExistsBooleanTest() {
        assertEquals(false, myService.budgetExists());
    }
    
    @Test
    public void budgetCanBeCreated() {
        myService.createBudget(500.0);
        assertEquals(true, myService.budgetExists());
    }
    
    
    
 
            
}
