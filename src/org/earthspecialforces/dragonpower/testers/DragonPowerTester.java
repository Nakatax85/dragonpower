package org.earthspecialforces.dragonpower.testers;

import org.earthspecialforces.dragonpower.game.Game;
import org.earthspecialforces.dragonpower.game.gameEngines.PhysicsEngine;
import org.earthspecialforces.dragonpower.game.gameObjects.Player;
import org.earthspecialforces.dragonpower.input.KeyboardInput;

import static org.earthspecialforces.dragonpower.game.Constants.GAME_DELAY;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class DragonPowerTester {

    public static void main(String[] args) throws InterruptedException {

        Player player = new Player();
        Game game = new Game(player);
        //TestGame game = new TestGame(player);

        //Player Image's dimensions:

        //System.out.println("Image Height = " + player.getTop().getHeight());
        //System.out.println("Image Width = " + player.getTop().getWidth());

        game.start(player, GAME_DELAY);

    }

}

