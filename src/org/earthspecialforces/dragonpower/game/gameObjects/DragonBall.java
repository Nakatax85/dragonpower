package org.earthspecialforces.dragonpower.game.gameObjects;


import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Collection;

import static org.earthspecialforces.dragonpower.game.Constants.*;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class DragonBall extends GameObject implements Collectable {
    //TODO: Implement DragonBall class as sub-class of GameObject

    private int dragonBallNumber;
    private Picture dragonBall;
    private String dragonBallPicturePath;


    public DragonBall(int dragonBallNumber) {
        super(MAX_SCREEN_WIDTH - WIDTH, PADDING);
        this.dragonBallNumber = dragonBallNumber;
        setDragonBallPicturePath(dragonBallNumber);
        this.dragonBall = new Picture(super.getX(), super.getPositionY(), dragonBallPicturePath);
        dragonBall.grow(-19,-18.5);

    }

    public void draw(double distance) {
        dragonBall.translate(-distance, 0);
        dragonBall.draw();

    }

    public double getPositionX() {
        return super.getX();
    }

    public void moveLeft(double distance) {
        super.moveLeft(distance);
        draw(distance);
    }

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

    public int getDragonBallNumber() {
        return dragonBallNumber;
    }

    @Override
    public boolean isHit() {
        return false;
    }

    @Override
    public boolean isCollected() {
        return false;
    }
}

