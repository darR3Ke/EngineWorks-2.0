package be.across.engine.graphics;

public final class GL_DATA {
	// Amount of bytes per element
	static final int BYTES_PER_ELEMENT = 4;

	// Elements per parameter
	static final int POSITION_ELEMENT = 4;
	static final int COLOR_ELEMENTS = 4;
	static final int TEXTURE_ELEMENTS = 2;

	// Bytes per parameter
	static final int POSITION_BYTES = POSITION_ELEMENT * BYTES_PER_ELEMENT;
	static final int COLOR_BYTES = COLOR_ELEMENTS * BYTES_PER_ELEMENT;
	static final int TEXTURE_BYTES = TEXTURE_ELEMENTS * BYTES_PER_ELEMENT;

	// Byte offset per parameter
	static final int POSITION_OFFSET = 0;
	static final int COLOR_OFFSET = POSITION_OFFSET + POSITION_BYTES;

	static final int TEXTURE_OFFSET = COLOR_OFFSET + COLOR_BYTES;

	// Amount of elements per vertex
	static final int ELEMENT = POSITION_ELEMENT + COLOR_ELEMENTS + TEXTURE_ELEMENTS;

	// Byte size per vertex
	static final int ELEMENT_BYTES = POSITION_BYTES + COLOR_BYTES + TEXTURE_BYTES;

	private GL_DATA() {
	}
}
