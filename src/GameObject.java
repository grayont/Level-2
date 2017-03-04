import java.awt.Graphics;

public class GameObject {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	
	public void update() {
		x += 10;
		y += 10;
		
	}
	
	public void draw(Graphics g) {
		g.fillRect(x, y, 100, 100);
	}
	

}
