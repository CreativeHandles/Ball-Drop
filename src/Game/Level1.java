/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * creates level 1
 * @author drilz
 */
public class Level1 extends GameLevel {

    /**
     * calls from Obstacle class
     */
    private Obstacle obstacle;

    /**
     * calls from Obstacle class
     */
    private Spike spike;
    
    @Override
    public void populate(PaperDrop game) {
        super.populate(game);
        
        // create obstacle that has restitution attributes
        Shape bounceShape = new BoxShape(1, 2);
        Body bounce = new StaticBody(this, bounceShape);
        content.add(bounce);
        bounce.setPosition(new Vec2(-4.0f, -3));
        SolidFixture bouncy = new SolidFixture(bounce, bounceShape);
        bouncy.setRestitution(1);
        
        // adding obstacle to control
        obstacle = new Obstacle(this);
        content.add(obstacle);
        obstacle.setPosition(new Vec2(5, 3));
        obstacle.rotateDegrees(-8);
        
        spike = new Spike(this);
        content.add(spike);
        spike.setPosition(new Vec2(1, -1));
    }
    
    @Override 
    public Vec2 startPosition() {
        return new Vec2(2, 8);
    }
    
    @Override 
    public Vec2 binPosition() {
        return new Vec2(1, -11);
    }
    
    @Override
    public Vec2 holdPosition() {
        return new Vec2(1, -12);
    }
    
    @Override 
    public Vec2 platformPosition() {
        return new Vec2(2, 7.5f);
    }
    
    @Override 
    public Vec2 heartPosition() {
        return new Vec2(10, 11.7f);
    }
    
    @Override 
    public Vec2 imgPosition() {
        return new Vec2(-12.3f, 11.7f);
    }
    
    
    
    @Override
    public Spike getSpike() {
        return spike;
    }
    
    @Override 
    public Obstacle getObstacle() {
        return obstacle;
    }
}
