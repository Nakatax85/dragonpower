package org.earthspecialforces.dragonpower.testers.mariotesters;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.earthspecialforces.dragonpower.game.Constants;
import org.earthspecialforces.dragonpower.game.gameObjects.Bean;


import java.awt.*;

/**
 * Created by codecadet on 15/06/17.
 */
public class BeanTester {
    public static void main(String[] args) throws InterruptedException {
        Bean bean = new Bean(100, 100, "/Users/codecadet/dev/projects/dragonpower/resources/imgs/Senzu_Bean.png");
        Rectangle pixel = new Rectangle(Constants.MAX_SCREEN_WIDTH,Constants.MAX_SCREEN_HEIGHT,1,1);
        pixel.setColor(Color.WHITE);
        pixel.draw();
        bean.draw();

        int delay = 300;

        while (true) {

            // Pause for a while
            Thread.sleep(delay);


            bean.draw();


        }
    }

    private static Constants.Direction genDirection() {
        int genDirection = (int)  (Math.random() * Constants.Direction.values().length);
        Constants.Direction direction = Constants.Direction.values()[genDirection];
        return direction;

    }

}
