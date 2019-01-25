/*
 * GraphicalUpdates.java
 */
package mazegame;

import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;

/** Does graphical calculations and buffering then outputs to window
 *
 * @author Deprecator16
 */
public class GraphicalUpdates extends Canvas implements Runnable
{
    private ArrayList<Rectangle> rects; //Arraylist of all drawn rectangles
    private Graphics output = null; //Graphics component
    private BufferStrategy buffStrat = null; //Used for double buffering
    
    private Thread gThread; //Graphics thread
    
    /** Begins the graphics thread and process
     * 
     * @param g 
     */
    @Override
    public void paint(Graphics g)
    {
        //If double buffering has not been set yet
        if (buffStrat == null)
        {
            this.createBufferStrategy(2); //Create double buffering strategy
            buffStrat = this.getBufferStrategy(); //Set buffer strategy to classes strategy
            output = buffStrat.getDrawGraphics(); //Set graphics component to buffer's graphics
            
            gThread.start(); //Start graphics thread
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
                //Draw end point
                else if (index == rects.size() - 1)
                {
                    output2D.setColor(Color.green);
                    output2D.fillRect(rects.get(index).x, rects.get(index).y, rects.get(index).width, rects.get(index).height); //Draw end point
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
        rects.add(rects.size() - 1, rect);
    }
    
    /** Remove a rectangle from the list of drawn rectangles
     * 
     * @param indexOfRect 
     */
    public void removeRectangle(int indexOfRect)
    {
        rects.remove(indexOfRect);
    }
    
    /** Adds the player rectangle
     * 
     * @param rect player rectangle
     */
    public void addPlayer(Rectangle rect)
    {
        rects.add(rect);
    }
    
    /** Adds the position of the endpoint of the maze
     * 
     * @param rect end point
     */
    public void addEndPoint(Rectangle rect)
    {
        rects.add(rect);
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
