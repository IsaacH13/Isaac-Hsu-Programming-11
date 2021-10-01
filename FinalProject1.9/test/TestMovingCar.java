import org.junit.Test;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.Game.objects.leftMovingCar;
import sample.Game.objects.rightMovingCar;

import static org.junit.Assert.assertTrue;


public class TestMovingCar {

    //Requires: nothing
    //Modifies: this, reachedLeftEdge
    //Effects: tests if the car created has reached and stops at the left side of the pane
    @Test
    public void testCarReachesLeftOfScreen() {
        double speed = 10;
        long MIN_X = 10;
        AnchorPane pane = new AnchorPane();
        leftMovingCar leftMovingCar = new leftMovingCar(pane, speed);
        ImageView carImageView = (ImageView)pane.getChildren().get(0); // the ImageVew of the created car.
        boolean reachedLeftEdge = false;
        while (!reachedLeftEdge) {
            reachedLeftEdge = leftMovingCar.moveLeft();
            System.out.println("x=" + carImageView.getX());
        }
        // Check that the while loop stops when the car reaches the left edge of the pane.
        assertTrue(carImageView.getX() <= MIN_X);
    }

    @Test
    public void testCarReachesRightOfScreen() {
        double speed = 10;
        long MAX_X = 10;
        AnchorPane pane = new AnchorPane();
        rightMovingCar rightMovingCar = new rightMovingCar(pane, speed);
        ImageView carImageView = (ImageView)pane.getChildren().get(0); // the ImageVew of the created car.
        boolean reachedLeftEdge = false;
        while (!reachedLeftEdge) {
            reachedLeftEdge = rightMovingCar.moveRight();
            System.out.println("x=" + carImageView.getX());
        }
        // Check that the while loop stops when the car reaches the left edge of the pane.
        assertTrue(carImageView.getX() >= MAX_X);
    }
}
