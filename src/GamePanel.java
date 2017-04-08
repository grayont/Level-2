import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	private Timer time;
	private int WIDTH;
	private int HEIGHT;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	private int currentState = MENU_STATE;
	Font titleFont;
	Font otherFont;
	Rocketship ship;
	ObjectManager manager;
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;

	public GamePanel(int WIDTH, int HEIGHT) {
		time = new Timer(1000 / 60, this);
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		titleFont = new Font("Comic Sans MS", Font.PLAIN, 48);
		otherFont = new Font("Comic Sans MS", Font.PLAIN, 32);
		ship = new Rocketship(250, 700, 50, 50);
		manager = new ObjectManager();
		manager.addObject(ship);
		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		

	}

	public void updateMenuState() {

	}

	public void updateGameState() {
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		if(ship.isAlive == false) {
			currentState = END_STATE;
			manager.reset();
			ship = new Rocketship(250, 700, 50, 50);
			manager.addObject(ship);
		}

	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.GREEN);
		g.drawString("League Invaders", 0, HEIGHT/2 - 48);
		g.drawString("Press Enter to Start", 0, HEIGHT/2);
		g.setFont(otherFont);
		g.drawString("Press Space for Instructions", 0, HEIGHT/2 + 32);

	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		manager.draw(g);

	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 0, HEIGHT/2 - 48);
		g.drawString("You killed " + manager.getScore() + " things", 0, HEIGHT/2);
		g.setFont(otherFont);
		g.drawString("Press Enter to restart", 0, HEIGHT/2 + 32);

	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	public void startGame() {
		time.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {
			updateMenuState();
			manager.setScore(0);
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("a");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("b");
		if(e.getKeyCode() == 10) {
			currentState += 1;
			if(currentState > END_STATE){
				currentState = MENU_STATE;
			}
		}
		if(e.getKeyCode() == 38) {
			ship.up = true;
		}
		if(e.getKeyCode() == 40) {
			ship.down = true;
		}
		if(e.getKeyCode() == 37) {
			ship.left = true;
		}
		if(e.getKeyCode() == 39) {
			ship.right = true;
		}
		if(e.getKeyCode() == 32){
			manager.addObject(new Projectile(ship.x + 20, ship.y, 10, 10));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("c");
		if(e.getKeyCode() == 38) {
			ship.up = false;
		}
		if(e.getKeyCode() == 40) {
			ship.down = false;
		}
		if(e.getKeyCode() == 37) {
			ship.left = false;
		}
		if(e.getKeyCode() == 39) {
			ship.right = false;
		}
	}

}
