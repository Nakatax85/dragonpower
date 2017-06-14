package org.earthspecialforces.dragonpower.game.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class Player {

    private static final int INITIAL_POSITION_X = 110;
    private static final int INITIAL_POSITION_Y = 110;
    String imagePath = "imgs/Goku_Cloud_1.png";

    Picture image;
    private double positionY;
    private boolean alive;
    private boolean jumped;

    public Player() {
        positionY = INITIAL_POSITION_Y;
        image = new Picture(INITIAL_POSITION_X, positionY, imagePath);

    }

    public void jump() {
        if (positionY > 38.4) {
            positionY -= 38.4;
            image.translate(0, -38.4);
            image.draw();
            jumped = true;
        }
    }

    public void draw(double distance) {
        //top border
        if (positionY < 0) {
            positionY = 0;
            distance = 0;
        }
        //bottom border
        if (positionY > 400) {
            positionY = 400;
            distance = positionY - image.getY();
        }

        image.translate(0, distance);
        image.draw();
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public Picture getImage() {
        return image;
    }

    public boolean hasJumped() {
        return jumped;
    }

    public void setJumped(boolean jumped) {
        this.jumped = jumped;
    }
}
