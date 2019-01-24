/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Team Lime
 */
public class GraphicalDisplay extends JFrame
{
    public Container pane;
    public GraphicalUpdates gUpdates;
    
    /** Add a rectangle to the drawn rectangles
     * 
     * @param rect Rectangle to add
     */
    public void addRectangle(Rectangle rect)
    {
        gUpdates.addRectangle(rect);
    }
    
    /** Remove a rectangle from the list of drawn rectangles
     * 
     * @param indexOfRect 
     */
    public void removeRectangle(int indexOfRect)
    {
        gUpdates.removeRectangle(indexOfRect);
    }
    
    /** Constructor
     * 
     */
    public GraphicalDisplay()
    {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set operation on closing program
        this.setSize(406, 428); //Set window size
        this.setResizable(false);
        this.setTitle("A Random Maze Game"); //Set title of window
        this.setVisible(true); //Show window
        
        pane = this.getContentPane();
        pane.setLayout(new GridLayout(1, 1));
        
        gUpdates = new GraphicalUpdates(400, 400);
        pane.add(gUpdates);
    }
}
