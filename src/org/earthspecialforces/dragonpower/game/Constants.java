package org.earthspecialforces.dragonpower.game;

/**
 * Created by joaorocha on 13/06/2017.
 */
public abstract class Constants {

    //Screen maximum width and height
    public static final int MAX_SCREEN_WIDTH = 600;
    public static final int MAX_SCREEN_HEIGHT = 400;

    //Screen padding
    public static final int PADDING = 10;

    //Player's initial position
    public static final int PLAYER_INITIAL_X = 110;
    public static final int PLAYER_INITIAL_Y = 110;

    public enum Direction{
        RIGHT,
        LEFT,
        Up,
        Down
    }


}
