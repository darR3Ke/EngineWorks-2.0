package be.across.engine.graphics;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;

public class Screen {
	private static Screen instance = new Screen();

	private Screen() { // private constructor for singleton
	}
	
	public static Screen getInstance() { // return the current screen object
		return instance;
	}

	public void init(int width, int height, String title) {
		try {
			Display.setDisplayMode(new DisplayMode(width, height)); // Set our display to the passed thru resolution
			Display.setTitle(title); // Set the title of the display
			ContextAttribs context = new ContextAttribs(3, 3); // Set openGL to version 3.3 and flag all deprecated older OpenGL commands
			Display.create(new PixelFormat(), context.withProfileCore(true).withForwardCompatible(true)); // create the display. PixelFormat controls the pixel configuration, context controls the OpenGL version
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(1); // Exits the program with an error
		}  
	}

	public void initGL() {
		glClearColor(0.0f, 0.0f, 0.0f, 1.0f); // set the default clear color for the display (R, G, B, A) 
	}

	
	
	public void update() {
		Display.update(false); // update the screen without input checking 
	}

	public void dispose() {
		Display.destroy(); // destroy the screen
	}
}
