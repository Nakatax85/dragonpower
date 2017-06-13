package org.earthspecialforces.dragonpower.testers;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class DragonPowerTester {

    public static void main(String[] args) throws InterruptedException{

        TestGame game = new TestGame(200, 100, 10);

        game.start();
    }


}

