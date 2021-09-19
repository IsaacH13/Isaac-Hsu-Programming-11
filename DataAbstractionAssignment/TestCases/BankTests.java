import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class BankTests {
    //creates new object customer 'test'
    Customer test;

    @Before
    public void setUp(){
        //specifies customer 'test' details
        test = new Customer("tyrone", 1, 400, 400);
    }

    @Test
    public void testDepositToString(){
        //sets up date and creates new deposit object
        Date date = new Date();
        Deposit deposit = new Deposit(400, date, "Checking");
        //makes sure that the expected output matches the actual output
        assertEquals("Deposit of: $" + 400.0 + " Date: " + date + " into account: " + "Checking", deposit.toString());

        //same thing as above just with Saving account
        Deposit deposit2 = new Deposit(400, date, "Saving");
        deposit2.toString();
        assertEquals("Deposit of: $" + 400.0 + " Date: " + date + " into account: " + "Saving", deposit2.toString());
    }

    @Test
    public void testWithdrawToString(){
        //sets up date and creates new withdraw object
        Date date = new Date();
        Withdraw withdraw = new Withdraw(400, date, "Checking");
        //makes sure that the expected output matches the actual output
        assertEquals("Withdraw of: $" + 400.0 + " Date: " + date + " into account: " + "Checking", withdraw.toString());

        //same thing as above just with Saving account
        Withdraw withdraw2 = new Withdraw(400, date, "Saving");
        withdraw2.toString();
        assertEquals("Withdraw of: $" + 400.0 + " Date: " + date + " into account: " + "Saving", withdraw2.toString());
    }

    @Test
    public void testDeposit(){
        //sets up date
        Date date = new Date();
        //makes sure the expected deposit matches what is actually deposited
        assertEquals(400, test.deposit(400, date, "Checking"), 0.001);
    }

    @Test
    public void testWithdraw(){
        //sets up date
        Date date = new Date();
        //makes sure the expeceted deposit matches what is actually deposited
        assertEquals(400, test.deposit(400, date, "Checking"), 0.001);
    }
}
