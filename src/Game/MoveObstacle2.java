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
 * creates movement for obstacle2
 * @author drilz
 */
public class MoveObstacle2 extends KeyAdapter{

    /**
     * calls from obstacle2 class
     */
    private Obstacle2 obstacle2;
    
    /**
     *
     * @param obstacle2 initialises obstacle2
     */
    public MoveObstacle2(Obstacle2 obstacle2) {
        this.obstacle2 = obstacle2;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {        
        int code = e.getKeyCode();      
        
        if (code == KeyEvent.VK_U){
            obstacle2.rotateDegrees(45);
        } else if (code == KeyEvent.VK_O) {
            obstacle2.rotateDegrees(-45);
        }
        
        if (code == KeyEvent.VK_J) {
            Vec2 p = obstacle2.getPosition();
            obstacle2.setPosition(p.sub(new Vec2(0.5f, 0.0f)));
        } else if (code == KeyEvent.VK_L) {
            Vec2 p = obstacle2.getPosition();
            obstacle2.setPosition(p.sub(new Vec2(-0.5f, 0.0f)));
        }
    }
    
    /**
     * sets obstacles2 to this class 
     * @param obstacle2 initialises obstacles2
     */
    public void setObstacle2(Obstacle2 obstacle2) {
        this.obstacle2 = obstacle2;
    }
}
