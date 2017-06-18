package org.earthspecialforces.dragonpower.testers;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.earthspecialforces.dragonpower.game.Constants;

import java.util.Random;

import static org.earthspecialforces.dragonpower.game.Constants.MAX_SCREEN_HEIGHT;
import static org.earthspecialforces.dragonpower.game.Constants.MAX_SCREEN_WIDTH;
import static org.earthspecialforces.dragonpower.game.Constants.PADDING;

/**
 * Created by joaorocha on 15/06/2017.
 */
public class TestObstacle {

    //Testing Obstacle = Rectangle
    //Rectangle's Dimensions:
    public static final int WIDTH = 75;
    public static final int GAP_HEIGHT = 100;

    String imagePath = "";

    private Rectangle top;
    private Rectangle gap;
    private Rectangle bottom;
    private double positionX;

    public TestObstacle() {
        positionX = MAX_SCREEN_WIDTH - WIDTH;

        Random random = new Random();


        top = new Rectangle(positionX, PADDING, WIDTH, random.nextInt(450));
        top.setColor(Color.BLUE);
        top.fill();


        gap = new Rectangle(top.getX(), PADDING + top.getHeight(), WIDTH, GAP_HEIGHT);


        bottom = new Rectangle(top.getX(), top.getHeight() + gap.getHeight(), WIDTH, MAX_SCREEN_HEIGHT - gap.getHeight() - top.getHeight() + PADDING);
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

    public void moveLeft(double distance) {
        this.positionX = this.positionX - distance;
        draw(distance);
    }

    public Rectangle getTop() {
        return top;
    }
}
