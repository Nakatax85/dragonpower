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
        scoreText = new Text(400, 100, Integer.toString(scoreInt));
        scoreText.grow(20,25);
    }

    public void start(Player player, int delay) throws InterruptedException {

        whenSpaceIsPressedStartsGame();

        while (player.isAlive()) {
            // Pause for a while
            Thread.sleep(delay);

            createNewObstacles();
            ifSpaceIsPressedPlayerJumps();
            makePlayerFall();
            moveObstacles();
            showScore();
            checkForCollisions();
        }
        gameOver();

        whenSpaceIsPressedRestartsGame();
    }

    private void whenSpaceIsPressedStartsGame() throws InterruptedException {
        if (screen instanceof StartScreen) {
            while (!k.isPressed()) {
                Thread.sleep(20);
            }
            screen = new GameScreen();
            k.stopPressed();
        }
    }

    private void createNewObstacles() {
        //TODO Create a GameObjects Factory
        if (objectsList.size() <= 0) {
            objectsList.add(new Building());
            showScore();
            return;
        }
        if (objectsList.getLast().getX() < MAX_SCREEN_WIDTH - OBSTACLES_DISTANCE) {
            objectsList.add(new Building());
            showScore();
        }

        if (objectsList.getFirst().getX() < 0 - OBSTACLES_WIDTH) {
            objectsList.removeFirst();
        }
    }

    private void ifSpaceIsPressedPlayerJumps() {
        if (k.isPressed()) {
            player.jump();
            k.stopPressed();
        }
    }

    private void checkForCollisions() {
        if (collisionDetector.checkForCollisions(player, objectsList)) {
            player.hasDied();
        }
    }

    private void makePlayerFall() {
        physicsEngine.fall(player);
        player.draw(physicsEngine.getVerticalSpeed());
    }

    private void moveObstacles() {
        for (GameObject iterator : objectsList) {
            iterator.moveLeft(HORIZONTAL_SPEED);
        }
    }

    private void showScore() {
        if (scoreInt >= 0 && objectsList.getLast().getX() >= MAX_SCREEN_WIDTH - OBSTACLES_WIDTH){
            scoreText.delete();
            scoreText = new Text(400, 100, Integer.toString(scoreInt));
            scoreText.grow(20,25);
            scoreText.draw();
            return;
        }
        if (collisionDetector.playerHasClearedObstacle(objectsList.getFirst(), player)) {
            scoreInt++;
            scoreText.setText(Integer.toString(scoreInt));
            scoreText.translate(0, 0);
            return;
        }

    }

    private void gameOver() throws InterruptedException{
        Picture gameOver = new Picture(250, 100, "imgs/Game Over.png");
        Picture spaceStart = new Picture(230, 300, "imgs/PRESS SPACE TO START_B.png");
        gameOver.draw();
        spaceStart.draw();
        Thread.sleep(2000);
    }

    private void whenSpaceIsPressedRestartsGame() throws InterruptedException {
        while (!k.isPressed()) {
            Thread.sleep(20);
        }
        restartGame();
    }

    private void restartGame() throws InterruptedException {
        screen = new GameScreen();
        k = new KeyboardInput(screen);
        this.player = new Player();
        objectsList = new LinkedList<>();
        scoreText.delete();
        scoreInt = 0;
        scoreText = new Text(400, 100, Integer.toString(scoreInt));
        scoreText.grow(20,25);
        scoreText.draw();
        start(player, GAME_DELAY);
    }
}

