package org.earthspecialforces.dragonpower.game.gameEngines;

import org.earthspecialforces.dragonpower.game.gameObjects.Building;
import org.earthspecialforces.dragonpower.game.gameObjects.Player;
import org.earthspecialforces.dragonpower.testers.TestObstacle;

import static org.earthspecialforces.dragonpower.game.Constants.GRAVITY;
import static org.earthspecialforces.dragonpower.game.Constants.HORIZONTAL_SPEED;
import static org.earthspecialforces.dragonpower.game.Constants.TERMINAL_VELOCITY;

/**
 * Created by DragonPowerTeam on 13/06/2017.
 */

/**
 * This class establishes the physics rule that guide the Player and the GameObjects behaviour
 */
public class PhysicsEngine {

    private double verticalSpeed;

    /**
     *
     */
    public PhysicsEngine() {
        verticalSpeed = 0;
    }

    /**
     *
     * @param player
     */
    public void fall(Player player) {
        verticalSpeed = verticalSpeed + GRAVITY;

        if (verticalSpeed > TERMINAL_VELOCITY) {
            verticalSpeed = TERMINAL_VELOCITY;
        }
        if (player.hasJumped()) {
            verticalSpeed = 0;
            player.setJumped(false);
        }

        player.updatePosition(verticalSpeed);
    }

    /**
     *
     * @param building
     * moves the Building object from the right to the left
     */
    public void moveLeft(Building building){
        building.moveLeft(HORIZONTAL_SPEED);
    }

    /**
     *
     * @return vertical speed
     */
    public double getVerticalSpeed() {
        return verticalSpeed;
    }

    /**
     *
     * @return horizontal speed
     */
    public double getHorizontalSpeed() {
        return HORIZONTAL_SPEED;
    }
}
