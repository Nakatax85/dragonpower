package org.earthspecialforces.dragonpower.game.gameEngines;

import org.earthspecialforces.dragonpower.game.Player;

import static org.earthspecialforces.dragonpower.game.Constants.GRAVITY;
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
     * The Physics Engine starts with the fall vertical speed as 0 (zero)
     */
    public PhysicsEngine() {
        verticalSpeed = 0;
    }

    /**
     * Makes one player fall, by incrementing its speed by the value of GRAVITY
     * If the player has jumped, sets its vertical speed to 0 (zero) to better
     * simulate what would happen in reality.
     * @param player
     */
    public void fall(Player player) {
        verticalSpeed = verticalSpeed + GRAVITY;

        if (verticalSpeed > TERMINAL_VELOCITY) {
            verticalSpeed = TERMINAL_VELOCITY;
        }
        if (player.hasJumped()) {
            verticalSpeed = 0;
            player.stopJumping(false);
        }

        player.updatePosition(verticalSpeed);
    }

    /**
     * Getter of the vertical speed currently used
     * @return vertical speed
     */
    public double getVerticalSpeed() {
        return verticalSpeed;
    }

}
