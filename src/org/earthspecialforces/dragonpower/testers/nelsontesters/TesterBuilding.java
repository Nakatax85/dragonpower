package org.earthspecialforces.dragonpower.testers.nelsontesters;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.earthspecialforces.dragonpower.game.gameEngines.NumGen;
import org.earthspecialforces.dragonpower.game.gameObjects.GameObject;

import java.util.ArrayList;

/**
 * Created by NJSilva on 15/06/2017.
 */
public class TesterBuilding extends GameObject {
    public static final int BUILDINGS_SPACE = 300;
    public static final int BUILDING_WIDTH = 100;
    public static final int BUILDING_HEIGHT = 50 + NumGen.chooseRandom(20, 300);

    private ArrayList<Rectangle> buildings;
    private int screenWidth = 800;
    private int screenHeight = 800;

    public TesterBuilding() {
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

    public void clear(){

    }

    public int getBuildingSize() {
       return buildings.size();
    }

    public Rectangle getBuildings(int index) {
        return buildings.get(index);
    }


}
