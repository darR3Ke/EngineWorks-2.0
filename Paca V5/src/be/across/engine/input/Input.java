package be.across.engine.input;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class Input {

	public void init() {
		try {
			Keyboard.create();
			Mouse.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(1);;
		}
	}

	public static void poll() {
		Display.processMessages();
		Keyboard.poll();
		Mouse.poll();
	}

	public void dispose() {
		Keyboard.destroy();
		Mouse.destroy();
	}

}
