package org.earthspecialforces.dragonpower.game.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.earthspecialforces.dragonpower.game.Constants;

import static org.earthspecialforces.dragonpower.game.Constants.GOKU_HEIGHT;
import static org.earthspecialforces.dragonpower.game.Constants.PLAYER_INITIAL_X;
import static org.earthspecialforces.dragonpower.game.Constants.PLAYER_INITIAL_Y;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class Player implements Playable {


    String imagePath = "imgs/Goku_Cloud_1.png";

    private Picture image;
    private double positionY;
    private boolean alive;
    private boolean jumped;

    public Player() {
        positionY = PLAYER_INITIAL_Y;
        image = new Picture(PLAYER_INITIAL_X, PLAYER_INITIAL_Y, imagePath);
        alive = true;
    }

    @Override
    public void jump() {
        if (alive) {
            if (positionY > 38.4) {
                positionY -= 38.4;
                image.translate(0, -38.4);
                image.draw();
                jumped = true;
            }
        }
    }

    public void draw(double distance) {
        //top border
        if (positionY < 0) {
            positionY = 0;
            distance = 0;
        }
        //bottom border
        if (positionY > Constants.MAX_SCREEN_HEIGHT - GOKU_HEIGHT) {
            positionY = Constants.MAX_SCREEN_HEIGHT - GOKU_HEIGHT;
            distance = positionY - image.getY();
            alive = false;
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

    @Override
    public boolean isAlive() {
        return alive;
    }

    public void setJumped(boolean jumped) {
        this.jumped = jumped;
    }
}
