/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * creates movement for block body
 * @author drilz
 */
public class MovingBlock implements StepListener {

    /**
     * calls from block class
     */
    private final Block block;

    /**
     * creates variable dir of integer set to -1
     */
    private int dir = 1;
    
    /**
     *
     * @param block initialises block
     */
    public MovingBlock(Block block) {
        this.block = block;
    }
    
    /**
     *
     * @param e 
     */
    public void preStep(StepEvent e) {
    }

    /**
     * algorithm for self movement of the block
     * @param e performs step every event
     */
    public void postStep(StepEvent e) {
        Vec2 p = block.getPosition();
        
        if (block.getPosition().x > 11.5f) {
            dir = -1;
        } else if (block.getPosition().x < -11.5f) {
            dir = 1;
        } 
        
        block.setPosition(p.sub(new Vec2(-0.1f*dir, 0)));
    }
}
