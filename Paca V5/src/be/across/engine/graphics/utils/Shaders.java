package be.across.engine.graphics.utils;

import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL20.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Shaders {
	
	public int load(String filename, int type){
		StringBuilder shaderSource = new StringBuilder();
		int shaderId = 0;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while((line = reader.readLine()) != null) {
				shaderSource.append(line).append("\n");
			}
			reader.close();
		} catch (IOException ex) {
			System.err.println("Could not read file.");
			ex.printStackTrace();
			System.exit(-1);
		}
		
		shaderId = glCreateShader(type);
		glShaderSource(shaderId, shaderSource);
		glCompileShader(shaderId);	
		
		int success = 0;
		success = glGetShaderi(shaderId, GL_COMPILE_STATUS);
		
		if (success == GL_FALSE) System.err.println("Shader compilation failed");
		
		return shaderId;
	}
}
