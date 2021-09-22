package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    public Label lblBalance;
    public Button btnPlay;
    public Label lblOutcome;
    public Label lblComChoice;
    public Label lblPlayerChoice;
    public TextField textGetBet;
    public TextField textGetInput;

    public void play(ActionEvent actionEvent) {
        do {
            int random = (int)(Math.random() * 100);
            int balance = Integer.parseInt(String.valueOf(lblBalance.getText()));
            Game temp = new Game(Integer.parseInt((String.valueOf(textGetBet.getText()))), textGetInput.getText());

            if (temp.input.equals("r")) {
                if ((random > 0) && (random <= 33)) {
                    lblOutcome.setText("YOU LOSE!!");
                    lblBalance.setText(String.valueOf(balance - temp.bet));
                    lblComChoice.setText("rock");
                    lblPlayerChoice.setText("rock");
                } else if ((random > 33) && (random <= 66)) {
                    lblOutcome.setText("YOU LOSE!!");
                    lblBalance.setText(String.valueOf(balance - temp.bet));
                    lblComChoice.setText("paper");
                    lblPlayerChoice.setText("rock");
                } else if ((random > 66) && (random <= 99)) {
                    lblOutcome.setText("YOU WIN!!");
                    lblBalance.setText(String.valueOf(balance + temp.bet));
                    lblComChoice.setText("scissors");
                    lblPlayerChoice.setText("rock");
                }
            } else if (temp.input.equals("p")) {
                if ((random > 0) && (random <= 33)) {
                    lblOutcome.setText("YOU WIN!!");
                    lblBalance.setText(String.valueOf(balance + temp.bet));
                    lblComChoice.setText("rock");
                    lblPlayerChoice.setText("paper");
                } else if ((random > 33) && (random <= 66)) {
                    lblOutcome.setText("YOU LOSE!!");
                    lblBalance.setText(String.valueOf(balance - temp.bet));
                    lblComChoice.setText("paper");
                    lblPlayerChoice.setText("paper");
                } else if ((random > 66) && (random <= 99)) {
                    lblOutcome.setText("YOU LOSE!!");
                    lblBalance.setText(String.valueOf(balance - temp.bet));
                    lblComChoice.setText("scissors");
                    lblPlayerChoice.setText("paper");
                }
            } else if (temp.input.equals("s")) {
                if ((random > 0) && (random <= 33)) {
                    lblOutcome.setText("YOU LOSE!!");
                    lblBalance.setText(String.valueOf(balance - temp.bet));
                    lblComChoice.setText("rock");
                    lblPlayerChoice.setText("scissors");
                } else if ((random > 33) && (random <= 66)) {
                    lblOutcome.setText("YOU WIN!!");
                    lblBalance.setText(String.valueOf(balance + temp.bet));
                    lblComChoice.setText("paper");
                    lblPlayerChoice.setText("scissors");
                } else if ((random > 66) && (random <= 99)) {
                    lblOutcome.setText("YOU LOSE!!");
                    lblBalance.setText(String.valueOf(balance - temp.bet));
                    lblComChoice.setText("scissors");
                    lblPlayerChoice.setText("scissors");
                }
            } else if (temp.input.equals("x")){
                break;
            }
            else {
                lblOutcome.setText("Invalid selection. Please try again.");
            }
        }while (true);
    }
}
