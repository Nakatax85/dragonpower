package org.earthspecialforces.dragonpower.testers.nelsontesters;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.earthspecialforces.dragonpower.game.gameObjects.Building;
import org.earthspecialforces.dragonpower.screens.Screen;

/**
 * Created by NJSilva on 15/06/2017.
 */
public class TesterMain {
    public static void main(String[] args) {
        Building b = new Building();
        Rectangle r = new Rectangle();
        Rectangle screen = new Rectangle(Screen.PADDING,Screen.PADDING,800,800);

        screen.setColor(Color.BLACK);
        screen.fill();

        b.addBuilding(true);
        b.paintBuilding(r);
    }


}
