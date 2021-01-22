package codes.biscuit.skyblockaddons.gui.TextRenders.textRenders;

import codes.biscuit.skyblockaddons.SkyblockAddons;
import codes.biscuit.skyblockaddons.core.Attribute;
import codes.biscuit.skyblockaddons.core.Feature;
import codes.biscuit.skyblockaddons.gui.TextRenders.TextRender;
import codes.biscuit.skyblockaddons.misc.ChromaManager;

public class Text_DefenceText implements TextRender {
	
	@Override
	public String getText() {
		return SkyblockAddons.getInstance().getUtils().getAttributes().get(Attribute.DEFENCE).toString();
	}
	
	@Override
	public int getWidth(int existingWidth) {
		return existingWidth;
	}
	
	@Override
	public int getHeight(int existingHeight) {
		return existingHeight;
	}
	
	@Override
	public void render(String text, float x, float y, int color) {
		ChromaManager.renderingText(getOwner());
		SkyblockAddons.getInstance().getUtils().drawTextWithStyle(text, x, y, color);
		ChromaManager.doneRenderingText();
	}
	
	@Override
	public Feature getOwner() {
		return Feature.DEFENCE_TEXT;
	}
}
