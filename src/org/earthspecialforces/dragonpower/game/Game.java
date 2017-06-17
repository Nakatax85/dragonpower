package org.earthspecialforces.dragonpower.game;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.earthspecialforces.dragonpower.game.gameEngines.PhysicsEngine;
import org.earthspecialforces.dragonpower.game.gameObjects.Building;
import org.earthspecialforces.dragonpower.game.gameObjects.GameObject;
import org.earthspecialforces.dragonpower.game.gameObjects.Player;
import org.earthspecialforces.dragonpower.input.KeyboardInput;
import org.earthspecialforces.dragonpower.screens.Screen;
import org.earthspecialforces.dragonpower.screens.StartScreen;
import org.earthspecialforces.dragonpower.testers.TestObstacle;

import java.util.LinkedList;

import static org.earthspecialforces.dragonpower.game.Constants.MAX_SCREEN_WIDTH;
import static org.earthspecialforces.dragonpower.game.Constants.OBSTACLES_DISTANCE;

/**
 * Created by njsilva on 11/06/2017.
 */
public class Game {

    //TODO: Change this to a specific GameObjects_List to encapsulate our GameObjects List
    private LinkedList<GameObject> objectsList;

    private PhysicsEngine physicsEngine;
    private KeyboardInput k;
    private Screen screen;
    private Player player;

    public Game(Player player) {
        screen = new StartScreen();
        k = new KeyboardInput(player, screen);
        physicsEngine = new PhysicsEngine();
        this.player = player;
        objectsList = new LinkedList<>();
    }


    public void start(Player player, int delay) throws InterruptedException {

        while (k.getScreen() instanceof StartScreen) {
            Thread.sleep(20);
        }
        screen = k.getScreen();

        //TODO Create a GameObjects Factory
        Building building = new Building();
        objectsList.add(building);

        building.draw(0);

        while (player.isAlive()) {
            // Pause for a while
            Thread.sleep(delay);

            createNewObstacles();

            makePlayerFall();
            //System.out.println("Index of getLast = " + objectsList.indexOf(objectsList.getLast()));
            moveObstacles();

            //System.out.println("Player Y = " + player.getPositionY());
            //System.out.println("Image Y = " + player.getImage().getY());
            //System.out.println("Is Alive? " + player.isAlive());
        }

        Picture gameOver = new Picture(290, 155, "imgs/Game Over.png");
        gameOver.draw();

    }

    public void moveObstacles() {

        //TODO: Verificar se pode ser alterado para for-each ou outra coisa qualquer
        for (int i = 0; i <= objectsList.indexOf(objectsList.getLast()); i++) {
            objectsList.get(i).moveLeft(physicsEngine.getHorizontalSpeed());
        }
    }

    public void makePlayerFall(){
        physicsEngine.fall(player);
        player.draw(physicsEngine.getVerticalSpeed());
    }

    public void createNewObstacles(){
        if (objectsList.getLast().getPositionX() < MAX_SCREEN_WIDTH - OBSTACLES_DISTANCE){

            //System.out.println("Last Object X = " + objectsList.getLast().getPositionX());
            objectsList.add(new Building());
        }
    }
}

