package Reversi;

import javax.swing.JFrame;

public class Reversi {

	public static void main(String[] args) {
		Reversi r = new Reversi();

	}

	public Reversi() {
		Display display = new Display(896, 896);
		JFrame frame = new JFrame();
		frame.add(display);
		frame.setVisible(true);
		frame.setSize(1000, 1000);

	}

}
