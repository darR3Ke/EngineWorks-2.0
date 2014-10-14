package be.across.engine.interfaces;

import java.util.ArrayList;

import be.across.engine.GameObject;
import be.across.engine.graphics.utils.Color4f;
import be.across.engine.graphics.utils.Coord4f;

public abstract class GameInterface {
	
	protected ArrayList<GameObject> objects = new ArrayList<GameObject>();
	protected Coord4f coord4f;
	protected Coord4f sCoord4f;
	protected Color4f color4f;
	protected String texName;

	public abstract void init();
	public abstract void getInput();
	public abstract void update();
	
	
	public void render() {
		for (GameObject go : objects) {
			go.render();
		}
	}
	
	public void addDraw(GameObject go){
		objects.add(go);
	}
	
	public void removeDraw(GameObject go) {
		int i = objects.indexOf(go);
		if (i >= 0) objects.remove(i);
	}

}
