package sample.Game.objects;

import java.util.concurrent.ThreadLocalRandom;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

//Manages the creation, speed, and size of all cars moving to the left
public class leftMovingCar {
    private Pane pane;
    private ImageView imageView;
    private double speed = 3;

    private static int WIDTH = 144;
    private static int HEIGHT = 80;
    private static int MIN_X = -370;
    int yCoord;

    //Requires: Pane pane and double carSpeed
    //Modifies: this and Pane pane
    //Effects: creates a car by creating an imageView using the car file in the project. Car file is then given width/height and x and y position.
    public leftMovingCar(Pane pane, double carSpeed) {
        this.pane = pane;
        Image car = new Image(getClass().getResourceAsStream("/sample/images/red-car-left.png"));
        imageView = new ImageView(car);
        pane.getChildren().add(imageView);

        imageView.setFitHeight(HEIGHT);
        imageView.setFitWidth(WIDTH);

        int random = ThreadLocalRandom.current().nextInt(0, 2);
        if(random < 0.5){
            yCoord = 315;
        }else{
            yCoord = 95;
        }

        imageView.setX(800);
        imageView.setY(yCoord);

        speed = carSpeed;
    }

    //Requires: nothing
    //Modifies: this
    //Effects: moves this car by negative speed and checks if this reaches the left side of the window.  If it does,
    //removes the imageView from the pane. else returns false.
    public boolean moveLeft(){
        double carXPosition = imageView.getX();
        imageView.setX(carXPosition - speed);
        if(carXPosition < MIN_X){
            pane.getChildren().remove(imageView);
            return true;
        } else {
            return false;
        }
    }

    //Requires: nothing
    //Modifies: nothing
    //Effects: returns the imageView's boundaries in the parent pane
    public Bounds getBoundsInParent() {
        return imageView.getBoundsInParent();
    }
}
