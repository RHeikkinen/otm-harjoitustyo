package budgetapp.domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BudgetTest {

    Budget myBudget;
    Wallet myWallet;
    double DELTA = 0.000000001;

    @Before
    public void setUp() {
        myWallet = new Wallet("MyWallet", 500.0);
        myBudget = new Budget(300);
    }

    @Test
    public void getBudgetReturnsCorrectValue() {
        assertEquals(300.0, myBudget.getBudget(), DELTA);
    }

    @Test
    public void getBudgetCounterReturnsCorrectValue() {
        myBudget.updateBudgetCounter(50);
        assertEquals(250.0, myBudget.getBudgetCounter(), DELTA);
    }

    @Test
    public void getExpanditureReturnsCorrectValue() {
        myBudget.updateBudgetCounter(55);
        assertEquals("55.00", myBudget.getExpanditure());
    }
    
    @Test
    public void toStringReturnsCorrectFormat() {
        assertEquals("300.00", myBudget.toString());
    }

}
