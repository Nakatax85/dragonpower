package org.earthspecialforces.dragonpower.game.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class Bean extends GameObject implements Collectable{
    private boolean collected;
    private boolean hit;
    private int value;

    public Bean (int x, int y,String imagePath){
        super(x,y,new Picture(x,y,imagePath));
        collected = false;
        hit = false;
        value = 1;
    }

    @Override
    public boolean isHit() {
        return hit;
    }

    @Override
    public boolean isCollected() {
        return collected;
    }

    public int getValue(){
        return value;
    }

    public void draw(){

        //super.getGameObjectImage().grow(-10,-10);
        super.draw();
    }



}
