package org.earthspecialforces.dragonpower.Testers.game;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

/**
 * Created by njsilva on 12/06/2017.
 */
public interface Playable {


    void heroAction(KeyboardEvent keyboardEvent);
    void keyReleased(KeyboardEvent keyboardEvent);
    Playable createHero();

}
