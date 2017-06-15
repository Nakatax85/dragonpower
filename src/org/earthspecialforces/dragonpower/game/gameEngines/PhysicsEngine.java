package org.earthspecialforces.dragonpower.game.gameEngines;

import org.earthspecialforces.dragonpower.game.gameObjects.Player;
import org.earthspecialforces.dragonpower.testers.TestObstacle;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class PhysicsEngine {

    private static final int TERMINAL_VELOCITY = 50;
    private double gravity;
    private double verticalSpeed;
    private double horizontalSpeed = 5;

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

    public void moveLeft(TestObstacle obstacle){
        obstacle.setPositionX(horizontalSpeed);
    }

    public double getVerticalSpeed() {
        return verticalSpeed;
    }

    public double getHorizontalSpeed() {
        return horizontalSpeed;
    }
}
