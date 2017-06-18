package org.earthspecialforces.dragonpower.game.screens;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class Screen {


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
