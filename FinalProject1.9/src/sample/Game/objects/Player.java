package sample.Game.objects;

import javafx.scene.image.ImageView;

//controls which direction the player moves, returns boolean if player collides with car
public class Player {
    private ImageView playerImageView;
    private double incrementY = 0;
    private double incrementX = 0;

    private static final double MIN_Y = -530;
    private static final double MAX_Y = 0;
    private static final double INCREMENT_Y = 3;
    private static final double MIN_X = -370;
    private static final double MAX_X = 365;
    private static final double INCREMENT_X = 3;

    //Requires: ImageView playerImageView
    //Modifies: this, playerImageView
    //Effects: saves the received playerImageView
    public Player(ImageView playerImageView) {
        this.playerImageView = playerImageView;
    }

    //Requires: the nothing
    //Modifies: this, increment
    //Effects: changes the increment to up
    public void setDirectionUp() {
        incrementY = -INCREMENT_Y;
    }

    //Requires: nothing
    //Modifies: this, increment
    //Effects: changes the increment to down
    public void setDirectionDown() {incrementY = INCREMENT_Y;}

    //Requires: nothing
    //Modifies: this, increment
    //Effects: sets increments to 0 so the player does not move
    public void setDirectionMotionless() {
        incrementY = 0;
        incrementX = 0;
    }

    //Requires: nothing
    //Modifies: this, increment
    //Effects: changes the increment to left
    public void setDirectionLeft(){
        incrementX = -INCREMENT_X;
    }

    //Requires: nothing
    //Modifies: this, increment
    //Effects: changes the increment to right
    public void setDirectionRight(){
        incrementX = INCREMENT_X;
    }

    //Requires: nothing
    //Modifies: this, playerYPosition and PlayerImageView
    //Effects: moves the player along the x axis. makes sure that the player images does not go off the screen.
    public void moveX(){
        if (incrementX == 0){
            return;
        }
        double playerXPosition = playerImageView.getX();
        playerXPosition += incrementX;

        if (playerXPosition < MIN_X){
            playerXPosition = MIN_X;
        } else if (playerXPosition > MAX_X){
            playerXPosition = MAX_X;
        }
        playerImageView.setX(playerXPosition);
    }

    //Requires: nothing
    //Modifies: this, playerYPosition and PlayerImageView
    //Effects: moves the player along the y axis. makes sure that the player images does not go off the screen.
    public void moveY(){
        if (incrementY == 0){
            return;
        }
        double playerYPosition = playerImageView.getY();
        playerYPosition += incrementY;
        if (playerYPosition < MIN_Y) {
            playerYPosition = MIN_Y;
        } else if (playerYPosition > MAX_Y){
            playerYPosition = MAX_Y;
        }
        playerImageView.setY(playerYPosition);
    }

    //Requires: leftMovingCar leftMovingCar
    //Modifies: nothing
    //Effects: if playerImageView's hitbox comes in contact with a car's, then returns true, else returns false
    public boolean isCollidingWithCar(leftMovingCar leftMovingCar) {
        return playerImageView.getBoundsInParent().intersects(leftMovingCar.getBoundsInParent());
    }

    //Requires: leftMovingCar leftMovingCar
    //Modifies: nothing
    //Effects: if playerImageView's hitbox comes in contact with a car's, then returns true, else returns false
    public boolean isCollidingWithRightCar(rightMovingCar rightMovingCar){
        return playerImageView.getBoundsInParent().intersects((rightMovingCar.getBoundsInParent()));
    }
}