/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.*;

/**
 *
 * @author Bassil Virk
 */
public class Player
{
   private Rectangle player;
   
   /** Offsets player position by x,y amount
    * 
    * @param x offset player on the x-axis by x amount
    * @param y offset player on the y-axis by y amount
    */
   public void updatePos(int x, int y)
   {
       player.x += x;
       player.y += y;
   }
   
   /** Sets position of player
    * 
    * @param x set player coordinates to position x on x-axis
    * @param y set player coordinates to position y on y-axis
    */
   public void setPos(int x, int y)
   {
       player.x = x;
       player.y = y;
   }
   
   /** Sets size of player
    * 
    * @param size size of player square
    */
   public void setSize(int size)
   {
       player.setSize(size, size);
   }
   
   /**
    * Constructor
    */
   public Player()
   {
       player = new Rectangle();
       setSize(4);
   }
}
