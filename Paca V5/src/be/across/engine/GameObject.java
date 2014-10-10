package be.across.engine;

import be.across.engine.graphics.Draw;
import be.across.engine.graphics.utils.Color4f;
import be.across.engine.graphics.utils.Coord4f;

public abstract class GameObject {

	protected Coord4f coord4f; // XYZW Coordinates
	protected Coord4f sCoord4f; // Size Coordinates
	protected Color4f color4f; // RGBA colors
	protected String textureName; // texture name and path (if exists)
	private Draw draw = new Draw();

	public abstract void init();

	public abstract void update();

	public void render() {
		draw.quad(coord4f, sCoord4f, color4f, textureName);
	}

	public Color4f getColor4f() {
		return color4f;
	}

	public void setColor4f(Color4f color4f) {
		this.color4f = color4f;
	}
}
