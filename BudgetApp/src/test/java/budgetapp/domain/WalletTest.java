package budgetapp.domain;

import org.junit.Before;
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
    public void getBalanceReturnsRightBalance() {
        assertEquals(400.0, myWallet.getBalance(), DELTA);
    }
    
    @Test
    public void depositTest() {
        myWallet.deposit(300.25);
        assertEquals(700.25, myWallet.getBalance(), DELTA);
    }
    
    @Test
    public void withdrawTest() {
        myWallet.withdraw(300.25);
        assertEquals(99.75, myWallet.getBalance(), DELTA);
    }
    
    @Test
    public void depositTestWithNegativeAmount() {
        myWallet.deposit(-50);
        assertEquals(400.0, myWallet.getBalance(), DELTA);
    }
    
    @Test
    public void withdrawTestWithNegativeAmount() {
        myWallet.withdraw(-50);
        assertEquals(400.0, myWallet.getBalance(), DELTA);
    }
    
    @Test
    public void setBalanceSetsNewBalance() {
        myWallet.setBalance(80.55);
        assertEquals(80.55, myWallet.getBalance(), DELTA);
    }
    
    @Test
    public void toStringReturnsCorrectFormat() {
        assertEquals("400.00", myWallet.toString());
    }
    
    @Test
    public void correctBalanceAfterReset() {
        myWallet.reset();
        assertEquals(0.0, myWallet.getBalance(), DELTA);
    }
    
    @Test
    public void toStringReturnsCorrectFormatAfterReset() {
        myWallet.reset();
        assertEquals("0.00", myWallet.toString());
    }


    
}
