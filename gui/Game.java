//#kevin #phoebe
package gui;

//import libraries
import javax.swing.*;
import entities.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Game extends JPanel implements ActionListener, KeyListener
{
  /***********************************************************************
    * VARIABLE DICTIONARY
    * t - the timer 
    * shouldRemove - ArrayList of alien entities to remove
    * player - the ship that handles user key input
    * bullets - Arraylist of bullets to be fired by aliens
    * enemies - Arraylist of alien entities
    * alienCount - the number of aliens existing
   *************************************************************************/
  
  //#variable
  private Timer t;
  ArrayList<Entity> shouldRemove;
  private Player player;
  private ArrayList<Entity> entities;
  private MainFrame mainFrame;
  private ArrayList<Bullet> bullets;
  private ArrayList<ArrayList<Alien>> enemies;
  private int alienCount;
  
  public Game(MainFrame mf) 
  {
    this.mainFrame = mf;
  }//end Game
  
  //INITIALISE ENTITIES #kevin #phoebe
  public void init()
  {
    alienCount = 0;
    t = new Timer(33, this); //frame rate --> 30 FPS
    shouldRemove = new ArrayList<Entity>();
    entities = new ArrayList<Entity>();
    bullets = new ArrayList<Bullet>();
    enemies = new ArrayList<ArrayList<Alien>>();
    setFocusable(true);
    
    //create ArrayList for aliens
    for (int i = 0; i < 6; i ++)
    {
      enemies.add(new ArrayList<Alien>());
    }//end for #loop
    
    for (int i = 0; i < 6; i ++)
    {
      for (int j = 0; j < 6; j++)
      {
        Alien alien = new Alien(this, 200 + j*50 + 10, 100 + 30*i + 5);
        //if bottom row of aliens, make the aliens shoot bullets back
        if (i == 5)
          alien.makeAlienShoot(); //#condition
        entities.add(alien);
        enemies.get(j).add(alien);
        alienCount ++;
      }
    }//end for #loop #array
    
    addKeyListener(this); //add key listener
    
  }//end #method init
  
  //START, END, BACKGROUND #kevin
  //if game starts, initialise entities and begin game
  public void start(int fireDelay){
    init();
    player = new Player(this, 275, 400, fireDelay);
    entities.add(player);
    t.start();
  }//end #method start
  
  //if game ends, go to end screen
  public void end(){
    t.stop();
    mainFrame.setPlayerScore(player.getScore());
    mainFrame.showPanel(MainFrame.ENDSCREEN); 
  }//end #method end
  
  //initialise bullets into the game 
  public void addBullet(int xLoc, int yLoc, int dir){
    Bullet bullet = new Bullet(xLoc, yLoc, dir);
    bullets.add(bullet);
    entities.add(bullet);
  }//end #method addBullet
  
  //paintComponent for the background of the game
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    requestFocus();
    g.drawImage(new ImageIcon("background.png").getImage(), 0, 0, 800, 600, null); //#string
    for (Entity i : entities){
      i.draw(g);
    }//end for #loop
  }//end method #paintComponent
  
  //KEYBOARD INPUT METHODS #phoebe #error
  @Override
  public void keyPressed(KeyEvent e) 
  {
    //if right key is pressed, move right
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
      player.shouldMoveRight();
    //if left key is pressed, move left
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
      player.shouldMoveLeft();
    //if space bar is pressed, shoot bullet
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
      player.shoot();  
  }//end #method keyPressed 
  
  //once keys are released, ship should stop moving
  @Override
  public void keyReleased(KeyEvent e) 
  {
    player.stopMoving();
  }//end #method keyReleased
  
  @Override
  //this is just here because it does not compile if it's not
    public void keyTyped(KeyEvent e) {
  }//end empty method
  
  //runs through the aliens and checks whether they have been killed
  //if yes, remove the aliens
  //#condition #loop #array
  @Override
  public void actionPerformed(ActionEvent e) 
  {
    if (e.getSource() == t)
    {
      for (Entity i : entities)
      {
        i.update();
        for (Bullet j : bullets)
        {
          i.checkCollision(j);
        }
        if (i.shouldRemove())
          shouldRemove.add(i);
      }//end for #loop #array
      
      for (ArrayList<Alien> i : enemies)
      {
        for (Alien j : i)
        {
          j.checkShoot();
        }
      }//end for #loop #array
      
      for (Entity i : shouldRemove)
      {
        entities.remove(i);
        bullets.remove(i);
        for (ArrayList<Alien> j : enemies)
        {
          //if alien is killed, remove the alien entity by 1
          if (j.remove(i)) 
            alienCount --;
          //if no aliens are left, game is over
          if (alienCount == 0)
            end();
          //first row of aliens shoot
          if (j.size() > 0)
            j.get(j.size() - 1).makeAlienShoot();
        }    
      }//end for loop
      shouldRemove.clear();//clears aliens     
    }//end outer for loop
    
    repaint();//repaint screen
  }//end #method actionPerformed
  
  //SCOREBOARD METHOD #phoebe
  public void addScore()
  {
    player.addScore();//add score
  }//end #method
}//end class Game
