package org.earthspecialforces.dragonpower.game.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.earthspecialforces.dragonpower.game.gameEngines.CollisionDetector;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class GameObject {

    /** PROPERTIES:
     */

    private GameObject objectType;

    private Picture gameObjectImage;

    private int positionX;

    private int positionY;


    public GameObject(int x, int y, Picture gameObjectImage){
        positionX = x;
        positionY = y;
        this.gameObjectImage = gameObjectImage;
    }



    /**
     * The GameObject collision detector
     */
    private CollisionDetector collisionDetector;



    /** METHODS:
     */

    public void moveLeft(int toLeft){

        positionX = positionX - toLeft;
    }


    public void getPosition(){}

    public void draw(){
        gameObjectImage.draw();
    }

    public void


}
