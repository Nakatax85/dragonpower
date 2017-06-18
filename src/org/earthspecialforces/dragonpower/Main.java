package org.earthspecialforces.dragonpower;

import org.earthspecialforces.dragonpower.game.Game;
import org.earthspecialforces.dragonpower.game.Player;

import static org.earthspecialforces.dragonpower.game.Constants.GAME_DELAY;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game game = new Game(new Player());

        game.start(GAME_DELAY);

    }

}

