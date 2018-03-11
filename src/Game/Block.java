/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import city.cs.engine.*;
import java.awt.Color;
/**
 * creates block which will become moving obstacle
 * @author drilz
 */
public class Block extends StaticBody {
    private static final Shape block = new BoxShape(2, 0.2f);
    
    /**
     *
     * @param world - initialises the class World
     */
    public Block(World world){
        super(world, block);
        setFillColor(Color.RED);
    }
}
