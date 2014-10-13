package be.across.engine.graphics;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.glu.GLU;

public abstract class GLErrorHandler {

	public void exitOnGLError(String errorMessage) {
		int errorValue = glGetError();
		
		if (errorValue != GL_NO_ERROR) {
			String errorString = GLU.gluErrorString(errorValue);
			System.err.println("ERROR - " + errorMessage + ": " + errorString);
			System.exit(-1);
		}
	}
}
