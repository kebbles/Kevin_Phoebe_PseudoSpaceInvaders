//#kevin
package entities;

//import libraries
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Bullet extends Entity {
  
  /***********************************************************************
    * #VARIABLE DICTIONARY
    * public static int width - dimensions of bullet
    * public static int height - dimensions of bullet
    * private static int yVelo - velocity (y axis) of bullet
    * private int dir - direction of bullet
    * private static Image bulletImage - load bullet sprite
    *************************************************************************/
  
 public static int width = 4;
 public static int height = 8;
 private static int yVelo = 10; 
 private int dir;
 private static Image bulletImage = new ImageIcon("shot.png").getImage();
 
 public Bullet(int xLoc, int yLoc, int dir){
  super(xLoc, yLoc);
  this.dir = dir;
 }//end Bullet
 
 @Override
 public void init() {  
 }//end empty method init
 
 //changes speed of bullet
 @Override
 public void update(){
  yLoc += yVelo*dir;
 }//end #method update

 //create bullets
 @Override
 public void draw(Graphics g){  
  g.drawImage(bulletImage, xLoc - 2, yLoc, width*-dir, height, null); 
 }//end #method draw

 @Override
 public void checkCollision(Bullet b) {  
 }//end empty method checkCollision
 
}//end class Bullet
