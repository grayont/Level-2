import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	
	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	
	private int speed;
	
	public Rocketship(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 5;
		
		
	}
	
	public void update() {
		if(up) {
			moveUp();
		}
		if(down) {
		    moveDown();
		}
		if(left) {
			moveLeft();
		}
		if(right) {
			moveRight();
		}
		
	}
	
	public void moveUp() {
		this.y -= speed;
	}
	
	public void moveDown() {
		this.y += speed;
	}
	
	public void moveRight() {
		this.x += speed;
	}
	
	public void moveLeft() {
		this.x -= speed;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

}
