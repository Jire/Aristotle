package aristotle.events.conversations;

import aristotle.Conversation;

public class ConversationSendMessageEvent extends ConversationEvent {

	private final String message;

	public ConversationSendMessageEvent(Conversation conversation, String message) {
		super(conversation);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}