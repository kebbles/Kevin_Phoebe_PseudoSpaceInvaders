//#kevin
package entities;

//import libraries
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import gui.Game;

public class Player extends Entity
{
  /*************************************************************************************************
    * VARIABLE DICTIONARY
    * score - recorded score that the player has from killing aliens
    * lives - number of lives that the player has <-- not visible, but 3
    * fireCooldownStart and fireCooldown - time interval between player shots
    * moveLeft and moveRight - direction that the player moves
    * width and height - width and height of the ship entity
    * windowLeftBound and windowRightBound - boundaries so the player doesn't move off of the screen
    * xVelo - speed of which the player moves
   **************************************************************************************************/
  //#variable
  private int score;
  private int lives;
  private int fireCooldownStart;
  private int fireCooldown;
  private boolean moveLeft, moveRight;
  private int width;
  private int height;
  private int windowLeftBound;
  private int windowRightBound;
  private int xVelo;
  private static Image playerImage = new ImageIcon("ship.png").getImage();
  private Game game;
  
  public Player(Game game, int xLoc, int yLoc, int fireCooldownStart){
    super(xLoc, yLoc);
    this.fireCooldownStart = fireCooldownStart;
    this.game = game;
  }//end Player
  
  //initialise variables and set them specific numbers
  @Override
  public void init() {
    width = 33;
    height = 23;
    windowLeftBound = 30;
    windowRightBound = 700;
    xVelo = 10; //ONLY CHANGE THIS IN MULTIPLES OF 5
    lives = 3;
    fireCooldown = 0;
  }//end #method init
  
  //handles the speed of which the character moves in a certian direction, and the cooldown of shots
  @Override
  public void update() {
    if (moveLeft && xLoc > windowLeftBound + xVelo)
      xLoc -= xVelo;
    else if (moveRight && xLoc < windowRightBound - xVelo)
      xLoc += xVelo; 
    if (fireCooldown > 0)
      fireCooldown --;   
  }//end #method update
  
  //draws the ship entity
  @Override
  public void draw(Graphics g) {
    g.drawImage(playerImage, xLoc, yLoc, width, height, null);    
  }//end #method draw
  
  //PLAYER MOVEMENT
  //handles player shot
  public void shoot(){
    //if cooldown of shot is 0, player can shoot again
    if (fireCooldown == 0){
      game.addBullet(xLoc + width/2, yLoc - height + 8, -1);
      fireCooldown += fireCooldownStart;     
    }//end if #condition
  }//end method shoot
  
  //handles moving left #error
  public void shouldMoveLeft(){
    moveLeft = true;
    moveRight = false;
  }//end #method shouldMoveLeft
  
  //handles moving right #error
  public void shouldMoveRight(){
    moveLeft = false;
    moveRight = true;
  }//end #method shouldMoveRight
  
  //handles when the player stops moving
  public void stopMoving() {
    moveLeft = false;
    moveRight = false;
  }//end #method stopMoving
  
  //COLLISION 
  public void checkCollision(Bullet b){
    boolean widthCond = b.getXLoc() - xLoc > 0 && b.getXLoc() - xLoc < width;
    boolean heightCond = b.getYLoc() - yLoc   > 0 && b.getYLoc() - yLoc < height;
    //player life conditions
    //if alien bullets collides with player, lives go down by 1
    if (widthCond && heightCond){
      b.die();
      lives --;
      //if no more lives, game ends
      if (lives == 0)
        game.end();
    }//end if #condition    
  }//end #method checkCollision
  
  //SCORE
  public void addScore() {
    score += 1000; //CHANGE SCORE HERE   
  }//end #method addScore
  
  public int getScore(){
    return score;
  }//end #method getScore

}//end class Player
