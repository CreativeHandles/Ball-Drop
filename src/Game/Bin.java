/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import city.cs.engine.*;
/**
 * creates the bin body
 * @author drilz
 */
public class Bin extends DynamicBody{
        
    private static final BodyImage image = new BodyImage("data/bin.png", 2);
    
    /**
     *
     * @param world - initialises the class World
     */
    public Bin(World world){
            super(world);
            // adds image to replace original body shape
            addImage(image);
            
            Shape leftSideBin = new PolygonShape(-0.431f,0.414f, -0.262f,-0.437f, -0.276f,-0.437f, -0.447f,0.414f);
            Fixture leftSideFixture = new SolidFixture(this, leftSideBin);
            
            Shape rightSideBin = new PolygonShape(0.421f,0.408f, 0.252f,-0.434f, 0.268f,-0.444f, 0.439f,0.405f);
            Fixture rightSideFixture = new SolidFixture(this, rightSideBin);
        }
        
}
