package org.earthspecialforces.dragonpower.input;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.earthspecialforces.dragonpower.game.gameObjects.Player;
import org.earthspecialforces.dragonpower.screens.GameScreen;
import org.earthspecialforces.dragonpower.screens.StartScreen;

/**
 * Created by codecadet on 13/06/17.
 */
public class TestInput {


    public static void main(String[] args) throws InterruptedException{

        int delay = 50;

        Player player = new Player();
        KeyboardInput k = new KeyboardInput(player);

        if (k.getScreen() instanceof GameScreen) {
            start(player, delay);
        }

    }

    public static void start(Player player,int delay) throws InterruptedException {

            while (true) {

                // Pause for a while
                Thread.sleep(delay);

                player.draw(5);
                System.out.println("Player Y = " + player.getPositionY());
            }

        }

}
