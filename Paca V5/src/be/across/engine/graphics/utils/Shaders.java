package be.across.engine.graphics.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.lwjgl.opengl.GL20.*;

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
		
		return shaderId;
	}
}
