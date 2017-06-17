package org.earthspecialforces.dragonpower.testers;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import java.util.Random;

import static org.earthspecialforces.dragonpower.game.Constants.*;

/**
 * Created by joaorocha on 15/06/2017.
 */
public class TestObstacle {

    //String imagePath = "";

    private Rectangle top;
    private Rectangle gap;
    private Rectangle bottom;

    private double positionX;

    public TestObstacle() {
        positionX = MAX_SCREEN_WIDTH - WIDTH;

        //TODO: Melhorar a geração do numero random
        Random random = new Random();

        top = new Rectangle(positionX, PADDING, WIDTH, random.nextInt(MAX_SCREEN_HEIGHT - (int) GAP_HEIGHT));
        top.setColor(Color.BLUE);
        top.fill();

        gap = new Rectangle(positionX, PADDING + top.getHeight(), WIDTH, GAP_HEIGHT);

        //TODO: Dar um PADDING ao bootom para criar a imagem do chão
        bottom = new Rectangle(positionX, PADDING + top.getHeight() + gap.getHeight(), WIDTH, MAX_SCREEN_HEIGHT - gap.getHeight() - top.getHeight() + PADDING);
        bottom.setColor(Color.BLUE);
        bottom.fill();
    }

    //TODO: Ver se faz sentido tirar o draw para outra class
    public void draw(double distance) {
        top.translate(-distance, 0);
        top.fill();
        gap.translate(-distance, 0);
        bottom.translate(-distance, 0);
        bottom.fill();
    }

    public double getPositionX() {
        return positionX;
    }

    public void moveLeft(double distance) {
        this.positionX = this.positionX - distance;
        draw(distance);
    }

    public Rectangle getTop() {
        return top;
    }
}
