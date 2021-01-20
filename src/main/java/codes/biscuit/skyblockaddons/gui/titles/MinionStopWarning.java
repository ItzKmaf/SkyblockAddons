package codes.biscuit.skyblockaddons.gui.titles;

import codes.biscuit.skyblockaddons.core.Feature;
import codes.biscuit.skyblockaddons.core.Message;
import codes.biscuit.skyblockaddons.utils.ColorCode;
import lombok.Setter;

public class MinionStopWarning implements Title {
	
	@Setter
	private String type;
	
	@Override
	public String getTitle() {
		return null;
	}
	
	@Override
	public String getSubTitle() {
		return Message.MESSAGE_MINION_CANNOT_REACH.getMessage(type);
	}
	
	@Override
	public int getColor() {
		return ColorCode.RED.getRGB();
	}
	
	@Override
	public Feature getOwner() {
		return Feature.MINION_STOP_WARNING;
	}
	
	@Override
	public String getName() {
		return "MinionStopWarning";
	}
}
