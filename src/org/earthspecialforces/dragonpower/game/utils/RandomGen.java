package org.earthspecialforces.dragonpower.game.utils;

import java.util.Random;

/**
 * Created by DragonPowerTeam on 26/05/2017.
 */

/**
 * This class represents a Random Generator
 */

public class RandomGen {

    public static int randomIntBetweenMinAndMax (int min, int max) {

        Random random = new Random();
        return ((random.nextInt(11) * (max - min) / 10) + min);
    }
}

