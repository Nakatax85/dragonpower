package org.earthspecialforces.dragonpower.game.gameEngines;

import org.earthspecialforces.dragonpower.game.gameObjects.Building;
import org.earthspecialforces.dragonpower.game.gameObjects.GameObject;
import org.earthspecialforces.dragonpower.game.gameObjects.Player;

import java.util.LinkedList;

import static org.earthspecialforces.dragonpower.game.Constants.*;

/**
 * Created by njsilva on 11/06/2017.
 */
public class CollisionDetector {


    public CollisionDetector() {
    }

    public boolean checkForCollisions(Player player, LinkedList<GameObject> gameObjectList) {

        for (GameObject gameObject : gameObjectList) {
            if(hasCollided(gameObject, player)){
                return true;
            }
        }
        return false;
    }

    public boolean hasCollided(GameObject gameObject, Player player) {


        if (hitsGround(player)){
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

    private boolean hitsGround(Player player){
        if (bottomY(player) > MAX_SCREEN_HEIGHT + CLOUD + PADDING){
            return true;
        }
        return false;
    }

    public double bottomY(Player player) {
        return player.getImage().getMaxY();
    }

    public double topY(Player player) {
        return player.getImage().getY();
    }

    public double backX(Player player) {
        return player.getImage().getMaxX();
    }


    public double frontX(Player player) {
        return player.getImage().getMaxX() - 8;
    }


    public double gapTopY(Building building) {
        return building.getGap().getY();
    }

    public double gapBotY(Building building) {
        return building.getGap().getY() + building.getGap().getHeight();
    }

    public double gapFrontX(Building building) {
        return building.getGap().getX() + building.getGap().getWidth();
    }

}
