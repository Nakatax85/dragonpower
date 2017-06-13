package org.earthspecialforces.dragonpower.input;

import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


/**
 * Created by salvador on 13/06/2017.
 */
public class KeyboardInput implements KeyboardHandler {
    private Keyboard keyboard;
    private Shape [] shapes;
    private boolean pressed = false;

    public KeyboardInput(Shape [] shape) {
        this.keyboard = new Keyboard(this);
        this.shapes = shape;
        setEventPressed(new KeyboardEvent());
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            if(!isPressed()){
                shapes[0].delete();
                shapes[1].delete();
                pressed = true;
            }
            else{

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

    public void setShapes(Shape [] shapes){
        this.shapes = shapes;
    }


}

