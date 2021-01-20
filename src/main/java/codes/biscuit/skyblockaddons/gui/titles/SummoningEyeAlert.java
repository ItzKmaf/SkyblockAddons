package codes.biscuit.skyblockaddons.gui.titles;

import codes.biscuit.skyblockaddons.core.Feature;
import codes.biscuit.skyblockaddons.core.Message;
import codes.biscuit.skyblockaddons.utils.ColorCode;

public class SummoningEyeAlert implements Title {
	@Override
	public String getTitle() {
		return Message.MESSAGE_SUMMONING_EYE_FOUND.getMessage();
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
		return Feature.SUMMONING_EYE_ALERT;
	}
	
	@Override
	public String getName() {
		return "SummoningEyeAlert";
	}
}
