package org.earthspecialforces.dragonpower.game.gameObjects;

import static org.earthspecialforces.dragonpower.game.Constants.MAX_SCREEN_WIDTH;
import static org.earthspecialforces.dragonpower.game.Constants.WIDTH;

/**
 * Created by joaorocha on 13/06/2017.
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
