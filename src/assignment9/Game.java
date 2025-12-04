package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Food apple;
	private Snake snake;
	
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		
		//FIXME - construct new Snake and Food objects
		Food apple = new Food();
		this.apple = apple;

		Snake snake = new Snake();
		this.snake = snake;

	}
	
	public void play() {
		while (snake.isInbounds()) {
			int dir = getKeypress();
				if (dir != -1) {
					snake.changeDirection(dir);
				}

			snake.move();

				if (snake.eatFood(apple) == true) {
					apple = new Food();
				}

			updateDrawing();
			
		}
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		//FIXME
		StdDraw.clear();

		this.snake.draw();
		this.apple.draw();

		StdDraw.pause(100);
		StdDraw.show();
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
