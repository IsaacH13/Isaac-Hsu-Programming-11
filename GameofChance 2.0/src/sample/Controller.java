package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    public Label lblBalance;
    public Label lblOutcome;
    public Label lblComChoice;
    public Label lblPlayerChoice;
    public TextField textGetBet;
    public TextField textGetInput;
    public Label lblBroke;
    int random;
    int balance;

    public void play(ActionEvent actionEvent) {
        random = (int)(Math.random() * 100);
        balance = Integer.parseInt(String.valueOf(lblBalance.getText()));
        Game temp = new Game(Integer.parseInt(String.valueOf(textGetBet.getText())), textGetInput.getText());
        String comChoice = null;

        if(balance - temp.bet >= 0) {
            if (temp.input.equals("r")) {
                if ((random > 0) && (random <= 33)) {
                    lblOutcome.setText("YOU LOSE!!");
                    lblBalance.setText((String.valueOf((balance - temp.bet))));
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

            lblComChoice.setText(comChoice);

            if (temp.input.matches("r")) {
                lblPlayerChoice.setText("rock");
            } else if (temp.input.matches("p")) {
                lblPlayerChoice.setText("paper");
            } else if (temp.input.matches("s")) {
                lblPlayerChoice.setText("paper");
            }
        }else{
            lblComChoice.setText("");
            lblPlayerChoice.setText("");
            lblOutcome.setText("");
            lblBroke.setText("You're broke :(");
        }
    }
}
