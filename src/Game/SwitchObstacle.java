/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import city.cs.engine.*;
import java.awt.Color;

/**
 * creates switch obstacle body
 * @author drilz
 */
public class SwitchObstacle extends StaticBody {

    /**
     * creates variable switchobstacle of shape set to boxshape
     */
    private static final Shape switchobstacle = new BoxShape(0.7f, 0.2f);
    
    /**
     * sets colour to green
     * @param world initialises world
     */
    public SwitchObstacle(World world) {
        super(world, switchobstacle);
        setFillColor(Color.GREEN);
    }
}
