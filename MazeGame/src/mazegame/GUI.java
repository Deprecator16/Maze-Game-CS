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
    private KeyPresses keyPress = KeyPresses.NONE;

    /** Sets the value for the current key being pressed
     * 
     * @param key ID of key being pressed
     */
    private void setKeyPress(KeyPresses key)
    {
        keyPress = key;
    }
    
    /** Returns the current key being pressed
     * 
     * @return ID of key being pressed
     */
    public KeyPresses getKeyPress()
    {
        return keyPress;
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)
        {
            keyPress = KeyPresses.UP;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)
        {
            keyPress = KeyPresses.DOWN;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)
        {
            keyPress = KeyPresses.LEFT;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
        {
            keyPress = KeyPresses.RIGHT;
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)
        {
            keyPress = KeyPresses.NONE;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)
        {
            keyPress = KeyPresses.NONE;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)
        {
            keyPress = KeyPresses.NONE;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
        {
            keyPress = KeyPresses.NONE;
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /** Constructor
     * 
     */
    public GUI()
    {
        
    }
}
