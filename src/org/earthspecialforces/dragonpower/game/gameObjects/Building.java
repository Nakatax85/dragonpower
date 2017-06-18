package org.earthspecialforces.dragonpower.game.gameObjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.Random;

import static org.earthspecialforces.dragonpower.game.Constants.*;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class Building extends GameObject {

    private Rectangle top;
    private Rectangle gap;
    private Rectangle bottom;

    /*
    private Picture topBuilding;
    private String topBuildingPath = "imgs/Building_2_top.png";
    private Rectangle gap;
    private Picture bottomBuilding;
    private String bottomBuildingPath = "imgs/Building_2_bottom.png";
    */


    public Building(){
        super(MAX_SCREEN_WIDTH - OBSTACLES_WIDTH, PADDING);


        //TODO: Melhorar a geração do numero random
        Random random = new Random();
        top = new Rectangle(super.getX(), PADDING, OBSTACLES_WIDTH, random.nextInt(MAX_SCREEN_HEIGHT - (int) GAP_HEIGHT));
        top.setColor(Color.BLUE);
        top.fill();

        gap = new Rectangle(super.getX(), PADDING + top.getHeight(), OBSTACLES_WIDTH, GAP_HEIGHT);

        //TODO: Dar um PADDING ao bottom para criar a imagem do chão
        bottom = new Rectangle(super.getX(), PADDING + top.getHeight() + gap.getHeight(), OBSTACLES_WIDTH, MAX_SCREEN_HEIGHT - gap.getHeight() - top.getHeight());
        bottom.setColor(Color.BLUE);
        bottom.fill();


        /*
        Random random = new Random();
        topBuilding = new Picture(OBSTACLES_WIDTH,random.nextInt(MAX_SCREEN_HEIGHT - (int) GAP_HEIGHT));
        topBuilding.translate(super.getX(),PADDING);
        topBuilding.load(topBuildingPath);
        topBuilding.grow(-57.5,(621-topBuilding.getHeight())/2);

        gap = new Rectangle(super.getX(), PADDING + topBuilding.getHeight(), OBSTACLES_WIDTH, GAP_HEIGHT);

        bottomBuilding = new Picture (OBSTACLES_WIDTH,MAX_SCREEN_HEIGHT - gap.getHeight() - topBuilding.getHeight() + PADDING);
        bottomBuilding.translate(super.getX(),PADDING + topBuilding.getHeight() + gap.getHeight());
        bottomBuilding.load(bottomBuildingPath);
        bottomBuilding.grow(-57.5,(621-bottomBuilding.getHeight())/2);
        */
    }

    //TODO: Ver se faz sentido tirar o draw para outra class
    public void draw(double distance) {
        top.translate(-distance, 0);
        top.fill();
        gap.translate(-distance, 0);
        bottom.translate(-distance, 0);
        bottom.fill();

        /*
        topBuilding.translate(-distance, 0);
        topBuilding.draw();
        gap.translate(-distance, 0);
        bottomBuilding.translate(-distance, 0);
        bottomBuilding.draw();
        */
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
        //return topBuilding;
    }

    public Rectangle getGap() {
        return gap;
    }

    public Rectangle getBottom() {
        return bottom;
        //return bottomBuilding;
    }
}
