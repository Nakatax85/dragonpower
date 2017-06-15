package org.earthspecialforces.dragonpower.testers.nelsontesters;

import javafx.scene.paint.Color;
import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import sun.java2d.cmm.ColorTransform;

import javax.swing.*;
import java.awt.*;

/**
 * Created by njsilva on 13/06/2017.
 */
public class TesterGameScreen extends JPanel {

    private int screenWidth, screenHeight;
    private boolean isSplash = true;
    private String message = "Dragon Power";
    private int messageWidth = 0;
    private TesterObsctacle b1, b2;

    public TesterGameScreen(int screenWidth, int screenHeight, boolean isSplash) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.isSplash = isSplash;
    }


    public void screenGFX(Rectangle r) {
        Picture bckg = new Picture(screenWidth, screenHeight, "imgs/Bckg_2.png");
        bckg.draw();

        r = new Rectangle(0, screenHeight * 7 / 8, screenWidth, screenHeight / 8);

        r.setColor(new org.academiadecodigo.simplegraphics.graphics.Color(147, 136, 9));
        r.fill();

        if (b1 != null && b2 != null) {
            b1.getBuildingImage();
            b2.getBuildingImage();
        }


    }


    public void setBuilding(TesterObsctacle b1, TesterObsctacle b2) {
        this.b1 = b1;
        this.b2 = b2;
    }


}
