import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int hotdogCount;
        double hotdogPrice = 2.50;
        int drinkCount;
        double drinkPrice = 1.25;
        double totalCost = 0;
        double payment = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("How many hotdogs would you liked to buy?");
        hotdogCount = Integer.parseInt(scan.next());
        totalCost += hotdogCount*hotdogPrice;
        System.out.println("How many drinks would you like to buy?");
        drinkCount = Integer.parseInt(scan.next());
        totalCost += drinkCount*drinkPrice;
        System.out.println("You have to pay " + totalCost);
        System.out.println("How would you like to pay?");
        payment = Double.parseDouble(scan.next());
        if(payment > totalCost){
            System.out.println("Your change is " + (payment - totalCost));
        }
        else if(payment == totalCost){
            System.out.println("Exact change way to go");
        }
        else{
            System.out.println("Not enough money. You owe us " + (totalCost - payment));
        }
    }
}
