package codes.biscuit.skyblockaddons.gui.titles;

import codes.biscuit.skyblockaddons.core.Feature;
import codes.biscuit.skyblockaddons.core.Message;
import codes.biscuit.skyblockaddons.utils.ColorCode;

public class LegendarySeaCreatureWarning implements Title{
	@Override
	public String getTitle() {
		return Message.MESSAGE_LEGENDARY_SEA_CREATURE_WARNING.getMessage();
	}
	
	@Override
	public String getSubTitle() {
		return null;
	}
	
	@Override
	public int getColor() {
		return ColorCode.RED.getRGB();
	}
	
	@Override
	public Feature getOwner() {
		return Feature.LEGENDARY_SEA_CREATURE_WARNING;
	}
	
	@Override
	public String getName() {
		return "LegendarySeaCreatureWarning";
	}
}
