package lederer;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Canvas extends JComponent implements ActionListener, KeyListener {
	// DEFAULT SERIAL NUMBER
	private static final long serialVersionUID = 1L;

	// GAME LOOP USES A FRAME AND TIMER
	private JFrame frame;
	private Timer gameLoopTimer;

	private List<GameObject> gameObjectList;
	private int highlighted = 0;
	int highlightedObjectIndex = 1;

	private GameObject activeObject;

	public GameObject getActiveObject() {
		return activeObject;
	}

	public void setActiveObject(GameObject object) {
		activeObject = object;
	}

	public Canvas() {
		// TASK 1: CREATE A LIST OF CHARACTERS THAT WILL APPEAR ON THE CANVAS
		gameObjectList = new LinkedList<>();

		// TASK 2: CREATE A WINDOW FOR THE APPLICATION
		frame = new JFrame("Animation Canvas");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);

		// TASK 3: CONSTRUCT A TIMER FOR GAME LOOP
		gameLoopTimer = new Timer(25, this);
		gameLoopTimer.start();

		setFocusTraversalKeysEnabled(false);
		addKeyListener(this);

		// TASK 4: MAKE THE WINDOW VISIBLE
		frame.setVisible(true);

		// Set highlightedObjectIndex based on the highlighted property
		for (int i = 0; i < gameObjectList.size(); i++) {
			if (gameObjectList.get(i).highlighted) {
				highlightedObjectIndex = i;
				break;
			}
		}
	}

	public synchronized void addGameObject(GameObject sprite) {
		if (gameObjectList.isEmpty()) {
			sprite.highlighted = true;
			// highlightedObjectIndex = 0;
		} else {
			sprite.highlighted = false;
		}
		gameObjectList.add(sprite);

	}

	public synchronized void paint(Graphics g) {
		for (GameObject s : gameObjectList) {
			s.draw(this, g);
		}
	}

	public synchronized void actionPerformed(ActionEvent e) {
		for (GameObject gameObject : gameObjectList) {
			gameObject.move(this);
			gameObject.setImage();

		}
		repaint();
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_TAB) {
			System.out.println("Highlighted index: " + highlightedObjectIndex);

			// Iterate through the gameObjectList and update highlighted status and velocity
			for (int i = 0; i < gameObjectList.size(); i++) {
				GameObject currentObject = gameObjectList.get(i);
				currentObject.highlighted = (i == highlightedObjectIndex);

				
				// Check if the object is highlighted before updating velocity
				if (currentObject.highlighted) {
					currentObject.setVelocity(currentObject.getVelocity() + 1);

					
					System.out.println("Object " + i + " highlighted: " + currentObject.highlighted);
				}
			}
			highlightedObjectIndex = (highlightedObjectIndex + 1) % gameObjectList.size();
			System.out.println("New highlightedObjectIndex: " + highlightedObjectIndex);
		}
	}

	// highlighted = highlighted + 1;
	// if (highlighted == gameObjectList.size()) {
	// highlighted = 0; }
	// setActiveObject(gameObjectList.get(highlighted));
	// System.out.println("Active object: " + getActiveObject());

	// GameObject s = gameObjectList.get(highlighted);
	// s.setVelocity(s.getVelocity() + 1);

}
