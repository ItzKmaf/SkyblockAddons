package codes.biscuit.skyblockaddons.gui.titles;

import codes.biscuit.skyblockaddons.core.Feature;
import codes.biscuit.skyblockaddons.core.Message;
import codes.biscuit.skyblockaddons.utils.ColorCode;

public class BossApproachAlert implements Title {
	
	@Override
	public String getTitle() {
		return Message.MESSAGE_BOSS_APPROACH_ALERT.getMessage();
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
		return Feature.BOSS_APPROACH_ALERT;
	}
	
	@Override
	public String getName() {
		return "BossApproachAlert";
	}
}
