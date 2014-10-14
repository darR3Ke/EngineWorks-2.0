package be.across.engine.graphics.utils;

public abstract class Sprite {
	private Coord4f coord4f;

	public Sprite(float x, float y, float spriteSize) {
		this.coord4f = new Coord4f(x, y, x + spriteSize, y + spriteSize);
	}

	public Coord4f getSpriteLocation(){
		return coord4f;
	}

}
