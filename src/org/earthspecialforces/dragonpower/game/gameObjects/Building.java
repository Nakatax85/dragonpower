package org.earthspecialforces.dragonpower.game.gameObjects;
import org.earthspecialforces.dragonpower.game.utils.RandomGen;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import static org.earthspecialforces.dragonpower.game.Constants.*;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class Building extends GameObject {

    private Rectangle top;
    private Rectangle gap;
    private Rectangle bottom;
    private Color brown = new Color(71, 41, 0);



    public Building(){
        super(MAX_SCREEN_WIDTH - OBSTACLES_WIDTH, PADDING);


        //TODO: Melhorar a geração do numero random
        top = new Rectangle(super.getX(), PADDING, OBSTACLES_WIDTH,RandomGen.randomIntBetweenMinAndMax(MAX_SCREEN_HEIGHT*2/9,MAX_SCREEN_HEIGHT*6/9));
        top.setColor(brown);
        top.fill();

        gap = new Rectangle(super.getX(), PADDING + top.getHeight(), OBSTACLES_WIDTH, GAP_HEIGHT);

        bottom = new Rectangle(super.getX(), PADDING + top.getHeight() + gap.getHeight(), OBSTACLES_WIDTH, MAX_SCREEN_HEIGHT - gap.getHeight() - top.getHeight());
        bottom.setColor(brown);
        bottom.fill();

    }

    //TODO: Ver se faz sentido tirar o draw para outra class
    public void draw(double distance) {
        top.translate(-distance, 0);
        top.fill();
        gap.translate(-distance, 0);
        bottom.translate(-distance, 0);
        bottom.fill();

    }

    public double getX(){
        return super.getX();
    }

    public void moveLeft(double distance) {
        super.moveLeft(distance);
        draw(distance);
    }

    public Rectangle getTop() {
        return top;
    }

    public Rectangle getGap() {
        return gap;
    }

    public Rectangle getBottom() {
        return bottom;
    }
}
