package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    //sets up all of the required fields
    public Label lblBalance;
    public Label lblOutcome;
    public Label lblComChoice;
    public Label lblPlayerChoice;
    public TextField textGetBet;
    public TextField textGetInput;
    public Label lblBroke;
    int random;
    int balance;

    //method that is activated when "Play!" button is clicked
    public void play(ActionEvent actionEvent) {
        //gets random number
        random = (int)(Math.random() * 100);
        //gets the current player's balance and parses the value of the string to an integer and stores it as int balance
        balance = Integer.parseInt(String.valueOf(lblBalance.getText()));
        //creates new game object with bet parameter obtained in the same way that balance was, input is a string so it's simpler
        Game temp = new Game(Integer.parseInt(String.valueOf(textGetBet.getText())), textGetInput.getText());
        String comChoice = null;

        //a loop to go through the three possible player inputs
        if(balance - temp.bet >= 0) {
            if (temp.input.equals("r")) {
                if ((random > 0) && (random <= 33)) {
                    //a loop inside of previous loop to go through computer's 3 possible outcomes
                    //declares whether the player won or not
                    lblOutcome.setText("YOU LOSE!!");
                    //adds or subtracts the bet from the current balance
                    lblBalance.setText((String.valueOf((balance - temp.bet))));
                    //stores the computer's choice to String "comChoice"
                    comChoice = "rock";
                } else if ((random > 33) && (random <= 66)) {
                    lblOutcome.setText("YOU LOSE!!");
                    lblBalance.setText((String.valueOf((balance - temp.bet))));
                    comChoice = "paper";
                } else if ((random > 66) && (random <= 99)) {
                    lblOutcome.setText("YOU WIN!!");
                    lblBalance.setText(String.valueOf(balance + temp.bet));
                    comChoice = "scissors";
                }
            } else if (temp.input.equals("p")) {
                if ((random > 0) && (random <= 33)) {
                    lblOutcome.setText("YOU WIN!!");
                    lblBalance.setText(String.valueOf(balance + temp.bet));
                    comChoice = "rock";
                } else if ((random > 33) && (random <= 66)) {
                    lblOutcome.setText("YOU LOSE!!");
                    lblBalance.setText((String.valueOf((balance - temp.bet))));
                    comChoice = "paper";
                } else if ((random > 66) && (random <= 99)) {
                    lblOutcome.setText("YOU LOSE!!");
                    lblBalance.setText((String.valueOf((balance - temp.bet))));
                    comChoice = "scissors";
                }
            } else if (temp.input.equals("s")) {
                if ((random > 0) && (random <= 33)) {
                    lblOutcome.setText("YOU LOSE!!");
                    lblBalance.setText((String.valueOf((balance - temp.bet))));
                    comChoice = "rock";
                } else if ((random > 33) && (random <= 66)) {
                    lblOutcome.setText("YOU WIN!!");
                    lblBalance.setText(String.valueOf(balance + temp.bet));
                    comChoice = "paper";
                } else if ((random > 66) && (random <= 99)) {
                    lblOutcome.setText("YOU LOSE!!");
                    lblBalance.setText((String.valueOf((balance - temp.bet))));
                    comChoice = "scissors";
                }
            } else {
                lblOutcome.setText("error");
            }

            //sets the label in the GUI to the computer's choice
            lblComChoice.setText(comChoice);

            //loop to change the player's choice from single inputted letter to full word by changing the player's choice text in the GUI
            if (temp.input.matches("r")) {
                lblPlayerChoice.setText("rock");
            } else if (temp.input.matches("p")) {
                lblPlayerChoice.setText("paper");
            } else if (temp.input.matches("s")) {
                lblPlayerChoice.setText("paper");
            }
        }else{
            //commands to be executed when the balance reaches $0
            //clears text fields
            lblComChoice.setText("");
            lblPlayerChoice.setText("");
            lblOutcome.setText("");
            //gives user the message that they're out of money
            lblBroke.setText("You're broke :(");
        }
    }
}
