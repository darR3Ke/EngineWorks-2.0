package be.across.engine;

import be.across.engine.graphics.Color4f;
import be.across.engine.graphics.Shape;

public abstract class GameObject {

	protected float x, y, sx, sy;
	protected Color4f color4f;
	protected String textureName;
	protected Shape shape;

	public abstract void init();

	public abstract void update();

	public void render() {
		

	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getSx() {
		return sx;
	}

	public void setSx(float sx) {
		this.sx = sx;
	}

	public float getSy() {
		return sy;
	}

	public void setSy(float sy) {
		this.sy = sy;
	}

	public Color4f getColor4f() {
		return color4f;
	}

	public void setColor4f(Color4f color4f) {
		this.color4f = color4f;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

}
