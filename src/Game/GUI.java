/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import city.cs.engine.*;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * creates GUI for showcase of lives, level and background image
 * @author drilz
 */
public class GUI extends UserView{
    private final PaperDrop game;
    private final Image background;
    
    /**
     *
     * @param world - initialises the class World
     * @param game - initialises the class PaperDrop
     * @param width - initialises width to an integer value
     * @param height - initialises height to an integer value
     */
    public GUI(World world, PaperDrop game, int width, int height) {
        super(world, width, height);
        this.game = game;
        
        background = new ImageIcon("data/background.jpg").getImage(); 
    }
    
    /**
     *
     * @param g - initialises Graphics2D
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0 ,0, this);
    }
    
    /**
     *
     * @param g - initialises Graphics2D
     */
    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawString("Level: " + game.getLevelCount(), 25, 20);
        g.drawString("Lives: " + game.getLifeCount(), 470, 20);
    }
}
