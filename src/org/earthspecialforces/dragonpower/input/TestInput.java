package org.earthspecialforces.dragonpower.input;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.earthspecialforces.dragonpower.screens.GameScreen;
import org.earthspecialforces.dragonpower.screens.StartScreen;

/**
 * Created by codecadet on 13/06/17.
 */
public class TestInput {


    public static void main(String[] args) {
        StartScreen s = new StartScreen(3);
       // GameScreen s2 = new GameScreen(2);

        KeyboardInput ki = new KeyboardInput(s.getShapes());
        //ki.setShapes(s2.getShapes());

    }

}
