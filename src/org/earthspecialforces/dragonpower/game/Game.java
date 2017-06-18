package org.earthspecialforces.dragonpower.game;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.earthspecialforces.dragonpower.game.gameEngines.CollisionDetector;
import org.earthspecialforces.dragonpower.game.gameEngines.PhysicsEngine;
import org.earthspecialforces.dragonpower.game.gameObjects.Building;
import org.earthspecialforces.dragonpower.game.gameObjects.GameObject;
import org.earthspecialforces.dragonpower.game.gameObjects.Player;
import org.earthspecialforces.dragonpower.input.KeyboardInput;
import org.earthspecialforces.dragonpower.screens.GameScreen;
import org.earthspecialforces.dragonpower.screens.Screen;
import org.earthspecialforces.dragonpower.screens.StartScreen;

import java.util.LinkedList;

import static org.earthspecialforces.dragonpower.game.Constants.*;

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
    private GameObject ground;
    private int scoreInt;
    private Text scoreText;
    private Score score;
    private CollisionDetector collisionDetector;

    public Game(Player player) {
        screen = new StartScreen();
        k = new KeyboardInput(screen);
        physicsEngine = new PhysicsEngine();
        this.player = player;
        objectsList = new LinkedList<>();
        collisionDetector = new CollisionDetector();
        scoreInt = 0;
        scoreText = new Text(200, 150, Integer.toString(scoreInt));
    }

    public void start(Player player, int delay) throws InterruptedException {

        while (!k.isPressed() && screen instanceof StartScreen) {
            Thread.sleep(20);
        }
        k.stopPressed();
        if (screen instanceof StartScreen) {
            screen = new GameScreen();
        }
        scoreText.draw();

        //TODO Create a GameObjects Factory
        Building building = new Building();
        objectsList.add(building);

        while (player.isAlive()) {
            // Pause for a while
            Thread.sleep(delay);

            if (k.isPressed()) {
                player.jump();
                k.stopPressed();
            }
            if (collisionDetector.checkForCollisions(player, objectsList)) {
                player.hasDied();
            }
            createNewObstacles();
            makePlayerFall();
            moveObstacles();
            if (collisionDetector.playerHasClearedObstacle(objectsList.getFirst(),player)){
                scoreInt++;
                drawScore();
            }
        }
        gameOver();
        while (!k.isPressed()) {
            Thread.sleep(20);
        }
        initiateNewGame();
    }

    private void gameOver() {
        Picture gameOver = new Picture(290, 155, "imgs/Game Over.png");
        Text spaceText = new Text(320, 450, "<Press SPACE to RESTART GAME>");
        gameOver.draw();
        spaceText.draw();
    }

    private void initiateNewGame() throws InterruptedException {
        screen = new GameScreen();
        k = new KeyboardInput(screen);
        this.player = new Player();
        objectsList = new LinkedList<>();
        scoreInt = 0;
        scoreText = new Text(200, 150, Integer.toString(scoreInt));
        System.out.println("Before score draw");
        scoreText.draw();
        System.out.println("New Game started");
        start(player, GAME_DELAY);
    }

    private void moveObstacles() {

        for (GameObject iterator : objectsList) {
            iterator.moveLeft(HORIZONTAL_SPEED);
        }
    }

    private void drawScore() {
        scoreText.setText(Integer.toString(scoreInt));
        scoreText.translate(0,0);
    }

    private void makePlayerFall() {
        physicsEngine.fall(player);
        player.draw(physicsEngine.getVerticalSpeed());
    }

    private void createNewObstacles() {
        if (objectsList.getLast().getX() < MAX_SCREEN_WIDTH - OBSTACLES_DISTANCE) {
            objectsList.add(new Building());
        }

        if (objectsList.getFirst().getX() < 0 - OBSTACLES_WIDTH) {
            objectsList.removeFirst();
        }
    }

}

