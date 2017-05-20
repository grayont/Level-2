package Reversi;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Display extends JPanel {

	private int width;
	private int height;
	private int[][] spaces;
	private GameManager gm;

	public Display(int width, int height, GameManager gm) {
		this.width = width;
		this.height = height;
		this.setSize(width, height);
		this.gm = gm;
		this.spaces = gm.getSpaces();
	}
	
	
	
	public void update(int p) {
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		drawGrid(g);
		for(int r = 0; r < spaces.length; r++) {
			for( int c = 0; c < spaces[r].length; c++){
				if(spaces[r][c] == 1) {
					g.setColor(Color.white);
					g.fillOval(c * 112, r * 112, 112, 112);
					g.setColor(Color.black);
					g.drawOval(c * 112, r * 112, 112, 112);
				}
				else if(spaces[r][c] == 2){
					g.setColor(Color.black);
					g.fillOval(c * 112, r * 112, 112, 112);
				}
			}
		}
	}
	
	public void drawGrid(Graphics g) {
		for (int i = 0; i <= width; i += width / 8) {
			g.drawLine(i, 0, i, height);
		}

		for (int i = 0; i <= width; i += height / 8) {
			g.drawLine(0, i, width, i);
		}
	}

}
