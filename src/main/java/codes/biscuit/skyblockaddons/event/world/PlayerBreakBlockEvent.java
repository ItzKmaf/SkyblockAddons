package codes.biscuit.skyblockaddons.event.world;

import codes.biscuit.skyblockaddons.event.AbstractCancellableEvent;
import lombok.Getter;
import net.minecraft.util.BlockPos;

public class PlayerBreakBlockEvent extends AbstractCancellableEvent {
	@Getter private final BlockPos loc;
	
	public PlayerBreakBlockEvent(BlockPos loc) {
		this.loc = loc;
	}
}
