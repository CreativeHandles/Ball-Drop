/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * creates level 2
 * @author drilz
 */
public class Level2 extends GameLevel {

    /**
     * calls from Obstacle class 
     */
    private Obstacle obstacle;

    /**
     * calls from Obstacle2 class
     */
    private Obstacle2 obstacle2;

    /**
     * calls from Spike class
     */
    private Spike spike;

    /**
     * calls from ninjaStar class
     */
    private ninjaStar ninjastar;
    
    @Override
    public void populate(PaperDrop game) {
        super.populate(game);
        
        // create obstacle that has restitution attributes
        Shape bounceShape = new BoxShape(0.5f, 1);
        
        Body bounce = new StaticBody(this, bounceShape);
        content.add(bounce);
        bounce.setPosition(new Vec2(-4, -10));
        SolidFixture bouncy = new SolidFixture(bounce, bounceShape);
        bouncy.setRestitution(0.5f);
        
        Body bounce2 = new StaticBody(this, bounceShape);
        content.add(bounce2);
        bounce2.setPosition(new Vec2(0, -9));
        SolidFixture bouncy2 = new SolidFixture(bounce2, bounceShape);
        bouncy2.setRestitution(0.7f);
        
        // create rectangle obstacle with restituition
        Shape rectBounce = new BoxShape(0.7f, 0.2f);
        
        Body rect = new StaticBody(this, rectBounce);
        content.add(rect);
        rect.setPosition(new Vec2(5, -7));
        SolidFixture bouncy3 = new SolidFixture(rect, rectBounce);
        bouncy3.setRestitution(0.5f);
        rect.rotateDegrees(45);
        
        // add obstacle to control
        obstacle = new Obstacle(this);
        content.add(obstacle);
        obstacle.setPosition(new Vec2(-5, 1));
        obstacle.rotateDegrees(-9);
        
        // moving obstacle 2 in this level only
        obstacle2 = new Obstacle2(this);
        content.add(obstacle2);
        obstacle2.setPosition(new Vec2 (-5, 6));
        obstacle2.rotateDegrees(8);
        
        spike = new Spike(this);
        content.add(spike);
        spike.setPosition(new Vec2(2.5f, -8));
        
        ninjastar = new ninjaStar(this);
        content.add(ninjastar);
        ninjastar.setPosition(new Vec2(-2, -9.5f));
    }
    
    @Override 
    public Vec2 startPosition() {
        return new Vec2(5, 10);
    }
    
    @Override 
    public Vec2 binPosition() {
        return new Vec2(-9.5f, -11);
    }
    
    @Override
    public Vec2 holdPosition() {
        return new Vec2(-9.5f, -12);
    }
    
    @Override 
    public Vec2 platformPosition() {
        return new Vec2(5, 9.5f);
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
    public ninjaStar getNinjaStar() {
        return ninjastar;
    }
    
    @Override 
    public Obstacle getObstacle() {
        return obstacle;
    }
    
    @Override 
     public Obstacle2 getObstacle2() {
        return obstacle2;
    }
}
