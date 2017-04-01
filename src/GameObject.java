import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean isAlive;
	private Rectangle collisionBox; 
	
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		isAlive = true;
		collisionBox = new Rectangle(x, y, width, height);
		
	}
	
	
	public void update() {
		collisionBox.setBounds(x, y, width, height);
		
	}
	
	public Rectangle getCollisionBox() {
		return collisionBox;
	}


	public void draw(Graphics g) {
	
	}
	

}
