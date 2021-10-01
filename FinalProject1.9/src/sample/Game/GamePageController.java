package sample.Game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.EndPage.EndPageController;
import sample.Game.objects.leftMovingCar;
import sample.Game.objects.Player;
import sample.EndPage.FinalScoreManager;
import sample.Game.objects.rightMovingCar;

//controls the GamePage.fxml
public class GamePageController {
    public AnchorPane anchorPane;
    public Label lblDisplayPlayerName;
    private FinalScoreManager finalScoreManager;
    public Label level;

    private ArrayList<leftMovingCar> leftMovingCars;
    private ArrayList<rightMovingCar> rightMovingCars;
    private double carSpeed = 2;
    private long timeOfNextCarCreation = 0;
    private long carDelay = 1200000000;

    public ImageView playerImageView;
    private Player player;
    private AnimationTimer animationTimer;

    //Requires: KeyEvent keyEvent
    //Modifies: nothing
    //Effects: interprets directional keyboard input.
    public void handleKeyPress(KeyEvent keyEvent) {    //All other keys make the player motionless.

        switch (keyEvent.getCode()){
            case UP:
                player.setDirectionUp();
                break;

            case DOWN:
                player.setDirectionDown();
                break;

            case LEFT:
                player.setDirectionLeft();
                break;

            case RIGHT:
                player.setDirectionRight();
                break;
        }
    }

    //Requires: KeyEvent keyEvent
    //Modifies: this, keyEvent
    //Effects: stops player movement on release
    public void handleKeyRelease(KeyEvent keyEvent) {
        player.setDirectionMotionless();
    }

    //Requires: Call this when the action view is displayed.
    //Modifies: the scene
    //Effects: Initializes the key handlers, the player and empty list of cars,
    //and starts animation timer.
    public void startPlay(){
        Scene scene = level.getScene();
        scene.setOnKeyPressed(this::handleKeyPress);
        scene.setOnKeyReleased(this::handleKeyRelease);

        finalScoreManager = new FinalScoreManager();

        player = new Player(playerImageView);
        leftMovingCars = new ArrayList<>();
        rightMovingCars = new ArrayList<>();

        animationTimer = new AnimationTimer() {
            public void handle(long now){
                try {
                    animationTick(now);
                } catch(Exception x) {
                }
            }
        };
        animationTimer.start();
    }

    //Requires: long now - the time provided when the animation engine calls this
    //Modifies: the scene components being animated
    //Effects: moves the player if needed, moves/removes/creates left and right cars as needed,
    //and updates the level
    private void animationTick(long now) throws IOException{
        player.moveX();
        player.moveY();

        if(playerImageView.getY() == -530){
            incrementScore();
            playerImageView.setY(0);
        }

        ArrayList<leftMovingCar> remainingCars = new ArrayList<>();
        for(leftMovingCar leftMovingCar : leftMovingCars){
            leftMovingCar.moveLeft();
                if(player.isCollidingWithCar(leftMovingCar)){
                    endGame();
                    return;
                } else {
                    remainingCars.add(leftMovingCar);
                }
        }
        leftMovingCars = remainingCars;

        ArrayList<rightMovingCar> remainingRightCars = new ArrayList<>();
        for(rightMovingCar rightMovingCar : rightMovingCars){
            rightMovingCar.moveRight();
            if(player.isCollidingWithRightCar(rightMovingCar)){
                endGame();
                return;
            } else {
                remainingRightCars.add(rightMovingCar);
            }
        }
        rightMovingCars = remainingRightCars;

        if (now < timeOfNextCarCreation){
            return;
        }

        //long randomDelay = carDelay;
        timeOfNextCarCreation = now + carDelay;

        leftMovingCar leftMovingCar = new leftMovingCar(anchorPane, carSpeed);
        rightMovingCar rightMovingCar = new rightMovingCar(anchorPane, carSpeed);
        leftMovingCars.add(leftMovingCar);
        rightMovingCars.add(rightMovingCar);
    }

    //Requires: nothing
    //Modifies: this, level
    //Effects: increases the level
    private void incrementScore(){
        int level = Integer.parseInt(this.level.getText());
        level++;
        this.level.setText(Integer.toString(level));
    }

    //Requires: nothing
    //Modifies: this, animationTimer and finalScoreManager
    //Effects: stops the animation timer, records the final score, and calls changeSceneToGameOverView().
    @FXML
    private void endGame() throws IOException{
        animationTimer.stop();
        int numberCarsDodged = Integer.parseInt(level.getText());
        finalScoreManager.addScore(numberCarsDodged);
        changeToEndPage();
    }

    //Requires: nothing
    //Modifies: this, gameOverViewScene and window
    //Effects: Prepares the GameOverView and transfers the view to that scene.
    private void changeToEndPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/EndPage/EndPage.fxml"));
        Parent endPageParent = (Parent)loader.load();
        EndPageController controller = (EndPageController)loader.getController();
        controller.showPlayerName.setText(lblDisplayPlayerName.getText() + "!");
        Scene endPageScene = new Scene(endPageParent, 800, 600);
        Stage window = (Stage) level.getScene().getWindow();
        window.setScene(endPageScene);
        window.show();
    }
}