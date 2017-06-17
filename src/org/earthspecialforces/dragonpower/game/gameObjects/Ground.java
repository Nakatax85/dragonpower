package org.earthspecialforces.dragonpower.game.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.earthspecialforces.dragonpower.game.Constants.MAX_SCREEN_HEIGHT;
import static org.earthspecialforces.dragonpower.game.Constants.PADDING;

/**
 * Created by joaorocha on 17/06/2017.
 */
public class Ground extends GameObject implements Crashable{

    private Picture ground;
    private String groundImagePath = "imgs/Ground.png";

    public Ground(){
        super(PADDING,PADDING+MAX_SCREEN_HEIGHT);
        ground = new Picture(super.getPositionX(),super.getPositionY(),groundImagePath);
        ground.draw();
    }

    public void draw(double distance){
        //ground.translate(-distance,0);
        ground.draw();
    }

    @Override
    public void moveLeft(double distance) {
        //super.moveLeft(distance);
        draw(distance);
    }

    @Override
    public void isHit() {

    }
}
