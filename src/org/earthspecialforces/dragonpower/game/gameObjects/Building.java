package org.earthspecialforces.dragonpower.game.gameObjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.earthspecialforces.dragonpower.game.gameEngines.NumGen;

import java.util.ArrayList;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class Building extends GameObject {

    /**
     * PROPERTIES:
     */
    public static final int BUILDINGS_SPACE = 300;
    public static final int BUILDING_WIDTH = 100;
    public static final int BUILDING_HEIGHT = 50 + NumGen.chooseRandom(20, 300);

    private ArrayList<Rectangle> buildings;
    private int screenWidth = 800;
    private int screenHeight = 800;

    public Building() {
        buildings = new ArrayList<Rectangle>();

    }


    public void addBuilding(boolean start) {

        if (start) {
            buildings.add(new Rectangle(screenWidth + BUILDING_WIDTH + buildings.size() * 300, 0, screenHeight - BUILDING_HEIGHT - BUILDINGS_SPACE, 0));
            buildings.add(new Rectangle(screenWidth + BUILDING_WIDTH + (buildings.size() - 1) * 300, 0, BUILDING_WIDTH, screenHeight - BUILDING_HEIGHT - BUILDINGS_SPACE));
        }else{
            buildings.add(new Rectangle(buildings.get(buildings.size()-1).getX()+600, screenHeight-BUILDING_HEIGHT-120,screenWidth,screenHeight));
            buildings.add(new Rectangle(buildings.get(buildings.size()-1).getX(),0,BUILDING_WIDTH,screenHeight-BUILDING_HEIGHT-BUILDINGS_SPACE));
        }
    }

    public void paintBuilding(Rectangle building){
        building.setColor(Color.YELLOW);
        building.fill();
    }


}
