package codes.biscuit.skyblockaddons.event.world;

import codes.biscuit.skyblockaddons.event.AbstractCancellableEvent;
import lombok.Getter;
import net.minecraft.util.BlockPos;

public class PlayerDamageBlockEvent extends AbstractCancellableEvent {
	@Getter private final BlockPos loc;
	
	public PlayerDamageBlockEvent(BlockPos loc) {
		this.loc = loc;
	}
	
}
