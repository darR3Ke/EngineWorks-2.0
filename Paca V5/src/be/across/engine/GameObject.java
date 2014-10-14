package be.across.engine;

import be.across.engine.graphics.Draw;
import be.across.engine.graphics.utils.Color4f;
import be.across.engine.graphics.utils.Coord4f;

public abstract class GameObject {

	protected Coord4f coord4f; // XYZW Coordinates
	protected Coord4f sCoord4f; // Size Coordinates
	protected Color4f color4f; // RGBA colors
	protected String textureName; // texture name and path (if exists)
	protected Coord4f spriteLocation; // if the texture is a spritesheet this will hold the location of the sprite for the object
	protected boolean redraw;
	
	private Draw draw = new Draw();
	

	public abstract void update();

	public void render() {
		draw.quad(coord4f, sCoord4f, color4f, textureName, spriteLocation);
		
	}

	
}
