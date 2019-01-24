/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Team Lime
 */
public class GraphicalDisplay extends JFrame
{
    private ArrayList<Rectangle> rects;
    private Graphics gBuffer;
    private BufferStrategy buff;
    
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g; //Cast Graphics to Graphics2D for extra functions
        gBuffer = (Graphics2D)gBuffer;
        gBuffer = buff.getDrawGraphics();
        
        super.paint(gBuffer);
        
        gBuffer.clearRect(0, 0, 500, 500);
        gBuffer.dispose();
        
        buff.show();
        //Draw all rectangles inside of ArrayList rects
        for (int index = 0; index < rects.size(); index++)
        {
            //Draw player in different colour. Player should always be first element in array
            if (index == 0)
            {
                gBuffer.setColor(Color.red);
                gBuffer.fillRect(rects.get(index).x, rects.get(index).y, rects.get(index).width, rects.get(index).height);
            }
            else
            {
                gBuffer.setColor(Color.black);
                gBuffer.fillRect(rects.get(index).x, rects.get(index).y, rects.get(index).width, rects.get(index).height);
            }
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
        this.setSize(400, 400); //Set window size
        this.setBounds(0, 0, 400, 400);
        this.setResizable(false);
        this.setTitle("A Random Maze Game"); //Set title of window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set operation on closing program
        this.setVisible(true); //Show window
        
        this.createBufferStrategy(4); //Buffer images
        buff = this.getBufferStrategy();
        gBuffer = buff.getDrawGraphics();
        
        rects = new ArrayList(); //Initialize ArrayList
    }
}
