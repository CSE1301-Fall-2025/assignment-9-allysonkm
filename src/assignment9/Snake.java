package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		deltaX = 0;
		deltaY = 0;
		this.segments = new LinkedList<>();
		BodySegment head = new BodySegment(0.2, 0.2, 0.02);
		this.segments.add(head);
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}

	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		double prevX = segments.get(0).getX();
		double prevY = segments.get(0).getY();

		segments.get(0).setPosition(prevX + deltaX, prevY + deltaY);

		for (int i = 1; i < segments.size(); i++) {
			double tempX = segments.get(i).getX();
			double tempY = segments.get(i).getY();

			segments.get(i).setPosition(tempX + deltaX, tempY + deltaY);

			prevX = tempX;
			prevY = tempY;
		}
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (int i = 0; i < this.segments.size(); i++) {
			this.segments.get(i).draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		if (segments.get(0).getX() == f.getX() && segments.get(0).getY() == f.getY()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		if (segments.get(0).getX() >= 0 && segments.get(0).getX() <= 1) {
			if (segments.get(0).getY() >= 0 && segments.get(0).getY() <= 1) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
