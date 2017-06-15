package org.earthspecialforces.dragonpower.testers;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.earthspecialforces.dragonpower.game.Constants;
import org.earthspecialforces.dragonpower.game.gameEngines.PhysicsEngine;
import org.earthspecialforces.dragonpower.game.gameObjects.Player;
import org.earthspecialforces.dragonpower.input.KeyboardInput;
import org.earthspecialforces.dragonpower.screens.GameScreen;
import org.earthspecialforces.dragonpower.screens.Screen;
import org.earthspecialforces.dragonpower.screens.StartScreen;

import java.util.LinkedList;

import static org.earthspecialforces.dragonpower.game.Constants.MAX_SCREEN_WIDTH;
import static org.earthspecialforces.dragonpower.game.Constants.OBSTACLES_DISTANCE;
import static org.earthspecialforces.dragonpower.game.Constants.PADDING;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class TestGame {

    private LinkedList<TestObstacle> obstaclesList;
    private PhysicsEngine physicsEngine;
    private KeyboardInput k;
    private Screen screen;
    Player player;

    public TestGame(Player player) {
        screen = new StartScreen();
        k = new KeyboardInput(player, screen);
        physicsEngine = new PhysicsEngine();
        this.player = player;
        obstaclesList = new LinkedList<>();
    }


    public void start(Player player, int delay) throws InterruptedException {

        while (k.getScreen() instanceof StartScreen) {
            Thread.sleep(20);
        }
        screen = k.getScreen();

        TestObstacle obstacle = new TestObstacle();
        obstaclesList.add(obstacle);
        obstacle.draw(0);

        while (player.isAlive()) {

            // Pause for a while
            Thread.sleep(delay);

            createNewObstacles();

            makePlayerFall();
            System.out.println("Index of getLast = " + obstaclesList.indexOf(obstaclesList.getLast()));
            moveObstacles();



            //System.out.println("Player Y = " + player.getPositionY());
            //System.out.println("Image Y = " + player.getImage().getY());
            //System.out.println("Is Alive? " + player.isAlive());

        }

        Picture gameOver = new Picture(290, 155, "imgs/Game Over.png");
        gameOver.draw();

    }

    public void moveObstacles() {

        for (int i = 0; i <= obstaclesList.indexOf(obstaclesList.getLast()); i++) {
            obstaclesList.get(i).moveLeft(physicsEngine.getHorizontalSpeed());
        }

    }

    public void makePlayerFall(){
        physicsEngine.fall(player);
        player.draw(physicsEngine.getVerticalSpeed());
    }

    public void createNewObstacles(){
        if (obstaclesList.getLast().getPositionX() < MAX_SCREEN_WIDTH - OBSTACLES_DISTANCE){
            System.out.println("Last Object X = " + obstaclesList.getLast().getPositionX());
            obstaclesList.add(new TestObstacle());
        }
    }
}


