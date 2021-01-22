package codes.biscuit.skyblockaddons.gui.titles;

import codes.biscuit.skyblockaddons.core.Feature;
import codes.biscuit.skyblockaddons.gui.Render;

public interface Title extends Render {
	
	String getTitle();
	String getSubTitle();
	int getColor();
	Feature getOwner();
	String getName();
}
