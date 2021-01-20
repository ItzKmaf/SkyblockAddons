package codes.biscuit.skyblockaddons.gui.titles;

import codes.biscuit.skyblockaddons.core.Feature;
import codes.biscuit.skyblockaddons.core.Message;
import codes.biscuit.skyblockaddons.utils.ColorCode;
import lombok.Setter;

public class FewArrowsLeftAlert implements Title {
	
	@Setter private String arrowsRemaining;
	
	@Override
	public String getTitle() {
		return null;
	}
	
	@Override
	public String getSubTitle() {
		return Message.MESSAGE_ONLY_FEW_ARROWS_LEFT.getMessage(arrowsRemaining);
	}
	
	@Override
	public int getColor() {
		return ColorCode.RED.getRGB();
	}
	
	@Override
	public Feature getOwner() {
		return Feature.NO_ARROWS_LEFT_ALERT;
	}
	
	@Override
	public String getName() {
		return "NoArrowsLeftAlert";
	}
	
	
}
