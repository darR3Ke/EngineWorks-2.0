package be.across.engine.graphics.utils;

public class Coord4f {

	private float x, y, z, w;

	public Coord4f(float x, float y) {
		this(x, y, 0, 1);
	}

	public Coord4f(float x, float y, float z) {
		this(x, y, z, 1);
	}

	public Coord4f(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}

	public float getW() {
		return w;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setZ(float z) {
		this.z = z;
	}
}
