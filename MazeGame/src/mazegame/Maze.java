/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Team Lime
 */
public class Maze
{
    private ArrayList<Rectangle> walls; //List of all walls in the maze, including the border
    private ArrayList<Rectangle> doors; //List of all doors between walls in the maze
    private int mazeWidth; //Total width of maze
    private int mazeLength; //Total length of maze
    private int wallWidth; //Thickness of walls
    private int passWidth; //Width of space between walls. Preferred to be the same size as wallWidth
    
    /** Adds a wall to the maze
     * 
     * @param wall adds this rectangle to ArrayList of walls
     */
    public void addWall(Rectangle wall)
    {
        walls.add(wall);
    }
    
    /** Adds a door to the maze
     * 
     * @param door adds this rectangle to ArrayList of doors
     */
    public void addDoor(Rectangle door)
    {
        doors.add(door);
    }
    
    /** Removes wall from ArrayList of walls
     * 
     * @param indexOfWall index of wall to remove
     */
    public void removeWall(int indexOfWall)
    {
        walls.remove(indexOfWall);
    }
    
    /** Removes door from ArrayList of doors
     * 
     * @param indexOfDoor index of door to remove
     */
    public void removeDoor(int indexOfDoor)
    {
        doors.remove(indexOfDoor);
    }
    
    /** Get parameters of the wall at the given index
     * 
     * @param indexOfWall index of wall to get
     */
    public Rectangle getWall(int indexOfWall)
    {
        return walls.get(indexOfWall);
    }
    
    /** Get parameters of the door at the given index
     * 
     * @param indexofDoor index of door to get
     */
    public Rectangle getDoor(int indexofDoor)
    {
        return doors.get(indexofDoor);
    }
    
    /** Constructor
     * 
     */
    public Maze()
    {
        walls = new ArrayList();
        doors = new ArrayList();
        mazeWidth = 800;
        mazeLength = 800;
        wallWidth = 8;
        passWidth = 8;
    }
}