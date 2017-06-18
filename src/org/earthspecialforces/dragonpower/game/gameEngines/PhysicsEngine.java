package org.earthspecialforces.dragonpower.game.gameEngines;

import org.earthspecialforces.dragonpower.game.gameObjects.Building;
import org.earthspecialforces.dragonpower.game.gameObjects.Player;
import org.earthspecialforces.dragonpower.testers.TestObstacle;

import static org.earthspecialforces.dragonpower.game.Constants.GRAVITY;
import static org.earthspecialforces.dragonpower.game.Constants.HORIZONTAL_SPEED;
import static org.earthspecialforces.dragonpower.game.Constants.TERMINAL_VELOCITY;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class PhysicsEngine {

    private double verticalSpeed;

    public PhysicsEngine() {
        verticalSpeed = 0;
    }

    public void fall(Player player) {
        verticalSpeed = verticalSpeed + GRAVITY;

        if (verticalSpeed > TERMINAL_VELOCITY) {
            verticalSpeed = TERMINAL_VELOCITY;
        }
        //System.out.println("Vertical Speed = " + verticalSpeed);
        if (player.hasJumped()) {
            verticalSpeed = 0;
            player.setJumped(false);
        }

        player.updatePosition(verticalSpeed);
    }

    public void moveLeft(Building building){
        building.moveLeft(HORIZONTAL_SPEED);
    }

    public double getVerticalSpeed() {
        return verticalSpeed;
    }

    public double getHorizontalSpeed() {
        return HORIZONTAL_SPEED;
    }
}
