package codes.biscuit.skyblockaddons.gui.TextRenders.textRenders;

import codes.biscuit.skyblockaddons.SkyblockAddons;
import codes.biscuit.skyblockaddons.core.Attribute;
import codes.biscuit.skyblockaddons.core.Feature;
import codes.biscuit.skyblockaddons.gui.TextRenders.TextRender;
import codes.biscuit.skyblockaddons.misc.ChromaManager;
import net.minecraft.client.Minecraft;

import java.math.BigDecimal;

public class Text_SpeedPercentageText implements TextRender {
	
	@Override
	public String getText() {
		String text;
		String walkSpeed = String.valueOf(Minecraft.getMinecraft().thePlayer.capabilities.getWalkSpeed() * 1000);
		text = walkSpeed.substring(0, Math.min(walkSpeed.length(), 3));
		
		if (text.endsWith(".")) text = text.substring(0, text.indexOf('.')); //remove trailing periods
		
		return text + "%";
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
