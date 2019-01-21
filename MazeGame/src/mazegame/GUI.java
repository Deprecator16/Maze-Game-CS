/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Team Lime
 */
public class GUI implements KeyListener
{
    private KeyPresses keyPress = KeyPresses.NONE; //Data to return to MazeGame
    private int key = 0; //Gets keycode
    
    /** Returns the current key being pressed
     * 
     * @return ID of key being pressed
     */
    public KeyPresses getKeyPress()
    {
        return keyPress;
    }

    /** Unused
     * 
     * @param e 
     */
    @Override
    public void keyTyped(KeyEvent e)
    {
        //Unused
    }

    /** Checks if key has been pressed and sets keyPress accordingly
     * 
     * @param e KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent e)
    {
        key = e.getKeyCode(); //Get keycode
        
        //Check what button has been pressed
        if (key == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) //If UP or W key was pressed
        {
            keyPress = KeyPresses.UP; //Set keyPress to UP
        }
        
        if (key == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) //If DOWN or S key was pressed
        {
            keyPress = KeyPresses.DOWN; //Set keyPress to DOWN
        }
        
        if (key == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) //If LEFT or A key was pressed
        {
            keyPress = KeyPresses.LEFT; //Set keyPress to LEFT
        }
        
        if (key == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) //If RIGHT or D key was pressed
        {
            keyPress = KeyPresses.RIGHT; //Set keyPress to RIGHT
        }
    }

    /** Checks if key has been released and updates keyPress accordingly
     * 
     * @param e 
     */
    @Override
    public void keyReleased(KeyEvent e)
    {
        keyPress = KeyPresses.NONE;
    }
    
    /** Constructor
     * 
     */
    public GUI()
    {
        
    }
}
