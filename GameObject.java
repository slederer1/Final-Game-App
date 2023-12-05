package lederer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.Icon;


//GENERAL GAME OBJECT
public abstract class GameObject {
	//EACH GAME OBJECT HAS AN X,Y LOCATION, VELOCITY, AND A DIRECTION

	private int x;
	private int y;
	private int velocity;
	private int direction;
	public boolean highlighted;

	//EACH GAME OBJECT CAN HAVE A COLLECTION OF IMAGES
	protected List<Icon> imageList;
	protected int currentImage; 

	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
		velocity = 0;
		currentImage = 0;
	}

	public void draw(Component c, Graphics g) {
		imageList.get(currentImage).paintIcon(c, g, x, y);
		if (highlighted) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.red);
			g2.setStroke(new BasicStroke(4));
			g2.drawRect(x, y, imageList.get(currentImage).getIconWidth(), imageList.get(currentImage).getIconHeight());
		}
	}

	// SETTERS AND GETTERS

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getVelocity() {
		return velocity;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Icon getCurrentImage() {
		return imageList.get(currentImage);
	}
	
	//ABSTRACT METHODS
	public abstract void move(Canvas c);
	public abstract void setImage();

}

