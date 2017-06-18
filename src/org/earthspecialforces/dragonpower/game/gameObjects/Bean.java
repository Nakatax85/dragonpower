package org.earthspecialforces.dragonpower.game.gameObjects;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import com.sun.tools.doclets.formats.html.WriterFactoryImpl;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.earthspecialforces.dragonpower.game.Constants;

import java.util.WeakHashMap;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class Bean extends GameObject implements Collectable{
    private boolean collected;
    private boolean hit;
    private int value;
    private boolean rotated;
    private int rotationLimit = 0;
    private Picture p1;
    private Picture p2;
    private boolean disappered = false;


    public Bean (int x, int y,String imagePath){
        super(x,y,new Picture(x,y,imagePath));
        collected = false;
        hit = false;
        value = 1;
        rotated = false;
        p1 = new Picture(100 ,100,imagePath);
        //p2 = new Picture(100,100);
        //p2.translate(400,400);
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
       /* double value = 0;
        if(rotationLimit < 5){
            value = -5;
            super.getGameObjectImage().translate(value,3);
        }
        else if(rotationLimit < 7 ){
            value = 5;
            super.getGameObjectImage().translate(-5,-value);
        }
        else {
            rotationLimit = 0;
        }
        ++rotationLimit;


        System.out.println("getMaxX():" + p1.getMaxX());
        System.out.println("getMaxY():" + p1.getMaxY());

        if(p1.getX() > 0){
            p1.translate(Constants.MAX_SCREEN_WIDTH  ,0);
        }
        else{
            p1.translate(-50,0);
        }

        */
        if(!disappered) {
//            copyColumnPixels(p1,p2);
            int i = 0;
            while (i < p1.pixels()){
                p1.setColorAt(i, Color.MAGENTA);
                ++i;
            }
            p1.grow(100,100);
            //p2.grow(300,300);
            disappered = true;

        }

        p1.draw();
       // p2.draw();




    }

    private void copyColumnPixels(Picture source, Picture destination){
        int start = 0;
        int end = source.getHeight();
        int xPosition = 0;
        int indexX =0;
        int indexY = 0;
        Color color;

        System.out.println("getHeight" + end);




        //i = x
        //j = y
      /*  for (int i = 0; i < 6 ; i++) {
            for (int j = 0; j < source.getHeight() ; j++) {
                color = source.getColorAt(i,j);
                destination.setColorAt(i,j,color);
            }
        }
*/
        destination.setColorAt(1,1,Color.RED);


        System.out.println(source.pixels());
    }



}
