package org.earthspecialforces.dragonpower.testers;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.earthspecialforces.dragonpower.screens.Screen.PADDING;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class TestGame {

    private int delay;

    TestPlayer goku;

    Picture background;

    public TestGame(int initialX, int initialY, int delay){
        this.delay = delay;
        background = new Picture(PADDING, PADDING, "imgs/Bckg_2.jpg");
        goku = new TestPlayer(initialX,initialY);
    }

    public void start() throws InterruptedException {

        background.draw();

        Thread.sleep(3000);

        while (true) {

            // Pause for a while
            Thread.sleep(delay);


            goku.draw(5);


        }

    }

}
