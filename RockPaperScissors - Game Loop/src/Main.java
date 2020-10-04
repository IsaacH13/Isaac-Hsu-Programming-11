import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String choice;
        int win = 0;
        int loss = 0;
        int draw = 0;
        // Sets integers 'win', 'loss', and 'draw' to 0. The numbers will go up by an increment of 1 according to each win, loss, or draw
        Scanner scan = new Scanner(System.in);

        System.out.println("Choose rock, paper, or scissors. 'r' for rock, 'p' for paper, and 's' for scissors. To exit, choose 'x'.");
        do {
            int random = (int)(Math.random() * 100);
            System.out.println("***************************************************\n\t");
            System.out.println("Wins: " + win + " Losses: " + loss + " Draws: " + draw + "\nPlayer's Choice:");
            // Prints out current number of wins, losses, and draws
            choice = scan.next();
            if (choice.equals("r")) {
                if ((random > 0) && (random <= 33)) {
                    System.out.println("Draw!\nComputer choice: Rock\tPlayer choice: Rock");
                    draw++;
                    // If the result is a draw, adds the value 1 to integer 'draw'
                } else if ((random > 33) && (random <= 66)) {
                    System.out.println("You Lose!\nComputer choice: Paper\tPlayer choice: Rock");
                    loss++;
                    // If the result is a loss, adds the value 1 to integer 'loss'
                } else if ((random > 66) && (random <= 99)) {
                    System.out.println("You Win!\nComputer choice: Scissors\tPlayer choice: Rock");
                    win++;
                    // If the result is a win, adds the value 1 to integer 'win'
                }
            } else if (choice.equals("p")) {
                if ((random > 0) && (random <= 33)) {
                    System.out.println("You Win!\nComputer choice: Rock\tPlayer choice: Paper");
                    win++;
                } else if ((random > 33) && (random <= 66)) {
                    System.out.println("Draw!\nComputer choice: Paper\tPlayer choice: Paper");
                    draw++;
                } else if ((random > 66) && (random <= 99)) {
                    System.out.println("You Lose!\nComputer choice: Scissors\tPlayer choice: Paper");
                    loss++;
                }
            } else if (choice.equals("s")) {
                if ((random > 0) && (random <= 33)) {
                    System.out.println("You Lose!\nComputer choice: Rock\tPlayer choice: Scissors");
                    loss++;
                } else if ((random > 33) && (random <= 66)) {
                    System.out.println("You Win!\nComputer choice: Paper\tPlayer choice: Scissors");
                    win++;
                } else if ((random > 66) && (random <= 99)) {
                    System.out.println("Draw!\nComputer choice: Scissors\tPlayer choice: Scissors");
                    draw++;
                }
            } else if (choice.equals("x")){
                break;
                // If the user types 'x' instead of rock, paper, or scissors, the loop will break
            }
            else {
                System.out.println("Invalid selection. Please play again.");
            }
        }while (true);
        System.out.println("Thank you for playing!");
        // After the user has typed 'x' and broken the loop, this final message is printed
    }
}
