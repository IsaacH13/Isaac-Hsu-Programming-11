package sample.TitlePage;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Game.GamePageController;

//controls TitlePage.fxml
public class TitlePageController {

    public TextField txtGetPlayerName;

    //Requires: ActionEvent event
    //Modifies: this, gamePage and window
    //Effects: gamePageParent is created from GamePage.fxml, gamePageScene is created and window
    public void changeToGamePage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Game/GamePage.fxml"));
        Parent gamePageParent = loader.load();
        GamePageController controller = loader.getController();
        controller.lblDisplayPlayerName.setText(txtGetPlayerName.getText());
        Scene gamePageScene = new Scene(gamePageParent, 800, 600);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(gamePageScene);
        window.show();
        controller.startPlay();
    }

    //Requires: ActionEvent event (kills program).
    //Modifies: this, window
    //Effects: closes the window.
    public void closeProgram(ActionEvent event) {
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.close();
    }
}
