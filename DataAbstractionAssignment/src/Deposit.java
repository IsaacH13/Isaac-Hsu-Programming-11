import java.text.SimpleDateFormat;
import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    //sets the format for the date
    SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");

    //defines deposit from inputted parameters
    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //formats the correct output in string format
    public String toString(){
        return "Deposit of: $" + amount + " Date: " + date + " into account: " + account;
    }
}
