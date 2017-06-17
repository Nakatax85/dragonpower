package org.earthspecialforces.dragonpower.game.gameEngines;

import org.earthspecialforces.dragonpower.game.gameObjects.Building;
import org.earthspecialforces.dragonpower.game.gameObjects.GameObject;
import org.earthspecialforces.dragonpower.game.gameObjects.Player;

import java.util.LinkedList;

/**
 * Created by njsilva on 11/06/2017.
 */
public class CollisionDetector {


    public CollisionDetector() {
    }

    public boolean checkForCollisions(Player player, LinkedList<GameObject> gameObjectList) {

        for (GameObject gameObject : gameObjectList) {
            checkAbove(gameObject, player);
            //checkInFront(gameObject);
            //checkBelow(gameObject);

        }
        return false;
    }

    public boolean checkAbove(GameObject gameObject, Player player) {

        if (maxX(player) < gameObject.getX()) {
            return false;
        }

        if (gameObject instanceof Building) {
            Building building = (Building) gameObject;

            if (player.getImage().getX() > building.getGap().getX() + building.getGap().getWidth() ){
                return false;
            }

            if (maxY(player) < gapTopY(building) &&
                    player.getImage().getMaxY() > gapBotY(building)) {

                System.out.println("Player has collided with building.");
                player.isDead();
                return true;
            }

        }


        return false;
    }

    public double maxY (Player player){
        return player.getImage().getMaxY();
    }

    public double maxX (Player player){
        return player.getImage().getMaxX() - 8;
    }


    public double gapTopY (Building building){
        return building.getGap().getY();
    }

    public double gapBotY (Building building){
        return building.getGap().getY() + building.getGap().getHeight();
    }


}
