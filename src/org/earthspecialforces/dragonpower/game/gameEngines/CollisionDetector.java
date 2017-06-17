package org.earthspecialforces.dragonpower.game.gameEngines;

import org.earthspecialforces.dragonpower.game.gameObjects.Building;
import org.earthspecialforces.dragonpower.game.gameObjects.GameObject;
import org.earthspecialforces.dragonpower.game.gameObjects.Player;

import java.util.LinkedList;

import static org.earthspecialforces.dragonpower.game.Constants.PLAYER_INITIAL_X;

/**
 * Created by njsilva on 11/06/2017.
 */
public class CollisionDetector {

    private GameObject ground;

    public CollisionDetector(GameObject ground) {
        this.ground = ground;
    }

    public boolean checkForCollisions(Player player, LinkedList<GameObject> gameObjectList) {

        for (GameObject gameObject : gameObjectList) {
            checkAbove(gameObject, player);
            //checkInFront(gameObject);
            //checkBelow(gameObject);

        }
        return false;
    }

    public void checkAbove(GameObject gameObject, Player player) {

        double playerFrontSide = 0;
        playerFrontSide = PLAYER_INITIAL_X + player.getImage().getWidth();

        if (playerFrontSide == gameObject.getPositionX()) {

            if (gameObject instanceof Building) {

                /*if (player.getPositionY() < ((Building) gameObject).getGap().getY() &&
                        player.getPositionY() > ((Building) gameObject).getBottom().getY()) {*/

                    System.out.println("Player has collided with something.");
                    player.isDead();
               // }
            }
        }
    }


    public boolean checkInFront() {
        return false;
    }

    public boolean checkBelow() {
        return false;
    }

}
