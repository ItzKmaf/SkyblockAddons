package codes.biscuit.skyblockaddons.gui.TextRenders;

import codes.biscuit.skyblockaddons.core.Feature;
import codes.biscuit.skyblockaddons.gui.Render;

public interface TextRender extends Render {
	
	String getText();
	
	int getWidth(int existingWidth);
	
	int getHeight(int existingHeight);
	
	void render(String text, float x, float y, int color);
}
