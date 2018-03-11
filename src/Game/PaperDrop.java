 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import city.cs.engine.*;
import java.awt.BorderLayout;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
/**
 * creates main class which will allow the running of code gathered from classes
 * @author drilz
 */

public class PaperDrop {

    /**
     * creates variable level of integer
     */
    private int level;

    /**
     * creates variable lives of integer set to 3
     */
    private int lives = 3;
    
    /**
     * calls from moveobstacle class
     */
    public MoveObstacle move;

    /**
     * calls from moveobstacle2 class
     */
    public MoveObstacle2 move2;

    /**
     * calls from balldrop class
     */
    public BallDrop drop;
    /** The World in which the bodies move and interact. */
    public GameLevel world;
    /** A graphical display of the world (a specialised JPanel). */
    private UserView view;

    /**
     * calls from menuoptions class to allow jpanel to be displayed
     */
    private MenuOptions menu;

    /**
     * calls from soundclip to allow music
     */
    private SoundClip gameMusicL1;

    /**
     * calls from soundclip to allow music for level 2
     */
    private SoundClip gameMusicL2;

    /**
     * calls from soundclip to allow music for level 3
     */
    private SoundClip gameMusicL3;
    
    /**
     * creates method for level 1 to be displayed on a frame and adds various features: music, controls, etc.
     */
    public PaperDrop(){
        level = 1;
        world = new Level1();
        world.populate(this);
        //starts the game
        world.start();
        
        try {
            gameMusicL1 = new SoundClip("data/music.wav");
            gameMusicL1.loop();
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
        
        // make a view
        view = new UserView(world, 500, 500);
        // allows string information to be displayed e.g. lives
        view = new GUI(world, this, 500, 500);
        view.setWorld(world); 
        
        // display the view in a frame
        final JFrame frame = new JFrame("Paper Drop");
        
        // creates new MenuOptions class to allow buttons to be used
        menu = new MenuOptions(this);
        
        // displays buttons north of the screen
        frame.add(menu, BorderLayout.NORTH);
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        
        
        // add controls to the game for positioning first obstacle
        move = new MoveObstacle(world.getObstacle());
        frame.addKeyListener(move); 
        
        // add controls to the game for positioning second obstacle
        move2 = new MoveObstacle2(world.getObstacle2());
        frame.addKeyListener(move2);
        
        // add control to remove ball paltform to allow drop
        drop = new BallDrop(world.getBallPlatform());
        frame.addKeyListener(drop);

        //JFrame debugView = new DebugViewer(world, 500, 500);
    }
    
    /**
     *
     * @return returns game music for level1
     */
    public SoundClip getgameMusicL1(){
        return gameMusicL1;
    }
    
    /**
     *
     * @return returns game music for level2
     */
    public SoundClip getgameMusicL2(){
        return gameMusicL2;
    }
    
    /**
     *
     * @return reutrns game music for level3
     */
    public SoundClip getgameMusicL3(){
        return gameMusicL3;
    }
    
    /**
     *
     * @return returns ball from world
     */
    public PaperBall getBall(){
        return world.getBall();
    }
    
    /**
     *
     * @return returns block from world
     */
    public Block getBlock() {
        return world.getBlock();
    }
    
    /**
     *
     * @return returns obstacle from world
     */
    public Obstacle getObstacle() {
        return world.getObstacle();
    }
    
    /**
     *
     * @return returns obstacle2 from world
     */
    public Obstacle2 getObstacle2() {
        return world.getObstacle2();
    }
    
    /**
     *
     * @return returns ball platform
     */
    public BallPlatform getBallPlatform() {
        return world.getBallPlatform();
    }
    
    /**
     *
     * @return returns bin from world
     */
    public Bin getBin() {
        return world.getBin();
    }
    
    /**
     *
     * @return returns ninjastar from world
     */
    public ninjaStar getNinjaStar() {
        return world.getNinjaStar();
    }
    
    /**
     *
     * @return returns spike from world
     */
    public Spike getSpike() {
        return world.getSpike();
    }
    
    /**
     *
     * @return returns switch obstacle from world
     */
    public SwitchObstacle getSwitchObstacle() {
        return world.getSwitchObstacle();
    }
    
    /**
     *
     * @return returns current level integer
     */
    public int getLevelCount() {
        return level;
    }
    
    /**
     *
     * @return returns world from gamelevel
     */
    public GameLevel getGameLevel() {
        return world;
    }
    
    /**
     *
     * @return returns current lives integer
     */
    public int getLifeCount() {
        return lives;
    }
    
    /**
     * decreases lives count when collision occurs; different out print is displayed based on lifecount
     */
    public void decrementLives() {
        lives--;
        switch (lives) {
            case 0:
                System.out.println("You Have Lost");
                System.exit(0);
            case 1:
                System.out.println("You have: " + lives + " life left");
                break; 
            default:
                System.out.println("You have: " + lives + " lives left");
                break;
        }
    }
    
    /**
     * allows function to shift to next level. Gives control to next set of bodies in further levels and changes music, etc.
     */
    public void nextLevel() {
        // stops the game
        world.stop();
        level++;
        switch (level) {
            case 2:
                // get a new world
                world = new Level2();
                // populates new world with Level2()
                world.populate(this);
                
                move.setObstacle(world.getObstacle());
                move2.setObstacle2(world.getObstacle2());
                drop.setBallDrop(world.getBallPlatform());
                view.setWorld(world);
                
                try {
                    gameMusicL2 = new SoundClip("data/music2.wav");
                    gameMusicL2.loop();
                    gameMusicL1.stop();
                } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                    System.out.println(e);
                }
                
                //JFrame debugView = new DebugViewer(world, 500, 500);
                break;
            case 3:
                // get a new world
                world = new Level3();
                // populates new world with Level3()
                world.populate(this);
                
                move.setObstacle(world.getObstacle());
                drop.setBallDrop(world.getBallPlatform());
                world.addStepListener(new MovingBlock(world.getBlock()));
                view.setWorld(world);
                
                try {
                    gameMusicL3 = new SoundClip("data/music3.wav");
                    gameMusicL3.loop();
                    gameMusicL2.stop();
                } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                    System.out.println(e);
                }
                
                //JFrame debugView = new DebugViewer(world, 500, 500);            
                break;
            default:
                System.out.println("Congratulations, you have completed the game!");
                System.exit(0);
        }
        world.start();
    }
    
    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new PaperDrop();
    }
}
