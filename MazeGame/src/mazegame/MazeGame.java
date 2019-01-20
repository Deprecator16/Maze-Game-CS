/*
 * MazeGame.java
 */
package mazegame;

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
    public static GraphicalDisplay g;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        g = new GraphicalDisplay();
        
        //Run overarching program
        while (!isClosing)
        {
            //Display GUI
        
        
            //Run game loop
            while (!isEnded)
            {
                gameLoop();
            }

            //Display GUI
            
            
        }
    }
    
    /** Runs entire game loop
     * 
     */
    public static void gameLoop()
    {
        //Check for button press from GUI class
        
        
        //Update player position
        
        
        //Check if player is at end
            //If so, end game
        
        
        //Otherwise, update collisions
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
