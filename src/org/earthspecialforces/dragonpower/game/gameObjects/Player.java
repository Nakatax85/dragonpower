package org.earthspecialforces.dragonpower.game.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class Player {

    private static final int INITIAL_POSITION_X = 110;
    private static final int INITIAL_POSITICN_Y = 110;
    String imagePath = "imgs/Goku_Cloud_1.png";


    Picture image;
    private int positionX;
    private int positionY;
    private boolean alive;

    public Player(){
        positionX = INITIAL_POSITION_X;
        positionY = INITIAL_POSITICN_Y;
        image = new Picture(positionX,positionY,imagePath);
    }

    public void jump(){
        if (positionY == 0){
            this.draw(0);
            return;
        }
        positionY -= 15;
        this.draw(-15);
    }

    public void draw(int gravity) {
        int newgravity = fall(gravity);
        image.translate(0, newgravity);
        image.draw();
    }

    public int fall(int gravity){
        if (positionY == 385){
            return 0;
        }
        positionY += gravity;
        return gravity;
    }

    public int getPositionY() {
        return positionY;
    }
}
