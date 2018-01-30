import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Stack;


public class Mouse extends ScrollingEnemy {
  private TiledWorldPathfinding twp;
  private Stack<Point> apath;
  private int walkDelay = -1;
  private final static int WALKDELAY = 40;
  private int searchDelay = -1;
  private final static int SEARCHDELAY = 130;
  private int prevRow = 0;
  private int prevCol = 0;
  /* initilization */
  
   protected void addedToWorld(World w) {
    MazeWorld mw = (MazeWorld) w;
    super.addedToWorld(w);
    twp = new TiledWorldPathfinding
    (mw.getStringWorld(),mw.getValidSpaces());
    prevRow = getY()/mw.getTileWidth();
    prevCol = getX()/mw.getTileWidth();
    setLocation(prevCol*mw.getTileWidth()+mw.getTileWidth()/2,
    prevRow*mw.getTileWidth()+mw.getTileWidth()/2);
  }
  protected void sense() {
    // A* pathfinding determines direction
    if( --searchDelay < 0) {
      MazeWorld w = (MazeWorld) getWorld();
      int hikerCol = w.getXHiker()/w.getTileWidth();
      int hikerRow = w.getYHiker()/w.getTileWidth();
      apath = twp.findShortestFeasiblePath(new
      Point(prevRow,prevCol), new Point(hikerRow,hikerCol));
      if( apath != null && !apath.isEmpty() ) apath.pop();
      searchDelay = SEARCHDELAY;
    }
  }
  protected void reaction() {
    // Move in direction chosen by A* pathfinding
    if( --walkDelay < 0 ) {
      walkDelay = WALKDELAY;
      if( apath != null && !apath.isEmpty() ) {
        Point p = apath.pop();
        MazeWorld w = (MazeWorld) getWorld();
        speedX = (p.col-prevCol) * w.getTileWidth();
        speedY = (p.row-prevRow) * w.getTileWidth();
        prevCol = p.col;
        prevRow = p.row;
      }
    } else {
      speedX = 0;
      speedY = 0;
    }
  }
}