/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Team Lime
 */
public class GraphicalDisplay extends JFrame
{
    private ArrayList<Rectangle> rects;
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g; //Cast Graphics to Graphics2D for extra functions
        
        //Draw all rectangles inside of ArrayList rects
        for (int index = 0; index < rects.size(); index++)
        {
            g2.fill(rects.get(index));
        }
    }
    
    /** Add a rectangle to the drawn rectangles
     * 
     * @param rect Rectangle to add
     */
    public void addRectangle(Rectangle rect)
    {
        rects.add(rect);
    }
    
    /** Remove a rectangle from the list of drawn rectangles
     * 
     * @param indexOfRect 
     */
    public void removeRectangle(int indexOfRect)
    {
        rects.remove(indexOfRect);
    }
    
    /** Constructor
     * 
     */
    public GraphicalDisplay()
    {
        this.setSize(900, 900); //Set window size
        this.setTitle("A Random Maze Game"); //Set title of window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set operation on closing program
        this.setVisible(true); //Show window
        
        rects = new ArrayList(); //Initialize ArrayList
    }
}
