package org.earthspecialforces.dragonpower.testers.nelsontesters;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.earthspecialforces.dragonpower.game.gameEngines.NumGen;
import org.earthspecialforces.dragonpower.game.gameObjects.Building;

/**
 * Created by NJSilva on 15/06/2017.
 */
public class TesterGame implements KeyboardHandler {

    public static TesterGame testerGame;
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 800;

    private TesterPlayer goku;
    private Building[] buildings;
    private int ticks, yMovement, score;
    private boolean gameOver, started;
    private int random = NumGen.chooseRandom(10,790);

    public TesterGame(){
    }

    public void init(){

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
