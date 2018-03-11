/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.jbox2d.common.Vec2;
/**
 * creates movement for obstacle
 * @author drilz
 */
public class MoveObstacle extends KeyAdapter{

    /**
     * calls from obstacle class
     */
    private Obstacle obstacle;
    
    /**
     *
     * @param obstacle initialises obstacle
     */
    public MoveObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {        
        int code = e.getKeyCode();      
        
        if (code == KeyEvent.VK_Q){
            obstacle.rotateDegrees(45);
        } else if (code == KeyEvent.VK_E) {
            obstacle.rotateDegrees(-45);
        }
        
        if (code == KeyEvent.VK_A) {
            Vec2 p = obstacle.getPosition();
            obstacle.setPosition(p.sub(new Vec2(0.5f, 0.0f)));
        } else if (code == KeyEvent.VK_D) {
            Vec2 p = obstacle.getPosition();
            obstacle.setPosition(p.sub(new Vec2(-0.5f, 0.0f)));
        }
    }
    
    /**
     *
     * @param obstacle initialises obstacle
     */
    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }
}
