package Reversi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display extends JPanel implements ActionListener{

	private int width;
	private int height;
	private int[][] spaces;
	private GameManager gm;
	private JLabel whiteScore;
	private JLabel blackScore;
	private JButton skipTurn;

	public Display(int width, int height, GameManager gm) {
		this.width = width;
		this.height = height;
		this.setSize(width, height);
		this.gm = gm;
		this.spaces = gm.getSpaces();
		whiteScore = new JLabel("White score: " + gm.getWhiteScore());
		blackScore = new JLabel("Black score: " + gm.getBlackScore());
		skipTurn = new JButton("Skip Turn");
		skipTurn.addActionListener(this);
		whiteScore.setBounds(width/2, height - 18,100, 50);
		blackScore.setBounds(width/2,height - 3, 100, 50);
		skipTurn.setBounds(0,height + 5, 100, 20);
		this.setLayout(null);
		this.add(skipTurn);
		this.add(whiteScore);
		this.add(blackScore);
		
	}
	
	
	
	public void update() {
		whiteScore.setText("White score: " + gm.getWhiteScore());
		blackScore.setText("Black score: " + gm.getBlackScore());
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



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		gm.getController().skipTurn();
	}

}
