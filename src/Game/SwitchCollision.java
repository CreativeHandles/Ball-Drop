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
 * creates collision for switch obstacle
 * @author drilz
 */
public class SwitchCollision implements CollisionListener{

    /**
     * calls from paperdrop class
     */
    private final PaperDrop game;

    /**
     * calls from soundclip class
     */
    private SoundClip switchsound;
    
    /**
     * adds try/catach exception sound effect
     * @param game initialises game
     */
    public SwitchCollision(PaperDrop game) {
        this.game = game;
        
        try {
            switchsound = new SoundClip("data/switch.wav");
            switchsound.setVolume(2);
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
    }
    
    /**
     * adds sound for collision hit and destroys spike to all path to the bin
     * @param e collision event for detecting collisions
     */
    @Override
    public void collide(CollisionEvent e) {
        SwitchObstacle switchobstacle = game.getSwitchObstacle();
        if (e.getOtherBody() == switchobstacle) {
            System.out.println("Path Cleared...");
            game.getSpike().destroy();
            switchsound.play();
        }
    }
}
