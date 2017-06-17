package org.earthspecialforces.dragonpower.game.gameObjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Random;

import static org.earthspecialforces.dragonpower.game.Constants.*;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class Building extends GameObject {

    //private Rectangle top;
    //private Rectangle bottom;

    private Picture topBuilding;
    private String topBuildingPath = "imgs/Building_2_top.png";
    private Rectangle gap;
    private Picture bottomBuilding;
    private String bottomBuildingPath = "imgs/Building_2_bottom.png";



    public Building(){
        super(MAX_SCREEN_WIDTH - WIDTH, PADDING);

        /* Rectangles logic
        //TODO: Melhorar a geração do numero random
        Random random = new Random();

        top = new Rectangle(super.getPositionX(), PADDING, WIDTH, random.nextInt(MAX_SCREEN_HEIGHT - (int) GAP_HEIGHT));
        top.setColor(Color.BLUE);
        top.fill();

        gap = new Rectangle(super.getPositionX(), PADDING + top.getHeight(), WIDTH, GAP_HEIGHT);

        //TODO: Dar um PADDING ao bottom para criar a imagem do chão
        bottom = new Rectangle(super.getPositionX(), PADDING + top.getHeight() + gap.getHeight(), WIDTH, MAX_SCREEN_HEIGHT - gap.getHeight() - top.getHeight() + PADDING);
        bottom.setColor(Color.BLUE);
        bottom.fill();
        */

        topBuilding = new Picture(super.getPositionX(), PADDING, topBuildingPath);

        gap = new Rectangle(super.getPositionX(), PADDING + topBuilding.getHeight(), WIDTH, GAP_HEIGHT);

        bottomBuilding = new Picture ()
    }

    //TODO: Ver se faz sentido tirar o draw para outra class
    public void draw(double distance) {
        top.translate(-distance, 0);
        top.fill();
        gap.translate(-distance, 0);
        bottom.translate(-distance, 0);
        bottom.fill();
    }

    public double getPositionX(){
        return super.getPositionX();
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
