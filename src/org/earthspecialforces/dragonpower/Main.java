package org.earthspecialforces.dragonpower;

import org.earthspecialforces.dragonpower.game.Game;
import org.earthspecialforces.dragonpower.game.gameEngines.PhysicsEngine;
import org.earthspecialforces.dragonpower.game.gameObjects.Player;
import org.earthspecialforces.dragonpower.input.KeyboardInput;

import static org.earthspecialforces.dragonpower.game.Constants.GAME_DELAY;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Player player = new Player();
        Game game = new Game(player);

        game.start(player, GAME_DELAY);

    }

}

