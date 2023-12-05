package lederer;

import javax.swing.Icon;

public class Type_B_Adapter extends Type_B_GameObject {

	private Type_B_GameObject object;
	boolean automaticMovement;

	public Type_B_Adapter(Type_B_GameObject object) {
		super(object.getX(), object.getY());
		this.object = object;
		setDirection(Direction.LEFT);
		setVelocity(4);
		highlighted = false;
		automaticMovement = true;
	}

	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		int iconHeight = icon.getIconHeight();
		int iconWidth = icon.getIconWidth();
		int canvasHeight = (int) c.getSize().getHeight();
		int canvasWidth = (int) c.getSize().getWidth();

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
			default:
				break;

			}

		} else {
			switch (getDirection()) {
			case Direction.LEFT:
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(1);
					setDirection(Direction.UP);
				}
				break;
			case Direction.RIGHT:
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
					setDirection(Direction.DOWN);
				}
				break;
			case Direction.UP:
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);
					setDirection(Direction.RIGHT);
				}
				break;
			case Direction.DOWN:
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
					setDirection(Direction.LEFT);
				}
				break;
			}
		}
	}
}