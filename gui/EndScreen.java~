//#phoebe
package gui;

//import libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class EndScreen extends JPanel implements ActionListener
{
  private String message; //#string
  private MainFrame mainFrame;
  private static Image endScreen = new ImageIcon("gameover.png").getImage();
  private JButton replay, quit;
  private boolean setoff = false;//for the score
  
  public EndScreen(MainFrame mf) 
  {
    super();
    mainFrame = mf;  
    init(); 
  }//end EndScreen
  
  //set initial layout and message
  public void init(){
    setLayout(null);
    message = "";
  }//end #method init
  
  public void setMessage() 
  {
    if (!setoff)
    {
      //set the score message
      message = "YOUR SCORE: " + mainFrame.getPlayerScore();
      JLabel label = new JLabel(message);
      
      //set the size, color, and location of the score message
      label.setSize(label.getPreferredSize());
      System.out.println(label.getSize());
      label.setLocation(400-label.getWidth()/2, 300);
      label.setForeground(new Color(255, 255, 255));;
      this.add(label);
      
      //load replay button and implement ActionListener
      replay= new JButton(new ImageIcon("playagain.png"));
      replay.setMargin(new Insets(0, 0, 0, 0));
      replay.addActionListener(this); 
      replay.setSize(150, 50);
      replay.setLocation(325, 350);
      //small quirk that makes the underlying JButtons invisible so only the images show up
      replay.setOpaque(false);
      replay.setContentAreaFilled(false);
      replay.setBorderPainted(false);
      replay.setFocusPainted(false);
      this.add(replay);
      
      //load quit button and implement ActionListener
      quit= new JButton(new ImageIcon("quitButton.png"));
      quit.setMargin(new Insets(0, 0, 0, 0));
      quit.addActionListener(this); 
      quit.setSize(150, 50);
      quit.setLocation(325, 425);
      //small quirk that makes the underlying JButtons invisible so only the images show up
      quit.setOpaque(false);
      quit.setContentAreaFilled(false);
      quit.setBorderPainted(false);
      quit.setFocusPainted(false);
      this.add(quit);
      
      repaint();//repaints the screen
      revalidate();//revalidates <-- do not remove this
      setoff = true;
    }//end if #condition setoff
  }//end #method setMessage
  
  //paintComponent for the graphics
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.drawImage(endScreen, 0, 0, 800, 600, null);
  }//end #method paintComponent
  
  @Override
  public void actionPerformed(ActionEvent e) 
  {
    if (e.getSource() == quit)//if player chooses to quit, exit game #condition
      System.exit(0);
    else
      mainFrame.showPanel(MainFrame.TITLE); //other option is to replay; goes back to main menu #condition
  }//end #method actionPerformed
}//end class EndScreen