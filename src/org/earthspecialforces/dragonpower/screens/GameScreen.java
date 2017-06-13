package org.earthspecialforces.dragonpower.screens;

import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class GameScreen {

    public static final int PADDING = 10;

    private Picture background;
    private Text startText;
    private Text spaceText;
    private Shape[] shapes;

    public GameScreen(int numberOfShapes){
        shapes = new Shape[numberOfShapes];

        background = new Picture(PADDING,PADDING, "imgs/Bckg_2.jpg");
        background.draw();

        startText = new Text(330,300,"Game Screen!");
        spaceText = new Text(320,325, "<Press SPACE to play!>");
        startText.draw();
        spaceText.draw();
        shapes[0] = startText;
        shapes[1] = spaceText;
    }

    public Shape [] getShapes(){
        return shapes;
    }

}
