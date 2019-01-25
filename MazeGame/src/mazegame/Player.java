/*
 * Player.java
 */
package mazegame;

import java.awt.*;

/** Player info
 *
 * @author Team Lime
 */
public class Player
{
   private Rectangle player; //Rectangle that the user will control
   
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
   
   /** Returns the rectangle that the user controls
    * 
    * @return player rectangle
    */
   public Rectangle getPlayerRect()
   {
       return player;
   }
   
   /**
    * Constructor
    */
   public Player()
   {
       player = new Rectangle(); //Create rectangle
       setPos(100, 100); //Set position of rectangle
       setSize(4); //Set size of rectangle
   }
}
