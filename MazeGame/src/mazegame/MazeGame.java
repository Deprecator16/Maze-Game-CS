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
    public static GraphicalDisplay graphics;
    public static GUI gui;
    public static KeyPresses key;
    public static boolean isEnded = false; //True if game has ended
    public static boolean isClosing = false; //True if user wants to exit program
    
    public static Rectangle bTop;
    public static Rectangle bBottom;
    public static Rectangle bLeft;
    public static Rectangle bRight;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException
    {
        graphics = new GraphicalDisplay(); //Init graphics
        gui = new GUI(); //Init GUI
        
        graphics.gUpdates.addKeyListener(gui); //Add key listener
        
        bTop = new Rectangle(0, 0, 400, 8); //Top border
        bBottom = new Rectangle(0, 391, 400, 8); //Bottom border
        bRight = new Rectangle(392, 8, 8, 383); //Right border
        bLeft = new Rectangle(0, 8, 8, 383); //Left border
        
        curMaze.addWall(bTop); //Add top border to maze
        curMaze.addWall(bBottom); //Add bottom border to maze
        curMaze.addWall(bRight); //Add right border to maze
        curMaze.addWall(bLeft); //Add left border to maze
        
        graphics.addRectangle(player.getPlayerRect()); //Add player rectangle to drawing
        graphics.addRectangle(bTop); //Add test rectangle to drawing
        graphics.addRectangle(bBottom); //Add test rectangle to drawing
        graphics.addRectangle(bRight); //Add test rectangle to drawing
        graphics.addRectangle(bLeft); //Add test rectangle to drawing
        
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
            //graphics.repaint(); //Repaint
            break;
            
            case DOWN: player.updatePos(0, 2); //Move player down 2 pixels
            //graphics.repaint(); //Repaint
            break;
            
            case LEFT: player.updatePos(-2, 0); //Move player left 2 pixels
            //graphics.repaint(); //Repaint
            break;
            
            case RIGHT: player.updatePos(2, 0); //Move player right 2 pixels
            //graphics.repaint(); //Repaint
            break;
        }
        
        //Check if player is at end
            //If so, end game
        
        updateCollisions(); //update collisions

        //graphics.repaint(); //Repaint
    }
    
    /** Checks if player has collided with a wall and stops them from passing through it
     * 
     */
    public static void updateCollisions()
    {
        //Loop through all walls and check if player intersects with any
        for (int index = 0; index < curMaze.getNumberOfWalls(); index++)
        {
            //If player intersects with wall
            if (player.getPlayerRect().intersects(curMaze.getWall(index)))
            {
                //Move player back to original position before intersection
                //This is done by moving the character in the opposite direction that the user did
                switch (key)
                {
                    case UP: player.updatePos(0, 2); //Move player down 2 pixels
                    break;

                    case DOWN: player.updatePos(0, -2); //Move player up 2 pixels
                    break;

                    case LEFT: player.updatePos(2, 0); //Move player right 2 pixels
                    break;

                    case RIGHT: player.updatePos(-2, 0); //Move player left 2 pixels
                    break;
                }
            }
        }
    }
    
    /** Chooses a maze from a set of mazes
     * 
     */
    public static void chooseMaze()
    {
        
    }
    
    /** Ends the current game
     * 
     */
    private static void endGame()
    {
        isEnded = true;
    }
    
    /** Ends the program
     * 
     */
    private static void endProgram()
    {
        isClosing = true;
    }
}
