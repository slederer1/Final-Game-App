package lederer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_B_GameObject extends GameObject implements KeyListener {

	boolean automaticMovement; 
	
	public Type_B_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.NONE);
		setVelocity(4);
		highlighted = false;
		automaticMovement = true;

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_B__Up.png"));
		imageList.add(new ImageIcon("images/Type_B_Down.png"));
		imageList.add(new ImageIcon("images/Type_B_Left.png"));
		imageList.add(new ImageIcon("images/Type_B_Right.png"));

	}

	public void move(Canvas c) {
		
	}

	// SPECIFY THE IMAGE TO DISPLAY
	// USED FOR ANIMATION
	public void setImage() {
		switch (getDirection()) {
		case Direction.NONE:
			break;
		case Direction.UP:
			currentImage = 0;
			break;
		case Direction.DOWN:
			currentImage = 1;
			break;
		case Direction.LEFT:
			currentImage = 3;
			break;
		case Direction.RIGHT:
			currentImage = 2;
			break;
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
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setDirection(Direction.UP);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setDirection(Direction.DOWN);
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				setDirection(Direction.LEFT);
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				setDirection(Direction.RIGHT);
			}
		}
	}

}