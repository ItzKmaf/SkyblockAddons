package codes.biscuit.skyblockaddons.event.io;

import codes.biscuit.skyblockaddons.event.AbstractEvent;
import lombok.Getter;

public class ChatReceivedEvent extends AbstractEvent {
	@Getter final private String chatMessage;
	
	public ChatReceivedEvent(String chatMessage) {
		this.chatMessage = chatMessage;
	}
}
