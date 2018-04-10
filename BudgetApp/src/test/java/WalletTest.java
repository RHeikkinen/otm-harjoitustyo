import budgetapp.domain.Wallet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class WalletTest {
    
    Wallet myWallet;
    double DELTA = 0.0000001;

    @Before
    public void setUp() {
        myWallet = new Wallet("My Wallet", 400.0);
        
    }
    
    @Test
    public void getBalanceReturnsTheRightBalance() {
        assertEquals(400.0, myWallet.getBalance(), DELTA);
    }


    
}