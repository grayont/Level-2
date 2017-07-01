 package Reversi;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements MouseListener{
	
	private int r;
	private int c;
	private int player = 1;
	private GameManager gm;
	private Display display;
	
	public Controller(GameManager gm, Display display) {
		this.gm = gm;
		this.display = display;
	}
	
	public int getRow() {
		return r;
	}
	
	public int getCollumn() {
		return c;
	}
	
	public int getPlayer() {
		return player;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		c = e.getX()/112;
		r = e.getY()/112;
		
		boolean completeTurn = gm.drawCircle(r, c, player);
		display.repaint();
		if(completeTurn) {
			display.update();
			gm.checkWin();
			if(player == 1) {
				player ++;
			}
			else{
				player --;
			}	
		}
	}
	
	public void skipTurn() {	
		if(player == 1) {
			player ++;
		}
		else{
			player --;
		}	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
