/*
 * GraphicalDisplay.java
 */
package mazegame;

import java.awt.*;
import javax.swing.*;

/** Window to display graphics
 *
 * @author Team Lime
 */
public class GraphicalDisplay extends JFrame
{
    public Container pane; //Graphics is shown through this pane
    public GraphicalUpdates gUpdates; //Graphics logic
    
    /** Constructor
     * 
     */
    public GraphicalDisplay()
    {
        super();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set operation on closing program
        this.setSize(406, 428); //Set window size
        this.setResizable(false); //Make sure window is not resized by user
        this.setTitle("A Random Maze Game"); //Set title of window
        this.setVisible(true); //Show window
        
        pane = this.getContentPane(); //Create pane to show images in window
        pane.setLayout(new GridLayout(1, 1));  //Set layout of pane
        
        gUpdates = new GraphicalUpdates(400, 400); //Create graphics logic
        pane.add(gUpdates); //Add graphics component to window
        
        gUpdates.requestFocus(); //Switch focus to game window
    }
}
