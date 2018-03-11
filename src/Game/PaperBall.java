/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import city.cs.engine.*;
/**
 * creates dynamic body for paperball
 * @author drilz
 */
public class PaperBall extends DynamicBody{    
   
    /**
     * creates variable paperball of shape set to circleshape
     */
    private static final Shape paperBall = new CircleShape(0.5f);

    /**
     * creates variable image of bodyimage set to selected png image
     */
    private final BodyImage image = new BodyImage("data/paperBall.png", 1);
     
    /**
     * adds image to paperball
     * @param world initialises world
     */
    public PaperBall(World world){
        super(world, paperBall);
        addImage(image);
    }
}
