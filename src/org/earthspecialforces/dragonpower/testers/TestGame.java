package org.earthspecialforces.dragonpower.testers;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.earthspecialforces.dragonpower.game.gameEngines.PhysicsEngine;
import org.earthspecialforces.dragonpower.game.gameObjects.Player;
import org.earthspecialforces.dragonpower.input.KeyboardInput;
import org.earthspecialforces.dragonpower.screens.GameScreen;
import org.earthspecialforces.dragonpower.screens.Screen;
import org.earthspecialforces.dragonpower.screens.StartScreen;

import static org.earthspecialforces.dragonpower.game.Constants.PADDING;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class TestGame {

    private PhysicsEngine physicsEngine;
    private KeyboardInput k;
    private Screen screen;

    public TestGame(Player player) {
        screen = new StartScreen();
        k = new KeyboardInput(player, screen);
        physicsEngine = new PhysicsEngine();
    }


    public void start(Player player, int delay) throws InterruptedException {

        while (k.getScreen() instanceof StartScreen){
            Thread.sleep(20);
        }
        screen = k.getScreen();

        TestObstacle obstacle = new TestObstacle();
        player.draw(0);
        obstacle.draw(0);

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            physicsEngine.fall(player);
            physicsEngine.moveLeft(obstacle);
            obstacle.draw(physicsEngine.getHorizontalSpeed());

            player.draw(physicsEngine.getVerticalSpeed());

            System.out.println("Player Y = " + player.getPositionY());
            System.out.println("Image Y = " + player.getImage().getY());

        }

    }

}


