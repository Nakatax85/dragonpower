package org.earthspecialforces.dragonpower.screens;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class Screen {

    public static final int PADDING = 10;
    private Picture background;

    public Screen(Picture background){
        this.background = background;
    }

    public void clear(){
        background.delete();
    }

    public void drawBackground(){
        background.draw();
    }

}
