package codes.biscuit.skyblockaddons.gui.TextRenders.textRenders;

import codes.biscuit.skyblockaddons.SkyblockAddons;
import codes.biscuit.skyblockaddons.core.Attribute;
import codes.biscuit.skyblockaddons.core.Feature;
import codes.biscuit.skyblockaddons.event.io.SkyblockJoinEvent;
import codes.biscuit.skyblockaddons.gui.TextRenders.TextRender;
import codes.biscuit.skyblockaddons.misc.ChromaManager;

import java.math.BigDecimal;

public class Text_DefencePercentageText implements TextRender {
	
	@Override
	public String getText() {
		double doubleDefence = SkyblockAddons.getInstance().getUtils().getAttributes().get(Attribute.DEFENCE).doubleValue();
		double percentage = ((doubleDefence/ 100) / ((doubleDefence)) / 100 + 1) * 100; //Taken from https://hypixel.net/threads/how-armor-works-and-the-diminishing-return-of-higher-defence.2178928/
		BigDecimal bigDecimal = new BigDecimal(percentage).setScale(1, BigDecimal.ROUND_HALF_UP);
		return bigDecimal.toString() + "%";
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
