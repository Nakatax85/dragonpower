package org.earthspecialforces.dragonpower.screens;

import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.earthspecialforces.dragonpower.game.Constants;

import static org.earthspecialforces.dragonpower.game.Constants.PADDING;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class GameScreen extends Screen {

    public GameScreen(){

        super(new Picture(PADDING,PADDING, "imgs/Satan_City.jpg"));
        super.drawBackground();

    }
}
