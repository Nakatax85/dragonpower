package org.earthspecialforces.dragonpower.game;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.earthspecialforces.dragonpower.game.Constants.*;

/**
 * Created by DragonPowerTeam on 13/06/2017.
 */

/**
 * This class represents the Player and implements the interface Playable
 */
public class Player {


    String gokuImagePath = "imgs/Goku_Cloud_1.png";
    String superSayanImagePath = "imgs/supersayan_head.png";
    String superSayan3ImagePath = "imgs/supersayan3_head.png";


    private Picture gokuImage;
    private double positionY;
    private boolean alive;
    private boolean jumped;

    /**
     * Initializes the player in its initial position (X and Y) and with the initial image representation
     */
    public Player() {
        positionY = PLAYER_INITIAL_Y;
        gokuImage = new Picture(PLAYER_INITIAL_X, PLAYER_INITIAL_Y, gokuImagePath);
        alive = true;
    }

    /**
     * Makes the player jump by incrementing it's Y position by a given constant number
     */

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
     * Draws the player
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
     * Returns the player's Y coordinate
     * @return
     */
    public double getPositionY() {
        return positionY;
    }

    /**
     * Updates the player's position
     * @param distance
     */
    public void updatePosition(double distance) {
        this.positionY = this.positionY + distance;
    }

    /**
     * Returns the player's current image
     * @return
     */
    public Picture getGokuImage() {
        return gokuImage;
    }

    /**
     * Changes the player's image to the image of the Super Sayan Goku
     * @return
     */
    public Picture changeToSuperSayanImage(){
        gokuImage.load(superSayanImagePath);
        gokuImage.translate(0,0);
        return gokuImage;
    }

    /**
     * Changes the player's picture to the image of the Super Sayan 3 Goku
     * @return
     */
    public Picture changeToSuperSayan3Image(){
       gokuImage.load(superSayan3ImagePath);
       gokuImage.translate(0,0);
        return gokuImage;
    }

    /**
     * Changes the player's picture to its initial image
     * @return
     */
    public Picture changeToDefaultGokuImage(){
        gokuImage.load(gokuImagePath);
        gokuImage.translate(0,0);
        return gokuImage;
    }

    /**
     * Returns TRUE if the players has jumped, and FALSE if it didn't
     * @return
     */
    public boolean hasJumped() {
        return jumped;
    }

    /**
     * Returns TRUE if the players is alive and FALSE if it died
     * @return
     */

    public boolean isAlive() {
        return alive;
    }

    //TODO: Change this setter

    /**
     * Sets the property jumped to false
     *
     */
    public void stopJumping() {
        this.jumped = false;
    }

    /**
     * Sets the property alive to false
     */
    public void hasDied() {
        alive = false;
    }
}
