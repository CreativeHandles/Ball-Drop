/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import city.cs.engine.*;

/**
 * creates ninjastar body
 * @author drilz
 */
public class ninjaStar extends StaticBody{
        
    /**
     * creates variable spike of shape set to circleshape
     */
    private static Shape spike = new CircleShape(1.3f);

    /**
     * creates variable image of bodyimage set to display selected image from data folder
     */
    private BodyImage image = new BodyImage("data/ninjastar.gif", 4);
    
    /**
     * adds image to ninjastar
     * @param world initialises world
     */
    public ninjaStar(World world){
        super(world, spike);
        addImage(image);
    }
 
}
