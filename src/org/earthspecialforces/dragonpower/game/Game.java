package org.earthspecialforces.dragonpower.game;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.earthspecialforces.dragonpower.game.gameEngines.CollisionDetector;
import org.earthspecialforces.dragonpower.game.gameEngines.PhysicsEngine;
import org.earthspecialforces.dragonpower.game.gameObjects.Obstacle;
import org.earthspecialforces.dragonpower.game.gameObjects.GameObject;
import org.earthspecialforces.dragonpower.input.KeyboardInput;
import org.earthspecialforces.dragonpower.game.screens.GameScreen;
import org.earthspecialforces.dragonpower.game.screens.Screen;
import org.earthspecialforces.dragonpower.game.screens.StartScreen;

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
    private CollisionDetector collisionDetector;

    /**
     * Starts the game, instantiating all its properties and saving the player
     * that is going to play the game
     *
     */
    public Game() {
        screen = new StartScreen();
        k = new KeyboardInput(screen);
        physicsEngine = new PhysicsEngine();
        this.player = new Player();
        objectsList = new LinkedList<>();
        collisionDetector = new CollisionDetector();
        scoreInt = 0;
        scoreText = new Text(400, 100, Integer.toString(scoreInt));
        scoreText.grow(20,25);
    }

    /**
     * Starts the game
     *
     * @throws InterruptedException - Because it uses the Thread.sleep method to
     * implement some delay while refreshing the game's screen.
     */
    public void start() throws InterruptedException {

        whenSpaceIsPressedChangesToGameScreen();

        while (player.isAlive()) {
            // Pause for a while
            Thread.sleep(GAME_DELAY);

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

    /**
     * Only when SPACE is pressed the GameScreen is initialized.
     *
     * @throws InterruptedException
     */
    private void whenSpaceIsPressedChangesToGameScreen() throws InterruptedException {
        if (screen instanceof StartScreen) {
            while (!k.isPressed()) {
                Thread.sleep(20);
            }
            screen = new GameScreen();
            k.stopPressed();
        }
    }

    /**
     * Creates the Obstacles of the game
     * If there are no Obstacles yet, creates the first one and adds it to the Obstacles List.
     *
     * If the last object in the screen has reached the distance between Obstacles,
     * (which is set in Constants.class), it creates a new Obstacle and adds it to the Obstacles List.
     *
     * When the first Obstacle of the list has left the Screen, it is removed from the Obstacles List.
     *
     */
    private void createNewObstacles() {
        //TODO Create a GameObjects Factory
        if (objectsList.size() <= 0) {
            objectsList.add(new Obstacle());
            showScore();
            return;
        }
        if (objectsList.getLast().getX() < MAX_SCREEN_WIDTH - OBSTACLES_DISTANCE) {
            objectsList.add(new Obstacle());
            showScore();
        }

        if (objectsList.getFirst().getX() < 0 - OBSTACLES_WIDTH) {
            objectsList.removeFirst();
        }
    }

    /**
     * Makes the player jump if the space is pressed.
     */
    private void ifSpaceIsPressedPlayerJumps() {
        if (k.isPressed()) {
            player.jump();
            k.stopPressed();
        }
    }

    /**
     * Uses the CollisionDetector.class to check for collisions between
     * the instance of Player and all Obstacles in the Screen.
     */
    private void checkForCollisions() {
        if (collisionDetector.checkForCollisions(player, objectsList)) {
            player.hasDied();
        }
    }

    /**
     * Uses the PhysicsEngine.class to make the Player fall
     */
    private void makePlayerFall() {
        physicsEngine.fall(player);
        player.draw(physicsEngine.getVerticalSpeed());
    }

    /**
     * Moves all Obstacles on the Screen (inside the Obstacles List)
     */
    private void moveObstacles() {
        for (GameObject iterator : objectsList) {
            iterator.moveLeft(HORIZONTAL_SPEED);
        }
    }

    /**
     * Prints the score, and updates it when required
     */
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

    /**
     * Prints the Game Over screen
     *
     * @throws InterruptedException
     */
    private void gameOver() throws InterruptedException{
        Picture gameOver = new Picture(250, 100, "imgs/Game Over.png");
        Picture spaceStart = new Picture(230, 300, "imgs/PRESS SPACE TO START_B.png");
        gameOver.draw();
        spaceStart.draw();
        Thread.sleep(1000);
    }

    /**
     * Restarts the Game when SPACE is pressed
     *
     * @throws InterruptedException
     */
    private void whenSpaceIsPressedRestartsGame() throws InterruptedException {
        while (!k.isPressed()) {
            Thread.sleep(20);
        }
        restartGame();
    }

    /**
     * Sets all properties of Game.class to its initial values and starts a new game.
     *
     * @throws InterruptedException
     */
    private void restartGame() throws InterruptedException {
        screen = new GameScreen();
        k.setGameScreen();
        this.player = new Player();
        objectsList.clear();
        scoreText.delete();
        scoreInt = 0;
        scoreText = new Text(400, 100, Integer.toString(scoreInt));
        scoreText.grow(20,25);
        scoreText.draw();
        start();
    }
}

