package org.earthspecialforces.dragonpower.input;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.earthspecialforces.dragonpower.game.gameEngines.PhysicsEngine;
import org.earthspecialforces.dragonpower.game.gameObjects.Player;
import org.earthspecialforces.dragonpower.screens.GameScreen;
import org.earthspecialforces.dragonpower.screens.StartScreen;

/**
 * Created by codecadet on 13/06/17.
 */
public class TestInput {


    public static void main(String[] args) throws InterruptedException {

        int delay = 50;

        Player player = new Player();
        KeyboardInput k = new KeyboardInput(player);
        PhysicsEngine physicsEngine = new PhysicsEngine();

        /*while(k.getScreen() instanceof GameScreen) {
            start(player, delay);
        }*/
        System.out.println("Image Height = " + player.getImage().getHeight());
        System.out.println("Image Width = " + player.getImage().getWidth());
        Thread.sleep(2000);
        start(physicsEngine, player, delay);

    }

    private static void start(PhysicsEngine physicsEngine, Player player, int delay) throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);
            physicsEngine.fall(player);
            player.draw(physicsEngine.getVerticalSpeed());
            System.out.println("Player Y = " + player.getPositionY());
            System.out.println("Image Y = " + player.getImage().getY());

        }

    }

}
