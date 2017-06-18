package org.earthspecialforces.dragonpower.game;

/**
 * Created by joaorocha on 13/06/2017.
 */
public abstract class Constants {

    //Delay of game
    public static final int GAME_DELAY = 3;

    //Screen maximum width and height
    public static final int MAX_SCREEN_WIDTH = 800;
    public static final int MAX_SCREEN_HEIGHT = 672;

    //Goku cloud width and height
    public static final int GOKU_HEIGHT = 49;
    public static final int GOKU_WIDTH = 61;
    public static final int CLOUD = 8;

    public static final double JUMP_HEIGHT = GOKU_HEIGHT * 0.8;

    //Screen padding
    public static final int PADDING = 10;

    //Player's initial position
    public static final int PLAYER_INITIAL_X = 200;
    public static final int PLAYER_INITIAL_Y = 300;

    //Obstacles constants
    //Distance between obstacles
    public static final int OBSTACLES_DISTANCE = 450;
    public static final int OBSTACLES_WIDTH = 75;
    public static final double GAP_HEIGHT = GOKU_HEIGHT * 2.5;


    //Physics Engine - constants
    public static final int TERMINAL_VELOCITY = 50;
    public static final double GRAVITY = 0.008;
    public static final double HORIZONTAL_SPEED = 1;

    public enum Direction{
        LEFT,
        RIGHT,
        Up,
        Down
    }
}
