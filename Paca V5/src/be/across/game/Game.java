package be.across.game;

import java.util.ArrayList;

import be.across.engine.GameObject;
import be.across.engine.graphics.utils.Color4f;
import be.across.engine.graphics.utils.Coord4f;
import be.across.engine.interfaces.GameInterface;
import be.across.game.gameobjects.Quad;

public class Game implements GameInterface {

	private ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private Coord4f coord4f, sCoord4f;
	private Color4f color4f;
	private String texName;
	private Quad quad;

	@Override
	public void init() {
		coord4f = new Coord4f(-0.5f, -0.5f);
		sCoord4f = new Coord4f(0.5f, 0.5f);
		color4f = new Color4f(0.7f, 0f, 0.3f, 1f);
		texName = "res/spritesheet.png";
		quad = new Quad(coord4f, sCoord4f, color4f, texName);

		quad.redraw();

		objects.add(quad);
	}

	@Override
	public void getInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
	}

	@Override
	public void render() {
		for (GameObject go : objects) {
			go.render();
			go.remove();
		}
		
		// Temporary
		objects.remove(quad);
	}

}
