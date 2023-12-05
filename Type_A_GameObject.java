package lederer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_A_GameObject extends GameObject implements KeyListener {

	boolean automaticMovement;

	public Type_A_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.UP);
		setVelocity(4);
		highlighted = false;
		automaticMovement = true;

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_A_Up.png"));
		imageList.add(new ImageIcon("images/Type_A_Down.png"));
	}

	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		int iconHeight = icon.getIconHeight();
		int canvasHeight = (int) c.getSize().getHeight();

		if (!highlighted) {
			switch (getDirection()) {
			case Direction.UP:
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(1);
					setDirection(Direction.DOWN);
				}
				break;
			case Direction.DOWN:
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
					setDirection(Direction.UP);
				}
				break;
			}
		} else {
			if (highlighted) {
				automaticMovement = false;
				switch (getDirection()) {
				case Direction.UP:
					setY(getY() - getVelocity());
					if (getY() < 0) {
						setY(0);
					}
					break;
				case Direction.DOWN:
					setY(getY() + getVelocity());
					if (getY() + iconHeight > canvasHeight) {
						setY((int) (canvasHeight - iconHeight));
					}
					break;
				default:
					break;
				}
			}
		}
	}

	public void setImage() {
		switch (getDirection()) {
		case Direction.UP:
			currentImage = 0;
			break;
		case Direction.DOWN:
			currentImage = 1;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_TAB) {
			if (highlighted) {
				setDirection(Direction.NONE);
				automaticMovement = false; // Ensure automatic movement is enabled
				System.out.println("type A highlighted");
			} 
			//else if (!highlighted) {
			else {
				// setDirection(Direction.UP);
				automaticMovement = true;
				setDirection(Direction.UP);
				setVelocity(getVelocity() + 1);
				System.out.println("type A not highlighted");
			}
		}
		if(highlighted)
		setDirection(Direction.NONE);
		
	}

	public void keyPressed(KeyEvent e) {
		if (highlighted) {
			automaticMovement = false;
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setDirection(Direction.UP);
				setY(getY() - getVelocity()); // Move up
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setDirection(Direction.DOWN);
				setY(getY() + getVelocity()); // Move down
			}
			setVelocity(10); // Adjust the velocity as needed
		}
	}
	
	public String toString() {
		return "TYPE A";
	}

}
