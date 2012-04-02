package aristotle.events.conversations;

import net.alkine.event.Event;
import aristotle.Conversation;

public abstract class ConversationEvent implements Event {

	private final Conversation conversation;

	public ConversationEvent(Conversation conversation) {
		this.conversation = conversation;
	}

	public Conversation getConversation() {
		return conversation;
	}

}