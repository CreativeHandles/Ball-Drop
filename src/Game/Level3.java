/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * creates level 3
 * @author drilz
 */
public class Level3 extends GameLevel {

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
     * calls from Block class
     */
    private Block block;

    /**
     * calls from SwitchObstacle class
     */
    private SwitchObstacle switchobstacle;
    
    @Override
    public void populate(PaperDrop game) {
        super.populate(game);
        
        // create rectangle obstacle with restituition
        Shape rectBounce = new BoxShape(0.7f, 0.2f);
        
        Body rect = new StaticBody(this, rectBounce);
        content.add(rect);
        rect.setPosition(new Vec2(-7, 3));
        SolidFixture bouncy = new SolidFixture(rect, rectBounce);
        bouncy.setRestitution(0.8f);
        rect.rotateDegrees(-45);
        
        Body rect2 = new StaticBody(this, rectBounce);
        content.add(rect2);
        rect2.setPosition(new Vec2(5, -1));
        SolidFixture bouncy2 = new SolidFixture(rect2, rectBounce);
        bouncy2.setRestitution(0.4f);
        rect2.rotateDegrees(45);
        
        block = new Block(this);
        content.add(block);
        block.setPosition(new Vec2(0, -4));
        
        switchobstacle = new SwitchObstacle(this);
        content.add(switchobstacle);
        switchobstacle.setPosition(new Vec2(-2, -8));
        switchobstacle.rotateDegrees(-45);
                
        // add obstacle to control
        obstacle = new Obstacle(this);
        content.add(obstacle);
        obstacle.setPosition(new Vec2(8, 8));
        obstacle.rotateDegrees(80);

        spike = new Spike(this);
        content.add(spike);
        spike.setPosition(new Vec2(0.5f, -9.5f));
    }
    
    @Override 
    public Vec2 startPosition() {
        return new Vec2(0, 11.5f);
    }
    
    @Override 
    public Vec2 binPosition() {
        return new Vec2(0.5f, -11);
    }
    
    @Override
    public Vec2 holdPosition() {
        return new Vec2(0.5f, -12);
    }
    
    @Override 
    public Vec2 platformPosition() {
        return new Vec2(0, 11);
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
    public Block getBlock(){
        return block;
    }
    
    @Override
    public Spike getSpike() {
        return spike;
    }   
    
    @Override 
    public Obstacle getObstacle() {
        return obstacle;
    }
    
    @Override 
     public Obstacle2 getObstacle2() {
        return obstacle2;
    }
     
    @Override
    public SwitchObstacle getSwitchObstacle() {
        return switchobstacle;
    }
}
