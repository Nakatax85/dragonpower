package org.earthspecialforces.dragonpower.testers;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import org.earthspecialforces.dragonpower.game.gameObjects.DragonBall;


import static org.earthspecialforces.dragonpower.game.Constants.MAX_SCREEN_HEIGHT;
import static org.earthspecialforces.dragonpower.game.Constants.MAX_SCREEN_WIDTH;

/**
 * Created by codecadet on 18/06/2017.
 */
public class TestDragonBalls {
    public static void main(String[] args) {

        Rectangle screen = new Rectangle(10, 10, MAX_SCREEN_WIDTH, MAX_SCREEN_HEIGHT);
        screen.setColor(Color.WHITE);
        screen.fill();
        DragonBall dragonBall1 = new DragonBall(1);

        dragonBall1.draw(10);



    }
}
