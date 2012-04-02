package aristotle.events.conversations;

import aristotle.Conversation;

public class ConversationClosedEvent extends ConversationEvent {

	public ConversationClosedEvent(Conversation conversation) {
		super(conversation);
	}

}