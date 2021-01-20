package codes.biscuit.skyblockaddons.gui.titles;

import codes.biscuit.skyblockaddons.core.Feature;
import codes.biscuit.skyblockaddons.core.Message;
import codes.biscuit.skyblockaddons.utils.ColorCode;

public class SpecialZelotAlert implements Title {
	
	@Override
	public String getTitle() {
		return Message.MESSAGE_SPECIAL_ZEALOT_FOUND.getMessage();
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
		return Feature.SPECIAL_ZEALOT_ALERT;
	}
	
	@Override
	public String getName() {
		return "SpecialZelotAlert";
	}
}
