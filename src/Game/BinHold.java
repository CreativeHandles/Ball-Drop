/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import city.cs.engine.*;

/**
 * creates bin hold
 * @author drilz
 */
public class BinHold extends StaticBody{
    private static final Shape hold = new BoxShape(0.7f, 0.2f);
    
    /**
     *
     * @param world - initialises the class World
     */
    public BinHold(World world){
        super(world, hold);
    }
}
