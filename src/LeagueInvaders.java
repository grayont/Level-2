import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class LeagueInvaders{
	
	private JFrame frame;
	final int WIDTH = 500;
	final int HEIGHT = 800;
	GamePanel panel;
	
      public static void main(String[] args) {
    	  LeagueInvaders li = new LeagueInvaders();
    	  li.setup();
    	  
    	
      
      }
      
      public LeagueInvaders() {
		  
    	  frame = new JFrame();
    	  panel = new GamePanel();
    	  
	  }
      
      public void setup() {
    	  frame.setSize(WIDTH, HEIGHT);
    	  frame.add(panel);
    	  frame.addKeyListener(panel);
    	  
    	  frame.setVisible(true);
    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  panel.startGame();
      }


}
