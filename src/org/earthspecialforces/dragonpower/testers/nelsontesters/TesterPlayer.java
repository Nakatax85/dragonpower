package org.earthspecialforces.dragonpower.Testers.nelsontesters;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by njsilva on 13/06/2017.
 */
public class TesterPlayer {

    private Picture goku;
    private int xLoc = 0, yLoc = 0;


    public TesterPlayer(int initialWidth, int initialHeight) {
        goku = new Picture(initialWidth, initialHeight, "imgs/Goku_Cloud_1.png");

    }

    public Picture getGoku() {
        return goku;
    }

    public int getWidth() {
        try {
            return goku.getWidth();
        } catch (Exception e) {
            return -1;
        }
    }

    public int getHeight() {
        try {
            return goku.getHeight();
        } catch (Exception e) {
            return -1;
        }
    }

    public void setxLoc(int x) {
        xLoc = 0;
    }

    public int getxLoc(){
        return xLoc;
    }

    public void setyLoc(int y) {
        this.yLoc = y;
    }

    public int getyLoc() {
        return yLoc;
    }

    public Rectangle getRectangle(){
        return (new Rectangle(xLoc,yLoc,goku.getWidth(),goku.getHeight()));
    }

    public Picture getGokuImage(){
        Picture gokuImage = new Picture(goku.getWidth(),goku.getHeight(),"imgs/Goku_Cloud_1.png");
        gokuImage.draw();
        return gokuImage;
    }


}
