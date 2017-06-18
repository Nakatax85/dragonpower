package org.earthspecialforces.dragonpower.game.gameObjects;
import org.earthspecialforces.dragonpower.game.utils.RandomGen;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import static org.earthspecialforces.dragonpower.game.Constants.*;

/**
 * Created by DragonPowerTeam on 13/06/2017.
 */

/**
 * This class represents the Building subClass of the superClass GameObject
 */
public class Building extends GameObject {

    /**
     * Building properties
     */
    private Rectangle top;
    private Rectangle gap;
    private Rectangle bottom;
    private Color buildingColor = new Color(229, 127, 5);


    /**
     * Building constructor
     */
    public Building(){
        super(MAX_SCREEN_WIDTH - OBSTACLES_WIDTH, PADDING);


        //TODO: Melhorar a geração do numero random
        top = new Rectangle(super.getX(), PADDING, OBSTACLES_WIDTH,RandomGen.randomIntBetweenMinAndMax(MAX_SCREEN_HEIGHT*2/9,MAX_SCREEN_HEIGHT*6/9));
        top.setColor(buildingColor);
        top.fill();

        gap = new Rectangle(super.getX(), PADDING + top.getHeight(), OBSTACLES_WIDTH, GAP_HEIGHT);

        bottom = new Rectangle(super.getX(), PADDING + top.getHeight() + gap.getHeight(), OBSTACLES_WIDTH, MAX_SCREEN_HEIGHT - gap.getHeight() - top.getHeight());
        bottom.setColor(buildingColor);
        bottom.fill();

    }

    //TODO: Ver se faz sentido tirar o draw para outra class

    /**
     *
     * @param distance
     * draws the Building's different instances
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
     *
     * @return
     */
    public Rectangle getTop() {
        return top;
    }

    /**
     *
     * @return
     */
    public Rectangle getGap() {
        return gap;
    }

    /**
     *
     * @return
     */
    public Rectangle getBottom() {
        return bottom;
    }
}
