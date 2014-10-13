package be.across.engine.input;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import be.across.engine.graphics.GLErrorHandler;

public class Input extends GLErrorHandler {

	public void init() {
		try {
			Keyboard.create();
			Mouse.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(1);;
		}
		
		this.exitOnGLError("setupInput");
	}

	public void poll() {
		Display.processMessages();
		Keyboard.poll();
		Mouse.poll();
		
		this.exitOnGLError("pollInput");
	}

	public void dispose() {
		Keyboard.destroy();
		Mouse.destroy();
	}
}
