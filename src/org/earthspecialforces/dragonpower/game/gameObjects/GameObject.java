package org.earthspecialforces.dragonpower.game.gameObjects;

/**
 * Created by DragonPowerTeam on 13/06/2017.
 */

/**
 * This class represents the GameObject that will act as superClass
 */
public class GameObject {

    private double positionX;
    private double positionY;

    public GameObject(double positionX, double positionY){
        this.positionX = positionX;
        this.positionY = positionY;

    }

    public void moveLeft(double distance){
        this.positionX = this.positionX - distance;
    }

    public double getX() {
        return positionX;
    }



    public double getPositionY() {
        return positionY;
    }
}
