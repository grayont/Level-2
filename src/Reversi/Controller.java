 package Reversi;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements MouseListener{
	
	private int r;
	private int c;
	private int player = 1;
	
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
