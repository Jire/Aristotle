package aristotle.events.conversations;

import aristotle.Conversation;

public class ConversationMessageReceivedEvent extends ConversationEvent {

	private final String message, sender;

	public ConversationMessageReceivedEvent(Conversation conversation, String message, String sender) {
		super(conversation);
		this.message = message;
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public String getSender() {
		return sender;
	}

}