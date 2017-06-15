package org.earthspecialforces.dragonpower.input;

import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.earthspecialforces.dragonpower.game.gameObjects.Player;
import org.earthspecialforces.dragonpower.screens.GameScreen;
import org.earthspecialforces.dragonpower.screens.Screen;
import org.earthspecialforces.dragonpower.screens.StartScreen;


/**
 * Created by salvador on 13/06/2017.
 */
public class KeyboardInput implements KeyboardHandler {
    private Keyboard keyboard;
    private Screen screen;
    private Player player;
    private boolean pressed = false;

    public KeyboardInput(Player player) {
        keyboard = new Keyboard(this);
        //screen = new StartScreen();

        screen = new GameScreen(); //testing gravity

        KeyboardEvent spacePressedEvent = new KeyboardEvent();
        spacePressedEvent.setKey(KeyboardEvent.KEY_SPACE);
        spacePressedEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(spacePressedEvent);
        this.player = player;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            if(screen instanceof StartScreen){
                screen.clear();
                screen = new GameScreen();
            }
            else if (screen instanceof GameScreen){
                player.jump();
            }
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    private void setEventPressed(KeyboardEvent keyboardEvent) {
        keyboardEvent.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);
    }

    private boolean isPressed(){
        return pressed;
    }

    public Keyboard getKeyboard(){
        return keyboard;
    }

    public Screen getScreen() {
        return screen;
    }
}

