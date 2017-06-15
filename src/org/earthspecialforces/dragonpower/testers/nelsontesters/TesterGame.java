package org.earthspecialforces.dragonpower.Testers.nelsontesters;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by njsilva on 13/06/2017.
 */
public class TesterGame implements ActionListener, KeyListener {

    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    private Rectangle frame = new Rectangle(10, 10, SCREEN_WIDTH, SCREEN_HEIGHT);
    private Rectangle hero = new Rectangle(200, 200, 20, 20);
    private static final int BUILDING_GAP = SCREEN_HEIGHT / 5;
    private static final int BUILDING_WIDTH = SCREEN_WIDTH / 8, BUILDING_HEIGHT = 4 * BUILDING_WIDTH;
    private static final int UPDATE_DIFFERENCE = 25;
    private static final int X_MOVEMENT_DIFFERENCE = 25;
    private static final int SCRREN_DELAY = 300;


    private boolean loopVar = true;

    private Rectangle buildingFrame;
    private JButton startGame;
    private JPanel topPanel;

    private static TesterGame tg = new TesterGame();
    private static TesterGameScreen gs;

    public TesterGame() {

    }

    public void init() {
        buildFrame();
        init();


    }

    public JPanel startGame() {
        JPanel topPanel = new JPanel();
        topPanel.setBackground(java.awt.Color.BLACK);

        JButton startGame = new JButton("Press SPace to Start");
        startGame.setBackground(java.awt.Color.BLUE);
        startGame.setForeground(java.awt.Color.WHITE);
        startGame.setFocusable(false);
        startGame.setFont(new Font("Arial", Font.BOLD, 42));
        startGame.setAlignmentX(0.5f);
        startGame.setAlignmentY(0.5f);
        startGame.addActionListener((ActionListener) this);

        topPanel.add(startGame);

        TesterGameScreen gs = new TesterGameScreen(SCREEN_WIDTH, SCREEN_HEIGHT, true);

        return topPanel;
    }

    public void buildFrame() {
        frame.setColor(Color.BLACK);
        frame.fill();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startGame()) {
            loopVar = false;

            fadeOperation();
        } else if (e.getSource() == buildComplete) {
            Thread t = new Thread() {
                public void init() {
                    loopVar = true;
                    gameScreen(false);
                }
            };
            t.start();
        }
    }

    private void fadeOperation() {
        Thread t = new Thread() {
            public void init() {
                topPanel.remove(startGame);
                topPanel.remove(gs);
                topPanel.revalidate();
                topPanel.repaint();

                JPanel temp = new JPanel();
                int alpha = 0;
                temp.setBackground(new java.awt.Color(0, 0, 0, alpha));

                topPanel.add(temp);
                topPanel.add(gs);
                topPanel.revalidate();
                topPanel.repaint();

                long currentTime = System.currentTimeMillis();
                long startTime = currentTime;

                while ((System.currentTimeMillis() - startTime) > FADE_TIME_MILLIS || temp.getBackground().getAlpha() != 255) {
                    if ((System.currentTimeMillis() - startTime) > UPDATE_DIFFERENCE / 2) {
                        if (alpha < 255 - 10) {
                            alpha += 10;
                        } else {
                            alpha = 255;
                        }
                        temp.setBackground(new java.awt.Color(0, 0, 0, alpha));

                        topPanel.revalidate();
                        topPanel.repaint();
                        startTime = System.currentTimeMillis();
                    }
                }
                topPanel.removeAll();
                topPanel.add(temp);
                gs = new TesterGameScreen(SCREEN_WIDTH, SCREEN_HEIGHT, false);
                topPanel.add(gs);

                while ((System.currentTimeMillis() - startTime) > UPDATE_DIFFERENCE / 2) {
                    if (alpha > 10) {
                        alpha -= 10;
                    } else {
                        alpha = 0;
                    }
                    temp.setBackground(new java.awt.Color(0, 0, 0, alpha));

                    topPanel.revalidate();
                    topPanel.repaint();
                    startTime = System.currentTimeMillis();
                }
            }

            void actionPerformed(new ActionEvent(buildComplete, -1,"Build Finished"));
        };
        t.start();
    }

    private void gameScreen(boolean isSplash) {
        TesterObsctacle b1 = new TesterObsctacle(BUILDING_WIDTH, BUILDING_HEIGHT);
        TesterObsctacle b2 = new TesterObsctacle(BUILDING_WIDTH, BUILDING_HEIGHT);

        int xLoc1 = SCREEN_WIDTH + SCRREN_DELAY, xLoc2 = (int) ((double) 3.0 / 2.0 * SCREEN_WIDTH + BUILDING_WIDTH / 2.0) + SCRREN_DELAY;
        int yLoc1 = buildingLoc(), yLoc2 = buildingLoc();

        long startTime = System.currentTimeMillis();

        while (loopVar) {
            if ((System.currentTimeMillis() - startTime) > UPDATE_DIFFERENCE) {
                if (xLoc1 < (0 - BUILDING_WIDTH)) {
                    xLoc1 = SCREEN_WIDTH;
                    yLoc1 = buildingLoc();
                } else if (xLoc2 < (0 - BUILDING_WIDTH)) {
                    xLoc2 = SCREEN_WIDTH;
                    yLoc2 = buildingLoc();
                }

                xLoc1 -= X_MOVEMENT_DIFFERENCE;
                xLoc2 -= X_MOVEMENT_DIFFERENCE;

                b1.setxLoc(xLoc1);
                b1.setyLoc(yLoc1);
                b2.setxLoc(xLoc2);
                b2.setyLoc(yLoc2);

                gs.setBuilding(b1, b2);

                topPanel.revalidate();
                topPanel.repaint();

                startTime = System.currentTimeMillis();
            }
        }
    }

    private int buildingLoc() {
        int temp = 0;
        while (temp <= BUILDING_GAP + 50 || temp >= SCREEN_HEIGHT - BUILDING_GAP) {
            temp = (int) ((double) Math.random() * ((double) SCREEN_HEIGHT));
        }
        return temp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
