//#kevin 
package entities;

//import libraries
import java.awt.*;
import javax.swing.*;
import gui.Game;

//aliens are inherited from Entity class #variable
public class Alien extends Entity{
  
  /***********************************************************************
    *  #VARIABLE DICTIONARY
    *  private static int width -width of the alien entity
    *  private static int height - height of the alien entity
    *  private static int widthMovement - INITIAL MOVEMENT
    *  private static int heightMovement - INITIAL MOVEMENT (HEIGHT)
    *  private int direction - direction aliens move in
    *  private static Image image - load alien image
    *  private int initialMovementDelay - initial movement delay of the alien
    *  private int movementDelay - movement delay of the alien
    *  private int timesMoved - number of times aliens shift over
    *  private Game game - game which this exists in
    *  private boolean shouldShoot - whether or not the alien can shoot
    *************************************************************************/
  
  private static int width = 30; 
  private static int height = 20; 
  private static int widthMovement = 10; 
  private static int heightMovement = 10;
  private int direction = 1;
  private static Image image = new ImageIcon("alien.png").getImage();
  private int initialMovementDelay;
  private int movementDelay;
  private int timesMoved;
  private Game game;
  private boolean shouldShoot;
  
  /*
   * This is the constructor of the Alien class. The constructor
   * takes in x and y locations of the individual alien.
   * xLoc - the x location of the Alien
   * yLoc - the y location of the Alien
   */
  public Alien(Game game, int xLoc, int yLoc){
    super(xLoc, yLoc);
    this.game = game;
  }//end Alien
  
  //initialise the movement delay
  @Override
  public void init() {
    //set movement delay and spaces moved
    initialMovementDelay = 10;
    direction = 1;
    timesMoved = 20;
    movementDelay = initialMovementDelay; 
  }//end #method init
  
  //ALIEN MOVESPEED 
  @Override
  public void update(){ //changes/updates the speed of which the alien entity moves
    if (movementDelay == 0){
      xLoc += widthMovement*direction;
      if (timesMoved%40 == 0){
        changeDirection();
        initialMovementDelay *= .8; //CHANGE THIS TO CHANGE ALIEN MOVESPEED.
      }
      if (timesMoved > 280)
        game.end();
      timesMoved ++;
      movementDelay = initialMovementDelay;
    }//end if #condition    
    else
      movementDelay --;
  }//end #method update
  
  //ALIEN SHOT
  public void checkShoot(){
    if (shouldShoot){
      if ((int)(Math.random() * 200) == 0)//random intervals of time that the alien can shoot #random
        shoot();
    }//end if #condition
  }//end #method checkShoot
  
  //ALIEN DEATH
  @Override
  public void die(){
    super.die();
    game.addScore();//add points to the score once an alien dies
  }//end #method die
  
  public void shoot(){
    game.addBullet(xLoc + width/2, yLoc + height, 1);//create bullet to shoot
  }//end #method shoot
  
  //checks the collision of the bullet to the alien, and whether or not it gets hit and dies
  public void checkCollision(Bullet b){
    boolean widthCond = b.getXLoc() - xLoc > 0 && b.getXLoc() - xLoc < width;
    boolean heightCond = b.getYLoc() - yLoc> 0 && b.getYLoc() - yLoc < height;  
    if (widthCond && heightCond){
      b.die();
      die();
    }  
  }//end #method checkCollision
  
  //makes alien shoot a bullet if true
  public void makeAlienShoot(){
    shouldShoot = true;
  }//end #method makeAlienShoot
  
  //changes the direction of which the aliens move
  private void changeDirection(){
    direction *= -1;
    yLoc += heightMovement;
  }//end #method changeDirection
  
  //create the alien entity
  @Override
  public void draw(Graphics g){
    g.drawImage(image, xLoc, yLoc, width, height, null);
  }//end #method draw
}//end class Alien
