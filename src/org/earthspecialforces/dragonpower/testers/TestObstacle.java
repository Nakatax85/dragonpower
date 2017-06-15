package org.earthspecialforces.dragonpower.testers;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.earthspecialforces.dragonpower.game.Constants;

import static org.earthspecialforces.dragonpower.game.Constants.PADDING;

/**
 * Created by joaorocha on 15/06/2017.
 */
public class TestObstacle {

    //Testing Obstacle = Rectangle
    //Rectangle's Dimensions:
    public static final int WIDTH = 75;
    public static final int TOP_HEIGHT = 150;
    public static final int GAP_HEIGHT = 100;
    public static final int BOTTOM_HEIGHT = 198;

    String imagePath = "";

    private Rectangle top;
    private Rectangle gap;
    private Rectangle bottom;
    private double positionX;

    public TestObstacle() {
        top = new Rectangle(Constants.MAX_SCREEN_WIDTH - WIDTH, PADDING, WIDTH, TOP_HEIGHT);
        top.setColor(Color.BLUE);
        top.fill();
        gap = new Rectangle(top.getX(), PADDING + top.getHeight(), WIDTH, GAP_HEIGHT);
        bottom = new Rectangle(top.getX(), PADDING + TOP_HEIGHT + GAP_HEIGHT, WIDTH, BOTTOM_HEIGHT);
        bottom.setColor(Color.BLUE);
        bottom.fill();
    }

    public void draw(double distance) {
        top.translate(-distance, 0);
        top.fill();
        gap.translate(-distance, 0);
        bottom.translate(-distance, 0);
        bottom.fill();
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double distance) {
        this.positionX = this.positionX - distance;
    }

    public Rectangle getTop() {
        return top;
    }
}
