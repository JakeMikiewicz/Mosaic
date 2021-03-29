import java.awt.Graphics;
//import java.util.ArrayList;
//import javax.swing.JPanel;
//import javax.swing.JFrame;
//import java.util.Random;

class OvalDraw extends Oval {
	public OvalDraw(int x, int y, int width, int height) {
		super(x,y,width,height);
	}
	public void paintComponent(Graphics g) {
		g.drawOval(getPositionX(), getPositionY(), getWidth(), getHeight());
	}
}

/* This is the face class, which creates the actual faces that are implemented in the other files. */

public class Face extends OvalDraw {

	private OvalDraw lefteye;
	private OvalDraw righteye;

	public Face() {
		super(0,0,0,0);
		lefteye = new OvalDraw(0,0,0,0);
		righteye = new OvalDraw(0,0,0,0);
	}

	public Face(int positionXIn, int positionYIn, int widthIn, int heightIn) {
		super(positionXIn, positionYIn, widthIn, heightIn);

		// the left eye of the face
		int lefteyeHeight = heightIn / 4;
		int lefteyeWidth = lefteyeHeight / 2;
		int lefteyePositionX = positionXIn + (widthIn / 3) - (lefteyeWidth / 3);
		int lefteyePositionY = positionYIn + (heightIn / 3) - (lefteyeHeight / 2);

		// the other eye
		int righteyeHeight = heightIn / 4;
		int righteyeWidth = righteyeHeight / 2;
		int righteyePositionX = positionXIn + (widthIn / 2) + 10;
		int righteyePositionY = positionYIn + (heightIn / 3) - (righteyeHeight / 2);

		lefteye = new OvalDraw(lefteyePositionX, lefteyePositionY, lefteyeWidth, lefteyeHeight);
		righteye = new OvalDraw(righteyePositionX, righteyePositionY, righteyeWidth, righteyeHeight);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		lefteye.paintComponent(g);
		righteye.paintComponent(g);

        g.drawArc(getPositionX() + 5, getPositionY(), getWidth() - 10, getHeight() - 10, -45, -90); // draws smile
	}
}