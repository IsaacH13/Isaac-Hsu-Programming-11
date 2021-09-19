import java.text.SimpleDateFormat;
import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    //sets the format for the date
    SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");

    //defines withdraw from inputted parameters
    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //formats the correct output in string format
    public String toString(){
        return "Withdraw of: $" + amount + " Date: " + date + " into account: " + account;
    }
}
