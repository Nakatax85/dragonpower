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
public class Bean extends GameObject implements Collectable {
    //TODO: Implement Bean class as sub-class of GameObject
    private boolean collected;
    private boolean hit;
    private int value;
    private boolean rotated;
    private int rotationLimit = 0;
    private Picture p1;
    private Picture p2;
    private Picture line;
    private boolean disappered = false;
    private int i = 0;


    public Bean(int x, int y, String imagePath) {
        super(x, y);
        collected = false;
        hit = false;
        value = 1;
        rotated = false;

        p1 = new Picture(100, 100, imagePath);
        p2 = new Picture(100, 100,imagePath);
        line = new Picture(1,p2.getHeight());
        line.translate(400, 400);
        p2.translate(500,500);
    }

    @Override
    public boolean isHit() {
        return hit;
    }

    @Override
    public boolean isCollected() {
        return collected;
    }

    public int getValue() {
        return value;
    }

    public void draw() {
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



        if (!disappered) {
//            copyColumnPixels(p1,p2);

            //System.out.println("White:\nRed: "+Color.WHITE.getRed() +"Green: "+Color.WHITE.getGreen() + "\nBlue:"+Color.WHITE.getBlue());
            System.out.println("GetWith:" + p2.getWidth());
            System.out.println("getMaxX" + p2.getMaxX());
            System.out.println("GetHeight:" + p2.getHeight());
            System.out.println("getMaxY" + p2.getMaxY());



            p2.setColorAt(0,0,Color.RED);
            p2.setColorAt(p2.getWidth() - 1,0,Color.RED);
            p2.setColorAt(0,p2.getHeight() - 1,Color.RED);
            p2.setColorAt(p2.getWidth() - 1 ,p2.getHeight() - 1,Color.RED);

            p1.setColorAt(0,0,p2.getColorAt(0,0));
            //paints p2 a RED

            paintColumn(line,0,Color.RED);

            //p1.grow(100, 100)
            //  p2.grow(100, 100);
            disappered = true;

    }

        copyColumn(p2,line,0 );
        for (int j = 1; j < p2.getWidth() - 1; j++) {
             copyDifferentColumns(p2,p2,j,j-1);
        }
        System.out.println(p2.getWidth());
        System.out.println(line.getWidth());
        copyDifferentColumns(line,p2,0,p2.getWidth() -1 );


       // p1.draw();
        p2.draw();
        line.draw();
}

    private void copyColumnPixels(Picture source, Picture destination) {
        int start = 0;
        int end = source.getHeight();
        int xPosition = 0;
        int indexX = 0;
        int indexY = 0;
        Color color;

        System.out.println("getHeight" + end);


        //i = x
        //j = y
        for (int i = 0; i < 6 ; i++) {
            for (int j = 0; j < source.getHeight() ; j++) {
                color = source.getColorAt(i,j);
                destination.setColorAt(i,j,color);
            }
        }

        destination.setColorAt(1, 1, Color.RED);


        System.out.println(source.pixels());
    }


    private void paintColumn(Picture target,int column,Color color){
        for (int i = 0; i < target.getHeight() ; i++) {
            target.setColorAt(column,i,color);
        }
    }

    private  void copyColumn(Picture source, Picture destination, int column ){
        int height = destination.getHeight();

        for (int i = 0; i < height  ; i++) {
            destination.setColorAt(column,i,source.getColorAt(column,i));
        }
    }

    private  void copyDifferentColumns(Picture source, Picture destination, int columnSource,int columnDestination ){
        int height = destination.getHeight();

        for (int i = 0; i < height  ; i++) {
        //    System.out.println("CopyDifferentColumns:\ni="+i+"\nColumnDestination:"+columnDestination+"\nColumnSource"+columnSource);
            destination.setColorAt(columnDestination,i,source.getColorAt(columnSource,i));
        }
    }

}
