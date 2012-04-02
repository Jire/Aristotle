package aristotle.events.conversations;

import aristotle.Conversation;

public class ConversationUserLeaveEvent extends ConversationEvent {

	private final String userEmail;

	public ConversationUserLeaveEvent(Conversation conversation, String userEmail) {
		super(conversation);
		this.userEmail = userEmail;
	}

	public String getUserEmail() {
		return userEmail;
	}

}