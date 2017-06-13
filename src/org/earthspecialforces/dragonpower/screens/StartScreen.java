package org.earthspecialforces.dragonpower.screens;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by joaorocha on 11/06/2017.
 */
public class StartScreen implements KeyboardHandler {

    public static final int PADDING = 10;
    Picture background;
    Text startText;
    Text spaceText;

    public StartScreen(){

        Keyboard startKeyboard = new Keyboard(this);
        background = new Picture(PADDING,PADDING, "imgs/Background_wasteland.jpg");
        background.draw();

        startText = new Text(330,300,"Welcome to Dragon Power!");
        spaceText = new Text(320,325, "<Press SPACE to START GAME>");
        startText.draw();
        spaceText.draw();


        KeyboardEvent spacePressedEvent = new KeyboardEvent();
        spacePressedEvent.setKey(KeyboardEvent.KEY_SPACE);
        spacePressedEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        startKeyboard.addEventListener(spacePressedEvent);
    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            startText.delete();
            spaceText.delete();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

}
