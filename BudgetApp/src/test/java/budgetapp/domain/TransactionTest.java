
package budgetapp.domain;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TransactionTest {

    Transaction myTransaction;
    double DELTA = 0.00000001;
    
    @Before
    public void setUp() {
        myTransaction = new Transaction(50, "+");
    }
    
    @Test
    public void toStringReturnsCorrectFormat() {
        assertEquals("+ 50.00", myTransaction.toString());
    }
    
    @Test
    public void getAmountReturnsCorrectValue() {
        assertEquals(50.0, myTransaction.getAmount(), DELTA);
    }

    @Test
    public void getInfoReturnsCorrectValue() {
        assertEquals("+", myTransaction.getInfo());
    }
    
    @Test
    public void setInfoUpdatesInfo() {
        myTransaction.setInfo("-");
        assertEquals("-", myTransaction.getInfo());
    }

}
