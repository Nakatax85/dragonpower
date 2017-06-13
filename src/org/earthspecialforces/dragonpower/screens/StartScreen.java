package org.earthspecialforces.dragonpower.screens;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.earthspecialforces.dragonpower.input.KeyboardInput;

/**
 * Created by joaorocha on 11/06/2017.
 */
public class StartScreen {

    public static final int PADDING = 10;

    private Picture background;
    private Text startText;
    private Text spaceText;
    private Shape [] shapes;

    public StartScreen(int numberOfShapes){
        shapes = new Shape[numberOfShapes];

        background = new Picture(PADDING,PADDING, "imgs/Background_wasteland.jpg");
        startText = new Text(330,300,"Welcome to Dragon Power!");
        spaceText = new Text(320,325, "<Press SPACE to START GAME>");

        shapes[0] = startText;
        shapes[1] = spaceText;
        shapes[2] = background;

        shapes[2].draw();
        shapes[0].draw();
        shapes[1].draw();


    }

    public Shape [] getShapes(){
        return shapes;
    }






}
