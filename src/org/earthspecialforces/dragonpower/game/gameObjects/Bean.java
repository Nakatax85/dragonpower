package org.earthspecialforces.dragonpower.game.gameObjects;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import com.sun.tools.doclets.formats.html.WriterFactoryImpl;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
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


    private Rectangle rectangle;
    private Rectangle rectangle2;
    private Rectangle rectangle3;

    private Line line;
    private Line line1;
    private Line line2;
    private boolean disappered = false;
    private int i = 0;


    public Bean(int x, int y, String imagePath) {
        super(x, y);
        collected = false;
        hit = false;
        value = 1;
        rotated = false;

        rectangle = new Rectangle(100,100,100,100);
        rectangle.setColor(Color.RED);
        rectangle2 = new Rectangle(200,100,100,100);
        rectangle2.setColor(Color.BLUE);
        rectangle3 = new Rectangle(300,100,100,100);
        rectangle3.setColor(Color.RED);


        line = new Line (100,100,120,100);
        line1 = new Line (100,101,120,101);
        line2 = new Line (100,102,120,102);


        line.setColor(Color.WHITE);
        line2.setColor(Color.WHITE);
        line.setColor(Color.WHITE);

        p1 = new Picture(100, 100, imagePath);
        p2 = new Picture(0, 0,imagePath);
        line.translate(p2.getWidth(), 400);
        line1.translate(p2.getWidth(),400);
        line2.translate(p2.getWidth(),400);

        p2.translate(0,400);
        p2.draw();
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
/*
       rectangle.translate(-5,0);
       rectangle2.translate(-5,0);
       rectangle3.translate(-5,0);

       if(rectangle.getX() < 0 && rectangle.getX() + rectangle.getWidth() < 0){
           rectangle.translate(Constants.MAX_SCREEN_WIDTH ,0);
       }

       if( rectangle2.getX() < 0 && rectangle2.getX() + rectangle2.getWidth() < 0){
            rectangle2.translate(Constants.MAX_SCREEN_WIDTH,0);
       }

        if( rectangle3.getX() < 0 && rectangle3.getX() + rectangle3.getWidth() < 0){
            rectangle3.translate(Constants.MAX_SCREEN_WIDTH ,0);
        }
*/
       //working code//
       /* copyDifferentColumns(p2,p2,0,p2.getWidth()-1);
        for (int j = 1; j < p2.getWidth() ; j++) {
             copyDifferentColumns(p2,p2,j,j-1);
        }*/


        line.translate(-10,0);
        line1.translate(-10,0);
        line2.translate(-10,0);

        if(line.getX() + line.getWidth() < 0){
            line.translate(p2.getWidth() ,0);
        }

        if(line1.getX() + line1.getWidth() < 0){
            line1.translate(p2.getWidth() ,0);
        }
        if(line2.getX() + line2.getWidth() < 0){
            line2.translate(p2.getWidth() ,0);
        }

        line.draw();
        line1.draw();
        line2.draw();

      //  p2.draw();
        //line.draw();
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
