/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import city.cs.engine.*;
import java.util.ArrayList;
import org.jbox2d.common.Vec2;
/*
 *
 * @author drilz
 */

/**
 * creates skeleton for the 3 levels created. holds the bodies that are used in all the levels.
 * @author drilz
 */

public abstract class GameLevel extends World {

    /**
     * calls from papaerball class
     */
    private PaperBall ball;

    /**
     * calls from bin class
     */
    private Bin bin;

    /**
     * calls from livesimage class
     */
    private LivesImage heart;

    /**
     * calls from levelimage class
     */
    private LevelImage img;

    /**
     * calls from binhold class
     */
    private BinHold hold;

    /**
     * calls from spike class
     */
    private Spike spike;

    /**
     * calls from injastar class
     */
    private ninjaStar ninjastar;

    /**
     * calls from ballplatform class
     */
    private BallPlatform holder;

    /**
     * calls from obstacle class
     */
    private Obstacle obstacle;

    /**
     * calls from obstacle2 class
     */
    private Obstacle2 obstacle2;

    /**
     * calls from block class
     */
    private Block block;

    /**
     * calls from switch obstacle class
     */
    private SwitchObstacle switchobstacle;
    
    /**
     * creates variable content of arraylist containing Body
     */
    ArrayList<Body> content = new ArrayList<>();
    
    /**
     * creates base for populating other levels
     * @param game - initialises the class PaperDrop
     */
    public void populate(PaperDrop game) {     
        bin = new Bin(this);
        content.add(bin);
        bin.setPosition(binPosition());
        
        hold = new BinHold(this);
        content.add(hold);
        hold.setPosition(holdPosition());
        
        ball = new PaperBall(this);
        ball.setPosition(startPosition());
        ball.addCollisionListener(new SpikeHit(game));
        ball.addCollisionListener(new ninjaStarHit(game));
        ball.addCollisionListener(new BinHit(game));
        ball.addCollisionListener(new SwitchCollision(game));
        
        holder = new BallPlatform(this);
        holder.setPosition(platformPosition());
        
        heart = new LivesImage(this);
        heart.setPosition(heartPosition());
        
        img = new LevelImage(this);
        img.setPosition(imgPosition());
    }
    
    /**
     * creates loop for destroying bodies held in arraylist
     */
    public void clear(){
        for(Body b : content) {
            b.destroy();
        }
    }
    
    /**
     *
     * @return returns heart image
     */
    public LivesImage getLivesImage() {
        return heart;
    }
    
    /**
     *
     * @return returns level image 
     */
    public LevelImage getLevelImage() {
        return img;
    }
    
    /**
     *
     * @return returns bin platform hold
     */
    public BinHold getBinHold() {
        return hold;
    }
    
    /**
     *
     * @return returns moving block
     */
    public Block getBlock() {
       return block; 
    }
    
    /**
     *
     * @return returns ninja star
     */
    public ninjaStar getNinjaStar() {
        return ninjastar;
    }
    
    /**
     *
     * @return returns spike 
     */
    public Spike getSpike() {
        return spike;
    }
    
    /**
     *
     * @return returns ball 
     */
    public PaperBall getBall() {
        return ball;
    }
    
    /**
     *
     * @return returns bin
     */
    public Bin getBin() {
        return bin;
    }
    
    /**
     *
     * @return returns obstacle
     */
    public Obstacle getObstacle() {
        return obstacle;
    }
    
    /**
     *
     * @return returns second obstacle
     */
    public Obstacle2 getObstacle2() {
        return obstacle2;
    }
    
    /**
     *
     * @return returns ball platform
     */
    public BallPlatform getBallPlatform() {
        return holder;
    }
    
    /**
     *
     * @return returns switch obstacle
     */
    public SwitchObstacle getSwitchObstacle() {
        return switchobstacle;
    }
    
    /**
     *
     * @return returns start position of the ball
     */
    public abstract Vec2 startPosition();
    
    /**
     *
     * @return returns bin position
     */
    public abstract Vec2 binPosition();
        
    /**
     *
     * @return returns ball platform position
     */
    public abstract Vec2 platformPosition();   
    
    /**
     *
     * @return returns bin platform position
     */
    public abstract Vec2 holdPosition();
    
    /**
     *
     * @return returns heart image position
     */
    public abstract Vec2 heartPosition();
    
    /**
     *
     * @return returns level image position
     */
    public abstract Vec2 imgPosition();
}
