/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * creates a collision listener for the bin with added sound effect
 * @author drilz
 */
public class BinHit implements CollisionListener{
    private final PaperDrop game;
    private SoundClip binsound;

    /**
     *
     * @param game - initialises the class PaperDrop
     */
    public BinHit(PaperDrop game) {
        this.game = game;

        try {
            binsound = new SoundClip("data/bincollisionhit.wav");
            binsound.setVolume(2);
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
    }
    
    /**
     *
     * @param e - allows collision event with bin
     */
    @Override
    public void collide(CollisionEvent e) {
        Bin bin = game.getBin();
        if (e.getOtherBody() == bin) {
            e.getReportingBody().destroy();
            System.out.println("Level Complete!");
            game.nextLevel();
            binsound.play();
        }
    }
}

