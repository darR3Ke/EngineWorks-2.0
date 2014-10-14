package be.across.engine;

import be.across.engine.graphics.utils.Color4f;
import be.across.engine.graphics.utils.Coord4f;
import be.across.engine.interfaces.GameInterface;
import be.across.game.gameobjects.Quad;
import be.across.game.sprites.Alien1;

public class GameLogic extends GameInterface {


	private Quad quad;
	private Alien1 alien;

	@Override
	public void init() {
		this.coord4f = new Coord4f(-0.5f, -0.5f);
		this.sCoord4f = new Coord4f(0.5f, 0.5f);
		this.color4f = new Color4f(0.7f, 0f, 0.3f, 1f);
		this.texName = "res/spritesheet.png";
		alien = new Alien1(0, 0, 0.134f);
		quad = new Quad(coord4f, sCoord4f, color4f, texName, alien.getSpriteLocation());
		
	}

	@Override
	public void getInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
	}



}
