package org.earthspecialforces.dragonpower.game.gameObjects;
import org.earthspecialforces.dragonpower.utils.RandomGen;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import static org.earthspecialforces.dragonpower.game.Constants.*;

/**
 * Created by DragonPowerTeam on 13/06/2017.
 */

/**
 * This class represents the Obstacle subClass of the superClass GameObject
 */
public class Obstacle extends GameObject {

    /**
     * Obstacle properties
     */
    private Rectangle top;
    private Rectangle gap;
    private Rectangle bottom;
    private Color obstacleColor = new Color(229, 127, 5);


    /**
     * Obstacle constructor
     */
    public Obstacle(){
        super(MAX_SCREEN_WIDTH - OBSTACLES_WIDTH, PADDING);

        //TODO: Melhorar a geração do numero random
        //The top rectangle of the Obstacle
        top = new Rectangle(super.getX(), PADDING, OBSTACLES_WIDTH,RandomGen.randomIntBetweenMinAndMax(MAX_SCREEN_HEIGHT*2/9,MAX_SCREEN_HEIGHT*6/9));
        top.setColor(obstacleColor);
        top.fill();

        //The rectangle of the gap
        gap = new Rectangle(super.getX(), PADDING + top.getHeight(), OBSTACLES_WIDTH, GAP_HEIGHT);

        //The bottom rectangle of the obstacle
        bottom = new Rectangle(super.getX(), PADDING + top.getHeight() + gap.getHeight(), OBSTACLES_WIDTH, MAX_SCREEN_HEIGHT - gap.getHeight() - top.getHeight());
        bottom.setColor(obstacleColor);
        bottom.fill();
    }

    //TODO: Ver se faz sentido tirar o draw para outra class

    /**
     * Draws this instance of obstacle
     * @param distance
     * draws the Obstacle's different instances
     */
    public void draw(double distance) {
        top.translate(-distance, 0);
        top.fill();
        gap.translate(-distance, 0);
        bottom.translate(-distance, 0);
        bottom.fill();
    }

    /**
     *
     * @return the position X using the method getX() of the superClass GameObject
     */
    public double getX(){
        return super.getX();
    }

    /**
     *
     * @param distance
     * draws the implementation of the moveLeft method according to the given distance parameter
     */
    public void moveLeft(double distance) {
        super.moveLeft(distance);
        draw(distance);
    }

    /**
     * Returns the rectangle in the middle, which is the gap of this Obstacle
     *
     * @return
     */
    public Rectangle getGap() {
        return gap;
    }

}
