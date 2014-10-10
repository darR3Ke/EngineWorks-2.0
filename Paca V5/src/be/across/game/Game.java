package be.across.game;

import java.util.ArrayList;

import be.across.engine.GameObject;
import be.across.engine.graphics.Color4f;
import be.across.engine.graphics.Coord4f;
import be.across.engine.interfaces.GameInterface;
import be.across.game.gameobjects.Quad;

public class Game implements GameInterface {

	private ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private Coord4f coord4f, sCoord4f;
	private Color4f color4f;
	private Quad quad;

	@Override
	public void init() {
		coord4f = new Coord4f(-0,5f, -0,5f);
		sCoord4f = new Coord4f(0,5f, 0,5f);
		color4f = new Color4f(0.7f, 0.5f, 0.3f, 1f);
		quad = new Quad(coord4f, sCoord4f, color4f);

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
		}
	}

}
