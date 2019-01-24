/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;

/**
 *
 * @author Deprecator16
 */
public class GraphicalUpdates extends Canvas implements Runnable
{
    private ArrayList<Rectangle> rects;
    private Graphics output = null;
    private BufferStrategy buffStrat = null;
    
    private Thread gThread;
    
    /** Begins the graphics thread and process
     * 
     * @param g 
     */
    @Override
    public void paint(Graphics g)
    {
        if (buffStrat == null)
        {
            this.createBufferStrategy(2);
            buffStrat = this.getBufferStrategy();
            output = buffStrat.getDrawGraphics();
            
            gThread.start();
        }
    }

    /** Runs graphics thread
     * 
     */
    @Override
    public void run()
    {
        //Always run till application is closed
        while (true)
        {
            refreshBuffer(); //Get new image
            drawBuffer(); //Display image
            
            Thread.currentThread(); //Access thread
            
            //Force thread to sleep to allow graphics to be displayed
            try
            {
                Thread.sleep(17);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    /** Refresh buffer with new image
     * 
     */
    public void refreshBuffer()
    {
        output = buffStrat.getDrawGraphics(); //Get graphics context
        
        //Attempt to draw image
        try
        {
            output.clearRect(0, 0, this.getSize().width, this.getSize().width); //Clear image
            
            Graphics2D output2D = (Graphics2D)output; //Cast output to Graphics2D for extra functions
            
            //Draw all rectangles inside of ArrayList rects
            for (int index = 0; index < rects.size(); index++)
            {
                //Draw player in different colour. Player should always be first element in array
                if (index == 0)
                {
                    output2D.setColor(Color.red);
                    output2D.fillRect(rects.get(index).x, rects.get(index).y, rects.get(index).width, rects.get(index).height); //Draw Player
                }
                //Draw maze
                else
                {
                    output2D.setColor(Color.black);
                    output2D.fillRect(rects.get(index).x, rects.get(index).y, rects.get(index).width, rects.get(index).height); //Draw wall
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            output.dispose(); //Free resources
        }
    }
    
    /** Show image that is currently in buffer
     * 
     */
    public void drawBuffer()
    {
        buffStrat.show(); //Draw image
        
        Toolkit.getDefaultToolkit().sync(); //Sync
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
     * @param width width of window
     * @param height height of window
     */
    public GraphicalUpdates(int width, int height)
    {
        this.setBounds(0, 0, width, height); //Set dimensions
        
        rects = new ArrayList(); //Initialize ArrayList
        
        gThread = new Thread(this); //Create graphics thread
    }
}
