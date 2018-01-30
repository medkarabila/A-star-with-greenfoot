import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScrollingEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract public class ScrollingEnemy extends ScrollingActor {  protected static final int SPEED = 1;
  private static final int BOUNDARY = 40;
  protected int speedX = SPEED;
  protected int speedY = SPEED;
  protected void addedToWorld(World w) {
    MazeWorld mw = (MazeWorld) w;
    GreenfootImage img = getImage();
    img.scale(mw.getTileWidth(),mw.getTileHeight());
    setImage(img);
  }
  public void act() {
    sense();
    reaction();
    boundedMove();
  }
  protected void sense() {
    // No smarts
  }
  protected void reaction() {
    // No reaction
  }
  protected void boundedMove() {
    setLocation(getX()+speedX, getY()+speedY);
    if( isTouching(ScrollingObstacle.class) ) {
      setLocation(getX()-speedX, getY()-speedY);
    }
  }
}