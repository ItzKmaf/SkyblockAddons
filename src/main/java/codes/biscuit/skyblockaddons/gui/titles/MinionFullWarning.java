package codes.biscuit.skyblockaddons.gui.titles;

import codes.biscuit.skyblockaddons.core.Feature;
import codes.biscuit.skyblockaddons.core.Message;
import codes.biscuit.skyblockaddons.utils.ColorCode;
import lombok.Setter;

public class MinionFullWarning implements Title {
	
	
	@Override
	public String getTitle() {
		return null;
	}
	
	@Override
	public String getSubTitle() {
		return Message.MESSAGE_MINION_IS_FULL.getMessage();
	}
	
	@Override
	public int getColor() {
		return ColorCode.RED.getRGB();
	}
	
	@Override
	public Feature getOwner() {
		return Feature.MINION_FULL_WARNING;
	}
	
	@Override
	public String getName() {
		return "MinionFullWarning";
	}
}
