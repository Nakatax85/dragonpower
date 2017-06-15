package org.earthspecialforces.dragonpower.game.gameEngines;

/**
 * Created by NJSilva on 15/06/2017.
 */
public class NumGen {

    public static int chooseRandom(int min, int max){

        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
