/*
 * MazeGame.java
 */
package mazegame;

import java.awt.Rectangle;
import javax.swing.JFrame;

/** Overarching game class. Contains main()
 * 
 * @author Team Lime
 */
public class MazeGame
{
    public static Player player = new Player(); //Controlled by user
    public static Maze curMaze = new Maze(); //Contains information of maze
    public static GraphicalDisplay graphics; //Graphics and window
    public static GUI gui; //GUI and user controls
    public static KeyPresses key; //Gets current key press
    public static boolean isEnded = false; //True if game has ended
    public static boolean isClosing = false; //True if user wants to exit program
    
    public static Rectangle bTop; //Top border
    public static Rectangle bBottom; //Bottom border
    public static Rectangle bLeft; //Left border
    public static Rectangle bRight; //Right border
    public static Rectangle endPoint; //End of maze
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException
    {
        graphics = new GraphicalDisplay(); //Init graphics
        gui = new GUI(); //Init GUI
        
        graphics.gUpdates.addKeyListener(gui); //Add key listener
        
        endPoint = new Rectangle(200, 391, 8, 8); //End of maze
        bTop = new Rectangle(0, 0, 400, 8); //Top border
        bBottom = new Rectangle(0, 391, 400, 8); //Bottom border
        bRight = new Rectangle(392, 8, 8, 383); //Right border
        bLeft = new Rectangle(0, 8, 8, 383); //Left border
        
        curMaze.addWall(bTop); //Add top border to maze
        curMaze.addWall(bBottom); //Add bottom border to maze
        curMaze.addWall(bRight); //Add right border to maze
        curMaze.addWall(bLeft); //Add left border to maze
        curMaze.addWall(endPoint); //Add end point of maze
        
        graphics.gUpdates.addPlayer(player.getPlayerRect()); //Player rectangle should always be first rectangle in array
        graphics.gUpdates.addEndPoint(endPoint); //End point should always be last rectangle in array
        
        graphics.gUpdates.addRectangle(bTop); //Add top border to graphics. Inserted at one index before the endPoint/last index
        graphics.gUpdates.addRectangle(bBottom); //Add bottom border to graphics. Inserted at one index before the endPoint/last index
        graphics.gUpdates.addRectangle(bRight); //Add right border to graphics. Inserted at one index before the endPoint/last index
        graphics.gUpdates.addRectangle(bLeft); //Add left border to graphics. Inserted at one index before the endPoint/last index
        
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
        if (player.getPlayerRect().intersects(endPoint)) 
        { 
            player.setPos(100, 100); //Reset player
        }
        updateCollisions(); //update collisions
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
