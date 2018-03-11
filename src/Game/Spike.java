/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import city.cs.engine.*;

/**
 * creates static body for spike
 * @author drilz
 */
public class Spike extends StaticBody{
        
    /**
     * creates variable spike of shape set to polygonshape
     */
    private static Shape spike = new PolygonShape(-1.282f,-0.637f, 1.166f,-0.637f, 1.158f,0.429f, -1.259f,0.436f);

    /**
     * creates variable image of bodyimage set to selected png image
     */
    private BodyImage image = new BodyImage("data/Spike.png", 2);
    
    /**
     * adds image for spike
     * @param world initialises world
     */
    public Spike(World world){
        super(world, spike);
        addImage(image);
    }
}
