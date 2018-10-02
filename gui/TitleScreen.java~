//#phoebe
package gui;

//import libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this class contains the main menu screen
@SuppressWarnings("serial")
public class TitleScreen extends JLabel implements ActionListener
{
  //#variable
  private JButton [] buttons; //JButtons that contain the buttons 
  private ImageIcon [] messages;//images of play, god mode, and quit buttons
  private MainFrame mainFrame;
  
  public TitleScreen(MainFrame mf)
  {
    this.mainFrame = mf;
    init();
  }//end method TitleScreen
  
 //create JButtons and initialise them and add images to them
 private void initButtons()
 {
   buttons = new JButton[3]; //#array
   messages = new ImageIcon [] //#array #string
   {
       new ImageIcon("playButton.png"), 
       new ImageIcon("godButton.png"),
       new ImageIcon("quitButton.png")
   };
  
  //for loop to run through all of the JButtons and add ActionListeners #loop
  for (int i = 0; i < buttons.length; i ++)
  {
   buttons[i] = new JButton(messages[i]);
   buttons[i].setMargin(new Insets(0, 0, 0, 0));
   buttons[i].addActionListener(this); 
   buttons[i].setSize(150, 50);
   buttons[i].setLocation(325, 250 + 75*i);
   //small quirk that makes the underlying JButtons invisible so only the images show up
   buttons[i].setOpaque(false);
   buttons[i].setContentAreaFilled(false);
   buttons[i].setBorderPainted(false);
   buttons[i].setFocusPainted(false);
   //add buttons
   this.add(buttons[i]);
  }//end for loop  
 }//end #method initButtons
 
 //initialise the buttons
 private void init(){
  setLayout(null);
  initButtons();
 }//end #method init
 
 //paintComponent for the graphics
 public void paintComponent(Graphics g){
  super.paintComponent(g);
  g.drawImage(new ImageIcon("titlescreen.png").getImage(), 0, 0, 800, 600, null);
 }//end #method paintComponent

 @Override
 public void actionPerformed(ActionEvent e){
  //if first button is selected, normal game begins #condition
  if (e.getSource() == buttons[0])
   mainFrame.showGame(20);
  //if second button is selected, god mode is initialised #condition #cheat
  if (e.getSource() == buttons[1])
   mainFrame.showGame(0); //delay of bullets is set at 0 instead of 20
  //if third button is selected, exit game #condition 
  if (e.getSource() == buttons[2])
   System.exit(0);
 }//end #method actionPerformed
}//end class TitleScreen
