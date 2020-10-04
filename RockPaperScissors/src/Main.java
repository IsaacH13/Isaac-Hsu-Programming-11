import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int random = (int)(Math.random() * 100);
        // Generates a random integer and multiplies it by 100 so that number is an integer between 1-99
        String choice;
        // Sets up the variable 'choice' as a string
        Scanner scan = new Scanner(System.in);

        System.out.println("Choose rock, paper, or scissors. 'r' for rock, 'p' for paper, and 's' for scissors.");
        choice = scan.next();
        // Prints the instructions and assigns the user's input to variable 'choice'
        if(choice.equals("r")){
        /*
         Tests what the user input is (of rock, paper, or scissors), then gives each outcome
         This is the same for the next two if statements
        */
            if((random > 0) && (random <= 33)){
                System.out.println("Draw!\nComputer choice: Rock\tPlayer choice: Rock");
            }
            else if((random > 33) && (random <= 66)){
                System.out.println("You Lose!\nComputer choice: Paper\tPlayer choice: Rock");
            }
            else if((random >66) && (random <= 99)){
                System.out.println("You Win!\nComputer choice: Scissors\tPlayer choice: Rock");
            }
            /*
             Checks to see what the value of the random number (assigned to var 'random') is. 0-33 = rock, 33-66 = paper, 66-99 = scissors and outputs the results
             This is the same for the other if statements nested in if statements
            */
        }
        else if(choice.equals("p")){
            if((random > 0) && (random <= 33)){
                System.out.println("You Win!\nComputer choice: Rock\tPlayer choice: Paper");
            }
            else if((random > 33) && (random <= 66)){
                System.out.println("Draw!\nComputer choice: Paper\tPlayer choice: Paper");
            }
            else if((random >66) && (random <= 99)){
                System.out.println("You Lose!\nComputer choice: Scissors\tPlayer choice: Paper");
            }
        }
        else if(choice.equals("s")){
            if((random > 0) && (random <= 33)){
                System.out.println("You Lose!\nComputer choice: Rock\tPlayer choice: Scissors");
            }
            else if((random > 33) && (random <= 66)){
                System.out.println("You Win!\nComputer choice: Paper\tPlayer choice: Scissors");
            }
            else if((random >66) && (random <= 99)){
                System.out.println("Draw!\nComputer choice: Scissors\tPlayer choice: Scissors");
            }
        }
        // If the user inputs anything other than 'r', 'p', or 's' it will send this message:
        else{
            System.out.println("Invalid selection. Please play again.");
        }
    }
}
