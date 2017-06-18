package org.earthspecialforces.dragonpower.game.gameEngines;

import org.earthspecialforces.dragonpower.game.gameObjects.Building;
import org.earthspecialforces.dragonpower.game.gameObjects.GameObject;
import org.earthspecialforces.dragonpower.game.gameObjects.Player;

import java.util.LinkedList;

import static org.earthspecialforces.dragonpower.game.Constants.*;

/**
 * Created by DragonPowerTeam on 11/06/2017.
 */

/**
 * This class represents the collision detector of the objects that interact within the game
 */
public class CollisionDetector {

    /**
     * Initialization of the CollisionDetector
     */
    public CollisionDetector() {
    }

    /**
     * @param player
     * @param gameObjectList
     * @return true if the Player collides with objects of the superClass GameObjects
     */
    public boolean checkForCollisions(Player player, LinkedList<GameObject> gameObjectList) {

        for (GameObject gameObject : gameObjectList) {
            if (hasCollided(gameObject, player)) {
                return true;
            }

        }
        return false;
    }

    /**
     * @param gameObject
     * @param player
     * @return
     */
    public boolean playerHasClearedObstacle(GameObject gameObject, Player player) {
        if (gameObject instanceof Building) {

            if (backX(player) == gapFrontX(((Building) gameObject))) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param gameObject
     * @param player
     * @return
     */
    public boolean hasCollided(GameObject gameObject, Player player) {

        if (hitsGround(player)) {
            player.hasDied();
        }

        if (frontX(player) < gameObject.getX()) {
            return false;
        }

        if (gameObject instanceof Building) {
            Building building = (Building) gameObject;

            if (backX(player) > gapFrontX(building)) {
                return false;
            }

            if (topY(player) <= gapTopY(building) || bottomY(player) >= gapBotY(building)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param player
     * @return true if the Player hits the ground
     */
    private boolean hitsGround(Player player) {
        if (bottomY(player) > MAX_SCREEN_HEIGHT + CLOUD + PADDING) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param player
     * @return
     */
    public double bottomY(Player player) {
        return player.getGokuImage().getMaxY();
    }

    /**
     *
     * @param player
     * @return
     */
    public double topY(Player player) {
        return player.getGokuImage().getY();
    }

    /**
     *
     * @param player
     * @return
     */
    public double backX(Player player) {
        return player.getGokuImage().getMaxX();
    }

    /**
     *
     * @param player
     * @return
     */
    public double frontX(Player player) {
        return player.getGokuImage().getMaxX() - 8;
    }

    /**
     *
     * @param building
     * @return
     */
    public double gapTopY(Building building) {
        return building.getGap().getY();
    }

    /**
     *
     * @param building
     * @return
     */
    public double gapBotY(Building building) {
        return building.getGap().getY() + building.getGap().getHeight();
    }

    /**
     *
     * @param building
     * @return
     */
    public double gapFrontX(Building building) {
        return building.getGap().getX() + building.getGap().getWidth();
    }

}
