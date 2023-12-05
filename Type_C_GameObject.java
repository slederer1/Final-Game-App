package lederer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_C_GameObject extends GameObject implements KeyListener {

	boolean automaticMovement;

	public Type_C_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.RIGHT);
		setVelocity(4);
		highlighted = false;
		automaticMovement = true;

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_C_Left.png"));
		imageList.add(new ImageIcon("images/Type_C_Right.png"));
	}

	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		int iconWidth = icon.getIconWidth();
		int canvasWidth = (int) c.getSize().getWidth();

		if (!highlighted) {
			switch (getDirection()) {
			case Direction.LEFT:
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(1);
					setDirection(Direction.RIGHT);
				}
				break;
			case Direction.RIGHT:
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
					setDirection(Direction.LEFT);
				}
				break;
			}
		} else {
			if (highlighted) {
				automaticMovement = false;
				switch (getDirection()) {
				case Direction.LEFT:
					setX(getX() + getVelocity());
					if (getX() + iconWidth > canvasWidth) {
						setX((int) (canvasWidth - iconWidth));
					}
					break;
				case Direction.RIGHT:
					setX(getX() - getVelocity());
					if (getX() < 0) {
						setX(0);
					}
					break;
				}
			}
		}
	}

	public void setImage() {
		if (!highlighted) {
	        switch (getDirection()) {
	            case Direction.LEFT:
	                currentImage = 1;
	                break;
	            case Direction.RIGHT:
	                currentImage = 0;
	                break;
	        }
	    } else {
	        switch (getDirection()) {
	            case Direction.LEFT:
	                currentImage = 0; // Set the image for left when highlighted
	                break;
	            case Direction.RIGHT:
	                currentImage = 1; // Set the image for right when highlighted
	                break;
	        }
	    }
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_TAB) {
          
            // Adjust the highlighted object and velocity
            if (highlighted) {
                setDirection(Direction.NONE);
                automaticMovement = false;
            } else {
                automaticMovement = true;
                setDirection(Direction.LEFT);
                setVelocity(getVelocity() + 1);
            }
        }
		if(highlighted)
			setDirection(Direction.NONE);
	}

	public void keyPressed(KeyEvent e) {
		if (highlighted) {
			automaticMovement = false;
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				setDirection(Direction.LEFT);
				setX(getX() - getVelocity()); 
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				setDirection(Direction.RIGHT);
				setX(getX() + getVelocity());
			}
			setVelocity(10); // Adjust the velocity as needed
		}
	}

}
