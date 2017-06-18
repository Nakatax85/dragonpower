package org.earthspecialforces.dragonpower.screens;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.earthspecialforces.dragonpower.game.Constants.MAX_SCREEN_HEIGHT;
import static org.earthspecialforces.dragonpower.game.Constants.PADDING;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class GameScreen extends Screen {

    private Picture ground;
    private String groundImagePath = "imgs/Ground.jpg";

    public GameScreen(){

        super(new Picture(PADDING,PADDING, "imgs/Satan_City.jpg"));
        super.drawBackground();
        ground = new Picture(PADDING, PADDING + MAX_SCREEN_HEIGHT, groundImagePath);
        ground.draw();

    }
}
