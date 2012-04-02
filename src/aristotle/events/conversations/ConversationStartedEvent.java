package aristotle.events.conversations;

import aristotle.Conversation;

public class ConversationStartedEvent extends ConversationEvent {

	public ConversationStartedEvent(Conversation conversation) {
		super(conversation);
	}

}