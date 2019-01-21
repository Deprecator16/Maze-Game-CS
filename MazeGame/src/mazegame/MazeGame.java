/*
 * MazeGame.java
 */
package mazegame;

import java.awt.Rectangle;
import javax.swing.JFrame;

/**
 * 
 * @author Team Lime
 */
public class MazeGame
{
    public static Player player = new Player(); //Controlled by user
    public static Maze curMaze = new Maze(); //Contains information of maze
    public static boolean isEnded = false; //True if game has ended
    public static boolean isClosing = false; //True if user wants to exit program
    public static GraphicalDisplay graphics;
    public static GUI gui;
    public static KeyPresses key;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException
    {
        graphics = new GraphicalDisplay(); //Init graphics
        gui = new GUI();
        
        Rectangle b1 = new Rectangle(100, 100, 200, 8); //Test rectangle
        
        graphics.addRectangle(b1);
        graphics.addRectangle(player.getPlayerRect()); //Add player rectangle to drawing
        
        graphics.addKeyListener(gui);
        graphics.createBufferStrategy(3); //Buffer images
        
        //Run overarching program
        while (!isClosing)
        {   
            //Display GUI
        
        
            //Run game loop
            while (!isEnded)
            {
                gameLoop(); //Run game loop
                Thread.sleep(17); //Delay loop to approx. 60 executions per second
            }
        }
    }
    
    /** Runs entire game loop
     * 
     */
    public static void gameLoop()
    {
        key = gui.getKeyPress(); //Check for button press
        
        //Update player position
        switch (key)
        {
            case UP: player.updatePos(0, -2); //Move player up 2 pixels
            break;
            
            case DOWN: player.updatePos(0, 2); //Move player down 2 pixels
            break;
            
            case LEFT: player.updatePos(-2, 0); //Move player left 2 pixels
            break;
            
            case RIGHT: player.updatePos(2, 0); //Move player right 2 pixels
            break;
        }
        
        //Check if player is at end
            //If so, end game
        
        
        //Otherwise, update collisions
        
        //Repaint
        graphics.repaint();
    }
    
    /** Checks if player has collided with a wall and stops them from passing through it
     * 
     */
    public static void updateCollision()
    {
        
    }
    
    /** Ends the game
     * 
     */
    private static void endGame()
    {
        isEnded = true;
    }
    
    private static void endProgram()
    {
        isClosing = true;
    }
}
