package org.earthspecialforces.dragonpower.Testers.nelsontesters;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by njsilva on 13/06/2017.
 */
public class TesterObsctacle {

    private Picture building;
    private int xLoc = 0, yLoc = 0;

    public TesterObsctacle(int initialWidth, int initialHeight) {
        building = new Picture(initialWidth, initialHeight, "imgs/Building_2.png");

    }

    public Picture getBuilding() {
        return building;
    }

    public int getWidth() {
        return building.getWidth();
    }

    public int getHeight() {
        return building.getHeight();
    }

    public void setxLoc(int x) {
        this.xLoc = x;
    }

    public int getxLoc() {
        return xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int y) {
        this.yLoc = y;
    }

    public Rectangle getRectangle() {
        return (new Rectangle(xLoc, yLoc, building.getWidth(), building.getHeight()));
    }

    public Picture getBuildingImage() {
        Picture buildingImage = new Picture(building.getWidth(), building.getHeight(), "imgs/Building_2.png");
        buildingImage.draw();
        return buildingImage;
    }

}
