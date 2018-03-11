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
 * creates collision for spike
 * @author drilz
 */
public class SpikeHit implements CollisionListener{

    /**
     * calls from paperdrop class
     */
    private PaperDrop game;

    /**
     * calls from soundclip class
     */
    private SoundClip spikesound;
    
    /**
     * adds try/catch exception sound effect
     * @param game initialises game
     */
    public SpikeHit(PaperDrop game) {
        this.game = game;
        
        try {
            spikesound = new SoundClip("data/spike.wav");
            spikesound.setVolume(2);
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
    }
    
    /**
     * adds sound for collision hit and gives the ability of a 'respawn' feature
     * @param e collision event for detecting collisions
     */
    @Override
    public void collide(CollisionEvent e) {
        Spike spike = game.getSpike();
        if (e.getOtherBody() == spike) {
            e.getReportingBody().destroy();
            game.decrementLives();
            spikesound.play();
            game.getGameLevel().clear();
            game.getGameLevel().populate(game);
            game.move.setObstacle(game.getObstacle());
            game.move2.setObstacle2(game.getObstacle2());
            game.drop.setBallDrop(game.getBallPlatform());
            if (game.getLevelCount() == 3) {
            game.world.addStepListener(new MovingBlock(game.getBlock()));
            }
        }
    }
}
