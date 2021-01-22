package codes.biscuit.skyblockaddons.gui.titles;

import codes.biscuit.skyblockaddons.core.Feature;
import codes.biscuit.skyblockaddons.core.Message;
import codes.biscuit.skyblockaddons.utils.ColorCode;

public class Title_MiningAbilityAvailable implements Title {
	@Override
	public String getTitle() {
		return Message.MESSAGE_MINING_ABILITY_AVAILABLE.getMessage();
	}
	
	@Override
	public String getSubTitle() {
		return null;
	}
	
	@Override
	public int getColor() {
		return ColorCode.GREEN.getRGB();
	}
	
	@Override
	public Feature getOwner() {
		return Feature.PICKAXE_ABILITY_COOLDOWN;
	}
	
	@Override
	public String getName() {
		return "MiningAbilityAvailable";
	}
}