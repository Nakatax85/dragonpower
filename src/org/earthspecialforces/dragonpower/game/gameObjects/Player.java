package org.earthspecialforces.dragonpower.game.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.earthspecialforces.dragonpower.game.Constants.*;

/**
 * Created by DragonPowerTeam on 13/06/2017.
 */

/**
 * This class represents the Player and implements the interface Playable
 */
public class Player implements Playable {


    String gokuImagePath = "imgs/Goku_Cloud_1.png";
    String superSayanImagePath = "imgs/supersayan_head.png";
    String superSayan3ImagePath = "imgs/supersayan3_head.png";


    private Picture gokuImage;
    private double positionY;
    private boolean alive;
    private boolean jumped;

    /**
     *
     */
    public Player() {
        positionY = PLAYER_INITIAL_Y;
        gokuImage = new Picture(PLAYER_INITIAL_X, PLAYER_INITIAL_Y, gokuImagePath);
        alive = true;
    }

    /**
     *
     */
    @Override
    public void jump() {
        if (alive) {
            if (positionY > JUMP_HEIGHT) {
                positionY -= JUMP_HEIGHT;
                gokuImage.translate(0, -JUMP_HEIGHT);
                gokuImage.draw();
                jumped = true;
            }
        }
    }

    //TODO: Ver se faz sentido tirar o draw para outra class

    /**
     *
     * @param distance
     */
    public void draw(double distance) {
        //Player can't go higher than the top border
        if (positionY < 0) {
            positionY = 0;
            distance = 0;
        }

        gokuImage.translate(0, distance);
        gokuImage.draw();
    }

    /**
     *
     * @return
     */
    public double getPositionY() {
        return positionY;
    }

    /**
     *
     * @param distance
     */
    public void updatePosition(double distance) {
        this.positionY = this.positionY + distance;
    }

    /**
     *
     * @return
     */
    public Picture getGokuImage() {
        return gokuImage;
    }

    /**
     *
     * @return
     */
    public Picture getSuperSayanImage(){
        gokuImage.load(superSayanImagePath);
        gokuImage.translate(0,0);
        return gokuImage;
    }

    /**
     *
     * @return
     */
    public Picture getSuperSayan3Image(){
       gokuImage.load(superSayan3ImagePath);
       gokuImage.translate(0,0);
        return gokuImage;
    }

    /**
     *
     * @return
     */
    public Picture restartGokuImage(){
        gokuImage.load(gokuImagePath);
        gokuImage.translate(0,0);
        return gokuImage;
    }

    /**
     *
     * @return
     */
    public boolean hasJumped() {
        return jumped;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isAlive() {
        return alive;
    }

    //TODO: Change this setter

    /**
     *
     * @param jumped
     */
    public void setJumped(boolean jumped) {
        this.jumped = jumped;
    }

    /**
     *
     */
    public void hasDied() {
        alive = false;
    }
}
