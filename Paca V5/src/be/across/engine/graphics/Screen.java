package be.across.engine.graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;

public class Screen {
	private static Screen instance = new Screen();
	private static int vaoId;
	private static int vboIId;
	private static int amount_of_indices;
	private static int pId;

	private Screen() { // private constructor for singleton
	}
	
	public static Screen getInstance() { // return the current screen object
		return instance;
	}

	public void init(int width, int height, String title) {
		try {
			Display.setDisplayMode(new DisplayMode(width, height)); // Set our display to the passed thru resolution
			Display.setTitle(title); // Set the title of the display
			ContextAttribs context = new ContextAttribs(3, 0); // Set openGL to version 3.3 and flag all deprecated older OpenGL commands
			Display.create(new PixelFormat(), context.withForwardCompatible(true)); // create the display. PixelFormat controls the pixel configuration, context controls the OpenGL version
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(1); // Exits the program with an error
		}  
	}

	public void initGL() {
		glClearColor(0.7f, 0.5f, 0.3f, 1.0f); // set the default clear color for the display (R, G, B, A) 
	}

	public void render(){
		glClear(GL_COLOR_BUFFER_BIT); // scherm schoonmaken
		
		glUseProgram(pId);
		
		glBindVertexArray(vaoId);
		glEnableVertexAttribArray(0);
		glEnableVertexAttribArray(1);
		glEnableVertexAttribArray(2);

		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, vboIId);
		glDrawElements(GL_TRIANGLES, amount_of_indices, GL_UNSIGNED_BYTE, 0);

		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
		glDisableVertexAttribArray(0);
		glDisableVertexAttribArray(1);
		glDisableVertexAttribArray(2);
		glBindVertexArray(0);

	}
	
	public void update() {
		Display.update(false); // update the screen without input checking 
	}

	public void dispose() {
		Display.destroy(); // destroy the screen
	}

	public void sendBufferId(int vaoId, int vboIId, int amount_of_indices) {
		Screen.vaoId = vaoId;
		Screen.vboIId = vboIId;
		Screen.amount_of_indices = amount_of_indices;
	}
	
	public void sendProgramId(int pId){
		Screen.pId = pId;
	}
}
