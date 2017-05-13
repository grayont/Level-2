package Reversi;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Display extends JPanel {

	private int width;
	private int height;
	private int[][] spaces;

	public Display(int width, int height) {
		this.width = width;
		this.height = height;
		this.setSize(width, height);
		spaces = new int[8][8];
		for(int r = 0; r < spaces.length; r++) {
			for( int c = 0; c < spaces[r].length; c++){
				if( (r == 3 && c == 3) || (r == 4 && c == 4)) {
					spaces[r][c] = 1;
				}
				else if( (r == 3 && c == 4) || (r == 4 && c == 3)) {
					spaces[r][c] = 2;
				}
				else {
					spaces[r][c] = 0;
				}
			}
		}
	}
	
	public void update(int p) {
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		for (int i = 0; i <= width; i += width / 8) {
			g.drawLine(i, 0, i, height);
		}

		for (int i = 0; i <= width; i += height / 8) {
			g.drawLine(0, i, width, i);
		}
	}

}
