package org.earthspecialforces.dragonpower.screens;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.earthspecialforces.dragonpower.input.KeyboardInput;

import static org.earthspecialforces.dragonpower.game.Constants.PADDING;

/**
 * Created by joaorocha on 11/06/2017.
 */
public class StartScreen extends Screen {

    private Text startText;
    private Text spaceText;

    public StartScreen(){
        super(new Picture(PADDING,PADDING, "imgs/StartScreen.jpg"));
        startText = new Text(330,425,"Welcome to Dragon Power!");
        spaceText = new Text(320,450, "<Press SPACE to START GAME>");
        drawBackground();
    }

    @Override
    public void drawBackground(){
        super.drawBackground();
        startText.draw();
        spaceText.draw();
    }

    @Override
    public void clear(){
        super.clear();
        startText.delete();
        spaceText.delete();
    }
}
