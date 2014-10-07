package be.across.engine.graphics;

public enum Shape {
	POINT(1), LINE(2), TRIANGLE(3), QUAD(4);

	private final int shapeId;

	private Shape(int shapeId) {
		this.shapeId = shapeId;
	}

	public int getShapeId() {
		return shapeId;
	}

}
