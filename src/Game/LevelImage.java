/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import city.cs.engine.*;

/**
 * creates image for levels
 * @author drilz
 */
public class LevelImage extends StaticBody{

    /**
     * calls from BodyImage and sets png image to initialised 'image'
     */
    private static final BodyImage image = new BodyImage("data/bin.png", 0.7f);
    
    /**
     *
     * @param world initialises World
     */
    public LevelImage(World world) {
        super(world);
        addImage(image);
    }
}
