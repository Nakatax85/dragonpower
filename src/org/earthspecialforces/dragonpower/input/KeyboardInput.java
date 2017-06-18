package org.earthspecialforces.dragonpower.input;

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
    private boolean pressed = false;

    public KeyboardInput(Screen screen) {
        keyboard = new Keyboard(this);
        this.screen = screen;

        KeyboardEvent spacePressedEvent = new KeyboardEvent();
        setEventPressed(spacePressedEvent);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            pressed = true;
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

    public boolean isPressed() {
        return pressed;
    }

    public void stopPressed() {
        this.pressed = false;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Screen getScreen() {
        return screen;
    }
}

