package be.across.engine.graphics;

import static be.across.engine.graphics.GL_DATA.*;

public class Vertex {
	// initialize vertex data
	private float[] xyzw = new float[] { 0f, 0f, 0f, 1f }; // w value wont be used by us
	private float[] rgba = new float[] { 1f, 1f, 1f, 1f };
	private float[] st = new float[] { 0f, 0f };


	
	public void setXyzw(float x, float y, float z, float w) {
		this.xyzw = new float[] { x, y, z, w };
	}

	public void setRgba(float r, float g, float b, float a) {
		this.rgba = new float[] { r, g, b, a };
	}

	public void setSt(float s, float t) {
		this.st = new float[] { s, t };
	}
	
	public float[] getElements(){
		float[] out = new float[ELEMENT];
		
		int i = 0;

		out[i++] = xyzw[0];
		out[i++] = xyzw[1];
		out[i++] = xyzw[2];
		out[i++] = xyzw[3];
		
		out[i++] = rgba[0];
		out[i++] = rgba[1];
		out[i++] = rgba[2];
		out[i++] = rgba[3];
		
		out[i++] = st[0];
		out[i++] = st[1];
		
		return out;
	}


}
