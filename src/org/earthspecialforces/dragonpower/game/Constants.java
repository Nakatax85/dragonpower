package org.earthspecialforces.dragonpower.game;

/**
 * Created by joaorocha on 13/06/2017.
 */
public abstract class Constants {

    //Screen maximum width and height
    public static final int MAX_SCREEN_WIDTH = 800;
    public static final int MAX_SCREEN_HEIGHT = 600;

    //Goku cloud width and height
    public static final int GOKU_HEIGHT = 49;
    public static final int GOKU_WIDTH = 61;

    //Screen padding
    public static final int PADDING = 10;

    //Player's initial position
    public static final int PLAYER_INITIAL_X = 110;
    public static final int PLAYER_INITIAL_Y = 110;

    //Obstacles constants
    //Distance between obstacles
    public static final int OBSTACLES_DISTANCE = 450;



    public enum Direction{
        LEFT,
        RIGHT,
        Up,
        Down
    }
}
