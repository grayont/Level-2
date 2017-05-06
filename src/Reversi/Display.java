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
				spaces[r][c] = 0;
			}
		}
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
