package org.earthspecialforces.dragonpower.game.gameObjects;


import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Collection;

import static org.earthspecialforces.dragonpower.game.Constants.*;

/**
 * Created by DragonPowerTeam on 13/06/2017.
 */

/**
 * This class represents the DragonBall subClass of the superClass GameObject and implements the interface Collectable
 */
public class DragonBall extends GameObject implements Collectable {

    /**
     * DragonBall properties
     */
    private int dragonBallNumber;
    private Picture dragonBall;
    private String dragonBallPicturePath;

    /**
     * Receive an integer and implements
     * @param dragonBallNumber
     */
    public DragonBall(int dragonBallNumber) {
        super(MAX_SCREEN_WIDTH - OBSTACLES_WIDTH, PADDING);
        this.dragonBallNumber = dragonBallNumber;
        setDragonBallPicturePath(dragonBallNumber);
        this.dragonBall = new Picture(super.getX(), super.getPositionY(), dragonBallPicturePath);
        dragonBall.grow(-19,-18.5);

    }

    /**
     *
     * @param distance
     */
    public void draw(double distance) {
        dragonBall.translate(-distance, 0);
        dragonBall.draw();

    }

    /**
     *
     * @return
     */
    public double getPositionX() {
        return super.getX();
    }

    /**
     * Receives the parameter distance and implem
     * @param distance
     *
     */
    public void moveLeft(double distance) {
        super.moveLeft(distance);
        draw(distance);
    }

    /**
     * Receives the number given by the Game and establishes the path of the picture
     * of the corresponding DragonBall
     * (there are only 7 Dragon Balls)
     * @param number
     */
    public void setDragonBallPicturePath(int number) {
        number = this.dragonBallNumber;
        switch (number) {
            case 1:
                this.dragonBallPicturePath = "imgs/Ball_1.png";
                break;
            case 2:
                this.dragonBallPicturePath = "imgs/Ball_2.png";
                break;
            case 3:
                this.dragonBallPicturePath = "imgs/Ball_3.png";
                break;
            case 4:
                this.dragonBallPicturePath = "imgs/Ball_4.png";
                break;
            case 5:
                this.dragonBallPicturePath = "imgs/Ball_5.png";
                break;
            case 6:
                this.dragonBallPicturePath = "imgs/Ball_6.png";
                break;
            case 7:
                this.dragonBallPicturePath = "imgs/Ball_7.png";
                break;
        }
    }

    /**
     *
     * @return
     */
    public int getDragonBallNumber() {
        return dragonBallNumber;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isHit() {
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isCollected() {
        return false;
    }
}

