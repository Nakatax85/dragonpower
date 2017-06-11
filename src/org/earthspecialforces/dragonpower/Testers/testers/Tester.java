package org.earthspecialforces.dragonpower.Testers.testers;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


/**
 * Created by njsilva on 09/06/2017.
 */
public class Tester {
    public static void main(String[] args) {

        Rectangle r = new Rectangle(10,10,1080,720);
        Picture bck = new Picture(10,10,"5090422-wasteland.jpg");
        Rectangle r2 = new Rectangle(500,300,40,40);

        r.setColor(Color.BLACK);
        r.fill();

        bck.draw();
        r2.setColor(Color.WHITE);
        r2.fill();









    }
}
