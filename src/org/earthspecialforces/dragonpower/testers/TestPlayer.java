package org.earthspecialforces.dragonpower.testers;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import static org.earthspecialforces.dragonpower.game.Constants.PADDING;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class TestPlayer {

    private int positionX;
    private int positionY;
    Picture image;
    String imagePath = "imgs/Goku_Cloud_1.png";


    public TestPlayer(int initialX, int initialY) {
        positionX = initialX;
        positionY = initialY;
        image = new Picture(positionX,positionY,imagePath);
    }

    public int fall(int gravity){
        if (positionY == 380){
            return 0;
        }
        positionY += gravity;
        return gravity;
    }

    public void draw(int gravity){
        int newgravity = fall(gravity);
        image.translate(0,newgravity);
        image.draw();
        System.out.println("Player: X = " + positionX + " | Y = " + positionY);
        System.out.println("Image: X = " + image.getX() + " | Y = " + image.getY());
    }


    public int getPositionY() {
        return positionY;
    }
}
