import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<>();
    private ArrayList<Withdraw> withdraws = new ArrayList<>();
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private double checkDeposit;
    private double savingDeposit;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    //basic customer constructor
    Customer(){
        accountNumber = 1;
        checkBalance = 0;
        savingBalance = 0;
        savingRate = 0;
        name = "";
    }

    //defines customer from inputter parameters
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkDeposit = checkDeposit;
        this.savingDeposit = savingDeposit;
    }

    //defines deposit from inputted parameters and adds amount to account
    public double deposit(double amt, Date date, String account){
        Deposit deposit = new Deposit(amt, date, account);
        checkBalance += amt;
        return checkBalance;
    }

    //defines withdraw from inputted parameters and removes amount from account
    public double withdraw(double amt, Date date, String account){
        Withdraw withdraw = new Withdraw(amt, date, account);
        if((checkBalance - amt) < -100){
            System.out.println("error");
        }else checkBalance -= amt;
        return checkBalance;
    }

    //checks each account to make sure the balance isn't below -100
    private boolean checkOverdraft(double amt, String account){
        if(account == CHECKING){
            if(checkBalance < -100){
                return true;
            }else{
                return false;
            }
        }else{
            if(savingBalance < -100){
                return true;
            }else{
                return false;
            }
        }
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
