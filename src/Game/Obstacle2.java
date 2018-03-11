/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import city.cs.engine.*;
/**
 * creates static body for obstacle2
 * @author drilz
 */
public class Obstacle2 extends StaticBody{

    /**
     * creates variable obstacle of shape set to polygonshape
     */
    private static final Shape obstacle2 = new PolygonShape(-2.23f,1.21f, -2.46f,-0.4f, 2.23f,-1.04f, 2.43f,0.59f);

    /**
     * creates variable image of bodyimage set to selected png image
     */
    private final BodyImage image = new BodyImage("data/chocobar2.png", 5);
    
    /**
     * adds image to obstacle body
     * @param world initialises world
     */
    public Obstacle2 (World world) {
        super(world, obstacle2);
        addImage(image);
    }
}
