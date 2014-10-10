package be.across.engine.graphics;

import java.nio.ByteBuffer;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

import static be.across.engine.graphics.GL_DATA.*;

public class Draw {

	private FloatBuffer verticesBuffer;
	private ByteBuffer indicesBuffer;

	private byte[] indices = { 0, 1, 2, 2, 3, 0 };

	public void point(Coord4f coord4f, Color4f color4f) {

	}

	public void line(Coord4f coord4f, Color4f color4f) {

	}

	public void quad(Coord4f coord4f, Coord4f sCoord4f, Color4f color4f, String textureName) {
		// Upper Left corner
		Vertex v0 = new Vertex();
		v0.setXyzw(coord4f.getX(), sCoord4f.getY(), coord4f.getZ(), coord4f.getW());
		v0.setRgba(color4f.getR(), color4f.getG(), color4f.getB(), color4f.getA());
		v0.setSt(0, 0);
		
		// Lower Left corner
		Vertex v1 = new Vertex();
		v1.setXyzw(coord4f.getX(), coord4f.getY(), coord4f.getZ(), coord4f.getW());
		v1.setRgba(color4f.getR(), color4f.getG(), color4f.getB(), color4f.getA());
		v1.setSt(1, 0);
		
		// Upper Right corner
		Vertex v2 = new Vertex();
		v2.setXyzw(sCoord4f.getX(), coord4f.getY(), coord4f.getZ(), coord4f.getW());
		v2.setRgba(color4f.getR(), color4f.getG(), color4f.getB(), color4f.getA());
		v2.setSt(0, 1);
		
		// Lower Right corner
		Vertex v3 = new Vertex();
		v3.setXyzw(sCoord4f.getX(), sCoord4f.getY(), coord4f.getZ(), coord4f.getW());
		v3.setRgba(color4f.getR(), color4f.getG(), color4f.getB(), color4f.getA());
		v3.setSt(1, 1);

		Vertex[] vertices = new Vertex[] { v0, v1, v2, v3 };
		verticesBuffer = BufferUtils.createFloatBuffer(vertices.length * ELEMENT);
		for (int i = 0; i < vertices.length; i++) {
			verticesBuffer.put(vertices[i].getElements());
		}
		verticesBuffer.flip();
		
		indicesBuffer = BufferUtils.createByteBuffer(indices.length);
		indicesBuffer.put(indices);
		indicesBuffer.flip();
		
		drawToBuffer();
	}

	private void drawToBuffer() {
		int vaoId = glGenVertexArrays();
		glBindVertexArray(vaoId);

		int vboId = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vboId);
		glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW);
		glVertexAttribPointer(0, POSITION_ELEMENT, GL_FLOAT, false, ELEMENT_BYTES, POSITION_OFFSET);
		glVertexAttribPointer(1, COLOR_ELEMENTS, GL_FLOAT, false, ELEMENT_BYTES, COLOR_OFFSET);
		glVertexAttribPointer(2, TEXTURE_ELEMENTS, GL_FLOAT, false, ELEMENT_BYTES, TEXTURE_OFFSET);
		glBindBuffer(GL_ARRAY_BUFFER, 0);

		int vboIId = glGenBuffers();
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, vboIId);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);

		Screen screen = Screen.getInstance();
		screen.sendBufferId(vaoId, vboIId, indices.length);
	}
}
