/********************************************************************************
  * Assignment: Pseudo Space Invaders - Final Culminating Project
  * Description: A simple version of Space Invaders for our Grade 11 ICS Summative.
  * Name: Phoebe Zhou and Kevin Wang
  * Date: 2016/01/18
  * Course: ICS 3U1
  *********************************************************************************/

//#main #phoebe
package gui;

//import libraries
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
  //#variable
  private JPanel panel;
  private CardLayout cl;
  private int score;
  private EndScreen end;
  public final static String TITLE = "title";
  public final static String GAME = "game"; 
  public final static String ENDSCREEN = "end";
  private Game game;
  
  //mainFrame initialises everything like entities, backgrounds, etc.
  public MainFrame()
  {
    super();
    init();
    initializePanel();
    validate();
    
  }//end #method
  
  //initialize the main menu, the game, and the ending screen #string
  private void initializePanel()
  {
    panel = new JPanel();
    panel.setLayout(cl = new CardLayout());
    panel.add(new TitleScreen(this), "title");
    panel.add(game = new Game(this), "game");
    panel.add(end = new EndScreen(this), "end");
    add(panel, BorderLayout.CENTER);
  }//end #method initializePanel
  
  //set the frame that contains everything #string
  private void init()
  {
    setSize(800, 600);
    setVisible(true);
    setTitle("Pseudo Space Invaders");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    score = 0;
  }//end #method init
  
  public void showPanel(String panelName)
  {
    cl.show(panel, panelName);
    if (panelName.equals(ENDSCREEN))
    {
      end.setMessage();
    }
  }//end #method showPanel
  
  //the delay for shooting --> implements god mode if fire delay = 0
  public void showGame(int fireDelay)
  {
    cl.show(panel, GAME);
    game.start(fireDelay);
  }
  
  //SCOREBOARD #phoebe  
  public void setPlayerScore(int score) 
  {
    this.score = score;//add score 
  }//end method setPlayerScore
  public int getPlayerScore()
  {
    return score;
  }//end method setPlayerScore
  
  //MAIN
  public static void main (String args [])
  {
    new MainFrame();
  }//end main
}//end MainFrame
