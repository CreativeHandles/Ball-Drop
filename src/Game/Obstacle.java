/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import city.cs.engine.*;
/**
 * creates static body for obstacle
 * @author drilz
 */
public class Obstacle extends StaticBody {

    /**
     * creates variable obstacle of shape set to ppolygonshape
     */
    private static final Shape obstacle = new PolygonShape(-2.26f,0.44f, -2.06f,-1.09f, 2.3f,-0.49f, 2.06f,1.04f);    

    /**
     * creates variable image of bodyimage set to selected png image
     */
    private final BodyImage image = new BodyImage("data/chocobar.png", 3);
    
    /**
     * adds image to obstacle
     * @param world initialises world
     */
    public Obstacle(World world) {
        super(world, obstacle);
        addImage(image);
    }
}
