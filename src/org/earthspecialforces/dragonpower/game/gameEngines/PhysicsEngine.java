package org.earthspecialforces.dragonpower.game.gameEngines;

import org.earthspecialforces.dragonpower.game.gameObjects.Player;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class PhysicsEngine {

    private static final int TERMINAL_VELOCITY = 50;
    private double gravity;
    private double verticalSpeed;

    public PhysicsEngine() {
        gravity = 0.8;
        verticalSpeed = 0;
    }

    public void fall(Player player) {
        verticalSpeed = verticalSpeed + gravity;

        if (verticalSpeed > TERMINAL_VELOCITY) {
            verticalSpeed = TERMINAL_VELOCITY;
        }
        System.out.println("Vertical Speed = " + verticalSpeed);
        if (player.hasJumped()) {
            verticalSpeed = 0;
            player.setJumped(false);
        }

        player.setPositionY(player.getPositionY() + verticalSpeed);
    }

    public double getVerticalSpeed() {
        return verticalSpeed;
    }
}
