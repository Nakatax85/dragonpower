package org.earthspecialforces.dragonpower.game.gameObjects;

/**
 * Created by DragonPowerTeam on 11/06/2017.
 */

/**
 * This class represents the interface Collectable
 */
public interface Collectable {

    /**
     *
     * @return true if the object that implements Collectable is hit
     */
    boolean isHit();

    /**
     *
     * @return true if the object that implements Collectable is collected
     */
    boolean isCollected();

}
