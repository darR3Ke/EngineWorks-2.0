package be.across.game.gameobjects;

import be.across.engine.GameLogic;
import be.across.engine.GameObject;
import be.across.engine.graphics.utils.Color4f;
import be.across.engine.graphics.utils.Coord4f;

public class Quad extends GameObject{

	public Quad(Coord4f coord4f, Coord4f sCoord4f, Color4f color4f, String texName) {
		this(coord4f, sCoord4f, color4f, texName, new Coord4f(0,0,1, 1));
	}
	
	public Quad(Coord4f coord4f, Coord4f sCoord4f, Color4f color4f, String texName, Coord4f spriteLocation) {
		this.coord4f = coord4f;
		this.sCoord4f = sCoord4f;
		this.color4f = color4f;
		this.textureName = texName;
		this.spriteLocation = spriteLocation;
	}


	@Override
	public void update() {
		
	}

}
