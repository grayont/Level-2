import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class LeagueInvaders{
	
	private JFrame frame;
	GamePanel panel;
	
      public static void main(String[] args) {
    	  LeagueInvaders li = new LeagueInvaders();
    	  li.setup();
    	  
    	
      
      }
      
      public LeagueInvaders() {
		  
    	  frame = new JFrame();
    	  panel = new GamePanel(500, 800);
    	  
	  }
      
      public void setup() {
    	  frame.setSize(500, 800);
    	  frame.add(panel);
    	  frame.addKeyListener(panel);
    	  
    	  frame.setVisible(true);
    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  panel.startGame();
      }


}
