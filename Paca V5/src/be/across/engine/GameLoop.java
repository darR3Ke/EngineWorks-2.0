package be.across.engine;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import be.across.engine.graphics.Screen;
import be.across.engine.input.Input;
import be.across.game.Game;

public class GameLoop implements Runnable {
	// Screen
	private static final int DISPLAY_WIDTH = 1024;
	private static final int DISPLAY_HEIGHT = DISPLAY_WIDTH / 4 * 3; // Aspect ratio (1024/4*3 = 768)
	private static final String DISPLAY_TITLE = "Display title";

	// Game
	private static boolean running = false;
	private static boolean update = false;
	private static boolean render = false;
	private static boolean gameOver = false;
	private static boolean isPaused = false;

	// Objects
	private static Screen screen;
	private static Input input;
	private static Game game;
	private Thread thread;

	// Debug
	private static boolean debug = true;
	private static int fps, ups;

	// Gameloop
	private static final long UPDATE_PERIOD = (1 * 1000000000L / 60); // 60 updates per 1 second (=1000.000.000 nanoseconds)
	private static final long RENDER_PERIOD = (1 * 1000000000L / 100); // 100 FPS

	public static void main(String[] args) {
		GameLoop gameLoop = new GameLoop(); // Create a new GameLoop Object
		gameLoop.start(); // use the object to call the method start
	}

	public void start() {
		running = true;
		thread = new Thread(this, "GameLoop"); // submit this object in a new thread
		thread.start(); // start the thread with the GameLoop object in
	}

	@Override
	public void run() {
		initScreen(); // initialize the screen
		initGL(); // initialize OpenGL

		initGame(); // initialize the game

		runGame(); // main gameloop

		cleanUp(); // clean up resources
	}

	public static void initScreen() {
		screen = Screen.getInstance(); // get the currently running screen object
		screen.init(DISPLAY_WIDTH, DISPLAY_HEIGHT, DISPLAY_TITLE);
	}

	public static void initGL() {
		screen.initGL();
	}

	public static void initGame() {
		input = new Input();
		game = new Game();
		input.init(); // initialize the input
		game.init(); // initialize the game
	}

	public static void runGame() {
		// timers
		long beforeTime, afterTime, sleepTime, renderTime, updateTime, timeDebug, timeDiff;

		beforeTime = System.nanoTime();
		renderTime = 0;
		updateTime = 0;
		timeDebug = 0;
		update = true;
		render = true;

		while (running) {

			if ( update ) {
				gameUpdate(); // do Game logic (60 updates per second)
				updateTime = 0;
				update = false;
			}

			if ( render ) {
				gameRender(); // draw to buffer (100 FPS)
				screen.update(); // paint the buffer
				renderTime = 0;
				render = false;
			}

			afterTime = System.nanoTime();

			/*
			 * slow down the loop to free CPU-time
			 */
			sleepTime = (RENDER_PERIOD - (afterTime - beforeTime)) / 20;
			if ( sleepTime > 0 ) {
				try {
					Thread.sleep((sleepTime) / 1000000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			afterTime = System.nanoTime();
			timeDiff = (afterTime - beforeTime);
			renderTime += timeDiff;
			updateTime += timeDiff;
			timeDebug += timeDiff;

			if ( renderTime > RENDER_PERIOD ) render = true;
			if ( updateTime > UPDATE_PERIOD ) update = true;

			if ( (timeDebug >= 1000000000L) && debug ) {
				System.out.println("FPS : " + fps + " UPS : " + ups);
				fps = 0;
				ups = 0;
				timeDebug = 0;
			}
			beforeTime = System.nanoTime();
		}
	}

	public static void gameUpdate() {
		ups++;
		Input.poll();
		if ( Display.isCloseRequested() || Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) ) closeGame();
		if ( running ) {
			game.update();
		}
	}

	public static void gameRender() {
		fps++;
		if ( running ) {
			game.render();
		}
	}

	public static void closeGame() {
		running = false;
	}

	public static void cleanUp() {
		screen.dispose();
		input.dispose();
		System.exit(0);

	}

}
