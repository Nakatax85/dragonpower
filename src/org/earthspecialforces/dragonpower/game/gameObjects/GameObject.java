package org.earthspecialforces.dragonpower.game.gameObjects;

import com.sun.org.apache.regexp.internal.RE;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.earthspecialforces.dragonpower.game.Constants;
import org.earthspecialforces.dragonpower.game.gameEngines.CollisionDetector;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class GameObject {

    /** PROPERTIES:
     */

    private GameObject objectType;

    private Picture gameObjectImage;
    private int gameObjectImageCenterX;
    private int gameObjectImageCenterY;

    private Rectangle gameObjectImageStartPoint;
    private Rectangle gameObjectImageEndPoint;
    private Rectangle gameObjectImageRightPoint;
    private Rectangle gameObjectImageLeftPoint;
    private Rectangle gameObjectImageCenterPoint;

    private int rectangleSize = 10;

    private int positionX;
    private int positionY;

    public GameObject(int x, int y, Picture gameObjectImage){
        positionX = x;
        positionY = y;
        this.gameObjectImage = gameObjectImage;
        setCenter();
        gameObjectImageStartPoint = new Rectangle(gameObjectImage.getX(),gameObjectImage.getY(),rectangleSize,rectangleSize);
        gameObjectImageEndPoint = new Rectangle(gameObjectImage.getMaxX(),gameObjectImage.getMaxY(),rectangleSize,rectangleSize);
        gameObjectImageRightPoint = new Rectangle(gameObjectImage.getX(),gameObjectImage.getMaxY(),rectangleSize,rectangleSize);
        gameObjectImageLeftPoint = new Rectangle(gameObjectImage.getMaxX(),gameObjectImage.getY(),rectangleSize,rectangleSize);
        gameObjectImageCenterPoint = new Rectangle(gameObjectImage.getX() + getCenterX(),gameObjectImage.getY() + getCenterY(),rectangleSize,rectangleSize);
    }



    /**
     * The GameObject collision detector
     */
    private CollisionDetector collisionDetector;



    /** METHODS:
     */

    public void move(int distance,Constants.Direction direction){
        switch (direction) {
            case LEFT:
                moveLeft(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
            case Up:
                moveUp(distance);
                break;
            case Down:
                moveDown(distance);
                break;
        }
    }


    public void moveLeft(int toLeft){
        positionX = positionX - toLeft;
        gameObjectImage.translate(-toLeft,0);
        updateRectangles(toLeft, Constants.Direction.LEFT);
    }

    public void moveRight(int toRight){
        positionX = positionX + toRight;
        gameObjectImage.translate(toRight,0);
        updateRectangles(toRight,Constants.Direction.RIGHT);
    }

    public void moveDown(int toDown){
        positionY = positionY - toDown;
        gameObjectImage.translate(0,toDown);
        updateRectangles(toDown,Constants.Direction.Down);
    }

    public void moveUp(int toUp){
        positionY = positionY - toUp;
        gameObjectImage.translate(0,-toUp);
        updateRectangles(toUp,Constants.Direction.Up);
    }

    private int getCenterX(){
        return gameObjectImage.getWidth()/2;
    }

    private int getCenterY(){
        return gameObjectImage.getHeight()/2;
    }

    private void setCenter(){
        gameObjectImageCenterX = getCenterX();
        gameObjectImageCenterY = getCenterY();
    }

    public int getPositionX(){ return positionX;}

    public int getPositionY(){
        return positionY;
    }

    public void draw(){
        gameObjectImage.draw();
        drawStart();
        drawLeft();
        drawRight();
        drawEnd();
        drawCenter();
    }

    public void drawStart(){
        gameObjectImageStartPoint.fill();
    }

    public void drawEnd(){
        gameObjectImageEndPoint.fill();
    }

    public void drawLeft(){
        gameObjectImageLeftPoint.fill();
    }

    public void drawRight(){
        gameObjectImageRightPoint.fill();
    }

    public void drawCenter(){
        gameObjectImageCenterPoint.fill();
    }

    public void updateRectangles(int distance, Constants.Direction direction){
        switch (direction){
            case LEFT:
                gameObjectImageLeftPoint.translate(-distance,0);
                gameObjectImageStartPoint.translate(-distance,0);
                gameObjectImageRightPoint.translate(-distance,0);
                gameObjectImageEndPoint.translate(-distance,0);
                gameObjectImageCenterPoint.translate(-distance,0);
                break;
            case RIGHT:
                gameObjectImageLeftPoint.translate(distance,0);
                gameObjectImageStartPoint.translate(distance,0);
                gameObjectImageRightPoint.translate(distance,0);
                gameObjectImageEndPoint.translate(distance,0);
                gameObjectImageCenterPoint.translate(distance,0);
                break;
            case Up:
                gameObjectImageLeftPoint.translate(0,-distance);
                gameObjectImageStartPoint.translate(0,-distance);
                gameObjectImageRightPoint.translate(0,-distance);
                gameObjectImageEndPoint.translate(0,-distance);
                gameObjectImageCenterPoint.translate(0,-distance);
                break;
            case Down:
                gameObjectImageLeftPoint.translate(0,distance);
                gameObjectImageStartPoint.translate(0,distance);
                gameObjectImageRightPoint.translate(0,distance);
                gameObjectImageEndPoint.translate(0,distance);
                gameObjectImageCenterPoint.translate(0,distance);
                break;
        }
    }


    public Picture getGameObjectImage(){
        return gameObjectImage;
    }


}
