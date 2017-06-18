package org.earthspecialforces.dragonpower.screens;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.earthspecialforces.dragonpower.game.Constants.PADDING;

/**
 * Created by joaorocha on 11/06/2017.
 */
public class StartScreen extends Screen {

    private Picture spaceTextB;
    private Picture logo;

    public StartScreen() {
        super(new Picture(PADDING, PADDING, "imgs/Start_Screen_bckg.jpg"));
        logo = new Picture(260, 200, "imgs/DP_logo.png");
        spaceTextB = new Picture(230,400, "imgs/PRESS SPACE TO START_B.png");
        drawBackground();

    }

    @Override
    public void drawBackground() {
        super.drawBackground();
        logo.draw();
        getSpaceText();
    }

    @Override
    public void clear() {
        super.clear();
        spaceTextB.delete();
    }

    public void getSpaceText() {
        spaceTextB.draw();
    }
}
