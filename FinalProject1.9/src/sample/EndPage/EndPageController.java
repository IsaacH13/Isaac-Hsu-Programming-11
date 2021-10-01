package sample.EndPage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import sample.Game.GamePageController;

import java.io.IOException;
import java.util.ArrayList;

//Controls EndPage.fxml
public class EndPageController {
    public ListView scoreList;
    public Label showPlayerName;

    //Requires: JavaFx calls this function automatically when the scene is displayed.
    //Modifies: this, scoreList
    //Effects: The scoreList ListView is assigned the score values from the file for display.
    public void initialize() throws IOException {
        scoreList.getItems().clear();
        FinalScoreManager finalScoreManager = new FinalScoreManager();
        ArrayList<String> scores = finalScoreManager.getAllScores();
        for (String score : scores){
            scoreList.getItems().add(score);
        }
    }

    //Requires: ActionEvent event
    //Modifies: this, menuViewScene and window
    //Effects: menuViewParent is created from TitlePage.fxml, menuViewScene is created and window
    public void changeToTitlePage(ActionEvent event) throws IOException{
        Parent titlePageParent = FXMLLoader.load(getClass().getResource("/sample/TitlePage/TitlePage.fxml"));
        Scene titlePageScene = new Scene(titlePageParent);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(titlePageScene);
        window.show();
    }

    //Requires: ActionEvent event
    //Modifies: this, actionViewScene and window
    //Effects: actionViewParent is created from GamePage.fxml, actionViewScene is created and window
    public void changeToGamePage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Game/GamePage.fxml"));
        Parent gamePageParent = loader.load();
        GamePageController controller = loader.getController();
        Scene gamePageScene = new Scene(gamePageParent);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(gamePageScene);
        window.show();
        controller.startPlay();
    }

    //Requires: ActionEvent event
    //Modifies: this, Stage window
    //Effects: closes window
    public void closeProgram(ActionEvent event) {
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.close();
    }
}
