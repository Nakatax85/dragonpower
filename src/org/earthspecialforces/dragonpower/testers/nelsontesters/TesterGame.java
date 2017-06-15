package org.earthspecialforces.dragonpower.testers.nelsontesters;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.earthspecialforces.dragonpower.game.gameEngines.NumGen;
import org.earthspecialforces.dragonpower.game.gameObjects.Building;
import org.earthspecialforces.dragonpower.screens.Screen;

import java.util.ArrayList;
import java.util.Timer;

/**
 * Created by NJSilva on 15/06/2017.
 */
public class TesterGame implements KeyboardHandler {

    public static TesterGame testerGame;
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 800;

    private TesterPlayer goku;
    private TesterBuilding buildings;
    private int ticks, yMovement, score;
    private boolean gameOver, started;
    private int random = NumGen.chooseRandom(10, 790);
    private Screen startScreen;
    private Screen gameScreen;
    private KeyboardHandler keyboard;
    private KeyboardEvent event;
    private Timer timer = new Timer();

    public TesterGame() {
    }

    public void init() {
        gameScreen.drawBackground();
        event.getKey();

        goku = new TesterPlayer();
        buildings = new TesterBuilding();
        buildings.addBuilding(true);
        buildings.addBuilding(true);
        buildings.addBuilding(true);
        buildings.addBuilding(true);

        timer.start();
    }

    public void playerJump() {
        if (gameOver) {
            goku = new TesterPlayer();
            buildings.clear(); //Não faz nada por enquanto mas é para limpar os obstáculos todos do jogo
            yMovement = 0;
            score = 0;

            buildings.addBuilding(true);
            buildings.addBuilding(true);
            buildings.addBuilding(true);
            buildings.addBuilding(true);

            gameOver = false;
        }
        if (!started) {
            started = true;
        } else if (!gameOver) {
            if (yMovement > 0) {
                yMovement = 0;
            }
            yMovement -= 10;
        }
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int speed = 10;
        ticks++;
        if (started) {
            for (int i = 0; i < buildings.getBuildingSize(); i++) {
                Rectangle building = buildings.getBuildings(i);
                building.getX() -= speed;
            }
            if ( ticks % 2 == 0 && yMovement < 15){
                yMovement +=2;
            }

            for (int i = 0; i <buildings.getBuildingSize() ; i++) {
                Rectangle building = buildings.getBuildings(i);

                if (building.getX() + building.getWidth()<0){
                    buildings.
                }
            }
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
