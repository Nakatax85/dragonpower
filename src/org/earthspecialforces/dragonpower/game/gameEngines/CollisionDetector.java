package org.earthspecialforces.dragonpower.game.gameEngines;

import org.earthspecialforces.dragonpower.game.gameObjects.Building;
import org.earthspecialforces.dragonpower.game.gameObjects.GameObject;
import org.earthspecialforces.dragonpower.game.Player;

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
     * Checks for collisions between the player object and all the objects in the game
     * @param player         Receives one player
     * @param gameObjectList And a list of GameObjects
     * @return               True - if the player has collided with one GameObject
     *                       False - if there is no collision
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
     * Checks if the player has passed one GameObjects of the type Building
     * @param gameObject Receives one GameObject
     * @param player  Receives one player
     * @return        TRUE - if the players is ahead of the GameObject
     *                FALSE - if the player didn't reach the end of the Obstacle
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
     * Checks if one player has collided with one GameObject
     * @param gameObject - one GameObject
     * @param player - one player
     * @return True - If there was a collision
     *         False - If there wasn't
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
     * Checks if the player hits the bottom of the screen
     * @param player - The object player
     * @return       True: if the player hits the ground
     *               False: If it didn't
     */
    private boolean hitsGround(Player player) {
        if (bottomY(player) > MAX_SCREEN_HEIGHT + CLOUD + PADDING) {
            return true;
        }
        return false;
    }

    /**
     * Calculates the Y coordinate of the bottom of the Player's image
     *
     * @param player
     * @return Double: the maximum Y coordinate of the Player's image
     */
    public double bottomY(Player player) {
        return player.getGokuImage().getMaxY();
    }

    /**
     * Calculates the Y coordinate of the top of the Player's image
     *
     * @param player
     * @return
     */
    public double topY(Player player) {
        return player.getGokuImage().getY();
    }

    /**
     * Calculates the X coordinate of the back of the Player's image
     *
     * @param player
     * @return The minimum X coordinate of the Player's image
     */
    public double backX(Player player) {
        return player.getGokuImage().getMaxX();
    }

    /**
     * Calculates the X coordinate of the front of the Player's image
     *
     * @param player
     * @return The maximum X coordinate of the Player's image
     */
    public double frontX(Player player) {
        return player.getGokuImage().getMaxX() - 8;
    }

    /**
     * Calculates the Y coordinate of the front of the Building's gap
     *
     * @param building
     * @return
     */
    public double gapTopY(Building building) {
        return building.getGap().getY();
    }

    /**
     * Calculates the Y coordinate of the bottom of the Building's gap
     *
     * @param building
     * @return
     */
    public double gapBotY(Building building) {
        return building.getGap().getY() + building.getGap().getHeight();
    }

    /**
     * Calculates the X coordinate of the front of the Building's gap
     *
     * @param building
     * @return
     */
    public double gapFrontX(Building building) {
        return building.getGap().getX() + building.getGap().getWidth();
    }

}
