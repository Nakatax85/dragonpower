package org.earthspecialforces.dragonpower.game.gameEngines;

import org.earthspecialforces.dragonpower.game.gameObjects.Obstacle;
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
     * Checks if the player has passed one GameObjects of the type Obstacle
     * @param gameObject Receives one GameObject
     * @param player  Receives one player
     * @return        TRUE - if the players is ahead of the GameObject
     *                FALSE - if the player didn't reach the end of the Obstacle
     */
    public boolean playerHasClearedObstacle(GameObject gameObject, Player player) {
        if (gameObject instanceof Obstacle) {

            if (backX(player) == gapFrontX(((Obstacle) gameObject))) {
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
    private boolean hasCollided(GameObject gameObject, Player player) {

        if (hitsGround(player)) {
            player.hasDied();
        }

        if (frontX(player) < gameObject.getX()) {
            return false;
        }

        if (gameObject instanceof Obstacle) {
            Obstacle obstacle = (Obstacle) gameObject;

            if (backX(player) > gapFrontX(obstacle)) {
                return false;
            }

            if (topY(player) <= gapTopY(obstacle) || bottomY(player) >= gapBotY(obstacle)) {
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
    private double bottomY(Player player) {
        return player.getGokuImage().getMaxY();
    }

    /**
     * Calculates the Y coordinate of the top of the Player's image
     *
     * @param player
     * @return
     */
    private double topY(Player player) {
        return player.getGokuImage().getY();
    }

    /**
     * Calculates the X coordinate of the back of the Player's image
     *
     * @param player
     * @return The minimum X coordinate of the Player's image
     */
    private double backX(Player player) {
        return player.getGokuImage().getMaxX();
    }

    /**
     * Calculates the X coordinate of the front of the Player's image
     *
     * @param player
     * @return The maximum X coordinate of the Player's image
     */
    private double frontX(Player player) {
        return player.getGokuImage().getMaxX() - 8;
    }

    /**
     * Calculates the Y coordinate of the front of the Obstacle's gap
     *
     * @param obstacle
     * @return
     */
    private double gapTopY(Obstacle obstacle) {
        return obstacle.getGap().getY();
    }

    /**
     * Calculates the Y coordinate of the bottom of the Obstacle's gap
     *
     * @param obstacle
     * @return
     */
    private double gapBotY(Obstacle obstacle) {
        return obstacle.getGap().getY() + obstacle.getGap().getHeight();
    }

    /**
     * Calculates the X coordinate of the front of the Obstacle's gap
     *
     * @param obstacle
     * @return
     */
    private double gapFrontX(Obstacle obstacle) {
        return obstacle.getGap().getX() + obstacle.getGap().getWidth();
    }

}
