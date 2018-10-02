//#kevin
package entities;

//import library
import java.awt.Graphics;

public abstract class Entity {
  
  /***********************************************************************
    * VARIABLE DICTIONARY
    * protected boolean die - holds entity dead or alive
    * protected int xLoc - holds current x location of entity
    * protected int yLoc - holds current y location of entity
    *************************************************************************/
  
 protected boolean die;
 protected int xLoc;
 protected int yLoc;

 public Entity(int xLoc, int yLoc) 
 {
  //initialise
  this.xLoc = xLoc;
  this.yLoc = yLoc;
  init();
 }//end Entity
 
 //if entity dies, make die = true
 public void die(){
  die = true;
 }
 
 //if entity dies, remove it buy returning die (true)
 public boolean shouldRemove(){
  return die;
 }

 //get current current x location
 public int getXLoc() {
  return xLoc;
 }

 //get current y location
 public int getYLoc() {
  return yLoc;
 }
 
 public abstract void init();
 
 public abstract void update();
 
 public abstract void draw(Graphics g);
 
 public abstract void checkCollision(Bullet b);
}
