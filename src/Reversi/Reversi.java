package Reversi;

import javax.swing.JFrame;

public class Reversi {

	public static void main(String[] args) {
		Reversi r = new Reversi();

	}

	public Reversi() {
		GameManager gm = new GameManager();
		Display display = new Display(896, 896, gm);
		Controller controller = new Controller(gm, display);
		gm.setController(controller);
		JFrame frame = new JFrame();
		frame.add(display);
		frame.addMouseListener(controller);
		frame.setVisible(true);
		frame.setSize(1000, 1000);

	}

}
