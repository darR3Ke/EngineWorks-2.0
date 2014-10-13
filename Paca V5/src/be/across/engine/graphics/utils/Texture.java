package be.across.engine.graphics.utils;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.IntBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;

import be.across.engine.graphics.GLErrorHandler;

public class Texture extends GLErrorHandler {
	private int width, height;
	private int textureId;
	
	public Texture(String path)
	{
		textureId = load(path);
	}
	
	private int load(String path)
	{
		
		int[] pixels = null;
		try
		{
			BufferedImage image = ImageIO.read(new FileInputStream(path));
			width = image.getWidth();
			height = image.getHeight();
			pixels = new int[width * height];
			image.getRGB(0, 0, width, height, pixels, 0, width);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
		
		int[] data = new int[width * height];
		
		for(int i = 0; i < width * height; i ++)
		{
			int a = (pixels[i] & 0xff000000) >> 24;
			int r = (pixels[i] & 0xff0000) >> 16; 
			int g = (pixels[i] & 0xff00) >> 8; 
			int b = (pixels[i] & 0xff); 
			
			data[i] = a << 24 | b << 16 | g << 8 | r;
		}
		
		IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		
		int tex = glGenTextures();
		glActiveTexture(GL_TEXTURE0);
		glBindTexture(GL_TEXTURE_2D, tex);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer );
		glBindTexture(GL_TEXTURE_2D, 0);

		this.exitOnGLError("loadTexture");
		
		return tex;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public int getTextureId()
	{
		return textureId;
	}
	
}
