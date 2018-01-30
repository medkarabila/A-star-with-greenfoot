import greenfoot.*;
import java.awt.Color.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlueBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueBlock extends ScrollingObstacle
{
    GreenfootImage image = new GreenfootImage(200, 100);
    public BlueBlock(){
        image.setColor(Color.BLUE);
    }
   
}
