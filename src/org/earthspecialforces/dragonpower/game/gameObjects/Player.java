package org.earthspecialforces.dragonpower.game.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.earthspecialforces.dragonpower.game.Constants;

import static org.earthspecialforces.dragonpower.game.Constants.*;

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
            if (positionY > JUMP_HEIGHT) {
                positionY -= JUMP_HEIGHT;
                image.translate(0, -JUMP_HEIGHT);
                image.draw();
                jumped = true;
            }
        }
    }

    //TODO: Ver se faz sentido tirar o draw para outra class
    public void draw(double distance) {
        //top border
        if (positionY < 0) {
            positionY = 0;
            distance = 0;
        }
        //bottom border
        if (positionY > MAX_SCREEN_HEIGHT - GOKU_HEIGHT) {
            positionY = MAX_SCREEN_HEIGHT - GOKU_HEIGHT;
            distance = positionY - image.getY();
            alive = false;
        }
        image.translate(0, distance);
        image.draw();
    }

    public double getPositionY() {
        return positionY;
    }

    public void updatePosition(double distance) {
        this.positionY = this.positionY + distance;
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

    //TODO: Change this setter
    public void setJumped(boolean jumped) {
        this.jumped = jumped;
    }
}
