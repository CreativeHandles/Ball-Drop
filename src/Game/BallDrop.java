/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * allows the ability to remove the ball platform allowing for the ball to reach the end goal
 * @author drilz
 */

public class BallDrop extends KeyAdapter {
    
    private BallPlatform drop;
    
    /**
     *
     * @param drop initialises the class BallPlatform
     */
    public BallDrop(BallPlatform drop) {
        this.drop = drop;
    }
    
    /**
     *
     * @param e allows KeyEvent function; ability to add event to a button press
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();      
        
        if (code == KeyEvent.VK_DOWN) {
            drop.destroy();
            System.out.println("Paper dropped!");
        }
    }
    // sets ball drop 
    public void setBallDrop(BallPlatform drop){
        this.drop = drop;
    }
}
